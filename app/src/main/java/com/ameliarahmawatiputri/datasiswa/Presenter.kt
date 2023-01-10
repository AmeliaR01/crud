package com.ameliarahmawatiputri.datasiswa

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class Presenter (val crudView: MainActivity){
    //fungsi get data
    fun getData() {
        NetworkConfig.getService().getData()
            .enqueue(object : retrofit2.Callback<SiswaModel> {
                override fun onFailure(call: Call<SiswaModel>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<SiswaModel>, response: Response<SiswaModel>) {
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        if (status == 200) {
                            val data = response.body()?.siswa
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    //hapus data
    fun hapusData(id: String?) {
        NetworkConfig.getService()
            .deleteSiswa(id)
            .enqueue(object : retrofit2.Callback<StatusModel> {
                override fun onFailure(call: Call<StatusModel>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(call: Call<StatusModel>, response: Response<StatusModel>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}