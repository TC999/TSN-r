package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaPrimitiveType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x extends z implements m2.v {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f56618b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Collection<m2.a> f56619c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f56620d;

    public x(@NotNull Class<?> reflectType) {
        List F;
        f0.p(reflectType, "reflectType");
        this.f56618b = reflectType;
        F = CollectionsKt__CollectionsKt.F();
        this.f56619c = F;
    }

    @Override // m2.d
    public boolean B() {
        return this.f56620d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    @NotNull
    /* renamed from: Q */
    public Class<?> P() {
        return this.f56618b;
    }

    @Override // m2.d
    @NotNull
    public Collection<m2.a> getAnnotations() {
        return this.f56619c;
    }

    @Override // m2.v
    @Nullable
    public PrimitiveType getType() {
        if (f0.g(P(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(P().getName()).getPrimitiveType();
    }
}
