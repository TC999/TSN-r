package com.umeng.socialize.tracker.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Errors.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum a {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(5004),
    UnKnownHostException(5005),
    HttpError(5006),
    EmptyResponse(5007),
    ErrorResponse(5008),
    ErrorMakeRequestBody(5009);
    

    /* renamed from: k  reason: collision with root package name */
    private final int f54196k;

    a(int i4) {
        this.f54196k = i4;
    }

    private String b() {
        return "\u9519\u8bef\u7801\uff1a" + this.f54196k + " \u9519\u8bef\u4fe1\u606f\uff1a";
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--\u672a\u77e5\u9519\u8bef--";
        } else if (this == Timeout) {
            return b() + "--\u8fde\u63a5\u8d85\u65f6--";
        } else if (this == NetworkUnavailable) {
            return b() + "--\u7f51\u7edc\u4e0d\u53ef\u7528--";
        } else if (this == SSLException) {
            return b() + "--SSL\u8bc1\u4e66\u8ba4\u8bc1\u5931\u8d25--";
        } else if (this == IOException) {
            return b() + "--IO\u5f02\u5e38--";
        } else if (this == HttpError) {
            return b() + "--\u670d\u52a1\u7aef\u8fd4\u56deHTTP\u9519\u8bef--";
        } else if (this == EmptyResponse) {
            return b() + "--\u670d\u52a1\u7aef\u8fd4\u56de\u6570\u636e\u4e3a\u7a7a--";
        } else if (this == ErrorResponse) {
            return b() + "--\u670d\u52a1\u7aef\u8fd4\u56de\u9519\u8bef\u6570\u636e--";
        } else if (this == ErrorMakeRequestBody) {
            return b() + "--\u8bf7\u6c42\u62a5\u6587\u6784\u5efa\u9519\u8bef--";
        } else {
            return "unknown";
        }
    }
}
