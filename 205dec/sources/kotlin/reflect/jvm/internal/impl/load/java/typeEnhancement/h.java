package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final n f57046a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<n> f57047b;

    public h() {
        this(null, null, 3, null);
    }

    public h(@Nullable n nVar, @NotNull List<n> parametersInfo) {
        f0.p(parametersInfo, "parametersInfo");
        this.f57046a = nVar;
        this.f57047b = parametersInfo;
    }

    @NotNull
    public final List<n> a() {
        return this.f57047b;
    }

    @Nullable
    public final n b() {
        return this.f57046a;
    }

    public /* synthetic */ h(n nVar, List list, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : nVar, (i4 & 2) != 0 ? CollectionsKt__CollectionsKt.F() : list);
    }
}
