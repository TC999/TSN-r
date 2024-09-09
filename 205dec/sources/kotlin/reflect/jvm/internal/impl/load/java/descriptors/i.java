package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: util.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e0 f56728a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f56729b;

    public i(@NotNull e0 type, boolean z3) {
        f0.p(type, "type");
        this.f56728a = type;
        this.f56729b = z3;
    }

    public final boolean a() {
        return this.f56729b;
    }

    @NotNull
    public final e0 getType() {
        return this.f56728a;
    }
}
