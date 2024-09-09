package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapPreFillRunner.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a implements Runnable {
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final String f17182i = "PreFillRunner";

    /* renamed from: k  reason: collision with root package name */
    static final long f17184k = 32;

    /* renamed from: l  reason: collision with root package name */
    static final long f17185l = 40;

    /* renamed from: m  reason: collision with root package name */
    static final int f17186m = 4;

    /* renamed from: a  reason: collision with root package name */
    private final e f17188a;

    /* renamed from: b  reason: collision with root package name */
    private final j f17189b;

    /* renamed from: c  reason: collision with root package name */
    private final c f17190c;

    /* renamed from: d  reason: collision with root package name */
    private final C0173a f17191d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<d> f17192e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f17193f;

    /* renamed from: g  reason: collision with root package name */
    private long f17194g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17195h;

    /* renamed from: j  reason: collision with root package name */
    private static final C0173a f17183j = new C0173a();

    /* renamed from: n  reason: collision with root package name */
    static final long f17187n = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BitmapPreFillRunner.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.prefill.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class C0173a {
        C0173a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BitmapPreFillRunner.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b implements com.bumptech.glide.load.c {
        b() {
        }

        @Override // com.bumptech.glide.load.c
        public void b(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, f17183j, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        return this.f17189b.getMaxSize() - this.f17189b.getCurrentSize();
    }

    private long d() {
        long j4 = this.f17194g;
        this.f17194g = Math.min(4 * j4, f17187n);
        return j4;
    }

    private boolean e(long j4) {
        return this.f17191d.a() - j4 >= 32;
    }

    @VisibleForTesting
    boolean a() {
        Bitmap createBitmap;
        long a4 = this.f17191d.a();
        while (!this.f17190c.b() && !e(a4)) {
            d c4 = this.f17190c.c();
            if (!this.f17192e.contains(c4)) {
                this.f17192e.add(c4);
                createBitmap = this.f17188a.f(c4.d(), c4.b(), c4.a());
            } else {
                createBitmap = Bitmap.createBitmap(c4.d(), c4.b(), c4.a());
            }
            int h4 = k.h(createBitmap);
            if (c() >= h4) {
                this.f17189b.d(new b(), f.d(createBitmap, this.f17188a));
            } else {
                this.f17188a.d(createBitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + c4.d() + "x" + c4.b() + "] " + c4.a() + " size: " + h4);
            }
        }
        return (this.f17195h || this.f17190c.b()) ? false : true;
    }

    public void b() {
        this.f17195h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f17193f.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    a(e eVar, j jVar, c cVar, C0173a c0173a, Handler handler) {
        this.f17192e = new HashSet();
        this.f17194g = 40L;
        this.f17188a = eVar;
        this.f17189b = jVar;
        this.f17190c = cVar;
        this.f17191d = c0173a;
        this.f17193f = handler;
    }
}
