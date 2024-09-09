package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaPackage.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w extends p implements m2.u {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56617a;

    public w(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        this.f56617a = fqName;
    }

    @Override // m2.d
    public boolean B() {
        return false;
    }

    @Override // m2.u
    @NotNull
    public Collection<m2.g> L(@NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List F;
        f0.p(nameFilter, "nameFilter");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // m2.d
    @NotNull
    /* renamed from: P */
    public List<m2.a> getAnnotations() {
        List<m2.a> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // m2.d
    @Nullable
    public m2.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return null;
    }

    @Override // m2.u
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return this.f56617a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof w) && f0.g(e(), ((w) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    @NotNull
    public String toString() {
        return w.class.getName() + ": " + e();
    }

    @Override // m2.u
    @NotNull
    public Collection<m2.u> u() {
        List F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }
}
