package com.qq.e.comm.plugin.u.k;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.gdtnativead.p.b.g;
import com.qq.e.comm.plugin.gdtnativead.p.b.h;
import com.qq.e.comm.plugin.u.f;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.j0;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.u.k.b f46309a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f46310b;

    /* renamed from: c  reason: collision with root package name */
    protected final q f46311c;

    /* renamed from: d  reason: collision with root package name */
    protected final VideoOption f46312d;

    /* renamed from: e  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.n0.c f46313e;

    /* renamed from: f  reason: collision with root package name */
    private final f.a f46314f;

    /* renamed from: g  reason: collision with root package name */
    protected d f46315g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f46316h;

    /* renamed from: i  reason: collision with root package name */
    private com.qq.e.comm.plugin.util.w2.c f46317i;

    /* renamed from: j  reason: collision with root package name */
    private Activity f46318j;

    /* renamed from: k  reason: collision with root package name */
    private final j0 f46319k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.util.w2.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f46320c;

        a(s sVar) {
            this.f46320c = sVar;
        }

        @Override // com.qq.e.comm.plugin.util.w2.b
        public void a(long j4) {
        }

        @Override // com.qq.e.comm.plugin.util.w2.b
        public void b(long j4) {
            this.f46320c.a(j4);
            this.f46320c.a(c.this.f46319k.a("vdoTime", j4).a());
        }

        @Override // com.qq.e.comm.plugin.util.w2.b
        public long c() {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (c.this.f46318j.equals(activity)) {
                ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(c.this.f46311c.l0(), LifecycleCallback.class)).l().b(LifecycleCallback.a.PAUSED);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (c.this.f46318j.equals(activity)) {
                ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(c.this.f46311c.l0(), LifecycleCallback.class)).l().b(LifecycleCallback.a.RESUMED);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public c(Context context, q qVar, VideoOption videoOption, f.a aVar, com.qq.e.comm.plugin.n0.c cVar) {
        this.f46309a = new com.qq.e.comm.plugin.u.k.b(context, qVar.q0());
        this.f46311c = qVar;
        this.f46310b = context;
        this.f46312d = videoOption;
        this.f46313e = cVar;
        this.f46314f = aVar;
        qVar.i0();
        this.f46316h = true;
        this.f46315g = new d(this.f46310b, this.f46309a, this.f46311c, this.f46312d, this.f46313e);
        this.f46319k = new j0();
    }

    private g e() {
        if (this.f46311c.o() == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD && this.f46311c.l1() && !TextUtils.isEmpty(this.f46311c.e())) {
            return new h(this.f46310b, this.f46311c);
        }
        return null;
    }

    private com.qq.e.comm.plugin.gdtnativead.p.a f() {
        com.qq.e.comm.plugin.gdtnativead.p.a aVar = new com.qq.e.comm.plugin.gdtnativead.p.a(this.f46310b, 1, this.f46311c.X(), true, true);
        aVar.a(this.f46313e);
        aVar.a(true, false);
        aVar.a(true);
        return aVar;
    }

    private JSONObject i() {
        j0 j0Var = new j0();
        VideoOption videoOption = this.f46312d;
        if (videoOption != null) {
            j0Var.a("vidMut", videoOption.getAutoPlayMuted() ? 1 : 0);
            j0Var.a("volume", !this.f46312d.getAutoPlayMuted());
        } else {
            j0Var.a("vidMut", 1);
            j0Var.a("volume", 0);
        }
        com.qq.e.comm.plugin.dl.d.a(j0Var);
        return j0Var.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.f46314f.a(103);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.f46314f.a(this.f46315g);
    }

    @Override // com.qq.e.comm.plugin.u.f
    public void destroy() {
        d dVar = this.f46315g;
        if (dVar != null) {
            dVar.h();
        }
        com.qq.e.comm.plugin.util.w2.c cVar = this.f46317i;
        if (cVar != null) {
            cVar.a();
        }
    }

    protected void g() {
        c();
    }

    protected void h() {
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void j() {
        /*
            r4 = this;
            com.qq.e.comm.plugin.g0.q r0 = r4.f46311c
            int r0 = r0.q1()
            com.qq.e.comm.plugin.g0.q r1 = r4.f46311c
            int r1 = r1.o1()
            if (r0 <= 0) goto L21
            android.content.Context r2 = r4.f46310b
            int r3 = com.qq.e.comm.plugin.util.f1.c(r2)
            int r2 = com.qq.e.comm.plugin.util.f1.b(r2, r3)
            if (r0 >= r2) goto L21
            android.content.Context r2 = r4.f46310b
            int r0 = com.qq.e.comm.plugin.util.f1.a(r2, r0)
            goto L22
        L21:
            r0 = -1
        L22:
            if (r1 <= 0) goto L2b
            android.content.Context r2 = r4.f46310b
            int r1 = com.qq.e.comm.plugin.util.f1.a(r2, r1)
            goto L2c
        L2b:
            r1 = -2
        L2c:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r0, r1)
            r0 = 17
            r2.gravity = r0
            com.qq.e.comm.plugin.u.k.b r0 = r4.f46309a
            r0.setLayoutParams(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.u.k.c.j():void");
    }

    @Override // com.qq.e.comm.plugin.u.f
    public View a() {
        return this.f46309a;
    }

    @Override // com.qq.e.comm.plugin.u.f
    public com.qq.e.comm.plugin.u.h b() {
        return this.f46315g;
    }

    @Override // com.qq.e.comm.plugin.u.f
    public void a(boolean z3) {
        com.qq.e.comm.plugin.u.d.a(this.f46313e, 0);
        if (b(z3)) {
            h();
        } else {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(boolean z3) {
        s a4 = i.a().a(this.f46310b, this.f46311c, this.f46316h);
        if (a4 == null) {
            g();
            d1.a("NativeTemplateAssembler", "Native DSL \u7ebf\u4e0a\u53ca\u515c\u5e95\u5747\u6e32\u67d3\u5931\u8d25");
            return false;
        }
        a(a4, z3);
        d1.a("NativeTemplateAssembler", "Native DSL \u6e32\u67d3\u6210\u529f");
        return true;
    }

    @Override // com.qq.e.comm.plugin.u.f
    public void a(Activity activity) {
        this.f46318j = activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, boolean z3) {
        h0.b bVar;
        g gVar;
        com.qq.e.comm.plugin.o0.h.f fVar;
        com.qq.e.comm.plugin.r0.a aVar;
        this.f46315g.b(sVar);
        if (sVar.l()) {
            a(sVar);
        }
        View j4 = sVar.j();
        this.f46309a.removeAllViews();
        com.qq.e.comm.plugin.gdtnativead.p.a aVar2 = null;
        r3 = null;
        com.qq.e.comm.plugin.r0.a aVar3 = null;
        if (this.f46311c.l1()) {
            sVar.a((h0.c) null);
            g e4 = e();
            com.qq.e.comm.plugin.gdtnativead.p.a f4 = f();
            h0.b e5 = sVar.e();
            fVar = sVar.i();
            if (e5 != null && fVar != null) {
                e5.addView(f4);
                fVar.a(f4);
                if (e4 != null) {
                    e5.addView(e4.a(), -1, -1);
                }
                aVar3 = a(e5);
            }
            aVar = aVar3;
            aVar2 = f4;
            bVar = e5;
            gVar = e4;
        } else {
            bVar = null;
            gVar = null;
            fVar = null;
            aVar = null;
        }
        this.f46309a.addView(j4, -1, -1);
        this.f46315g.a(sVar, fVar, aVar2, bVar, gVar, aVar, z3);
        sVar.a(i());
        j();
    }

    private void b(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.getApplication().registerActivityLifecycleCallbacks(new b());
    }

    private void a(s sVar) {
        this.f46317i = new com.qq.e.comm.plugin.util.w2.c(this.f46311c);
        a aVar = new a(sVar);
        if (!h0.f42444z && this.f46311c.l1()) {
            this.f46317i.a(aVar, false);
        } else {
            this.f46317i.a(aVar, true);
        }
        b(this.f46318j);
    }

    private com.qq.e.comm.plugin.r0.a a(FrameLayout frameLayout) {
        int a4 = f1.a(this.f46310b, 46);
        com.qq.e.comm.plugin.r0.a aVar = new com.qq.e.comm.plugin.r0.a(this.f46310b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4, a4);
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
        aVar.setVisibility(4);
        frameLayout.addView(aVar);
        return aVar;
    }
}
