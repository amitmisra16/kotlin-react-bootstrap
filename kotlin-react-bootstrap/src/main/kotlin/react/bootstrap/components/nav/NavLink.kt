package react.bootstrap.components.nav

import kotlinext.js.jsObject
import kotlinx.html.classes
import kotlinx.html.tabIndex
import react.RBuilder
import react.RState
import react.RStatics
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.ariaDisabled
import react.bootstrap.lib.kotlinxhtml.loadAttributes
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.identifiable.IdentifiableProps
import react.bootstrap.lib.react.rprops.WithActive
import react.bootstrap.lib.react.rprops.WithDisabled
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.react.rprops.tags.WithAttributesA
import react.dom.a
import react.setState

class NavLink(props: Props) : BootstrapComponent<NavLink.Props, NavLink.State>(props) {
    override fun State.init(props: Props) {
        active = props.active

        props.activeLinkPredicate?.let {
            active = it.invoke(props)
        }
    }

    override fun componentDidMount() {
        if (state.active) {
            props.onActive?.invoke()
        }
    }

    override fun componentDidUpdate(prevProps: Props, prevState: State, snapshot: Any) {
        if (prevProps !== props) {
            setState {
                active = props.activeLinkPredicate?.invoke(props) ?: props.active
            }
        }
        if (!prevState.active && props.active) {
            props.onActive?.invoke()
        }
    }

    override fun buildClasses(): Set<ClassNames> {
        val navLinkClasses = mutableSetOf(
            ClassNames.NAV_LINK
        )

        if (state.active) {
            navLinkClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled) {
            navLinkClasses.add(ClassNames.DISABLED)
        }

        return navLinkClasses
    }

    override fun RBuilder.render() {
        a {
            attrs {
                loadGlobalAttributes(props)
                loadDomEvents(props)
                loadAttributes(props)

                classes = getComponentClasses()

                if (props.disabled) {
                    tabIndex = "-1"
                    ariaDisabled = true
                }
            }
            children()
        }
    }

    interface Props : WithAttributesA, WithActive, WithDisabled, WithDomEvents, IdentifiableProps<NavLink> {
        var activeLinkPredicate: (Props.() -> Boolean)?
    }

    interface State : RState {
        var active: Boolean
    }

    companion object : RStatics<Props, State, NavLink, Nothing>(NavLink::class) {
        init {
            defaultProps = jsObject {
                componentType = NavLink::class
                active = false
                disabled = false
            }
        }
    }
}
