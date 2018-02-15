package com.lvqingyang.offer

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * 一句话功能描述
 * 功能详细描述
 * @author Lv Qingyang
 * @see 相关类/方法
 * @since
 * @date 2018/2/15
 * @email biloba12345@gamil.com
 * @github https://github.com/biloba123
 * @blog https://biloba123.github.io/
 */
fun Context.decodeBitmapFromResource(
        resId: Int,
        reqWith: Int,
        reqHeight: Int
): Bitmap? {
    val options=BitmapFactory.Options()
    //先只测量bitmap的实际宽高
    options.inJustDecodeBounds=true
    BitmapFactory.decodeResource(resources, resId, options)
    options.inSampleSize=calculateInSampleSize(options, reqWith, reqHeight)
    options.inJustDecodeBounds=false
    return  BitmapFactory.decodeResource(resources, resId, options)
}

fun calculateInSampleSize(options: BitmapFactory.Options, reqWith: Int, reqHeight: Int): Int {
    //缩放取宽高缩放数中的小数
    val inSample=Math.min(options.outWidth/reqWith, options.outHeight/reqHeight)
    //保证为2的倍数
    return inSample-inSample%2
}
