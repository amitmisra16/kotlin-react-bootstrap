@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.Tag
import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.AlertBuilder
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.h1
import react.bootstrap.components.alert.h2
import react.bootstrap.components.alert.h3
import react.bootstrap.components.alert.h4
import react.bootstrap.components.alert.h5
import react.bootstrap.components.alert.h6
import react.bootstrap.components.alert.heading
import react.bootstrap.components.alert.link
import react.bootstrap.content.typography.Headings
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.p
import kotlin.reflect.KFunction

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle()
        mapOf(
            Alert.Variants.DANGER to Alerts::danger,
            Alert.Variants.DARK to Alerts::dark,
            Alert.Variants.INFO to Alerts::info,
            Alert.Variants.LIGHT to Alerts::light,
            Alert.Variants.PRIMARY to Alerts::primary,
            Alert.Variants.SECONDARY to Alerts::secondary,
            Alert.Variants.SUCCESS to Alerts::success,
            Alert.Variants.WARNING to Alerts::warning
        ).forEach { (variant, function) ->
            val variantName = variant::class.simpleName!!.toLowerCase().capitalize()
            subSectionTitle(function.name)
            p {
                +"Adds an alert component with the $variantName context."
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RHandler", Alert.Props::class))
                    .returns("ReactElement")
                    .build()
                +"\n"
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .nestedBy(AlertBuilder::dismissible)
                    .addParameter("fade", false)
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RHandler", Alert.Dismissible.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }

        subSectionTitle(RElementBuilder<Alert.Props>::link.name)
        Markdown {
            //language=Markdown
            +"""
Adds `${ClassNames.ALERT_LINK.nestedName}` to the outer most `ReactElement` resulting from `block`.
            """
        }
        codeExample {
            +FunSpec.builder(RElementBuilder<Alert.Props>::link, false)
                .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                .addParameter("block", "ElementProvider")
                .returns("ReactElement")
                .build()
        }
        subSectionTitle(RElementBuilder<Alert.Props>::heading.name)
        Markdown {
            //language=Markdown
            +"""
Adds `${ClassNames.ALERT_HEADING.nestedName}` to the outer most `ReactElement` resulting from `block`.
            """
        }
        codeExample {
            +FunSpec.builder(RElementBuilder<Alert.Props>::heading, false)
                .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                .addParameter<Headings>("headings")
                .addParameter("block", "ElementProvider")
                .returns("ReactElement")
                .build()
        }
        listOf(
            RElementBuilder<Alert.Props>::h1,
            RElementBuilder<Alert.Props>::h2,
            RElementBuilder<Alert.Props>::h3,
            RElementBuilder<Alert.Props>::h4,
            RElementBuilder<Alert.Props>::h5,
            RElementBuilder<Alert.Props>::h6,
        ).forEach { function ->
            subSectionTitle(function.name)
            Markdown {
                //language=Markdown
                +"""
Custom `${function.name}` which behaves the same but adds `${ClassNames.ALERT_HEADING.nestedName}` to `classes`.
            """
            }
            codeExample {
                +FunSpec.builder(function, false)
                    .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RDOMHandler", function.name.toUpperCase()))
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle("closingElement")
        p {
            +"Wrapper for a custom alert closing element."
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "closingElement"
                }
            )
                .nestedByGeneric<RElementBuilder<*>, Alert.Dismissible.Props>()
                .addParameter("block", Generic("RHandler", Alert.Dismissible.ClosingElement.Props::class))
                .returns("ReactElement")
                .build()
            +"\n"
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "closingElement"
                }
            )
                .nestedByGeneric<RElementBuilder<*>, Alert.Dismissible.Props>()
                .addTypeParameter("TT", Tag::class, true)
                .addParameter("block", Generic("RHandler", Alert.Dismissible.ClosingElement.Props::class))
                .returns("ReactElement")
                .build()
        }
    }
}
