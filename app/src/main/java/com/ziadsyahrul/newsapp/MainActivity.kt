package com.ziadsyahrul.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_item.*

// Class MainActivity mewarisi kelas AppCompatActivity()
class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    //oncreate disini salah satu contoh proses pewarisan
    //dimana oncreate diturunkan dari AppCompatActivity()
    //lalu oncreate dipanggil di MainActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //argument -> posisi sama kayak parameter
        // isian setelah fungsi tertentu yang memiliki parameter
        // setContentView(..'argument'..)
        setContentView(R.layout.activity_main)

        var headlineNews: Model?
        if (NewsModel.newsList.size > 0){
            headlineNews = NewsModel.newsList[NewsModel.newsList.size-1]
            txt_title_headline.setText(headlineNews.title)
            txt_description_headline.setText(headlineNews.desc)
            img_headline.setImageResource(headlineNews.photo)

            cv_newsheadline.setOnClickListener {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.titleNews,headlineNews.title.toString())
                    putExtra(DetailActivity.photoNews,headlineNews.photo.toString())
                }

                startActivity(intent)
                finish()
            }
        }

//        rv_daftar_berita.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
//            adapter = NewsAdapter(this@MainActivity, NewsModel.newsList)
//        }

        val layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        rv_daftar_berita.layoutManager = layoutManager

        newsAdapter = NewsAdapter(this, NewsModel.newsList)
        rv_daftar_berita.adapter = newsAdapter

        newsAdapter.setOnItemClickCallback(
            object : NewsAdapter.ItemCallBack {
                override fun onItemClick(data: Model) {
                    val intent = Intent(this@MainActivity,
                        DetailActivity::class.java).apply {
                        putExtra(DetailActivity.titleNews, data.title.toString())
                        putExtra(DetailActivity.photoNews, data.photo.toString())
                    }
                    startActivity(intent)
                    finish()
                }
            })

    }
}

//DONEE//  :)