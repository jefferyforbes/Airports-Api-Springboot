package multiversebootcamp.springboot.datasource

import multiversebootcamp.springboot.models.Airport
import org.springframework.stereotype.Repository

@Repository
//This repository annotation tells spring boot that class is responsible to storing and updating the database.
class AirportDataSourceInteractorImpl: AirportDataSourceInteractor {
    override fun retrieveAirports(): Collection<Airport> {
        TODO("Not yet implemented")
    }

    override fun createAirport(airport: Airport): Airport {
        TODO("Not yet implemented")
    }

    override fun removeAll() {
        TODO("Not yet implemented")
    }

    override fun retrieveAirport(icao: String): Airport {
        TODO("Not yet implemented")
    }

    override fun updateAirport(icao: String): Airport {
        TODO("Not yet implemented")
    }

    override fun removeAirport(icao: String) {
        TODO("Not yet implemented")
    }
}