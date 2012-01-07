package com.example;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class PropertyAnimationExample extends Activity {
    int i = 0;
    boolean toggle = true;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digit);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            final TextView tv = (TextView) findViewById(R.id.text1);
            final TextView alt = (TextView) findViewById(R.id.text2);
            float new_y = 0.25f * tv.getHeight();
            
            AnimatorSet set = new AnimatorSet();

            if (toggle) {
                AnimatorSet test = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.set);
                test.setTarget(tv);
                test.start();

//                ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, View.ALPHA, 0f);
//                ObjectAnimator slide = ObjectAnimator.ofFloat(tv, View.TRANSLATION_Y, 100f);
//                ObjectAnimator scale = ObjectAnimator.ofFloat(tv, View.SCALE_X, 2f);
//                set.play(alpha).with(slide).after(scale);
                
//                set.play(scale).before(slide);
//                set.play(slide).with(alpha);
                
//                tv.animate().yBy(new_y).alpha(0f).setDuration(250);
//                alt.animate().yBy(-new_y).alpha(1f).setDuration(250);
            } else {
                ObjectAnimator scale = ObjectAnimator.ofFloat(tv, View.SCALE_X, 1f);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, View.ALPHA, 1f);
                ObjectAnimator slide_up = ObjectAnimator.ofFloat(tv, View.TRANSLATION_Y, -new_y);
                set.play(alpha).with(slide_up).before(scale);

//                tv.animate().yBy(-new_y).alpha(1f).setDuration(250);
//                alt.animate().yBy(new_y).alpha(0f).setDuration(250);
            }
            set.setDuration(1000);
            set.start();
            toggle = !toggle;
            return true;
        }
        return super.onTouchEvent(event);
    }
}
