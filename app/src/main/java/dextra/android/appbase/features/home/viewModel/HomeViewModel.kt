package dextra.android.appbase.features.home.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dextra.android.appbase.features.home.model.HomeModel

class HomeViewModel
    constructor(
            private val homeModel: HomeModel = HomeModel(),
            var postsLiveData: MutableLiveData<List<String>> = MutableLiveData()
    ) : ViewModel() {


    fun searchPostsByHashTag(hashTag: String) {
        val isEmpty = postsLiveData.value?.isEmpty() ?: true
        if (isEmpty) {
            postsLiveData.value = homeModel.fetchPostsByHashTag(hashTag)
        }
    }
}