package com.example.smoothiefeedapp.data.contracts

object NewsContract {
    const val TABLE_NAME = "news"

    object Columns {
        const val ID = "id"
        const val TEXT = "text"
        const val PHOTO_URLS = "photo_urls"
        const val PUBLIC_NAME = "public_name"
        const val PUBLIC_PHOTO_URL = "public_photo_url"
    }
}