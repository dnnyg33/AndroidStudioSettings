package ${PACKAGE_NAME}

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout= R.layout.${LAYOUT_NAME})
abstract class ${NAME}EpoxyModel : EpoxyModelWithHolder<${NAME}EpoxyModel.ViewHolder>() {

    @EpoxyAttribute
    lateinit var viewModel: ViewModel//the data backing model

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        val context = holder.context

    }
    
     class ViewHolder : KotlinEpoxyHolder() {
        val titleView by bind<TextView>(R.id.title)
    }
}