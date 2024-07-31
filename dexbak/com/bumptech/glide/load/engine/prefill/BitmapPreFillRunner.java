package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.C3771k;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.prefill.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BitmapPreFillRunner implements Runnable {
    @VisibleForTesting

    /* renamed from: i */
    static final String f13865i = "PreFillRunner";

    /* renamed from: k */
    static final long f13867k = 32;

    /* renamed from: l */
    static final long f13868l = 40;

    /* renamed from: m */
    static final int f13869m = 4;

    /* renamed from: a */
    private final BitmapPool f13871a;

    /* renamed from: b */
    private final MemoryCache f13872b;

    /* renamed from: c */
    private final PreFillQueue f13873c;

    /* renamed from: d */
    private final C3643a f13874d;

    /* renamed from: e */
    private final Set<PreFillType> f13875e;

    /* renamed from: f */
    private final Handler f13876f;

    /* renamed from: g */
    private long f13877g;

    /* renamed from: h */
    private boolean f13878h;

    /* renamed from: j */
    private static final C3643a f13866j = new C3643a();

    /* renamed from: n */
    static final long f13870n = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapPreFillRunner.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.prefill.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3643a {
        C3643a() {
        }

        /* renamed from: a */
        long m45161a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BitmapPreFillRunner.java */
    /* renamed from: com.bumptech.glide.load.engine.prefill.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3644b implements Key {
        C3644b() {
        }

        @Override // com.bumptech.glide.load.Key
        /* renamed from: b */
        public void mo44432b(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, f13866j, new Handler(Looper.getMainLooper()));
    }

    /* renamed from: c */
    private long m45164c() {
        return this.f13872b.getMaxSize() - this.f13872b.getCurrentSize();
    }

    /* renamed from: d */
    private long m45163d() {
        long j = this.f13877g;
        this.f13877g = Math.min(4 * j, f13870n);
        return j;
    }

    /* renamed from: e */
    private boolean m45162e(long j) {
        return this.f13874d.m45161a() - j >= 32;
    }

    @VisibleForTesting
    /* renamed from: a */
    boolean m45166a() {
        Bitmap createBitmap;
        long m45161a = this.f13874d.m45161a();
        while (!this.f13873c.m45156b() && !m45162e(m45161a)) {
            PreFillType m45155c = this.f13873c.m45155c();
            if (!this.f13875e.contains(m45155c)) {
                this.f13875e.add(m45155c);
                createBitmap = this.f13871a.mo45372f(m45155c.m45151d(), m45155c.m45153b(), m45155c.m45154a());
            } else {
                createBitmap = Bitmap.createBitmap(m45155c.m45151d(), m45155c.m45153b(), m45155c.m45154a());
            }
            int m44383h = C3771k.m44383h(createBitmap);
            if (m45164c() >= m44383h) {
                this.f13872b.mo45319d(new C3644b(), BitmapResource.m44977d(createBitmap, this.f13871a));
            } else {
                this.f13871a.mo44924d(createBitmap);
            }
            if (Log.isLoggable(f13865i, 3)) {
                Log.d(f13865i, "allocated [" + m45155c.m45151d() + "x" + m45155c.m45153b() + "] " + m45155c.m45154a() + " size: " + m44383h);
            }
        }
        return (this.f13878h || this.f13873c.m45156b()) ? false : true;
    }

    /* renamed from: b */
    public void m45165b() {
        this.f13878h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m45166a()) {
            this.f13876f.postDelayed(this, m45163d());
        }
    }

    @VisibleForTesting
    BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, C3643a c3643a, Handler handler) {
        this.f13875e = new HashSet();
        this.f13877g = f13868l;
        this.f13871a = bitmapPool;
        this.f13872b = memoryCache;
        this.f13873c = preFillQueue;
        this.f13874d = c3643a;
        this.f13876f = handler;
    }
}
