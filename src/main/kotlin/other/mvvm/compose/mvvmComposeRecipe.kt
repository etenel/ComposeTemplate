package other.mvvm.compose

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import org.jetbrains.kotlin.idea.base.psi.unquoteKotlinIdentifier

fun RecipeExecutor.composeRecipe(
    moduleData: ModuleTemplateData,
    composeClass: String,
    packageName: String,
    saveViewModel: Boolean,
    saveNavigation: Boolean,
    saveModule: Boolean
) {
    val (projectData, srcOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val mvvmCompose = mvvmComposeKt( composeClass, packageName)
    // 保存Compose
    save(mvvmCompose, srcOut.resolve("${composeClass}.${ktOrJavaExt}"))
//保存navigation
    if (saveNavigation) {
        save(
            mvvmNavigation(packageName, composeClass),
            srcOut.resolve("navigation/${composeClass}Navigation.${ktOrJavaExt}")
        )
    }
    // 保存viewModel
    if (saveViewModel) {
        save(
            mvvmViewModel(packageName, composeClass),
            srcOut.resolve("viewmodel/${composeClass}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepository(packageName, composeClass),
            srcOut.resolve("./repository/${composeClass}Repository.${ktOrJavaExt}")
        )

    }
    //保存dagger的module
    if (saveModule) {
        save(
            mvvmMoudle(packageName, composeClass),
            srcOut.resolve("di/${composeClass}Module.${ktOrJavaExt}")
        )
    }
}