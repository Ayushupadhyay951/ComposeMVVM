package com.cscorner.composemvvm.models

data class Article(
    val imgUrl: String,
    val title: String,
    val body: String,
    val author: String = "Ayush Upadhayay",
    val likes: Int,
)

fun getArticle(): List<Article> {
    return listOf(
        Article(
            imgUrl = "https://picsum.photos/id/1/200/300",
            title = "Article one",
            body = "This is one Article picture",
            likes = 1000,
            author="Lord Ayush Updhyay"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/324/367/267",
            title = "Article Two",
            body = "This is secoond part",
            likes = 200,
            author="kk bro"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/382/367/267",
            title = "Article Three",
            body = "This is three Article picture",
            likes = 500
        ),
        Article(
            imgUrl = "https://picsum.photos/id/27/367/267",
            title = "Article fourth",
            body = "This is fourth Article picture",
            likes = 200,
            author = "Carry diary"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/42/3456/2304",
            title = "Article Fifth",
            body = "This is Fifth Article picture",
            likes = 200,
            author="Belli"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/65/4912/3264",
            title = "Article six",
            body = "This is six Article picture",
            likes = 200,
            author="Robert brown,"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/111/4400/2656",
            title = "Article seven",
            body = "This is seven Article picture",
            likes = 200,
            author="Lily baby"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/129/4910/3252",
            title = "Article eight",
            body = "This is eight Article picture",
            likes = 200,
            author="jony sins"
        ),
        Article(
            imgUrl = "https://picsum.photos/id/315/367/267",
            title = "Article Nine",
            body = "This is Nine Article picture",
            likes = 200
        ),
        Article(
            imgUrl = "https://picsum.photos/id/384/5000/3333",
            title = "Article one",
            body = "This is one Article picture",
            likes = 300
        ),
        Article(
            imgUrl = "https://picsum.photos/id/360/1925/1280",
            title = "Article Ten",
            body = "This is ten Article picture",
            likes = 600
        ),
        Article(
            imgUrl = "https://picsum.photos/id/306/367/267",
            title = "Article eleven",
            body = "This is eleven Article picture",
            likes = 231,
            author="dudd"
        ),
    )
}