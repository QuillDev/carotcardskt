package moe.quill.carotcards.engine.tiles

import com.badlogic.gdx.Gdx
import moe.quill.carotcards.WORLD_UNIT
import java.nio.file.Path

class TileSet {
    val tiles: List<List<Tile?>> = mutableListOf()
}

fun loadTileSet(name: String) {
    val tilePath = Gdx.files.internal(Path.of(name, "maps", name).toString())

    tilePath.readString().split("\n").forEachIndexed { rowIdx, row ->
        row.split(",").forEachIndexed { colIdx, tileName ->
            val tile = spawnTileByName(tileName)
            tile?.sprite?.position?.apply {
                x = colIdx * WORLD_UNIT
                y = rowIdx * WORLD_UNIT
            }
        }
    }
}