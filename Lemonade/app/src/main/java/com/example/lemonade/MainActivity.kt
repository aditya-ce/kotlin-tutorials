package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0x9Ffff44f),
                )
            )
        }
    ) {
            _ ->
        LemonadePage()
    }
}

@Composable
fun LemonadePage(
) {
    var screen by remember { mutableStateOf(1) }
    var tapsRequired by remember { mutableStateOf((2..4).random()) }
    var tapsCount by remember { mutableStateOf(0) }

    val (imageResource, imageDescription, instructions) = when (screen) {
        1 -> Triple(R.drawable.lemon_tree, R.string.lemon_tree_description, R.string.instruction1)
        2 -> Triple(R.drawable.lemon_squeeze, R.string.lemon_description, R.string.instruction2)
        3 -> Triple(R.drawable.lemon_drink, R.string.lemonade_glass_description, R.string.instruction3)
        else -> Triple(R.drawable.lemon_restart, R.string.empty_glass_description, R.string.instruction4)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button( onClick = {
            screen = when (screen){
                1 -> {
                    tapsRequired = (2..4).random()
                    screen + 1
                }
                2 -> {
                    if (tapsCount < tapsRequired) {
                        tapsCount += 1
                        screen
                    }
                    else {
                        tapsCount = 0
                        screen + 1
                    }
                }
                3 -> screen + 1
                else -> 1
            }
        },
            shape = RoundedCornerShape( 14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x42008080))
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(imageDescription)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(instructions), fontSize = 18.sp )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeScreen()
}
