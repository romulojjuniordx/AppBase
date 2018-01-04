package dextra.android.appbase.features.home.model

import dextra.android.appbase.repositories.PostsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeModel
    constructor(
            var postsRepository: PostsRepository = PostsRepository()
    ){

    fun fetchPostsByHashTag(hashTag: String, callback:(error: Any?, result: List<String>?) -> Unit) {
        postsRepository.fetchPostsByHashTag(hashTag)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { posts -> callback(null, posts) },
                        { e -> callback( e, null) }
                )
    }
}