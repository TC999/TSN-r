package com.kwad.components.p208ad.p236h;

import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.core.proxy.AbstractC8897i;
import com.kwad.components.core.proxy.C8891h;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.kwad.components.ad.h.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7668b implements InterfaceC8678b {

    /* renamed from: nF */
    private static final Object f25979nF = new Object();

    /* renamed from: nG */
    private static volatile C7668b f25980nG;

    /* renamed from: nH */
    private Set<Integer> f25981nH = new HashSet();

    /* renamed from: nI */
    private List<RunnableC7670c> f25982nI = new ArrayList();

    /* renamed from: nJ */
    private Map<InterfaceC8677a, Object> f25983nJ = new WeakHashMap();

    /* renamed from: nK */
    private Map<AbstractC8886c, Object> f25984nK = new WeakHashMap();

    /* renamed from: nL */
    private AbstractC8897i f25985nL = new AbstractC8897i() { // from class: com.kwad.components.ad.h.b.1
        @Override // com.kwad.components.core.proxy.AbstractC8897i, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: a */
        public final void mo26606d(AbstractC8886c abstractC8886c) {
            super.mo26606d(abstractC8886c);
            C7668b.this.f25984nK.put(abstractC8886c, C7668b.f25979nF);
        }

        @Override // com.kwad.components.core.proxy.AbstractC8897i, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: b */
        public final void mo26607c(AbstractC8886c abstractC8886c) {
            super.mo26607c(abstractC8886c);
            C7668b.this.f25984nK.remove(abstractC8886c);
            if (C7668b.this.f25984nK.isEmpty()) {
                C7668b.this.m32687eJ();
            }
        }
    };

    private C7668b() {
        C8891h.m29662qg().m29667a(this.f25985nL);
        this.f25981nH.add(2);
        this.f25981nH.add(3);
        this.f25981nH.add(13);
        this.f25981nH.add(6);
    }

    /* renamed from: A */
    private boolean m32695A(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.f25981nH.contains(Integer.valueOf(adTemplate.adStyle));
    }

    /* renamed from: e */
    private void m32689e(InterfaceC8677a interfaceC8677a) {
        this.f25983nJ.put(interfaceC8677a, f25979nF);
        if (m32683g(interfaceC8677a)) {
            RunnableC7670c runnableC7670c = new RunnableC7670c(interfaceC8677a);
            runnableC7670c.m32678eM();
            this.f25982nI.add(runnableC7670c);
        }
    }

    /* renamed from: eI */
    public static C7668b m32688eI() {
        if (f25980nG == null) {
            synchronized (C7668b.class) {
                if (f25980nG == null) {
                    f25980nG = new C7668b();
                }
            }
        }
        return f25980nG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eJ */
    public synchronized void m32687eJ() {
        boolean m32686eK = m32686eK();
        C10331c.m26254d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + m32686eK);
        if (m32686eK) {
            for (RunnableC7670c runnableC7670c : this.f25982nI) {
                runnableC7670c.m32676eO();
            }
        }
    }

    /* renamed from: f */
    private void m32684f(InterfaceC8677a interfaceC8677a) {
        this.f25983nJ.remove(interfaceC8677a);
        for (RunnableC7670c runnableC7670c : this.f25982nI) {
            runnableC7670c.m32679d(interfaceC8677a);
        }
        if (m32695A(interfaceC8677a.getAdTemplate())) {
            m32687eJ();
        }
    }

    /* renamed from: g */
    private static boolean m32683g(InterfaceC8677a interfaceC8677a) {
        if (interfaceC8677a.mo30033ag()) {
            return C10483a.m25833cU(C10487e.m25641dQ(interfaceC8677a.getAdTemplate()));
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8678b
    /* renamed from: c */
    public final void mo30031c(InterfaceC8677a interfaceC8677a) {
        m32689e(interfaceC8677a);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8678b
    /* renamed from: d */
    public final void mo30030d(InterfaceC8677a interfaceC8677a) {
        m32684f(interfaceC8677a);
        m32690b(interfaceC8677a);
    }

    /* renamed from: eK */
    public final synchronized boolean m32686eK() {
        for (InterfaceC8677a interfaceC8677a : this.f25983nJ.keySet()) {
            if (m32695A(interfaceC8677a.getAdTemplate())) {
                return false;
            }
        }
        return this.f25984nK.isEmpty();
    }

    /* renamed from: a */
    public final void m32692a(InterfaceC8677a interfaceC8677a) {
        if (interfaceC8677a != null) {
            interfaceC8677a.mo30034a(this);
        }
    }

    /* renamed from: b */
    public final void m32690b(InterfaceC8677a interfaceC8677a) {
        if (interfaceC8677a != null) {
            interfaceC8677a.mo30032b(this);
        }
    }

    /* renamed from: a */
    public final void m32693a(RunnableC7670c runnableC7670c) {
        if (runnableC7670c != null) {
            this.f25982nI.remove(runnableC7670c);
        }
    }
}
