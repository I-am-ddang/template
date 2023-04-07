package com.ddang_.template.classes

import com.ddang_.template.managers.MemberManager
import java.util.*

class Member (val name: String, val uniqueId: UUID) {

    init {
        MemberManager.memberList.add(this)
    }
}