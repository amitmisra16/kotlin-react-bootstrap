package react.bootstrap.site.components.docs.layout.reference

import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.ContainerBuilder
import react.bootstrap.layout.grid.container.container
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class ContainersContainerBuilder : SectionComponent() {
    override val title: String = "Containers & ContainerBuilder"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::container.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Container::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::container)
                .nestedBy<RBuilder>()
                .addParameter<Container.Viscosities>("viscosity", null)
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Container.Props::class))
                .returns("ReactElement")
                .build()
        }

        listOf(
            ContainerBuilder::fluid,
            ContainerBuilder::sm,
            ContainerBuilder::md,
            ContainerBuilder::lg,
            ContainerBuilder::xl
        ).forEach { function ->
            subSectionTitle(function.name)
            val viscosity = Container.Viscosities.valueOf(function.name.toUpperCase())
            Markdown {
                //language=Markdown
                +"""
Creates a `${Container::class.nestedName}` element with `viscosity` set to `${viscosity.nestedName}`.
            """
            }
            codeExample {
                +FunSpec.builder(function, false)
                    .nestedBy<ContainerBuilder>()
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RHandler", Container.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}
