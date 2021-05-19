package ru.netology

fun main() {
    println(WallService.add(Post()))
    println(WallService.add(Post()))
    println(WallService.add(Post()))
    println(WallService.userPosts[1].postType)
    println(WallService.update(Post(2)))
    println(WallService.userPosts[1].postType)
    println(WallService.userPosts)
}