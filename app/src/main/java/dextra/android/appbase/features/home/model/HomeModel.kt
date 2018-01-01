package dextra.android.appbase.features.home.model

class HomeModel {
    // TODO: Create a repository
    // TODO: http request with hashTag
    fun fetchPostsByHashTag(hashTag: String, callback:(error: Any?, result: List<String>) -> Unit) {
        val result = IntRange(1, 10).map { "$hashTag - $it" }
        callback(null, result)
    }
}