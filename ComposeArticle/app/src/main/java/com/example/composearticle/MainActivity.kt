package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface (
                    // Frame takes all space available
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        heading = stringResource(R.string.heading),
                        summary = stringResource(R.string.summary),
                        body = stringResource(R.string.body),
                        modifier = Modifier.border(4.dp,Color.Blue).padding(5.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun Article(
    heading: String,
    summary: String,
    body:String,
    modifier: Modifier = Modifier,
    ) {
    val image = painterResource(R.drawable.bg_compose_background)
    // by passing only variable, compiler will select first parameter from Implementation
    // here for Colum its modifier : Modifier = Modifier <- This is best practice
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            // Scale image width wise to available space and scale horizontally to maintain aspect ratio
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            heading,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            summary,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp))
        Text(
            body,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article(
            heading = stringResource(R.string.heading),
            summary = stringResource(R.string.summary),
            body = stringResource(R.string.body),
            modifier = Modifier.border(4.dp,Color.Blue),
        )
    }
}