package moe.quill.carotcards.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import moe.quill.carotcards.SCREEN_HEIGHT
import moe.quill.carotcards.SCREEN_WIDTH
import moe.quill.carotcards.UPDATE_RATE
import moe.quill.carotcards.contexts.Context
import moe.quill.carotcards.elapsed
import moe.quill.carotcards.engine.entities.EntitySystem
import moe.quill.carotcards.engine.entities.Player
import moe.quill.carotcards.engine.renderer.sprites.OrderedSpriteRenderer
import moe.quill.carotcards.engine.renderer.sprites.SpriteRenderer

class EngineContext : Context {
    private lateinit var renderer: SpriteRenderer
    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: Viewport

    private lateinit var mapRenderer: OrthogonalTiledMapRenderer
    private lateinit var map: TiledMap

    override fun create() {
        renderer = OrderedSpriteRenderer()
        this.camera = OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT)
        this.viewport = FitViewport(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat(), camera)
        this.viewport.apply()
        this.camera.update()

        this.map = TmxMapLoader(InternalFileHandleResolver()).load("assets/map1/testmap.tmx")
        this.mapRenderer = OrthogonalTiledMapRenderer(map)
        Player()
    }

    override fun render() {
        handleUpdate()

        ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1f)
        renderer.begin()
        EntitySystem.render(renderer)
        renderer.end()
    }

    private fun handleUpdate() {
        elapsed += Gdx.graphics.deltaTime
        while(elapsed >= UPDATE_RATE) {
            update()
            elapsed -= UPDATE_RATE
        }
    }

    private fun update() {
        EntitySystem.update()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }
}