package dextra.android.appbase.base

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<out VM : ViewModel> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        loadUI()
        loadCallbacks()
        loadObservers()
    }
    protected abstract fun loadUI()
    protected abstract fun loadCallbacks()
    protected abstract fun loadObservers()
    protected abstract fun viewModel() : VM?
    protected abstract fun getLayoutId() : Int
}