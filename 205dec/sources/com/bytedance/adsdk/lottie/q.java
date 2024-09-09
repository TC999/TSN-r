package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.sdk.component.gd.sr;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f25694e = sr.w(new com.bytedance.sdk.component.gd.k("ie/LottieTask"));

    /* renamed from: a  reason: collision with root package name */
    private final Set<l<T>> f25695a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<l<Throwable>> f25696b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f25697c;

    /* renamed from: d  reason: collision with root package name */
    private volatile com.bytedance.adsdk.lottie.b<T> f25698d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.adsdk.lottie.b bVar = q.this.f25698d;
            if (bVar == null) {
                return;
            }
            if (bVar.a() != null) {
                q.this.g(bVar.a());
            } else {
                q.this.h(bVar.b());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class b extends FutureTask<com.bytedance.adsdk.lottie.b<T>> {
        b(Callable<com.bytedance.adsdk.lottie.b<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                q.this.setResult(get());
            } catch (InterruptedException | ExecutionException e4) {
                q.this.setResult(new com.bytedance.adsdk.lottie.b(e4));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q(Callable<com.bytedance.adsdk.lottie.b<T>> callable) {
        this(callable, false);
    }

    private void c() {
        this.f25697c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(T t3) {
        for (l lVar : new ArrayList(this.f25695a)) {
            lVar.c(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(Throwable th) {
        ArrayList<l> arrayList = new ArrayList(this.f25696b);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.f.e.b("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (l lVar : arrayList) {
            lVar.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(com.bytedance.adsdk.lottie.b<T> bVar) {
        if (this.f25698d == null) {
            this.f25698d = bVar;
            c();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized q<T> b(l<T> lVar) {
        com.bytedance.adsdk.lottie.b<T> bVar = this.f25698d;
        if (bVar != null && bVar.a() != null) {
            lVar.c(bVar.a());
        }
        this.f25695a.add(lVar);
        return this;
    }

    public synchronized q<T> i(l<Throwable> lVar) {
        this.f25696b.remove(lVar);
        return this;
    }

    public synchronized q<T> j(l<T> lVar) {
        this.f25695a.remove(lVar);
        return this;
    }

    public synchronized q<T> k(l<Throwable> lVar) {
        com.bytedance.adsdk.lottie.b<T> bVar = this.f25698d;
        if (bVar != null && bVar.b() != null) {
            lVar.c(bVar.b());
        }
        this.f25696b.add(lVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q(Callable<com.bytedance.adsdk.lottie.b<T>> callable, boolean z3) {
        this.f25695a = new LinkedHashSet(1);
        this.f25696b = new LinkedHashSet(1);
        this.f25697c = new Handler(Looper.getMainLooper());
        this.f25698d = null;
        if (z3) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new com.bytedance.adsdk.lottie.b<>(th));
                return;
            }
        }
        f25694e.execute(new b(callable));
    }
}
