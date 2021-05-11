package multiversebootcamp.springboot

import com.fasterxml.jackson.core.type.TypeReference
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import multiversebootcamp.springboot.AirportsController
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.MediaType
import java.io.IOException
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
@RestController
@RequestMapping("/airports")
class AirportsController {

    @GetMapping(value = ["/hello"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sayHello(): String? {
        return "{\"message\":\"hello from Spring Boot!\"}"
    }

    fun main(args: Array<String>) {
        SpringApplication.run(AirportsController::class.java, *args)
    }
}