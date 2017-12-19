package dextra.android.appbase.application

import android.app.Application
import android.util.Log

class App : Application() {

    companion object {
        val TAG: String = App::class.simpleName.toString()
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate()")
    }
}