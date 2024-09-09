package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.request.target.r;
import com.stub.StubApp;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestManager.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class j implements com.bumptech.glide.manager.i, h<i<Drawable>> {

    /* renamed from: l  reason: collision with root package name */
    private static final com.bumptech.glide.request.h f16772l = com.bumptech.glide.request.h.W0(Bitmap.class).k0();

    /* renamed from: m  reason: collision with root package name */
    private static final com.bumptech.glide.request.h f16773m = com.bumptech.glide.request.h.W0(GifDrawable.class).k0();

    /* renamed from: n  reason: collision with root package name */
    private static final com.bumptech.glide.request.h f16774n = com.bumptech.glide.request.h.X0(com.bumptech.glide.load.engine.j.f17105c).y0(Priority.LOW).G0(true);

    /* renamed from: a  reason: collision with root package name */
    protected final d f16775a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f16776b;

    /* renamed from: c  reason: collision with root package name */
    final com.bumptech.glide.manager.h f16777c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final n f16778d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private final m f16779e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private final o f16780f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f16781g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f16782h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.manager.c f16783i;

    /* renamed from: j  reason: collision with root package name */
    private final CopyOnWriteArrayList<com.bumptech.glide.request.g<Object>> f16784j;
    @GuardedBy("this")

    /* renamed from: k  reason: collision with root package name */
    private com.bumptech.glide.request.h f16785k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestManager.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.f16777c.b(jVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestManager.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b extends r<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.p
        public void k(@NonNull Object obj, @Nullable com.bumptech.glide.request.transition.f<? super Object> fVar) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestManager.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class c implements c.a {
        @GuardedBy("RequestManager.this")

        /* renamed from: a  reason: collision with root package name */
        private final n f16787a;

        c(@NonNull n nVar) {
            this.f16787a = nVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z3) {
            if (z3) {
                synchronized (j.this) {
                    this.f16787a.h();
                }
            }
        }
    }

    public j(@NonNull d dVar, @NonNull com.bumptech.glide.manager.h hVar, @NonNull m mVar, @NonNull Context context) {
        this(dVar, hVar, mVar, new n(), dVar.h(), context);
    }

    private void Y(@NonNull p<?> pVar) {
        if (X(pVar) || this.f16775a.u(pVar) || pVar.i() == null) {
            return;
        }
        com.bumptech.glide.request.d i4 = pVar.i();
        pVar.m(null);
        i4.clear();
    }

    private synchronized void Z(@NonNull com.bumptech.glide.request.h hVar) {
        this.f16785k = this.f16785k.b(hVar);
    }

    @NonNull
    @CheckResult
    public i<File> A(@Nullable Object obj) {
        return B().o(obj);
    }

    @NonNull
    @CheckResult
    public i<File> B() {
        return t(File.class).b(f16774n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.request.g<Object>> C() {
        return this.f16784j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.bumptech.glide.request.h D() {
        return this.f16785k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> k<?, T> E(Class<T> cls) {
        return this.f16775a.i().e(cls);
    }

    public synchronized boolean F() {
        return this.f16778d.e();
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: G */
    public i<Drawable> l(@Nullable Bitmap bitmap) {
        return v().l(bitmap);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: H */
    public i<Drawable> g(@Nullable Drawable drawable) {
        return v().g(drawable);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: I */
    public i<Drawable> d(@Nullable Uri uri) {
        return v().d(uri);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: J */
    public i<Drawable> f(@Nullable File file) {
        return v().f(file);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: K */
    public i<Drawable> p(@Nullable @DrawableRes @RawRes Integer num) {
        return v().p(num);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: L */
    public i<Drawable> o(@Nullable Object obj) {
        return v().o(obj);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: M */
    public i<Drawable> a(@Nullable String str) {
        return v().a(str);
    }

    @Override // com.bumptech.glide.h
    @CheckResult
    @Deprecated
    /* renamed from: N */
    public i<Drawable> c(@Nullable URL url) {
        return v().c(url);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: O */
    public i<Drawable> e(@Nullable byte[] bArr) {
        return v().e(bArr);
    }

    public synchronized void P() {
        this.f16778d.f();
    }

    public synchronized void Q() {
        this.f16778d.g();
    }

    public synchronized void R() {
        Q();
        for (j jVar : this.f16779e.a()) {
            jVar.Q();
        }
    }

    public synchronized void S() {
        this.f16778d.i();
    }

    public synchronized void T() {
        com.bumptech.glide.util.k.b();
        S();
        for (j jVar : this.f16779e.a()) {
            jVar.S();
        }
    }

    @NonNull
    public synchronized j U(@NonNull com.bumptech.glide.request.h hVar) {
        V(hVar);
        return this;
    }

    protected synchronized void V(@NonNull com.bumptech.glide.request.h hVar) {
        this.f16785k = hVar.clone().h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void W(@NonNull p<?> pVar, @NonNull com.bumptech.glide.request.d dVar) {
        this.f16780f.d(pVar);
        this.f16778d.j(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean X(@NonNull p<?> pVar) {
        com.bumptech.glide.request.d i4 = pVar.i();
        if (i4 == null) {
            return true;
        }
        if (this.f16778d.c(i4)) {
            this.f16780f.e(pVar);
            pVar.m(null);
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onDestroy() {
        this.f16780f.onDestroy();
        for (p<?> pVar : this.f16780f.c()) {
            z(pVar);
        }
        this.f16780f.a();
        this.f16778d.d();
        this.f16777c.a(this);
        this.f16777c.a(this.f16783i);
        this.f16782h.removeCallbacks(this.f16781g);
        this.f16775a.z(this);
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onStart() {
        S();
        this.f16780f.onStart();
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onStop() {
        Q();
        this.f16780f.onStop();
    }

    public j r(com.bumptech.glide.request.g<Object> gVar) {
        this.f16784j.add(gVar);
        return this;
    }

    @NonNull
    public synchronized j s(@NonNull com.bumptech.glide.request.h hVar) {
        Z(hVar);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> i<ResourceType> t(@NonNull Class<ResourceType> cls) {
        return new i<>(this.f16775a, this, cls, this.f16776b);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f16778d + ", treeNode=" + this.f16779e + "}";
    }

    @NonNull
    @CheckResult
    public i<Bitmap> u() {
        return t(Bitmap.class).b(f16772l);
    }

    @NonNull
    @CheckResult
    public i<Drawable> v() {
        return t(Drawable.class);
    }

    @NonNull
    @CheckResult
    public i<File> w() {
        return t(File.class).b(com.bumptech.glide.request.h.q1(true));
    }

    @NonNull
    @CheckResult
    public i<GifDrawable> x() {
        return t(GifDrawable.class).b(f16773m);
    }

    public void y(@NonNull View view) {
        z(new b(view));
    }

    public synchronized void z(@Nullable p<?> pVar) {
        if (pVar == null) {
            return;
        }
        Y(pVar);
    }

    j(d dVar, com.bumptech.glide.manager.h hVar, m mVar, n nVar, com.bumptech.glide.manager.d dVar2, Context context) {
        this.f16780f = new o();
        a aVar = new a();
        this.f16781g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f16782h = handler;
        this.f16775a = dVar;
        this.f16777c = hVar;
        this.f16779e = mVar;
        this.f16778d = nVar;
        this.f16776b = context;
        com.bumptech.glide.manager.c a4 = dVar2.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new c(nVar));
        this.f16783i = a4;
        if (com.bumptech.glide.util.k.s()) {
            handler.post(aVar);
        } else {
            hVar.b(this);
        }
        hVar.b(a4);
        this.f16784j = new CopyOnWriteArrayList<>(dVar.i().c());
        V(dVar.i().d());
        dVar.t(this);
    }
}
