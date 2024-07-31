package com.p521ss.android.socialbase.downloader.exception;

/* renamed from: com.ss.android.socialbase.downloader.exception.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12527h extends BaseException {
    public C12527h(int i, String str) {
        super(i, str);
    }

    /* renamed from: ok */
    public C12527h m17615ok(String str) {
        setExtraInfo(str);
        return this;
    }

    /* renamed from: ok */
    public String m17616ok() {
        return getExtraInfo();
    }
}
