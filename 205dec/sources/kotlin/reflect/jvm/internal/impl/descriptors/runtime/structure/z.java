package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.f0;
import m2.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class z implements m2.x {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56622a = new a(null);

    /* compiled from: ReflectJavaType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final z a(@NotNull Type type) {
            z kVar;
            f0.p(type, "type");
            boolean z3 = type instanceof Class;
            if (z3) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new x(cls);
                }
            }
            if (!(type instanceof GenericArrayType) && (!z3 || !((Class) type).isArray())) {
                kVar = type instanceof WildcardType ? new c0((WildcardType) type) : new n(type);
            } else {
                kVar = new k(type);
            }
            return kVar;
        }
    }

    @NotNull
    protected abstract Type P();

    @Override // m2.d
    @Nullable
    public m2.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return x.a.a(this, cVar);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof z) && f0.g(P(), ((z) obj).P());
    }

    public int hashCode() {
        return P().hashCode();
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + P();
    }
}
