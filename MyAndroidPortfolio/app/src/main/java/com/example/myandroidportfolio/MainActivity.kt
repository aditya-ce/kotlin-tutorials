package com.example.myandroidportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidportfolio.ui.theme.MyAndroidPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAndroidPortfolioTheme {
                AboutPage()
            }
        }
    }
}

@Composable
fun AboutPage() {
    Surface(
        color = Color(0x223ddc84),
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            AboutSection()
            Spacer(modifier = Modifier.weight(1f))
            ContactSection()
        }
    }
}

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.DarkGray)
                .height(140.dp)
                .width(140.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 36.sp
        )
        Text(
            text = stringResource(R.string.job_title),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp),
            color = Color(
                color = 0xFF036d39
            )
        )
    }
}

@Composable
fun ContactSection() {
    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            Modifier
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            ContactRow(
                icon = Icons.Rounded.Phone,
                text = stringResource(R.string.contact_number)
            )
            ContactRow(
                icon = Icons.Rounded.Person,
                text = stringResource(R.string.website)
            )
            ContactRow(
                icon = Icons.Rounded.Email,
                text = stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(Modifier.padding(top = 8.dp, bottom = 4.dp)) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF036d39)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAndroidPortfolioTheme {
        AboutPage()
    }
}
