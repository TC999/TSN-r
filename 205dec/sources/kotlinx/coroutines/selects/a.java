package kotlinx.coroutines.selects;

import d2.l;
import d2.p;
import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J5\u0010\b\u001a\u00020\u0007*\u00020\u00032\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u00a6\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJG\u0010\r\u001a\u00020\u0007\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00010\u000b2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u00a6\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ[\u0010\u0012\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u000f\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u00a6\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u0014\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u000f\"\u0004\b\u0002\u0010\n*\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00028\u00020\u00102\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J8\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H'\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/selects/a;", "R", "", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "block", "Lkotlin/f1;", "l", "(Lkotlinx/coroutines/selects/c;Ld2/l;)V", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", "j", "(Lkotlinx/coroutines/selects/d;Ld2/p;)V", "P", "Lkotlinx/coroutines/selects/e;", "param", "x", "(Lkotlinx/coroutines/selects/e;Ljava/lang/Object;Ld2/p;)V", "b", "(Lkotlinx/coroutines/selects/e;Ld2/p;)V", "", "timeMillis", "c", "(JLd2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a<R> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Select.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1221a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void a(@NotNull a<? super R> aVar, @NotNull e<? super P, ? extends Q> eVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            aVar.x(eVar, null, pVar);
        }
    }

    <P, Q> void b(@NotNull e<? super P, ? extends Q> eVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);

    @ExperimentalCoroutinesApi
    void c(long j4, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar);

    <Q> void j(@NotNull d<? extends Q> dVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);

    void l(@NotNull c cVar, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar);

    <P, Q> void x(@NotNull e<? super P, ? extends Q> eVar, P p3, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar);
}
