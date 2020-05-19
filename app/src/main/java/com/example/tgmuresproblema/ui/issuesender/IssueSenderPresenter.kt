package com.example.tgmuresproblema.ui.issuesender

import android.opengl.Visibility
import android.view.View
import android.view.View.GONE
import com.example.tgmuresproblema.api.BackendService
import com.example.tgmuresproblema.data.persistence.SavedValues
import com.example.tgmuresproblema.data.translations.TranslationKey
import com.example.tgmuresproblema.data.translations.TranslationManager
import com.example.tgmuresproblema.ui.util.LoadingManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class IssueSenderPresenter(view: IssueSenderContract.View) : IssueSenderContract.Presenter(view),
    KoinComponent {

    val backendService: BackendService by inject()
    private val loadingManager: LoadingManager by inject()
    private val translationManager: TranslationManager by inject()

    override fun sendQuestion(question: String) {
        if (question.isEmpty() || question.length < 10) {
            loadingManager.setLoadingVisibility(GONE)
            view?.showError(translationManager.getTranslation(TranslationKey.KEY_FILL_ISSUE))
            return
        }

        backendService
            .putQuestionData(question)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<String> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable?) {
                    compositeDisposable.add(d)
                }

                override fun onNext(id: String?) {
                    SavedValues.lastAddedId.put(id ?: "")
                    view?.showNextFragment()
                }

                override fun onError(e: Throwable?) {
                    loadingManager.setLoadingVisibility(GONE)
                    view?.showError(translationManager.getTranslation(TranslationKey.KEY_GENERAL_ERROR))
                }
            })
    }


}