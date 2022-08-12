package moe.quill.carotcards.entities

import com.badlogic.gdx.math.Vector3
import java.util.UUID

abstract class GameObject(val position: Vector3) {

    val uuid = UUID.randomUUID()

    init {
        register()
    }

    abstract fun update()

    private fun register() {
        EntitySystem.add(this)
    }
}