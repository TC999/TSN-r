package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.webview.p417a.C10603c;

/* renamed from: com.kwad.sdk.core.webview.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10632d {
    private long aDV;
    private boolean aDW;

    /* renamed from: d */
    public static void m25247d(C10603c.C10604a c10604a) {
        if (c10604a != null) {
            C9908c.m27336b(c10604a.getAdTemplate(), c10604a.m25328nL());
        }
    }

    /* renamed from: a */
    public final void m25250a(C10603c.C10604a c10604a) {
        if (c10604a != null) {
            C9908c.m27344a(c10604a.getAdTemplate(), c10604a.m25328nL());
        }
        if (c10604a != null) {
            this.aDV = System.currentTimeMillis();
        }
    }

    /* renamed from: b */
    public final void m25249b(C10603c.C10604a c10604a) {
        if (c10604a != null) {
            C9908c.m27294k(c10604a.getAdTemplate(), System.currentTimeMillis() - this.aDV);
        }
    }

    /* renamed from: c */
    public final void m25248c(C10603c.C10604a c10604a) {
        if (c10604a == null || this.aDW) {
            return;
        }
        this.aDW = true;
        long j = 0;
        if (this.aDV > 0) {
            j = System.currentTimeMillis() - this.aDV;
            this.aDV = -1L;
        }
        C9908c.m27343a(c10604a.getAdTemplate(), c10604a.m25328nL(), j);
    }
}
