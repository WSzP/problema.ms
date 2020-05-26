package ms.problema.tgmuresproblema.ui.intro.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_language.view.*
import ms.problema.tgmuresproblema.R
import ms.problema.tgmuresproblema.ui.base.BaseViewHolder
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

    private val translationManager: ms.problema.tgmuresproblema.data.translations.TranslationManager by inject()

    private var dataSource = mutableListOf<ms.problema.tgmuresproblema.data.AvailableLanguage>()
    private var clickListener: (language: ms.problema.tgmuresproblema.data.AvailableLanguage) -> Unit

    constructor(
        dataSource: List<ms.problema.tgmuresproblema.data.AvailableLanguage>,
        clickListener: (language: ms.problema.tgmuresproblema.data.AvailableLanguage) -> Unit
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