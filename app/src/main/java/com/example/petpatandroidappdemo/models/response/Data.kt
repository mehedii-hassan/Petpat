package com.example.petpatandroidappdemo.models.response

data class Data(
    val admin_issue_sub_categories: List<AdminIssueSubCategory>,
    val id: Int,
    val issue_category: String,
    val issue_category_ar: String
)