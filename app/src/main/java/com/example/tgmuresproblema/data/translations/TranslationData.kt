package com.example.tgmuresproblema.data.translations

import com.squareup.moshi.JsonClass

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/17/2020
 *
 */

@JsonClass(generateAdapter = true)
data class TranslationData(val key:String,val term:String)