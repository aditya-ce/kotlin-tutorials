package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals

class NetworkMarsRepositoryTest {
    @Test
    fun networkMarsRepositoryTest_getMarsPhotos_verifyPhotoList() {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
    }

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest{
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService())
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
}