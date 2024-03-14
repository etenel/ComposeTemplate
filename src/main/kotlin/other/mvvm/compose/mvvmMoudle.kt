package other.mvvm.compose

fun mvvmMoudle (packageName:String,
                composeClass:String)="""
 
package ${packageName}.di

import com.wls.base.IRepository
import ${packageName}.repository.${composeClass}Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ${composeClass}Module {
    @Binds
    fun bind${composeClass}Repository(repository: ${composeClass}Repository): IRepository

}                     
                  """