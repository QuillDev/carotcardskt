package moe.quill.carotcards.contexts

interface Context {
    fun create()
    fun render()
    fun resize(width: Int, height: Int)
}