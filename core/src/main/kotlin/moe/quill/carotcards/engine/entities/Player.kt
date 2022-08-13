package moe.quill.carotcards.engine.entities

import com.badlogic.gdx.Input
import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.WORLD_UNIT
import moe.quill.carotcards.engine.renderer.CSprite
import moe.quill.carotcards.engine.renderer.sprite
import moe.quill.carotcards.engine.textures.TextureLibrary
import moe.quill.carotcards.engine.extensions.deltaTime
import moe.quill.carotcards.engine.extensions.keyPressed

const val WORLD_UNITS_PER_SECOND = 2 * WORLD_UNIT
class Player : TexturedGameObject(sprite("chick")) {

    private fun handleMovement() {
        val delta = deltaTime()
        if(keyPressed(Input.Keys.W)) {
            sprite.position.y += WORLD_UNITS_PER_SECOND * delta
        }
        if(keyPressed(Input.Keys.S)) {
            sprite.position.y -= WORLD_UNITS_PER_SECOND * delta
        }
        if(keyPressed(Input.Keys.A)) {
            sprite.position.x -= WORLD_UNITS_PER_SECOND * delta
        }
        if(keyPressed(Input.Keys.D)) {
            sprite.position.x += WORLD_UNITS_PER_SECOND * delta
        }
    }

    override fun update() {
        handleMovement()
    }
}