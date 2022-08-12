package moe.quill.carotcards.entities

import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.renderer.CSprite
import moe.quill.carotcards.renderer.sprites.SpriteRenderer

abstract class TexturedGameObject(val sprite: CSprite, position: Vector3): GameObject(position) {

    fun draw(renderer: SpriteRenderer) {
        renderer.draw(sprite)
    }
}