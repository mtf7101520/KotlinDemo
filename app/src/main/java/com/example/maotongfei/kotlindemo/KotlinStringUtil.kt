package com.example.maotongfei.kotlintest

import android.text.TextUtils

/**
 * Created by MAOTONGFEI on 2017/9/21.
 */

class KotlinStringUtil {

    //双重锁的单例，volatile通俗的讲就是可以让这个执行有序，就是当instance = new KotlinStringUtil(); 线程A去拿这个instance的时候必须要new KotlinStringUtil()
    // 初始化成功之后，再赋值给instance,其他线程在看到instance的时候如果是null，就说明new KotlinStringUtil()初始化还没有成功。这样能确保在其他线程拿到的
    // instance是正确的 如果少了这个关键字，之后的所有instance==null的判断都是有问题的
    /**
     * java
     */
    //    private static volatile KotlinStringUtil instance;
    //
    //    private KotlinStringUtil() {
    //    }
    //
    //    public static KotlinStringUtil getInstance() {
    //        if (instance == null) {
    //            synchronized (KotlinStringUtil.class) {
    //                if (instance == null) {
    //                    instance = new KotlinStringUtil();
    //                }
    //            }
    //        }
    //        return instance;
    //    }

    /**
     * kotlin
     */
    //
//    companion object {
//        val instance by lazy(mode= LazyThreadSafetyMode.SYNCHRONIZED){
//            KotlinStringUtil()
//        }
//    }


    //相当于java的匿名内部类
    private object stringHolder {
        val instance = KotlinStringUtil()
    }


    //An object declaration inside a class can be marked with the companion keyword:
    //Kotlin的不支持static变量,所以这里用的是companion object 来替代，效果和static类似,称作伴生对象，半生对象和类是一一对应的，所以可以直接用类名调用
    companion object {
        fun getInstance() =stringHolder.instance
    }

    /**
     * 拼接字符串
     *
     * @param strs
     * @return
     */
    fun concat(vararg strs: String): String? {
        if (strs.isNotEmpty()) {
            val len = strs.sumBy { it.length }
            if (len > 0) {
                val sb = StringBuilder(len)
                strs.filterNot { TextUtils.isEmpty(it) }.forEach { sb.append(it) }
                return sb.toString()
            }
        }
        return null
    }

}
