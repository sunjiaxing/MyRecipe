package com.myrecipe.ui.activity

import android.os.Bundle
import android.os.Handler
import com.myrecipe.R
import org.jetbrains.anko.startActivity

/**
 * 欢迎页面
 */
class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_welcome)
        // 页面延时跳转
        Handler().postDelayed({
            startActivity<MainActivity>()
            finish()
        }, 3_000)
    }
}
