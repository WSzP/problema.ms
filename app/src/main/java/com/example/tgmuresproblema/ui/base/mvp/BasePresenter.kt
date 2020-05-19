package com.example.tgmuresproblema.ui.base.mvp

import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */

abstract class BasePresenter<T : BaseView>(var view: T?) {

    protected val compositeDisposable = CompositeDisposable()

    fun onDetachView() {
        view = null
        compositeDisposable.dispose()
    }

}
