package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeserializedPackageFragment.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class n extends kotlin.reflect.jvm.internal.impl.descriptors.impl.z {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f58150g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d0 module) {
        super(module, fqName);
        f0.p(fqName, "fqName");
        f0.p(storageManager, "storageManager");
        f0.p(module, "module");
        this.f58150g = storageManager;
    }

    @NotNull
    public abstract f C0();

    public boolean F0(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h p3 = p();
        return (p3 instanceof DeserializedMemberScope) && ((DeserializedMemberScope) p3).s().contains(name);
    }

    public abstract void G0(@NotNull i iVar);
}
