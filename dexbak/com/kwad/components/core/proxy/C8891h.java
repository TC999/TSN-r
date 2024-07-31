package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.proxy.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8891h {

    /* renamed from: QV */
    private static volatile C8891h f28749QV;
    private final List<AbstractC8897i> mListeners = new CopyOnWriteArrayList();

    /* renamed from: c */
    private void m29666c(final InterfaceC10761a<AbstractC8897i> interfaceC10761a) {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.proxy.h.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                for (AbstractC8897i abstractC8897i : C8891h.this.mListeners) {
                    if (abstractC8897i != null) {
                        try {
                            interfaceC10761a.accept(abstractC8897i);
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: qg */
    public static C8891h m29662qg() {
        if (f28749QV == null) {
            synchronized (C8891h.class) {
                if (f28749QV == null) {
                    f28749QV = new C8891h();
                }
            }
        }
        return f28749QV;
    }

    /* renamed from: e */
    public final void m29665e(final AbstractC8886c abstractC8886c) {
        m29666c(new InterfaceC10761a<AbstractC8897i>() { // from class: com.kwad.components.core.proxy.h.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(AbstractC8897i abstractC8897i) {
                abstractC8897i.mo26606d(abstractC8886c);
            }
        });
    }

    /* renamed from: f */
    public final void m29664f(final AbstractC8886c abstractC8886c) {
        m29666c(new InterfaceC10761a<AbstractC8897i>() { // from class: com.kwad.components.core.proxy.h.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: b */
            public void accept(AbstractC8897i abstractC8897i) {
                abstractC8897i.mo26607c(abstractC8886c);
            }
        });
    }

    /* renamed from: g */
    public final void m29663g(final AbstractC8886c abstractC8886c) {
        m29666c(new InterfaceC10761a<AbstractC8897i>() { // from class: com.kwad.components.core.proxy.h.4
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* bridge */ /* synthetic */ void accept(AbstractC8897i abstractC8897i) {
            }
        });
    }

    /* renamed from: a */
    public final void m29669a(final AbstractC8886c abstractC8886c, final Bundle bundle) {
        m29666c(new InterfaceC10761a<AbstractC8897i>() { // from class: com.kwad.components.core.proxy.h.1
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* bridge */ /* synthetic */ void accept(AbstractC8897i abstractC8897i) {
            }
        });
    }

    /* renamed from: a */
    public final void m29667a(AbstractC8897i abstractC8897i) {
        this.mListeners.add(abstractC8897i);
    }
}
