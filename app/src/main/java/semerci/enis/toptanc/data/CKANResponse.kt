package semerci.enis.toptanc.data

data class CKANResponse(
    val help: String?,
    val success: Boolean,
    val result: CKANResult?
)

data class CKANResult(
    val resource_id: String?,
    val fields: List<CKANField>?,
    val records: List<CKANRecord>?,
    val limit: Int?,
    val total: Int?
)

data class CKANField(
    val type: String?,
    val id: String?
)

data class CKANRecord(
    val _id: Int?,
    val TARIH: String?,
    val MAL_TURU: String?,
    val MAL_ADI: String?,
    val BIRIM: String?,
    val ASGARI_FIYAT: Int?,
    val AZAMI_FIYAT: String?,
    val ORTALAMA_FIYAT: String?
)