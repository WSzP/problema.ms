package ms.problema.tgmuresproblema.ui.main

import ms.problema.tgmuresproblema.ui.base.mvp.BasePresenter
import ms.problema.tgmuresproblema.ui.base.mvp.BaseView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */

class MainContract {

    interface View : BaseView {

        fun onStartupSuccessful(firstStart : Boolean)

        fun onStartupFailed()

    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {

        abstract fun doStartup()

    }

}
