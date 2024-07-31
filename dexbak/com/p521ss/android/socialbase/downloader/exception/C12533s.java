package com.p521ss.android.socialbase.downloader.exception;

/* renamed from: com.ss.android.socialbase.downloader.exception.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12533s extends BaseException {

    /* renamed from: a */
    private final long f35188a;

    /* renamed from: ok */
    private final long f35189ok;

    public C12533s(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f35189ok = j;
        this.f35188a = j2;
    }

    /* renamed from: a */
    public long m17612a() {
        return this.f35188a;
    }

    /* renamed from: ok */
    public long m17611ok() {
        return this.f35189ok;
    }
}
