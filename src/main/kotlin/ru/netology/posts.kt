package ru.netology

object Comments{                  //object	информация о комментариях к записи, объект с полями:
    val count: Int = 0                //(integer) — количество комментариев;
    val canPost: Boolean = false         //* (integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val groupsCanPost: Boolean = false  //(integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
    val canClose: Boolean = false        // — может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean = false         // — может ли текущий пользователь открыть комментарии к записи.
}
object Copyrights{                 //object	источник материала, объект с полями:
    val id: Int = 0
    val link: String = ""
    val name: String = ""
    val type: String = ""
}
object Likes {                      //object	информация о лайках к записи, объект с полями:
    val count: Int = 0                  // (integer) — число пользователей, которым понравилась запись;
    val userLikes: Int  = 0             //* (integer, [0,1]) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    val canLike: Boolean = false           //* (integer, [0,1]) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);can_publish* (integer, [0,1]) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
}
object Reposts {                     //object	информация о репостах записи («Рассказать друзьям»), объект с полями:
    val count: Int = 0                   // (integer) — число пользователей, скопировавших запись;
    val userReposted: Boolean = false        //* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).
}
object Views {                         //object	информация о просмотрах записи. Объект с единственным полем:
    val count: Int = 0                   // (integer) — число просмотров записи.
}
object Donuts {                         //object	информация о записи VK Donut:
    val isDonut: Boolean = false              //— запись доступна только платным подписчикам VK Donut;
    val paidDuration: Int = 0             //(integer) — время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder = Placeholder.text
    val canPublishFreeCopy:Boolean = false   // — можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val editMode = EditModes.all
}
object EditModes{                        // — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
    val all = "all"                    // all — всю информацию о VK Donut.
    val duration = "duration"         // duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.
}
object Placeholder{                   //(object) — заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
    val text = "No VK donut"
}

data class  Post (
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,                 //integer	время публикации записи в формате unixtime.
    val text: String = "",                //string	текст записи.
    val replyOwnerId: Int = 0,          //integer	идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int = 0,          //integer	идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly: Boolean = false,         //integer, [1]	1, если запись была создана с опцией «Только для друзей».
    val postType: String = "",                 //string    тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int = 0,                    //integer	идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val canPin: Boolean = false,                  //integer, [0,1]	информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete: Boolean = false,               //integer, [0,1]	информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit: Boolean = false,                 //integer, [0,1]	информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
    val isPinned: Boolean = false,                //integer, [1]	информация о том, что запись закреплена.
    val markedAsAds: Boolean = false,            //integer, [0,1]	информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
    val isFavorite: Boolean = false,              //boolean	true, если объект добавлен в закладки у текущего пользователя.
    val postponedId: Int = 0,                   // integer
    val comments: Comments = Comments,
    val copyrights: Copyrights = Copyrights,
    val likes: Likes = Likes,
    val reports: Reposts = Reposts,
    val views: Views = Views,
    val donut: Donuts = Donuts
){
    override fun toString(): String {
        return id.toString()
    }
}

object WallService{
    var userPosts: ArrayList<Post> = arrayListOf()
    fun add(post: Post): Post {
        val newPost =
        if(userPosts.isEmpty())  post.copy(id = 1)
        else post.copy(id = userPosts.last().id + 1)
        userPosts += newPost
        return  userPosts.last()
    }
    fun update(post: Post): Boolean {
        for(oldPost in userPosts){
            if(post.id == oldPost.id){
                val updapedPost = oldPost.copy(id = oldPost.id,
                    oldPost.ownerId,
                    oldPost.fromId +1,
                    oldPost.createdBy +1,
                    oldPost.date,
                    oldPost.text + 1,
                    oldPost.replyOwnerId + 1,
                    oldPost.replyPostId + 1,
                    oldPost.friendsOnly.not(),
                    oldPost.postType + 1,
                    oldPost.signerId +1,
                    canPin  = oldPost.canPin.not(),
                    oldPost.canDelete.not(),
                    oldPost.canEdit.not(),
                    oldPost.isPinned.not(),
                    oldPost.markedAsAds.not(),
                    oldPost.isFavorite.not(),
                    oldPost.postponedId + 1
                )
                userPosts[userPosts.indexOf(oldPost)] = updapedPost
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return userPosts.toList().toString()
    }
}

fun main() {
    println(WallService.add(Post()))
    println(WallService.add(Post()))
    println(WallService.add(Post()))
    println(WallService.add(Post()))
    println(WallService.userPosts[1].postType)
    println(WallService.update(Post(2)))
    println(WallService.userPosts[1].postType)
    println(WallService.userPosts)
}