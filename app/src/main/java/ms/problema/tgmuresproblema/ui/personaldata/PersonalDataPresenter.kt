package ms.problema.tgmuresproblema.ui.personaldata

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
class PersonalDataPresenter(view: PersonalDataContract.View) : PersonalDataContract.Presenter(view),
    KoinComponent {

    val backendService: ms.problema.tgmuresproblema.api.BackendService by inject()

    override fun sendPersonalData(
        check: Boolean,
        name: String,
        phone: String,
        email: String
    ) {
        ms.problema.tgmuresproblema.data.persistence.SavedValues.username.put(name)
        ms.problema.tgmuresproblema.data.persistence.SavedValues.phone.put(phone)
        ms.problema.tgmuresproblema.data.persistence.SavedValues.email.put(email)

        if (phone.isEmpty() && email.isEmpty()) {
            view?.showTextFieldError()
            return
        }

        if (!check) {
            view?.showTextFieldError()
            return
        }

        backendService.putAdditionalData(
            ms.problema.tgmuresproblema.data.persistence.SavedValues.lastAddedId.getString(),
            name,
            phone,
            email
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<Boolean> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable?) {
                    compositeDisposable.add(d)
                }

                override fun onNext(id: Boolean?) {
                    view?.showNextFragment()
                }

                override fun onError(e: Throwable?) {
                }
            })
    }


}