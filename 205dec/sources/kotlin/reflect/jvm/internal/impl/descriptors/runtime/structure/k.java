package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectJavaArrayType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k extends z implements m2.f {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Type f56596b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final z f56597c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Collection<m2.a> f56598d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f56599e;

    public k(@NotNull Type reflectType) {
        z a4;
        List F;
        f0.p(reflectType, "reflectType");
        this.f56596b = reflectType;
        Type P = P();
        if (!(P instanceof GenericArrayType)) {
            if (P instanceof Class) {
                Class cls = (Class) P;
                if (cls.isArray()) {
                    z.a aVar = z.f56622a;
                    Class<?> componentType = cls.getComponentType();
                    f0.o(componentType, "getComponentType()");
                    a4 = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + P().getClass() + "): " + P());
        }
        z.a aVar2 = z.f56622a;
        Type genericComponentType = ((GenericArrayType) P).getGenericComponentType();
        f0.o(genericComponentType, "genericComponentType");
        a4 = aVar2.a(genericComponentType);
        this.f56597c = a4;
        F = CollectionsKt__CollectionsKt.F();
        this.f56598d = F;
    }

    @Override // m2.d
    public boolean B() {
        return this.f56599e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    @NotNull
    protected Type P() {
        return this.f56596b;
    }

    @Override // m2.f
    @NotNull
    /* renamed from: Q */
    public z l() {
        return this.f56597c;
    }

    @Override // m2.d
    @NotNull
    public Collection<m2.a> getAnnotations() {
        return this.f56598d;
    }
}
