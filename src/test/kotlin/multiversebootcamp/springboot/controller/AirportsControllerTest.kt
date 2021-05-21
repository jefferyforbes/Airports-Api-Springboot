package multiversebootcamp.springboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class AirportsControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper,
) {
    val baseURL = "/airports"
    val icao: String = "LHR"

    @Nested
    @DisplayName("GET allAirports")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetAirports {
        @Test
        fun getAirports() {
            mockMvc.get(baseURL)
        }
    }

    @Nested
    @DisplayName("POST addAirport")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class AddAirport {
        @Test
        fun addAirport() {
            mockMvc.post("$baseURL/$icao")
                .andDo { print() }
                .andExpect {
                    content {
                        string("Nice! Created a New Airport $icao")
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    status { isCreated() }
                }
        }

        @Test
        fun alreadyExistsAirport() {
            mockMvc.post("$baseURL/$icao")
                .andDo { print() }
                .andExpect {
                    content {
                        string("Error! This airport already exists in the database $icao")
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    status { isBadRequest() }
                }
        }
    }

    @Nested
    @DisplayName("DELETE allAirports")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class DeleteAirports {
        @Test
        @DirtiesContext
        fun deleteAll() {
            mockMvc.delete(baseURL)
                .andDo { print() }
                .andExpect {
                    content {
                        string("All Airports Deleted!")
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    status { isNoContent() }
                }
        }
    }

    @Nested
    @DisplayName("GET specificAirport")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetAirport {
        @Test
        fun getAirport() {
            mockMvc.get("$baseURL/$icao")
                .andDo { print() }
                .andExpect {
                    content {
                        string("Airport $icao returned.")
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    status { isOk() }
                }
        }
    }

    @Nested
    @DisplayName("PUT updateAirport")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class UpdateAirport {
        @Test
        @DirtiesContext
        fun updateAirport() {
            mockMvc.put("$baseURL/$icao")
                .andDo { print() }
                .andExpect {
                    content {
                        string("Airport $icao updated and returned.")
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    status { isOk() }
                }
        }
    }

    @Nested
    @DisplayName("DELETE specificAirport")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class DeleteAirport {
        @Test
        @DirtiesContext
        fun deleteAirport() {
            mockMvc.delete("$baseURL/$icao")
                .andDo { print() }
                .andExpect {
                    content {
                        string("Airport $icao delete!")
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    status { isNoContent() }
                }
        }
    }
}
