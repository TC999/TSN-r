package kotlinx.coroutines.selects;

import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.internal.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001aG\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\u0002\b\u000bH\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\r\u0010\u000e\" \u0010\u0015\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\" \u0010\u0019\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012\"\u001a\u0010\u001c\u001a\u00020\u00068\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u0012\u0004\b\u001b\u0010\u0014\"\u001a\u0010\u001e\u001a\u00020\u00068\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u0012\u0004\b\u001d\u0010\u0014\"\u001a\u0010#\u001a\u00020\u001f8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u0012\u0004\b\"\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"R", "Lkotlinx/coroutines/selects/a;", "Lkotlin/time/d;", "timeout", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "k", "(Lkotlinx/coroutines/selects/a;DLd2/l;)V", "Lkotlin/ExtensionFunctionType;", "builder", "l", "(Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "getNOT_SELECTED$annotations", "()V", "NOT_SELECTED", "b", "d", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "c", "getUNDECIDED$annotations", "UNDECIDED", "getRESUMED$annotations", "RESUMED", "Lkotlinx/coroutines/selects/i;", "e", "Lkotlinx/coroutines/selects/i;", "getSelectOpSequenceNumber$annotations", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: a */
    private static final Object f60642a = new j0("NOT_SELECTED");
    @NotNull

    /* renamed from: b */
    private static final Object f60643b = new j0("ALREADY_SELECTED");

    /* renamed from: c */
    private static final Object f60644c = new j0("UNDECIDED");

    /* renamed from: d */
    private static final Object f60645d = new j0("RESUMED");

    /* renamed from: e */
    private static final i f60646e = new i();

    public static final /* synthetic */ Object a() {
        return f60645d;
    }

    public static final /* synthetic */ i b() {
        return f60646e;
    }

    public static final /* synthetic */ Object c() {
        return f60644c;
    }

    @NotNull
    public static final Object d() {
        return f60643b;
    }

    public static /* synthetic */ void e() {
    }

    @NotNull
    public static final Object f() {
        return f60642a;
    }

    public static /* synthetic */ void g() {
    }

    private static /* synthetic */ void h() {
    }

    private static /* synthetic */ void i() {
    }

    private static /* synthetic */ void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalTime
    @ExperimentalCoroutinesApi
    public static final <R> void k(@NotNull a<? super R> aVar, double d4, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        aVar.c(a1.e(d4), lVar);
    }

    @Nullable
    public static final <R> Object l(@NotNull l<? super a<? super R>, f1> lVar, @NotNull kotlin.coroutines.c<? super R> cVar) {
        Object h4;
        b bVar = new b(cVar);
        try {
            lVar.invoke(bVar);
        } catch (Throwable th) {
            bVar.p0(th);
        }
        Object o02 = bVar.o0();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (o02 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return o02;
    }

    @Nullable
    private static final Object m(@NotNull l lVar, @NotNull kotlin.coroutines.c cVar) {
        Object h4;
        c0.e(0);
        b bVar = new b(cVar);
        try {
            lVar.invoke(bVar);
        } catch (Throwable th) {
            bVar.p0(th);
        }
        Object o02 = bVar.o0();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (o02 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        c0.e(1);
        return o02;
    }
}
