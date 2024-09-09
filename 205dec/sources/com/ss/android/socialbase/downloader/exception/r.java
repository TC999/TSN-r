package com.ss.android.socialbase.downloader.exception;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r extends BaseException {
    public r(int i4, String str) {
        super(i4, str);
    }

    public r c(String str) {
        setExtraInfo(str);
        return this;
    }

    public String c() {
        return getExtraInfo();
    }
}
