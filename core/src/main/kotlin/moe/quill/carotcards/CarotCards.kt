package moe.quill.carotcards

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import moe.quill.carotcards.contexts.Context
import moe.quill.carotcards.editor.EditorContext
import moe.quill.carotcards.engine.EngineContext
import moe.quill.carotcards.engine.entities.EntitySystem
import moe.quill.carotcards.engine.entities.Player
import moe.quill.carotcards.engine.renderer.sprites.OrderedSpriteRenderer
import moe.quill.carotcards.engine.renderer.sprites.SpriteRenderer

class CarotCards : ApplicationAdapter() {

    private var context: Context =
        if (System.getenv("ctx")?.equals("editor") == true) {
            EditorContext()
        } else {
            EngineContext()
        }

    init {
        println(System.getenv())
        println("Context: ${context.javaClass.simpleName}")
    }
    override fun create() {
        context.create()
    }

    override fun render() {
        context.render()
    }

    override fun resize(width: Int, height: Int) {
        context.resize(width, height)
    }
}
