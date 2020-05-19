package com.example.tgmuresproblema.data.startup

import android.content.Context
import com.example.tgmuresproblema.data.startup.steps.MeasureStep
import com.example.tgmuresproblema.data.startup.steps.Step
import com.example.tgmuresproblema.data.startup.steps.StepSuccessListener
import com.example.tgmuresproblema.data.startup.steps.TranslationLoadStep
import io.reactivex.rxjava3.core.Observable
import kotlin.collections.ArrayList

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */

class StartupFlow(context: Context) {

    private val stepList = ArrayList<Step>()

    init {
        stepList.add(TranslationLoadStep())
    }

    fun executeStartup(): Observable<Boolean> {
        return Observable.create { emitter ->
            iterateOnSteps(stepList) {
                emitter.onNext(it)
            }
        }
    }

    private fun iterateOnSteps(
        stepList: ArrayList<Step>,
        successListener: (Boolean) -> Unit
    ) {
        if (stepList.isEmpty()) {
            successListener(true)
            return
        }

        stepList.first().execute(object : StepSuccessListener {
            override fun stepSuccessful() {
                stepList.removeAt(0)
                iterateOnSteps(stepList, successListener)
            }

            override fun stepFailed() {
                successListener(false)
            }

        })
    }
}