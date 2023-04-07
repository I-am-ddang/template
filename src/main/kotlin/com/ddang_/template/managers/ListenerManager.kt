package com.ddang_.template.managers

import com.ddang_.template.listeners.bukkitapi.player.PlayerJoinListener
import com.ddang_.template.listeners.bukkitapi.player.PlayerQuitListener
import org.bukkit.plugin.java.JavaPlugin

/**
 * Listener 클래스를 관리하기 위한 Manager 클래스
 */
object ListenerManager {

    val bukkitAPIArray = arrayOf(

        //  player
        PlayerJoinListener,
        PlayerQuitListener
    )

    /**
     * EventListener 클래스 모두를 서버에 등록하기 위한 메소드
     *
     * @param plugin 메인 클래스 플러그인 인스턴스
     */
    fun registerListener(plugin: JavaPlugin) {
        plugin.server.pluginManager.apply {
            bukkitAPIArray.forEach {
                registerEvents(it, plugin)
            }
        }
    }
}