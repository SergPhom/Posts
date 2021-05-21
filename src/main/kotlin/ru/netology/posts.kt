package ru.netology

fun main() {
    println("первый пост ${WallService.add(Post())}")
    println("второй пост ${WallService.add(Post())}")
    println("третий пост ${WallService.add(Post())}")
    println("начальное значение ${WallService.userPosts[1].copyHistory}")
    println("обновили второй пост ${WallService.update(Post(2))}")
    println("обновленное значение ${WallService.userPosts[1].copyHistory?.toList().toString()}")
    WallService.print(WallService.userPosts)
}