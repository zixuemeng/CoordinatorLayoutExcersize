package com.joany.custombehavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by joany on 2016/8/19.
 */
public class FooterBehaviorDependAppBar extends AppBarLayout.Behavior {

    public FooterBehaviorDependAppBar(Context context,AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        float translationY = Math.abs(dependency.getTranslationY());
        child.setTranslationY(translationY);
        return true;
    }
}
