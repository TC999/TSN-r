package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaClassifierType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n extends z implements m2.j {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Type f56610b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final m2.i f56611c;

    public n(@NotNull Type reflectType) {
        m2.i lVar;
        f0.p(reflectType, "reflectType");
        this.f56610b = reflectType;
        Type P = P();
        if (P instanceof Class) {
            lVar = new l((Class) P);
        } else if (P instanceof TypeVariable) {
            lVar = new a0((TypeVariable) P);
        } else if (!(P instanceof ParameterizedType)) {
            throw new IllegalStateException("Not a classifier type (" + P.getClass() + "): " + P);
        } else {
            Type rawType = ((ParameterizedType) P).getRawType();
            if (rawType == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            lVar = new l((Class) rawType);
        }
        this.f56611c = lVar;
    }

    @Override // m2.d
    public boolean B() {
        return false;
    }

    @Override // m2.j
    @NotNull
    public String C() {
        return P().toString();
    }

    @Override // m2.j
    @NotNull
    public String E() {
        throw new UnsupportedOperationException(f0.C("Type not found: ", P()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    @NotNull
    public Type P() {
        return this.f56610b;
    }

    @Override // m2.j
    @NotNull
    public m2.i a() {
        return this.f56611c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z, m2.d
    @Nullable
    public m2.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return null;
    }

    @Override // m2.d
    @NotNull
    public Collection<m2.a> getAnnotations() {
        List F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // m2.j
    public boolean s() {
        Type P = P();
        if (P instanceof Class) {
            TypeVariable[] typeParameters = ((Class) P).getTypeParameters();
            f0.o(typeParameters, "getTypeParameters()");
            return (typeParameters.length == 0) ^ true;
        }
        return false;
    }

    @Override // m2.j
    @NotNull
    public List<m2.x> x() {
        int Z;
        List<Type> d4 = d.d(P());
        z.a aVar = z.f56622a;
        Z = kotlin.collections.y.Z(d4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (Type type : d4) {
            arrayList.add(aVar.a(type));
        }
        return arrayList;
    }
}
