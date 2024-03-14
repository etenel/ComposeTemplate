package other.mvvm.compose

fun mvvmComposeKt(
    composeClass: String,
    packageName: String
) = """
 @file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class, ExperimentalLayoutApi::class
)   
package $packageName
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import ${packageName}.viewModel.${composeClass}ViewModel
import androidx.compose.runtime.Composable

@Composable
fun ${composeClass}Route(
    modifier: Modifier = Modifier,
    viewModel: ${composeClass}ViewModel = hiltViewModel(),
){
    ${composeClass}Screen(
  
    )
}
@Composable
fun ${composeClass}Screen(
    modifier: Modifier = Modifier,
){
    
}                  
@Preview(showBackground = true, showSystemUi = true)
@Composable                  
fun Pre${composeClass}(){
   
    ${composeClass}Screen(
    
    )                  
}                  
                  
"""