package com.example.p5 // Sesuaikan dengan nama package proyek Anda

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.p5.R // Sesuaikan import R dengan package Anda

@Composable
fun FormatDataDiri(modifier: Modifier = Modifier) {
    // Variabel-variabel untuk mengingat nilai masukan dari keyboard (menggunakan 'by' agar lebih ringkas)
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    // Variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input Nama Lengkap
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNama = it }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Pilihan Jenis Kelamin (Radio Button)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    )
                    Text(item)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Input Alamat
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { Text("Alamat") },
            onValueChange = { textAlamat = it }
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)
            ),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        // Tombol Submit
        Button(
            modifier = Modifier.width(250.dp),
            enabled = textAlamat.isNotEmpty() && textNama.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
            }
        ) {
            Text(stringResource(R.string.submit))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)
            ),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        // ElevatedCard untuk Menampilkan Hasil
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .width(300.dp) // Cukup atur lebar dan biarkan tinggi menyesuaikan isi
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(text = "Nama : $nama", color = Color.White)
                Text(text = "Gender : $jenis", color = Color.White)
                Text(text = "Alamat : $alamat", color = Color.White)
            }
        }
    }
}