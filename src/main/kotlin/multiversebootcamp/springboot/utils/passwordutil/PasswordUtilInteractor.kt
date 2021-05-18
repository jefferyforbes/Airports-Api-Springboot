package multiversebootcamp.springboot.utils.passwordutil

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

interface PasswordUtilInteractor {
    fun encrypt(passwordEncoder: BCryptPasswordEncoder, encode: String?): String
    fun passwordCompare(passwordEncoder: BCryptPasswordEncoder, inputPassword: String, existPassword: String): Boolean
}