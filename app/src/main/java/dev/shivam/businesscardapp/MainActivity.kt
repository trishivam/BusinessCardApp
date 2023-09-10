package dev.shivam.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.shivam.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {
                    BusinessCard(
                        iconImage = R.drawable.android_logo,
                        fullName = "Shivam Tripathi",
                        designation = "Software Engineer",
                        phoneNumber = "+91 7499229768",
                        twitterHandle = "@sanskar10100",
                        email = "trishivam64@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    iconImage: Int,
    fullName: String,
    designation: String,
    phoneNumber: String,
    twitterHandle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0xFF073042))
            ) {
                Image(
                    painter = painterResource(id = iconImage),
                    contentDescription = "Android Logo",
                    modifier = Modifier.size(128.dp)
                )
            }
            Text(
                text = fullName,
                style = MaterialTheme.typography.headlineLarge
            )
            Text(text = designation)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                ContactInfoRow(icon = Icons.Filled.Call, text = phoneNumber)
                ContactInfoRow(icon = Icons.Filled.Share, text = twitterHandle)
                ContactInfoRow(icon = Icons.Filled.Email, text = email)
            }
        }
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Call",
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoRowPreview() {
    BusinessCardAppTheme {
        ContactInfoRow(icon = Icons.Filled.Info, text = "Info")
    }
}