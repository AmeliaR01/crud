package com.ameliarahmawatiputri.datasiswa

import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: UpdateActivity) {
    //Add data
    fun addData(nama: String, kelas: String) {
        NetworkConfig.getService()
            .addSiswa(nama, kelas)
            .enqueue(object : retrofit2.Callback<StatusModel> {
                override fun onFailure(call: Call<StatusModel>, t: Throwable) {
                    crudView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<StatusModel>, response: Response<StatusModel>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessAdd(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    //update data
    fun updateData(id: String, nama: String, kelas: String) {
        NetworkConfig.getService()
            .updateSiswa(id, nama, kelas)
            .enqueue(object : retrofit2.Callback<StatusModel> {
                override fun onFailure(call: Call<StatusModel>, t: Throwable) {
                    crudView.onErrorupdate(t.localizedMessage)
                }

                override fun onResponse(call: Call<StatusModel>, response: Response<StatusModel>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorupdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}