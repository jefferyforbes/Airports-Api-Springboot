package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.UserDAO
import multiversebootcamp.springboot.models.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/users")
class UserController(private val service: UserDAO) {

    @GetMapping
    fun allUserNames(): ResponseEntity<Any> = ResponseEntity.ok(service.retrieveUsers())

    @PostMapping("/register")
    fun register(@RequestBody body: User): String {
        service.createUser(body)
        return "User Created"
    }

    @GetMapping("/login")
    fun login(@RequestBody body: User) = service.loginReq(body)

    @GetMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        return ResponseEntity.ok("Logged Out")
    }
}