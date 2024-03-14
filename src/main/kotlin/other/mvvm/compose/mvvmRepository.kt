package other.mvvm.compose

fun mvvmRepository(packageName:String, composeClass:String)="""
package ${packageName}.repository
import com.wls.base.IRepository
import javax.inject.Inject

class ${composeClass}Repository @Inject constructor()  : IRepository {

    
}
"""