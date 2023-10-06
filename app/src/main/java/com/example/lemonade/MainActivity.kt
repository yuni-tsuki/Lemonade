package com.example.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun SignOfLemonade(){
    var lemonClick by remember { mutableStateOf(1) } //レモンを絞る回数を格納するための変数
    var counter by remember { mutableStateOf(0) } //四段階のどこに位置するかを数える変数

    when(counter) {
        0 -> Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.lemon_tree),
                contentDescription = stringResource(id = R.string.lemon_tree_description),
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        color = Color(0xFFc3ecd2),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable {
                        counter = 1
                        lemonClick = (2..4).random()
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.lemon_tree_text),
                fontSize = 18.sp
            )
        }

        1 -> Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                contentDescription = stringResource(id = R.string.lemon_description),
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        color = Color(0xFFc3ecd2),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable {
                        lemonClick--
                        if (lemonClick == 0) {
                            counter = 2
                        }
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.lemon_text),
                fontSize = 18.sp
            )
        }

        2 -> Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.lemon_drink),
                contentDescription = stringResource(id = R.string.lemonade_description),
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        color = Color(0xFFc3ecd2),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable { counter = 3 }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.lemonade_text),
                fontSize = 18.sp
            )
        }

        else -> Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.lemon_restart),
                contentDescription = stringResource(id = R.string.empty_glass_description),
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        color = Color(0xFFc3ecd2),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable { counter = 0 }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.empty_glass_text),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun LemonApp() {

    /*Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color(0xFFf9e44c)),
        //contentColor = MaterialTheme.colorScheme.onBackground
    ){
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxSize()
                //.padding(vertical = 16.dp)
                .height(100.dp)
        )*/


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color(0xFFf9e44c)),
            contentColor = MaterialTheme.colorScheme.onBackground
        ){
            Text(
                text = "Lemonade",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp)
            )
        }
        //Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SignOfLemonade()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonApp()
    }
}