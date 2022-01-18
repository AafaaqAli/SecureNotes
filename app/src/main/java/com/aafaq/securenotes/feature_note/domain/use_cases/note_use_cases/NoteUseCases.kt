package com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val getNoteByID: GetNoteByIdUseCase,

    val deleteAllNotesUseCase: DeleteAllNotesUseCase,
    val deleteByObject: DeleteByObjectNoteUseCase,

    val insertNote: InsertNoteUseCase
)
