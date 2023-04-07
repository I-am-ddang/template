package com.ddang_.template.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage

/**
 * Component 와 관련된 메소드를 담아두기 위한 Util 클래스
 */
object ComponentUtil {
    const val COLOR_DARK_RED = "aa0000"
    const val COLOR_LIME = "55ff55"
    const val COLOR_WHITE = "ffffff"
    const val COLOR_LIGHT_GRAY = "aaaaaa"
    const val COLOR_YELLOW = "ffff55"
    const val COLOR_DARK_AQUA = "00aaaa"
    const val COLOR_DARK_PURPLE = "aa00aa"
    const val COLOR_GOLD = "ffaa00"
    const val COLOR_GRAY = "555555"
    const val COLOR_BLUE = "5555ff"
    const val COLOR_AQUA = "55ffff"
    const val COLOR_RED = "ff5555"
    const val COLOR_PINK = "ff55ff"
    const val COLOR_BLACK = "000000"

    /**
     * 특정 RGB 값을 가진 텍스트 컴포넌트를 만듦
     * @param text 글
     * @param hex 색상
     * @param bold 굵기 여부
     * @return 특정 RGB 값을 가진 텍스트 컴포넌트
     */
    fun toText(text: String, hex: String = "ffffff", bold: Boolean = false): Component {
        hex.replace("#", "")

        val componentText = Component.text(text, TextColor.fromHexString("#${hex}"))
            .decoration(TextDecoration.ITALIC, false)

        return if (bold) {componentText.decorate(TextDecoration.BOLD)} else { componentText }
    }

    /**
     * 두 RGB 값 사이를 그라디언트 효과를 넣어 텍스트 컴포넌트를 만듦
     * @param text 글
     * @param hexStart 시작 색상
     * @param hexEnd 끝 색상
     * @param bold 굵기 여부
     * @return 두 RGB 값 사이를 그라디언트 효과를 넣어 만들어진 텍스트 컴포넌트
     */
    fun toGradient(text: String, hexStart: String, hexEnd: String, bold: Boolean = false): Component {

        hexStart.replace("#", "")
        hexEnd.replace("#", "")

        val gradientText = MiniMessage.miniMessage().deserialize("<gradient:#${hexStart}:#${hexEnd}>${text}</gradient>")
            .decoration(TextDecoration.ITALIC, false)

        return if (bold) {
            gradientText.decorate(TextDecoration.BOLD)
        } else {
            gradientText
        }
    }
}