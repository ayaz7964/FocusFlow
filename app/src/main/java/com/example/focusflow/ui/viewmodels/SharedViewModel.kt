package com.example.focusflow.ui.viewmodels

//class SharedViewModel {
//}

//package com.focusflow.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selectedTaskId = MutableLiveData<Int>()
}