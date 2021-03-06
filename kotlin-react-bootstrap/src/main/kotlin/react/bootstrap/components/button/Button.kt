package react.bootstrap.components.button

import kotlinext.js.jsObject
import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.InputType
import kotlinx.html.classes
import kotlinx.html.js.onChangeFunction
import kotlinx.html.role
import kotlinx.html.style
import kotlinx.html.tabIndex
import kotlinx.html.title
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RBuilder
import react.RState
import react.RStatics
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.kotlinxhtml.ariaDisabled
import react.bootstrap.lib.kotlinxhtml.ariaPressed
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.identifiable.IdentifiableProps
import react.bootstrap.lib.react.rprops.WithActive
import react.bootstrap.lib.react.rprops.WithDisabled
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.a
import react.dom.button
import react.dom.input
import react.dom.label
import react.setState

class Button(props: Props) : BootstrapComponent<Button.Props, Button.State>(props) {
    init {
        // These comparison are not senseless. The props are built using kotlin's `dynamic` keyword. Null is a possible
        // value.

        @Suppress("SENSELESS_COMPARISON")
        require(props.variant != null) {
            "Missing property: variant must not be null!"
        }
    }

    override fun State.init(props: Props) {
        active = props.active
    }

    override fun componentDidMount() {
        if (state.active) {
            props.onActive?.invoke()
        }
    }

    override fun componentDidUpdate(prevProps: Props, prevState: State, snapshot: Any) {
        if (prevProps !== props) {
            setState {
                active = props.active
            }
        }
        if (!prevState.active && props.active) {
            props.onActive?.invoke()
        }
    }

    private fun handleChange(event: Event, originalEventHandler: EventHandler?) {
        if (originalEventHandler is EventHandler) {
            originalEventHandler.invoke(event)
        }
        val target = event.target as HTMLInputElement

        setState {
            active = target.checked
        }
    }

    override fun buildClasses(): Set<ClassNames> {
        val btnClasses = mutableSetOf(ClassNames.BTN)

        if (state.active) {
            btnClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled && props.type is Types.Link) {
            btnClasses.add(ClassNames.DISABLED)
        }

        if (props.nowrap) {
            btnClasses.add(ClassNames.TEXT_NOWRAP)
        }

        if (props.blockSized) {
            btnClasses.add(ClassNames.BTN_BLOCK)
        }

        props.sizes?.also {
            btnClasses.add(
                when (it) {
                    Sizes.SM -> ClassNames.BTN_SM
                    Sizes.LG -> ClassNames.BTN_LG
                }
            )
        }

        btnClasses.add(props.variant.className)

        return btnClasses
    }

    @Suppress("UnsafeCastFromDynamic")
    override fun RBuilder.render() {
        when (val type = props.type) {
            is Types.Button -> {
                button(
                    formEncType = type.buttonFormEncType,
                    formMethod = type.buttonFormMethod,
                    type = type.buttonType
                ) {
                    attrs {
                        handleCommonAttrs()
                        loadGlobalAttributes(props)

                        classes = getComponentClasses()

                        attrs.disabled = props.disabled
                    }
                    children()
                }
            }
            is Types.Input -> {
                if (type.type == Types.Input.Type.CHECKBOX || type.type == Types.Input.Type.RADIO) {
                    label {
                        attrs {
                            loadGlobalAttributes(props)

                            classes = getComponentClasses()
                        }
                        input(
                            type = type.type.inputType,
                            formEncType = type.inputFormEncType,
                            formMethod = type.inputFormMethod,
                            name = type.name
                        ) {
                            attrs {
                                handleCommonAttrs()
                                onChangeFunction = {
                                    handleChange(it, props.onChange)
                                }

                                value = type.value

                                // Hide the box/circle
                                style = kotlinext.js.js {
                                    position = "absolute"
                                    clip = "rect(0,0,0,0)"
                                    pointerEvents = "none"
                                }

                                if (props.disabled) {
                                    disabled = true
                                    tabIndex = "-1"
                                }

                                defaultChecked = state.active
                            }
                            // No children allowed
                        }
                        +" "
                        type.title?.let { +it } ?: +type.value
                    }
                } else {
                    input(
                        type = type.type.inputType,
                        formEncType = type.inputFormEncType,
                        formMethod = type.inputFormMethod,
                        name = type.name

                    ) {
                        attrs {
                            handleCommonAttrs()
                            loadGlobalAttributes(props)

                            classes = getComponentClasses()
                            value = type.value

                            type.title?.let {
                                title = it
                            }

                            if (props.disabled) {
                                disabled = true
                                tabIndex = "-1"
                            }
                        }
                        // No children allowed
                    }
                }
            }
            is Types.Link -> {
                a(href = type.href, target = type.target) {
                    attrs {
                        handleCommonAttrs()
                        loadGlobalAttributes(props)

                        classes = getComponentClasses()
                        role = "button"
                    }
                    children()
                }
            }
        }
    }

