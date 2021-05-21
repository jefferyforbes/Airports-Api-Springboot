package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.AirportDAO
import multiversebootcamp.springboot.models.Airport
import org.springframework.boot.SpringApplication
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/airports")
class AirportsController(private val service: AirportDAO) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAirports() = service.retrieveAirports()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addAirport(@RequestBody airport: Airport) = service.createAirport(airport)

    @DeleteMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAll() = "All Airports Deleted!" // DECIDE NOT TO IMPL

    @GetMapping("/{icao}")
    @ResponseStatus(HttpStatus.OK)
    fun getAirport(@PathVariable @RequestBody airport: Airport) = service.retrieveAirport(airport)

    @PutMapping
    fun updateAirport(@RequestBody airport: Airport) = service.updateAirport(airport)

    @DeleteMapping
    fun deleteAirport(@RequestBody airport: Airport) = service.removeAirport(airport)

    fun main(args: Array<String>) {
        SpringApplication.run(AirportsController::class.java, *args)
    }
}