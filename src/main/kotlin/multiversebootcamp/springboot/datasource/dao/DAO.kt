package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User
import org.springframework.http.ResponseEntity

interface DAO {
    fun retrieveUsers(): List<User>
    fun retrieveUser(user: User): ResponseEntity<Any>
    fun createUser(user: User)
    fun updateUser(user: User)
    fun removeUser(user: User)
    fun loginReq(user: User): ResponseEntity<Any>

    fun retrieveAirports(): List<Airport>
    fun retrieveAirport(airport: Airport): Airport?
    fun createAirport(airport: Airport)
    fun updateAirport(airport: Airport)
    fun removeAirport(airport: Airport)
}