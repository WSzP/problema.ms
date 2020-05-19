package ms.problema.tgmuresproblema.api.endpoints

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
    fun reportIssue(@Body createRequestModel: ms.problema.tgmuresproblema.api.model.CreateRequestModel): Call<ms.problema.tgmuresproblema.api.model.CreateResponseModel>

    @POST("raport/update.php")
    fun uploadPersonalData(@Body requestModel: ms.problema.tgmuresproblema.api.model.PersonalDetailRequestModel): Call<ms.problema.tgmuresproblema.api.model.PersonalDetailResponseModel>

}