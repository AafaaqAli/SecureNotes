package com.aafaq.securenotes.feature_note.domain.utils

object EncryptionDecryptionUtils {

    /**
     * Encrypt And Decrypt the source text appropriately
     * */
    fun String.encryptSource(saltString: String, encryptionStrength: EncryptionStrength): String{
        return "Test String"
    }

    fun String.decryptSource(saltString: String, encryptionStrength: EncryptionStrength): String{
        return "Test String"
    }


    /**
     * key generators
     * TODO: Link '2 factor Authenticator' support
     * */
    fun String.generateEncryptionKey(): String{
        return "Encryption Test Key"
    }

    fun String.generateDecryptionKey(): String{
        return "Decryption Test Key"
    }
}