package ms.problema.tgmuresproblema.ui.util

import android.app.AlertDialog
import android.content.Context
import android.widget.TextView
import ms.problema.tgmuresproblema.R

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *i
 */

class AlertDialogUtil {

    fun showAlertDialog(
        context: Context?,
        message: String
    ){
        if (context == null) {
            return
        }

        val builder = AlertDialog.Builder(context)

        builder.setMessage(message)
        builder.setPositiveButton("ok") { dialog, which
            ->
        }

        builder.create()

        val show = builder.show()
        val messageView = show.findViewById<TextView>(android.R.id.message)
        messageView.textSize = 20f
    }

}