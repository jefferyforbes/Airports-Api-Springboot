package multiversebootcamp.springboot.service

import multiversebootcamp.springboot.datasource.UserDataSourceInteractor
import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private val dataSourceInteractor: UserDataSourceInteractor) {
//    private fun getUsers(): Collection<Airport> = dataSourceInteractor.retrieveAirports()
//    private fun addUser(user: User): Airport = dataSourceInteractor.createAirport(airport)
//    private fun getUser(icao: String) = dataSourceInteractor.retrieveAirport(icao)
//    private fun updateAirport(icao: String) = dataSourceInteractor.updateAirport(icao)
//    private fun deleteUser(userid: _id) = dataSourceInteractor.removeAirport(icao)
}