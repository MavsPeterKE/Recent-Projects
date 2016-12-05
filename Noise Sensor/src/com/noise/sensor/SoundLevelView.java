package com.noise.sensor;

import com.noise.sensor.R;
import com.noise.sensor.R.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

class SoundLevelView extends View {
        private Drawable mGreen;
        private Drawable mRed;
        private Paint mBackgroundPaint;
        
        private int mHeight;
        private int mWidth;
        
        private int mThreshold = 0;
        private int mVol = 0;
        
        
        public SoundLevelView(Context context, AttributeSet attrs) {
               super(context, attrs);  
 
                mGreen 	= context.getResources().getDrawable(
                          R.drawable.greenbar);
                mRed 	= context.getResources().getDrawable(
                          R.drawable.redbar);
                
                mWidth  = mGreen.getIntrinsicWidth();
                setMinimumWidth(mWidth*10);
                
                mHeight = mGreen.getIntrinsicHeight();
                setMinimumHeight(mHeight);
                
                //Used to paint canvas background color
                mBackgroundPaint = new Paint();
                mBackgroundPaint.setColor(Color.BLACK);
        
        }
        
        public void setLevel(int volume, int threshold) {
                if (volume == mVol && threshold == mThreshold) return;
                mVol = volume;
                mThreshold = threshold;
                
                // invalidate Call onDraw method and draw voice points
                invalidate();
        }
        
        @Override
        public void onDraw(Canvas canvas) {
               
                canvas.drawPaint(mBackgroundPaint);
               
                for (int i=0; i<= mVol; i++) {
                        Drawable bar;
                        if (i<mThreshold) 
                        	bar = mGreen;
                        else             
                        	bar = mRed;
                        //Toast.makeText(SoundLevelView.this, "Destructive Level", Toast.LENGTH_SHORT).show();
 
                        bar.setBounds((10-i)*mWidth, 0, (10-i+1)*mWidth, mHeight); //
                        bar.draw(canvas);
                }
        }
}
