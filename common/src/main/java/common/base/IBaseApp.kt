package common.base

import android.app.Application

interface IBaseApp {

    fun onCreate(app : Application)

    fun onTerminate()

}