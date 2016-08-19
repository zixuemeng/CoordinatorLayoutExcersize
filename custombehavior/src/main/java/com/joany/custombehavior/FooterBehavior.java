package com.joany.custombehavior;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by joany on 2016/8/19.
 */
public class FooterBehavior extends CoordinatorLayout.Behavior {
    private int directionChangeDistance;

    public FooterBehavior(Context context,AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       View child, View directTargetChild,
                                       View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout,
                                  View child, View target, int dx, int dy, int[] consumed) {
        if(dy > 0 && directionChangeDistance < 0 || dy < 0 && directionChangeDistance > 0) {
            child.animate().cancel();
            directionChangeDistance = 0;
        }
        directionChangeDistance += dy;
        if(directionChangeDistance > child.getHeight() && child.getVisibility() == View.VISIBLE) {
            hide(child);
        } else if(directionChangeDistance < 0 && child.getVisibility() == View.GONE){
            show(child);
        }
    }

    private void hide(final View view){
        ViewPropertyAnimator animator = view.animate().translationY(view.getHeight())
                .setInterpolator(new FastOutSlowInInterpolator()).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                show(view);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();
    }

    private void show(final View view) {
        ViewPropertyAnimator animator = view.animate().translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator()).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                hide(view);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();
    }
}
