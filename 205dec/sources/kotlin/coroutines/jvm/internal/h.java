package kotlin.coroutines.jvm.internal;

import d2.l;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RunSuspend.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a0\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "block", "a", "(Ld2/l;)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @SinceKotlin(version = "1.3")
    public static final void a(@NotNull l<? super kotlin.coroutines.c<? super f1>, ? extends Object> block) {
        f0.p(block, "block");
        g gVar = new g();
        kotlin.coroutines.e.h(block, gVar);
        gVar.b();
    }
}
