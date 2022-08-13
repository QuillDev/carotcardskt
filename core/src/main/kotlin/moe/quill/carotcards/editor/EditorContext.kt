package moe.quill.carotcards.editor

import com.badlogic.gdx.Gdx
import moe.quill.carotcards.contexts.Context

class EditorContext : Context {

    override fun create() {
    }

    override fun render() {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f)

    }

    override fun resize(width: Int, height: Int) {
    }
}