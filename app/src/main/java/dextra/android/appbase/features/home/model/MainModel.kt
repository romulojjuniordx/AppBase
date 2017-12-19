package dextra.android.appbase.features.home.model

import android.util.Log

class MainModel {
    fun fetchNames(): List<String>? {
        Log.i("-->","Fake request!")        // TODO: async request
        return listOf("Name01", "Name02", "Name03")
    }
}