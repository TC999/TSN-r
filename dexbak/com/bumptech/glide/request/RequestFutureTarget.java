package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import com.bumptech.glide.util.C3771k;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.request.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: k */
    private static final C3745a f14378k = new C3745a();

    /* renamed from: a */
    private final int f14379a;

    /* renamed from: b */
    private final int f14380b;

    /* renamed from: c */
    private final boolean f14381c;

    /* renamed from: d */
    private final C3745a f14382d;
    @Nullable

    /* renamed from: e */
    private R f14383e;
    @Nullable

    /* renamed from: f */
    private InterfaceC3744d f14384f;

    /* renamed from: g */
    private boolean f14385g;

    /* renamed from: h */
    private boolean f14386h;

    /* renamed from: i */
    private boolean f14387i;
    @Nullable

    /* renamed from: j */
    private GlideException f14388j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3745a {
        C3745a() {
        }

        /* renamed from: a */
        void m44587a(Object obj) {
            obj.notifyAll();
        }

        /* renamed from: b */
        void m44586b(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, f14378k);
    }

    /* renamed from: d */
    private synchronized R m44588d(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f14381c && !isDone()) {
            C3771k.m44390a();
        }
        if (!this.f14385g) {
            if (!this.f14387i) {
                if (this.f14386h) {
                    return this.f14383e;
                }
                if (l == null) {
                    this.f14382d.m44586b(this, 0L);
                } else if (l.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f14382d.m44586b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f14387i) {
                        if (!this.f14385g) {
                            if (this.f14386h) {
                                return this.f14383e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f14388j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f14388j);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.request.RequestListener
    /* renamed from: a */
    public synchronized boolean mo44585a(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.f14387i = true;
        this.f14388j = glideException;
        this.f14382d.m44587a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: b */
    public void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.RequestListener
    /* renamed from: c */
    public synchronized boolean mo44584c(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.f14386h = true;
        this.f14383e = r;
        this.f14382d.m44587a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        InterfaceC3744d interfaceC3744d;
        if (isDone()) {
            return false;
        }
        this.f14385g = true;
        this.f14382d.m44587a(this);
        if (z && (interfaceC3744d = this.f14384f) != null) {
            interfaceC3744d.clear();
            this.f14384f = null;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return m44588d(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: h */
    public void mo44473h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    /* renamed from: i */
    public synchronized InterfaceC3744d mo44472i() {
        return this.f14384f;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f14385g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f14385g && !this.f14386h) {
            z = this.f14387i;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: j */
    public void mo44471j(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: k */
    public synchronized void mo44364k(@NonNull R r, @Nullable InterfaceC3759f<? super R> interfaceC3759f) {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: m */
    public synchronized void mo44469m(@Nullable InterfaceC3744d interfaceC3744d) {
        this.f14384f = interfaceC3744d;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: n */
    public synchronized void mo44481n(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: q */
    public void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.mo44365e(this.f14379a, this.f14380b);
    }

    RequestFutureTarget(int i, int i2, boolean z, C3745a c3745a) {
        this.f14379a = i;
        this.f14380b = i2;
        this.f14381c = z;
        this.f14382d = c3745a;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m44588d(Long.valueOf(timeUnit.toMillis(j)));
    }
}
