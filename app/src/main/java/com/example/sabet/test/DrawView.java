package com.example.sabet.test;

/**
 * Created by sabet on 3/30/18.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        // declare each ball with the ColorBall class
        /*colorballs = new ArrayList<ColorBall>();
        colorballs.add(0,new ColorBall(context, R.drawable.gray_circle, point1,0));
        colorballs.add(1,new ColorBall(context, R.drawable.gray_circle, point2,1));
        colorballs.add(2,new ColorBall(context, R.drawable.gray_circle, point3,2));
        colorballs.add(3,new ColorBall(context, R.drawable.gray_circle, point4,3));*/

    }

    // the method that draws the balls
    @Override
    protected void onDraw(Canvas canvas) {
        // canvas.drawColor(0xFFCCCCCC); //if you want another background color

        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#55000000"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
        // mPaint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(5);

        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#55FFFFFF"));

        /*if (groupId == 1) {
            canvas.drawRect(point1.x + colorballs.get(0).getWidthOfBall() / 2,
                    point3.y + colorballs.get(2).getWidthOfBall() / 2, point3.x
                            + colorballs.get(2).getWidthOfBall() / 2, point1.y
                            + colorballs.get(0).getWidthOfBall() / 2, paint);
        } else {
            canvas.drawRect(point2.x + colorballs.get(1).getWidthOfBall() / 2,
                    point4.y + colorballs.get(3).getWidthOfBall() / 2, point4.x
                            + colorballs.get(3).getWidthOfBall() / 2, point2.y
                            + colorballs.get(1).getWidthOfBall() / 2, paint);
        }
        BitmapDrawable mBitmap;
        mBitmap = new BitmapDrawable();

        // draw the balls on the canvas
        for (ColorBall ball : colorballs) {
            canvas.drawBitmap(ball.getBitmap(), ball.getX(), ball.getY(),
                    new Paint());
        }*/
    }
    /*
    // events when touching the screen
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();

        int X = (int) event.getX();
        int Y = (int) event.getY();

        switch (eventaction) {

            case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on
                // a ball
                balID = -1;
                startMovePoint = new Point(X,Y);
                for (ColorBall ball : colorballs) {
                    // check if inside the bounds of the ball (circle)
                    // get the center for the ball
                    int centerX = ball.getX() + ball.getWidthOfBall();
                    int centerY = ball.getY() + ball.getHeightOfBall();
                    paint.setColor(Color.CYAN);
                    // calculate the radius from the touch to the center of the ball
                    double radCircle = Math
                            .sqrt((double) (((centerX - X) * (centerX - X)) + (centerY - Y)
                                    * (centerY - Y)));

                    if (radCircle < ball.getWidthOfBall()) {

                        balID = ball.getID();
                        if (balID == 1 || balID == 3) {
                            groupId = 2;
                            canvas.drawRect(point1.x, point3.y, point3.x, point1.y,
                                    paint);
                        } else {
                            groupId = 1;
                            canvas.drawRect(point2.x, point4.y, point4.x, point2.y,
                                    paint);
                        }
                        invalidate();
                        break;
                    }
                    invalidate();
                }

                break;

            case MotionEvent.ACTION_MOVE: // touch drag with the ball
                // move the balls the same as the finger
                if (balID > -1) {
                    colorballs.get(balID).setX(X);
                    colorballs.get(balID).setY(Y);

                    paint.setColor(Color.CYAN);

                    if (groupId == 1) {
                        colorballs.get(1).setX(colorballs.get(0).getX());
                        colorballs.get(1).setY(colorballs.get(2).getY());
                        colorballs.get(3).setX(colorballs.get(2).getX());
                        colorballs.get(3).setY(colorballs.get(0).getY());
                        canvas.drawRect(point1.x, point3.y, point3.x, point1.y,
                                paint);
                    } else {
                        colorballs.get(0).setX(colorballs.get(1).getX());
                        colorballs.get(0).setY(colorballs.get(3).getY());
                        colorballs.get(2).setX(colorballs.get(3).getX());
                        colorballs.get(2).setY(colorballs.get(1).getY());
                        canvas.drawRect(point2.x, point4.y, point4.x, point2.y,
                                paint);
                    }

                    invalidate();
                }else{
                    if (startMovePoint!=null) {
                        paint.setColor(Color.CYAN);
                        int diffX = X - startMovePoint.x;
                        int diffY = Y - startMovePoint.y;
                        startMovePoint.x = X;
                        startMovePoint.y = Y;
                        colorballs.get(0).addX(diffX);
                        colorballs.get(1).addX(diffX);
                        colorballs.get(2).addX(diffX);
                        colorballs.get(3).addX(diffX);
                        colorballs.get(0).addY(diffY);
                        colorballs.get(1).addY(diffY);
                        colorballs.get(2).addY(diffY);
                        colorballs.get(3).addY(diffY);
                        if(groupId==1)
                            canvas.drawRect(point1.x, point3.y, point3.x, point1.y,
                                    paint);
                        else
                            canvas.drawRect(point2.x, point4.y, point4.x, point2.y,
                                    paint);
                        invalidate();
                    }
                }

                break;

            case MotionEvent.ACTION_UP:
                // touch drop - just do things here after dropping

                break;
        }
        // redraw the canvas
        invalidate();
        return true;

    }*/

    public void shade_region_between_points() {
        canvas.drawRect(point1.x, point3.y, point3.x, point1.y, paint);
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
                break;
            default:break;
        }
        invalidate();
        return true;
    }
}