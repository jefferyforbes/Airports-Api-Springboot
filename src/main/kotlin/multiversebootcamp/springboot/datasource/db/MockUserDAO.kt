package multiversebootcamp.springboot.datasource.db

import multiversebootcamp.springboot.datasource.dao.UserDAO
import multiversebootcamp.springboot.models.User
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository("mockUserDB")
class MockUserDAO: UserDAO {
    val mockUserDB = mutableListOf(
        User(
            ObjectId.getSmallestWithDate(Date.from(Instant.now())),
            name = "mock-name",
            username = "mock-user",
            password = "mock-password",
            role = "mock-user"
        )
    )

    override fun retrieveUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun retrieveUser(user: User): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }

    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun removeUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun loginReq(user: User): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }

}