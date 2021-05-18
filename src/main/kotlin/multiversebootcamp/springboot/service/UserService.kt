package multiversebootcamp.springboot.service

import multiversebootcamp.springboot.datasource.dao.DAO
import multiversebootcamp.springboot.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private val data: DAO) {
    private fun getUsers(): Collection<User> = data.retrieveUsers()
    private fun addUser(user: User): User = data.createUser(user)
    private fun getUser(username: String) = data.retrieveUser(username)
    private fun updateUser(username: String) = data.updateUser(username)
    private fun deleteUser(username: String) = data.removeUser(username)
}