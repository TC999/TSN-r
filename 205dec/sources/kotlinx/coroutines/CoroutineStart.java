package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineStart.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JE\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ^\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00022'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "completion", "Lkotlin/f1;", "invoke", "(Ld2/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    @InternalCoroutinesApi
    public final <T> void invoke(@NotNull d2.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        int i4 = s0.f60552a[ordinal()];
        if (i4 == 1) {
            z2.a.b(lVar, cVar);
        } else if (i4 == 2) {
            kotlin.coroutines.e.h(lVar, cVar);
        } else if (i4 == 3) {
            z2.b.a(lVar, cVar);
        } else if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull d2.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, R r3, @NotNull kotlin.coroutines.c<? super T> cVar) {
        int i4 = s0.f60553b[ordinal()];
        if (i4 == 1) {
            z2.a.e(pVar, r3, cVar, null, 4, null);
        } else if (i4 == 2) {
            kotlin.coroutines.e.i(pVar, r3, cVar);
        } else if (i4 == 3) {
            z2.b.b(pVar, r3, cVar);
        } else if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
