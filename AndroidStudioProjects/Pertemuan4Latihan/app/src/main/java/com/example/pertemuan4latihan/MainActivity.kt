package com.example.pertemuan4latihan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan4latihan.ui.theme.Pertemuan4LatihanTheme
import com.example.pertemuan4latihan.ui.theme.Purple80
import com.example.pertemuan4latihan.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pertemuan4LatihanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormLogin(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormLogin(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val name = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val numberPhone = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val address = remember { mutableStateOf(TextFieldValue("")) }
    val isSaved = remember{ mutableStateOf(false) };

    // Warna tombol
    val simpanButtonColors = ButtonDefaults.buttonColors(
        containerColor = Purple80
    )
    val resetButtonColors = ButtonDefaults.buttonColors(
        containerColor = Purple40
    )


    Column(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        if(!isSaved.value) {
            Text(
                text = "Daftar Gyanakaya",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

        Text(text = "Nama Lengkap", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(
            value = name.value ?: TextFieldValue(""),
            onValueChange = {
                name.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(text = "Username", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(
            value = username.value ?: TextFieldValue(""),
            onValueChange = {
                username.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(text = "No. Telp", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(
            value = numberPhone.value,
            onValueChange = {
                numberPhone.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(text = "Email", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(text = "Alamat Rumah", modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(
            value = address.value,
            onValueChange = {
                address.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )


        // Spacer untuk memberikan jarak antar elemen
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
//                    Jika semua gak diisi
                    if (name.value.text.isEmpty() || username.value.text.isEmpty() || numberPhone.value.text.isEmpty() || email.value.text.isEmpty() || address.value.text.isEmpty()) {
                        Toast.makeText(context, "Mohon lengkapi formulir", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Selamat datang ${name.value.text}", Toast.LENGTH_SHORT).show()
                        isSaved.value = true
                    }
                },
                colors = simpanButtonColors
            ) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    // Action Reset
                    name.value = TextFieldValue("")
                    username.value = TextFieldValue("")
                    numberPhone.value = TextFieldValue("")
                    email.value = TextFieldValue("")
                    address.value = TextFieldValue("")
                    Toast.makeText(context, "Formulir telah di-reset", Toast.LENGTH_SHORT).show();
                    isSaved.value = false;
                },
                colors = resetButtonColors
            ) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        } else {
            Text(
                text = "Hai, ${name.value.text}",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

//            button logout
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    // Action Reset
                    name.value = TextFieldValue("")
                    username.value = TextFieldValue("")
                    numberPhone.value = TextFieldValue("")
                    email.value = TextFieldValue("")
                    address.value = TextFieldValue("")
                    Toast.makeText(context, "Formulir telah di-reset", Toast.LENGTH_SHORT).show();
                    isSaved.value = false;
                },
                colors = resetButtonColors
            ) {
                Text(
                    text = "Logout",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormLoginPreview() {
    Pertemuan4LatihanTheme {
        FormLogin()
    }
}
