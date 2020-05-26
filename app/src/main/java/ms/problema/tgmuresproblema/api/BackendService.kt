package ms.problema.tgmuresproblema.api

import io.reactivex.rxjava3.core.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */

class BackendService : KoinComponent {

    private val backendService: ms.problema.tgmuresproblema.api.BackendProxy by inject()

    fun putQuestionData(question: String): Observable<String> {
        return Observable.create { emitter ->
            emitter.onNext(backendService.putQuestion(question))
        }
    }

    fun putAdditionalData(
        id: String,
        name: String,
        phone: String,
        email: String
    ): Observable<Boolean> {
        return Observable.create { emitter ->
            emitter.onNext(backendService.putPersonalData(id, name, phone, email))
        }
    }
}
