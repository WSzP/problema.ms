package com.example.tgmuresproblema.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.example.tgmuresproblema.ui.base.mvp.BasePresenter
import com.example.tgmuresproblema.ui.base.mvp.BaseView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */

abstract class BaseActivity<T : BasePresenter<*>> : AppCompatActivity(), BaseView {

    protected abstract val presenter: T?

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetachView()
    }


}
