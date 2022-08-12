package moe.quill.carotcards.tiles

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.entities.TexturedGameObject
import moe.quill.carotcards.renderer.CSprite

abstract class Tile(val texture: Texture, val pos: Vector3) : TexturedGameObject(CSprite(texture), pos){

    init {}
}