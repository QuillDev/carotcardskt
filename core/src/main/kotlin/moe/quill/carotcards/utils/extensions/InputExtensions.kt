package moe.quill.carotcards.utils.extensions

import com.badlogic.gdx.Gdx

fun keyPressed(key: Int): Boolean {
    return Gdx.input.isKeyPressed(key)
}

fun keyJustPressed(key: Int): Boolean {
    return Gdx.input.isButtonJustPressed(key)
}