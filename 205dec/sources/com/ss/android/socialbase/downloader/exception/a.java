package com.ss.android.socialbase.downloader.exception;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends BaseException {
    private final int ok;

    public a(int i4, int i5, String str) {
        super(i4, str);
        this.ok = i5;
    }

    public int ok() {
        return this.ok;
    }
}
