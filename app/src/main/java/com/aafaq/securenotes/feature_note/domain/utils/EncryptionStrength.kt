package com.aafaq.securenotes.feature_note.domain.utils

sealed class EncryptionStrength(val encryptionType: EncryptionType) {
    object NONE: EncryptionStrength(EncryptionType.NONE)
    class HIGH(encryptionType: EncryptionType) : EncryptionStrength(encryptionType)
    class MEDIUM(encryptionType: EncryptionType) : EncryptionStrength(encryptionType)
    class LOW(encryptionType: EncryptionType) : EncryptionStrength(encryptionType)
}