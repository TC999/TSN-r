package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.a;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e implements a {

    /* renamed from: f  reason: collision with root package name */
    private static final String f16959f = "DiskLruCacheWrapper";

    /* renamed from: g  reason: collision with root package name */
    private static final int f16960g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16961h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static e f16962i;

    /* renamed from: b  reason: collision with root package name */
    private final File f16964b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16965c;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.disklrucache.a f16967e;

    /* renamed from: d  reason: collision with root package name */
    private final c f16966d = new c();

    /* renamed from: a  reason: collision with root package name */
    private final m f16963a = new m();

    @Deprecated
    protected e(File file, long j4) {
        this.f16964b = file;
        this.f16965c = j4;
    }

    public static a c(File file, long j4) {
        return new e(file, j4);
    }

    @Deprecated
    public static synchronized a d(File file, long j4) {
        e eVar;
        synchronized (e.class) {
            if (f16962i == null) {
                f16962i = new e(file, j4);
            }
            eVar = f16962i;
        }
        return eVar;
    }

    private synchronized com.bumptech.glide.disklrucache.a e() throws IOException {
        if (this.f16967e == null) {
            this.f16967e = com.bumptech.glide.disklrucache.a.B(this.f16964b, 1, 1, this.f16965c);
        }
        return this.f16967e;
    }

    private synchronized void f() {
        this.f16967e = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void a(com.bumptech.glide.load.c cVar, a.b bVar) {
        com.bumptech.glide.disklrucache.a e4;
        String b4 = this.f16963a.b(cVar);
        this.f16966d.a(b4);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b4 + " for for Key: " + cVar);
            }
            try {
                e4 = e();
            } catch (IOException e5) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e5);
                }
            }
            if (e4.p(b4) != null) {
                return;
            }
            a.c n4 = e4.n(b4);
            if (n4 != null) {
                try {
                    if (bVar.a(n4.f(0))) {
                        n4.e();
                    }
                    n4.b();
                    return;
                } catch (Throwable th) {
                    n4.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b4);
        } finally {
            this.f16966d.b(b4);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public File b(com.bumptech.glide.load.c cVar) {
        String b4 = this.f16963a.b(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b4 + " for for Key: " + cVar);
        }
        try {
            a.e p3 = e().p(b4);
            if (p3 != null) {
                return p3.b(0);
            }
            return null;
        } catch (IOException e4) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e4);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public synchronized void clear() {
        try {
            e().delete();
        } catch (IOException e4) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e4);
            }
        }
        f();
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void delete(com.bumptech.glide.load.c cVar) {
        try {
            e().G(this.f16963a.b(cVar));
        } catch (IOException e4) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e4);
            }
        }
    }
}
