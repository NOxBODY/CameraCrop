package com.example.sabet.test;

/**
 * Created by sabet on 3/30/18.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class DrawView extends View implements View.OnTouchListener{
    private int _xDelta;
    private int _yDelta;
    public static Point point1, point3;
    public static Point point2, point4;
    Point startMovePoint;
    public ImageView ib1,ib2,ib3,ib4;
    RelativeLayout root;
    RelativeLayout.LayoutParams layoutParams;
    /**
     * point1 and point 3 are of same group and same as point 2 and point4
     */
    int groupId = 2;
    private ArrayList<ColorBall> colorballs;
    // array that holds the balls
    private int balID = 0;
    // variable to know what ball is being dragged
    Paint paint;
    Canvas canvas;

    public DrawView(Context context) {
        super(context);
//        init(context);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        init(context);
    }

    public void init(Context context) {
//        root = findViewById(R.id.root);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        setFocusable(true); // necessary for getting the touch events
        canvas = new Canvas();
        // setting the start point for the balls
        point1 = new Point();
        point1.x = 50;
        point1.y = 20;
        ib1 = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.leftMargin = point1.x;
        layoutParams.topMargin = point1.y;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        ib1.setLayoutParams(layoutParams);
        ib1.setId(R.id.ib1);
        ib1.setImageResource(R.drawable.gray_circle);
        ib1.setOnTouchListener(this);
        root.addView(ib1);

        point2 = new Point();
        point2.x = 450;
        point2.y = 20;
        ib2 = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.leftMargin = point2.x;
        layoutParams.topMargin = point2.y;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        ib2.setLayoutParams(layoutParams);
        ib2.setId(R.id.ib2);
        ib2.setImageResource(R.drawable.gray_circle);
        ib2.setOnTouchListener(this);
        root.addView(ib2);

        point3 = new Point();
        point3.x = 450;
        point3.y = 520;
        ib3 = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.leftMargin = point3.x;
        layoutParams.topMargin = point3.y;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        ib3.setLayoutParams(layoutParams);
        ib3.setId(R.id.ib3);
        ib3.setImageResource(R.drawable.gray_circle);
        ib3.setOnTouchListener(this);
        root.addView(ib3);

        point4 = new Point();
        point4.x = 50;
        point4.y = 520;
        ib4 = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.leftMargin = point4.x;
        layoutParams.topMargin = point4.y;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        ib4.setLayoutParams(layoutParams);
        ib4.setId(R.id.ib4);
        ib4.setImageResource(R.drawable.gray_circle);
        ib4.setOnTouchListener(this);
        root.addView(ib4);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        startMovePoint = new Point((int)event.getRawX(),(int)event.getRawY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                _xDelta = startMovePoint.x - lParams.leftMargin;
                _yDelta = startMovePoint.y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams.leftMargin = startMovePoint.x - _xDelta;
                layoutParams.topMargin = startMovePoint.y - _yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                v.setLayoutParams(layoutParams);
                //joy
                if(v.getId()==R.id.ib1){
                    point1.x= (int) v.getX();
                    point1.y= (int) v.getY();

                    //point 2 and point 4 also change
                    RelativeLayout.LayoutParams layoutParamsP2 = (RelativeLayout.LayoutParams) ib2.getLayoutParams();
                    //layoutParams.leftMargin = startMovePoint.x - _xDelta;
                    layoutParamsP2.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP2.rightMargin = -250;
                    layoutParamsP2.bottomMargin = -250;
                    ib2.setLayoutParams(layoutParamsP2);
                    point2.x= (int) ib2.getX();
                    point2.y= (int) ib2.getY();

                    RelativeLayout.LayoutParams layoutParamsP4 = (RelativeLayout.LayoutParams) ib4.getLayoutParams();
                    layoutParamsP4.leftMargin = startMovePoint.x - _xDelta;
                    //layoutParamsP4.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP4.rightMargin = -250;
                    layoutParamsP4.bottomMargin = -250;
                    ib4.setLayoutParams(layoutParamsP4);
                    point4.x= (int) ib4.getX();
                    point4.y= (int) ib4.getY();

                    groupId=1;

                }else if(v.getId()==R.id.ib2){
                    point2.x= (int) v.getX();
                    point2.y= (int) v.getY();

                    //point 1 and point 3 also change
                    RelativeLayout.LayoutParams layoutParamsP1 = (RelativeLayout.LayoutParams) ib1.getLayoutParams();
                    //layoutParams.leftMargin = startMovePoint.x - _xDelta;
                    layoutParamsP1.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP1.rightMargin = -250;
                    layoutParamsP1.bottomMargin = -250;
                    ib1.setLayoutParams(layoutParamsP1);
                    point1.x= (int) ib1.getX();
                    point1.y= (int) ib1.getY();

                    RelativeLayout.LayoutParams layoutParamsP3 = (RelativeLayout.LayoutParams) ib3.getLayoutParams();
                    layoutParamsP3.leftMargin = startMovePoint.x - _xDelta;
                    //layoutParamsP4.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP3.rightMargin = -250;
                    layoutParamsP3.bottomMargin = -250;
                    ib3.setLayoutParams(layoutParamsP3);
                    point3.x= (int) ib3.getX();
                    point3.y= (int) ib3.getY();

                    groupId=2;

                }else if(v.getId()==R.id.ib3){
                    point3.x= (int) v.getX();
                    point3.y= (int) v.getY();

                    //point 2 and point 4 also change
                    RelativeLayout.LayoutParams layoutParamsP2 = (RelativeLayout.LayoutParams) ib2.getLayoutParams();
                    layoutParamsP2.leftMargin = startMovePoint.x - _xDelta;
                    //layoutParamsP2.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP2.rightMargin = -250;
                    layoutParamsP2.bottomMargin = -250;
                    ib2.setLayoutParams(layoutParamsP2);
                    point2.x= (int) ib2.getX();
                    point2.y= (int) ib2.getY();

                    RelativeLayout.LayoutParams layoutParamsP4 = (RelativeLayout.LayoutParams) ib4.getLayoutParams();
                    //layoutParamsP4.leftMargin = startMovePoint.x - _xDelta;
                    layoutParamsP4.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP4.rightMargin = -250;
                    layoutParamsP4.bottomMargin = -250;
                    ib4.setLayoutParams(layoutParamsP4);
                    point4.x= (int) ib4.getX();
                    point4.y= (int) ib4.getY();

                    groupId=1;

                }else {
                    point4.x= (int) v.getX();
                    point4.y= (int) v.getY();

                    //point 1 and point 3 also change
                    RelativeLayout.LayoutParams layoutParamsP1 = (RelativeLayout.LayoutParams) ib1.getLayoutParams();
                    layoutParamsP1.leftMargin = startMovePoint.x - _xDelta;
                    //layoutParamsP1.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP1.rightMargin = -250;
                    layoutParamsP1.bottomMargin = -250;
                    ib1.setLayoutParams(layoutParamsP1);
                    point1.x= (int) ib1.getX();
                    point1.y= (int) ib1.getY();

                    RelativeLayout.LayoutParams layoutParamsP3 = (RelativeLayout.LayoutParams) ib3.getLayoutParams();
                    //layoutParamsP3.leftMargin = startMovePoint.x - _xDelta;
                    layoutParamsP3.topMargin = startMovePoint.y - _yDelta;
                    layoutParamsP3.rightMargin = -250;
                    layoutParamsP3.bottomMargin = -250;
                    ib3.setLayoutParams(layoutParamsP3);
                    point3.x= (int) ib3.getX();
                    point3.y= (int) ib3.getY();
                    groupId=2;
                }
                break;
            default:break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(point1.x+50,point1.y+50,point3.x+50,point3.y+50);
        canvas.drawRect(rect,paint);
    }
}