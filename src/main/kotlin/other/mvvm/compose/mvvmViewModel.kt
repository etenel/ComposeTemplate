package other.mvvm.compose

fun mvvmViewModel(packageName:String,
                  composeClass:String)="""
                      
package ${packageName}.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wls.base.BaseViewModel
import ${packageName}.repository.${composeClass}Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${composeClass}ViewModel @Inject constructor(private val repository: ${composeClass}Repository) :
    BaseViewModel<Unit>() {

     
}

                    """