package com.habib.jeenyassesment.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.habib.jeenyassesment.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MostViewedArticlesFragmentViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

}