package com.example.tgmuresproblema.data.translations

import com.example.tgmuresproblema.data.util.FileReader
import io.reactivex.rxjava3.annotations.NonNull
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
    private val fileReader: FileReader by inject()

    private val translationList = HashMap<String, String>()

    fun setTranslations(translationList: Map<String, String>) {
        this.translationList.clear()
        this.translationList.putAll(translationList)
    }

    fun getTranslation(translationKey: TranslationKey): String {
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