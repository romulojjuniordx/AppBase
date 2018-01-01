package dextra.android.appbase.base

import android.arch.lifecycle.ViewModel

open class ViewModelBase : ViewModel() {
    lateinit var uiMessageCallback: (message: String) -> Unit
    lateinit var handleErrorCallback: (error: Any) -> Unit

}