package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Airport

interface AirportDAO {
    fun retrieveAirports(): List<Airport>
    fun retrieveAirport(airport: Airport): Airport?
    fun createAirport(airport: Airport)
    fun updateAirport(airport: Airport)
    fun removeAirport(airport: Airport)
}