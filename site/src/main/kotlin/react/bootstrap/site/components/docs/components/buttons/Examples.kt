package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.p

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle()
        p {
            +"""
Bootstrap includes several predefined button styles, each serving its own semantic purpose, with a few extras thrown in
for more control.
            """
        }
        liveExample {
            Buttons.solid.danger { +Button.Variants.Solid.DANGER::class.normalName }
            +" "
            Buttons.solid.dark { +Button.Variants.Solid.DARK::class.normalName }
            +" "
            Buttons.solid.info { +Button.Variants.Solid.INFO::class.normalName }
            +" "
            Buttons.solid.light { +Button.Variants.Solid.LIGHT::class.normalName }
            +" "
            Buttons.solid.link { +Button.Variants.Solid.LINK::class.normalName }
            +" "
            Buttons.solid.primary { +Button.Variants.Solid.PRIMARY::class.normalName }
            +" "
            Buttons.solid.secondary { +Button.Variants.Solid.SECONDARY::class.normalName }
            +" "
            Buttons.solid.success { +Button.Variants.Solid.SUCCESS::class.normalName }
            +" "
            Buttons.solid.warning { +Button.Variants.Solid.WARNING::class.normalName }
            +" "
        }

        codeExample {
            +Imports.builder()
                .importButtonsBuilder()
                .build()

            mapOf(
                solidDangerFun to Button.Variants.Solid.DANGER,
                solidDarkFun to Button.Variants.Solid.DARK,
                solidInfoFun to Button.Variants.Solid.INFO,
                solidLightFun to Button.Variants.Solid.LIGHT,
                solidLinkFun to Button.Variants.Solid.LINK,
                solidPrimaryFun to Button.Variants.Solid.PRIMARY,
                solidSecondaryFun to Button.Variants.Solid.SECONDARY,
                solidSuccessFun to Button.Variants.Solid.SUCCESS,
                solidWarningFun to Button.Variants.Solid.WARNING
            ).forEach {
                +FunCall.builder(it.key, FunCall.Style.NEW_INLINE)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::solid)
                    .setLambdaArgument(plusString(it.value::class.normalName))
                    .build()
                appendLine(plusString(" "))
            }
        }
    }
}
