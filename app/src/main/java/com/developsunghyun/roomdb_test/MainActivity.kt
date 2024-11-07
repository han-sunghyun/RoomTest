package com.developsunghyun.roomdb_test

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.developsunghyun.roomdb_test.Model.Data.DBItem
import com.developsunghyun.roomdb_test.Model.Repository.DataBase
import com.developsunghyun.roomdb_test.ViewModel.DBManager
import com.developsunghyun.roomdb_test.ui.theme.RoomDB_TestTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val dbManager = DBManager(applicationContext)
            RoomDB_TestTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)

                    )

                    Button(

                        onClick = {
                            coroutineScope.launch {
                                dbManager.testInsert2()
                                val getDataList = dbManager.getDataList()
                                for (i in getDataList){
                                    Log.d("LOG", "${i.id} ${i.name} ${i.age}")
                                }
                            }
                        }
                    ) {
                        Text(text = "데이터 저장")
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomDB_TestTheme {
        Greeting("Android")
    }
}

fun test(){

}