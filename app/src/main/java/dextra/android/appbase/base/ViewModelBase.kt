package dextra.android.appbase.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

open class ViewModelBase
    constructor(
            var uiErrorLiveDate: MutableLiveData<GenericError> = MutableLiveData()
    ) : ViewModel() {

}