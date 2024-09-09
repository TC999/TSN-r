package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, d> f57084a;

    public n(@NotNull Map<Integer, d> map) {
        f0.p(map, "map");
        this.f57084a = map;
    }

    @NotNull
    public final Map<Integer, d> a() {
        return this.f57084a;
    }
}
