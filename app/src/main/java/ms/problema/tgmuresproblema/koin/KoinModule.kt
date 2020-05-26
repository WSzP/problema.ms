package ms.problema.tgmuresproblema.koin

import ms.problema.tgmuresproblema.ui.intro.IntroContract
import ms.problema.tgmuresproblema.ui.intro.IntroPresenter
import ms.problema.tgmuresproblema.ui.issuesender.IssueSenderContract
import ms.problema.tgmuresproblema.ui.issuesender.IssueSenderPresenter
import ms.problema.tgmuresproblema.ui.main.MainContract
import ms.problema.tgmuresproblema.ui.main.MainPresenter
import ms.problema.tgmuresproblema.ui.personaldata.PersonalDataContract
import ms.problema.tgmuresproblema.ui.personaldata.PersonalDataPresenter
import ms.problema.tgmuresproblema.ui.util.AlertDialogUtil
import ms.problema.tgmuresproblema.ui.util.LoadingManager
import ms.problema.tgmuresproblema.ui.util.WebOpenerUtil
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */

val uiModule = module {

    factory { (view: MainContract.View) -> MainPresenter(view) as MainContract.Presenter }
    factory { (view: IntroContract.View) -> IntroPresenter(view) as IntroContract.Presenter }
    factory { (view: IssueSenderContract.View) -> IssueSenderPresenter(view) as IssueSenderContract.Presenter }
    factory { (view: PersonalDataContract.View) -> PersonalDataPresenter(view) as PersonalDataContract.Presenter }
    single { AlertDialogUtil() }
    single { WebOpenerUtil(androidContext()) }
    single { LoadingManager() }

}

val dataModule = module {

    single { ms.problema.tgmuresproblema.data.startup.StartupFlow(androidContext()) }
    single { ms.problema.tgmuresproblema.data.translations.TranslationManager() }
    single { ms.problema.tgmuresproblema.data.util.FileReader(androidContext()) }
    single {
        ms.problema.tgmuresproblema.data.persistence.SharedPrefManager(
            androidContext()
        )
    }

}

val apiModule = module {

    single { ms.problema.tgmuresproblema.api.BackendProxyImplementation() as ms.problema.tgmuresproblema.api.BackendProxy }
    single { ms.problema.tgmuresproblema.api.BackendService() }
    single { ms.problema.tgmuresproblema.api.RetrofitAdapter() }

}