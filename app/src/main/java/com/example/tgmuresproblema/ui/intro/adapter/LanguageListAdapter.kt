package com.example.tgmuresproblema.ui.intro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.tgmuresproblema.R
import com.example.tgmuresproblema.data.AvailableLanguage
import com.example.tgmuresproblema.data.translations.TranslationManager
import com.example.tgmuresproblema.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_language.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/16/2020
 *
 */

class LanguageListAdapter : RecyclerView.Adapter<LanguageListAdapter.LanguageViewHolder>,
    KoinComponent {

    private val translationManager: TranslationManager by inject()

    private var dataSource = mutableListOf<AvailableLanguage>()
    private var clickListener: (language: AvailableLanguage) -> Unit

    constructor(
        dataSource: List<AvailableLanguage>,
        clickListener: (language: AvailableLanguage) -> Unit
    ) {
        this.dataSource.addAll(dataSource)
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(parent, R.layout.item_language)
    }

    override fun getItemCount() = dataSource.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.languageItemText.text =
            translationManager.getTranslation(dataSource[position].translationKey)

        holder.languageItemText.setOnClickListener {
            clickListener.invoke(dataSource[position])
        }
    }

    class LanguageViewHolder(parentViewGroup: ViewGroup, @LayoutRes resourceId: Int) :
        BaseViewHolder(parentViewGroup, resourceId) {

        val languageItemText = itemView.languageItemText

    }
}