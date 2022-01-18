package com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases

import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.repository.NoteRepository

class GetNoteByIdUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(id: Int): Note? {
        return repository.getNoteByID(id)
    }
}