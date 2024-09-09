package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletionHandler.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0007\u001a\u00020\u0005*#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0080\b\":\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\u00020\b8\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\":\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\u00020\f8\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "c", "Lkotlinx/coroutines/f0;", "b", "(Lkotlinx/coroutines/f0;)Ld2/l;", "asHandler", "Lkotlinx/coroutines/n;", "a", "(Lkotlinx/coroutines/n;)Ld2/l;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g0 {
    @NotNull
    public static final d2.l<Throwable, kotlin.f1> a(@NotNull n nVar) {
        return nVar;
    }

    @NotNull
    public static final d2.l<Throwable, kotlin.f1> b(@NotNull f0 f0Var) {
        return f0Var;
    }

    public static final void c(@NotNull d2.l<? super Throwable, kotlin.f1> lVar, @Nullable Throwable th) {
        lVar.invoke(th);
    }
}
