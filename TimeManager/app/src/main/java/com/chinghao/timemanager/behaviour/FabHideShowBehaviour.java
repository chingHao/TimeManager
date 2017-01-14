package com.chinghao.timemanager.behaviour;

import android.animation.FloatArrayEvaluator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ChingHao on 2017/1/12.
 */

public class FabHideShowBehaviour extends FloatingActionButton.Behavior {
    private static final String TAG = "FabHideShowBehaviour";

    public FabHideShowBehaviour() {
    }

    public FabHideShowBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
//        Log.i(TAG, "onNestedScroll: " + dyConsumed + " : " + dyUnconsumed);

        if ((dyConsumed > 0) && child.isShown()) child.hide();
        else if ((dyConsumed < 0 || dyUnconsumed > 0) && !child.isShown()) child.show();

    }
}
