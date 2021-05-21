package multiversebootcamp.springboot.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class User(
    @Contextual val _id: ObjectId? = null,
    val name: String? = "User",
    val username: String,
    val password: String,
    val role: String? = null
)
