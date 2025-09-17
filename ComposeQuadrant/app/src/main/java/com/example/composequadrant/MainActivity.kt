package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier){
    Column (modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            ComposeInfo(
                name = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_composable_info),
                color = Color(0xFFEADDFF), Modifier.weight(1f)
            )
            ComposeInfo(
                name = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_composable_info),
                color = Color(0xFFD0BCFF), Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposeInfo(
                name = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_composable_info),
                color = Color(0xFFB69DF8), Modifier.weight(1f)
            )
            ComposeInfo(
                name = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_composable_info),
                color = Color(0xFFF6EDFF), Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun ComposeInfo(name: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier.background(color = color)
        .padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}