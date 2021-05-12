package multiversebootcamp.springboot.service

import multiversebootcamp.springboot.datasource.AirportDataSourceInteractor
import multiversebootcamp.springboot.model.Airport

//@Service
class AirportService(private val dataSourceInteractor: AirportDataSourceInteractor) {
    private fun getAirports(): Collection<Airport> = dataSourceInteractor.retrieveAirports()
    private fun addAirport(airport: Airport): Airport = dataSourceInteractor.createAirport(airport)
    private fun deleteAll() = dataSourceInteractor.removeAll()
    private fun getAirport(icao: String) = dataSourceInteractor.retrieveAirport(icao)
    private fun updateAirport(icao: String) = dataSourceInteractor.updateAirport(icao)
    private fun deleteAirport(icao: String) = dataSourceInteractor.removeAirport(icao)
}