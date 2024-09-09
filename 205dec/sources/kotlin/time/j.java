package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.time.n;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: measureTime.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\b\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\b\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006\r"}, d2 = {"Lkotlin/Function0;", "Lkotlin/f1;", "block", "Lkotlin/time/d;", "a", "(Ld2/a;)J", "Lkotlin/time/n;", "b", "(Lkotlin/time/n;Ld2/a;)J", "T", "Lkotlin/time/p;", "c", "d", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long a(@NotNull d2.a<f1> block) {
        f0.p(block, "block");
        m a4 = n.b.f59010c.a();
        block.invoke();
        return a4.a();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long b(@NotNull n nVar, @NotNull d2.a<f1> block) {
        f0.p(nVar, "<this>");
        f0.p(block, "block");
        m a4 = nVar.a();
        block.invoke();
        return a4.a();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    public static final <T> p<T> c(@NotNull d2.a<? extends T> block) {
        f0.p(block, "block");
        return new p<>(block.invoke(), n.b.f59010c.a().a(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    public static final <T> p<T> d(@NotNull n nVar, @NotNull d2.a<? extends T> block) {
        f0.p(nVar, "<this>");
        f0.p(block, "block");
        return new p<>(block.invoke(), nVar.a().a(), null);
    }
}
