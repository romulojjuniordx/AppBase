package dextra.android.appbase.features.home.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dextra.android.appbase.features.home.model.MainModel

class MainViewModel
    constructor(
            private val mainModel: MainModel = MainModel(),
            private var namesLiveData: MutableLiveData<List<String>> = MutableLiveData()
    ) : ViewModel() {

    fun loadNames() : MutableLiveData<List<String>>? {
        val isEmpty = namesLiveData.value?.isEmpty() ?: true
        if (isEmpty) {
            namesLiveData.value = mainModel.fetchNames()
        }
        return namesLiveData
    }
}