package com.learning.permohoantes

class NoteModel (
    val permohonan: List<Data>
){
    data class Data (
        val nama: String?,
        val nohp: Int?,
        val noktp: Int?,
        val alamat: String?,
        val pekerjaan: String?,
        val rincian: String?,
        val tujuan: String?)
}


