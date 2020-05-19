package ms.problema.tgmuresproblema.ui.intro

import ms.problema.tgmuresproblema.ui.util.WebOpenerUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class IntroPresenter(view: IntroContract.View) : IntroContract.Presenter(view), KoinComponent {

    private val translationManager: ms.problema.tgmuresproblema.data.translations.TranslationManager by inject()
    val webOpenerUtil: WebOpenerUtil by inject()

    override fun handleLanguageSelection(it: ms.problema.tgmuresproblema.data.AvailableLanguage) {
        translationManager.loadTranslationsToMemory(it.languageKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<Boolean> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: Boolean?) {
                    ms.problema.tgmuresproblema.data.persistence.SavedValues.firstStart.put(true)
                    ms.problema.tgmuresproblema.data.persistence.SavedValues.language.put(it.languageKey)
                    translationManager.loadTranslationsToMemory(it.languageKey)
                    view?.showNextFragment()
                }

                override fun onError(e: Throwable?) {
                }
            })
    }

    override fun showDataProtection() {
        val language = when (Locale.getDefault().language) {
            "en", "ro", "hu" -> {
                Locale.getDefault().language
            }
            else -> {
                "en"
            }
        }
        webOpenerUtil.openWebUrl("https://problema.ms/privacy/$language")
    }

    override fun showImpressum() {
        webOpenerUtil.openWebUrl("https://problema.ms/impressum")
    }

}