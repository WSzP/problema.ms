package ms.problema.tgmuresproblema.data.startup.steps

import android.content.Context
import ms.problema.tgmuresproblema.ui.util.SCREEN_HEIGHT
import ms.problema.tgmuresproblema.ui.util.SCREEN_WIDTH

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */
class MeasureStep(val context: Context) :
    ms.problema.tgmuresproblema.data.startup.steps.Step {
    override fun execute(successListener: ms.problema.tgmuresproblema.data.startup.steps.StepSuccessListener) {
        SCREEN_WIDTH = context.resources.displayMetrics.widthPixels
        SCREEN_HEIGHT = context.resources.displayMetrics.heightPixels

        successListener.stepSuccessful()
    }

}