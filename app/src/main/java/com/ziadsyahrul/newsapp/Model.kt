package com.ziadsyahrul.newsapp

data class Model(var title: String, var desc: String, var photo: Int)

object NewsModel{
    val newsList = listOf<Model>(
        Model(
            "Pasar Ramai dikunjungi warga meskipun wabah covid19 belum dinyatakan berakhir",
            "detik.com | 1 jam yang lalu",
            R.drawable.img_news1
        ),

        Model(
            "Kapal Nelayan menyalurkan bansos masyarakat sulawesi",
            "detik.com | 2 jam yang lalu",
            R.drawable.img_news2
        ),

        Model(
            "Macet mulai terjadi di wilayah jalur pemudik semarang",
            "detik.com | 30 menit yang lalu",
            R.drawable.img_news3
        ),

        Model(
            "Jelang new normal Jakarta macet lagi",
            "detik.com | 20 menit yang lalu",
            R.drawable.img_news4
        )
    )

}