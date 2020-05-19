package com.example.tgmuresproblema.ui.intro

import com.example.tgmuresproblema.data.AvailableLanguage
import com.example.tgmuresproblema.ui.base.mvp.BasePresenter
import com.example.tgmuresproblema.ui.base.mvp.BaseView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class IntroContract {

    interface View : BaseView {

        fun showNextFragment()

    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {

        abstract fun handleLanguageSelection(it: AvailableLanguage)
        abstract fun showDataProtection()
        abstract fun showImpressum()

    }

}