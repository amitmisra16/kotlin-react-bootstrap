package react.bootstrap.site.components.docs.fixings

import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.site.external.PrismLight
import react.dom.figure

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/styles/prism/coy")
external val coy: dynamic

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/languages/prism/kotlin")
external val kotlin: dynamic

internal class CodeExample : RComponent<CodeExample.Props, RState>() {
    override fun RBuilder.render() {
        val code = props.code ?: ""

        PrismLight.registerLanguage("kotlin", kotlin.default)

        figure("highlight") {
            PrismLight {
                attrs {
                    language = "kotlin"
                    style = coy.default
                }
                +code
            }
        }
    }

    interface Props : RProps {
        var code: String?
    }
}

internal class CodeExampleBuilder(private val indent: Int) : RElementBuilder<CodeExample.Props>(jsObject()) {
    internal fun joinToString(): String = childList.joinToString("")

    // Todo remove this
    internal fun string(content: String) {
        +"+\"$content\""
    }

    internal fun plusString(content: String): String = "+\"$content\""

    // Todo remove this
    internal fun appendLine(block: CodeExampleBuilder.() -> Unit) {
        +getIndent(indent)
        block()
        +"\n"
    }

    // Todo remove this
    internal fun appendLine(content: String) {
        appendLine {
            string(content)
        }
    }

    // Todo remove this
    private fun getIndent(level: Int): String =
        buildString {
            for (x in 1..level) {
                append("    ")
            }
        }
}

internal fun RBuilder.codeExample(block: CodeExampleBuilder.() -> Unit): ReactElement {
    val code = CodeExampleBuilder(0).apply {
        block()
    }

    return child(CodeExample::class) {
        attrs.code = code.joinToString()
    }
}
