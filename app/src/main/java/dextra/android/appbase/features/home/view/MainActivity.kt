package dextra.android.appbase.features.home

import android.os.Bundle
import dextra.android.appbase.R
import dextra.android.appbase.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
