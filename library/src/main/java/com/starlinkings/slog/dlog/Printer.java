package com.starlinkings.slog.dlog;

/**
 * Created by fastcome1985
 */
public interface Printer {


    /**
     * set Dlog level
     *
     * @return
     */
    DLogOption setDLogLevel(DLogLevel level);

    /**
     * set tag for DLog
     *
     * @param tag
     * @return
     */
    DLogOption setTag(String tag);

    /**
     * set params for DLog
     *
     * @param option
     * @return
     */
    DLogOption setOption(DLogOption option);

    /**
     *
     * @return
     */
    DLogOption getOption();

    /**
     * normal log
     *
     * @param logType Log.Info  Log.debug  Log.warning Log.error
     * @param tag     tag
     * @param message message
     */
    void normalLog(int logType, String tag, String message);

    /**
     * set tag&methodCount once for debug
     *
     * @param methodCount
     * @return
     */
    Printer t(String tag, int methodCount);

    /**
     * Dlog.d
     *
     * @param message
     * @param args
     */
    void d(String message, Object... args);

    /**
     * Dlog.e
     *
     * @param message
     * @param args
     */
    void e(String message, Object... args);

    /**
     * Dlog.e
     *
     * @param message
     * @param args
     */
    void e(Throwable throwable, String message, Object... args);

    /**
     * Dlog.w
     *
     * @param message
     * @param args
     */
    void w(String message, Object... args);

    /**
     * Dlog.i
     *
     * @param message
     * @param args
     */
    void i(String message, Object... args);

    /**
     * Dlog.v
     *
     * @param message
     * @param args
     */
    void v(String message, Object... args);

    /**
     * Dlog.wtf
     *
     * @param message
     * @param args
     */
    void wtf(String message, Object... args);

    /**
     * Dlog.json
     *
     * @param json
     */
    void json(String json);

    /**
     * Dlog.xml
     *
     * @param xml
     */
    void xml(String xml);

}
