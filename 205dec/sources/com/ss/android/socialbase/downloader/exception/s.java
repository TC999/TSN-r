package com.ss.android.socialbase.downloader.exception;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s extends BaseException {

    /* renamed from: a  reason: collision with root package name */
    private final long f49577a;
    private final long ok;

    public s(long j4, long j5) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j5), String.valueOf(j4)));
        this.ok = j4;
        this.f49577a = j5;
    }

    public long a() {
        return this.f49577a;
    }

    public long ok() {
        return this.ok;
    }
}
