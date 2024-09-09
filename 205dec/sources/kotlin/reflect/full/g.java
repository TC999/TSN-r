package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.r;
import org.jetbrains.annotations.NotNull;

/* compiled from: KTypes.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0014\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007\u00a8\u0006\u0007"}, d2 = {"Lkotlin/reflect/r;", "", "nullable", "c", "other", "a", "b", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KTypes")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @SinceKotlin(version = "1.1")
    public static final boolean a(@NotNull r rVar, @NotNull r other) {
        f0.p(rVar, "<this>");
        f0.p(other, "other");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.m(((u) rVar).getType(), ((u) other).getType());
    }

    @SinceKotlin(version = "1.1")
    public static final boolean b(@NotNull r rVar, @NotNull r other) {
        f0.p(rVar, "<this>");
        f0.p(other, "other");
        return a(other, rVar);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final r c(@NotNull r rVar, boolean z3) {
        f0.p(rVar, "<this>");
        return ((u) rVar).h(z3);
    }
}
