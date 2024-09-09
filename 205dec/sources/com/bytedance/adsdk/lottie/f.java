package com.bytedance.adsdk.lottie;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f25593a;

    /* renamed from: b  reason: collision with root package name */
    private int f25594b;

    /* renamed from: c  reason: collision with root package name */
    private int f25595c;

    /* renamed from: d  reason: collision with root package name */
    private int f25596d;

    /* renamed from: e  reason: collision with root package name */
    private int f25597e;

    /* renamed from: f  reason: collision with root package name */
    private int f25598f;

    /* renamed from: g  reason: collision with root package name */
    private int f25599g;

    /* renamed from: h  reason: collision with root package name */
    private int f25600h;

    public f(int i4) {
        if (i4 > 0) {
            this.f25595c = i4;
            this.f25593a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int g(K k4, V v3) {
        int e4 = e(k4, v3);
        if (e4 >= 0) {
            return e4;
        }
        throw new IllegalStateException("Negative size: " + k4 + "=" + v3);
    }

    public final V a(K k4) {
        V put;
        if (k4 != null) {
            synchronized (this) {
                V v3 = this.f25593a.get(k4);
                if (v3 != null) {
                    this.f25599g++;
                    return v3;
                }
                this.f25600h++;
                V f4 = f(k4);
                if (f4 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f25597e++;
                    put = this.f25593a.put(k4, f4);
                    if (put != null) {
                        this.f25593a.put(k4, put);
                    } else {
                        this.f25594b += g(k4, f4);
                    }
                }
                if (put != null) {
                    d(false, k4, f4, put);
                    return put;
                }
                c(this.f25595c);
                return f4;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V b(K k4, V v3) {
        V put;
        if (k4 != null && v3 != null) {
            synchronized (this) {
                this.f25596d++;
                this.f25594b += g(k4, v3);
                put = this.f25593a.put(k4, v3);
                if (put != null) {
                    this.f25594b -= g(k4, put);
                }
            }
            if (put != null) {
                d(false, k4, put, v3);
            }
            c(this.f25595c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f25594b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f25593a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f25594b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f25594b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f25593a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f25593a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f25593a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f25594b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.g(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f25594b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f25598f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f25598f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.d(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            goto L75
        L74:
            throw r5
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.f.c(int):void");
    }

    protected void d(boolean z3, K k4, V v3, V v4) {
    }

    protected int e(K k4, V v3) {
        return 1;
    }

    protected V f(K k4) {
        return null;
    }

    public final synchronized String toString() {
        int i4;
        int i5;
        i4 = this.f25599g;
        i5 = this.f25600h + i4;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f25595c), Integer.valueOf(this.f25599g), Integer.valueOf(this.f25600h), Integer.valueOf(i5 != 0 ? (i4 * 100) / i5 : 0));
    }
}
