package com.ddang_.template

import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class Template : JavaPlugin() {

    companion object {
        val templateCore = TemplateCore

        lateinit var instance: Plugin

        lateinit var scheduler: BukkitScheduler

        lateinit var players: MutableCollection<out Player>
    }

    override fun onLoad() {
        templateCore.load(this)
    }

    override fun onEnable() {
        templateCore.enable(this)
    }

    override fun onDisable() {
        templateCore.disable(this)
    }
}