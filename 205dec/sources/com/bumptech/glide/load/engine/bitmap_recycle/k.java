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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LruBitmapPool.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k implements e {

    /* renamed from: k  reason: collision with root package name */
    private static final String f16905k = "LruBitmapPool";

    /* renamed from: l  reason: collision with root package name */
    private static final Bitmap.Config f16906l = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final l f16907a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f16908b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16909c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16910d;

    /* renamed from: e  reason: collision with root package name */
    private long f16911e;

    /* renamed from: f  reason: collision with root package name */
    private long f16912f;

    /* renamed from: g  reason: collision with root package name */
    private int f16913g;

    /* renamed from: h  reason: collision with root package name */
    private int f16914h;

    /* renamed from: i  reason: collision with root package name */
    private int f16915i;

    /* renamed from: j  reason: collision with root package name */
    private int f16916j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap bitmap) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Bitmap> f16917a = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap bitmap) {
            if (this.f16917a.contains(bitmap)) {
                this.f16917a.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap bitmap) {
            if (!this.f16917a.contains(bitmap)) {
                this.f16917a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    k(long j4, l lVar, Set<Bitmap.Config> set) {
        this.f16909c = j4;
        this.f16911e = j4;
        this.f16907a = lVar;
        this.f16908b = set;
        this.f16910d = new b();
    }

    @TargetApi(26)
    private static void g(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap h(int i4, int i5, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f16906l;
        }
        return Bitmap.createBitmap(i4, i5, config);
    }

    private void i() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            j();
        }
    }

    private void j() {
        Log.v("LruBitmapPool", "Hits=" + this.f16913g + ", misses=" + this.f16914h + ", puts=" + this.f16915i + ", evictions=" + this.f16916j + ", currentSize=" + this.f16912f + ", maxSize=" + this.f16911e + "\nStrategy=" + this.f16907a);
    }

    private void k() {
        q(this.f16911e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> l() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 19) {
            hashSet.add(null);
        }
        if (i4 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l m() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new o();
        }
        return new com.bumptech.glide.load.engine.bitmap_recycle.c();
    }

    @Nullable
    private synchronized Bitmap n(int i4, int i5, @Nullable Bitmap.Config config) {
        Bitmap e4;
        g(config);
        e4 = this.f16907a.e(i4, i5, config != null ? config : f16906l);
        if (e4 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f16907a.b(i4, i5, config));
            }
            this.f16914h++;
        } else {
            this.f16913g++;
            this.f16912f -= this.f16907a.c(e4);
            this.f16910d.a(e4);
            p(e4);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f16907a.b(i4, i5, config));
        }
        i();
        return e4;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j4) {
        while (this.f16912f > j4) {
            Bitmap removeLast = this.f16907a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    j();
                }
                this.f16912f = 0L;
                return;
            }
            this.f16910d.a(removeLast);
            this.f16912f -= this.f16907a.c(removeLast);
            this.f16916j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f16907a.a(removeLast));
            }
            i();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @SuppressLint({"InlinedApi"})
    public void a(int i4) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i4);
        }
        if (i4 >= 40) {
            b();
        } else if (i4 >= 20 || i4 == 15) {
            q(getMaxSize() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void c(float f4) {
        this.f16911e = Math.round(((float) this.f16909c) * f4);
        k();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void d(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f16907a.c(bitmap) <= this.f16911e && this.f16908b.contains(bitmap.getConfig())) {
                        int c4 = this.f16907a.c(bitmap);
                        this.f16907a.d(bitmap);
                        this.f16910d.b(bitmap);
                        this.f16915i++;
                        this.f16912f += c4;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f16907a.a(bitmap));
                        }
                        i();
                        k();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f16907a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f16908b.contains(bitmap.getConfig()));
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

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap e(int i4, int i5, Bitmap.Config config) {
        Bitmap n4 = n(i4, i5, config);
        if (n4 != null) {
            n4.eraseColor(0);
            return n4;
        }
        return h(i4, i5, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap f(int i4, int i5, Bitmap.Config config) {
        Bitmap n4 = n(i4, i5, config);
        return n4 == null ? h(i4, i5, config) : n4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public long getMaxSize() {
        return this.f16911e;
    }

    public k(long j4) {
        this(j4, m(), l());
    }

    public k(long j4, Set<Bitmap.Config> set) {
        this(j4, m(), set);
    }
}
