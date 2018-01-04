package dextra.android.appbase.repositories

import io.reactivex.Observable

// TODO: http request with hashTag
class PostsRepository {

    fun fetchPostsByHashTag(hashTag: String): Observable<List<String>> {
        return Observable.just(IntRange(1, 15).map { "$it $hashTag" })
    }
}