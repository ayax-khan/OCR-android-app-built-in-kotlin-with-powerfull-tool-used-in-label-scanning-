package com.buy2enjoy.returnscanner.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buy2enjoy.returnscanner.ui.Routes

@Composable
fun DashboardScreen(onNavigate: (String) -> Unit, vm: DashboardViewModel = androidx.hilt.navigation.compose.hiltViewModel()) {
    val stats = vm.stats.collectAsState().value
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Returns Scanner", style = MaterialTheme.typography.headlineSmall)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            StatCard("Scanned", stats.totalScanned.toString())
            StatCard("Verified", stats.verified.toString())
            StatCard("Pending", stats.pending.toString())
        }
        Text("Scanned this month: ${stats.scannedThisMonth}")
        Spacer(Modifier.height(8.dp))
        Button(onClick = { onNavigate(Routes.SCAN) }, modifier = Modifier.fillMaxWidth()) { Text("Start Scanning") }
        OutlinedButton(onClick = { onNavigate(Routes.LIST) }, modifier = Modifier.fillMaxWidth()) { Text("View Scanned Items") }
        OutlinedButton(onClick = { onNavigate(Routes.EXPORT) }, modifier = Modifier.fillMaxWidth()) { Text("Export Data") }
    }
}

@Composable
private fun StatCard(title: String, value: String) {
    ElevatedCard(modifier = Modifier.weight(1f)) {
        Column(Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title, style = MaterialTheme.typography.labelLarge)
            Text(value, style = MaterialTheme.typography.headlineSmall)
        }
    }
}
