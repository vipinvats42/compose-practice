package com.test.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.jetpackcompose1.ui.theme.Jetpackcompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpackcompose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreetingText("Android")
                    //GreetingButton()
                }
            }
        }
    }
}


@Composable
fun GreetingText(name: String) {
    Text(
        text = "Hello $name!", modifier = Modifier
            .clickable(onClick = { })
            .padding(all = 20.dp)
            .width(200.dp)
            .height(240.dp),
       /* style = TextStyle(color = Color.Blue,
            fontWeight = FontWeight.Bold
        , fontSize = 18.sp*/
        style = MaterialTheme.typography.labelMedium,
        fontWeight = FontWeight.Bold

    )


}

@Composable
fun GreetingButton(){
Button(onClick = {  }) {
    GreetingText(name = "Button")
    //GreetingText(name = "Remaining Button")

}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpackcompose1Theme {
        GreetingText("Android")
        //GreetingButton()
    }
}