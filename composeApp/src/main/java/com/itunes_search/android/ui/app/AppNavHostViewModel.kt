package com.itunes_search.android.ui.app

import androidx.lifecycle.ViewModel
import com.itunes_search.domain.ContentModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AppNavHostViewModel @Inject constructor(): ViewModel() {

    private val _selectedContentModel = MutableStateFlow<ContentModel?>(null)
    val selectedContent = _selectedContentModel.asStateFlow()

    fun setContent(content: ContentModel) {
        _selectedContentModel.update { content }
    }
}