package com.ameliarahmawatiputri.datasiswa

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

@Suppress("SENSELESESS_C0MPARISON")
class UpdateActivity : AppCompatActivity(),CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var btnAction: Button
    private lateinit var etNama:Button
    private lateinit var etKelas:Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            btnAction.text = "Tambah"
            btnAction.setOnClickListener() {
                presenter.addData(
                    etNama.text.toString(),
                    etKelas.text.toString())
            }
        } else if (itemDataItem != null) {
            btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            etNama.setText(item?.siswaNama.toString())
            etKelas.setText(item?.siswaKelas.toString())
            btnAction.setOnClickListener() {
                presenter.updateData(
                    item?.siswaId ?: "",
                    etNama.text.toString(),
                    etKelas.text.toString())
                finish()
            }
        }
    }

    override fun onSuccessAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorAdd(msg: String) {}

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorupdate(msg: String) {}

    override fun onSuccessGet(data: List<DataItem>?) {}

    override fun onFailedGet(msg: String) {}

    override fun onSuccessDelete(msg: String) {}

    override fun onErrorDelete(msg: String) {}
    }