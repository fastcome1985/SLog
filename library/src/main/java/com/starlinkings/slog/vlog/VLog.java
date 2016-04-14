package com.starlinkings.slog.vlog;

import android.content.Context;

/**
 * show log in floatview
 * init  in the firstactivity
 * clear in the  lastactivity
 * <p>
 * Created by  fastcome1985
 */
public class VLog {

    /**
     * @param activityContext
     */
    public static void init(Context activityContext) {
        VLogFloatPrinter.getInstance().init(activityContext);
    }


    /**
     * set log
     *
     * @param msg
     */
    public static void log(final String msg) {
        VLogFloatPrinter.getInstance().log(msg);
    }

    /**
     * add log
     *
     * @param msg
     */
    public static void appendLog(final String msg) {
        VLogFloatPrinter.getInstance().appendLog(msg);
    }

    /**
     *
     */
    public static void clear() {
        VLogFloatPrinter.getInstance().clear();
    }


}
