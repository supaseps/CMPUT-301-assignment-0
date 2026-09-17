package com.example.myapplication

import android.hardware.camera2.CaptureFailure
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random



fun getNumber(): Int {
    val number = Random.nextInt(1,101)
    return number
}

@Composable
fun buttonList (
    onSuccess: () -> Unit,
    onFailure: () -> Unit,
    modifier: Modifier= Modifier
){
    Row (
        modifier= Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ){
    Button(
        onClick = {

            val number= getNumber()
            if (number <= 50) {
                onSuccess()
            }else{onFailure()}
        }
    ) {Text ("Lets go!")}

    Button(
        onClick = {

            val number= getNumber()
            if (number <=25){
                onSuccess()
            }else {onFailure()}
        }
    ){ Text ("Meh")}

    Button(
        onClick= {

            val number=getNumber()
            if (number <=10){
                onSuccess()
            }else{onFailure()}
        }
    ) {Text("Oh god please no")}}

}


@Composable
fun decisiondisplay(decision: Int){
    if (decision==1){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Yes!",
            modifier = Modifier.padding(top = 24.dp) // optional breathing room
        )
    }
} else
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No!",
                modifier = Modifier.padding(top = 24.dp) // optional breathing room
            )
        }
}

@Composable
fun clickerdisplay(clicker:Int){
    Box(
        modifier = Modifier.fillMaxWidth(),

        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Clicks $clicker",
            modifier = Modifier.padding(bottom = 24.dp) // optional breathing room
        )
    }
}





