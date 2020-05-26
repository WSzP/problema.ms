package ms.problema.tgmuresproblema.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*
import ms.problema.tgmuresproblema.R
import ms.problema.tgmuresproblema.ui.base.BaseActivity
import ms.problema.tgmuresproblema.ui.util.LoadingManager
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View {

    override val presenter:
            MainContract.Presenter? by inject { parametersOf(this) }
    private val loadingManager: LoadingManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadingManager.initialise(loadingSpinner, blockingView)
        presenter?.doStartup()
    }

    override fun onStartupSuccessful(firstStart: Boolean) {
        val navGraph = if (!firstStart) {
            R.navigation.nav_graph
        } else {
            R.navigation.nav_graph_without_intro
        }
        val finalHost = NavHostFragment.create(navGraph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, finalHost)
            .setPrimaryNavigationFragment(finalHost)
            .commit()
        loadingManager.setLoadingVisibility(View.GONE)
    }

    override fun onStartupFailed() {

    }

}
