package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaTypeParameter.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 extends p implements h, m2.y {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TypeVariable<?> f56567a;

    public a0(@NotNull TypeVariable<?> typeVariable) {
        f0.p(typeVariable, "typeVariable");
        this.f56567a = typeVariable;
    }

    @Override // m2.d
    public boolean B() {
        return h.a.c(this);
    }

    @Override // m2.d
    @Nullable
    /* renamed from: P */
    public e b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // m2.d
    @NotNull
    /* renamed from: Q */
    public List<e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // m2.y
    @NotNull
    /* renamed from: R */
    public List<n> getUpperBounds() {
        Object V4;
        List<n> F;
        Type[] bounds = this.f56567a.getBounds();
        f0.o(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        int length = bounds.length;
        int i4 = 0;
        while (i4 < length) {
            Type type = bounds[i4];
            i4++;
            arrayList.add(new n(type));
        }
        V4 = kotlin.collections.f0.V4(arrayList);
        n nVar = (n) V4;
        if (f0.g(nVar == null ? null : nVar.P(), Object.class)) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof a0) && f0.g(this.f56567a, ((a0) obj).f56567a);
    }

    @Override // m2.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(this.f56567a.getName());
        f0.o(f4, "identifier(typeVariable.name)");
        return f4;
    }

    public int hashCode() {
        return this.f56567a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h
    @Nullable
    public AnnotatedElement r() {
        TypeVariable<?> typeVariable = this.f56567a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @NotNull
    public String toString() {
        return a0.class.getName() + ": " + this.f56567a;
    }
}
