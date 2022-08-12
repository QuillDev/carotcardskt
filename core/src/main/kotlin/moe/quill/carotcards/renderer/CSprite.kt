package moe.quill.carotcards.renderer

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3

class CSprite(val texture: Texture, val position: Vector3 = Vector3(), var visible: Boolean = true) {
    fun draw(batch: SpriteBatch) {
        if(!visible) return
        batch.draw(texture, position.x, position.y)
    }
}