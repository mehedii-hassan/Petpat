package com.example.petpatandroidappdemo.models.gallery


data class PhotoModel(
    val id: String,
    val slug: String,
    val created_at: String,
    val updated_at: String,
    val promoted_at: String,
    val width: Int,
    val height: Int,
    val color: String,
    val blur_hash: String,
    val description: String,
    val alt_description: String,
    val urls: Urls,
    val links: Links,
    val likes: Int,
    val liked_by_user: Boolean,
    val current_user_collections: List<String>,
    val sponsorship: Sponsorship,
    val topic_submissions: TopicSubmissions,
    val user: User
)