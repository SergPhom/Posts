package ru.netology

import java.time.Duration
import java.util.*

sealed class Attachment {
    abstract val attachmentType: String
}
//1 type Photo and it's Copies
data class PhotoAttachment(
    val photo: Photo,
    override val attachmentType: String = "photo"
    ): Attachment()
data class Photo(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "",
    val date: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
    val sizes: Array<PhotoCopy>? = null
){
    override fun toString(): String {
        return "$id  $albumId  $text  $sizes"
    }
}
data class PhotoCopy(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)
//2 type Video and it's members
data class VideoAttachment(
    val video: Video,
    override val attachmentType: String = "video"
): Attachment()
class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val description: String = "",
    val image: Array<Image> = arrayOf(),
    val firstFrame: Array<ImageOfFrame> = arrayOf(),
    val date: Int = 0,
    val addingDate: Int = 0,
    val views: Int = 0,
    val localViews: Int = 0,
    val comments: Int = 0,
    val player: String = "",
    val platform: String = "",
    val canAdd: Boolean = false,
    val isPrivate: Boolean = false,
    val accessKey: String = "",
    val processing: Boolean = false,
    val isFavorite: Boolean = false,
    val canComment: Boolean = false,
    val canEdit: Boolean = false,
    val canLike: Boolean = false,
    val canRepost: Boolean = false,
    val canSubscribe: Boolean = false,
    val canAddToFaves: Boolean = false,
    val canAttachLink: Boolean = false,
    val width: Int = 0,
    val height: Int = 0,
    val userId: Int = 0,
    val converting: Boolean = false,
    val added: Boolean = false,
    val isSubscribed: Boolean = false,
    val repeat: Boolean = false,
    val type: String = "",
    val balance: Int = 0,
    val live: Boolean = false,
    val liveStatus: LiveStatus? = null,
    val upcoming: Boolean = liveStatus == LiveStatus.UPCOMING,
    val spectators: Int = 0,
    val likes: LikesForVideo = LikesForVideo(),
    val reposts: RepostsForVideo = RepostsForVideo(),
)
data class Image(
    val width: Int,
    val height: Int,
    val url: String,
    val withPadding: Boolean
)
data class ImageOfFrame(
    val width: Int,
    val height: Int,
    val url: String
)
enum class LiveStatus{  // "waiting", "started", "finished", "failed", "upcoming".
    WAITING, STARTED, FINISHED, FAILED, UPCOMING
}
data class LikesForVideo(
    val count: Int = 0,
    val userLikes: Boolean = false
)
data class RepostsForVideo(
    val count: Int = 0,
    val wallCount: Int = 0,
    val mailCount: Int = 0,
    val userReposted: Int = 0
)
//3 type Audio
data class AudioAttachment(
    val audio: Audio,
    override val attachmentType: String = "audio"
): Attachment()
data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val IsHQ: Boolean
)
//4 type Doc
data class DocAttachment(
    val doc: Doc,
    override val attachmentType: String = "doc"
): Attachment()
data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int,
    val preview: Preview? = null
)
data class Preview(
    val photo: PhotoForDoc,
    val graffiti: Graffiti,
    val audioMessage: AudioMessage,
)
data class PhotoForDoc(
    val size: Array<PhotoForPreview>
)
data class PhotoForPreview(
    val src: String,
    val width: Int,
    val height: Int,
    val type: String
)
data class Graffiti(
    val src: String,
    val width: Int,
    val height: Int
)
data class AudioMessage(
    val duration: Int,
    val waveForm: Array<Int>,
    val linkOgg: String,
    val linkMp3: String
)
//5 type Album and it's members
data class AlbumAttachment(
    val album: Album,
    override val attachmentType: String = "album"
): Attachment()
data class Album(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val photo: Photo? = null,
    val product: Product? = null,
)
data class  Product(
    val price: Price
)
data class Price(
    val amount: Int,
    val text: String,
    val currency: PriceCurrency,
)
data class PriceCurrency(
    val id: Int,
    val name: String
)