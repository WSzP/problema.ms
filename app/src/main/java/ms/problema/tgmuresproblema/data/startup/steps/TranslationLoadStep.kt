package ms.problema.tgmuresproblema.data.startup.steps

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

class TranslationLoadStep : ms.problema.tgmuresproblema.data.startup.steps.Step, KoinComponent {

    private val translationManager: ms.problema.tgmuresproblema.data.translations.TranslationManager by inject()

    override fun execute(successListener: ms.problema.tgmuresproblema.data.startup.steps.StepSuccessListener) {
        val savedLanguage = ms.problema.tgmuresproblema.data.persistence.SavedValues.language.getString()

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