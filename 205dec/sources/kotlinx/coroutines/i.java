package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Builders.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"T", "Lkotlin/coroutines/f;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlin/coroutines/f;Ld2/p;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class i {
    public static final <T> T a(@NotNull kotlin.coroutines.f fVar, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) throws InterruptedException {
        m1 a4;
        kotlin.coroutines.f d4;
        Thread currentThread = Thread.currentThread();
        kotlin.coroutines.d dVar = (kotlin.coroutines.d) fVar.get(kotlin.coroutines.d.f55503f0);
        if (dVar == null) {
            a4 = k3.f60465b.b();
            d4 = k0.d(w1.f60756a, fVar.plus(a4));
        } else {
            if (!(dVar instanceof m1)) {
                dVar = null;
            }
            m1 m1Var = (m1) dVar;
            if (m1Var != null) {
                m1 m1Var2 = m1Var.J() ? m1Var : null;
                if (m1Var2 != null) {
                    a4 = m1Var2;
                    d4 = k0.d(w1.f60756a, fVar);
                }
            }
            a4 = k3.f60465b.a();
            d4 = k0.d(w1.f60756a, fVar);
        }
        f fVar2 = new f(d4, currentThread, a4);
        fVar2.r1(CoroutineStart.DEFAULT, fVar2, pVar);
        return (T) fVar2.s1();
    }

    public static /* synthetic */ Object b(kotlin.coroutines.f fVar, d2.p pVar, int i4, Object obj) throws InterruptedException {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        return h.g(fVar, pVar);
    }
}
