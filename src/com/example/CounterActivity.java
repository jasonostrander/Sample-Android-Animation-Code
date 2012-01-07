package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.TimeUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class CounterActivity extends Activity {
    int i = 0;
    private long mStart = 0;
    private long mTime = 0;
    
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            long current = System.currentTimeMillis();
            mTime += current - mStart;
            mStart = current;
            
            setTime(mTime);
            
            mHandler.sendEmptyMessageDelayed(0, 250);
        };
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        mStart = System.currentTimeMillis();
        mHandler.sendEmptyMessage(0);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mTime += 1000;
            setTime(mTime);
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void setTime(long time) {
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        if (time > 3600*1000) {
            hours = time/(3600*1000);
            time -= hours*3600*1000;
        }
        if (time > 60*1000) {
            minutes = time/(60*1000);
            time -= minutes*60*1000;
        }
        if (time > 1000) {
            seconds = time/1000;
            time -= seconds*1000;
        }

        animateDigit(R.id.minute2, minutes%10);
        animateDigit(R.id.minute1, minutes/10);
        animateDigit(R.id.hour2, hours%10);
        animateDigit(R.id.hour1, hours/10);
        animateDigit(R.id.second2, seconds%10);
        animateDigit(R.id.second1, seconds/10);
    }
    
    private void animateDigit(final int id, final long value) {
        final View v = findViewById(id);
        final TextView text1 = (TextView) v.findViewById(R.id.text1);
        final TextView text2 = (TextView) v.findViewById(R.id.text2 );

        boolean running = false;
        Object obj = text1.getTag();
        if (obj != null) running = (Boolean) obj;
        
        if (Long.parseLong(text1.getText().toString()) == value || running) return;

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_out);
        animation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            
            @Override
            public void onAnimationEnd(Animation animation) {
                text1.setText("" + value);
                text1.setTag(false);
            }
        });
        text1.startAnimation(animation);
        text1.setTag(true);
        
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_in);
        text2.startAnimation(animation);
        text2.setText("" + value);
    }
}