    private fun <T : CommonAttributeGroupFacade> T.handleCommonAttrs() {
        ariaPressed = state.active
        ariaDisabled = props.disabled

        loadDomEvents(props)
    }

    sealed class Variants(val className: ClassNames) {
        class Solid {
            class DANGER internal constructor() : Variants(ClassNames.BTN_DANGER)
            class DARK internal constructor() : Variants(ClassNames.BTN_DARK)
            class INFO internal constructor() : Variants(ClassNames.BTN_INFO)
            class LIGHT internal constructor() : Variants(ClassNames.BTN_LIGHT)
            class LINK internal constructor() : Variants(ClassNames.BTN_LINK)
            class PRIMARY internal constructor() : Variants(ClassNames.BTN_PRIMARY)
            class SECONDARY internal constructor() : Variants(ClassNames.BTN_SECONDARY)
            class SUCCESS internal constructor() : Variants(ClassNames.BTN_SUCCESS)
            class WARNING internal constructor() : Variants(ClassNames.BTN_WARNING)

            companion object {
                val DANGER = DANGER()
                val DARK = DARK()
                val INFO = INFO()
                val LIGHT = LIGHT()
                val LINK = LINK()
                val PRIMARY = PRIMARY()
                val SECONDARY = SECONDARY()
                val SUCCESS = SUCCESS()
                val WARNING = WARNING()
            }
        }

        class Outline {
            class DANGER internal constructor() : Variants(ClassNames.BTN_OUTLINE_DANGER)
            class DARK internal constructor() : Variants(ClassNames.BTN_OUTLINE_DARK)
            class INFO internal constructor() : Variants(ClassNames.BTN_OUTLINE_INFO)
            class LIGHT internal constructor() : Variants(ClassNames.BTN_OUTLINE_LIGHT)
            class PRIMARY internal constructor() : Variants(ClassNames.BTN_OUTLINE_PRIMARY)
            class SECONDARY internal constructor() : Variants(ClassNames.BTN_OUTLINE_SECONDARY)
            class SUCCESS internal constructor() : Variants(ClassNames.BTN_OUTLINE_SUCCESS)
            class WARNING internal constructor() : Variants(ClassNames.BTN_OUTLINE_WARNING)

            companion object {
                val DANGER = DANGER()
                val DARK = DARK()
                val INFO = INFO()
                val LIGHT = LIGHT()
                val PRIMARY = PRIMARY()
                val SECONDARY = SECONDARY()
                val SUCCESS = SUCCESS()
                val WARNING = WARNING()
            }
        }
    }

    enum class Sizes(override val className: ClassNames) : ClassNameEnum {
        SM(ClassNames.BTN_SM),
        LG(ClassNames.BTN_LG);
    }

    sealed class Types {
        class Button(
            val buttonFormEncType: ButtonFormEncType? = null,
            val buttonFormMethod: ButtonFormMethod? = null,
            val buttonType: ButtonType = ButtonType.button
        ) : Types()

        class Input(
            val type: Type = Type.BUTTON,
            val inputFormEncType: InputFormEncType? = null,
            val inputFormMethod: InputFormMethod? = null,
            val name: String? = null,
            val value: String,
            val title: String? = null
        ) : Types() {
            enum class Type(val inputType: InputType) {
                BUTTON(InputType.button),
                RESET(InputType.reset),
                SUBMIT(InputType.submit),
                RADIO(InputType.radio),
                CHECKBOX(InputType.checkBox);
            }
        }

        class Link(
            val href: String? = null,
            val target: String? = null
        ) : Types()
    }

    interface Props : WithGlobalAttributes, WithActive, WithDisabled, WithDomEvents, IdentifiableProps<Button> {
        /**
         * Set this to *true* to disable text-wrapping for this button.
         *
         * Defaults to *false*
         */
        var nowrap: Boolean

        /**
         * Use this to make buttons appear smaller or larger than usual.
         *
         * Defaults to *null*
         */
        var sizes: Sizes?

        /**
         * Setting this defines the underlying HTML.
         *
         * Defaults to [Types.Button]
         */
        var type: Types

        /**
         * Use the [Variants] to colour-in the button.
         */
        var variant: Variants

        /**
         * Set this to *true* to render the button as block.
         *
         * Defaults to *false*
         */
        var blockSized: Boolean
    }

    interface State : RState {
        var active: Boolean
    }

    companion object : RStatics<Props, State, Button, Nothing>(Button::class) {
        init {
            defaultProps = jsObject {
                nowrap = false
                type = Types.Button()
                componentType = Button::class
                blockSized = false
                active = false
                disabled = false
            }
        }
    }
}
