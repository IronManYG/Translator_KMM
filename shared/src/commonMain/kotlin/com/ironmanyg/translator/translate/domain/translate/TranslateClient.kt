package com.ironmanyg.translator.translate.domain.translate

import com.ironmanyg.translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}