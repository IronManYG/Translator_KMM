package com.ironmanyg.translator.di

import com.ironmanyg.translator.database.TranslateDatabase
import com.ironmanyg.translator.translate.data.history.SqlDelightHistoryDataSource
import com.ironmanyg.translator.translate.data.local.DatabaseDriverFactory
import com.ironmanyg.translator.translate.data.remote.HttpClientFactory
import com.ironmanyg.translator.translate.data.translate.KtorTranslateClient
import com.ironmanyg.translator.translate.domain.history.HistoryDataSource
import com.ironmanyg.translator.translate.domain.translate.Translate
import com.ironmanyg.translator.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(translateClient, historyDataSource)
    }
}