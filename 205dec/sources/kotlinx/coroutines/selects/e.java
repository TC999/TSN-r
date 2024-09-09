package kotlinx.coroutines.selects;

import d2.p;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003JR\u0010\f\u001a\u00020\u000b\"\u0004\b\u0002\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bH'\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/selects/e;", "P", "Q", "", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "Lkotlin/f1;", "D", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface e<P, Q> {
    @InternalCoroutinesApi
    <R> void D(@NotNull f<? super R> fVar, P p3, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);
}
