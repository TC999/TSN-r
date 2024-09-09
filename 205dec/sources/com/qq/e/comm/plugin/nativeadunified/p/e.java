package com.qq.e.comm.plugin.nativeadunified.p;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.nativeadunified.g;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.n2;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends com.qq.e.comm.plugin.nativeadunified.p.a {

    /* renamed from: n  reason: collision with root package name */
    private final VideoOption f45009n;

    /* renamed from: o  reason: collision with root package name */
    private final s f45010o;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f45011p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f45012q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f45013r;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends r {
        a(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            e.this.f45000i.a(fVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void k(com.qq.e.dl.l.j.c cVar) {
            super.k(cVar);
            e.this.f45000i.a();
            e.this.f45010o.p();
        }
    }

    public e(Context context, g gVar, VideoOption videoOption, a.d dVar, f.p pVar, com.qq.e.comm.plugin.nativeadunified.e eVar, View.OnTouchListener onTouchListener, MediaView mediaView) {
        super(context, gVar, videoOption, dVar, pVar, eVar, onTouchListener, mediaView);
        this.f45010o = i.a().a(context, gVar);
        this.f45009n = videoOption;
        p();
    }

    private void p() {
        if (this.f45010o != null && this.f44996e.l1()) {
            this.f45010o.a((h0.c) null);
            this.f45011p = this.f45010o.e();
            com.qq.e.comm.plugin.o0.h.f i4 = this.f45010o.i();
            this.f44993b = i4;
            if (i4 == null || this.f45011p == null) {
                return;
            }
            com.qq.e.comm.plugin.gdtnativead.p.a o4 = o();
            this.f44994c = o4;
            this.f45011p.addView(o4);
            a(this.f44993b);
            this.f45012q = true;
        }
    }

    private JSONObject r() {
        j0 j0Var = new j0();
        VideoOption videoOption = this.f45009n;
        if (videoOption != null) {
            j0Var.a("vidMut", videoOption.getAutoPlayMuted() ? 1 : 0);
            j0Var.a("volume", !this.f45009n.getAutoPlayMuted());
        } else {
            j0Var.a("vidMut", 1);
            j0Var.a("volume", 0);
        }
        com.qq.e.comm.plugin.dl.d.a(j0Var);
        return j0Var.a();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a, com.qq.e.comm.plugin.nativeadunified.p.b
    public void destroy() {
        s sVar = this.f45010o;
        if (sVar != null) {
            sVar.b();
        }
        super.destroy();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void j() {
        this.f45013r = false;
        this.f45010o.p();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a, com.qq.e.comm.plugin.nativeadunified.p.b
    public void k() {
        this.f45013r = true;
        if (m()) {
            this.f45010o.r();
        } else {
            super.k();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a
    public boolean m() {
        return this.f45010o.o();
    }

    public boolean q() {
        return this.f45012q;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a, com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(MediaView mediaView) {
        super.a(mediaView);
        View j4 = this.f45010o.j();
        n2.a(j4);
        this.f44995d.addView(j4, l());
        this.f45010o.a(r());
        this.f45010o.a(new a(this.f45010o, this.f44996e));
        n();
        if (this.f45013r) {
            k();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.a
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.f45011p;
        if (frameLayout != null) {
            frameLayout.addView(view, layoutParams);
        }
    }
}
