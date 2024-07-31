package com.p521ss.android.downloadlib.addownload.compliance;

import com.p521ss.android.downloadlib.addownload.p528a.C12029a;
import com.p521ss.android.socialbase.downloader.p556q.C12718p;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12063bl extends C12718p<Long, C12029a> {

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12065ok {

        /* renamed from: ok */
        private static C12063bl f34147ok = new C12063bl();
    }

    /* renamed from: ok */
    public static C12063bl m19218ok() {
        return C12065ok.f34147ok;
    }

    private C12063bl() {
        super(16, 16);
    }

    /* renamed from: ok */
    public void m19215ok(C12029a c12029a) {
        if (c12029a == null) {
            return;
        }
        put(Long.valueOf(c12029a.m19341ok()), c12029a);
    }

    /* renamed from: ok */
    public C12029a m19216ok(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    /* renamed from: ok */
    public C12029a m19217ok(long j) {
        return get(Long.valueOf(j));
    }
}
