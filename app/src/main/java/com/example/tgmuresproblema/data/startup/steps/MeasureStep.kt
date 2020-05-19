package com.example.tgmuresproblema.data.startup.steps

import android.app.Activity
import android.content.Context
import com.example.tgmuresproblema.ui.util.SCREEN_HEIGHT
import com.example.tgmuresproblema.ui.util.SCREEN_WIDTH

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */
class MeasureStep(val context: Context) : Step {
    override fun execute(successListener: StepSuccessListener) {
        SCREEN_WIDTH = context.resources.displayMetrics.widthPixels
        SCREEN_HEIGHT = context.resources.displayMetrics.heightPixels

        successListener.stepSuccessful()
    }

}