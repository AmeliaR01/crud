package com.ameliarahmawatiputri.datasiswa

import com.google.gson.annotations.SerializedName

class SiswaModel {
    @field:SerializedName("pesan")
    val pesan: String? = null

    @field:SerializedName("siswa")
    val siswa: List<DataItem>? = null

    @field:SerializedName("status")
    val status: Int? = null
}