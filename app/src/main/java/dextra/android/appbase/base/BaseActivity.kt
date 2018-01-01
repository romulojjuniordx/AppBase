package dextra.android.appbase.base

import android.arch.lifecycle.ViewModel
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<out VM : ViewModel> : AppCompatActivity() {
    protected abstract fun loadUI()
    protected abstract fun loadObservers()
    protected abstract fun viewModel() : VM?
}