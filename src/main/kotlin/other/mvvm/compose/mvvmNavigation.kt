package other.mvvm.compose

fun  mvvmNavigation(packageName: String, composeClass: String) = """
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ${packageName}.${composeClass}Route

const val ${composeClass.lowercase()}Route = "${composeClass.lowercase()}_route"

fun NavController.navigateTo${composeClass}(navOptions: NavOptions? = null) {
    this.navigate(${composeClass.lowercase()}Route, navOptions)
}

fun NavGraphBuilder.${composeClass.lowercase()}Screen() {
        composable(route = ${composeClass.lowercase()}Route,
            //deepLinks = listOf(navDeepLink { uriPattern= }),
//        arguments = listOf(navArgument(" "){type= NavType.StringType})
        ) {
            ${composeClass}Route()
        }
}



"""