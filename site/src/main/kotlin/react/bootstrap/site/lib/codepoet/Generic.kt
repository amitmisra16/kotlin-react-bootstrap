package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.components.docs.nestedName
import kotlin.reflect.KClass

internal data class Generic(
    private val className: String,
    private val typeName: String
) : CodePoet {
    constructor(
        clazz: KClass<*>,
        type: KClass<*>
    ) : this(clazz.nestedName, type.nestedName)

    constructor(
        className: String,
        type: KClass<*>
    ) : this(className, type.nestedName)

    private var variance: Variance? = null

    fun setVariance(variance: Variance): Generic {
        this.variance = variance

        return this
    }

    override fun build(): String = buildString {
        append("$className<")

        variance?.let {
            append(it.name.toLowerCase())
            append(" ")
        }

        append("$typeName>")
    }

    enum class Variance {
        IN,
        OUT
    }

    companion object {
        inline fun <reified TP, reified TC> builder(): Generic = Generic(TP::class, TC::class)
    }
}
