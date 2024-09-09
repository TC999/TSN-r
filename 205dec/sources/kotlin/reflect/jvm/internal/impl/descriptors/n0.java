package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeParameterUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final g f56523a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.types.a1> f56524b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final n0 f56525c;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(@NotNull g classifierDescriptor, @NotNull List<? extends kotlin.reflect.jvm.internal.impl.types.a1> arguments, @Nullable n0 n0Var) {
        kotlin.jvm.internal.f0.p(classifierDescriptor, "classifierDescriptor");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        this.f56523a = classifierDescriptor;
        this.f56524b = arguments;
        this.f56525c = n0Var;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.types.a1> a() {
        return this.f56524b;
    }

    @NotNull
    public final g b() {
        return this.f56523a;
    }

    @Nullable
    public final n0 c() {
        return this.f56525c;
    }
}
