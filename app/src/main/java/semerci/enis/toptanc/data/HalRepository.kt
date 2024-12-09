package semerci.enis.toptanc.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class HalRepository {

    private val resourceId = "71ab2fea-f2f5-4401-85cf-dba09baf5135"

    suspend fun getHalData(
        limit: Int = 100,
        query: String? = null,
        filtersJson: String? = null
    ): List<CKANRecord> = withContext(Dispatchers.IO) {
        val response = RetrofitClient.apiService.getHalData(
            resourceId = resourceId,
            limit = limit,
            query = query,
            filters = filtersJson
        ).awaitResponse()

        if (response.isSuccessful) {
            val body = response.body()
            val records = body?.result?.records
            records ?: emptyList()
        } else {
            throw Exception("Sunucu hatası: ${response.code()}")
        }
    }
}