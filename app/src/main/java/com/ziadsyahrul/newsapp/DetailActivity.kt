package com.ziadsyahrul.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.row_item.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val titleNews = "TitleNews"
        const val photoNews = "PhotoNews"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txt_titlenews.setText(intent.getStringExtra(titleNews))
        img_detail.setImageResource(intent.getStringExtra(photoNews).toInt())


        btn_back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}