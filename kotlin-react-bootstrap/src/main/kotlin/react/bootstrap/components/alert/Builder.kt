package react.bootstrap.components.alert

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.SPAN
import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.components.alert.Alert.Variants.DANGER
import react.bootstrap.components.alert.Alert.Variants.DARK
import react.bootstrap.components.alert.Alert.Variants.INFO
import react.bootstrap.components.alert.Alert.Variants.LIGHT
import react.bootstrap.components.alert.Alert.Variants.PRIMARY
import react.bootstrap.components.alert.Alert.Variants.SECONDARY
import react.bootstrap.components.alert.Alert.Variants.SUCCESS
import react.bootstrap.components.alert.Alert.Variants.WARNING
import react.bootstrap.lib.Builder
import react.bootstrap.helpers.splitClassesToSet

class AlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates an [Alert] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param classes Space separated list of CSS classes for this element.
     */
    fun RBuilder.alert(variant: Alert.Variants, classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        child(Alert.Static::class) {
            attrs {
                this.variant = variant
                this.classes = classes.splitClassesToSet()
            }

            block()
        }

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun danger(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(DANGER, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(classes: String? = null, block: RHandler<Alert.Props>): ReactElement = builder.alert(DARK, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(classes: String? = null, block: RHandler<Alert.Props>): ReactElement = builder.alert(INFO, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(LIGHT, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(PRIMARY, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(SECONDARY, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(SUCCESS, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(WARNING, classes, block)

    val dismissible = DismissibleAlertBuilder(builder)
}

class DismissibleAlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates a dismissible [Alert] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement = child(Alert.Dismissible::class) {
        attrs {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.fade = fade
        }

        block()
    }

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun danger(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(DANGER, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(DARK, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(INFO, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(LIGHT, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(PRIMARY, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(SECONDARY, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(SUCCESS, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(WARNING, fade, classes, block)
}

val RBuilder.Alerts
    get() = AlertBuilder(this)

fun RElementBuilder<Alert.Dismissible.Props>.closingElement(
    block: RHandler<Alert.Dismissible.ClosingElement.Props>
): ReactElement = child(Alert.Dismissible.ClosingElement::class) {
    attrs {
        rendererTag = SPAN::class
    }

    block()
}

inline fun <reified TT : CommonAttributeGroupFacade> RElementBuilder<Alert.Dismissible.Props>.closingElement(
    crossinline block: RHandler<Alert.Dismissible.ClosingElement.Props>
): ReactElement = child(Alert.Dismissible.ClosingElement::class) {
    attrs {
        this.rendererTag = TT::class
    }

    block()
}
