package com.mbridge.msdk.foundation.same.p474a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* renamed from: com.mbridge.msdk.foundation.same.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class LruMemoryCache implements MemoryCacheAware<String, Bitmap> {

    /* renamed from: a */
    private final LinkedHashMap<String, Bitmap> f30604a;

    /* renamed from: b */
    private final int f30605b;

    /* renamed from: c */
    private int f30606c;

    public LruMemoryCache(int i) {
        if (i > 0) {
            this.f30605b = i;
            this.f30604a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    @Override // com.mbridge.msdk.foundation.same.p474a.MemoryCacheAware
    /* renamed from: a */
    public final /* synthetic */ void mo22380a(String str) {
        String str2 = str;
        if (str2 != null) {
            synchronized (this) {
                Bitmap remove = this.f30604a.remove(str2);
                if (remove != null) {
                    this.f30606c -= m22385b(str2, remove);
                }
            }
            return;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f30605b));
    }

    @Override // com.mbridge.msdk.foundation.same.p474a.MemoryCacheAware
    /* renamed from: b */
    public final void mo22378b() {
        m22388a(-1);
    }

    /* renamed from: b */
    private int m22385b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.mbridge.msdk.foundation.same.p474a.MemoryCacheAware
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Bitmap mo22377b(String str) {
        if (str != null) {
            synchronized (this) {
                Bitmap bitmap = this.f30604a.get(str);
                if (bitmap == null || bitmap.isRecycled()) {
                    return null;
                }
                return bitmap;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.mbridge.msdk.foundation.same.p474a.MemoryCacheAware
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo22379a(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            synchronized (this) {
                this.f30606c += m22385b(str, bitmap);
                Bitmap put = this.f30604a.put(str, bitmap);
                if (put != null) {
                    this.f30606c -= m22385b(str, put);
                }
            }
            m22388a(this.f30605b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        throw new java.lang.IllegalStateException(com.mbridge.msdk.foundation.same.p474a.LruMemoryCache.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m22388a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f30606c     // Catch: java.lang.Throwable -> L73
            if (r0 < 0) goto L56
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f30604a     // Catch: java.lang.Throwable -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L11
            int r0 = r3.f30606c     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L56
        L11:
            int r0 = r3.f30606c     // Catch: java.lang.Throwable -> L73
            if (r0 <= r4) goto L54
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f30604a     // Catch: java.lang.Throwable -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L1e
            goto L54
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f30604a     // Catch: java.lang.Throwable -> L73
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L73
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L73
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L32
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            goto L55
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L73
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L73
            int r0 = r3.m22385b(r1, r0)     // Catch: java.lang.Throwable -> L52
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f30604a     // Catch: java.lang.Throwable -> L52
            java.lang.Object r1 = r2.remove(r1)     // Catch: java.lang.Throwable -> L52
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch: java.lang.Throwable -> L52
            r1.recycle()     // Catch: java.lang.Throwable -> L52
            int r1 = r3.f30606c     // Catch: java.lang.Throwable -> L52
            int r1 = r1 - r0
            r3.f30606c = r1     // Catch: java.lang.Throwable -> L52
        L52:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            goto L0
        L54:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
        L55:
            return
        L56:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r0.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.Class<com.mbridge.msdk.foundation.same.a.a> r1 = com.mbridge.msdk.foundation.same.p474a.LruMemoryCache.class
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L73
            r0.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L73
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L73
            throw r4     // Catch: java.lang.Throwable -> L73
        L73:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            goto L77
        L76:
            throw r4
        L77:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.p474a.LruMemoryCache.m22388a(int):void");
    }

    @Override // com.mbridge.msdk.foundation.same.p474a.MemoryCacheAware
    /* renamed from: a */
    public final Collection<String> mo22381a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f30604a.keySet());
        }
        return hashSet;
    }
}
