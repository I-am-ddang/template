package com.ddang_.template.utils

import com.ddang_.template.Template
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitTask

/**
 * 리시버 모아두는 클래스
 */
object ReceiverUtil {
    /**
     * 입력 받은 문자열을 콘솔창에 남기기 위한 리시버. 정보 (하얀 줄) 유형으로 남김
     */
    fun String.info() = Bukkit.getLogger().info(this)

    /**
     * 입력 받은 문자열을 콘솔창에 남기기 위한 리시버. 주의 (노란 줄) 유형으로 남김
     */
    fun String.warn() = Bukkit.getLogger().warning(this)

    /**
     * 입력 받은 문자열을 서버 전체에 알리기 위한 리시버. Deprecated 이므로 디버그 용으로만 사용을 권장
     */
    fun String.broad() = Bukkit.broadcastMessage(this)

    /**
     * 입력 받은 컴포넌트를 서버 전체에 알리기 위한 리시버
     */
    fun Component.broad() = Bukkit.broadcast(this)

    /**
     * 동기로 작업을 주기적으로 실행하기 위한 리시버
     */
    fun Number.runTimer(run: BukkitTask.() -> Unit) = Template.scheduler.runTaskTimer(Template.instance, run, 0, this.toLong())

    /**
     * 비동기로 작업을 주기적으로 실행하기 위한 리시버
     */
    fun Number.runTimerAsync(run: BukkitTask.() -> Unit) = Template.scheduler
        .runTaskTimerAsynchronously(Template.instance, run, 0, this.toLong())

    /**
     * 동기로 작업을 실행하기 위한 리시버. 주로 패킷 라이브러리에서 버킷 api 로 넘길 때 사용 (커스텀 이벤트 같은 경우에 해당)
     */
    fun run(run: Runnable) = Template.scheduler.runTask(Template.instance, run)

    /**
     * 비동기로 작업을 실행하기 위한 리시버
     */
    fun runAsync(run: Runnable) = Template.scheduler.runTaskAsynchronously(Template.instance, run)

    /**
     * 동기로 일정 시간 뒤에 작업을 실행하기 위한 리시버
     */
    fun Number.runLater(run: Runnable) = Template.scheduler.runTaskLater(Template.instance, run, this.toLong())

    /**
     * 비동기로 일정 시간 뒤에 작업을 실행하기 위한 리시버
     */
    fun Number.runLaterAsync(run: Runnable) = Template.scheduler.runTaskLaterAsynchronously(Template.instance, run, this.toLong())

    /**
     * 두 컴포넌트를 하나로 합쳐주기 위한 infix 리시버
     */
    infix fun Component.with(next: Component): Component {
        return Component.text().append(
            this,
            next
        ).build()
    }
}