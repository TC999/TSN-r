package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConcurrentLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ao\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u000228\u0010\b\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00018\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00000\u0004H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0019\u001a\u00020\u00148\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/g0;", "S", "", "id", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/h0;", "d", "(Lkotlinx/coroutines/internal/g0;JLd2/p;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/g;", "N", "c", "(Lkotlinx/coroutines/internal/g;)Lkotlinx/coroutines/internal/g;", "", "a", "I", "POINTERS_SHIFT", "Lkotlinx/coroutines/internal/j0;", "b", "Lkotlinx/coroutines/internal/j0;", "getCLOSED$annotations", "()V", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {

    /* renamed from: a */
    private static final int f60355a = 16;

    /* renamed from: b */
    private static final j0 f60356b = new j0("CLOSED");

    public static final /* synthetic */ j0 b() {
        return f60356b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.g] */
    @NotNull
    public static final <N extends g<N>> N c(@NotNull N n4) {
        while (true) {
            Object e4 = n4.e();
            if (e4 == f60356b) {
                return n4;
            }
            ?? r02 = (g) e4;
            if (r02 != 0) {
                n4 = r02;
            } else if (n4.j()) {
                return n4;
            }
        }
    }

    public static final <S extends g0<S>> Object d(S s3, long j4, d2.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s3.o() >= j4 && !s3.g()) {
                return h0.b(s3);
            }
            Object e4 = s3.e();
            if (e4 == f60356b) {
                return h0.b(f60356b);
            }
            S s4 = (S) ((g) e4);
            if (s4 == null) {
                s4 = pVar.invoke(Long.valueOf(s3.o() + 1), s3);
                if (s3.m(s4)) {
                    if (s3.g()) {
                        s3.l();
                    }
                }
            }
            s3 = s4;
        }
    }

    private static /* synthetic */ void e() {
    }
}
