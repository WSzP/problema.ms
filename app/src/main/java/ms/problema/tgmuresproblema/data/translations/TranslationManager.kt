package ms.problema.tgmuresproblema.data.translations

import io.reactivex.rxjava3.core.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */
class TranslationManager : KoinComponent {

    private val filenamePrefix = "translations-"
    private val fileReader: ms.problema.tgmuresproblema.data.util.FileReader by inject()

    private val translationList = HashMap<String, String>()

    fun setTranslations(translationList: Map<String, String>) {
        this.translationList.clear()
        this.translationList.putAll(translationList)
    }

    fun getTranslation(translationKey: ms.problema.tgmuresproblema.data.translations.TranslationKey): String {
        return if (translationList.containsKey(translationKey.toString()))
            translationList[translationKey.toString()] as String
        else {
            ""
        }
    }

    fun loadTranslationsToMemory(
        languageKey: String
    ): Observable<Boolean> {
        return Observable.create { emitter ->
            val mapFromJsonString = fileReader.getMapFromJsonString(filenamePrefix + languageKey)
            setTranslations(mapFromJsonString ?: emptyMap())
            emitter.onNext(true)
        }

    }

}