package com.aafaq.securenotes.feature_note.data.data_source

import androidx.room.*
import com.aafaq.securenotes.feature_note.domain.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    /**
     * Add Note | Edit Note | Get Note By ID | Get All Notes | Delete Notes | Delete By ID & Object
     * */

    /**
     * Replace the note if similar note with same id exists
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id =:id")
    fun getNoteByID(id: Int): Note?

    @Query("DELETE FROM note")
    suspend fun deleteAllNotes()

    @Query("DELETE FROM note WHERE id =:id")
    suspend fun deleteNoteByID(id: Int)

    @Delete
    suspend fun deleteNote(note: Note)

}