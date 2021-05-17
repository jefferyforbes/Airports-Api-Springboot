package multiversebootcamp.springboot.security

import org.jasypt.util.text.AES256TextEncryptor
import org.jasypt.util.text.TextEncryptor

class MockEncryption {
    fun encrypting(encryptor: AES256TextEncryptor) {
        val message = "This message is a secret"
        encryptor.setPassword("supersafepassword")
        val textEncryptor: TextEncryptor = encryptor
        val myEncryptedText: String = textEncryptor.encrypt(message)
        val plainText: String = textEncryptor.decrypt(myEncryptedText)
        println("This is the encrypted message = $myEncryptedText")
        println("This is the plainText = $plainText")
    }
}