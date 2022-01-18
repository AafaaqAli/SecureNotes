package com.aafaq.securenotes.di

import android.app.Application
import androidx.room.Room
import com.aafaq.securenotes.feature_note.data.utils.FeatureConstants
import com.aafaq.securenotes.feature_note.data.data_source.NoteDao
import com.aafaq.securenotes.feature_note.data.data_source.NoteDatabase
import com.aafaq.securenotes.feature_note.data.repository.NoteRepositoryImp
import com.aafaq.securenotes.feature_note.domain.repository.NoteRepository
import com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun providesNoteDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            FeatureConstants.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun providesNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao

    @Provides
    @Singleton
    fun providesNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImp(noteDao)

    @Provides
    @Singleton
    fun providesNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            GetNotesUseCase(repository),
            GetNoteByIdUseCase(repository),
            DeleteAllNotesUseCase(repository),
            DeleteByObjectNoteUseCase(repository),
            InsertNoteUseCase(repository),
        )
    }
}