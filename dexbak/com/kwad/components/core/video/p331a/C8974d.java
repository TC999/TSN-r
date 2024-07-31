package com.kwad.components.core.video.p331a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.video.C8998i;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;

/* renamed from: com.kwad.components.core.video.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8974d extends AbstractC8971a {

    /* renamed from: UZ */
    private long f28923UZ;

    /* renamed from: Va */
    private long f28924Va;

    /* renamed from: Vb */
    private long f28925Vb;

    /* renamed from: Vc */
    private String f28926Vc;

    /* renamed from: Vd */
    private boolean f28927Vd;

    /* renamed from: Ve */
    private boolean f28928Ve;

    /* renamed from: Vf */
    private boolean f28929Vf;

    /* renamed from: Vg */
    private long f28930Vg;

    /* renamed from: Vh */
    private long f28931Vh;

    /* renamed from: Vi */
    private long f28932Vi;

    /* renamed from: Vj */
    private long f28933Vj;

    /* renamed from: tV */
    private C8998i f28934tV;

    /* renamed from: xL */
    private String f28935xL;

    @KsJson
    /* renamed from: com.kwad.components.core.video.a.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8976a extends AbstractC9822a {

        /* renamed from: Sd */
        public long f28941Sd;

        /* renamed from: Vp */
        public String f28942Vp;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    @KsJson
    /* renamed from: com.kwad.components.core.video.a.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8977b extends AbstractC9822a implements Cloneable {

        /* renamed from: Sd */
        public long f28943Sd;

        /* renamed from: UX */
        public int f28944UX;

        /* renamed from: Vp */
        public String f28945Vp;

        /* renamed from: Vq */
        public long f28946Vq;

        /* renamed from: Vr */
        public long f28947Vr;

        /* renamed from: Vs */
        public long f28948Vs;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;

        /* renamed from: rZ */
        public final C8977b clone() {
            try {
                return (C8977b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return new C8977b();
            }
        }
    }

    private C8974d(@NonNull AdTemplate adTemplate) {
        this.f28927Vd = false;
        this.f28928Ve = false;
        this.f28929Vf = false;
        try {
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            this.f28935xL = C10483a.m25977K(m25641dQ);
            this.f28923UZ = C10487e.m25644dN(adTemplate);
            this.f28924Va = C10487e.m25631ea(adTemplate);
            this.f28925Vb = C10483a.m25819cg(m25641dQ);
            this.f28926Vc = C10483a.m25823cc(m25641dQ);
            this.f28934tV = new C8998i();
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: ay */
    public static AbstractC8971a m29494ay(@NonNull AdTemplate adTemplate) {
        return C10251d.m26527a(C10250c.asO) ? new C8974d(adTemplate) : new C8972b();
    }

    /* renamed from: b */
    private void m29493b(boolean z, int i, int i2) {
        if (this.f28929Vf) {
            this.f28934tV.m29417rS();
            this.f28933Vj = SystemClock.elapsedRealtime();
            m29495a(z, i, i2);
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C8976a m29492o(int i, int i2) {
        C8976a c8976a = new C8976a();
        c8976a.code = i;
        c8976a.msg = String.valueOf(i2);
        c8976a.videoUrl = this.f28935xL;
        c8976a.llsid = this.f28923UZ;
        c8976a.creativeId = this.f28924Va;
        c8976a.f28941Sd = this.f28925Vb;
        c8976a.f28942Vp = this.f28926Vc;
        return c8976a;
    }

    /* renamed from: rY */
    private C8977b m29490rY() {
        C8977b c8977b = new C8977b();
        long j = this.f28931Vh;
        long j2 = this.f28930Vg;
        c8977b.f28946Vq = j - j2;
        c8977b.f28947Vr = this.f28932Vi - j2;
        c8977b.f28948Vs = this.f28934tV.m29415rU().m29412rX();
        c8977b.videoDuration = this.f28933Vj - this.f28930Vg;
        c8977b.f28944UX = this.f28934tV.m29415rU().m29413rW();
        c8977b.videoUrl = this.f28935xL;
        c8977b.llsid = this.f28923UZ;
        c8977b.creativeId = this.f28924Va;
        c8977b.f28943Sd = this.f28925Vb;
        c8977b.f28945Vp = this.f28926Vc;
        return c8977b;
    }

    private void reset() {
        this.f28934tV.reset();
        this.f28930Vg = 0L;
        this.f28931Vh = 0L;
        this.f28933Vj = 0L;
        this.f28932Vi = 0L;
        this.f28927Vd = false;
        this.f28928Ve = false;
        this.f28929Vf = false;
    }

    @Override // com.kwad.components.core.video.p331a.AbstractC8971a
    /* renamed from: oD */
    public final void mo29491oD() {
        if (this.f28929Vf) {
            return;
        }
        this.f28932Vi = SystemClock.elapsedRealtime();
        this.f28929Vf = true;
    }

    @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
    public final void onMediaPlayError(int i, int i2) {
        super.onMediaPlayError(i, i2);
        this.f28934tV.m29417rS();
        m29493b(false, i, i2);
    }

    @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.f28934tV.m29417rS();
    }

    @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (this.f28928Ve) {
            return;
        }
        this.f28931Vh = SystemClock.elapsedRealtime();
        this.f28928Ve = true;
    }

    @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        mo29491oD();
        this.f28934tV.m29417rS();
    }

    @Override // com.kwad.components.core.video.p331a.InterfaceC8973c
    public final void onRelease() {
        m29493b(true, 0, 0);
    }

    @Override // com.kwad.components.core.video.p331a.InterfaceC8973c
    public final void onReset() {
        m29493b(false, 0, 0);
    }

    @Override // com.kwad.components.core.video.p331a.InterfaceC8973c
    public final void onStart() {
        if (this.f28927Vd) {
            return;
        }
        this.f28930Vg = SystemClock.elapsedRealtime();
        this.f28927Vd = true;
    }

    @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC9001k
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.f28934tV.m29418rR();
    }

    @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC9001k
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.f28934tV.m29418rR();
    }

    /* renamed from: a */
    private void m29495a(final boolean z, final int i, final int i2) {
        final C8977b clone = m29490rY().clone();
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.video.a.d.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (!z) {
                    C9815b.m27649t(C8974d.this.m29492o(i, i2));
                } else {
                    C9815b.m27650s(clone);
                }
            }
        });
    }

    /* renamed from: a */
    public static AbstractC8971a m29496a(AdTemplate adTemplate, AdTemplate adTemplate2, String str) {
        if (C10251d.m26527a(C10250c.asO)) {
            if (adTemplate != null) {
                return new C8974d(adTemplate);
            }
            return adTemplate2 == null ? new C8974d(str) : new C8974d(adTemplate2);
        }
        return new C8972b();
    }

    private C8974d(String str) {
        this.f28927Vd = false;
        this.f28928Ve = false;
        this.f28929Vf = false;
        this.f28935xL = str;
        this.f28934tV = new C8998i();
    }
}
