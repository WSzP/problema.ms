package com.example.tgmuresproblema.koin

import com.example.tgmuresproblema.api.BackendProxy
import com.example.tgmuresproblema.api.BackendProxyImplementation
import com.example.tgmuresproblema.api.BackendService
import com.example.tgmuresproblema.api.RetrofitAdapter
import com.example.tgmuresproblema.data.persistence.SharedPrefManager
import com.example.tgmuresproblema.data.startup.StartupFlow
import com.example.tgmuresproblema.data.translations.TranslationManager
import com.example.tgmuresproblema.data.util.FileReader
import com.example.tgmuresproblema.ui.intro.IntroContract
import com.example.tgmuresproblema.ui.intro.IntroPresenter
import com.example.tgmuresproblema.ui.issuesender.IssueSenderContract
import com.example.tgmuresproblema.ui.issuesender.IssueSenderPresenter
import com.example.tgmuresproblema.ui.main.MainContract
import com.example.tgmuresproblema.ui.main.MainPresenter
import com.example.tgmuresproblema.ui.personaldata.PersonalDataContract
import com.example.tgmuresproblema.ui.personaldata.PersonalDataPresenter
import com.example.tgmuresproblema.ui.util.AlertDialogUtil
import com.example.tgmuresproblema.ui.util.LoadingManager
import com.example.tgmuresproblema.ui.util.WebOpenerUtil
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

    single { StartupFlow(androidContext()) }
    single { TranslationManager() }
    single { FileReader(androidContext()) }
    single { SharedPrefManager(androidContext()) }

}

val apiModule = module {

    single { BackendProxyImplementation() as BackendProxy }
    single { BackendService() }
    single { RetrofitAdapter() }

}