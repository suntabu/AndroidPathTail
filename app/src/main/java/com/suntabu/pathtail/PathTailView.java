package com.suntabu.pathtail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by suntabu on 2017/11/11.
 */

public class PathTailView extends View {

    private PathTailHelper mPathTailHelper;
    private Context mContext;

    public PathTailView(Context context) {
        super(context);
        init(context);
    }

    public PathTailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PathTailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint();

        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        paint.setStrokeCap(Paint.Cap.BUTT);

        mPathTailHelper = new PathTailHelper(context, new PathTailHelper.OnInvalidateCallback() {
            @Override
            public void invalidate() {
                PathTailView.this.invalidate();
            }
        }, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mPathTailHelper.handleTouchEvent(event);

//        return super.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPathTailHelper.draw(canvas);
    }
}
