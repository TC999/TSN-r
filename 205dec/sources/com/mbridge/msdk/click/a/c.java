package com.mbridge.msdk.click.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* compiled from: WaitRetryLruMemoryCache.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements com.mbridge.msdk.foundation.same.a.c<String, b> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, b> f38835a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38836b;

    /* renamed from: c  reason: collision with root package name */
    private int f38837c;

    public c(int i4) {
        if (i4 > 0) {
            this.f38836b = i4;
            this.f38835a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f38836b));
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final void a(String str) {
        if (str != null) {
            synchronized (this) {
                if (this.f38835a.remove(str) != null) {
                    this.f38837c--;
                }
            }
            return;
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final b b(String str) {
        if (str != null) {
            synchronized (this) {
                b bVar = this.f38835a.get(str);
                if (bVar != null) {
                    return bVar;
                }
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final void b() {
        a(-1);
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final boolean a(String str, b bVar) {
        if (str != null && bVar != null) {
            synchronized (this) {
                this.f38837c++;
                if (this.f38835a.put(str, bVar) != null) {
                    this.f38837c--;
                }
            }
            a(this.f38836b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
        throw new java.lang.IllegalStateException(com.mbridge.msdk.click.a.c.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r3) {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            int r0 = r2.f38837c     // Catch: java.lang.Throwable -> L6a
            if (r0 < 0) goto L4d
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f38835a     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L11
            int r0 = r2.f38837c     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L4d
        L11:
            int r0 = r2.f38837c     // Catch: java.lang.Throwable -> L6a
            if (r0 <= r3) goto L4b
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f38835a     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L1e
            goto L4b
        L1e:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f38835a     // Catch: java.lang.Throwable -> L6a
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6a
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L32
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            goto L4c
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6a
            com.mbridge.msdk.click.a.b r0 = (com.mbridge.msdk.click.a.b) r0     // Catch: java.lang.Throwable -> L6a
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f38835a     // Catch: java.lang.Throwable -> L49
            r0.remove(r1)     // Catch: java.lang.Throwable -> L49
            int r0 = r2.f38837c     // Catch: java.lang.Throwable -> L49
            int r0 = r0 + (-1)
            r2.f38837c = r0     // Catch: java.lang.Throwable -> L49
        L49:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            goto L0
        L4b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
        L4c:
            return
        L4d:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r0.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.Class<com.mbridge.msdk.click.a.c> r1 = com.mbridge.msdk.click.a.c.class
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6a
            r0.append(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L6a
            throw r3     // Catch: java.lang.Throwable -> L6a
        L6a:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            goto L6e
        L6d:
            throw r3
        L6e:
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.c.a(int):void");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f38835a.keySet());
        }
        return hashSet;
    }
}
