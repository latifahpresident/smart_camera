package com.latifah.machinelearningwithmlkitandobjectrecognition.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageLabelingViewModel : ViewModel() {
    private val _label = MutableLiveData<String>() //mutable but can't be accessed out of this class
    val label : LiveData<String> = _label

    private val _confidence = MutableLiveData<String>()
    val confidence : LiveData<String> = _confidence //immutable but can be accessed outside the class. This is to make sure the data can be accessed but not changed



}