package multiversebootcamp.springboot.models

import com.fasterxml.jackson.annotation.JsonIgnore
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonIgnore
import org.bson.types.ObjectId

@Serializable
data class User(
    @Contextual val _id: ObjectId? = null,
    val name: String? = "User",
    val username: String,
    @BsonIgnore val password: String,
    val role: String
) {

}
