package com.example.tgmuresproblema.ui.issuesender

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tgmuresproblema.R
import com.example.tgmuresproblema.data.translations.TranslationKey
import com.example.tgmuresproblema.data.translations.TranslationManager
import com.example.tgmuresproblema.ui.base.BaseFragment
import com.example.tgmuresproblema.ui.main.MainContract
import com.example.tgmuresproblema.ui.util.AlertDialogUtil
import com.example.tgmuresproblema.ui.util.LoadingManager
import kotlinx.android.synthetic.main.fragment_issue_sender.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * A simple [Fragment] subclass.
 * Use the [IssueSenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IssueSenderFragment : BaseFragment<IssueSenderContract.Presenter>(),
    IssueSenderContract.View {

    override val presenter: IssueSenderContract.Presenter? by inject { parametersOf(this) }
    private val translationManager: TranslationManager by inject()
    private val loadingManager: LoadingManager by inject()
    private val alertDialog: AlertDialogUtil by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_issue_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        issueSenderTextView.text = translationManager.getTranslation(TranslationKey.KEY_HELP)
        issueSenderButton.text = translationManager.getTranslation(TranslationKey.KEY_SEND)
        issueSenderTextArea.hint =
            translationManager.getTranslation(TranslationKey.KEY_TEXT_AREA_PLACEHOLDER)
        issueSenderButton.setOnClickListener {
            loadingManager.setLoadingVisibility(View.VISIBLE)
            presenter?.sendQuestion(issueSenderTextArea.text.toString())
        }

        if (arguments?.getBoolean("showTanks") == true) {
            personalDataSendImage.visibility = View.VISIBLE
            personalDataThanks.visibility = View.VISIBLE
            personalDataThanks.text = translationManager.getTranslation(TranslationKey.KEY_THANKS)
            issueSenderTextView.text = translationManager.getTranslation(TranslationKey.KEY_MORE_QUESTION)
        }
    }

    override fun showNextFragment() {
        findNavController().navigate(R.id.action_issueSenderFragment_to_personalDataFragment)
        loadingManager.setLoadingVisibility(View.GONE)
    }

    override fun showError(error: String) {
        alertDialog.createAlertDialog(context, error)?.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment IssueSenderFragment.
         */
        @JvmStatic
        fun newInstance() =
            IssueSenderFragment()
    }

}
