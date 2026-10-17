package com.daralkutub.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DarAlKutubApp()
        }
    }
}

@Composable
fun DarAlKutubApp() {
    var search by remember { mutableStateOf("") }
    val books = listOf(
        "تفسیر القرآن",
        "صحیح البخاری",
        "ہدایہ",
        "شرح نخبہ",
        "سراجی",
        "البلاغۃ الواضحۃ",
        "مختارات من أدب العرب"
    )

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF35251B))
                .padding(16.dp)
        ) {
            Text(
                text = "دار الكتب",
                fontSize = 32.sp,
                color = Color(0xFFE5C18A)
            )

            Text(
                text = "Digital Offline Library",
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text("کتاب تلاش کریں", color = Color.White) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "میری کتابیں",
                color = Color(0xFFE5C18A),
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(books.filter {
                    it.contains(search, ignoreCase = true)
                }) { book ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF79553A)
                        )
                    ) {
                        Text(
                            text = "📚  $book",
                            modifier = Modifier.padding(18.dp),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
