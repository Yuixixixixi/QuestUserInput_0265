package com.example.p5

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FormatDataDiri(modifier: Modifier = Modifier) {
    // Skeletons
}
@Composable
fun FormatDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
}
Column(
modifier = modifier.padding(top = 50.dp),
verticalArrangement = Arrangement.Top,
horizontalAlignment = Alignment.CenterHorizontally
) {
    OutlinedTextField(
        value = textNama,
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.width(250.dp),
        label = { Text(text = "Nama Lengkap") },
        onValueChange = { textNama = it }
    )
}