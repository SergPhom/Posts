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

}