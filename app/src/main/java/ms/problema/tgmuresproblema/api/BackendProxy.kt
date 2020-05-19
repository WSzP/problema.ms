package ms.problema.tgmuresproblema.api

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */

interface BackendProxy{

    fun putQuestion(question:String):String

    fun putPersonalData(id:String, name: String, phone:String, email:String):Boolean

}