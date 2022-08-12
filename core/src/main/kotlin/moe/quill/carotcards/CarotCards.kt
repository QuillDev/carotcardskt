package moe.quill.carotcards

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.ScreenUtils
import moe.quill.carotcards.entities.EntitySystem
import moe.quill.carotcards.entities.Player
import moe.quill.carotcards.renderer.sprites.OrderedSpriteRenderer
import moe.quill.carotcards.renderer.sprites.SpriteRenderer

class CarotCards : ApplicationAdapter() {

    private lateinit var renderer: SpriteRenderer
    private lateinit var player: Player

    override fun create() {
        renderer = OrderedSpriteRenderer()
        player = Player()
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
}
