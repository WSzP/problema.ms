package com.example.tgmuresproblema.data.startup.steps

import com.example.tgmuresproblema.data.persistence.SavedValues
import com.example.tgmuresproblema.data.translations.TranslationManager
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */

class TranslationLoadStep : Step, KoinComponent {

    private val translationManager: TranslationManager by inject()

    override fun execute(successListener: StepSuccessListener) {
        val savedLanguage = SavedValues.language.getString()

        val language = if (savedLanguage.isNotEmpty()) {
            savedLanguage
        } else {
            when (Locale.getDefault().language) {
                "en", "ro", "hu" -> {
                    Locale.getDefault().language
                }
                else -> {
                    "en"
                }
            }
        }
        translationManager.loadTranslationsToMemory(language)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                successListener.stepSuccessful()
            }
    }

}