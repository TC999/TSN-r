package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.request.target.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestFutureTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f<R> implements c<R>, g<R> {

    /* renamed from: k  reason: collision with root package name */
    private static final a f17909k = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f17910a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17911b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17912c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17913d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private R f17914e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private d f17915f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17916g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17917h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17918i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private GlideException f17919j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j4) throws InterruptedException {
            obj.wait(j4);
        }
    }

    public f(int i4, int i5) {
        this(i4, i5, true, f17909k);
    }

    private synchronized R d(Long l4) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f17912c && !isDone()) {
            com.bumptech.glide.util.k.a();
        }
        if (!this.f17916g) {
            if (!this.f17918i) {
                if (this.f17917h) {
                    return this.f17914e;
                }
                if (l4 == null) {
                    this.f17913d.b(this, 0L);
                } else if (l4.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l4.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f17913d.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f17918i) {
                        if (!this.f17916g) {
                            if (this.f17917h) {
                                return this.f17914e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f17919j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f17919j);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean a(@Nullable GlideException glideException, Object obj, p<R> pVar, boolean z3) {
        this.f17918i = true;
        this.f17919j = glideException;
        this.f17913d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.target.p
    public void b(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean c(R r3, Object obj, p<R> pVar, DataSource dataSource, boolean z3) {
        this.f17917h = true;
        this.f17914e = r3;
        this.f17913d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z3) {
        d dVar;
        if (isDone()) {
            return false;
        }
        this.f17916g = true;
        this.f17913d.a(this);
        if (z3 && (dVar = this.f17915f) != null) {
            dVar.clear();
            this.f17915f = null;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return d(null);
        } catch (TimeoutException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.bumptech.glide.request.target.p
    public void h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public synchronized d i() {
        return this.f17915f;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f17916g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z3;
        if (!this.f17916g && !this.f17917h) {
            z3 = this.f17918i;
        }
        return z3;
    }

    @Override // com.bumptech.glide.request.target.p
    public void j(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    public synchronized void k(@NonNull R r3, @Nullable com.bumptech.glide.request.transition.f<? super R> fVar) {
    }

    @Override // com.bumptech.glide.request.target.p
    public synchronized void m(@Nullable d dVar) {
        this.f17915f = dVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public synchronized void n(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.p
    public void q(@NonNull o oVar) {
        oVar.e(this.f17910a, this.f17911b);
    }

    f(int i4, int i5, boolean z3, a aVar) {
        this.f17910a = i4;
        this.f17911b = i5;
        this.f17912c = z3;
        this.f17913d = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j4, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return d(Long.valueOf(timeUnit.toMillis(j4)));
    }
}
