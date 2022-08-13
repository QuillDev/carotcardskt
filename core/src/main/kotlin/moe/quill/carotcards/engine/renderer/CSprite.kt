package moe.quill.carotcards.engine.renderer

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.engine.textures.TextureLibrary

class CSprite(val texture: Texture, val position: Vector3 = Vector3(), var visible: Boolean = true) {
    fun draw(batch: SpriteBatch) {
        if(!visible) return
        batch.draw(texture, position.x, position.y)
    }
}

fun sprite(name: String, pos: Vector3 = Vector3()) = CSprite(TextureLibrary.getTexture(name), pos)