package com.aafaq.securenotes.feature_note.domain.utils

import java.lang.Exception

object NoteExceptions {
    class InvalidNoteException(message: String): Exception(message)
    class InvalidReturnedObject(message: String): Exception(message)
}