package com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases

import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.repository.NoteRepository
import com.aafaq.securenotes.feature_note.domain.utils.DomainConstants.EXCEPTION_BLANK_CONTENT
import com.aafaq.securenotes.feature_note.domain.utils.DomainConstants.EXCEPTION_BLANK_TITLE
import com.aafaq.securenotes.feature_note.domain.utils.DomainConstants.EXCEPTION_BLANK_TITLE_AND_CONTENT
import com.aafaq.securenotes.feature_note.domain.utils.NoteExceptions

class InsertNoteUseCase (
    private val repository: NoteRepository
) {
    @Throws(NoteExceptions.InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isNotBlank() && note.message.isNotBlank()){
            repository.insertNote(note)
        }else{
            when {
                note.title.isBlank() -> {
                    throw NoteExceptions.InvalidNoteException(EXCEPTION_BLANK_TITLE)
                }
                note.message.isBlank() -> {
                    throw NoteExceptions.InvalidNoteException(EXCEPTION_BLANK_CONTENT)
                }
                else -> {
                    throw NoteExceptions.InvalidNoteException(EXCEPTION_BLANK_TITLE_AND_CONTENT)
                }
            }
        }
    }
}