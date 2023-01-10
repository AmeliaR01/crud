package com.ameliarahmawatiputri.datasiswa

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItem: Serializable {
    @field:SerializedName("siswa_nama")
    val siswaNama: String? = null

    @field:SerializedName("siswa_id")
    val siswaId: String? = null

    @field:SerializedName("siswa_kelas")
    val siswaKelas: String? = null
}