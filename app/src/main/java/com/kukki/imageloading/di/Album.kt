data class Album(
    val albumId: Int = 0,
    val id: Int = 0,
    val thumbnailUrl: String? = null,
    val title: String? = null,
    val url: String? = null
)

data class DataResponse(
    var products: List<Album>? = null,
    var exception: Exception? = null
)