package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Await.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\b\u0004B\u001d\u0012\u0014\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/c;", "T", "", "", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/x0;", "a", "[Lkotlinx/coroutines/x0;", "deferreds", "<init>", "([Lkotlinx/coroutines/x0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c<T> {

    /* renamed from: b  reason: collision with root package name */
    static final AtomicIntegerFieldUpdater f59058b = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");

    /* renamed from: a  reason: collision with root package name */
    private final x0<T>[] f59059a;
    volatile int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Await.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R<\u0010\u001c\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00162\u0012\u0010\u0017\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/c$a;", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "h0", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/i1;", "e", "Lkotlinx/coroutines/i1;", "j0", "()Lkotlinx/coroutines/i1;", "l0", "(Lkotlinx/coroutines/i1;)V", "handle", "Lkotlinx/coroutines/o;", "", "f", "Lkotlinx/coroutines/o;", "continuation", "Lkotlinx/coroutines/c$b;", "Lkotlinx/coroutines/c;", "value", "i0", "()Lkotlinx/coroutines/c$b;", "k0", "(Lkotlinx/coroutines/c$b;)V", "disposer", "job", "<init>", "(Lkotlinx/coroutines/c;Lkotlinx/coroutines/o;Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends k2<e2> {
        private volatile Object _disposer;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public i1 f59060e;

        /* renamed from: f  reason: collision with root package name */
        private final o<List<? extends T>> f59061f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull o<? super List<? extends T>> oVar, @NotNull e2 e2Var) {
            super(e2Var);
            this.f59061f = oVar;
            this._disposer = null;
        }

        @Override // kotlinx.coroutines.f0
        public void h0(@Nullable Throwable th) {
            if (th != null) {
                Object o4 = this.f59061f.o(th);
                if (o4 != null) {
                    this.f59061f.S(o4);
                    c<T>.b i02 = i0();
                    if (i02 != null) {
                        i02.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (c.f59058b.decrementAndGet(c.this) == 0) {
                o<List<? extends T>> oVar = this.f59061f;
                x0[] x0VarArr = c.this.f59059a;
                ArrayList arrayList = new ArrayList(x0VarArr.length);
                for (x0 x0Var : x0VarArr) {
                    arrayList.add(x0Var.e());
                }
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(arrayList));
            }
        }

        @Nullable
        public final c<T>.b i0() {
            return (b) this._disposer;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
            h0(th);
            return kotlin.f1.f55527a;
        }

        @NotNull
        public final i1 j0() {
            i1 i1Var = this.f59060e;
            if (i1Var == null) {
                kotlin.jvm.internal.f0.S("handle");
            }
            return i1Var;
        }

        public final void k0(@Nullable c<T>.b bVar) {
            this._disposer = bVar;
        }

        public final void l0(@NotNull i1 i1Var) {
            this.f59060e = i1Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Await.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b0\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/c$b;", "Lkotlinx/coroutines/m;", "Lkotlin/f1;", "b", "", "cause", "a", "", "toString", "", "Lkotlinx/coroutines/c$a;", "Lkotlinx/coroutines/c;", "[Lkotlinx/coroutines/c$a;", "nodes", "<init>", "(Lkotlinx/coroutines/c;[Lkotlinx/coroutines/c$a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends m {

        /* renamed from: a  reason: collision with root package name */
        private final c<T>.a[] f59063a;

        public b(@NotNull c<T>.a[] aVarArr) {
            this.f59063a = aVarArr;
        }

        @Override // kotlinx.coroutines.n
        public void a(@Nullable Throwable th) {
            b();
        }

        public final void b() {
            for (c<T>.a aVar : this.f59063a) {
                aVar.j0().dispose();
            }
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
            a(th);
            return kotlin.f1.f55527a;
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f59063a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull x0<? extends T>[] x0VarArr) {
        this.f59059a = x0VarArr;
        this.notCompletedCount = x0VarArr.length;
    }

    @Nullable
    public final Object b(@NotNull kotlin.coroutines.c<? super List<? extends T>> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar = new p(d4, 1);
        pVar.H();
        int length = this.f59059a.length;
        a[] aVarArr = new a[length];
        for (int i4 = 0; i4 < length; i4++) {
            x0 x0Var = this.f59059a[kotlin.coroutines.jvm.internal.a.f(i4).intValue()];
            x0Var.start();
            a aVar = new a(pVar, x0Var);
            aVar.l0(x0Var.m(aVar));
            aVarArr[i4] = aVar;
        }
        c<T>.b bVar = new b(aVarArr);
        for (int i5 = 0; i5 < length; i5++) {
            aVarArr[i5].k0(bVar);
        }
        if (pVar.isCompleted()) {
            bVar.b();
        } else {
            pVar.B(bVar);
        }
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }
}
