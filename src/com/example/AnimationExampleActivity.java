package com.example;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationExampleActivity extends Activity {
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView iv = (ImageView) findViewById(R.id.image_view);
        iv.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView iv = (ImageView) v;
//                AnimationDrawable ad = (AnimationDrawable) iv.getDrawable();
//                ad.stop();
//                ad.start();
                
//                TranslateAnimation anim = 
//                    new TranslateAnimation(
//                            TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 
//                            TranslateAnimation.RELATIVE_TO_SELF, 0.25f, 
//                            TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 
//                            TranslateAnimation.RELATIVE_TO_SELF, 0.25f);
//                anim.setDuration(500);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.simple_set);
                iv.startAnimation(anim);
                
                return true;
            }
        });
        
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        ImageView iv = (ImageView) findViewById(R.id.image_view);
//        AnimationDrawable ad = (AnimationDrawable) iv.getDrawable();
//        ad.start();
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            ImageView iv = (ImageView) findViewById(R.id.image_view);
//            AnimationDrawable ad = (AnimationDrawable) iv.getDrawable();
//            ad.stop();
//            ad.start();
//            return true;
//        }
//        return super.onTouchEvent(event);
//    }

    //    @Override
    //    public boolean onTouchEvent(MotionEvent event) {
    //        if (event.getAction() == MotionEvent.ACTION_DOWN) {
    //            i += 1;
    //            if (i%10 == 0) i = 0;
    //
    //            final TextView tv = (TextView) findViewById(R.id.text1);
    //            Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_out);
    //            animation.setAnimationListener(new AnimationListener() {
    //                @Override
    //                public void onAnimationStart(Animation animation) {
    //                }
    //                
    //                @Override
    //                public void onAnimationRepeat(Animation animation) {
    //                }
    //                
    //                @Override
    //                public void onAnimationEnd(Animation animation) {
    //                    tv.setText("" + i);
    //                }
    //            });
    //            tv.startAnimation(animation);
    //            
    //            TextView alt = (TextView) findViewById(R.id.text2);
    //            animation = AnimationUtils.loadAnimation(this, R.anim.slide_in);
    //            alt.startAnimation(animation);
    //            alt.setText("" + i);
    //            return true;
    //        }
    //        return super.onTouchEvent(event);
    //    }
}