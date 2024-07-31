package com.p521ss.android.socialbase.appdownloader.p543kf.p544ok;

import java.io.IOException;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12319a {
    /* renamed from: ok */
    public static final void m18213ok(C12328s c12328s, int i) throws IOException {
        int m18180a = c12328s.m18180a();
        if (m18180a == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(m18180a) + ".");
    }
}
