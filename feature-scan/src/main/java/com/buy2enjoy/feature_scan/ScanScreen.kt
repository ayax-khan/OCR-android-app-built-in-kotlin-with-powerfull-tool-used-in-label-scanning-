package com.buy2enjoy.feature_scan

import android.Manifest
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.camera.view.PreviewView
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.nativeKeyCode
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.buy2enjoy.core.camera.CameraXController
import com.buy2enjoy.core.ml.BarcodeScanner
import com.buy2enjoy.core.common.ScannerInputManager
import com.buy2enjoy.core.ml.TextRecognizer
import com.buy2enjoy.core.ml.pipeline.ScanPipeline
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScanScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current

    val cameraPermission = rememberPermissionState(Manifest.permission.CAMERA)
    var torchOn by remember { mutableStateOf(false) }
    var lastScan by remember { mutableStateOf("") }

    LaunchedEffect(Unit) { cameraPermission.launchPermissionRequest() }

    if (!cameraPermission.status.isGranted) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Camera permission required")
        }
        return
    }

    val previewView = remember { PreviewView(context) }

    // Hardware scanner input manager (keyboard wedge with ENTER suffix)
    val scannerManager = remember {
        ScannerInputManager(onScan = { code ->
            // Route to same pipeline as camera results
            vm.onBarcode(code)
        })
    }

    val focusRequester = remember { FocusRequester() }

    val vm: ScanViewModel = androidx.hilt.navigation.compose.hiltViewModel()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        vm.events.collect { e ->
            when (e) {
                is ScanViewModel.UiEvent.Inserted -> {
                    lastScan = e.tracking
                    if (vibrationOn) haptic(context)
                    snackbarHostState.showSnackbar("Saved: ${e.tracking}")
                }
                is ScanViewModel.UiEvent.Duplicate -> snackbarHostState.showSnackbar("Duplicate: ${e.tracking}")
                is ScanViewModel.UiEvent.Info -> snackbarHostState.showSnackbar(e.message)
            }
        }
    }

    var soundOn by remember { mutableStateOf(true) }
    var vibrationOn by remember { mutableStateOf(true) }
    var roiOn by remember { mutableStateOf(true) }

    val pipeline = remember(soundOn, roiOn) {
        ScanPipeline(BarcodeScanner(), TextRecognizer(), ocrDelayMs = 800, onResult = { result ->
            when (result) {
                is ScanPipeline.Result.BarcodeFound -> vm.onBarcode(result.trackingNumber)
                is ScanPipeline.Result.OcrExtracted -> vm.onOcr(result.trackingNumber, result.orderNumber, result.createdDateDisplay)
            }
        }, soundEnabled = soundOn, roiEnabled = roiOn)
    }

    val controller = remember {
        CameraXController(context, lifecycle, previewView) { image ->
            pipeline.analyze(image)
        }
    }

    DisposableEffect(Unit) {
        // Ensure focus to capture hardware scanner input
        try { focusRequester.requestFocus() } catch (_: Throwable) {}

        controller.start()
        onDispose { controller.stop() }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
        Box(
            Modifier
                .weight(1f)
                .onPreviewKeyEvent { event ->
                    if (event.type == KeyEventType.KeyUp) {
                        when (event.key) {
                            Key.Enter -> { scannerManager.onChar('\n', isEnter = true); true }
                            else -> {
                                val code = event.nativeKeyCode
                                val c = event.utfCharOrNull()
                                if (c != null) { scannerManager.onChar(c); true } else false
                            }
                        }
                    } else false
                }
                .focusRequester(focusRequester)
                .focusable()
        ) {
            AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
            // On-screen frame
            Box(
                Modifier
                    .align(Alignment.Center)
                    .size(260.dp)
                    .border(2.dp, Color(0x55FFFFFF))
            )
            if (lastScan.isNotBlank()) {
                Text(
                    text = "Last: $lastScan",
                    modifier = Modifier.align(Alignment.BottomCenter).padding(12.dp),
                    color = Color.White
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Back") }
            Button(onClick = {
                torchOn = !torchOn
                controller.setTorch(torchOn)
            }, modifier = Modifier.weight(1f)) {
                Text(if (torchOn) "Torch Off" else "Torch On")
            }
        }
        }
    }
}

private fun haptic(context: android.content.Context) {
    try {
        val v = context.getSystemService(Vibrator::class.java)
        v?.vibrate(VibrationEffect.createOneShot(40, VibrationEffect.DEFAULT_AMPLITUDE))
    } catch (_: Throwable) { }
}
