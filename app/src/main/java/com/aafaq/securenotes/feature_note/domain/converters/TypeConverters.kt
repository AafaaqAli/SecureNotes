package com.aafaq.securenotes.feature_note.domain.converters

import androidx.room.TypeConverter
import com.aafaq.securenotes.feature_note.domain.utils.EncryptionStrength
import com.google.gson.Gson


class TypeConverters {
    @TypeConverter
    fun EncryptionStrength.toEncryptionObject() =
        Gson().toJson(this, EncryptionStrength::class.java).toString()

    @TypeConverter
    fun String.toEncryptionString() =
        Gson().fromJson(this, EncryptionStrength::class.java)

}