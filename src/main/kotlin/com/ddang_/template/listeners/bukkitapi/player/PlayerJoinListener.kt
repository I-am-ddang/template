package com.ddang_.template.listeners.bukkitapi.player

import com.ddang_.template.Template
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object PlayerJoinListener: Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player

        Template.templateCore.memberManager.load(player)
    }
}