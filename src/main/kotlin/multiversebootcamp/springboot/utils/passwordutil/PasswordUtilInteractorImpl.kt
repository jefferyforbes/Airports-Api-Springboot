package multiversebootcamp.springboot.utils.passwordutil

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class PasswordUtilInteractorImpl : PasswordUtilInteractor {

    override fun encrypt(passwordEncoder: BCryptPasswordEncoder, encode: String?): String =
        passwordEncoder.encode(encode)

    override fun passwordCompare(
        passwordEncoder: BCryptPasswordEncoder,
        inputPassword: String,
        existPassword: String,
    ): Boolean {
        return passwordEncoder.matches(inputPassword, existPassword)
    }
}