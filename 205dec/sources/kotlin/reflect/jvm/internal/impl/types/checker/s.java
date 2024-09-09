package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: utils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class s {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e0 f58306a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final s f58307b;

    public s(@NotNull e0 type, @Nullable s sVar) {
        f0.p(type, "type");
        this.f58306a = type;
        this.f58307b = sVar;
    }

    @Nullable
    public final s a() {
        return this.f58307b;
    }

    @NotNull
    public final e0 getType() {
        return this.f58306a;
    }
}
