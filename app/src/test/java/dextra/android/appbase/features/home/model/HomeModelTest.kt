package dextra.android.appbase.features.home.model

import dextra.android.appbase.repositories.PostsRepository
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class HomeModelTest {
    @Mock lateinit var postRepository : PostsRepository
    lateinit var homeModel: HomeModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        // Sync RX test
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        // Create a HomeMode with repository mocked
        homeModel = HomeModel(postRepository)
    }

    @Test
    fun fetchPostsByHashTagIsCorrect() {
        val hashtagName = "teste"

        `when`(postRepository.fetchPostsByHashTag(hashtagName))
                .thenReturn(Observable.just(listOf("01 Teste", "02 Teste")))

        with(homeModel) {
            fetchPostsByHashTag(hashtagName) { error, result ->
                // print(result?.get(0)) // See log
            }

            verify(postsRepository, times(1)).fetchPostsByHashTag(hashtagName)
        }
    }
}