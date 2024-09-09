package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import m2.y;
import org.jetbrains.annotations.NotNull;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m extends kotlin.reflect.jvm.internal.impl.descriptors.impl.b {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56912k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final y f56913l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull y javaTypeParameter, int i4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration) {
        super(c4.e(), containingDeclaration, new kotlin.reflect.jvm.internal.impl.load.java.lazy.e(c4, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), Variance.INVARIANT, false, i4, v0.f56634a, c4.a().v());
        f0.p(c4, "c");
        f0.p(javaTypeParameter, "javaTypeParameter");
        f0.p(containingDeclaration, "containingDeclaration");
        this.f56912k = c4;
        this.f56913l = javaTypeParameter;
    }

    private final List<e0> H0() {
        int Z;
        List<e0> l4;
        Collection<m2.j> upperBounds = this.f56913l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            m0 i4 = this.f56912k.d().k().i();
            f0.o(i4, "c.module.builtIns.anyType");
            m0 I = this.f56912k.d().k().I();
            f0.o(I, "c.module.builtIns.nullableAnyType");
            l4 = x.l(kotlin.reflect.jvm.internal.impl.types.f0.d(i4, I));
            return l4;
        }
        Z = kotlin.collections.y.Z(upperBounds, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (m2.j jVar : upperBounds) {
            arrayList.add(this.f56912k.g().o(jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.d(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    @NotNull
    protected List<e0> C0(@NotNull List<? extends e0> bounds) {
        f0.p(bounds, "bounds");
        return this.f56912k.a().r().g(this, bounds, this.f56912k);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected void F0(@NotNull e0 type) {
        f0.p(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    @NotNull
    protected List<e0> G0() {
        return H0();
    }
}
