package com.kwad.sdk.core.webview.b.b;

import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.m;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.webview.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0703a {
        void c(com.kwad.sdk.h.a.b bVar);

        void d(com.kwad.sdk.h.a.b bVar);

        void e(com.kwad.sdk.h.a.b bVar);
    }

    public static void a(final com.kwad.sdk.h.a.b bVar, @NonNull final InterfaceC0703a interfaceC0703a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0703a.c(bVar);
        bVar.az(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.al(l.Ob());
        r.uU();
        r.bc(bVar.packageUrl).e(bVar).aZ(bVar.aHZ).bb(true).a(new m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0703a.this.e((com.kwad.sdk.h.a.b) aVar.getTag());
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.tV() == -3) {
                    InterfaceC0703a.this.d(bVar);
                    return;
                }
                InterfaceC0703a.this.e(bVar);
                com.kwad.sdk.h.a.b bVar2 = bVar;
                com.kwad.sdk.core.webview.b.c.b.a(bVar2, 0, 1, "task.getStatus()=" + ((int) aVar.tV()));
            }
        }).start();
    }
}
