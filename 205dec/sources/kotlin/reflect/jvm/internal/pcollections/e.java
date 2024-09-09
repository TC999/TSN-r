package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

/* compiled from: MapEntry.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class e<K, V> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final K f58628a;

    /* renamed from: b  reason: collision with root package name */
    public final V f58629b;

    public e(K k4, V v3) {
        this.f58628a = k4;
        this.f58629b = v3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            K k4 = this.f58628a;
            if (k4 == null) {
                if (eVar.f58628a != null) {
                    return false;
                }
            } else if (!k4.equals(eVar.f58628a)) {
                return false;
            }
            V v3 = this.f58629b;
            V v4 = eVar.f58629b;
            if (v3 == null) {
                if (v4 != null) {
                    return false;
                }
            } else if (!v3.equals(v4)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        K k4 = this.f58628a;
        int hashCode = k4 == null ? 0 : k4.hashCode();
        V v3 = this.f58629b;
        return hashCode ^ (v3 != null ? v3.hashCode() : 0);
    }

    public String toString() {
        return this.f58628a + "=" + this.f58629b;
    }
}
