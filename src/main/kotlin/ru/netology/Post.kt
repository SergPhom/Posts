package ru.netology

import java.util.*

data class  Post (
    var id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val postType: PostType = PostType.POST,
    val signerId: Int = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Int = 0,
    val comments: Comments = Comments(),
    val copyrights: Copyrights = Copyrights(),
    val likes: Likes = Likes(),
    val reports: Reposts = Reposts(),
    val views: Views = Views(),
    val donut: Donuts = Donuts(),
    //nullable
    val geo: Geo? = null,
    val postSource: PostSource? = null,
    val copyHistory: Array<Post>? = null,
    //add attachments
    val attachments: Array<Attachment>? = null
){
    override fun toString(): String {
        return "id = $id, geo = $geo, postSource = $postSource, copyHistory = ${copyHistory?.toList()}."
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (postType != other.postType) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavorite != other.isFavorite) return false
        if (postponedId != other.postponedId) return false
        if (comments != other.comments) return false
        if (copyrights != other.copyrights) return false
        if (likes != other.likes) return false
        if (reports != other.reports) return false
        if (views != other.views) return false
        if (donut != other.donut) return false
        if (geo != other.geo) return false
        if (postSource != other.postSource) return false
        if (copyHistory != null) {
            if (other.copyHistory == null) return false
            if (!copyHistory.contentEquals(other.copyHistory)) return false
        } else if (other.copyHistory != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + fromId
        result = 31 * result + createdBy
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + replyOwnerId
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + postponedId
        result = 31 * result + comments.hashCode()
        result = 31 * result + copyrights.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + reports.hashCode()
        result = 31 * result + views.hashCode()
        result = 31 * result + donut.hashCode()
        result = 31 * result + (geo?.hashCode() ?: 0)
        result = 31 * result + (postSource?.hashCode() ?: 0)
        result = 31 * result + (copyHistory?.contentHashCode() ?: 0)
        return result
    }
}

enum class PostType{
    POST, COPY, REPLY, POSTPONE, SUGGEST
}

//comments, copyrights, likes, reposts, views,
data class Comments(                  //object	информация о комментариях к записи, объект с полями:
    val count: Int = 0,                //(integer) — количество комментариев
    val canPost: Boolean = false,         //* (integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может)
    val groupsCanPost: Boolean = false,  //(integer, [0,1]) — информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean = false,      // — может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean = false         // — может ли текущий пользователь открыть комментарии к записи.
)
data class Copyrights(                 //object	источник материала, объект с полями:
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = ""
)
data class Likes(                      //object	информация о лайках к записи, объект с полями:
    val count: Int = 0,                 // (integer) — число пользователей, которым понравилась запись;
    val userLikes: Int  = 0,             //* (integer, [0,1]) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    val canLike: Boolean = false           //* (integer, [0,1]) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);can_publish* (integer, [0,1]) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
)
data class Reposts (                     //object	информация о репостах записи («Рассказать друзьям»), объект с полями:
    val count: Int = 0,                   // (integer) — число пользователей, скопировавших запись;
    val userReposted: Boolean = false        //* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).
)
data class Views (                         //object	информация о просмотрах записи. Объект с единственным полем:
    val count: Int = 0                   // (integer) — число просмотров записи.
)
//donut with it's members
data class Donuts(                         //object	информация о записи VK Donut:
    val isDonut: Boolean = false,              //— запись доступна только платным подписчикам VK Donut;
    val paidDuration: Int = 0,             //(integer) — время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder: String = Placeholder.default,
    val canPublishFreeCopy:Boolean = false,   // — можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val editMode: EditModes = EditModes.ALL
)
enum class  EditModes(val value: String) {
    ALL("all"),
    DURATION("duration")
}
object Placeholder {
    const val default: String = "No VK donut"
}
//geo and it's member
data class Geo(
    val type: String = "",
    val coordinates: String = "",
    val place: Place?
)
data class Place (
    val id: Int,
    val title: String,
    val latitude: Int,
    val longitude:Int,
    val created: Int,
    val icon: String,
    val checkins: Int,
    val updated: Int,
    val country: Int,
    val city: Int,
    val address: String
)
//PostSource with members
data class PostSource(
    val type: PostSourceType,
    val platform: PostSourcePlatform,
    val url: String,
    val data: PostSourceData
)
enum class PostSourceType{
    VK, WIDGET, API, RSS, SMS
}
enum class PostSourcePlatform{
    ANDROID, IPHONE, WPHONE
}
enum class PostSourceData{
    PROFILE_ACTIVITY,
    PROFILE_PHOTO,
    COMMENTS,
    LIKE,
    POLL
}