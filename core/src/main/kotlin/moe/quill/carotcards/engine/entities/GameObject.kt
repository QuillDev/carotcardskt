package moe.quill.carotcards.engine.entities

import java.util.UUID

abstract class GameObject() {

    val uuid = UUID.randomUUID()

    init {
        register()
    }

    open fun update() {

    }

    private fun register() {
        EntitySystem.add(this)
    }
}