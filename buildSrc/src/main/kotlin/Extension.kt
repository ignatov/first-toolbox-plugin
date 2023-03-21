import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

fun Extension.toJson(): String {
    val json = Json { prettyPrint = true }
    return json.encodeToString(Extension.serializer(), this)
}

@Serializable
data class Extension(
    val id: String,
    val version: String,
    val meta: Meta,
    val compatibleVersionRange: CompatibleVersionRange
)

@Serializable
data class Meta(
    val readableName: String,
    val description: String,
    val vendor: String
)

@Serializable
data class CompatibleVersionRange(
    val from: String,
    val to: String
)