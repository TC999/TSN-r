package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv extends com.ss.android.socialbase.downloader.gd.ev<Long, com.ss.android.downloadlib.addownload.w.w> {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static xv f48524c = new xv();
    }

    public static xv c() {
        return c.f48524c;
    }

    private xv() {
        super(16, 16);
    }

    public void c(com.ss.android.downloadlib.addownload.w.w wVar) {
        if (wVar == null) {
            return;
        }
        put(Long.valueOf(wVar.c()), wVar);
    }

    public com.ss.android.downloadlib.addownload.w.w c(long j4, long j5) {
        return get(get(Long.valueOf(j4)) != null ? Long.valueOf(j4) : Long.valueOf(j5));
    }

    public com.ss.android.downloadlib.addownload.w.w c(long j4) {
        return get(Long.valueOf(j4));
    }
}
