package moe.quill.carotcards.engine.tiles

import com.badlogic.gdx.math.Vector3
import moe.quill.carotcards.engine.entities.TexturedGameObject
import moe.quill.carotcards.engine.renderer.CSprite
import moe.quill.carotcards.engine.renderer.sprite

abstract class Tile(sprite: CSprite) : TexturedGameObject(sprite), Cloneable

enum class Tiles(private val supplier: (Vector3) -> Tile) {
    DIRT({ pos -> GenericTile(sprite("dirt", pos)) })
    ;

    fun spawn(loc: Vector3 = Vector3()): Tile {
        return supplier(loc)
    }
}

fun spawnTileByName(name: String, loc: Vector3 = Vector3()): Tile? {
    return Tiles.values().firstOrNull { it.name == name }?.spawn(loc)
}