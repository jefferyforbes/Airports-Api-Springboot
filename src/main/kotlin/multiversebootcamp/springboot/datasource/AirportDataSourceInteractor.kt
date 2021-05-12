package multiversebootcamp.springboot.datasource

import multiversebootcamp.springboot.model.Airport

interface AirportDataSourceInteractor {
    fun retrieveAirports(): Collection<Airport>
    fun createAirport(airport: Airport): Airport
    fun removeAll(): Airport
    fun retrieveAirport(icao: String): Airport
    fun updateAirport(icao: String): Airport
    fun removeAirport(icao: String): Airport
}