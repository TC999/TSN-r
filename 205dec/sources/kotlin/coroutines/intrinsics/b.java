package kotlin.coroutines.intrinsics;

import d2.l;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.coroutines.c;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Intrinsics.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001aD\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\b\u0004\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0087H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u000b\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "j", "(Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "()Ljava/lang/Object;", "getCOROUTINE_SUSPENDED$annotations", "()V", "COROUTINE_SUSPENDED", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b extends IntrinsicsKt__IntrinsicsJvmKt {
    @NotNull
    public static Object h() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void i() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object j(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        throw new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
