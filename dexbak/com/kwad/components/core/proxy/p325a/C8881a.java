package com.kwad.components.core.proxy.p325a;

import android.os.SystemClock;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.proxy.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8881a {

    /* renamed from: Ra */
    private String f28735Ra;

    /* renamed from: Rb */
    private long f28736Rb;

    /* renamed from: Rc */
    private long f28737Rc;

    /* renamed from: Rd */
    private long f28738Rd;

    /* renamed from: Re */
    private boolean f28739Re;

    /* renamed from: Rf */
    private InterfaceC8884c f28740Rf;

    public C8881a(InterfaceC8884c interfaceC8884c) {
        this.f28740Rf = interfaceC8884c;
    }

    /* renamed from: F */
    public final void m29680F(long j) {
        this.f28736Rb = j;
        this.f28737Rc = SystemClock.uptimeMillis();
    }

    /* renamed from: av */
    public final void m29677av(String str) {
        this.f28735Ra = str;
    }

    /* renamed from: qh */
    public final void m29676qh() {
        if (this.f28739Re) {
            return;
        }
        this.f28739Re = true;
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8881a.this.f28738Rd = SystemClock.uptimeMillis();
                C8881a.this.report();
            }
        });
    }

    public final void report() {
        C8883b c8883b = new C8883b();
        c8883b.f28742Ra = this.f28735Ra;
        long j = this.f28736Rb;
        c8883b.f28744Ri = j != 0 ? this.f28737Rc - j : 0L;
        long j2 = this.f28737Rc;
        c8883b.f28745Rj = j2 != 0 ? this.f28738Rd - j2 : 0L;
        c8883b.f28743Rh = j != 0 ? this.f28738Rd - j : 0L;
        C8766a.m29888qi().m29915a(c8883b);
        C10331c.m26254d("PageMonitor", c8883b.toString());
    }

    /* renamed from: a */
    public final void m29679a(PageCreateStage pageCreateStage) {
        InterfaceC8884c interfaceC8884c = this.f28740Rf;
        if (interfaceC8884c != null) {
            interfaceC8884c.onCreateStageChange(pageCreateStage);
        }
    }
}
