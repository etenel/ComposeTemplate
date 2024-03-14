package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvvm.compose.mvvmComposeTemplate

class SamplePluginTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(

        // compose
        mvvmComposeTemplate,

        )


}