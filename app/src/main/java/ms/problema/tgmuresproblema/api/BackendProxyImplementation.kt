package ms.problema.tgmuresproblema.api

import ms.problema.tgmuresproblema.data.persistence.SavedValues
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */
class BackendProxyImplementation : ms.problema.tgmuresproblema.api.BackendProxy, KoinComponent {

    private val retrofitAdapter: ms.problema.tgmuresproblema.api.RetrofitAdapter by inject()

    override fun putQuestion(question: String): String {
        val requestModel =
            ms.problema.tgmuresproblema.api.model.CreateRequestModel(
                question,
                SavedValues.language.getString()
            )

        val execute = retrofitAdapter.adapter.reportIssue(requestModel).execute()

        if (execute.body() == null || !execute.isSuccessful) {
            throw Exception("Report is not successfull")
        }

        return execute.body()?.lastId ?: ""
    }

    override fun putPersonalData(id: String, name: String, phone: String, email: String): Boolean {
        val requestModel =
            ms.problema.tgmuresproblema.api.model.PersonalDetailRequestModel(
                id,
                name,
                phone,
                email
            )

        val execute = retrofitAdapter.adapter.uploadPersonalData(requestModel).execute()

        if (execute.body() == null || !execute.isSuccessful) {
            throw Exception("Report is not successfull")
        }

        return true
    }
}