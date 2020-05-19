package ms.problema.tgmuresproblema.ui.personaldata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_personal_data.*

import ms.problema.tgmuresproblema.R
import ms.problema.tgmuresproblema.ui.base.BaseFragment
import ms.problema.tgmuresproblema.ui.util.AlertDialogUtil
import ms.problema.tgmuresproblema.ui.util.WebOpenerUtil
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
    val translationManager: ms.problema.tgmuresproblema.data.translations.TranslationManager by inject()
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
        personalDataSenderSend.text = translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_SEND)
        personalDataName.hint = translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_NAME)
        personalDataPhone.hint = translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_PHONE)
        personalDataEmail.hint = translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_EMAIL)

        personalDataNameEditText.setText(ms.problema.tgmuresproblema.data.persistence.SavedValues.username.getString())
        personalDataPhoneEditText.setText(ms.problema.tgmuresproblema.data.persistence.SavedValues.phone.getString())
        personalDataEmailEditText.setText(ms.problema.tgmuresproblema.data.persistence.SavedValues.email.getString())

        personalDataSenderSend.setOnClickListener {
            presenter?.sendPersonalData(
                personalDetailCheckBox.isChecked,
                personalDataNameEditText.text.toString(),
                personalDataPhoneEditText.text.toString(),
                personalDataEmailEditText.text.toString()
            )
        }

        personalDataCheckText.text =
            translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_AGREE_PRIVACY)
        personalDataPrivacy.text =
            translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_CHECKBOX_PRIVACY)

        personalDataCheckText.setOnClickListener {
            personalDetailCheckBox.toggle()
        }

        personalDataPrivacy.setOnClickListener {
            webOpenerUtil.openWebUrl("https://problema.ms/privacy/" + ms.problema.tgmuresproblema.data.persistence.SavedValues.language.getString())
        }

        personalDataThanks.text = translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_THANKS_INQUIRY)
        personalDetailFeedback.text = translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_FEEDBACK_TEXT)

    }

    override fun showNextFragment() {
        val bundle = bundleOf("showTanks" to true)
        findNavController().navigate(R.id.action_personalDataFragment_to_issueSenderFragment,bundle)
    }

    override fun showTextFieldError() {
        alertDialogUtil.showAlertDialog(
            context,
            translationManager.getTranslation(ms.problema.tgmuresproblema.data.translations.TranslationKey.KEY_ADD_EMAIL_PHONE)
        )
    }

}
