package multiversebootcamp.springboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
internal class BanksControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    objectMapper: ObjectMapper
) {

    @Test
    fun login() {
    }

    @Test
    fun createBank() {
    }

    @Test
    fun getBalance() {
    }

    @Test
    fun getStandingOrders() {
    }

    @Test
    fun standingOrder() {
    }

    @Test
    fun sendMoney() {
    }
}