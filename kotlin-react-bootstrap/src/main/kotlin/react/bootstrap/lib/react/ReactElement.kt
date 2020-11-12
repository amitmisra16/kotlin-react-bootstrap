package react.bootstrap.lib.react

import react.ReactElement

/**
 * The type of this element.
 * For DOM components, this will be a String tagName (e.g., 'div', 'a').
 * For composite components (react-dart or pure JS), this will be a ReactClass.
 */
private val ReactElement.type: dynamic
    get() = asDynamic().type

@Suppress("UnsafeCastFromDynamic")
val ReactElement.tagName: String?
    get() = if (type is String) {
        type
    } else {
        null
    }

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
val ReactElement.componentJsClass: JsClass<*>?
    get() = if (type !is String) {
        type as JsClass<*>
    } else {
        null
    }