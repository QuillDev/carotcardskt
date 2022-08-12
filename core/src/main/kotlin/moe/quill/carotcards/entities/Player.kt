package moe.quill.carotcards.entities

import com.badlogic.gdx.Input
import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.WORLD_UNIT
import moe.quill.carotcards.renderer.CSprite
import moe.quill.carotcards.textures.TextureLibrary
import moe.quill.carotcards.utils.extensions.deltaTime
import moe.quill.carotcards.utils.extensions.keyPressed

const val WORLD_UNITS_PER_SECOND = 2 * WORLD_UNIT
class Player : TexturedGameObject(
    CSprite(TextureLibrary.getTexture("chick")),
    Vector3()
) {

    private fun handleMovement() {
        val delta = deltaTime()
        if(keyPressed(Input.Keys.W)) {
            position.y += WORLD_UNITS_PER_SECOND * delta
        }
        if(keyPressed(Input.Keys.S)) {
            position.y -= WORLD_UNITS_PER_SECOND * delta
        }
        if(keyPressed(Input.Keys.A)) {
            position.x -= WORLD_UNITS_PER_SECOND * delta
        }
        if(keyPressed(Input.Keys.D)) {
            position.x += WORLD_UNITS_PER_SECOND * delta
        }
    }

    override fun update() {
        handleMovement()
        sprite.position.set(position)
    }
}