package com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases

import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.repository.NoteRepository

class DeleteByObjectNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}