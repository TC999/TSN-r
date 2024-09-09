package com.tencent.open.apireq;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* renamed from: a  reason: collision with root package name */
    private int f51682a = 0;

    /* renamed from: b  reason: collision with root package name */
    private String f51683b = "";

    protected String a(int i4) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.f51682a;
    }

    public String getErrorMsg() {
        return this.f51683b;
    }

    public boolean isSuccess() {
        return this.f51682a == 0;
    }

    public void setCode(int i4) {
        String str;
        this.f51682a = i4;
        if (i4 == -2001) {
            str = "Not login.";
        } else if (i4 == -2000) {
            str = "The given params check failed.";
        } else if (i4 != 0) {
            switch (i4) {
                case -1002:
                    str = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case -1001:
                    str = "QQ version is too low.";
                    break;
                case -1000:
                    str = "QQ is not installed.";
                    break;
                default:
                    str = a(i4);
                    break;
            }
        } else {
            str = "";
        }
        setErrorMsg(str);
    }

    public void setErrorMsg(String str) {
        this.f51683b = str;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.f51682a + ", mErrorMsg='" + this.f51683b + "'}";
    }
}
