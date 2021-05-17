package multiversebootcamp.springboot.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class User(
    @Contextual val id: ObjectId,
    val username: String,
    val password: String,
    val role: String
)
