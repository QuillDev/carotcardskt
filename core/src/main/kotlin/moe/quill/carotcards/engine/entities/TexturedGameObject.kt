package moe.quill.carotcards.engine.entities

import moe.quill.carotcards.engine.renderer.CSprite
import moe.quill.carotcards.engine.renderer.sprites.SpriteRenderer

abstract class TexturedGameObject(
    val sprite: CSprite
    ) : GameObject() {
    fun draw(renderer: SpriteRenderer) {
        renderer.draw(sprite)
    }
}