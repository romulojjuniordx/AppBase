package dextra.android.appbase.features.home.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.widget.ArrayAdapter
import android.widget.Toast
import dextra.android.appbase.R
import dextra.android.appbase.base.BaseActivity
import dextra.android.appbase.features.home.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity<HomeViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUI()
        loadObservers()
    }

    override fun loadUI() {
        searchViewSetup()
    }

    override fun loadObservers() {
        viewModel()?.postsLiveData?.observe(this, Observer<List<String>> { names ->
            updateListOfPosts(names)
        })
    }

    override fun loadCallbacks() {
        viewModel()?.uiMessageCallback = { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        viewModel()?.handleErrorCallback = { error ->
            if (error is String) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun viewModel(): HomeViewModel? {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private fun searchViewSetup() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override
            fun onQueryTextSubmit(query: String): Boolean {
                viewModel()?.searchPostsByHashTag(searchView.query.toString())
                return false
            }

            override
            fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    // TODO: Create a RecyclerView Adapter
    private fun updateListOfPosts(posts: List<String>?) {
        val layoutId = android.R.layout.simple_list_item_1
        hashTagsView.adapter = ArrayAdapter<String>(this, layoutId, posts)
    }
}
