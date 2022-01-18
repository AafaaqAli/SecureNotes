package com.aafaq.securenotes.feature_note.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aafaq.securenotes.feature_note.domain.utils.EncryptionStrength

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var message: String,
    var encryptionStrength: EncryptionStrength = EncryptionStrength.NONE,
    var creationDateAndTime: Long,
    var NotePriority: Int,
    var ShouldRemind: Boolean,
    var reminderTimeInFuture: Long
)
