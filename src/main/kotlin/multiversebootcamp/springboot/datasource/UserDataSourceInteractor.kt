package multiversebootcamp.springboot.datasource

import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User

interface UserDataSourceInteractor {
    fun retrieveUsers(): Collection<User>
    fun createUser(user: User): User
    fun retrieveUser(user: User): User  //findbyUsername
//    fun updateAirport(_id: _id): Airport
//    fun removeUser(_id: _id)
}