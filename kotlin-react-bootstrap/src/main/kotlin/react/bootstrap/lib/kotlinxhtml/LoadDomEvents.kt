@file:Suppress("DuplicatedCode")

package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.js.onAbortFunction
import kotlinx.html.js.onBlurFunction
import kotlinx.html.js.onCanPlayFunction
import kotlinx.html.js.onCanPlayThroughFunction
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onContextMenuFunction
import kotlinx.html.js.onDoubleClickFunction
import kotlinx.html.js.onDragEndFunction
import kotlinx.html.js.onDragEnterFunction
import kotlinx.html.js.onDragFunction
import kotlinx.html.js.onDragLeaveFunction
import kotlinx.html.js.onDragOverFunction
import kotlinx.html.js.onDragStartFunction
import kotlinx.html.js.onDropFunction
import kotlinx.html.js.onDurationChangeFunction
import kotlinx.html.js.onEmptiedFunction
import kotlinx.html.js.onEndedFunction
import kotlinx.html.js.onErrorFunction
import kotlinx.html.js.onFocusFunction
import kotlinx.html.js.onInputFunction
import kotlinx.html.js.onInvalidFunction
import kotlinx.html.js.onKeyDownFunction
import kotlinx.html.js.onKeyPressFunction
import kotlinx.html.js.onKeyUpFunction
import kotlinx.html.js.onLoadFunction
import kotlinx.html.js.onLoadStartFunction
import kotlinx.html.js.onLoadedDataFunction
import kotlinx.html.js.onMouseDownFunction
import kotlinx.html.js.onMouseMoveFunction
import kotlinx.html.js.onMouseOutFunction
import kotlinx.html.js.onMouseOverFunction
import kotlinx.html.js.onMouseUpFunction
import kotlinx.html.js.onPauseFunction
import kotlinx.html.js.onPlayFunction
import kotlinx.html.js.onPlayingFunction
import kotlinx.html.js.onProgressFunction
import kotlinx.html.js.onRateChangeFunction
import kotlinx.html.js.onScrollFunction
import kotlinx.html.js.onSeekedFunction
import kotlinx.html.js.onSeekingFunction
import kotlinx.html.js.onSelectFunction
import kotlinx.html.js.onStalledFunction
import kotlinx.html.js.onSubmitFunction
import kotlinx.html.js.onSuspendFunction
import kotlinx.html.js.onTimeUpdateFunction
import kotlinx.html.js.onTouchCancelFunction
import kotlinx.html.js.onTouchEndFunction
import kotlinx.html.js.onTouchMoveFunction
import kotlinx.html.js.onTouchStartFunction
import kotlinx.html.js.onVolumeChangeFunction
import kotlinx.html.js.onWaitingFunction
import kotlinx.html.js.onWheelFunction
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.react.rprops.WithDomEvents
import kotlin.reflect.KProperty

