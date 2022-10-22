package com.example.lemonade

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp(){
    layoutOnePage(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun layoutOnePage(modifier: Modifier = Modifier){
    var step by remember { mutableStateOf(1) }
    val imageResource = when(step){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val decription = when(step){
        1 -> "A"
        2 -> "B"
        3 -> "C"
        else -> "D"
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = decription,
            fontSize = 16.sp
        )
        Image(
            painter = painterResource(imageResource),
            contentDescription = decription
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { if(step >= 4) step = 1 else step++ }) {
            if(step == 4) {
                Text(
                    text = "FINISH",
                    fontSize = 24.sp
                )
            }
            else{
                Text(
                    text = "NEXT",
                    fontSize = 24.sp
                )
            }
        }
    }
}
