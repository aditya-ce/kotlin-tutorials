package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.ui.theme.QuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quote(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val quotes = listOf(
    QuoteData(
        quoteText = "You have power over your mind — not outside events. Realize this, and you will find strength.",
        authorName = "Marcus Aurelius",
        authorImage = R.drawable.marcus,
        quoteTheme = QuoteTheme.WISDOM
    ),
    QuoteData(
        quoteText = "The happiness of your life depends upon the quality of your thoughts.",
        authorName = "Marcus Aurelius",
        authorImage = R.drawable.marcus,
        quoteTheme = QuoteTheme.LIFE
    ),
    QuoteData(
        quoteText = "You have the right to work, but never to the fruit of work.",
        authorName = "Krishna",
        authorImage = R.drawable.krishna,
        quoteTheme = QuoteTheme.GROWTH
    ),
    QuoteData(
        quoteText = "Knowing yourself is the beginning of all wisdom.",
        authorName = "Aristotle",
        authorImage = R.drawable.aristotle,
        quoteTheme = QuoteTheme.WISDOM
    ),
    QuoteData(
        quoteText = "We are what we repeatedly do. Excellence, then, is not an act, but a habit.",
        authorName = "Aristotle",
        authorImage = R.drawable.aristotle,
        quoteTheme = QuoteTheme.SUCCESS
    ),
    QuoteData(
        quoteText = "If I have seen further it is by standing on the shoulders of giants.",
        authorName = "Isaac Newton",
        authorImage = R.drawable.newton,
        quoteTheme = QuoteTheme.TECH
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quote(modifier: Modifier = Modifier) {
    var quoteNumber by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(Modifier.weight(1f))
        Image(
            painterResource(quotes[quoteNumber].authorImage),
            contentDescription = "Portrait of ${quotes[quoteNumber].authorName},",
            Modifier.size(300.dp)
            )
        Text(
            quotes[quoteNumber].authorName,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            modifier = modifier.padding(vertical = 4.dp)
        )
        Text(
            quotes[quoteNumber].quoteText,
            fontStyle = FontStyle.Italic,
        )
        Spacer(Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                quoteNumber = if(quoteNumber==0) quotes.lastIndex else quoteNumber-1
            }) {
                Text( "Previous")
            }
            Spacer(modifier = Modifier.size(25.dp))
            Button(onClick = {
                quoteNumber = if(quoteNumber==quotes.lastIndex) 0 else quoteNumber+1
            }) {
                Text("Next")
            }
        }
        Spacer(Modifier.size(72.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotesTheme {
        Quote()
    }
}

data class QuoteData(
    val quoteText: String,
    val authorName: String,
    @DrawableRes val authorImage: Int,
    val quoteTheme: QuoteTheme
)

enum class QuoteTheme {
    LIFE, SUCCESS, LOVE, TECH, WISDOM, COURAGE, GROWTH
}
