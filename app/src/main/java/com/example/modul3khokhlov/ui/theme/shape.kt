package com.example.modul3khokhlov.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val CustomShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp,
        bottomEnd = 16.dp
    ),
    large = RoundedCornerShape(50.dp)
)