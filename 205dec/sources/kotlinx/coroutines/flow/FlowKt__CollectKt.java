package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Collect.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001aX\u0010\u0010\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000023\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001am\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002H\b\u0004\u0010\u000f\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001aV\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0011\u001a1\u0010\u001a\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/flow/h;", "Lkotlin/f1;", "b", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/e2;", "i", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/c;", "", "action", "a", "(Lkotlinx/coroutines/flow/h;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "", "index", "d", "(Lkotlinx/coroutines/flow/h;Ld2/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "Lkotlinx/coroutines/flow/i;", "flow", "g", "(Lkotlinx/coroutines/flow/i;Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class FlowKt__CollectKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", i = {0}, l = {50}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f59656a;

        /* renamed from: b  reason: collision with root package name */
        Object f59657b;

        /* renamed from: c  reason: collision with root package name */
        int f59658c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f59659d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(h hVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59659d = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f59659d, cVar);
            aVar.f59656a = (q0) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59658c;
            if (i4 == 0) {
                kotlin.d0.n(obj);
                q0 q0Var = this.f59656a;
                h hVar = this.f59659d;
                this.f59657b = q0Var;
                this.f59658c = 1;
                if (k.A(hVar, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q0 q0Var2 = (q0) this.f59657b;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = hVar.e(new FlowKt__CollectKt$collect$3(pVar), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Nullable
    public static final Object b(@NotNull h<?> hVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = hVar.e(kotlinx.coroutines.flow.internal.q.f60166a, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Nullable
    private static final Object c(@NotNull h hVar, @NotNull d2.p pVar, @NotNull kotlin.coroutines.c cVar) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(pVar);
        kotlin.jvm.internal.c0.e(0);
        Object e4 = hVar.e(flowKt__CollectKt$collect$3, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return e4;
    }

    @Nullable
    public static final <T> Object d(@NotNull h<? extends T> hVar, @NotNull d2.q<? super Integer, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = hVar.e(new FlowKt__CollectKt$collectIndexed$2(qVar), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Nullable
    private static final Object e(@NotNull h hVar, @NotNull d2.q qVar, @NotNull kotlin.coroutines.c cVar) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(qVar);
        kotlin.jvm.internal.c0.e(0);
        Object e4 = hVar.e(flowKt__CollectKt$collectIndexed$2, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return e4;
    }

    @Nullable
    public static final <T> Object f(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        h d4;
        Object h4;
        d4 = n.d(k.e1(hVar, pVar), 0, null, 2, null);
        Object A = k.A(d4, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return A == h4 ? A : f1.f55527a;
    }

    @BuilderInference
    @Nullable
    public static final <T> Object g(@NotNull i<? super T> iVar, @NotNull h<? extends T> hVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = hVar.e(iVar, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @BuilderInference
    @Nullable
    private static final Object h(@NotNull i iVar, @NotNull h hVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(0);
        Object e4 = hVar.e(iVar, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return e4;
    }

    @NotNull
    public static final <T> e2 i(@NotNull h<? extends T> hVar, @NotNull q0 q0Var) {
        e2 f4;
        f4 = kotlinx.coroutines.j.f(q0Var, null, null, new a(hVar, null), 3, null);
        return f4;
    }
}
