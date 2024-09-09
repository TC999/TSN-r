package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl extends com.ss.android.socialbase.downloader.q.p<Long, com.ss.android.downloadlib.addownload.a.a> {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ok {
        private static bl ok = new bl();
    }

    public static bl ok() {
        return ok.ok;
    }

    private bl() {
        super(16, 16);
    }

    public void ok(com.ss.android.downloadlib.addownload.a.a aVar) {
        if (aVar == null) {
            return;
        }
        put(Long.valueOf(aVar.ok()), aVar);
    }

    public com.ss.android.downloadlib.addownload.a.a ok(long j4, long j5) {
        return get(get(Long.valueOf(j4)) != null ? Long.valueOf(j4) : Long.valueOf(j5));
    }

    public com.ss.android.downloadlib.addownload.a.a ok(long j4) {
        return get(Long.valueOf(j4));
    }
}
