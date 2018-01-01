package dextra.android.appbase.features.home.viewModel

import android.arch.lifecycle.MutableLiveData
import dextra.android.appbase.base.ViewModelBase
import dextra.android.appbase.features.home.model.HomeModel

class HomeViewModel
    constructor(
            private val homeModel: HomeModel = HomeModel(),
            var postsLiveData: MutableLiveData<List<String>> = MutableLiveData()
    ) : ViewModelBase() {

    fun searchPostsByHashTag(hashTag: String) {
        homeModel.fetchPostsByHashTag(hashTag) { error, result ->
            when {
                error != null -> handleErrorCallback("Request Error")
                result.isEmpty() -> uiMessageCallback("No results")
                else -> {
                    uiMessageCallback("Results")
                    postsLiveData.value = result
                }
            }
        }
    }
}