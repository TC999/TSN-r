package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: RuntimeErrorReporter.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements p {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final j f56556b = new j();

    private j() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.p
    public void a(@NotNull CallableMemberDescriptor descriptor) {
        f0.p(descriptor, "descriptor");
        throw new IllegalStateException(f0.C("Cannot infer visibility for ", descriptor));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.p
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor, @NotNull List<String> unresolvedSuperClasses) {
        f0.p(descriptor, "descriptor");
        f0.p(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }
}
