package ms.problema.tgmuresproblema.ui.intro

import ms.problema.tgmuresproblema.ui.base.mvp.BasePresenter
import ms.problema.tgmuresproblema.ui.base.mvp.BaseView

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

        abstract fun handleLanguageSelection(it: ms.problema.tgmuresproblema.data.AvailableLanguage)
        abstract fun showDataProtection()
        abstract fun showImpressum()

    }

}