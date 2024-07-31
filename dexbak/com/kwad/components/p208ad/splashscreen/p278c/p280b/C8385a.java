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
import com.kwad.components.p208ad.splashscreen.p278c.C8435j;
import com.kwad.components.p208ad.splashscreen.p278c.p281c.C8407a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.splashscreen.c.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8385a extends C8421e {

    /* renamed from: EV */
    private InterfaceC8700b f27676EV;

    /* renamed from: EW */
    private long f27677EW;

    /* renamed from: EX */
    private volatile boolean f27678EX = false;

    /* renamed from: jR */
    private AbstractC9293e f27681jR = new AbstractC9293e() { // from class: com.kwad.components.ad.splashscreen.c.b.a.1
        @Override // com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e
        /* renamed from: a */
        public final void mo29094a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(C10484b.m25687dr(C8385a.this.f27734Dg.mAdTemplate))) {
                return;
            }
            C8497b.m30550kV();
            C8497b.m30573a(C8385a.this.f27734Dg.mAdTemplate, C8385a.this.f27734Dg.f27880Cr, C8385a.this.f27734Dg.f27869CB, C8385a.this.f27734Dg.f27871CD, C8385a.this.f27734Dg.f27870CC, C8385a.this.f27734Dg.f27872CE, j, j2, j3, SystemClock.elapsedRealtime() - C8385a.this.f27677EW);
            C8385a.this.f27734Dg.f27873CF = j;
            C8385a.this.f27734Dg.f27874CG = j2;
            C8385a.this.f27734Dg.f27875CH = j3;
            C11064bn.m23858c(C8385a.this.f27679EY);
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
        /* renamed from: q */
        public final void mo29101q(String str) {
            C8385a.this.f27734Dg.f27888Cz = true;
            if ("tk_splash".equals(str)) {
                C8385a.this.m30848aq();
            }
        }
    };

    /* renamed from: EY */
    private final Runnable f27679EY = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (C8385a.this.f27678EX) {
                C8385a.this.f27734Dg.f27888Cz = true;
                C8385a.this.m30848aq();
                C8497b.m30550kV();
                C8497b.m30561c(C8385a.this.f27734Dg.mAdTemplate, C8385a.this.f27734Dg.f27880Cr);
                return;
            }
            C8385a.this.m30835lG();
        }
    };

    /* renamed from: EZ */
    private InterfaceC8698a f27680EZ = new InterfaceC8698a() { // from class: com.kwad.components.ad.splashscreen.c.b.a.3
        @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8698a
        /* renamed from: a */
        public final void mo29087a(int i, int i2, long j, long j2) {
            C8385a.this.f27734Dg.f27869CB = i;
            C8385a.this.f27734Dg.f27870CC = i2;
            C8385a.this.f27734Dg.f27871CD = j;
            C8385a.this.f27734Dg.f27872CE = j2;
            C8497b.m30550kV();
            C8497b.m30554e(C8385a.this.f27734Dg.mAdTemplate, SystemClock.elapsedRealtime() - C8385a.this.f27677EW);
            C8385a.this.m30835lG();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aq */
    public void m30848aq() {
        C8489h c8489h = this.f27734Dg;
        if (c8489h.f27887Cy) {
            return;
        }
        c8489h.f27887Cy = true;
        c8489h.f27886Cx = true;
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.b.a.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8385a.this.m24611a(new C8435j(), true);
            }
        });
    }

    /* renamed from: lF */
    private void m30836lF() {
        InterfaceC8700b interfaceC8700b = (InterfaceC8700b) C9861c.m27501f(InterfaceC8700b.class);
        this.f27676EV = interfaceC8700b;
        if (interfaceC8700b != null) {
            interfaceC8700b.mo28845a(this.f27680EZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lG */
    public void m30835lG() {
        if (this.f27678EX) {
            return;
        }
        this.f27678EX = true;
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.b.a.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8385a.this.m24611a(new C8407a(), true);
            }
        });
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27677EW = SystemClock.elapsedRealtime();
        C8497b.m30550kV();
        C8489h c8489h = this.f27734Dg;
        C8497b.m30574a(c8489h.mAdTemplate, c8489h.f27880Cr);
        C8489h c8489h2 = this.f27734Dg;
        c8489h2.f27868CA = this.f27677EW;
        C11064bn.runOnUiThreadDelay(this.f27679EY, C10484b.m25713de(c8489h2.mAdTemplate));
        C9283b.m29107tc().m29113a(this.f27681jR);
        m30836lF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        InterfaceC8700b interfaceC8700b = this.f27676EV;
        if (interfaceC8700b != null) {
            interfaceC8700b.mo28844b(this.f27680EZ);
        }
        C11064bn.m23858c(this.f27679EY);
        C9283b.m29107tc().m29112b(this.f27681jR);
    }
}
