package ms.problema.tgmuresproblema.ui.base

import androidx.fragment.app.Fragment
import ms.problema.tgmuresproblema.ui.base.mvp.BasePresenter
import ms.problema.tgmuresproblema.ui.base.mvp.BaseView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */

abstract class BaseFragment<T : BasePresenter<*>> : Fragment(), BaseView {

    protected abstract val presenter: T?

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetachView()
    }

}
