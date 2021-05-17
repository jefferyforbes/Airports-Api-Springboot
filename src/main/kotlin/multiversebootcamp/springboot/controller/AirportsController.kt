package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.model.Airport
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/airports")
class AirportsController {
    // TODO: Use the AirportService class to impl the functionality for the HTTP Requests
    // TODO: Delete "(produces = [MediaType.APPLICATION_JSON_VALUE])" once service class is implemented

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getAirports(): String = "All Airports returned."

    @PostMapping("/{icao}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addAirport(@PathVariable icao: String) = "Nice! Created a New Airport $icao"

    @DeleteMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAll() = "All Airports Deleted!"

    @GetMapping("/{icao}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getAirport(@PathVariable icao: String) = "Airport $icao returned."

    @PutMapping("/{icao}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateAirport(@PathVariable icao: String) = "Airport $icao updated and returned."

    @DeleteMapping("/{icao}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAirport(@PathVariable icao: String) = "Airport $icao delete!"

    fun main(args: Array<String>) {
        SpringApplication.run(AirportsController::class.java, *args)
    }
}