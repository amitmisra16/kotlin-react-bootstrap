package react.bootstrap.content.typography

import kotlinx.html.LI
import kotlinx.html.UL
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.ClassNameEnum
import react.dom.li
import react.dom.ul

enum class ListStyles(override val className: ClassNames) : ClassNameEnum {
    UNSTYLED(ClassNames.LIST_UNSTYLED),
    INLINE(ClassNames.LIST_INLINE);
}

/**
 * Creates an [UL] element.
 *
 * @param listStyles Set different [ListStyles].
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.ul(
    listStyles: ListStyles,
    classes: String? = null,
    block: RDOMHandler<UL>
): ReactElement = ul(classes = classes.appendClass(listStyles.className), block = block)

enum class ListItemStyles(override val className: ClassNames) : ClassNameEnum {
    INLINE(ClassNames.LIST_INLINE);
}

/**
 * Creates an [LI] element.
 *
 * @param listItemStyles Set different [ListItemStyles].
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.li(
    listItemStyles: ListItemStyles,
    classes: String? = null,
    block: RDOMHandler<LI>
): ReactElement = li(classes = classes.appendClass(listItemStyles.className), block = block)
