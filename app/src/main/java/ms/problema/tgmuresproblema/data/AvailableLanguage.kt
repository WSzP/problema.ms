package ms.problema.tgmuresproblema.data

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */

enum class AvailableLanguage(val translationKey: ms.problema.tgmuresproblema.data.translations.TranslationKey, val languageKey: String) {

    HUNGARIAN(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_HUNGARIAN,"hu"),
    ROMANIAN(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_ROMANIAN,"ro"),
    ENGLISH(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_ENGLISH,"en")

}