package ru.netology

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
        for((index, oldPost) in userPosts.withIndex()){
            if(post.id == oldPost.id){
                val updapedPost = oldPost.copy(
                    fromId = oldPost.fromId +1,
                    createdBy = oldPost.createdBy +1,
                    text = oldPost.text + 1,
                    replyOwnerId = oldPost.replyOwnerId + 1,
                    replyPostId = oldPost.replyPostId + 1,
                    friendsOnly = oldPost.friendsOnly.not(),
                    postType = oldPost.postType + 1,
                    signerId = oldPost.signerId +1,
                    canPin  = oldPost.canPin.not(),
                    canDelete = oldPost.canDelete.not(),
                    canEdit = oldPost.canEdit.not(),
                    isPinned = oldPost.isPinned.not(),
                    markedAsAds = oldPost.markedAsAds.not(),
                    isFavorite = oldPost.isFavorite.not(),
                    postponedId = oldPost.postponedId + 1
                )
                userPosts[index] = updapedPost
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return userPosts.toList().toString()
    }
}