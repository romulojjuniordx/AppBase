package dextra.android.appbase.features.home.viewModel

import android.arch.lifecycle.MutableLiveData
import dextra.android.appbase.base.GenericError
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
                error != null -> uiErrorLiveDate.value = GenericError("Try again")
                result.isEmpty() -> uiErrorLiveDate.value = GenericError("No results", GenericError.Types.NO_RESULT)
                else -> {
                    postsLiveData.value = result
                }
            }
        }
    }
}