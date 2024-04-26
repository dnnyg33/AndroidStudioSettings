
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neighbor.repositories.Resource
import javax.inject.Inject

class ${FragmentName}Presenter @Inject constructor(): ViewModel() {
    val items = MutableLiveData<Resource<${FragmentName}ListItem>>()

    fun loadPage() {
        TODO("fetch data and map to ${FragmentName}ListItem")
    }
}

sealed class ${FragmentName}ListItem {
    object ${FragmentName}Item: ${FragmentName}ListItem()
    object EmptyStateItem: ${FragmentName}ListItem()
}