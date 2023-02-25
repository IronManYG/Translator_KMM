package com.ironmanyg.translator.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironmanyg.translator.translate.domain.history.HistoryDataSource
import com.ironmanyg.translator.translate.domain.translate.Translate
import com.ironmanyg.translator.translate.presentation.TranslateEvent
import com.ironmanyg.translator.translate.presentation.TranslateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
): ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translate = translate,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}