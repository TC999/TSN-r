package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaWildcardType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0 extends z implements m2.c0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final WildcardType f56582b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Collection<m2.a> f56583c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f56584d;

    public c0(@NotNull WildcardType reflectType) {
        List F;
        f0.p(reflectType, "reflectType");
        this.f56582b = reflectType;
        F = CollectionsKt__CollectionsKt.F();
        this.f56583c = F;
    }

    @Override // m2.d
    public boolean B() {
        return this.f56584d;
    }

    @Override // m2.c0
    public boolean J() {
        Object Kb;
        Type[] upperBounds = P().getUpperBounds();
        f0.o(upperBounds, "reflectType.upperBounds");
        Kb = kotlin.collections.p.Kb(upperBounds);
        return !f0.g(Kb, Object.class);
    }

    @Override // m2.c0
    @Nullable
    /* renamed from: Q */
    public z getBound() {
        Object Cs;
        Object Cs2;
        Type[] upperBounds = P().getUpperBounds();
        Type[] lowerBounds = P().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                z.a aVar = z.f56622a;
                f0.o(lowerBounds, "lowerBounds");
                Cs2 = kotlin.collections.p.Cs(lowerBounds);
                f0.o(Cs2, "lowerBounds.single()");
                return aVar.a((Type) Cs2);
            } else if (upperBounds.length == 1) {
                f0.o(upperBounds, "upperBounds");
                Cs = kotlin.collections.p.Cs(upperBounds);
                Type ub = (Type) Cs;
                if (f0.g(ub, Object.class)) {
                    return null;
                }
                z.a aVar2 = z.f56622a;
                f0.o(ub, "ub");
                return aVar2.a(ub);
            } else {
                return null;
            }
        }
        throw new UnsupportedOperationException(f0.C("Wildcard types with many bounds are not yet supported: ", P()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    @NotNull
    /* renamed from: R */
    public WildcardType P() {
        return this.f56582b;
    }

    @Override // m2.d
    @NotNull
    public Collection<m2.a> getAnnotations() {
        return this.f56583c;
    }
}
