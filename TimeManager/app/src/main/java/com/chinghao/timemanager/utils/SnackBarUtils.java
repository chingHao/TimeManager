package com.chinghao.timemanager.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by ChingHao on 2017/1/12.
 */

public class SnackBarUtils {
    public static void show(View view, int message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .show();
    }

    public static void show(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .show();
    }

    public static void show(Activity activity, int message) {
        View view = activity.getWindow().getDecorView();
        show(view, message);
    }

    public static void show(Activity activity, String message) {
        View view = activity.getWindow().getDecorView();
        show(view, message);
    }

    public static void showAction(View view, int message, int action, View.OnClickListener listener) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .setAction(action, listener)
                .show();
    }

    public static void showAction(View view, String message, String action, View.OnClickListener listener) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .setAction(action, listener)
                .show();
    }

    public static void showAction(Activity activity, int message, int action, View.OnClickListener listener) {
        View view = activity.getWindow().getDecorView();
        showAction(view, message, action, listener);
    }
}
