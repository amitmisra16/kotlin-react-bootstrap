package react.bootstrap.site.components.docs.content.reference

import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.lead.Lead
import react.bootstrap.content.typography.lead.lead
import react.bootstrap.content.typography.mark.Mark
import react.bootstrap.content.typography.muted.Muted
import react.bootstrap.content.typography.small.Small
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import kotlin.reflect.KFunction

internal class Other : SectionComponent() {
    override val title: String = "Other"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::lead.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Lead::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::lead)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Lead.Props::class))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("muted")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Muted::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "muted"
                }
            )
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Muted.Props::class))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("mark")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Mark::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "mark"
                }
            )
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Mark.Props::class))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("small")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Small::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "small"
                }
            )
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Small.Props::class))
                .returns("ReactElement")
                .build()
        }
    }
}
