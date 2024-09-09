package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LruCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f18070a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f18071b;

    /* renamed from: c  reason: collision with root package name */
    private long f18072c;

    /* renamed from: d  reason: collision with root package name */
    private long f18073d;

    public g(long j4) {
        this.f18071b = j4;
        this.f18072c = j4;
    }

    private void h() {
        o(this.f18072c);
    }

    public void b() {
        o(0L);
    }

    public synchronized void c(float f4) {
        if (f4 >= 0.0f) {
            this.f18072c = Math.round(((float) this.f18071b) * f4);
            h();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized boolean g(@NonNull T t3) {
        return this.f18070a.containsKey(t3);
    }

    public synchronized long getCurrentSize() {
        return this.f18073d;
    }

    public synchronized long getMaxSize() {
        return this.f18072c;
    }

    @Nullable
    public synchronized Y i(@NonNull T t3) {
        return this.f18070a.get(t3);
    }

    protected synchronized int j() {
        return this.f18070a.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k(@Nullable Y y3) {
        return 1;
    }

    protected void l(@NonNull T t3, @Nullable Y y3) {
    }

    @Nullable
    public synchronized Y m(@NonNull T t3, @Nullable Y y3) {
        long k4 = k(y3);
        if (k4 >= this.f18072c) {
            l(t3, y3);
            return null;
        }
        if (y3 != null) {
            this.f18073d += k4;
        }
        Y put = this.f18070a.put(t3, y3);
        if (put != null) {
            this.f18073d -= k(put);
            if (!put.equals(y3)) {
                l(t3, put);
            }
        }
        h();
        return put;
    }

    @Nullable
    public synchronized Y n(@NonNull T t3) {
        Y remove;
        remove = this.f18070a.remove(t3);
        if (remove != null) {
            this.f18073d -= k(remove);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void o(long j4) {
        while (this.f18073d > j4) {
            Iterator<Map.Entry<T, Y>> it = this.f18070a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f18073d -= k(value);
            T key = next.getKey();
            it.remove();
            l(key, value);
        }
    }
}
