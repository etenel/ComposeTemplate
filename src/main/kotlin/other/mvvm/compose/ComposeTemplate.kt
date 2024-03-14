package other.mvvm.compose

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.EnumWidget
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.enumParameter
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val mvvmComposeTemplate
    get() = template {

        name = "Composable页面"
        description = "Composable页面"
        minApi = MIN_API
        category = Category.Compose
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val pageName = stringParameter {
            name = "Composable Name"
            default = "MVVM"
            help = "只输入页面名字"
            constraints = listOf(Constraint.NONEMPTY, Constraint.UNIQUE)
        }


        //val packageName = defaultPackageNameParameter
        val packageName = stringParameter {
            name = " Package Name"
            default = defaultPackageNameParameter.value
            constraints = listOf(Constraint.PACKAGE)
        }
        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }
        val saveNavigation= booleanParameter {
            name="save navigation"
            default=true
        }
        val saveViewModel= booleanParameter {
            name="save viewModel"
            default=true
        }
        val saveModule= booleanParameter {
            name="save module"
            default=true
        }
        widgets(
            TextFieldWidget(pageName),
            PackageNameWidget(packageName),
            EnumWidget(language),
            CheckBoxWidget(saveNavigation),
            CheckBoxWidget(saveViewModel),
            CheckBoxWidget(saveModule)

        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            composeRecipe(
                data as ModuleTemplateData,
                pageName.value,
                packageName.value,
                saveViewModel.value,
                saveNavigation.value,
                saveModule.value
            )
        }
    }
