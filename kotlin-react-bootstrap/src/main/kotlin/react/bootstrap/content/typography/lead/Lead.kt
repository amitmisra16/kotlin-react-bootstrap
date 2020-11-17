package react.bootstrap.content.typography.lead

import kotlinx.html.P
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.SimpleDOMComponent

class Lead(props: Props) : SimpleDOMComponent<P, Lead.Props, RState>(props, P::class) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.LEAD)

    interface Props : SimpleDOMComponent.Props<P>
}
