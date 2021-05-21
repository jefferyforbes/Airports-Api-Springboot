package multiversebootcamp.springboot

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import multiversebootcamp.springboot.controller.UserController
import multiversebootcamp.springboot.datasource.dao.UserDAO
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication (exclude = [SecurityAutoConfiguration::class])
class AirportsApiApplication(
    private val userController: UserController
) {
    @Bean
    fun customOpenAPI(@Value("\${springdoc.version}") appVersion: String?, userDao: UserDAO): OpenAPI {
//        println(dao.retrieveUser("vibeN_Jeff"))
        println(userDao.retrieveUsers())
        return OpenAPI()
            .info(Info()
                .title("Airports")
                .version(appVersion)
                .description("28,000 airports")
            )
            .addServersItem(Server()
                .url("http://localhost:8080/"))
    }


    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AirportsApiApplication::class.java, *args)
        }
    }
}