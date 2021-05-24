package ru.netology

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addPostIdNotZero() {
        val post = Post()

        WallService.add(post)

        assertNotEquals(0, WallService.userPosts.last().id)
    }

    @Test
    fun updateTrue() {
        WallService.add(Post())
        WallService.add(Post())
        val post = Post(id = WallService.userPosts.last().id)

        val result = WallService.update(post)

        assertTrue(result)
    }
    @Test
    fun updateFalse() {
        WallService.add(Post())
        WallService.add(Post())
        val post = Post(100)

        val result = WallService.update(post)

        assertFalse(result)
    }

    @Test
    fun createCommentAddCommentToArray() {
        WallService.add(Post())

        val result = WallService.createComment(Comment(postId = 1))

        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowPostNotFoundException() {
        WallService.createComment(Comment(postId = 100))
    }

    @Test
    fun reportCommentCorrectWork() {
        WallService.add(Post())           // create Post
        WallService.createComment(Comment(postId = WallService.userPosts.last().id)) //create Comment to Post

        val result = WallService.reportComment(Report(commentId = WallService.getComments().last().id))

        assertTrue(result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowCommentNotFoundException() {
        WallService.reportComment(Report(commentId = 100))
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun shouldThrowIndexOutOfBoundsException() {
        WallService.add(Post())           // create Post
        WallService.createComment(Comment(postId = WallService.userPosts.last().id)) //create Comment to Post
        WallService.reportComment(Report(commentId = WallService.getComments().last().id, reason = 10))
    }

}