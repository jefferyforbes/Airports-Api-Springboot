package multiversebootcamp.springboot.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class Bank (
    @Contextual val _id: ObjectId? = null,
    val accountNumber: Int,
    val passcode: Int,
    val balance: Int = 0,
    val standingOrder: MutableCollection<String?>?
)