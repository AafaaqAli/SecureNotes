package com.aafaq.securenotes.feature_note.domain.utils

sealed class EncryptionType{
    object AES: EncryptionType()
    object RSA: EncryptionType()
    object HASHING: EncryptionType()
    object E2EE: EncryptionType()
    object ECC: EncryptionType()
    object HMAC: EncryptionType()
    object NONE: EncryptionType()
}
