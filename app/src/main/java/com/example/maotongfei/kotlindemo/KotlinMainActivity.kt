package com.example.maotongfei.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.maotongfei.kotlintest.KotlinStringUtil
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by MAOTONGFEI on 2017/9/18.
 */
class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //通常情况下都是这样写的
//        val drawView = findViewById(R.id.draw_view) as DrawView
//        val button = findViewById(R.id.clear_canvas) as Button
//        button.setOnClickListener({
//            drawView.clear()
//        })

        /**
         * 这里可以使用Kotlin Android Extensions 插件 Instead of findViewById(R.id.textView) as TextView
         * The Kotlin Android Extensions plugin allows us to obtain the same experience we have with some of these libraries,
        without having to add any extra code or shipping any additional runtime.
         */
        //lambda 表达式不必再实现一个匿名内部类
        clear_canvas.setOnClickListener({
            //在Kotlin代码里面我们也可以调用JAVA代码，两者是可以共存的
            showLog("click clear")
            Toast.makeText(this, getClassName("mao:"), Toast.LENGTH_SHORT).show()
            draw_view.clear()
        })

    }

    /**
     * 无返回值的方法 形参定义的方式也略有不同 ，Unit表示无返回值，也可以省略
     */
    private fun showLog(toastStr: String): Unit {
        Log.e("mao", toastStr)
    }

    /**
     * 有返回值的方法
     * 这里写法很多，可以这样写，也可以常规的写法return 一下，也可以省略：String 返回值，Kotlin有类型推导的特性，会自动判断返回的是什么类型
     * 这里为了体验一下Kotlin的单例写法,写了个单例
     *
     */
    private fun getClassName(name: String): String? =
            KotlinStringUtil.getInstance().concat(name, this.localClassName)
}
