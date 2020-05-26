package ms.problema.tgmuresproblema.ui.personaldata

import ms.problema.tgmuresproblema.ui.base.mvp.BasePresenter
import ms.problema.tgmuresproblema.ui.base.mvp.BaseView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class PersonalDataContract {

    interface View : BaseView {
        fun showNextFragment()
        fun showTextFieldError()

    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun sendPersonalData(
            checked: Boolean,
            name: String,
            phone: String,
            email: String
        )

    }

}