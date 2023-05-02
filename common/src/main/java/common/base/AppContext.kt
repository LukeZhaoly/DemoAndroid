package common.base

import android.content.Context

object AppContext {

    lateinit var appContext : Context
        private set

    fun init(appContext: Context){
        this.appContext = appContext
    }

}