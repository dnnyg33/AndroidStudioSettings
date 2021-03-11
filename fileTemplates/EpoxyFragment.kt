import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.neighbor.appcoordination.AppCoordination
import com.neighbor.earnings.databinding.Fragment${FragmentName}Binding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
//todo add to dagger module
//@ContributesAndroidInjector
//abstract fun ${FragmentName}Fragment(): ${FragmentName}Fragment
class ${FragmentName}Fragment : Fragment() {

    @Inject
    lateinit var appCoordination: AppCoordination
    private lateinit var binding: Fragment${FragmentName}Binding

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    //todo add to dagger module
    //@Binds
    //@IntoMap
    //@ViewModelKey(${FragmentName}Presenter::class)
    //internal abstract fun ${FragmentName}Presenter(presenter: ${FragmentName}Fragment): ViewModel
    
    val presenter: ${FragmentName}Presenter by viewModels { factory }
    lateinit var controller: ${FragmentName}Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = getString(R.string.${FragmentName})
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_${FragmentName}, container, false
            )
        AndroidSupportInjection.inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLiveData()
        setupRecyclerView()
        presenter.loadPage()
    }

    private fun setupRecyclerView() {
        controller = ${FragmentName}Controller(this)
        binding.epoxyList.adapter = controller.adapter
    }

    private fun setupLiveData() {
    }

}