package common.base

object AppManager {

    val mAppList = mutableListOf<IBaseApp>()

    @Synchronized
    fun registerApp(app : IBaseApp){
        if (!mAppList.contains(app)){
            mAppList.add(app)
        }
    }

    @Synchronized
    fun unRegisterApp(app: IBaseApp){
        mAppList.remove(app)
    }
}