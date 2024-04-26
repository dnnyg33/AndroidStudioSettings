package ${PACKAGE_NAME}

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.neighbor.utils.ui.epoxy.KotlinEpoxyHolder

class ${NAME} : EpoxyModelWithHolder<${NAME}.ViewHolder>() {
     inner class ViewHolder : KotlinEpoxyHolder() {
        val title: TextView by bind(R.id.title)
    }

    override fun getDefaultLayout(): Int = R.layout.layout_#parse("snakeCase(${NAME}")
    
    override fun createNewHolder(): ViewHolder = ViewHolder()
}