package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001aQ\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001aW\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\tH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aH\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e*\u00020\u00142)\b\b\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\tH\u0086J\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\"\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/e2;", "e", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/CoroutineStart;Ld2/p;)Lkotlinx/coroutines/e2;", "T", "Lkotlinx/coroutines/x0;", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/CoroutineStart;Ld2/p;)Lkotlinx/coroutines/x0;", "g", "(Lkotlin/coroutines/f;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/l0;", "c", "(Lkotlinx/coroutines/l0;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "I", "UNDECIDED", "b", "SUSPENDED", "RESUMED", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class j {

    /* renamed from: a */
    private static final int f60453a = 0;

    /* renamed from: b */
    private static final int f60454b = 1;

    /* renamed from: c */
    private static final int f60455c = 2;

    @NotNull
    public static final <T> x0<T> a(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, @NotNull CoroutineStart coroutineStart, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        y0 y0Var;
        kotlin.coroutines.f d4 = k0.d(q0Var, fVar);
        if (coroutineStart.isLazy()) {
            y0Var = new n2(d4, pVar);
        } else {
            y0Var = new y0(d4, true);
        }
        ((a) y0Var).r1(coroutineStart, y0Var, pVar);
        return y0Var;
    }

    public static /* synthetic */ x0 b(q0 q0Var, kotlin.coroutines.f fVar, CoroutineStart coroutineStart, d2.p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i4 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.a(q0Var, fVar, coroutineStart, pVar);
    }

    @Nullable
    public static final <T> Object c(@NotNull l0 l0Var, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return h.i(l0Var, pVar, cVar);
    }

    @Nullable
    private static final Object d(@NotNull l0 l0Var, @NotNull d2.p pVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(0);
        Object i4 = h.i(l0Var, pVar, cVar);
        kotlin.jvm.internal.c0.e(1);
        return i4;
    }

    @NotNull
    public static final e2 e(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, @NotNull CoroutineStart coroutineStart, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super kotlin.f1>, ? extends Object> pVar) {
        a e3Var;
        kotlin.coroutines.f d4 = k0.d(q0Var, fVar);
        if (coroutineStart.isLazy()) {
            e3Var = new o2(d4, pVar);
        } else {
            e3Var = new e3(d4, true);
        }
        e3Var.r1(coroutineStart, e3Var, pVar);
        return e3Var;
    }

    public static /* synthetic */ e2 f(q0 q0Var, kotlin.coroutines.f fVar, CoroutineStart coroutineStart, d2.p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i4 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.e(q0Var, fVar, coroutineStart, pVar);
    }

    @Nullable
    public static final <T> Object g(@NotNull kotlin.coroutines.f fVar, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        Object t12;
        Object h4;
        kotlin.coroutines.f context = cVar.getContext();
        kotlin.coroutines.f plus = context.plus(fVar);
        v3.a(plus);
        if (plus == context) {
            kotlinx.coroutines.internal.f0 f0Var = new kotlinx.coroutines.internal.f0(plus, cVar);
            t12 = z2.b.f(f0Var, f0Var, pVar);
        } else {
            d.b bVar = kotlin.coroutines.d.f55503f0;
            if (kotlin.jvm.internal.f0.g((kotlin.coroutines.d) plus.get(bVar), (kotlin.coroutines.d) context.get(bVar))) {
                t3 t3Var = new t3(plus, cVar);
                Object c4 = kotlinx.coroutines.internal.o0.c(plus, null);
                try {
                    Object f4 = z2.b.f(t3Var, t3Var, pVar);
                    kotlinx.coroutines.internal.o0.a(plus, c4);
                    t12 = f4;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.o0.a(plus, c4);
                    throw th;
                }
            } else {
                b1 b1Var = new b1(plus, cVar);
                b1Var.m1();
                z2.a.e(pVar, b1Var, b1Var, null, 4, null);
                t12 = b1Var.t1();
            }
        }
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (t12 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return t12;
    }
}
