@file:JvmName("Lwjgl3Launcher")

package moe.quill.carotcards.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import moe.quill.carotcards.CarotCards

/** Launches the desktop (LWJGL3) application. */
fun main() {
    Lwjgl3Application(CarotCards(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("carotcardskt")
        setWindowedMode(640, 480)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
