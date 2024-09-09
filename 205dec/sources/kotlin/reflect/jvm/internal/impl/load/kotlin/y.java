package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y implements x<k> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final y f57263a = new y();

    private y() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @Nullable
    public String b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return x.a.a(this, dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @Nullable
    public String c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        f0.p(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @Nullable
    public e0 d(@NotNull e0 e0Var) {
        return x.a.b(this, e0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    public void e(@NotNull e0 kotlinType, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor) {
        f0.p(kotlinType, "kotlinType");
        f0.p(descriptor, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @NotNull
    public e0 f(@NotNull Collection<? extends e0> types) {
        String X2;
        f0.p(types, "types");
        X2 = kotlin.collections.f0.X2(types, null, null, null, 0, null, null, 63, null);
        throw new AssertionError(f0.C("There should be no intersection type in existing descriptors, but found: ", X2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @Nullable
    /* renamed from: g */
    public k a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        f0.p(classDescriptor, "classDescriptor");
        return null;
    }
}
