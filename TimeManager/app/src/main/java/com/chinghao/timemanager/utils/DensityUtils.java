package com.chinghao.timemanager.utils;

import android.content.Context;

/**
 * Created by ChingHao on 2017/1/13.
 */

public class DensityUtils {
    /**
     *  dip 转成为 px
     */
    public static int dip2px(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int) (dpValue*scale+0.5F);
    }

    /**
     * px 转成为 dip
     */
    public static int px2dip(Context context,float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue/scale+0.5F);
    }
}
