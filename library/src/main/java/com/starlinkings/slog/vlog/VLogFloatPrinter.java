package com.starlinkings.slog.vlog;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.starlinkings.slog.dlog.DLog;

/**
 * Created by fastcome1985
 */
public class VLogFloatPrinter {

    /**
     * single instance
     */
    private static VLogFloatPrinter sInstance;

    /**
     * floatview
     */
    private VLogFloatingView mFloatingView = null;

    /**
     *
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /**
     *
     */
    WindowManager mWindowManager;

    /**
     * no instance
     */
    private VLogFloatPrinter() {
    }

    /**
     * @return
     */
    public static VLogFloatPrinter getInstance() {
        if (sInstance == null) {
            synchronized (VLogFloatPrinter.class) {
                if (sInstance == null) {
                    sInstance = new VLogFloatPrinter();
                }
            }
        }
        return sInstance;
    }

    /**
     * @param context
     */
    public void init(Context context) {
        if (mFloatingView == null) {
            mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (mFloatingView == null) {
                mFloatingView = new VLogFloatingView(context);
                mFloatingView.setOnTouchListener(onTouchListener);
            }
            mHandler.post(new Runnable() {
                public void run() {
                    setFloatingView();
                }
            });
        }
    }

    /**
     * set log
     *
     * @param msg
     */
    public void log(final String msg) {
        if (mFloatingView == null || TextUtils.isEmpty(msg)) return;

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mFloatingView.log(msg);
                mFloatingView.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * add log
     *
     * @param msg
     */
    public void appendLog(final String msg) {
        if (mFloatingView == null || TextUtils.isEmpty(msg)) return;

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mFloatingView.appeldLog(msg);
                mFloatingView.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     *
     */
    public void clear() {
        if (mFloatingView == null) return;
        mWindowManager.removeViewImmediate(mFloatingView);
        mFloatingView = null;
    }

    /**
     *
     */
    private void setFloatingView() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.type = WindowManager.LayoutParams.TYPE_PHONE;//TYPE_PHONE 全局,TYPE_APPLICATION
        params.format = PixelFormat.TRANSPARENT;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL //外面可点击
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;//不捕获返回键
        params.x = 0;
        params.y = -mWindowManager.getDefaultDisplay().getHeight() / 2;
        mWindowManager.addView(mFloatingView, params);
    }

    private float mRawX;
    private float mRawY;
    private float mLastX;
    private float mLastY;

    /**
     * floatview move
     */
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            mRawX = event.getRawX();
            mRawY = event.getRawY();
            final int action = event.getAction();

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    mLastX = event.getRawX();
                    mLastY = event.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    updateWindowPosition();
                    mLastX = mRawX;
                    mLastY = mRawY;
                    break;

                case MotionEvent.ACTION_UP:
                    updateWindowPosition();
                    break;
            }
            return true;
        }
    };

    /**
     * update windowview position
     */
    private void updateWindowPosition() {
        WindowManager.LayoutParams params = (WindowManager.LayoutParams) mFloatingView.getLayoutParams();
        params.x = params.x + (int) (mRawX - mLastX);
        params.y = params.y + (int) (mRawY - mLastY);
        mWindowManager.updateViewLayout(mFloatingView, params);
    }

}
