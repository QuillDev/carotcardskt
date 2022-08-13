package moe.quill.carotcards.engine.entities

import moe.quill.carotcards.engine.renderer.sprites.SpriteRenderer

object EntitySystem {

    private val entities = mutableSetOf<GameObject>()

    fun add(gameObject: GameObject) {
        entities.add(gameObject)
    }

    fun destroy(gameObject: GameObject) {
        entities.remove(gameObject)
    }

    fun render(renderer: SpriteRenderer) {
        entities.forEach { sprite ->
            (sprite as? TexturedGameObject)?.draw(renderer)
        }
    }

    fun update() {
        entities.forEach { it.update() }
    }
}