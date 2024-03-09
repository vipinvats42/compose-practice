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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.practiceproject3.viewmodel.MainViewModel

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
fun HomeScreen(viewModel: MainViewModel = MainViewModel()) {
    val newNameStateContent = viewModel.textFieldState.observeAsState("")
//    val greetingListState = remember { mutableStateListOf<String>("john", "amanda") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingMessage(/*greetingListState, { greetingListState.add(newNameStateContent.value) },*/
            newNameStateContent.value,
            { newName -> viewModel.onTextChanged(newName) })
    }

}

@Composable
fun GreetingMessage(
    /*namesList: List<String>, buttonClick: () -> Unit,*/
    textFielsValue: String, textFieldUpdate: (newName: String) -> Unit
) {
    /* for (name in namesList) {
         Greeting(name = name)
     }*/


    TextField(value = textFielsValue, onValueChange = textFieldUpdate)

    Button(onClick = {}) {
        Text(text = textFielsValue)
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