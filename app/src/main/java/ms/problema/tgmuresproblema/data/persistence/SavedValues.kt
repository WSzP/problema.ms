package ms.problema.tgmuresproblema.data.persistence

import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */
enum class SavedValues : KoinComponent {
    language,
    firstStart,
    lastAddedId,
    username,
    phone,
    email;

    private val sharedPrefManager: ms.problema.tgmuresproblema.data.persistence.SharedPrefManager by inject()

    fun getString(): String {
        return sharedPrefManager.getString(this.name)
    }

    fun getBoolean(): Boolean {
        return sharedPrefManager.getBoolean(this.name)
    }

    fun put(value: String) {
        sharedPrefManager.putValue(this.name, value)
    }

    fun put(value: Boolean) {
        sharedPrefManager.putValue(this.name, value)
    }
}