package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun DigitalLemonade(modifier: Modifier = Modifier) {
    var image by remember { mutableStateOf(1) }
    val imageResource = when (image) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    var text by remember { mutableStateOf(1) }
    val textResource = when (text) {
        1 -> R.string.desc_lemon_tree
        2 -> R.string.desc_lemon
        3 -> R.string.desc_lemonade_glass
        4 -> R.string.desc_empty_glass
        else -> R.string.desc_lemon_tree
    }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lemonade",
            fontSize = 24.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(64.dp)
                .padding(top = 16.dp)

        )
        Spacer(modifier = Modifier.height(200.dp))
        Button(
            onClick = { image = if (image == 4) 1 else image + 1
                        text = if (text == 4) 1 else text + 1
                      },
            shape = FloatingActionButtonDefaults.shape,
        )
        {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Text(text = stringResource(textResource), fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeAppTheme {
        DigitalLemonade(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}