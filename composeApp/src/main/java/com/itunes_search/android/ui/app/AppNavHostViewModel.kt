package com.itunes_search.android.ui.app

import androidx.lifecycle.ViewModel
import com.itunes_search.domain.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AppNavHostViewModel @Inject constructor(): ViewModel() {

    private val _selectedContent = MutableStateFlow<Content?>(null)
    val selectedContent = _selectedContent.asStateFlow()

    fun setContent(content: Content) {
        _selectedContent.update { content }
    }
}