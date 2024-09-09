package com.bytedance.sdk.component.ux.xv.c;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv<K, V> {

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashMap<K, SoftReference<V>> f30290c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f30291f;

    /* renamed from: r  reason: collision with root package name */
    private int f30292r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f30293w;
    private int xv;

    public xv(int i4) {
        if (i4 > 0) {
            this.xv = i4;
            this.f30290c = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int xv(K k4, V v3) {
        int w3 = w(k4, v3);
        if (w3 >= 0) {
            return w3;
        }
        throw new IllegalStateException("Negative size: " + k4 + "=" + v3);
    }

    public final V c(K k4) {
        V v3;
        if (k4 != null) {
            synchronized (this) {
                SoftReference<V> softReference = this.f30290c.get(k4);
                if (softReference != null) {
                    v3 = softReference.get();
                    if (v3 != null) {
                        this.f30292r++;
                        return v3;
                    }
                    this.f30290c.remove(k4);
                } else {
                    v3 = null;
                }
                this.ev++;
                V w3 = w(k4);
                if (w3 == null) {
                    return null;
                }
                synchronized (this) {
                    this.ux++;
                    SoftReference<V> put = this.f30290c.put(k4, new SoftReference<>(w3));
                    if (put != null) {
                        v3 = put.get();
                    }
                    if (v3 != null) {
                        this.f30290c.put(k4, put);
                    } else {
                        this.f30293w += xv(k4, w3);
                    }
                }
                if (v3 != null) {
                    c(false, k4, w3, v3);
                    return v3;
                }
                c(this.xv);
                return w3;
            }
        }
        throw new NullPointerException("key == null");
    }

    protected void c(boolean z3, K k4, V v3, V v4) {
    }

    public final synchronized String toString() {
        int i4;
        int i5;
        i4 = this.f30292r;
        i5 = this.ev + i4;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.xv), Integer.valueOf(this.f30292r), Integer.valueOf(this.ev), Integer.valueOf(i5 != 0 ? (i4 * 100) / i5 : 0));
    }

    protected int w(K k4, V v3) {
        return 1;
    }

    protected V w(K k4) {
        return null;
    }

    public final V c(K k4, V v3) {
        if (k4 != null && v3 != null) {
            V v4 = null;
            synchronized (this) {
                this.sr++;
                this.f30293w += xv(k4, v3);
                SoftReference<V> put = this.f30290c.put(k4, new SoftReference<>(v3));
                if (put != null && (v4 = put.get()) != null) {
                    this.f30293w -= xv(k4, v4);
                }
            }
            if (v4 != null) {
                c(false, k4, v4, v3);
            }
            c(this.xv);
            return v4;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r5.f30293w + ", maxSize: " + r6);
        r5.f30293w = 0;
        r5.f30290c.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r6) {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            int r0 = r5.f30293w     // Catch: java.lang.Throwable -> L82
            if (r0 < 0) goto L58
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r5.f30290c     // Catch: java.lang.Throwable -> L82
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L12
            int r0 = r5.f30293w     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L12
            goto L58
        L12:
            int r0 = r5.f30293w     // Catch: java.lang.Throwable -> L82
            if (r0 > r6) goto L18
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            goto L81
        L18:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r5.f30290c     // Catch: java.lang.Throwable -> L82
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L82
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L82
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L2c
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            goto L81
        L2c:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L82
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L82
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r5.f30290c     // Catch: java.lang.Throwable -> L82
            r2.remove(r1)     // Catch: java.lang.Throwable -> L82
            r2 = 0
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L82
            int r3 = r5.f30293w     // Catch: java.lang.Throwable -> L82
            int r4 = r5.xv(r1, r0)     // Catch: java.lang.Throwable -> L82
            int r3 = r3 - r4
            r5.f30293w = r3     // Catch: java.lang.Throwable -> L82
            goto L4d
        L4c:
            r0 = r2
        L4d:
            int r3 = r5.f30291f     // Catch: java.lang.Throwable -> L82
            r4 = 1
            int r3 = r3 + r4
            r5.f30291f = r3     // Catch: java.lang.Throwable -> L82
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            r5.c(r4, r1, r0, r2)
            goto L0
        L58:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r1.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            int r2 = r5.f30293w     // Catch: java.lang.Throwable -> L82
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            r1.append(r6)     // Catch: java.lang.Throwable -> L82
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r0, r6)     // Catch: java.lang.Throwable -> L82
            r6 = 0
            r5.f30293w = r6     // Catch: java.lang.Throwable -> L82
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r6 = r5.f30290c     // Catch: java.lang.Throwable -> L82
            r6.clear()     // Catch: java.lang.Throwable -> L82
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
        L81:
            return
        L82:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            goto L86
        L85:
            throw r6
        L86:
            goto L85
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ux.xv.c.xv.c(int):void");
    }

    public final void c() {
        c(-1);
    }
}
