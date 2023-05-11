package common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author luke.zhao
 * create :2023/5/11
 * description:
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWindowStyle()
        initView()
        initData()
    }

    protected open fun initData() {

    }

    protected open fun initView() {

    }

    // window属性设置
    protected open fun initWindowStyle() {

    }


    override fun onResume() {
        super.onResume()
        loadData()
    }

    protected open fun loadData() {
        // 数据加载
    }
}