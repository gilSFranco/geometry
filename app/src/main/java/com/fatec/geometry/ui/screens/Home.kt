package com.fatec.geometry.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatec.geometry.data.model.Shape
import com.fatec.geometry.ui.components.Container
import com.fatec.geometry.ui.components.ShapeCard
import com.fatec.geometry.ui.theme.Black
import com.fatec.geometry.ui.theme.White
import kotlin.math.pow

@Composable
fun Home(
    navigationController: NavController
) {
    var shape: Shape? by remember {
        mutableStateOf(null)
    }

    var calculateSquare: String by remember {
        mutableStateOf("")
    }

    var result: Double? by remember {
        mutableStateOf(null)
    }

    Container {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement= Arrangement.SpaceBetween
        ) {
            ShapeCard(
                text = "Square",
                onClick = {
                    shape = Shape.SQUARE
                }
            )

            ShapeCard(
                text = "Triangle",
                onClick = {
                    shape = Shape.TRIANGLE
                }
            )

            ShapeCard(
                text = "Circle",
                onClick = {
                    shape = Shape.CIRCLE
                }
            )
        }

        when (shape) {
            Shape.SQUARE -> {
                OutlinedTextField(
                    value = calculateSquare,
                    onValueChange = {
                        calculateSquare = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Side"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Type side here"
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),

                )
            }

            Shape.TRIANGLE -> {

            }

            Shape.CIRCLE -> {

            }

            else -> {
                Text(
                    text = "Select a shape to calculate the area",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        result?.let {
            Text(
                text = result.toString()
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                when (shape) {
                    Shape.SQUARE -> result = calculateSquare.toDouble().pow(2.0)
                    Shape.TRIANGLE -> TODO()
                    Shape.CIRCLE -> TODO()
                    else -> Unit
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Black,
                contentColor = White
            )
        ) {
            Text(
                text = "Calcular",
                modifier = Modifier
                    .padding(vertical = 5.dp)
            )
        }
    }
}