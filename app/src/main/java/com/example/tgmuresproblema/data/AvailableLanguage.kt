package com.example.tgmuresproblema.data

import com.example.tgmuresproblema.data.translations.TranslationKey

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */

enum class AvailableLanguage(val translationKey: TranslationKey, val languageKey: String) {

    HUNGARIAN(TranslationKey.KEY_HUNGARIAN,"hu"),
    ROMANIAN(TranslationKey.KEY_ROMANIAN,"ro"),
    ENGLISH(TranslationKey.KEY_ENGLISH,"en")

}