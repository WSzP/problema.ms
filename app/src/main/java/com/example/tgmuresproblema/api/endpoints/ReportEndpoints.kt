package com.example.tgmuresproblema.api.endpoints

import com.example.tgmuresproblema.api.model.CreateRequestModel
import com.example.tgmuresproblema.api.model.CreateResponseModel
import com.example.tgmuresproblema.api.model.PersonalDetailRequestModel
import com.example.tgmuresproblema.api.model.PersonalDetailResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */

interface ReportEndpoints {

    @POST("raport/create.php")
    fun reportIssue(@Body createRequestModel: CreateRequestModel): Call<CreateResponseModel>

    @POST("raport/update.php")
    fun uploadPersonalData(@Body requestModel: PersonalDetailRequestModel): Call<PersonalDetailResponseModel>

}