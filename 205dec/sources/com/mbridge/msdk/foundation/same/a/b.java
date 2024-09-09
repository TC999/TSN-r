package com.mbridge.msdk.foundation.same.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* compiled from: LruReplaceTempCache.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements c<String, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, JSONObject> f39402a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39403b;

    /* renamed from: c  reason: collision with root package name */
    private int f39404c;

    public b(int i4) {
        if (i4 > 0) {
            this.f39403b = i4;
            this.f39402a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        if (str2 != null) {
            synchronized (this) {
                if (this.f39402a.remove(str2) != null) {
                    this.f39404c--;
                }
            }
            return;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f39403b));
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final void b() {
        a(-1);
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final JSONObject b(String str) {
        JSONObject jSONObject;
        if (str != null) {
            synchronized (this) {
                jSONObject = this.f39402a.get(str);
            }
            return jSONObject;
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final boolean a(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            synchronized (this) {
                this.f39404c++;
                if (this.f39402a.put(str, jSONObject) != null) {
                    this.f39404c--;
                }
            }
            a(this.f39403b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        throw new java.lang.IllegalStateException(com.mbridge.msdk.foundation.same.a.b.class.getName() + ".sizeOf() is reporting inconsistent results!");
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
            int r0 = r2.f39404c     // Catch: java.lang.Throwable -> L6d
            if (r0 < 0) goto L50
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f39402a     // Catch: java.lang.Throwable -> L6d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L11
            int r0 = r2.f39404c     // Catch: java.lang.Throwable -> L6d
            if (r0 != 0) goto L50
        L11:
            int r0 = r2.f39404c     // Catch: java.lang.Throwable -> L6d
            if (r0 <= r3) goto L4e
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f39402a     // Catch: java.lang.Throwable -> L6d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L1e
            goto L4e
        L1e:
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f39402a     // Catch: java.lang.Throwable -> L6d
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6d
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6d
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6d
            if (r0 != 0) goto L32
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6d
            goto L4f
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6d
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Throwable -> L6d
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f39402a     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L4c
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Throwable -> L4c
            int r0 = r2.f39404c     // Catch: java.lang.Throwable -> L4c
            int r0 = r0 + (-1)
            r2.f39404c = r0     // Catch: java.lang.Throwable -> L4c
        L4c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6d
            goto L0
        L4e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6d
        L4f:
            return
        L50:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r0.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.Class<com.mbridge.msdk.foundation.same.a.b> r1 = com.mbridge.msdk.foundation.same.a.b.class
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6d
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6d
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L6d
            throw r3     // Catch: java.lang.Throwable -> L6d
        L6d:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L70:
            throw r3
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.a.b.a(int):void");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f39402a.keySet());
        }
        return hashSet;
    }
}
