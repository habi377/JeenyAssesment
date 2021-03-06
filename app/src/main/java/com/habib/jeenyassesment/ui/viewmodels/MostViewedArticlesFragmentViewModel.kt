package com.habib.jeenyassesment.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habib.jeenyassesment.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MostViewedArticlesFragmentViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    // update the UI from the db
    val mostViewed = repository.dataItem
    /**
     * Event triggered for network error message.
     */
    private var _eventNetworkErrorMsg = MutableLiveData<String>("")
    /**
     * Event triggered for network error message.
     */
    val eventNetworkErrorMsg: LiveData<String>
        get() = _eventNetworkErrorMsg

    /**
     * Event triggered for network error.
     */
    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    /**
     * Event triggered for network error. Views should use this to get access
     * to the data.
     */
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    /**
     * Flag to display the error message.
     */
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    /**
     * Flag to display the error message.
     */
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                repository.refreshMostViewed(1)
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false

            } catch (networkError: IOException) {
                // Show a Toast error message and hide the progress bar.
                if(mostViewed.value.isNullOrEmpty()){
                    _eventNetworkErrorMsg.value = networkError.message.toString()
                    _eventNetworkError.value = true
                }
            }
        }
    }

    /**
     * Resets the network error flag.
     */
    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

}