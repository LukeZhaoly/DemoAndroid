package common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luke.common.R

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextMessage("牛")
            Submit()
        }
    }


    @Composable
    fun TextMessage(text : String = "hello world"){
        Text(text = text)
    }

    @Composable
    fun Submit(){
       Button(onClick = {
           Log.d(TAG, "Submit: onClick")
           Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()
       }) {
           Icon(Icons.Filled.Favorite, contentDescription = null,modifier = Modifier.size(
               ButtonDefaults.IconSize))
            Text(text = " 确认")
       }
    }


}