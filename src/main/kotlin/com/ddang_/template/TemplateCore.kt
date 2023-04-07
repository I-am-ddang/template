package com.ddang_.template

import com.ddang_.template.managers.InitManager
import com.ddang_.template.managers.ListenerManager
import com.ddang_.template.managers.MemberManager
import com.ddang_.template.managers.MessageManager
import org.bukkit.plugin.java.JavaPlugin

/**
 * manager 객체를 하나로 관리하며, 메인 클래스의 onLoad, onEnable, onDisable 단의 작업을 수행하기 위한 클래스
 */
object TemplateCore {

    val initManager = InitManager
    val listenerManager = ListenerManager
    val memberManager = MemberManager
    val messageManager = MessageManager

    /**
     * 메인 클래스 onLoad 에 들어가는 모든 작업을 수행
     * @param plugin 메인 클래스 플러그인 인스턴스
     */
    fun load(plugin: JavaPlugin) {
        Template.instance = plugin
        Template.scheduler = plugin.server.scheduler
        Template.players = plugin.server.onlinePlayers

        initManager.load()
    }

    /**
     * 메인 클래스 onEnable 에 들어가는 모든 작업을 수행
     * @param plugin 메인 클래스 플러그인 인스턴스
     */
    fun enable(plugin: JavaPlugin) {
        listenerManager.registerListener(plugin)

        initManager.enable()
    }

    /**
     * 메인 클래스 onDisable 에 들어가는 모든 작업을 수행
     * @param plugin 메인 클래스 플러그인 인스턴스
     */
    fun disable(plugin: JavaPlugin) {
        initManager.disable()
    }
}