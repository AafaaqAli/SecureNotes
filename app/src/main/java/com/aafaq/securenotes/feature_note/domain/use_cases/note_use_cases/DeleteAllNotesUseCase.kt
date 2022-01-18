package com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases

import com.aafaq.securenotes.feature_note.domain.repository.NoteRepository

class DeleteAllNotesUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(){
        repository.deleteAllNotes()
    }
}