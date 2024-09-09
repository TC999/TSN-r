package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: ModuleCapability.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f56262a;

    public c0(@NotNull String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        this.f56262a = name;
    }

    @NotNull
    public String toString() {
        return this.f56262a;
    }
}
