package kotlin.sequences;

import cn.jpush.android.api.InAppSlotParams;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SequenceBuilder.kt */
@SinceKotlin(version = "1.3")
@RestrictsSuspension
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lkotlin/sequences/o;", "T", "", "value", "Lkotlin/f1;", "e", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "iterator", "g", "(Ljava/util/Iterator;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "elements", "f", "(Ljava/lang/Iterable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "h", "(Lkotlin/sequences/m;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class o<T> {
    @Nullable
    public abstract Object e(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Nullable
    public final Object f(@NotNull Iterable<? extends T> iterable, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return f1.f55527a;
        }
        Object g4 = g(iterable.iterator(), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return g4 == h4 ? g4 : f1.f55527a;
    }

    @Nullable
    public abstract Object g(@NotNull Iterator<? extends T> it, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Nullable
    public final Object h(@NotNull m<? extends T> mVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object g4 = g(mVar.iterator(), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return g4 == h4 ? g4 : f1.f55527a;
    }
}
