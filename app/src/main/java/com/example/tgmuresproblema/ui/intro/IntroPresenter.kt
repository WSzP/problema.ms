package com.example.tgmuresproblema.ui.intro

import com.example.tgmuresproblema.data.AvailableLanguage
import com.example.tgmuresproblema.data.persistence.SavedValues
import com.example.tgmuresproblema.data.translations.TranslationManager
import com.example.tgmuresproblema.ui.util.WebOpenerUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.android.ext.android.inject
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

    private val translationManager: TranslationManager by inject()
    val webOpenerUtil: WebOpenerUtil by inject()

    override fun handleLanguageSelection(it: AvailableLanguage) {
        translationManager.loadTranslationsToMemory(it.languageKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<Boolean> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: Boolean?) {
                    SavedValues.language.put(it.languageKey)
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