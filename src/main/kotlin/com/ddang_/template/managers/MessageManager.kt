package com.ddang_.template.managers

import com.ddang_.template.utils.ComponentUtil
import net.kyori.adventure.text.Component

/**
 * 주요 Message 를 관리하기 위한 Manager 클래스
 */
object MessageManager {

    val prefix = Component.text().append(
        ComponentUtil.toText("  [ ", "dad7cd"),
        ComponentUtil.toGradient("Sen", "a3b18a", "588157"),
        ComponentUtil.toGradient("ti", "588157", "3a5a40"),
        ComponentUtil.toGradient("nel", "3a5a40", "344e41"),
        ComponentUtil.toText(" ]", "344e41")
    ).build()

}