package com.starlinkings.slog.dlog;

/**
 * Created by fastcome1985
 */
public class DLog {

    /**
     * printer
     */
    private static final Printer printer = new DLogPrinter();

    /**
     * no  instance
     */
    private DLog() {
    }

    /**
     * close Dlog
     *
     * @return
     */
    public static DLogOption closeDlog() {
        return printer.setDLogLevel(DLogLevel.NONE);
    }

    /**
     * open Dlog
     *
     * @return
     */
    public static DLogOption openDlog() {
        return printer.setDLogLevel(DLogLevel.ALL);
    }

    /**
     * set tag for DLog
     *
     * @param tag
     * @return
     */
    public static DLogOption setTag(String tag) {
        return printer.setTag(tag);
    }

    /**
     * set params for DLog
     *
     * @param option
     * @return
     */
    public static DLogOption setOption(DLogOption option) {
        return printer.setOption(option);
    }


    /**
     * normal log
     *
     * @param logType Log.Info  Log.debug  Log.warning Log.error
     * @param tag     tag
     * @param message message
     */
    public static void easylog(int logType, String tag, String message) {
        printer.normalLog(logType, tag, message);
    }


    /**
     * set tag once for debug
     *
     * @param tag
     * @return
     */
    public static Printer t(String tag) {
        return printer.t(tag, printer.getOption().getMethodCount());
    }

    /**
     * set methodCount once for debug
     *
     * @param methodCount
     * @return
     */
    public static Printer t(int methodCount) {
        return printer.t(null, methodCount);
    }

    /**
     * set tag&methodCount once for debug
     *
     * @param methodCount
     * @return
     */
    public static Printer t(String tag, int methodCount) {
        return printer.t(tag, methodCount);
    }

    /**
     * Dlog.d
     *
     * @param message
     * @param args
     */
    public static void d(String message, Object... args) {
        printer.d(message, args);
    }

    /**
     * Dlog.e
     *
     * @param message
     * @param args
     */
    public static void e(String message, Object... args) {
        printer.e(null, message, args);
    }

    /**
     * Dlog.e
     *
     * @param throwable
     * @param message
     * @param args
     */
    public static void e(Throwable throwable, String message, Object... args) {
        printer.e(throwable, message, args);
    }

    /**
     * Dlog.i
     *
     * @param message
     * @param args
     */
    public static void i(String message, Object... args) {
        printer.i(message, args);
    }

    /**
     * Dlog.v
     *
     * @param message
     * @param args
     */
    public static void v(String message, Object... args) {
        printer.v(message, args);
    }

    /**
     * Dlog.w
     *
     * @param message
     * @param args
     */
    public static void w(String message, Object... args) {
        printer.w(message, args);
    }

    /**
     * Dlog.wtf
     *
     * @param message
     * @param args
     */
    public static void wtf(String message, Object... args) {
        printer.wtf(message, args);
    }

    /**
     * Dlog.json
     *
     * @param json
     */
    public static void json(String json) {
        printer.json(json);
    }

    /**
     * Dlog.xml
     *
     * @param xml
     */
    public static void xml(String xml) {
        printer.xml(xml);
    }

}
