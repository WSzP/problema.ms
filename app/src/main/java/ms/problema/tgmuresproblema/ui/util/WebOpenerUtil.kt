package ms.problema.tgmuresproblema.ui.util

import android.content.Context
import android.content.Intent
import android.net.Uri


/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */

class WebOpenerUtil (val context: Context){

    fun openWebUrl(webUrl: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(browserIntent)
    }

}