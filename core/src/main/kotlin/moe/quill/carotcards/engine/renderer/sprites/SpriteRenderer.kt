package moe.quill.carotcards.engine.renderer.sprites

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import moe.quill.carotcards.engine.renderer.CSprite

interface SpriteRenderer {

    val batch: SpriteBatch

    fun begin()
    fun draw(sprite: CSprite)
    fun end()
}