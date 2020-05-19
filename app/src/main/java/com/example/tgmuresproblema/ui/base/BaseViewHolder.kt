package com.example.tgmuresproblema.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */
open class BaseViewHolder(parentView: ViewGroup, @LayoutRes resourceId: Int) :
    RecyclerView.ViewHolder(parentView.inflate(resourceId, false))