package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.C3541a;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.engine.cache.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: f */
    private static final String f13636f = "DiskLruCacheWrapper";

    /* renamed from: g */
    private static final int f13637g = 1;

    /* renamed from: h */
    private static final int f13638h = 1;

    /* renamed from: i */
    private static DiskLruCacheWrapper f13639i;

    /* renamed from: b */
    private final File f13641b;

    /* renamed from: c */
    private final long f13642c;

    /* renamed from: e */
    private C3541a f13644e;

    /* renamed from: d */
    private final DiskCacheWriteLocker f13643d = new DiskCacheWriteLocker();

    /* renamed from: a */
    private final SafeKeyGenerator f13640a = new SafeKeyGenerator();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.f13641b = file;
        this.f13642c = j;
    }

    /* renamed from: c */
    public static DiskCache m45330c(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    /* renamed from: d */
    public static synchronized DiskCache m45329d(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (f13639i == null) {
                f13639i = new DiskLruCacheWrapper(file, j);
            }
            diskLruCacheWrapper = f13639i;
        }
        return diskLruCacheWrapper;
    }

    /* renamed from: e */
    private synchronized C3541a m45328e() throws IOException {
        if (this.f13644e == null) {
            this.f13644e = C3541a.m45720B(this.f13641b, 1, 1, this.f13642c);
        }
        return this.f13644e;
    }

    /* renamed from: f */
    private synchronized void m45327f() {
        this.f13644e = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    /* renamed from: a */
    public void mo45332a(Key key, DiskCache.InterfaceC3593b interfaceC3593b) {
        C3541a m45328e;
        String m45299b = this.f13640a.m45299b(key);
        this.f13643d.m45336a(m45299b);
        try {
            if (Log.isLoggable(f13636f, 2)) {
                Log.v(f13636f, "Put: Obtained: " + m45299b + " for for Key: " + key);
            }
            try {
                m45328e = m45328e();
            } catch (IOException e) {
                if (Log.isLoggable(f13636f, 5)) {
                    Log.w(f13636f, "Unable to put to disk cache", e);
                }
            }
            if (m45328e.m45695p(m45299b) != null) {
                return;
            }
            C3541a.C3544c m45697n = m45328e.m45697n(m45299b);
            if (m45697n != null) {
                try {
                    if (interfaceC3593b.mo45296a(m45697n.m45686f(0))) {
                        m45697n.m45687e();
                    }
                    m45697n.m45690b();
                    return;
                } catch (Throwable th) {
                    m45697n.m45690b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + m45299b);
        } finally {
            this.f13643d.m45335b(m45299b);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    /* renamed from: b */
    public File mo45331b(Key key) {
        String m45299b = this.f13640a.m45299b(key);
        if (Log.isLoggable(f13636f, 2)) {
            Log.v(f13636f, "Get: Obtained: " + m45299b + " for for Key: " + key);
        }
        try {
            C3541a.C3546e m45695p = m45328e().m45695p(m45299b);
            if (m45695p != null) {
                return m45695p.m45667b(0);
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable(f13636f, 5)) {
                Log.w(f13636f, "Unable to get from disk cache", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            m45328e().delete();
        } catch (IOException e) {
            if (Log.isLoggable(f13636f, 5)) {
                Log.w(f13636f, "Unable to clear disk cache or disk cache cleared externally", e);
            }
        }
        m45327f();
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            m45328e().m45715G(this.f13640a.m45299b(key));
        } catch (IOException e) {
            if (Log.isLoggable(f13636f, 5)) {
                Log.w(f13636f, "Unable to delete from disk cache", e);
            }
        }
    }
}
