package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: TypeProjectionBase.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b1 implements a1 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a1) {
            a1 a1Var = (a1) obj;
            return b() == a1Var.b() && c() == a1Var.c() && getType().equals(a1Var.getType());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = c().hashCode();
        if (h1.w(getType())) {
            return (hashCode * 31) + 19;
        }
        return (hashCode * 31) + (b() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (b()) {
            return "*";
        }
        if (c() == Variance.INVARIANT) {
            return getType().toString();
        }
        return c() + " " + getType();
    }
}
