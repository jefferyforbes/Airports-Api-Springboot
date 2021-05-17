package multiversebootcamp.springboot

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import multiversebootcamp.springboot.security.mocksecurity.MockEncryption
import org.jasypt.util.text.AES256TextEncryptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.support.beans
import org.springframework.security.core.userdetails.User

@SpringBootApplication
class AirportsApiApplication() {
    @Bean
    fun customOpenAPI(@Value("\${springdoc.version}") appVersion: String?): OpenAPI {
        return OpenAPI()
            .info(Info()
                .title("Airports")
                .version(appVersion)
                .description("28,000 airports")
            )
            .addServersItem(Server()
                .url("http://localhost:8080/"))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AirportsApiApplication::class.java, *args)
        }
    }
}