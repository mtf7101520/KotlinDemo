package com.example.maotongfei.kotlindemo;

import android.text.TextUtils;

/**
 * Created by MAOTONGFEI on 2017/9/21.
 */

public class StringUtil {
    //类的加载是线程安全的
    private static class stringHolder {
        private static StringUtil instance = new StringUtil();
    }

    private StringUtil() {
    }

    public static StringUtil getInstance() {
        return stringHolder.instance;
    }

    //双重锁的单例，volatile通俗的讲就是可以让这个执行有序，就是当instance = new KotlinStringUtil(); 线程A去拿这个instance的时候必须要new KotlinStringUtil()初始化成功之后，再赋值给instance,其他线程在看到instance的时候如果是null，就说明new KotlinStringUtil()初始化还没有成功。这样能确保在其他线程拿到的instance是正确的
    //如果少了这个关键字，之后的所有instance==null的判断都是有问题的
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
     * 拼接字符串
     *
     * @param strs
     * @return
     */
    public static String concat(String... strs) {
        if (null != strs && strs.length > 0) {
            int len = 0;
            for (String str : strs) {
                if (null != str) {
                    len += str.length();
                }
            }
            if (len > 0) {
                StringBuilder sb = new StringBuilder(len);
                for (String str : strs) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            }
        }
        return null;
    }

}
