package com.ss.android.socialbase.downloader.exception;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h extends BaseException {
    public h(int i4, String str) {
        super(i4, str);
    }

    public h ok(String str) {
        setExtraInfo(str);
        return this;
    }

    public String ok() {
        return getExtraInfo();
    }
}
