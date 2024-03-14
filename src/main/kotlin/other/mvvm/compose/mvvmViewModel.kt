package other.mvvm.compose

fun mvvmViewModel(packageName:String,
                  composeClass:String)="""
                      
package ${packageName}.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wls.base.entity.ResultState
import ${packageName}.repository.${composeClass}Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ${composeClass}ViewModel @Inject constructor(private val repository: ${composeClass}Repository) :
    ViewModel() {
private val _state = MutableSharedFlow<ResultState<Any>>()
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),ResultState.None
    )
 
      
}

                    """