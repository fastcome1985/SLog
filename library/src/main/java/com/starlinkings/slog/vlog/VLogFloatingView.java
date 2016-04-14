package com.starlinkings.slog.vlog;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.starlinkings.slog.R;

/**
 * floatingview
 * Created by fastcome1985
 */
public class VLogFloatingView extends LinearLayout {
    private TextView mTextView;

    public VLogFloatingView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        init();
    }

    /**
     * add textview
     */
    private void init() {
        mTextView = new TextView(getContext());
        mTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        mTextView.setText("Vlog floatview");
        mTextView.setTextColor(getResources().getColor(R.color.white));
        mTextView.setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundColor(getResources().getColor(R.color.bg_half_transparent));
//        setPadding(20, 20, 20, 20);
        this.addView(mTextView);
    }


    /**
     * @param msg
     */
    public void log(String msg) {
        if (mTextView != null && !TextUtils.isEmpty(msg)) {
            mTextView.setText(msg);
        }
    }

    /**
     * @param msg
     */
    public void appeldLog(String msg) {
        if (mTextView != null && !TextUtils.isEmpty(msg)) {
            mTextView.append(msg);
        }
    }

}
