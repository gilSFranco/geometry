package com.fatec.geometry.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Container(
    child: @Composable () -> Unit
) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = innerPadding.calculateTopPadding() + 30.dp,
                    bottom = 20.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            child()
        }
    }
}