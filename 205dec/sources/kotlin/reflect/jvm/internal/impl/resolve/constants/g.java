package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f57830a;

    public g(T t3) {
        this.f57830a = t3;
    }

    public T a() {
        return this.f57830a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            T a4 = a();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!f0.g(a4, gVar != null ? gVar.a() : null)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public abstract e0 getType(@NotNull d0 d0Var);

    public int hashCode() {
        T a4 = a();
        if (a4 == null) {
            return 0;
        }
        return a4.hashCode();
    }

    @NotNull
    public String toString() {
        return String.valueOf(a());
    }
}
