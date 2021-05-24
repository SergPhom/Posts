package ru.netology

fun main() {
    println("первый пост ${WallService.add(Post())}")
    println("второй пост ${WallService.add(Post())}")
    println("третий пост ${WallService.add(Post())}")
    println("начальное значение ${WallService.userPosts[1].copyHistory}")
    println("обновили второй пост ${WallService.update(Post(2))}")
    println("обновленное значение ${WallService.userPosts[1].copyHistory?.toList().toString()}")
    val new = WallService.userPosts[1].copy(attachments = arrayOf(PhotoAttachment( Photo()),
        VideoAttachment(Video()),
        DocAttachment(Doc(0,0,"",0,"","",0,0,null))
    ))
    val photo = (new.attachments?.get(0) as PhotoAttachment).photo
    val photos = new.attachments.filterIsInstance<PhotoAttachment>()
    println(photos[0].photo)
    println(photo.toString())
    WallService.print(WallService.userPosts)
}