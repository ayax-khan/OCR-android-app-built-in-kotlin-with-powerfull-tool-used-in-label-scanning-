package com.buy2enjoy.feature_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus

@Composable
fun ListScreen(onBack: () -> Unit, onOpenDetail: (Long) -> Unit, vm: ListViewModel = hiltViewModel()) {
    val items = vm.items.collectAsLazyPagingItems()
    var search by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var statusExpanded by remember { mutableStateOf(false) }
    var statusSel by remember { mutableStateOf<ReturnStatus?>(null) }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Scanned Items") })
    }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            Column(Modifier.fillMaxWidth().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it; vm.setQuery(it) },
                    label = { Text("Search") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = month,
                        onValueChange = { month = it; vm.setMonth(it.ifBlank { null }) },
                        label = { Text("Month (yyyy-MM)") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                    ExposedDropdownMenuBox(expanded = statusExpanded, onExpandedChange = { statusExpanded = it }) {
                        OutlinedTextField(
                            readOnly = true,
                            value = statusSel?.name ?: "All Status",
                            onValueChange = {},
                            label = { Text("Status") },
                            modifier = Modifier.menuAnchor().weight(1f)
                        )
                        ExposedDropdownMenu(expanded = statusExpanded, onDismissRequest = { statusExpanded = false }) {
                            DropdownMenuItem(text = { Text("All Status") }, onClick = { statusSel = null; vm.setStatus(null); statusExpanded = false })
                            ReturnStatus.values().forEach { s ->
                                DropdownMenuItem(text = { Text(s.name) }, onClick = { statusSel = s; vm.setStatus(s); statusExpanded = false })
                            }
                        }
                    }
                }
            }
            Divider()
            val context = LocalContext.current
            LazyColumn(Modifier.fillMaxSize()) {
                items(items) { item -> if (item != null) ItemRow(item, onOpenDetail = { onOpenDetail(item.id) }, onOpenSeller = { SellerCenter.openOrdersPage(context) }, onCopy = { copyToClipboard(context, item.trackingNumber) }) }
            }
        }
    }
}

@Composable
private fun ItemRow(
    item: ReturnItem,
    onOpenDetail: () -> Unit,
    onOpenSeller: () -> Unit,
    onCopy: () -> Unit
) {
    var menu by remember { mutableStateOf(false) }
    ListItem(
        headlineContent = { Text(item.trackingNumber) },
        supportingContent = {
            Text(listOfNotNull(item.orderNumber, item.createdDate).joinToString(" • "))
        },
        trailingContent = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(item.status.name)
                DropdownMenu(expanded = menu, onDismissRequest = { menu = false }) {
                    DropdownMenuItem(text = { Text("Open in Seller Center") }, onClick = { menu = false; onOpenSeller() })
                    DropdownMenuItem(text = { Text("Copy Tracking Number") }, onClick = { menu = false; onCopy() })
                    DropdownMenuItem(text = { Text("Open Detail") }, onClick = { menu = false; onOpenDetail() })
                }
                TextButton(onClick = { menu = true }) { Text("More") }
            }
        },
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        onClick = onOpenDetail
    )
    Divider()
}
