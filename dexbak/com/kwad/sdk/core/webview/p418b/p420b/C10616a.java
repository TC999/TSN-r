package com.kwad.sdk.core.webview.p418b.p420b;

import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.C9513m;
import com.kwad.framework.filedownloader.C9559r;
import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.sdk.core.webview.b.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10616a {

    /* renamed from: com.kwad.sdk.core.webview.b.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10618a {
        /* renamed from: c */
        void mo25281c(C10772b c10772b);

        /* renamed from: d */
        void mo25280d(C10772b c10772b);

        /* renamed from: e */
        void mo25279e(C10772b c10772b);
    }

    /* renamed from: a */
    public static void m25284a(final C10772b c10772b, @NonNull final InterfaceC10618a interfaceC10618a) {
        C10331c.m26254d("HybridDownloader", "reportHybrid: download+++url " + c10772b.packageUrl);
        interfaceC10618a.mo25281c(c10772b);
        c10772b.m24879az(System.currentTimeMillis());
        C10621b.m25266a(c10772b, 1);
        C9559r.m28423al(C10887l.m24567Ob());
        C9559r.m28419uU();
        C9559r.m28422bc(c10772b.packageUrl).mo28750e(c10772b).mo28756aZ(c10772b.aHZ).mo28753bb(true).mo28759a(new C9513m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.C9513m, com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: a */
            public final void mo25283a(InterfaceC9427a interfaceC9427a, Throwable th) {
                super.mo25283a(interfaceC9427a, th);
                C10621b.m25265a(c10772b, 0, 1, th.getMessage());
                InterfaceC10618a.this.mo25279e((C10772b) interfaceC9427a.getTag());
            }

            @Override // com.kwad.framework.filedownloader.C9513m, com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: c */
            public final void mo25282c(InterfaceC9427a interfaceC9427a) {
                super.mo25282c(interfaceC9427a);
                if (interfaceC9427a.mo28739tV() == -3) {
                    InterfaceC10618a.this.mo25280d(c10772b);
                    return;
                }
                InterfaceC10618a.this.mo25279e(c10772b);
                C10772b c10772b2 = c10772b;
                C10621b.m25265a(c10772b2, 0, 1, "task.getStatus()=" + ((int) interfaceC9427a.mo28739tV()));
            }
        }).start();
    }
}
