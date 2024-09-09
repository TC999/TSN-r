package com.qq.e.comm.plugin.splash.s;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.b.k;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.splash.s.c;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g extends FrameLayout implements c {

    /* renamed from: c  reason: collision with root package name */
    private h f46217c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.h f46218d;

    /* renamed from: e  reason: collision with root package name */
    private final k.b f46219e;

    /* renamed from: f  reason: collision with root package name */
    private final c.a f46220f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f46221g;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f46220f != null) {
                g.this.f46220f.b(view.getId());
            }
        }
    }

    public g(com.qq.e.comm.plugin.splash.h hVar, c.a aVar) {
        super(hVar.f46089a);
        this.f46221g = new a();
        this.f46218d = hVar;
        this.f46219e = k.a(k.c.SPLASH, hVar.b());
        this.f46220f = aVar;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.splash.s.g.b():void");
    }

    @Override // com.qq.e.comm.plugin.splash.s.c
    public View a() {
        return this;
    }

    private void a(c0 c0Var, boolean z3, com.qq.e.comm.plugin.splash.s.a aVar, boolean z4) {
        if (c0Var == null || TextUtils.isEmpty(c0Var.Q0())) {
            return;
        }
        if (z3 && aVar.a()) {
            return;
        }
        j.a(this, c0Var.Q0(), this.f46221g, z4);
    }

    @Override // com.qq.e.comm.plugin.splash.s.c
    public void a(long j4) {
        this.f46217c.a(j4);
    }
}
