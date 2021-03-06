package ru.netology

object WallService{
    val userPosts = arrayListOf<Post>()
    private val comments = arrayListOf<Comment>()
    private val reports = arrayListOf<Report>()
    fun getComments(): ArrayList<Comment>{
        return comments
    }
    fun add(post: Post): Post {
        val newPost =
        if(userPosts.isEmpty())  post.copy(id = 1)
        else post.copy(id = userPosts.last().id + 1)
        userPosts += newPost
        return  userPosts.last()
    }


    fun createComment(comment: Comment): Boolean{
        for((index, oldPost) in userPosts.withIndex()) {
            if (comment.postId == oldPost.id) {
                comments += if(comments.isEmpty()) comment.copy(id = 1)
                else comment.copy(id = comments.last().id + 1)
                return true
            }
        }
        throw PostNotFoundException
    }
    fun reportComment(report: Report): Boolean{
        for((index, comment) in comments.withIndex()) {
            if (report.commentId == comment.id) {
                reports += report
                if(report.reason < 0 || report.reason > 8){
                    throw IndexOutOfBoundsException("Reason with such Index doesn't exist")
                }
                return true
            }
        }
        throw CommentNotFoundException
    }
    fun update(post: Post): Boolean {
        for((index, oldPost) in userPosts.withIndex()){
            if(post.id == oldPost.id){
                val updatedPost = oldPost.copy(
                    fromId = oldPost.fromId +1,
                    createdBy = oldPost.createdBy +1,
                    text = oldPost.text + 1,
                    replyOwnerId = oldPost.replyOwnerId + 1,
                    replyPostId = oldPost.replyPostId + 1,
                    friendsOnly = oldPost.friendsOnly.not(),
                    postType = when(oldPost.postType){      //change of postType
                        PostType.POST -> PostType.COPY
                        else -> PostType.POST
                    },
                    signerId = oldPost.signerId +1,
                    canPin  = oldPost.canPin.not(),
                    canDelete = oldPost.canDelete.not(),
                    canEdit = oldPost.canEdit.not(),
                    isPinned = oldPost.isPinned.not(),
                    markedAsAds = oldPost.markedAsAds.not(),
                    isFavorite = oldPost.isFavorite.not(),
                    postponedId = oldPost.postponedId + 1,
                    postSource = PostSource(PostSourceType.API,
                        PostSourcePlatform.ANDROID,
                        url = "",
                        PostSourceData.COMMENTS
                    ),
                    copyHistory = arrayOf(),
                    geo = Geo(type = "",coordinates = "",place = null)
                )
                userPosts[index] = updatedPost
                return true
            }
        }
        return false
    }
    fun print(posts: ArrayList<Post>){
        for(string in posts.toString().split(".,")){
            println(string)
        }
    }
}

object CommentNotFoundException : NoSuchElementException ("Comment with such ID doesn't exist")

object PostNotFoundException : NoSuchElementException("Post with such ID doesn't exist")
