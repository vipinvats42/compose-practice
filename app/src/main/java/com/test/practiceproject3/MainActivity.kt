package com.test.practiceproject3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//val nameList : ArrayList<String> = arrayListOf("John","Mickel","Andrew","Danna","Georgia")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val newNameStateContent = remember {
        mutableStateOf("")
    }
    val greetingListState = remember { mutableStateListOf<String>("john", "amanda") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(greetingListState, { greetingListState.add(newNameStateContent.value) }, newNameStateContent.value,
            { newName -> newNameStateContent.value = newName })
    }

}

@Composable
fun GreetingList(
    namesList: List<String>, buttonClick: () -> Unit,
    textFielsValue: String, textFieldUpdate: (newName: String) -> Unit
) {
    for (name in namesList) {
        Greeting(name = name)
    }


    TextField(value = textFielsValue, onValueChange = textFieldUpdate)

    Button(onClick = buttonClick) {
        Text(text = "add new name")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen()
}