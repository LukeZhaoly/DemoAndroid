package home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.home.R
import home.base.BaseVmActivity

class HomeActivity : BaseVmActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}