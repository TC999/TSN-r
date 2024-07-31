package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* renamed from: com.bumptech.glide.util.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3769g<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f14552a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f14553b;

    /* renamed from: c */
    private long f14554c;

    /* renamed from: d */
    private long f14555d;

    public C3769g(long j) {
        this.f14553b = j;
        this.f14554c = j;
    }

    /* renamed from: h */
    private void m44407h() {
        m44400o(this.f14554c);
    }

    /* renamed from: b */
    public void m44410b() {
        m44400o(0L);
    }

    /* renamed from: c */
    public synchronized void m44409c(float f) {
        if (f >= 0.0f) {
            this.f14554c = Math.round(((float) this.f14553b) * f);
            m44407h();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    /* renamed from: g */
    public synchronized boolean m44408g(@NonNull T t) {
        return this.f14552a.containsKey(t);
    }

    public synchronized long getCurrentSize() {
        return this.f14555d;
    }

    public synchronized long getMaxSize() {
        return this.f14554c;
    }

    @Nullable
    /* renamed from: i */
    public synchronized Y m44406i(@NonNull T t) {
        return this.f14552a.get(t);
    }

    /* renamed from: j */
    protected synchronized int m44405j() {
        return this.f14552a.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public int mo44404k(@Nullable Y y) {
        return 1;
    }

    /* renamed from: l */
    protected void mo44403l(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    /* renamed from: m */
    public synchronized Y m44402m(@NonNull T t, @Nullable Y y) {
        long mo44404k = mo44404k(y);
        if (mo44404k >= this.f14554c) {
            mo44403l(t, y);
            return null;
        }
        if (y != null) {
            this.f14555d += mo44404k;
        }
        Y put = this.f14552a.put(t, y);
        if (put != null) {
            this.f14555d -= mo44404k(put);
            if (!put.equals(y)) {
                mo44403l(t, put);
            }
        }
        m44407h();
        return put;
    }

    @Nullable
    /* renamed from: n */
    public synchronized Y m44401n(@NonNull T t) {
        Y remove;
        remove = this.f14552a.remove(t);
        if (remove != null) {
            this.f14555d -= mo44404k(remove);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public synchronized void m44400o(long j) {
        while (this.f14555d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f14552a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f14555d -= mo44404k(value);
            T key = next.getKey();
            it.remove();
            mo44403l(key, value);
        }
    }
}
