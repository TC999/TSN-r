package com.qq.e.comm.plugin.fs.f.e.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private boolean f43442c;

    /* renamed from: d  reason: collision with root package name */
    private float f43443d;

    /* renamed from: e  reason: collision with root package name */
    private float f43444e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.comm.plugin.q0.h f43445f;

    /* renamed from: g  reason: collision with root package name */
    private int f43446g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43447h;

    /* renamed from: i  reason: collision with root package name */
    private a f43448i;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a(com.qq.e.comm.plugin.i.f fVar);

        void b();
    }

    public g(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.q0.h hVar) {
        this.f43447h = eVar;
        this.f43445f = hVar;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        com.qq.e.comm.plugin.e.a.a().a(this.f43445f.a(), eVar);
        this.f43446g = ViewConfiguration.get(this.f43445f.a().getContext()).getScaledTouchSlop();
    }

    public void a(a aVar) {
        this.f43448i = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.qq.e.comm.plugin.q0.h hVar = this.f43445f;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f43445f.a());
        if (d4 != null) {
            d4.a(motionEvent, true);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f43443d = motionEvent.getRawX();
            this.f43444e = motionEvent.getRawY();
        } else if (action == 1 || action == 3) {
            a(motionEvent);
        }
        return this.f43445f.a().onTouchEvent(motionEvent);
    }

    private void a(MotionEvent motionEvent) {
        a aVar = this.f43448i;
        if (aVar != null) {
            aVar.b();
        }
        if (Math.abs(motionEvent.getRawX() - this.f43443d) <= this.f43446g) {
            Math.abs(motionEvent.getRawY() - this.f43444e);
        }
        this.f43445f.f(true);
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f43445f.a());
        if (d4 != null) {
            d4.d(4);
        }
        if (this.f43442c) {
            return;
        }
        d1.a("LandingPageTouchHandler", "LandingPageView user click");
        this.f43442c = true;
        if (this.f43448i != null) {
            String a4 = com.qq.e.comm.plugin.e.a.a().a(this.f43445f.a());
            com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(this.f43447h);
            fVar.f44110g = 4;
            fVar.f44105b = a4;
            this.f43448i.a(fVar);
        }
    }
}
