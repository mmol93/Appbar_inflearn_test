package com.example.appbar_inflearn_test

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.example.appbar_inflearn_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binder : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        setSupportActionBar(binder.toolbar)

        // 접었을 때 타이틀 색 지정
        binder.toolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        // 펼쳤을 때 타이틀 색 지정
        binder.toolbarLayout.setExpandedTitleColor(Color.GREEN)

        // 접었을 때 타이틀 위치 지정
        binder.toolbarLayout.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
        // 펼쳤을 때 타이틀 위치 지정
        binder.toolbarLayout.expandedTitleGravity = Gravity.LEFT + Gravity.BOTTOM

        // 이미지뷰 넣기
        binder.imageView.setImageResource(R.drawable.ic_launcher_foreground)

        // 타이틀 변경
        supportActionBar?.title = "타이틀입니다"
    }
}