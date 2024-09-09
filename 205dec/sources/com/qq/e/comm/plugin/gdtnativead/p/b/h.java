package com.qq.e.comm.plugin.gdtnativead.p.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.util.n2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends FrameLayout implements g {

    /* renamed from: c  reason: collision with root package name */
    private f f43972c;

    /* renamed from: d  reason: collision with root package name */
    private f f43973d;

    /* renamed from: e  reason: collision with root package name */
    private final f f43974e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f43975f;

    /* renamed from: g  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43976g;

    /* renamed from: h  reason: collision with root package name */
    private e f43977h;

    /* renamed from: i  reason: collision with root package name */
    private a f43978i;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a();

        void a(View view, String str);
    }

    public h(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        super(context);
        this.f43975f = context;
        this.f43976g = eVar;
        this.f43974e = new i(context, eVar);
        c();
    }

    private void c() {
        f fVar = this.f43973d;
        if (fVar != null) {
            fVar.destroy();
            removeView(this.f43973d.a());
        }
        this.f43977h = new b(new com.qq.e.comm.plugin.gdtnativead.p.b.a(this.f43976g));
        try {
            c cVar = new c(this.f43977h, new com.qq.e.comm.plugin.q0.d(this.f43975f, this.f43976g, true).a());
            this.f43973d = cVar;
            cVar.a(this.f43978i);
            this.f43977h.a(this.f43973d);
            addView(this.f43973d.a());
            this.f43972c = this.f43973d;
        } catch (Exception unused) {
            this.f43972c = this.f43974e;
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.g
    public View a() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.g
    public void a(a aVar) {
        this.f43978i = aVar;
        f fVar = this.f43973d;
        if (fVar != null) {
            fVar.a(aVar);
        }
        this.f43974e.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.g
    public void b() {
        this.f43972c.dismiss();
        f fVar = this.f43972c;
        f fVar2 = this.f43974e;
        if (fVar == fVar2) {
            removeView(fVar2.a());
            c();
        }
        this.f43977h.b();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.g
    public void destroy() {
        f fVar = this.f43973d;
        if (fVar != null) {
            fVar.destroy();
        }
        this.f43974e.destroy();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.g
    public void show() {
        f fVar = this.f43973d;
        if (fVar == null || !fVar.show()) {
            c();
            View a4 = this.f43974e.a();
            n2.a(a4);
            addView(a4);
            this.f43974e.show();
            this.f43972c = this.f43974e;
        }
    }
}
