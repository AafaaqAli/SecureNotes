package com.aafaq.securenotes.feature_note.presentation.notes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aafaq.securenotes.feature_note.domain.models.Note
import com.aafaq.securenotes.feature_note.domain.use_cases.note_use_cases.NoteUseCases
import com.aafaq.securenotes.feature_note.domain.utils.DomainConstants.EXCEPTION_NOTE_NOT_FOUND
import com.aafaq.securenotes.feature_note.domain.utils.NoteExceptions
import com.aafaq.securenotes.feature_note.domain.utils.NoteOrder
import com.aafaq.securenotes.feature_note.domain.utils.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCase: NoteUseCases
): ViewModel() {
    private val _state = mutableStateOf(NotesState())
    val state: MutableState<NotesState> = _state
    var deletedNote: Note? = null

    private var getAllNoteJob: Job? = null
    private var foundNote: Note? = null


    init {
        getNotes(NoteOrder.Title(OrderType.Ascending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if(state.value.noteOrder::class == event.noteOrder::class
                    && state.value.noteOrder.orderType == event.noteOrder.orderType){
                    return
                }else{

                }
            }

            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }

            is NotesEvent.InsertNote -> {
                viewModelScope.launch{
                    noteUseCase.insertNote(event.note)
                }
            }

            is NotesEvent.DeleteAllNotes -> {
                viewModelScope.launch{
                    noteUseCase.deleteAllNotesUseCase()
                }
            }

            is NotesEvent.DeleteNoteByObject -> {
                viewModelScope.launch{
                    noteUseCase.deleteByObject(event.note)
                    deletedNote = event.note
                }
            }

            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCase.insertNote(deletedNote ?: return@launch)

                    /**
                     * Invalidate the deleted Note after restoring
                     * */
                    deletedNote = null
                }
            }
        }
    }


    private fun getNotes(noteOrder: NoteOrder){
        getAllNoteJob?.cancel()
        getAllNoteJob = noteUseCase.getNotes(noteOrder).onEach { notes ->
            _state.value = state.value.copy(
                noteOrder = noteOrder,
                notes = notes
            )
        }.launchIn(viewModelScope)
    }


    @Throws(NoteExceptions.InvalidReturnedObject::class)
    private fun getNoteByID(id: Int): Note? {
        _state.value.notes.forEach { note ->
            if(note.id == id){
                foundNote = note

                return@forEach
            }
        }

        if (foundNote != null){
            return foundNote
        } else throw NoteExceptions.InvalidReturnedObject(EXCEPTION_NOTE_NOT_FOUND)
    }
}