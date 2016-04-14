package com.starlinkings.slog.dlog;

/**
 * the options of Dlog
 * Created by fastcome1985
 */
public class DLogOption {


    /**
     * method count in log . you can change tag once with methodCount DLog.t
     */
    private int methodCount = 2;

    /**
     * whether is meanthread or not
     */
    private boolean showThreadInfo = true;

    /**
     * the offset of beginmethod
     */
    private int methodOffset = 0;

    /**
     * defult tag.   you can change tag once with method DLog.t
     */
    private String defaultTag = "dlog";

    /**
     * Determines how logs will printed
     */
    private DLogLevel logLevel = DLogLevel.ALL;

    /**
     * do not show methodinfo
     *
     * @return
     */
    public DLogOption hideThreadInfo() {
        showThreadInfo = false;
        return this;
    }

    /**
     * @param methodCount
     * @return
     */
    public DLogOption setMethodCount(int methodCount) {
        if (methodCount < 0) {
            methodCount = 0;
        }
        this.methodCount = methodCount;
        return this;
    }

    /**
     * @param logLevel
     * @return
     */
    public DLogOption setLogLevel(DLogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    /**
     * @param offset
     * @return
     */
    public DLogOption setMethodOffset(int offset) {
        this.methodOffset = offset;
        return this;
    }

    /**
     * @return
     */
    public int getMethodCount() {
        return methodCount;
    }

    /**
     * @return
     */
    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    /**
     * @return
     */
    public DLogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * @return
     */
    public int getMethodOffset() {
        return methodOffset;
    }

    /**
     * @return
     */
    public String getDefaultTag() {
        return defaultTag;
    }

    /**
     * @param defaultTag
     * @return
     */
    public DLogOption setDefaultTag(String defaultTag) {
        this.defaultTag = defaultTag;
        return this;
    }
}
