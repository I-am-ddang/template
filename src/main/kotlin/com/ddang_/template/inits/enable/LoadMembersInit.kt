package com.ddang_.template.inits.enable

import com.ddang_.template.Template
import com.ddang_.template.inits.Initable
import com.ddang_.template.managers.MemberManager

/**
 * 플러그인이 로드될 때 서버에 접속한 모든 플레이어의 Member 객체를 생성하기 위한 Init 클래스
 */
object  LoadMembersInit: Initable {
    override fun run() {
        Template.players.forEach {
            MemberManager.load(it)
        }
    }
}