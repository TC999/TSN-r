package com.qq.e.comm.plugin.o0.g;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.p.j.f;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.o0.g.b f45104c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.b f45105d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f45106e;

    /* renamed from: f  reason: collision with root package name */
    private b f45107f;

    /* renamed from: g  reason: collision with root package name */
    private a f45108g;

    /* renamed from: h  reason: collision with root package name */
    private final String f45109h;

    /* renamed from: i  reason: collision with root package name */
    private volatile f f45110i;

    /* renamed from: j  reason: collision with root package name */
    private final com.qq.e.comm.plugin.p.c f45111j;

    /* renamed from: k  reason: collision with root package name */
    private volatile double f45112k = 0.0d;

    /* renamed from: l  reason: collision with root package name */
    private double f45113l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void a(File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, com.qq.e.comm.plugin.o0.g.b bVar, com.qq.e.comm.plugin.p.b bVar2, com.qq.e.comm.plugin.p.c cVar) {
        this.f45104c = bVar;
        this.f45105d = bVar2;
        this.f45109h = str;
        this.f45111j = cVar;
        this.f45113l = bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d4) {
        this.f45112k = d4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f45106e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f45106e = true;
        a(false);
        if (this.f45112k > this.f45113l) {
            this.f45113l = this.f45112k;
            d1.a("Continue download " + this.f45113l, new Object[0]);
            a(true);
        }
        b bVar = this.f45107f;
        if (bVar != null) {
            bVar.a(this.f45109h);
        }
        this.f45106e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qq.e.comm.plugin.o0.g.b a() {
        return this.f45104c;
    }

    private void a(boolean z3) {
        File file = (this.f45104c.b() == null || TextUtils.isEmpty(this.f45104c.d())) ? null : new File(this.f45104c.b(), this.f45104c.d());
        a aVar = this.f45108g;
        if (aVar != null) {
            aVar.a(file);
        }
        this.f45110i = new f(this.f45104c.g(), file, this.f45104c.k() ? 3 : 1, this.f45111j, this.f45104c.i(), this.f45104c.f());
        this.f45110i.a(this.f45105d);
        this.f45110i.a(this.f45113l);
        this.f45110i.b(z3);
        if (this.f45104c.i()) {
            v.a(1402203, this.f45104c.a(), Integer.valueOf(com.qq.e.comm.plugin.util.v2.a.a("vcrn")));
        }
        if (!this.f45110i.g() && this.f45104c.i()) {
            d dVar = new d();
            dVar.a("rs", this.f45104c.g());
            v.b(1402204, this.f45104c.a(), Integer.valueOf(this.f45110i.b()), dVar);
        }
        d1.a("download result" + this.f45110i.b() + " " + this.f45110i.a(), new Object[0]);
    }

    public void a(com.qq.e.comm.plugin.p.b bVar) {
        if (bVar != null) {
            this.f45105d = bVar;
            if (this.f45110i != null) {
                this.f45110i.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f45107f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f45108g = aVar;
    }
}
