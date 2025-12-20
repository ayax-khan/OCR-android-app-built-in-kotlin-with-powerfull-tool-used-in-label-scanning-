package com.buy2enjoy.feature_export

import android.content.Intent
import android.net.Uri
import android.provider.DocumentsContract
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@Composable
fun ExportScreen(onBack: () -> Unit, vm: ExportViewModel = hiltViewModel()) {
    val context = LocalContext.current
    var month by remember { mutableStateOf(currentMonthYearPkt()) } // expected yyyy-MM
    val isExporting by vm.isExporting.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        vm.events.collect { e ->
            when (e) {
                is ExportViewModel.Event.Success -> snackbarHostState.showSnackbar("Exported ${e.count} rows")
                is ExportViewModel.Event.Error -> snackbarHostState.showSnackbar(e.message)
            }
        }
    }

    val createDocLauncher = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("text/csv")) { uri: Uri? ->
        if (uri != null) {
            vm.exportMonth(context.contentResolver, uri, month)
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Export") }) }, snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = month,
                onValueChange = { month = it },
                label = { Text("Month (yyyy-MM)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    if (month.matches(Regex("\\d{4}-\\d{2}"))) {
                        val filename = "Daraz_Returns_${month.replace("-", "_")}.csv"
                        createDocLauncher.launch(filename)
                    } else {
                        // Light validation
                        scope.launch { snackbarHostState.showSnackbar("Enter month as yyyy-MM") }
                    }
                },
                enabled = !isExporting,
                modifier = Modifier.fillMaxWidth()
            ) { Text(if (isExporting) "Exporting..." else "Export to CSV") }
        }
    }
}
