package com.kwad.components.p208ad.p233g.p234a.p235a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.g.a.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7662b implements InterfaceC10625a {

    /* renamed from: nt */
    public static int f25965nt = 1;

    /* renamed from: nu */
    public static int f25966nu = 2;

    /* renamed from: ns */
    private InterfaceC10627c f25967ns;

    /* renamed from: nv */
    private int f25968nv;

    /* renamed from: nw */
    private int f25969nw;

    /* renamed from: ny */
    private InterfaceC7665b f25971ny;

    /* renamed from: nx */
    private RunnableC7666c f25970nx = new RunnableC7666c(this, (byte) 0);
    @Nullable

    /* renamed from: nz */
    private Runnable f25972nz = null;

    @KsJson
    /* renamed from: com.kwad.components.ad.g.a.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7664a extends C10482a {

        /* renamed from: nB */
        public int f25974nB;

        /* renamed from: nC */
        public int f25975nC;
    }

    /* renamed from: com.kwad.components.ad.g.a.a.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7665b {
        /* renamed from: E */
        void mo32469E(int i);
    }

    private C7662b(int i, int i2) {
        this.f25968nv = i;
        this.f25969nw = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m32708I(int i) {
        C10331c.m26254d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.f25967ns);
        if (i >= 0 && this.f25967ns != null) {
            InterfaceC7665b interfaceC7665b = this.f25971ny;
            if (interfaceC7665b != null && i == 0) {
                interfaceC7665b.mo32469E(this.f25968nv);
            }
            C7664a c7664a = new C7664a();
            c7664a.f25975nC = i;
            c7664a.f25974nB = this.f25968nv;
            InterfaceC10627c interfaceC10627c = this.f25967ns;
            if (interfaceC10627c != null) {
                interfaceC10627c.mo25251a(c7664a);
            }
        }
    }

    /* renamed from: f */
    private static int m32702f(AdInfo adInfo) {
        int m32576b = C7721b.m32576b(adInfo);
        if (m32576b <= 0) {
            m32576b = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        return i > 0 ? Math.min(m32576b, i) : m32576b;
    }

    @Nullable
    /* renamed from: z */
    public static C7662b m32701z(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (!C10483a.m25877bc(m25641dQ)) {
            if (C10483a.m25900bH(m25641dQ)) {
                return new C7662b(f25966nu, m32702f(m25641dQ));
            }
            int i = m25641dQ.adInsertScreenInfo.autoCloseTime;
            if (i > 0) {
                return new C7662b(f25965nt, i);
            }
            return null;
        }
        return null;
    }

    /* renamed from: eF */
    public final void m32705eF() {
        C10331c.m26254d("RegisterTimer", "startTimer: mCallBackFunction: " + this.f25967ns);
        if (this.f25967ns == null) {
            this.f25972nz = new Runnable() { // from class: com.kwad.components.ad.g.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    C7662b.this.m32705eF();
                }
            };
            return;
        }
        this.f25970nx.m32700J(this.f25969nw);
        C11064bn.runOnUiThread(this.f25970nx);
    }

    /* renamed from: eG */
    public final void m32704eG() {
        this.f25970nx.m32699y(true);
    }

    /* renamed from: eH */
    public final void m32703eH() {
        this.f25970nx.m32699y(false);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f25967ns = null;
    }

    /* renamed from: a */
    public final void m32707a(InterfaceC7665b interfaceC7665b) {
        this.f25971ny = interfaceC7665b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.g.a.a.b$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class RunnableC7666c implements Runnable {

        /* renamed from: nD */
        private boolean f25977nD;

        /* renamed from: nE */
        private int f25978nE;

        private RunnableC7666c() {
            this.f25977nD = false;
            this.f25978nE = -1;
        }

        /* renamed from: J */
        public final void m32700J(int i) {
            this.f25978nE = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C10331c.m26254d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.f25977nD + ", currentTime: " + this.f25978nE);
            if (this.f25977nD) {
                C11064bn.m23862a(this, null, 1000L);
                return;
            }
            int i = this.f25978nE;
            if (i < 0) {
                return;
            }
            C7662b.this.m32708I(i);
            this.f25978nE--;
            C11064bn.m23862a(this, null, 1000L);
        }

        /* renamed from: y */
        public final void m32699y(boolean z) {
            this.f25977nD = z;
        }

        /* synthetic */ RunnableC7666c(C7662b c7662b, byte b) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f25967ns = interfaceC10627c;
        Runnable runnable = this.f25972nz;
        if (runnable != null) {
            runnable.run();
            this.f25972nz = null;
        }
    }
}
