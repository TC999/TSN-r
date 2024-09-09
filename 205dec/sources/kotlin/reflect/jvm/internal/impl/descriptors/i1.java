package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Visibility.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class i1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f56290a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f56291b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i1(@NotNull String name, boolean z3) {
        kotlin.jvm.internal.f0.p(name, "name");
        this.f56290a = name;
        this.f56291b = z3;
    }

    @Nullable
    public Integer a(@NotNull i1 visibility) {
        kotlin.jvm.internal.f0.p(visibility, "visibility");
        return h1.f56275a.a(this, visibility);
    }

    @NotNull
    public String b() {
        return this.f56290a;
    }

    public final boolean c() {
        return this.f56291b;
    }

    @NotNull
    public i1 d() {
        return this;
    }

    @NotNull
    public final String toString() {
        return b();
    }
}
