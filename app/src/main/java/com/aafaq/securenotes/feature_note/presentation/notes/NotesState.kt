package com.aafaq.securenotes.feature_note.presentation.notes

import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.utils.NoteOrder
import com.aafaq.securenotes.feature_note.domain.utils.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Title(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false,
)