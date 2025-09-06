package com.example.travelupa

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.example.travelupa.ui.theme.TravelupaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelupaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RekomendasiTempatScreen()
                }
            }
        }
    }
}

data class TempatWisata(val nama: String, val deskripsi: String, val gambar: Int)

val daftarTempatWisata = listOf(
    TempatWisata("Tumpak Sewu", "Air terjun tercantik di Jawa Timur.", R.drawable.tumpak_sewu),
    TempatWisata("Gunung Bromo", "Matahari terbitnya bagus banget.", R.drawable.gunung_bromo),
    TempatWisata("Pantai Klayar", "Pantai dengan air mancur alami yang menawan.", R.drawable.pantai_klayar),
    TempatWisata("Kawah Ijen", "Kawah dengan api biru yang spektakuler.", R.drawable.kawah_ijen)
)

@Composable
fun GreetingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Selamat Datang di Travelupa!",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Solusi buat kamu yang lupa kemana-mana",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Button(
            onClick = { /*TODO: Navigation to main screen*/ },
            modifier = Modifier
                .width(360.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Mulai")
        }
    }
}

@Composable
fun RekomendasiTempatScreen() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(daftarTempatWisata) { tempat ->
            TempatItem(tempat)
        }
    }
}

@Composable
fun TempatItem(tempat: TempatWisata) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = tempat.gambar),
                contentDescription = tempat.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = tempat.nama,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp, top = 12.dp),
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = tempat.deskripsi,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}