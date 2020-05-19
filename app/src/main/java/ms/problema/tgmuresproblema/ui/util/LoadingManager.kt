package ms.problema.tgmuresproblema.ui.util

import android.view.View

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/19/2020
 *
 */
class LoadingManager {

    private var blockingView: View? = null
    private var loadingSpinner: View? = null

    fun initialise(loadingSpinner: View, blockingView: View){
        this.loadingSpinner = loadingSpinner
        this.blockingView = blockingView
    }

    fun setLoadingVisibility(visibility:Int){
        this.blockingView?.visibility=visibility
        this.loadingSpinner?.visibility=visibility
    }

}