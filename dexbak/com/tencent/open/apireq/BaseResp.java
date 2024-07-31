package com.tencent.open.apireq;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* renamed from: a */
    private int f37282a = 0;

    /* renamed from: b */
    private String f37283b = "";

    /* renamed from: a */
    protected String m15200a(int i) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.f37282a;
    }

    public String getErrorMsg() {
        return this.f37283b;
    }

    public boolean isSuccess() {
        return this.f37282a == 0;
    }

    public void setCode(int i) {
        String str;
        this.f37282a = i;
        if (i == -2001) {
            str = "Not login.";
        } else if (i == -2000) {
            str = "The given params check failed.";
        } else if (i != 0) {
            switch (i) {
                case CODE_UNSUPPORTED_BRANCH /* -1002 */:
                    str = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case CODE_QQ_LOW_VERSION /* -1001 */:
                    str = "QQ version is too low.";
                    break;
                case -1000:
                    str = "QQ is not installed.";
                    break;
                default:
                    str = m15200a(i);
                    break;
            }
        } else {
            str = "";
        }
        setErrorMsg(str);
    }

    public void setErrorMsg(String str) {
        this.f37283b = str;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.f37282a + ", mErrorMsg='" + this.f37283b + "'}";
    }
}
