package com.fatec.geometry.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fatec.geometry.ui.theme.Black
import com.fatec.geometry.ui.theme.White

@Composable
fun ShapeCard(
    text: String,
    onClick: () -> Unit
) {
    Card (
        modifier = Modifier
            .width(110.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = Black,
            contentColor = White
        )
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp)
        )
    }
}