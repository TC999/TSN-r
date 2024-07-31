package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: k */
    private static final String f13582k = "LruBitmapPool";

    /* renamed from: l */
    private static final Bitmap.Config f13583l = Bitmap.Config.ARGB_8888;

    /* renamed from: a */
    private final LruPoolStrategy f13584a;

    /* renamed from: b */
    private final Set<Bitmap.Config> f13585b;

    /* renamed from: c */
    private final long f13586c;

    /* renamed from: d */
    private final InterfaceC3584a f13587d;

    /* renamed from: e */
    private long f13588e;

    /* renamed from: f */
    private long f13589f;

    /* renamed from: g */
    private int f13590g;

    /* renamed from: h */
    private int f13591h;

    /* renamed from: i */
    private int f13592i;

    /* renamed from: j */
    private int f13593j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3584a {
        /* renamed from: a */
        void mo45360a(Bitmap bitmap);

        /* renamed from: b */
        void mo45359b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.k$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3585b implements InterfaceC3584a {
        C3585b() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.InterfaceC3584a
        /* renamed from: a */
        public void mo45360a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.InterfaceC3584a
        /* renamed from: b */
        public void mo45359b(Bitmap bitmap) {
        }
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.k$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3586c implements InterfaceC3584a {

        /* renamed from: a */
        private final Set<Bitmap> f13594a = Collections.synchronizedSet(new HashSet());

        private C3586c() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.InterfaceC3584a
        /* renamed from: a */
        public void mo45360a(Bitmap bitmap) {
            if (this.f13594a.contains(bitmap)) {
                this.f13594a.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.InterfaceC3584a
        /* renamed from: b */
        public void mo45359b(Bitmap bitmap) {
            if (!this.f13594a.contains(bitmap)) {
                this.f13594a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.f13586c = j;
        this.f13588e = j;
        this.f13584a = lruPoolStrategy;
        this.f13585b = set;
        this.f13587d = new C3585b();
    }

    @TargetApi(26)
    /* renamed from: g */
    private static void m45371g(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    /* renamed from: h */
    private static Bitmap m45370h(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f13583l;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    /* renamed from: i */
    private void m45369i() {
        if (Log.isLoggable(f13582k, 2)) {
            m45368j();
        }
    }

    /* renamed from: j */
    private void m45368j() {
        Log.v(f13582k, "Hits=" + this.f13590g + ", misses=" + this.f13591h + ", puts=" + this.f13592i + ", evictions=" + this.f13593j + ", currentSize=" + this.f13589f + ", maxSize=" + this.f13588e + "\nStrategy=" + this.f13584a);
    }

    /* renamed from: k */
    private void m45367k() {
        m45361q(this.f13588e);
    }

    @TargetApi(26)
    /* renamed from: l */
    private static Set<Bitmap.Config> m45366l() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            hashSet.add(null);
        }
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: m */
    private static LruPoolStrategy m45365m() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }

    @Nullable
    /* renamed from: n */
    private synchronized Bitmap m45364n(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap mo45346e;
        m45371g(config);
        mo45346e = this.f13584a.mo45346e(i, i2, config != null ? config : f13583l);
        if (mo45346e == null) {
            if (Log.isLoggable(f13582k, 3)) {
                Log.d(f13582k, "Missing bitmap=" + this.f13584a.mo45349b(i, i2, config));
            }
            this.f13591h++;
        } else {
            this.f13590g++;
            this.f13589f -= this.f13584a.mo45348c(mo45346e);
            this.f13587d.mo45360a(mo45346e);
            m45362p(mo45346e);
        }
        if (Log.isLoggable(f13582k, 2)) {
            Log.v(f13582k, "Get bitmap=" + this.f13584a.mo45349b(i, i2, config));
        }
        m45369i();
        return mo45346e;
    }

    @TargetApi(19)
    /* renamed from: o */
    private static void m45363o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    /* renamed from: p */
    private static void m45362p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m45363o(bitmap);
    }

    /* renamed from: q */
    private synchronized void m45361q(long j) {
        while (this.f13589f > j) {
            Bitmap removeLast = this.f13584a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(f13582k, 5)) {
                    Log.w(f13582k, "Size mismatch, resetting");
                    m45368j();
                }
                this.f13589f = 0L;
                return;
            }
            this.f13587d.mo45360a(removeLast);
            this.f13589f -= this.f13584a.mo45348c(removeLast);
            this.f13593j++;
            if (Log.isLoggable(f13582k, 3)) {
                Log.d(f13582k, "Evicting bitmap=" + this.f13584a.mo45350a(removeLast));
            }
            m45369i();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo45376a(int i) {
        if (Log.isLoggable(f13582k, 3)) {
            Log.d(f13582k, "trimMemory, level=" + i);
        }
        if (i >= 40) {
            mo45375b();
        } else if (i >= 20 || i == 15) {
            m45361q(getMaxSize() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: b */
    public void mo45375b() {
        if (Log.isLoggable(f13582k, 3)) {
            Log.d(f13582k, "clearMemory");
        }
        m45361q(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: c */
    public synchronized void mo45374c(float f) {
        this.f13588e = Math.round(((float) this.f13586c) * f);
        m45367k();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: d */
    public synchronized void mo44924d(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f13584a.mo45348c(bitmap) <= this.f13588e && this.f13585b.contains(bitmap.getConfig())) {
                        int mo45348c = this.f13584a.mo45348c(bitmap);
                        this.f13584a.mo45347d(bitmap);
                        this.f13587d.mo45359b(bitmap);
                        this.f13592i++;
                        this.f13589f += mo45348c;
                        if (Log.isLoggable(f13582k, 2)) {
                            Log.v(f13582k, "Put bitmap in pool=" + this.f13584a.mo45350a(bitmap));
                        }
                        m45369i();
                        m45367k();
                        return;
                    }
                    if (Log.isLoggable(f13582k, 2)) {
                        Log.v(f13582k, "Reject bitmap from pool, bitmap: " + this.f13584a.mo45350a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f13585b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    /* renamed from: e */
    public Bitmap mo45373e(int i, int i2, Bitmap.Config config) {
        Bitmap m45364n = m45364n(i, i2, config);
        if (m45364n != null) {
            m45364n.eraseColor(0);
            return m45364n;
        }
        return m45370h(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    /* renamed from: f */
    public Bitmap mo45372f(int i, int i2, Bitmap.Config config) {
        Bitmap m45364n = m45364n(i, i2, config);
        return m45364n == null ? m45370h(i, i2, config) : m45364n;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.f13588e;
    }

    public LruBitmapPool(long j) {
        this(j, m45365m(), m45366l());
    }

    public LruBitmapPool(long j, Set<Bitmap.Config> set) {
        this(j, m45365m(), set);
    }
}
