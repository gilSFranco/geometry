package com.fatec.geometry.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import kotlin.math.PI
import kotlin.math.pow

@Composable
fun Home(
    navigationController: NavController
) {
    var shape: Shape? by remember {
        mutableStateOf(null)
    }

    var side: String by remember {
        mutableStateOf("")
    }

    var base: String by remember {
        mutableStateOf("")
    }

    var height: String by remember {
        mutableStateOf("")
    }

    var radius: String by remember {
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
                    value = side,
                    onValueChange = {
                        side = it
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
                    )
                )
            }

            Shape.TRIANGLE -> {
                Column (
                    verticalArrangement = Arrangement.spacedBy(
                        space = 40.dp
                    )
                ) {
                    OutlinedTextField(
                        value = base,
                        onValueChange = {
                            base = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = {
                            Text(
                                text = "Base"
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
                        )
                    )

                    OutlinedTextField(
                        value = height,
                        onValueChange = {
                            height = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = {
                            Text(
                                text = "Height"
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Type height here"
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }
            }

            Shape.CIRCLE -> {
                OutlinedTextField(
                    value = radius,
                    onValueChange = {
                        radius = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Height"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Type height here"
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
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

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = result?.let { result.toString() } ?: run { "Waiting to calculate..." }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                when (shape) {
                    Shape.SQUARE -> result = side.toDouble().pow(2.0)
                    Shape.TRIANGLE -> result = (base.toDouble() * height.toDouble()) / 2
                    Shape.CIRCLE -> result = PI * radius.toDouble().pow(2.0)
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