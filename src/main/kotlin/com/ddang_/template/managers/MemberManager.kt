package com.ddang_.template.managers

import com.ddang_.template.classes.Member
import org.bukkit.entity.Player
import java.util.*

/**
 * Member 클래스를 관리하기 위한 Manager 클래스
 */
object MemberManager {

    /**
     * 모든 Member 객체를 담아두는 arrayList 변수입니다.
     */
    val memberList = arrayListOf<Member>()

    /**
     * Member 객체를 구해옵니다.
     * @param name Member 객체를 구해올 플레이어의 이름입니다.
     * @return 해당하는 이름의 Member 객체가 있으면 Member 그 객체를 받아오고, 없으면 null 을 반환합니다.
     */
    fun getMember(name: String) = memberList.find { it.name == name }

    /**
     * Member 객체를 구해옵니다.
     * @param uniqueId Member 객체를 구해올 플레이어의 UUID 입니다.
     * @return 해당하는 UUID 의 Member 객체가 있으면 그 Member 객체를 받아오고, 없으면 null 을 반환합니다.
     */
    fun getMember(uniqueId: UUID) = memberList.find { it.uniqueId == uniqueId }

    /**
     * 플레이어를 매개변수로 받아 Member 객체를 생성합니다.
     * @param p Member 객체를 만들 플레이어 객체
     */
    fun load(p: Player) {

        if (getMember(p.name) != null) return
        if (getMember(p.uniqueId) != null) return

        Member(p.name, p.uniqueId)
    }

    /**
     * 플레이어를 매개변수로 받아 Member 객체를 memberList 에서 제거합니다.
     * @param p Member 객체를 지울 플레이어
     */
    fun unload(p: Player) {
        val m = getMember(p.name) ?: return

        memberList.remove(m)
    }
}