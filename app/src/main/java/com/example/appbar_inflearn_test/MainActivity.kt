package com.example.appbar_inflearn_test

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.appbar_inflearn_test.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout

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

        // 슬라이드를 하더라도 앱바가 그대로 있게 변경한다
        // (이 기능은 켜고 끌 수 있다) = true: 켠다 / false: 끈다
        ((binder.appbar.layoutParams as CoordinatorLayout.LayoutParams)
            .behavior as BlockableAppBarLayoutBehavior).isShouldScroll = false
    }

    class BlockableAppBarLayoutBehavior(context: Context, attrs: AttributeSet) : AppBarLayout.Behavior(context, attrs) {
        var isShouldScroll = false

        override fun onStartNestedScroll(
            parent: CoordinatorLayout,
            child: AppBarLayout,
            directTargetChild: View,
            target: View,
            nestedScrollAxes: Int,
            type: Int) = isShouldScroll

        override fun onTouchEvent(
            parent: CoordinatorLayout,
            child: AppBarLayout,
            ev: MotionEvent) = isShouldScroll && super.onTouchEvent(parent, child, ev)
    }
}