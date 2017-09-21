package com.example.maotongfei.kotlindemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by MAOTONGFEI on 2017/9/20.
 */
class KotlinDrawView: View {
    /**
     * 这里如果不想之后都做非空判断可以用 lateinit ，lateinit官方文档解释
     *
     *
     */
    private var paint : Paint ?=null

    private lateinit var mPaint : Paint
    private lateinit var mPath : Path

    constructor(context: Context?) : super(context){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }


    private fun init() {
        //kotlin里面没有new 关键字,创建实例直接可以用类名
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 5f
        mPaint.color = Color.BLACK
        mPaint.textSize = 10f
        mPaint.style = Paint.Style.STROKE
        mPath = Path()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y
        //when的写法就是java里面的switch case,唯一区别是when里面有返回值
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> mPath.moveTo(touchX, touchY)
            MotionEvent.ACTION_MOVE -> mPath.quadTo(touchX, touchY, touchX, touchY)
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(mPath, mPaint)
        super.onDraw(canvas)
    }

    fun clear() {
        mPath.reset()
        invalidate()
    }
}