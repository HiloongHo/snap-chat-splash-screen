package com.example.snapchatsplashscreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * 主Activity类，应用的启动点。
 * 实现了Splash Screen的展示，全屏显示以及窗口 insets 的处理。
 */
class MainActivity : AppCompatActivity() {

    /**
     * 创建Activity时被调用，用于初始化Activity的组件和设置。
     *
     * @param savedInstanceState 保存的实例状态，在Activity重建时使用。
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 暂停3秒，模拟加载延迟（实际开发中避免使用，仅作示例）
        Thread.sleep(3000)

        // 初始化Splash Screen，与主题中的SplashScreen相关设置配合使用
        installSplashScreen()

        // 启用Edge-to-Edge模式，以适应全面屏，隐藏系统装饰（如状态栏和导航栏）
        enableEdgeToEdge()

        // 设置Activity的布局文件
        setContentView(R.layout.activity_main)

        // 为id为main的视图设置一个监听器，用于处理系统窗口插入的变化
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // 获取系统栏占据的空间大小
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // 根据系统栏尺寸设置视图的内边距，确保内容不会被遮挡
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // 返回 insets，允许其他监听器继续处理
            insets
        }
    }
}
