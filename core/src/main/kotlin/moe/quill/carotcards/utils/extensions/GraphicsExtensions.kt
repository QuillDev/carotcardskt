package moe.quill.carotcards.utils.extensions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3

fun deltaTime() = Gdx.graphics.deltaTime

fun SpriteBatch.draw(texture: Texture, pos: Vector3) = draw(texture, pos.x, pos.y)