package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f25304a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f25305b;

    public b(V v3) {
        this.f25304a = v3;
        this.f25305b = null;
    }

    public V a() {
        return this.f25304a;
    }

    public Throwable b() {
        return this.f25305b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (a() == null || !a().equals(bVar.a())) {
                if (b() == null || bVar.b() == null) {
                    return false;
                }
                return b().toString().equals(b().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }

    public b(Throwable th) {
        this.f25305b = th;
        this.f25304a = null;
    }
}
