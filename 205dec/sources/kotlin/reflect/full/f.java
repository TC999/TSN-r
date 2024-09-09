package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.p;
import kotlin.reflect.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperties.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0007\u001a1\u0010\u0006\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/reflect/p;", "", "a", "D", "Lkotlin/reflect/q;", "receiver", "b", "(Lkotlin/reflect/q;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KProperties")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Object a(@NotNull p<?, ?> pVar) {
        f0.p(pVar, "<this>");
        return pVar.getDelegate(s.f58640k.a());
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <D> Object b(@NotNull q<D, ?, ?> qVar, D d4) {
        f0.p(qVar, "<this>");
        return qVar.getDelegate(d4, s.f58640k.a());
    }
}
