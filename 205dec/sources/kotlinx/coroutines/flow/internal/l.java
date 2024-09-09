package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FlowCoroutine.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002)\b\u0001\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u00a2\u0006\u0002\b\u0005H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001aU\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000025\b\u0001\u0010\u0006\u001a/\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t\u00a2\u0006\u0002\b\u0005H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001ae\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122/\b\u0001\u0010\u0006\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u00a2\u0006\u0002\b\u0005H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"R", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "c", "(Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "Lkotlinx/coroutines/flow/h;", "d", "(Ld2/q;)Lkotlinx/coroutines/flow/h;", "T", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/b0;", "Lkotlinx/coroutines/channels/d0;", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILd2/p;)Lkotlinx/coroutines/channels/d0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> implements kotlinx.coroutines.flow.h<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.q f60158a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: FlowCoroutine.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/FlowCoroutineKt$scopedFlow$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.internal.l$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1215a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a  reason: collision with root package name */
            private q0 f60159a;

            /* renamed from: b  reason: collision with root package name */
            Object f60160b;

            /* renamed from: c  reason: collision with root package name */
            int f60161c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f60162d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ a f60163e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1215a(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar, a aVar) {
                super(2, cVar);
                this.f60162d = iVar;
                this.f60163e = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                C1215a c1215a = new C1215a(this.f60162d, cVar, this.f60163e);
                c1215a.f60159a = (q0) obj;
                return c1215a;
            }

            @Override // d2.p
            public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
                return ((C1215a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60161c;
                if (i4 == 0) {
                    d0.n(obj);
                    q0 q0Var = this.f60159a;
                    d2.q qVar = this.f60163e.f60158a;
                    kotlinx.coroutines.flow.i iVar = this.f60162d;
                    this.f60160b = q0Var;
                    this.f60161c = 1;
                    c0.e(6);
                    Object invoke = qVar.invoke(q0Var, iVar, this);
                    c0.e(7);
                    if (invoke == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q0 q0Var2 = (q0) this.f60160b;
                    d0.n(obj);
                }
                return f1.f55527a;
            }
        }

        public a(d2.q qVar) {
            this.f60158a = qVar;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull kotlinx.coroutines.flow.i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object c4 = l.c(new C1215a(iVar, null, this), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return c4 == h4 ? c4 : f1.f55527a;
        }
    }

    @NotNull
    public static final <T> kotlinx.coroutines.channels.d0<T> a(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, int i4, @BuilderInference @NotNull d2.p<? super b0<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        n nVar = new n(k0.d(q0Var, fVar), kotlinx.coroutines.channels.q.d(i4, null, null, 6, null));
        nVar.r1(CoroutineStart.ATOMIC, nVar, pVar);
        return nVar;
    }

    public static /* synthetic */ kotlinx.coroutines.channels.d0 b(q0 q0Var, kotlin.coroutines.f fVar, int i4, d2.p pVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return a(q0Var, fVar, i4, pVar);
    }

    @Nullable
    public static final <R> Object c(@BuilderInference @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super R> cVar) {
        Object h4;
        k kVar = new k(cVar.getContext(), cVar);
        Object f4 = z2.b.f(kVar, kVar, pVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (f4 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return f4;
    }

    @NotNull
    public static final <R> kotlinx.coroutines.flow.h<R> d(@BuilderInference @NotNull d2.q<? super q0, ? super kotlinx.coroutines.flow.i<? super R>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return new a(qVar);
    }
}
