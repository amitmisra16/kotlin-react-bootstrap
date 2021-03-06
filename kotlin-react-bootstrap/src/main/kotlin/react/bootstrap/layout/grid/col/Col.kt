package react.bootstrap.layout.grid.col

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.classes
import react.RState
import react.bootstrap.helpers.addOrInit
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

class Col : CustomisableComponent<CommonAttributeGroupFacade, Col.Props, RState>() {
    override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> = DIV::class

    override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
        attrs {
            // Pairs and Triples match in multiple of those. That's why we need a Set
            val colClasses = mutableSetOf<ClassNames>()

            with(props) {
                if (all?.size == null && sm?.size == null && md?.size == null && lg?.size == null && xl?.size == null) {
                    EQ.getClassNames(null).let(colClasses::addAll)
                }

                all?.getClassNames(null)?.let(colClasses::addAll)
                sm?.getClassNames(Breakpoints.SM)?.let(colClasses::addAll)
                md?.getClassNames(Breakpoints.MD)?.let(colClasses::addAll)
                lg?.getClassNames(Breakpoints.LG)?.let(colClasses::addAll)
                xl?.getClassNames(Breakpoints.XL)?.let(colClasses::addAll)
            }

            loadGlobalAttributes(props)

            classes = props.classes.addOrInit(colClasses)
        }
    }

    interface Props : WithRendererTag<CommonAttributeGroupFacade>, WithGlobalAttributes {
        var all: ColAttributes?
        var sm: ColAttributes?
        var md: ColAttributes?
        var lg: ColAttributes?
        var xl: ColAttributes?
    }
}
