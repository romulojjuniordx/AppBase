package dextra.android.appbase.features.home.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import dextra.android.appbase.R
import dextra.android.appbase.base.BaseActivity
import dextra.android.appbase.features.home.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_bar.setOnSearchClickListener {
            searchHashtag(search_bar.query.toString())
        }

        val searchResultLiveData = viewModel()?.getLiveData()
        searchResultLiveData?.observe(this, Observer<List<String>> { names ->
             hashTagsView.adapter =  ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names)
        })

        searchResultLiveData?.observe(this, Observer<List<String>> {
            Toast.makeText(this, "Search Finished!", Toast.LENGTH_LONG).show()
        })
    }

    fun searchHashtag(text : String) {
        viewModel()?.searchHashTags(text)
    }

    override fun viewModel(): MainViewModel? {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
}
