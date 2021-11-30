package com.example.smoothiefeedapp.data.implementations

import com.example.smoothiefeedapp.data.apis.VKApi
import com.example.smoothiefeedapp.data.daos.NewsDao
import com.example.smoothiefeedapp.data.enteties.db.NewsEntity
import com.example.smoothiefeedapp.domain.repositories.NewsRepository
import com.example.smoothiefeedapp.domain.enteties.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlin.math.abs

class NewsRepositoryImpl(
    private val newsApi: VKApi,
    private val newsDao: NewsDao,
    private val preferencesDatastoreRepository: DatastoreRepositoryImpl
): NewsRepository {
    private var nextFrom = ""

    override fun getNews(): Flow<List<News>> {
        return newsDao.getNewsEntity().map { newsList ->
            newsList.map { newsEntity ->
                News(
                    id = newsEntity.id,
                    text = newsEntity.text,
                    photoUrls = newsEntity.photoUrls,
                    publicName = newsEntity.publicName,
                    publicPhotoUrl = newsEntity.publicPhotoUrl
                )
            }
        }
    }

    override suspend fun loadNews(){
        preferencesDatastoreRepository.getToken("vk").collect { vkToken ->
            if (!vkToken.isNullOrEmpty()){
                val newsResponse = newsApi.getNews(
                    token = vkToken,
                    count = 10,
                    startFrom = nextFrom
                ).response

                nextFrom = newsResponse.nextFrom ?: ""

                newsDao.addNewsEntityList(
                    newsResponse.items?.map { newsItem ->
                        val newsGroup = newsResponse.groups?.find { newsGroup ->
                            newsGroup.id == abs(newsItem.sourceId ?: 0)
                        }
                        NewsEntity(
                            id = newsItem.sourceId ?: 0,
                            text = newsItem.text ?: "",
                            photoUrls = newsItem.attachments?.filter { newsAttachment ->
                                newsAttachment.type == "photo"
                            }?.map {
                                String(
                                    it.photo?.sizes?.last()?.url?.toCharArray()
                                        ?: charArrayOf()
                                )
                            } ?: emptyList(),
                            publicName = newsGroup?.name ?: "",
                            publicPhotoUrl = newsGroup?.photoUrl ?: ""
                        )
                    } ?: emptyList()
                )
            }
        }
    }

    override suspend fun deleteAllNews() {
        newsDao.deleteAllNewsEntity()
    }
}