package moe.quill.carotcards.renderer.sprites

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import moe.quill.carotcards.renderer.CSprite

class OrderedSpriteRenderer : SpriteRenderer {

    override val batch = SpriteBatch()
    private val spriteQueue = mutableSetOf<CSprite>()

    override fun begin() {
        batch.begin()
        spriteQueue.clear()
    }

    override fun draw(sprite: CSprite) {
        spriteQueue += sprite
    }


    override fun end() {
        spriteQueue.sortedBy { it.position.z }.forEach { it.draw(batch) }
        batch.end()
    }
}