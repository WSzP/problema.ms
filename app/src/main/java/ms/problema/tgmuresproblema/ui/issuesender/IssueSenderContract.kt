package ms.problema.tgmuresproblema.ui.issuesender

import ms.problema.tgmuresproblema.ui.base.mvp.BasePresenter
import ms.problema.tgmuresproblema.ui.base.mvp.BaseView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class IssueSenderContract {

    interface View : BaseView {
        fun showNextFragment()
        fun showError(error:String)

    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {

        abstract fun sendQuestion(question: String)

    }

}