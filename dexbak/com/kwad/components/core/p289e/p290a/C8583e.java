package com.kwad.components.core.p289e.p290a;

import android.app.Activity;
import com.kwad.components.p208ad.p210b.p211a.AbstractC7343c;
import com.kwad.components.p208ad.p210b.p211a.InterfaceC7341a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.core.e.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8583e {

    /* renamed from: JK */
    private final List<InterfaceC8580b> f28140JK;

    /* renamed from: JL */
    private final Stack<AdTemplate> f28141JL;

    /* renamed from: JM */
    private final AtomicBoolean f28142JM;

    /* renamed from: JN */
    private final Set<String> f28143JN;
    private final String TAG;

    /* renamed from: od */
    private final AtomicBoolean f28144od;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.e.a.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8588a {

        /* renamed from: JR */
        private static final C8583e f28151JR = new C8583e((byte) 0);
    }

    /* synthetic */ C8583e(byte b) {
        this();
    }

    /* renamed from: an */
    private void m30316an(final AdTemplate adTemplate) {
        if (!this.f28142JM.get() && !this.f28144od.get()) {
            C10331c.m26254d("InstalledActivateManager", "showInstalledActivate");
            this.f28142JM.set(true);
            C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.a.e.1
                /* JADX INFO: Access modifiers changed from: private */
                /* renamed from: nh */
                public void m30305nh() {
                    C10232b.m26625DD();
                    if (!C10232b.isEnable()) {
                        C8583e.this.f28142JM.set(false);
                        return;
                    }
                    C10232b.m26625DD();
                    if (C10232b.getCurrentActivity() != null) {
                        C10232b.m26625DD();
                        if (C10232b.isAppOnForeground()) {
                            m30304ni();
                            return;
                        }
                    }
                    C10232b.m26625DD();
                    C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.components.core.e.a.e.1.2
                        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
                        /* renamed from: onActivityResumed */
                        public final void mo26606d(Activity activity) {
                            super.mo26606d(activity);
                            C10232b.m26625DD();
                            C10232b.m26621b((InterfaceC10246c) this);
                            C10331c.m26254d("InstalledActivateManager", "startShow onBackToForeground");
                            m30304ni();
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* renamed from: ni */
                public void m30304ni() {
                    C10331c.m26254d("InstalledActivateManager", "startShow");
                    C8583e.this.m30315ao(adTemplate);
                    C8583e.this.f28142JM.set(false);
                    C8583e.this.f28143JN.remove(C10483a.m25911ay(C10487e.m25641dQ(adTemplate)));
                }

                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    final InterfaceC7341a interfaceC7341a = (InterfaceC7341a) C9861c.m27501f(InterfaceC7341a.class);
                    if (interfaceC7341a != null && interfaceC7341a.mo32698S()) {
                        interfaceC7341a.mo32697a(new AbstractC7343c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.p208ad.p210b.p211a.AbstractC7343c, com.kwad.components.p208ad.p210b.p211a.InterfaceC7342b
                            /* renamed from: U */
                            public final void mo30303U() {
                                interfaceC7341a.mo32696b(this);
                                m30305nh();
                                C10331c.m26254d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    } else {
                        m30305nh();
                    }
                }
            }, C10484b.m25701dk(adTemplate));
            return;
        }
        C10331c.m26254d("InstalledActivateManager", "mLoadDisable: " + this.f28144od.get() + ", mLoadDisable: " + this.f28142JM.get());
        this.f28141JL.add(adTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ao */
    public void m30315ao(AdTemplate adTemplate) {
        if (m30318a(adTemplate, new InterfaceC8580b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.p289e.p290a.InterfaceC8580b
            /* renamed from: eP */
            public final void mo30302eP() {
                C10331c.m26254d("InstalledActivateManager", "onViewClose");
                C8583e.this.m30311dJ();
                C8583e.this.m30308ng();
            }

            @Override // com.kwad.components.core.p289e.p290a.InterfaceC8580b
            /* renamed from: nd */
            public final void mo30301nd() {
                C10331c.m26254d("InstalledActivateManager", "onViewShow");
                C8583e.this.m30310dZ();
            }
        })) {
            return;
        }
        m30308ng();
    }

    /* renamed from: nf */
    public static C8583e m30309nf() {
        return C8588a.f28151JR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ng */
    public synchronized void m30308ng() {
        if (this.f28141JL.isEmpty()) {
            return;
        }
        m30316an(this.f28141JL.pop());
    }

    /* renamed from: am */
    public final synchronized void m30317am(AdTemplate adTemplate) {
        String m25911ay = C10483a.m25911ay(C10487e.m25641dQ(adTemplate));
        if (C10484b.m25703dj(adTemplate) && !this.f28143JN.contains(m25911ay)) {
            this.f28143JN.add(m25911ay);
            m30316an(adTemplate);
        }
    }

    /* renamed from: dJ */
    public final void m30311dJ() {
        this.f28144od.set(false);
        for (InterfaceC8580b interfaceC8580b : this.f28140JK) {
            interfaceC8580b.mo30302eP();
        }
    }

    /* renamed from: dZ */
    public final void m30310dZ() {
        this.f28144od.set(true);
        for (InterfaceC8580b interfaceC8580b : this.f28140JK) {
            interfaceC8580b.mo30301nd();
        }
    }

    public final boolean isShowing() {
        return this.f28144od.get();
    }

    private C8583e() {
        this.TAG = "InstalledActivateManager";
        this.f28140JK = new CopyOnWriteArrayList();
        this.f28141JL = new Stack<>();
        this.f28144od = new AtomicBoolean();
        this.f28142JM = new AtomicBoolean();
        this.f28143JN = new HashSet();
    }

    /* renamed from: b */
    public final void m30314b(InterfaceC8580b interfaceC8580b) {
        this.f28140JK.remove(interfaceC8580b);
    }

    /* renamed from: a */
    public final void m30321a(InterfaceC8580b interfaceC8580b) {
        this.f28140JK.add(interfaceC8580b);
    }

    /* renamed from: a */
    private static boolean m30318a(AdTemplate adTemplate, InterfaceC8580b interfaceC8580b) {
        C10331c.m26254d("InstalledActivateManager", "showToActivityWindow");
        return new C8594h().m30291b(adTemplate, interfaceC8580b);
    }
}
