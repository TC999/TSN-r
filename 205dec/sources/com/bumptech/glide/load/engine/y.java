package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SourceGenerator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class y implements f, d.a<Object>, f.a {

    /* renamed from: h  reason: collision with root package name */
    private static final String f17247h = "SourceGenerator";

    /* renamed from: a  reason: collision with root package name */
    private final g<?> f17248a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f17249b;

    /* renamed from: c  reason: collision with root package name */
    private int f17250c;

    /* renamed from: d  reason: collision with root package name */
    private c f17251d;

    /* renamed from: e  reason: collision with root package name */
    private Object f17252e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n.a<?> f17253f;

    /* renamed from: g  reason: collision with root package name */
    private d f17254g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(g<?> gVar, f.a aVar) {
        this.f17248a = gVar;
        this.f17249b = aVar;
    }

    private void g(Object obj) {
        long b4 = com.bumptech.glide.util.f.b();
        try {
            com.bumptech.glide.load.a<X> p3 = this.f17248a.p(obj);
            e eVar = new e(p3, obj, this.f17248a.k());
            this.f17254g = new d(this.f17253f.f17316a, this.f17248a.o());
            this.f17248a.d().a(this.f17254g, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f17254g + ", data: " + obj + ", encoder: " + p3 + ", duration: " + com.bumptech.glide.util.f.a(b4));
            }
            this.f17253f.f17318c.b();
            this.f17251d = new c(Collections.singletonList(this.f17253f.f17316a), this.f17248a, this);
        } catch (Throwable th) {
            this.f17253f.f17318c.b();
            throw th;
        }
    }

    private boolean h() {
        return this.f17250c < this.f17248a.g().size();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f17249b.a(cVar, exc, dVar, this.f17253f.f17318c.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        Object obj = this.f17252e;
        if (obj != null) {
            this.f17252e = null;
            g(obj);
        }
        c cVar = this.f17251d;
        if (cVar == null || !cVar.b()) {
            this.f17251d = null;
            this.f17253f = null;
            boolean z3 = false;
            while (!z3 && h()) {
                List<n.a<?>> g4 = this.f17248a.g();
                int i4 = this.f17250c;
                this.f17250c = i4 + 1;
                this.f17253f = g4.get(i4);
                if (this.f17253f != null && (this.f17248a.e().c(this.f17253f.f17318c.getDataSource()) || this.f17248a.t(this.f17253f.f17318c.a()))) {
                    this.f17253f.f17318c.d(this.f17248a.l(), this);
                    z3 = true;
                }
            }
            return z3;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f17249b.a(this.f17254g, exc, this.f17253f.f17318c, this.f17253f.f17318c.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f17253f;
        if (aVar != null) {
            aVar.f17318c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void d() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(Object obj) {
        j e4 = this.f17248a.e();
        if (obj != null && e4.c(this.f17253f.f17318c.getDataSource())) {
            this.f17252e = obj;
            this.f17249b.d();
            return;
        }
        this.f17249b.f(this.f17253f.f17316a, obj, this.f17253f.f17318c, this.f17253f.f17318c.getDataSource(), this.f17254g);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void f(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f17249b.f(cVar, obj, dVar, this.f17253f.f17318c.getDataSource(), cVar);
    }
}
