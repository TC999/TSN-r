package com.p521ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12513r;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;

/* renamed from: com.ss.android.socialbase.downloader.impls.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12555q implements InterfaceC12513r {
    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12513r
    /* renamed from: ok */
    public int mo17530ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String m16578n = C12713kf.m16578n(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(m16578n)) {
            return 0;
        }
        return m16578n.hashCode();
    }
}
