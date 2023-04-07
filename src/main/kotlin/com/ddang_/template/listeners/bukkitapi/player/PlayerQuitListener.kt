package com.ddang_.template.listeners.bukkitapi.player

import com.ddang_.template.Template
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

object PlayerQuitListener: Listener {
    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        val player = e.player

        Template.templateCore.memberManager.unload(player)
    }
}