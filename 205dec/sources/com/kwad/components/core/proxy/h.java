package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {
    private static volatile h QV;
    private final List<i> mListeners = new CopyOnWriteArrayList();

    private void c(final com.kwad.sdk.g.a<i> aVar) {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.core.proxy.h.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                for (i iVar : h.this.mListeners) {
                    if (iVar != null) {
                        try {
                            aVar.accept(iVar);
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }
                }
            }
        });
    }

    public static h qg() {
        if (QV == null) {
            synchronized (h.class) {
                if (QV == null) {
                    QV = new h();
                }
            }
        }
        return QV;
    }

    public final void e(final c cVar) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.d(cVar);
            }
        });
    }

    public final void f(final c cVar) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.c(cVar);
            }
        });
    }

    public final void g(final c cVar) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.4
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(i iVar) {
            }
        });
    }

    public final void a(final c cVar, final Bundle bundle) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.proxy.h.1
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(i iVar) {
            }
        });
    }

    public final void a(i iVar) {
        this.mListeners.add(iVar);
    }
}
