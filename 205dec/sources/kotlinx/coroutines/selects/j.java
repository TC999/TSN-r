package kotlinx.coroutines.selects;

import d2.l;
import d2.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.selects.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SelectUnbiased.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001J5\u0010\f\u001a\u00020\u0005*\u00020\b2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJG\u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u000f2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J[\u0010\u0016\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u000e*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R3\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050#`$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u001d\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lkotlinx/coroutines/selects/j;", "R", "Lkotlinx/coroutines/selects/a;", "", "e", "Lkotlin/f1;", "", "f", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "block", "l", "(Lkotlinx/coroutines/selects/c;Ld2/l;)V", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", "j", "(Lkotlinx/coroutines/selects/d;Ld2/p;)V", "P", "Lkotlinx/coroutines/selects/e;", "param", "x", "(Lkotlinx/coroutines/selects/e;Ljava/lang/Object;Ld2/p;)V", "", "timeMillis", "c", "(JLd2/l;)V", "Lkotlinx/coroutines/selects/b;", "a", "Lkotlinx/coroutines/selects/b;", "d", "()Lkotlinx/coroutines/selects/b;", "instance", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "clauses", "uCont", "<init>", "(Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j<R> implements kotlinx.coroutines.selects.a<R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlinx.coroutines.selects.b<R> f60648a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<d2.a<f1>> f60649b = new ArrayList<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SelectUnbiased.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.selects.c f60651b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f60652c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlinx.coroutines.selects.c cVar, l lVar) {
            super(0);
            this.f60651b = cVar;
            this.f60652c = lVar;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f60651b.N(j.this.d(), this.f60652c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SelectUnbiased.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Q", "R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.selects.d f60654b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p f60655c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlinx.coroutines.selects.d dVar, p pVar) {
            super(0);
            this.f60654b = dVar;
            this.f60655c = pVar;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f60654b.I(j.this.d(), this.f60655c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SelectUnbiased.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"P", "Q", "R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f60657b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f60658c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p f60659d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e eVar, Object obj, p pVar) {
            super(0);
            this.f60657b = eVar;
            this.f60658c = obj;
            this.f60659d = pVar;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f60657b.D(j.this.d(), this.f60658c, this.f60659d);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SelectUnbiased.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f60661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f60662c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j4, l lVar) {
            super(0);
            this.f60661b = j4;
            this.f60662c = lVar;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            j.this.d().c(this.f60661b, this.f60662c);
        }
    }

    public j(@NotNull kotlin.coroutines.c<? super R> cVar) {
        this.f60648a = new kotlinx.coroutines.selects.b<>(cVar);
    }

    @NotNull
    public final ArrayList<d2.a<f1>> a() {
        return this.f60649b;
    }

    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void b(@NotNull e<? super P, ? extends Q> eVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        a.C1221a.a(this, eVar, pVar);
    }

    @Override // kotlinx.coroutines.selects.a
    public void c(long j4, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        this.f60649b.add(new d(j4, lVar));
    }

    @NotNull
    public final kotlinx.coroutines.selects.b<R> d() {
        return this.f60648a;
    }

    @PublishedApi
    public final void e(@NotNull Throwable th) {
        this.f60648a.p0(th);
    }

    @PublishedApi
    @Nullable
    public final Object f() {
        if (!this.f60648a.h()) {
            try {
                Collections.shuffle(this.f60649b);
                Iterator<T> it = this.f60649b.iterator();
                while (it.hasNext()) {
                    ((d2.a) it.next()).invoke();
                }
            } catch (Throwable th) {
                this.f60648a.p0(th);
            }
        }
        return this.f60648a.o0();
    }

    @Override // kotlinx.coroutines.selects.a
    public <Q> void j(@NotNull kotlinx.coroutines.selects.d<? extends Q> dVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        this.f60649b.add(new b(dVar, pVar));
    }

    @Override // kotlinx.coroutines.selects.a
    public void l(@NotNull kotlinx.coroutines.selects.c cVar, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        this.f60649b.add(new a(cVar, lVar));
    }

    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void x(@NotNull e<? super P, ? extends Q> eVar, P p3, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        this.f60649b.add(new c(eVar, p3, pVar));
    }
}
