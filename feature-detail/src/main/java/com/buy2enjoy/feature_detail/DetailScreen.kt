package com.buy2enjoy.feature_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.buy2enjoy.domain.model.ReturnStatus

@Composable
fun DetailScreen(itemId: Long, onBack: () -> Unit, vm: DetailViewModel = hiltViewModel()) {
    val item = vm.item.collectAsState().value
    val isSaving = vm.isSaving.collectAsState().value
    val context = LocalContext.current

    Scaffold(topBar = {
        TopAppBar(title = { Text("Item Detail") })
    }) { padding ->
        if (item == null) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            var order by remember(item) { mutableStateOf(item.orderNumber ?: "") }
            var createdDate by remember(item) { mutableStateOf(item.createdDate ?: "") }
            var statusExpanded by remember { mutableStateOf(false) }
            var statusSel by remember(item) { mutableStateOf(item.status) }

            Column(Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = item.trackingNumber,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tracking Number") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = order,
                    onValueChange = { order = it; vm.updateFields(order, createdDate) },
                    label = { Text("Order Number") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = createdDate,
                    onValueChange = { createdDate = it; vm.updateFields(order, createdDate) },
                    label = { Text("Created Date (dd MMM yyyy)") },
                    modifier = Modifier.fillMaxWidth()
                )

                ExposedDropdownMenuBox(expanded = statusExpanded, onExpandedChange = { statusExpanded = it }) {
                    OutlinedTextField(
                        value = statusSel.name,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Status") },
                        modifier = Modifier.menuAnchor().fillMaxWidth()
                    )
                    ExposedDropdownMenu(expanded = statusExpanded, onDismissRequest = { statusExpanded = false }) {
                        ReturnStatus.values().forEach { s ->
                            DropdownMenuItem(text = { Text(s.name) }, onClick = {
                                statusSel = s
                                statusExpanded = false
                                vm.changeStatus(s)
                            })
                        }
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { vm.save() }, enabled = !isSaving) { Text(if (isSaving) "Saving..." else "Save") }
                    OutlinedButton(onClick = { onBack() }) { Text("Back") }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = { SellerCenter.openOrdersPage(context) }) { Text("Open in Seller Center") }
                    OutlinedButton(onClick = { copyToClipboard(context, item.trackingNumber) }) { Text("Copy Tracking") }
                }
            }
        }
    }
}
