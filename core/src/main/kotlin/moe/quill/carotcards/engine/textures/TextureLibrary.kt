package moe.quill.carotcards.engine.textures

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import java.nio.file.Files
import java.nio.file.Path

object TextureLibrary {

    private val default = Texture("assets/textures/default.png")
    private val textureMap: MutableMap<String, Texture> = mutableMapOf()

    init {
        loadTextures()
    }

    private fun loadTextures() {
        textureMap.clear()

        val resourcePath = Path.of(Gdx.files.localStoragePath, "assets")
        val path = Path.of(resourcePath.toString(), "textures")

        val res = path.toFile().walkTopDown().filter { file -> Files.isRegularFile(file.toPath()) }

        res.forEach { file ->
            val texturePath = file.path.removePrefix(resourcePath.toString().substring(1))
            val texture = Texture(texturePath)
            textureMap[file.nameWithoutExtension] = texture
        }
    }

    fun getTexture(name: String): Texture {
        return textureMap[name.lowercase()] ?: default
    }
}