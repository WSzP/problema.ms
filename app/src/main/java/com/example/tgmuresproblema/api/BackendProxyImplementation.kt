package com.example.tgmuresproblema.api

import com.example.tgmuresproblema.api.model.CreateRequestModel
import com.example.tgmuresproblema.api.model.PersonalDetailRequestModel
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
class BackendProxyImplementation : BackendProxy, KoinComponent {

    private val retrofitAdapter: RetrofitAdapter by inject()

    override fun putQuestion(question: String): String {
        val requestModel = CreateRequestModel(question)

        val execute = retrofitAdapter.adapter.reportIssue(requestModel).execute()

        if (execute.body() == null || !execute.isSuccessful) {
            throw Exception("Report is not successfull")
        }

        return execute.body()?.lastId ?: ""
    }

    override fun putPersonalData(id: String, name: String, phone: String, email: String): Boolean {
        val requestModel = PersonalDetailRequestModel(id,name, phone, email)

        val execute = retrofitAdapter.adapter.uploadPersonalData(requestModel).execute()

        if (execute.body() == null || !execute.isSuccessful) {
            throw Exception("Report is not successfull")
        }

        return true
    }
}