package dextra.android.appbase.features.home.model

class HomeModel {

    fun fetchPostsByHashTag(hashTag: String) : List<String>? {
        return listOf("Hash1", "Hash2", "Hash3")
    }
}