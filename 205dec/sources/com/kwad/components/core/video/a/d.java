package com.kwad.components.core.video.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.core.video.a.a {
    private long UZ;
    private long Va;
    private long Vb;
    private String Vc;
    private boolean Vd;
    private boolean Ve;
    private boolean Vf;
    private long Vg;
    private long Vh;
    private long Vi;
    private long Vj;
    private i tV;
    private String xL;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.commercial.c.a {
        public long Sd;
        public String Vp;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.commercial.c.a implements Cloneable {
        public long Sd;
        public int UX;
        public String Vp;
        public long Vq;
        public long Vr;
        public long Vs;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;

        /* renamed from: rZ */
        public final b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return new b();
            }
        }
    }

    private d(@NonNull AdTemplate adTemplate) {
        this.Vd = false;
        this.Ve = false;
        this.Vf = false;
        try {
            AdInfo dQ = e.dQ(adTemplate);
            this.xL = com.kwad.sdk.core.response.b.a.K(dQ);
            this.UZ = e.dN(adTemplate);
            this.Va = e.ea(adTemplate);
            this.Vb = com.kwad.sdk.core.response.b.a.cg(dQ);
            this.Vc = com.kwad.sdk.core.response.b.a.cc(dQ);
            this.tV = new i();
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    public static com.kwad.components.core.video.a.a ay(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asO) ? new d(adTemplate) : new com.kwad.components.core.video.a.b();
    }

    private void b(boolean z3, int i4, int i5) {
        if (this.Vf) {
            this.tV.rS();
            this.Vj = SystemClock.elapsedRealtime();
            a(z3, i4, i5);
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a o(int i4, int i5) {
        a aVar = new a();
        aVar.code = i4;
        aVar.msg = String.valueOf(i5);
        aVar.videoUrl = this.xL;
        aVar.llsid = this.UZ;
        aVar.creativeId = this.Va;
        aVar.Sd = this.Vb;
        aVar.Vp = this.Vc;
        return aVar;
    }

    private b rY() {
        b bVar = new b();
        long j4 = this.Vh;
        long j5 = this.Vg;
        bVar.Vq = j4 - j5;
        bVar.Vr = this.Vi - j5;
        bVar.Vs = this.tV.rU().rX();
        bVar.videoDuration = this.Vj - this.Vg;
        bVar.UX = this.tV.rU().rW();
        bVar.videoUrl = this.xL;
        bVar.llsid = this.UZ;
        bVar.creativeId = this.Va;
        bVar.Sd = this.Vb;
        bVar.Vp = this.Vc;
        return bVar;
    }

    private void reset() {
        this.tV.reset();
        this.Vg = 0L;
        this.Vh = 0L;
        this.Vj = 0L;
        this.Vi = 0L;
        this.Vd = false;
        this.Ve = false;
        this.Vf = false;
    }

    @Override // com.kwad.components.core.video.a.a
    public final void oD() {
        if (this.Vf) {
            return;
        }
        this.Vi = SystemClock.elapsedRealtime();
        this.Vf = true;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayError(int i4, int i5) {
        super.onMediaPlayError(i4, i5);
        this.tV.rS();
        b(false, i4, i5);
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.tV.rS();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (this.Ve) {
            return;
        }
        this.Vh = SystemClock.elapsedRealtime();
        this.Ve = true;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        oD();
        this.tV.rS();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onRelease() {
        b(true, 0, 0);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onReset() {
        b(false, 0, 0);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onStart() {
        if (this.Vd) {
            return;
        }
        this.Vg = SystemClock.elapsedRealtime();
        this.Vd = true;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.tV.rR();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.tV.rR();
    }

    private void a(final boolean z3, final int i4, final int i5) {
        final b clone = rY().clone();
        g.execute(new ay() { // from class: com.kwad.components.core.video.a.d.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (!z3) {
                    com.kwad.sdk.commercial.b.t(d.this.o(i4, i5));
                } else {
                    com.kwad.sdk.commercial.b.s(clone);
                }
            }
        });
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, AdTemplate adTemplate2, String str) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asO)) {
            if (adTemplate != null) {
                return new d(adTemplate);
            }
            return adTemplate2 == null ? new d(str) : new d(adTemplate2);
        }
        return new com.kwad.components.core.video.a.b();
    }

    private d(String str) {
        this.Vd = false;
        this.Ve = false;
        this.Vf = false;
        this.xL = str;
        this.tV = new i();
    }
}
