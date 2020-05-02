package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.lib.ClassNames
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.document

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal val Enum<*>.kt: String
    get() = "${this::class.simpleName}.$name"

internal abstract class DocumentationPage(private val category: Category<*>) :
    RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        switch {
            category.subCategories.forEach { subcategory ->
                route<RProps>(subcategory.link) {
                    subcategory.renderer.invoke(this)
                }
            }
            route(category.link) {
                redirect(props.location.pathname, category.subCategories.first().link)
            }
        }
    }
}

internal fun RBuilder.classNamesImport() {
    ln { +"import react.bootstrap.lib.${ClassNames::class.simpleName}" }
}

internal fun RBuilder.ln(indentationLevel: Int = 0, block: RBuilder.() -> Unit) {
    for (x in 1..indentationLevel) {
        +"    "
    }
    block()
    +"\n"
}
