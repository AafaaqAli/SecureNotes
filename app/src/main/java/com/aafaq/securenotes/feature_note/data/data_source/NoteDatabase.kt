package com.aafaq.securenotes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aafaq.securenotes.feature_note.data.utils.FeatureConstants
import com.aafaq.securenotes.feature_note.domain.models.Note

@Database(
    version = FeatureConstants.DATABASE_VERSION,
    entities = [Note::class]
)
@TypeConverters(com.aafaq.securenotes.feature_note.domain.converters.TypeConverters::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
}