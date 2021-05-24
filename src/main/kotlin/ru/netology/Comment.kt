package ru.netology

data class Comment (
    val id: Int = 0,
    val postId: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val parentsStack: Array<Int> = arrayOf(),
    val donut: Donut = Donut(Placeholder),
    val thread: Threads = Threads()
)
data class Donut(
    val placeholder: Placeholder,
    val isDon: Boolean = false
)
data class Threads(
    val count: Int = 0,
    val items: Array<Comment>? = null,
    val canPost: Boolean = false,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = false
)