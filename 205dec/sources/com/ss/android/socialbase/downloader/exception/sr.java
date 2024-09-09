package com.ss.android.socialbase.downloader.exception;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr extends BaseException {

    /* renamed from: c  reason: collision with root package name */
    private final long f49578c;

    /* renamed from: w  reason: collision with root package name */
    private final long f49579w;

    public sr(long j4, long j5) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j5), String.valueOf(j4)));
        this.f49578c = j4;
        this.f49579w = j5;
    }

    public long c() {
        return this.f49578c;
    }

    public long w() {
        return this.f49579w;
    }
}
