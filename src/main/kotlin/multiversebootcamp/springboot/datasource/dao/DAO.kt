package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User

interface DAO {
    fun retrieveUsers(): Collection<User>
    fun retrieveUser(username: String): User?
    fun createUser(user: User): User
    fun updateUser(username: String): User
    fun removeUser(username: String)

    fun retrieveAirports(): Collection<Airport>
    fun retrieveAirport(icao: String): Airport?
    fun createAirport(airport: Airport): Airport
    fun updateAirport(icao: String): Airport
    fun removeAirport(icao: String)
}