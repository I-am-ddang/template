package com.ddang_.template.managers

import com.ddang_.template.inits.Initable
import com.ddang_.template.inits.enable.LoadMembersInit

/**
 * Initable 을 구현하는 클래스를 관리하기 위한 Manager 클래스
 */
object InitManager {

    private val taskOnLoad = arrayOf<Initable>(

    )

    private val taskOnEnable = arrayOf<Initable>(
        LoadMembersInit
    )

    private val taskOnDisable = arrayOf<Initable>(

    )

    /**
     * 메인 클래스의 onLoad 때 수행할 작업을 동작시킴
     */
    fun load() {
        for (task in taskOnLoad) {
            task.run()
        }
    }

    /**
     * 메인 클래스의 onEnable 때 수행할 작업을 동작시킴
     */
    fun enable() {
        for (task in taskOnEnable) {
            task.run()
        }
    }

    /**
     * 메인 클래스의 onDisable 때 수행할 작업을 동작시킴
     */
    fun disable() {
        for (task in taskOnDisable) {
            task.run()
        }
    }
}