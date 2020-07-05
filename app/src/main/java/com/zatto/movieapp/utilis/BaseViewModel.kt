package com.zatto.movieapp.utilis

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



abstract class BaseViewModel : ViewModel() {

    val errorMessage: MutableLiveData<String> = MutableLiveData()

    val isLoading = ObservableField(true)
}
