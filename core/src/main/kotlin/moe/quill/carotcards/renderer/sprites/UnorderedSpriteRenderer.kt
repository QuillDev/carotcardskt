package moe.quill.carotcards.renderer.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.renderer.CSprite

class UnorderedSpriteRenderer : SpriteRenderer {
    override val batch = SpriteBatch()

    override fun begin() {
        batch.begin()
    }

    override fun draw(sprite: CSprite) {
        sprite.draw(batch)
    }

    override fun end() {
        batch.end()
    }

}