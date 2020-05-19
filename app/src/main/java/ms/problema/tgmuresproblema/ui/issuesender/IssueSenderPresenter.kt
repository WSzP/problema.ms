package ms.problema.tgmuresproblema.ui.issuesender

import android.view.View.GONE
import ms.problema.tgmuresproblema.ui.util.LoadingManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
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

    val backendService: ms.problema.tgmuresproblema.api.BackendService by inject()
    private val loadingManager: LoadingManager by inject()
    private val translationManager: ms.problema.tgmuresproblema.data.translations.TranslationManager by inject()

    override fun sendQuestion(question: String) {
        if (question.isEmpty() || question.length < 10) {
            loadingManager.setLoadingVisibility(GONE)
            view?.showError(translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_FILL_ISSUE))
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
                    ms.problema.tgmuresproblema.data.persistence.SavedValues.lastAddedId.put(id ?: "")
                    view?.showNextFragment()
                }

                override fun onError(e: Throwable?) {
                    loadingManager.setLoadingVisibility(GONE)
                    view?.showError(translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_GENERAL_ERROR))
                }
            })
    }


}