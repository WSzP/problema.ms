package ms.problema.tgmuresproblema.data.util

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.InputStream

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class FileReader(private val context: Context) {

    private fun readJSONFromAsset(fileName: String): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open("$fileName.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun getMapFromJsonString(fileName: String): Map<String, String>? {
        val listType = Types.newParameterizedType(List::class.java, ms.problema.tgmuresproblema.data.translations.TranslationData::class.java)
        val adapter: JsonAdapter<List<ms.problema.tgmuresproblema.data.translations.TranslationData>> = Moshi.Builder().build().adapter(listType)
        val result = adapter.fromJson(readJSONFromAsset(fileName) ?: "")
        return result?.toList()?.map { it.key to it.term }?.toMap()
    }



}