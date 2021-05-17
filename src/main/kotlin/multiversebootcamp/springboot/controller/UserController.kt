package multiversebootcamp.springboot.controller

import com.auth0.jwt.JWT
import multiversebootcamp.springboot.models.User
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
@RequestMapping("/user")
class UserController {

    @GetMapping
    fun allUserNames(): String {
        return "List of all user names"
    }

    @GetMapping("/register")
    fun register(): String {
        return "Registered"
    }

    @PostMapping("/login")
    fun login(user:User): String {
        return "On Success logged In"
//        Date(System.currentTimeMillis() + 60 * 1 * 1000) 1 Hour
    }
}