fun CommonAttributeGroupFacade.loadDomEvents(props: WithDomEvents, vararg excludes: KProperty<EventHandler?>) {
    if (props::onAbort !in excludes) {
        props.onAbort?.let { onAbortFunction = it }
    }
    if (props::onAnimationEnd !in excludes) {
        props.onAnimationEnd?.let { onAnimationEndFunction = it }
    }
    if (props::onAnimationIteration !in excludes) {
        props.onAnimationIteration?.let { onAnimationIterationFunction = it }
    }
    if (props::onAnimationStart !in excludes) {
        props.onAnimationStart?.let { onAnimationStartFunction = it }
    }
    if (props::onBlur !in excludes) {
        props.onBlur?.let { onBlurFunction = it }
    }
    if (props::onCanPlay !in excludes) {
        props.onCanPlay?.let { onCanPlayFunction = it }
    }
    if (props::onCanPlayThrough !in excludes) {
        props.onCanPlayThrough?.let { onCanPlayThroughFunction = it }
    }
    if (props::onChange !in excludes) {
        props.onChange?.let { onChangeFunction = it }
    }
    if (props::onClick !in excludes) {
        props.onClick?.let { onClickFunction = it }
    }
    if (props::onCompositionEnd !in excludes) {
        props.onCompositionEnd?.let { onCompositionEndFunction = it }
    }
    if (props::onCompositionStart !in excludes) {
        props.onCompositionStart?.let { onCompositionStartFunction = it }
    }
    if (props::onCompositionUpdate !in excludes) {
        props.onCompositionUpdate?.let { onCompositionUpdateFunction = it }
    }
    if (props::onContextMenu !in excludes) {
        props.onContextMenu?.let { onContextMenuFunction = it }
    }
    if (props::onCopy !in excludes) {
        props.onCopy?.let { onCopyFunction = it }
    }
    if (props::onCut !in excludes) {
        props.onCut?.let { onCutFunction = it }
    }
    if (props::onDoubleClick !in excludes) {
        props.onDoubleClick?.let { onDoubleClickFunction = it }
    }
    if (props::onDrag !in excludes) {
        props.onDrag?.let { onDragFunction = it }
    }
    if (props::onDragEnd !in excludes) {
        props.onDragEnd?.let { onDragEndFunction = it }
    }
    if (props::onDragEnter !in excludes) {
        props.onDragEnter?.let { onDragEnterFunction = it }
    }
    if (props::onDragExit !in excludes) {
        props.onDragExit?.let { onDragExitFunction = it }
    }
    if (props::onDragLeave !in excludes) {
        props.onDragLeave?.let { onDragLeaveFunction = it }
    }
    if (props::onDragOver !in excludes) {
        props.onDragOver?.let { onDragOverFunction = it }
    }
    if (props::onDragStart !in excludes) {
        props.onDragStart?.let { onDragStartFunction = it }
    }
    if (props::onDrop !in excludes) {
        props.onDrop?.let { onDropFunction = it }
    }
    if (props::onDurationChange !in excludes) {
        props.onDurationChange?.let { onDurationChangeFunction = it }
    }
    if (props::onEmptied !in excludes) {
        props.onEmptied?.let { onEmptiedFunction = it }
    }
    if (props::onEncrypted !in excludes) {
        props.onEncrypted?.let { onEncryptedFunction = it }
    }
    if (props::onEnded !in excludes) {
        props.onEnded?.let { onEndedFunction = it }
    }
    if (props::onError !in excludes) {
        props.onError?.let { onErrorFunction = it }
    }
    if (props::onFocus !in excludes) {
        props.onFocus?.let { onFocusFunction = it }
    }
    if (props::onGotPointerCapture !in excludes) {
        props.onGotPointerCapture?.let { onGotPointerCaptureFunction = it }
    }
    if (props::onInput !in excludes) {
        props.onInput?.let { onInputFunction = it }
    }
    if (props::onInvalid !in excludes) {
        props.onInvalid?.let { onInvalidFunction = it }
    }
    if (props::onKeyDown !in excludes) {
        props.onKeyDown?.let { onKeyDownFunction = it }
    }
    if (props::onKeyPress !in excludes) {
        props.onKeyPress?.let { onKeyPressFunction = it }
    }
    if (props::onKeyUp !in excludes) {
        props.onKeyUp?.let { onKeyUpFunction = it }
    }
    if (props::onLoad !in excludes) {
        props.onLoad?.let { onLoadFunction = it }
    }
    if (props::onLoadedData !in excludes) {
        props.onLoadedData?.let { onLoadedDataFunction = it }
    }
    if (props::onLoadedMetadata !in excludes) {
        props.onLoadedMetadata?.let { onLoadedMetadataFunction = it }
    }
    if (props::onLoadStart !in excludes) {
        props.onLoadStart?.let { onLoadStartFunction = it }
    }
    if (props::onLostPointerCapture !in excludes) {
        props.onLostPointerCapture?.let { onLostPointerCaptureFunction = it }
    }
    if (props::onMouseDown !in excludes) {
        props.onMouseDown?.let { onMouseDownFunction = it }
    }
    if (props::onMouseEnter !in excludes) {
        props.onMouseEnter?.let { onMouseEnterFunction = it }
    }
    if (props::onMouseLeave !in excludes) {
        props.onMouseLeave?.let { onMouseLeaveFunction = it }
    }
    if (props::onMouseMove !in excludes) {
        props.onMouseMove?.let { onMouseMoveFunction = it }
    }
    if (props::onMouseOut !in excludes) {
        props.onMouseOut?.let { onMouseOutFunction = it }
    }
    if (props::onMouseOver !in excludes) {
        props.onMouseOver?.let { onMouseOverFunction = it }
    }
    if (props::onMouseUp !in excludes) {
        props.onMouseUp?.let { onMouseUpFunction = it }
    }
    if (props::onPaste !in excludes) {
        props.onPaste?.let { onPasteFunction = it }
    }
    if (props::onPause !in excludes) {
        props.onPause?.let { onPauseFunction = it }
    }
    if (props::onPlay !in excludes) {
        props.onPlay?.let { onPlayFunction = it }
    }
    if (props::onPlaying !in excludes) {
        props.onPlaying?.let { onPlayingFunction = it }
    }
    if (props::onPointerCancel !in excludes) {
        props.onPointerCancel?.let { onPointerCancelFunction = it }
    }
    if (props::onPointerDown !in excludes) {
        props.onPointerDown?.let { onPointerDownFunction = it }
    }
    if (props::onPointerEnter !in excludes) {
        props.onPointerEnter?.let { onPointerEnterFunction = it }
    }
    if (props::onPointerLeave !in excludes) {
        props.onPointerLeave?.let { onPointerLeaveFunction = it }
    }
    if (props::onPointerMove !in excludes) {
        props.onPointerMove?.let { onPointerMoveFunction = it }
    }
    if (props::onPointerOut !in excludes) {
        props.onPointerOut?.let { onPointerOutFunction = it }
    }
    if (props::onPointerOver !in excludes) {
        props.onPointerOver?.let { onPointerOverFunction = it }
    }
    if (props::onPointerUp !in excludes) {
        props.onPointerUp?.let { onPointerUpFunction = it }
    }
    if (props::onProgress !in excludes) {
        props.onProgress?.let { onProgressFunction = it }
    }
    if (props::onRateChange !in excludes) {
        props.onRateChange?.let { onRateChangeFunction = it }
    }
    if (props::onReset !in excludes) {
        props.onReset?.let { onResetFunction = it }
    }
    if (props::onScroll !in excludes) {
        props.onScroll?.let { onScrollFunction = it }
    }
    if (props::onSeeked !in excludes) {
        props.onSeeked?.let { onSeekedFunction = it }
    }
    if (props::onSeeking !in excludes) {
        props.onSeeking?.let { onSeekingFunction = it }
    }
    if (props::onSelect !in excludes) {
        props.onSelect?.let { onSelectFunction = it }
    }
    if (props::onStalled !in excludes) {
        props.onStalled?.let { onStalledFunction = it }
    }
    if (props::onSubmit !in excludes) {
        props.onSubmit?.let { onSubmitFunction = it }
    }
    if (props::onSuspend !in excludes) {
        props.onSuspend?.let { onSuspendFunction = it }
    }
    if (props::onTimeUpdate !in excludes) {
        props.onTimeUpdate?.let { onTimeUpdateFunction = it }
    }
    if (props::onToggle !in excludes) {
        props.onToggle?.let { onToggleFunction = it }
    }
    if (props::onTouchCancel !in excludes) {
        props.onTouchCancel?.let { onTouchCancelFunction = it }
    }
    if (props::onTouchEnd !in excludes) {
        props.onTouchEnd?.let { onTouchEndFunction = it }
    }
    if (props::onTouchMove !in excludes) {
        props.onTouchMove?.let { onTouchMoveFunction = it }
    }
    if (props::onTouchStart !in excludes) {
        props.onTouchStart?.let { onTouchStartFunction = it }
    }
    if (props::onTransitionEnd !in excludes) {
        props.onTransitionEnd?.let { onTransitionEndFunction = it }
    }
    if (props::onVolumeChange !in excludes) {
        props.onVolumeChange?.let { onVolumeChangeFunction = it }
    }
    if (props::onWaiting !in excludes) {
        props.onWaiting?.let { onWaitingFunction = it }
    }
    if (props::onWheel !in excludes) {
        props.onWheel?.let { onWheelFunction = it }
    }
}
