package com.aafaq.securenotes.feature_note.presentation.notes

import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.utils.NoteOrder

sealed class NotesEvent{
    /**
     * Default Order
     * */
    data class Order(val noteOrder: NoteOrder): NotesEvent()

    /**
     * keep Note for few seconds and show Snack bar to restore deleted item and than delete permanently
     * */
    object RestoreNote: NotesEvent()

    /**
     * When Note Order is changed
     * */
    object ToggleOrderSection: NotesEvent()

    /**
     * Repository Note Events
     * */
    object DeleteAllNotes: NotesEvent()

    data class DeleteNoteByObject(val note: Note): NotesEvent()

    data class InsertNote(val note: Note): NotesEvent()
}
