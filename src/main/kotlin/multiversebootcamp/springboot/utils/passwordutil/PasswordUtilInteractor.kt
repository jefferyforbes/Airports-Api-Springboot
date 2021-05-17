package multiversebootcamp.springboot.utils.passwordutil

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

interface PasswordUtilInteractor {
    fun encrypt(passwordEncoder: BCryptPasswordEncoder, toEncode: String): String
    fun passwordCompare(passwordEncoder: BCryptPasswordEncoder, password: String): Boolean
}