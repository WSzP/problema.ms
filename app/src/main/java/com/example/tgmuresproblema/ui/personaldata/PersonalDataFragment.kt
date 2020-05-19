package com.example.tgmuresproblema.ui.personaldata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

import com.example.tgmuresproblema.R
import com.example.tgmuresproblema.data.persistence.SavedValues
import com.example.tgmuresproblema.data.translations.TranslationKey
import com.example.tgmuresproblema.data.translations.TranslationManager
import com.example.tgmuresproblema.ui.base.BaseFragment
import com.example.tgmuresproblema.ui.util.AlertDialogUtil
import com.example.tgmuresproblema.ui.util.WebOpenerUtil
import kotlinx.android.synthetic.main.fragment_personal_data.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalDataFragment : BaseFragment<PersonalDataContract.Presenter>(),
    PersonalDataContract.View {

    override val presenter: PersonalDataContract.Presenter? by inject { parametersOf(this) }
    val translationManager: TranslationManager by inject()
    val alertDialogUtil: AlertDialogUtil by inject()
    val webOpenerUtil: WebOpenerUtil by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personalDataSenderSend.text = translationManager.getTranslation(TranslationKey.KEY_SEND)
        personalDataName.hint = translationManager.getTranslation(TranslationKey.KEY_NAME)
        personalDataPhone.hint = translationManager.getTranslation(TranslationKey.KEY_PHONE)
        personalDataEmail.hint = translationManager.getTranslation(TranslationKey.KEY_EMAIL)

        personalDataNameEditText.setText(SavedValues.username.getString())
        personalDataPhoneEditText.setText(SavedValues.phone.getString())
        personalDataEmailEditText.setText(SavedValues.email.getString())

        personalDataSenderSend.setOnClickListener {
            presenter?.sendPersonalData(
                personalDetailCheckBox.isChecked,
                personalDataNameEditText.text.toString(),
                personalDataPhoneEditText.text.toString(),
                personalDataEmailEditText.text.toString()
            )
        }

        personalDataCheckText.text =
            translationManager.getTranslation(TranslationKey.KEY_AGREE_PRIVACY)
        personalDataPrivacy.text =
            translationManager.getTranslation(TranslationKey.KEY_CHECKBOX_PRIVACY)

        personalDataCheckText.setOnClickListener {
            personalDetailCheckBox.toggle()
        }

        personalDataPrivacy.setOnClickListener {
            webOpenerUtil.openWebUrl("https://problema.ms/privacy/" + SavedValues.language.getString())
        }

        personalDataThanks.text = translationManager.getTranslation(TranslationKey.KEY_THANKS_INQUIRY)
        personalDetailFeedback.text = translationManager.getTranslation(TranslationKey.KEY_FEEDBACK_TEXT)

    }

    override fun showNextFragment() {
        val bundle = bundleOf("showTanks" to true)
        findNavController().navigate(R.id.action_personalDataFragment_to_issueSenderFragment,bundle)
    }

    override fun showTextFieldError() {
        alertDialogUtil.createAlertDialog(
            context,
            translationManager.getTranslation(TranslationKey.KEY_ADD_EMAIL_PHONE)
        )?.show()
    }

}
