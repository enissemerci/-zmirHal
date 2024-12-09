package semerci.enis.toptanc.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HalApiService {
    @GET("datastore_search")
    fun getHalData(
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: Int = 100,
        @Query("q") query: String? = null,
        @Query("filters") filters: String? = null
    ): Call<CKANResponse>

    @GET("datastore_search_sql")
    fun getHalDataSql(
        @Query("sql", encoded = true) sqlQuery: String
    ): Call<CKANResponse>
}