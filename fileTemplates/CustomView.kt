class CustomComponent @JvmOverloads constructor(
context: Context,
attrs: AttributeSet? = null,
defStyle: Int = 0,
defStyleRes: Int = 0):LinearLayout(context, attrs, defStyle, defStyleRes) {
init {
    LayoutInflater.from(context)
        .inflate(R.layout.custom_view, this, true)
}}