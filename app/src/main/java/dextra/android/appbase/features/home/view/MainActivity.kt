package dextra.android.appbase.features.home.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dextra.android.appbase.R
import dextra.android.appbase.base.BaseActivity
import dextra.android.appbase.features.home.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel()?.loadNames()?.observe(this, Observer<List<String>> { names ->
            names?.forEach(::println)
        })
    }

    override fun viewModel(): MainViewModel? {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
}
