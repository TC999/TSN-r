package com.kwad.components.p208ad.splashscreen.p278c.p280b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8698a;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8700b;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;
import com.kwad.components.p208ad.splashscreen.p278c.C8455p;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.splashscreen.c.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8391b extends C8421e {

    /* renamed from: EV */
    private InterfaceC8700b f27687EV;

    /* renamed from: EW */
    private long f27688EW;

    /* renamed from: EX */
    private volatile boolean f27689EX = false;

    /* renamed from: jR */
    private AbstractC9293e f27692jR = new AbstractC9293e() { // from class: com.kwad.components.ad.splashscreen.c.b.b.1
        @Override // com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e
        /* renamed from: a */
        public final void mo29094a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(C10484b.m25687dr(C8391b.this.f27734Dg.mAdTemplate))) {
                return;
            }
            C8497b.m30550kV();
            C8497b.m30573a(C8391b.this.f27734Dg.mAdTemplate, C8391b.this.f27734Dg.f27880Cr, C8391b.this.f27734Dg.f27869CB, C8391b.this.f27734Dg.f27871CD, C8391b.this.f27734Dg.f27870CC, C8391b.this.f27734Dg.f27872CE, j, j2, j3, SystemClock.elapsedRealtime() - C8391b.this.f27688EW);
            C8391b.this.f27734Dg.f27873CF = j;
            C8391b.this.f27734Dg.f27874CG = j2;
            C8391b.this.f27734Dg.f27875CH = j3;
            C11064bn.m23858c(C8391b.this.f27690EY);
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
        /* renamed from: q */
        public final void mo29101q(String str) {
            C8391b.this.f27734Dg.f27888Cz = true;
            if ("tk_splash".equals(str)) {
                C8391b.this.m30808lH();
            }
        }
    };

    /* renamed from: EY */
    private final Runnable f27690EY = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (C8391b.this.f27689EX) {
                C8391b.this.f27734Dg.f27888Cz = true;
                C8391b.this.m30808lH();
                C8497b.m30550kV();
                C8497b.m30561c(C8391b.this.f27734Dg.mAdTemplate, C8391b.this.f27734Dg.f27880Cr);
                return;
            }
            C8391b.this.m30809lG();
        }
    };

    /* renamed from: EZ */
    private InterfaceC8698a f27691EZ = new InterfaceC8698a() { // from class: com.kwad.components.ad.splashscreen.c.b.b.3
        @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8698a
        /* renamed from: a */
        public final void mo29087a(int i, int i2, long j, long j2) {
            C8391b.this.f27734Dg.f27869CB = i;
            C8391b.this.f27734Dg.f27870CC = i2;
            C8391b.this.f27734Dg.f27871CD = j;
            C8391b.this.f27734Dg.f27872CE = j2;
            C8497b.m30550kV();
            C8497b.m30554e(C8391b.this.f27734Dg.mAdTemplate, SystemClock.elapsedRealtime() - C8391b.this.f27688EW);
            C8391b.this.m30809lG();
        }
    };

    /* renamed from: lF */
    private void m30810lF() {
        InterfaceC8700b interfaceC8700b = (InterfaceC8700b) C9861c.m27501f(InterfaceC8700b.class);
        this.f27687EV = interfaceC8700b;
        if (interfaceC8700b != null) {
            interfaceC8700b.mo28845a(this.f27691EZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lG */
    public void m30809lG() {
        if (this.f27689EX) {
            return;
        }
        this.f27689EX = true;
        if (m30807lI()) {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    C8391b.this.m24611a(new C8397c(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lH */
    public void m30808lH() {
        if (C10484b.m25739dB(C10487e.m25641dQ(this.f27734Dg.mAdTemplate))) {
            C8489h c8489h = this.f27734Dg;
            if (c8489h.f27886Cx) {
                return;
            }
            c8489h.f27886Cx = true;
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    C8391b.this.m24611a(new C8455p(), true);
                }
            });
        }
    }

    /* renamed from: lI */
    private boolean m30807lI() {
        if (C10251d.m26572BV()) {
            return C10484b.m25708dh(C10487e.m25641dQ(this.f27734Dg.mAdTemplate));
        }
        return false;
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27688EW = SystemClock.elapsedRealtime();
        if (m30807lI()) {
            C8497b.m30550kV();
            C8489h c8489h = this.f27734Dg;
            C8497b.m30574a(c8489h.mAdTemplate, c8489h.f27880Cr);
            C8489h c8489h2 = this.f27734Dg;
            c8489h2.f27868CA = this.f27688EW;
            C11064bn.runOnUiThreadDelay(this.f27690EY, C10484b.m25700dl(C10487e.m25641dQ(c8489h2.mAdTemplate)));
            C9283b.m29107tc().m29113a(this.f27692jR);
        }
        if (C10251d.m26572BV()) {
            m30810lF();
        } else {
            m30808lH();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        InterfaceC8700b interfaceC8700b = this.f27687EV;
        if (interfaceC8700b != null) {
            interfaceC8700b.mo28844b(this.f27691EZ);
        }
        if (m30807lI()) {
            C11064bn.m23858c(this.f27690EY);
            C9283b.m29107tc().m29112b(this.f27692jR);
        }
    }
}
