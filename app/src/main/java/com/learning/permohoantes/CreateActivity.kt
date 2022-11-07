package com.learning.permohoantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etNohp : EditText
    private lateinit var etNoktp : EditText
    private lateinit var etAlamat : EditText
    private lateinit var etPekerjaan : EditText
    private lateinit var etRincian : EditText
    private lateinit var etTujuan : EditText
    private lateinit var btnSaveData : Button
    private lateinit var btnMenu : Button

    private val api by lazy { ApiRetrofit().endpoint}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        etName = findViewById(R.id.etName)
        etNohp = findViewById(R.id.etNohp)
        etNoktp = findViewById(R.id.etNoktp)
        etAlamat = findViewById(R.id.etAlamat)
        etPekerjaan = findViewById(R.id.etPekerjaan)
        etRincian = findViewById(R.id.etRincian)
        etTujuan = findViewById(R.id.etTujuan)
        btnSaveData = findViewById(R.id.btnSave)
        btnMenu = findViewById(R.id.btnMenu)

    btnMenu.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    btnSaveData.setOnClickListener{
        savepermohonanData()
    }
}

private fun savepermohonanData(){

    //getting values
    val nama = etName.text.toString()
    val nohp = etNohp.text.toString()
    val noktp = etNoktp.text.toString()
    val alamat = etAlamat.text.toString()
    val pekerjaan = etPekerjaan.text.toString()
    val rincian = etRincian.text.toString()
    val tujuan = etTujuan.text.toString()

    api.createData(nama, nohp, noktp, alamat, pekerjaan, rincian, tujuan)
        .enqueue(object : Callback<SubmitModel> {
            override fun onResponse(call: Call<SubmitModel>, response: Response<SubmitModel>) {
                if (response.isSuccessful){
                    val submit = response.body()
                    Toast.makeText(
                        applicationContext,submit!!.messaage, Toast.LENGTH_SHORT
                    ).show()
                    etName.text.clear()
                    etNohp.text.clear()
                    etNoktp.text.clear()
                    etAlamat.text.clear()
                    etPekerjaan.text.clear()
                    etRincian.text.clear()
                    etTujuan.text.clear()
                }
            }

            override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
            }

        })

    }
}