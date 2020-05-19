package com.example.tgmuresproblema.ui.util

import android.app.AlertDialog
import android.content.Context
import android.view.View

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *i
 */

class AlertDialogUtil {

    fun createAlertDialog(
        context: Context?,
        message: String
    ): AlertDialog? {
        if (context == null) {
            return null
        }

        val builder = AlertDialog.Builder(context)

        builder.setMessage(message)
        builder.setPositiveButton("ok") { dialog, which
            ->
        }

        return builder.create();
    }

}