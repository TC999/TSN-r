package com.beizi.fusion.b;

import com.beizi.fusion.b.a;
import com.beizi.fusion.g.af;
import java.util.Observable;
import java.util.Observer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ObserverAdStatus.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public a.i f14492a;

    /* renamed from: b  reason: collision with root package name */
    public a.h f14493b;

    /* renamed from: c  reason: collision with root package name */
    public a.k f14494c;

    /* renamed from: d  reason: collision with root package name */
    public a.g f14495d;

    /* renamed from: e  reason: collision with root package name */
    public a.d f14496e;

    /* renamed from: f  reason: collision with root package name */
    public a.e f14497f;

    /* renamed from: g  reason: collision with root package name */
    public a.f f14498g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f14499h;

    /* renamed from: i  reason: collision with root package name */
    public a.b f14500i;

    /* renamed from: j  reason: collision with root package name */
    public a.j f14501j;

    /* renamed from: k  reason: collision with root package name */
    public a.C0132a f14502k;

    /* renamed from: l  reason: collision with root package name */
    private final a f14503l;

    /* renamed from: m  reason: collision with root package name */
    private b f14504m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14505n = false;

    public d(b bVar) {
        this.f14504m = bVar;
        a aVar = new a();
        this.f14503l = aVar;
        this.f14492a = new a.i();
        this.f14493b = new a.h();
        this.f14494c = new a.k();
        this.f14495d = new a.g();
        this.f14496e = new a.d();
        this.f14497f = new a.e();
        this.f14498g = new a.f();
        this.f14499h = new a.c();
        this.f14500i = new a.b();
        this.f14501j = new a.j();
        this.f14502k = new a.C0132a();
    }

    public a a() {
        return this.f14503l;
    }

    public b b() {
        return this.f14504m;
    }

    public boolean c() {
        return this.f14505n;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof a.l) && (obj instanceof b)) {
            b bVar = (b) obj;
            String k4 = bVar.k();
            String d4 = bVar.d();
            int O = bVar.O();
            String P = bVar.P();
            String Q = bVar.Q();
            String c4 = bVar.c();
            af.a("BeiZis", "channel == " + k4 + ",eventCode = " + d4 + ";buyerSpaceId:" + bVar.s() + ",srcType = " + O + ",price = " + P + ",bidPrice = " + Q + ",eventId = " + c4 + ",buyerSpaceId = " + bVar.m());
            c.a(com.beizi.fusion.d.b.a().e()).a(bVar);
        }
    }

    public void a(boolean z3) {
        this.f14505n = z3;
    }
}
