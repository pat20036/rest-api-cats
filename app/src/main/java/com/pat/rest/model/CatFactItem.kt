package com.pat.rest.model

data class CatFactItem(
    val deleted: Boolean,
    val sentCount: Int,
    val source: String,
    val text: String,
    val updatedAt: String
)