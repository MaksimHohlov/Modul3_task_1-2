package com.example.modul3khokhlov
import com.example.modul3khokhlov.ui.theme.Modul3KhokhlovTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// задание 1
data class CardItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageResId: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modul3KhokhlovTheme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItemListScreen(
                        items = sampleItems,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val sampleItems = listOf(
    CardItem(1, "Заголовок 1", "Описание первого элемента.", R.drawable.yellow_android),
    CardItem(2, "Заголовок 2", "Описание второго элемента.", R.drawable.blue_android),
    CardItem(3, "Заголовок 3", "Описание третьего элемента.", R.drawable.red_android),
    CardItem(4, "Заголовок 4", "Описание четвертого элемента.", R.drawable.green_android),
    CardItem(5, "Заголовок 5", "Описание пятого элемента.", R.drawable.purple_android),
    CardItem(6, "Заголовок 6", "Описание шестого элемента.", R.drawable.blue_android),
    CardItem(7, "Заголовок 7", "Описание седьмого элемента.", R.drawable.red_android),
    CardItem(8, "Заголовок 8", "Описание восьмого элемента.", R.drawable.green_android),
    CardItem(9, "Заголовок 9", "Описание девятого элемента.", R.drawable.red_android)
)

@Composable
fun ItemListScreen(items: List<CardItem>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items, key = { it.id }) { item ->
            ItemCard(item = item)
        }
    }
}

@Composable
fun ItemCard(item: CardItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = "Изображение ${item.title}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.size(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}