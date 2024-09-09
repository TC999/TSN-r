package com.bytedance.adsdk.lottie.xv;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    T f25757a;

    /* renamed from: b  reason: collision with root package name */
    T f25758b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t3, T t4) {
        this.f25757a = t3;
        this.f25758b = t4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return b(pair.first, this.f25757a) && b(pair.second, this.f25758b);
        }
        return false;
    }

    public int hashCode() {
        T t3 = this.f25757a;
        int hashCode = t3 == null ? 0 : t3.hashCode();
        T t4 = this.f25758b;
        return hashCode ^ (t4 != null ? t4.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f25757a + " " + this.f25758b + "}";
    }
}
