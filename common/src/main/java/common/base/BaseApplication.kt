package common.base

import android.app.Application

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppContext.init(this)
        initModule(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        AppManager.mAppList.forEach {
            it.onTerminate()
        }
    }

    // 初始化模块
    private fun initModule(application: Application) {
        AppManager.mAppList.forEach {
            it.onCreate(application)
        }
    }
}