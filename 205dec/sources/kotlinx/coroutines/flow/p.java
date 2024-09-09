package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Distinct.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001aT\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u001a6\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u001aw\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\"0\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f8\u0002X\u0083\u0004\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"6\u0010\u0018\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\b0\u00038\u0002X\u0083\u0004\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "a", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "areEquivalent", "b", "K", "Lkotlin/Function1;", "keySelector", "c", "", "d", "(Lkotlinx/coroutines/flow/h;Ld2/l;Ld2/p;)Lkotlinx/coroutines/flow/h;", "defaultKeySelector", "Ld2/l;", "g", "()Ld2/l;", "getDefaultKeySelector$FlowKt__DistinctKt$annotations", "()V", "defaultAreEquivalent", "Ld2/p;", "e", "()Ld2/p;", "getDefaultAreEquivalent$FlowKt__DistinctKt$annotations", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class p {

    /* renamed from: a  reason: collision with root package name */
    private static final d2.l<Object, Object> f60282a = b.f60285a;

    /* renamed from: b  reason: collision with root package name */
    private static final d2.p<Object, Object, Boolean> f60283b = a.f60284a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Distinct.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "old", "new", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Z"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.p<Object, Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f60284a = new a();

        a() {
            super(2);
        }

        public final boolean a(@Nullable Object obj, @Nullable Object obj2) {
            return kotlin.jvm.internal.f0.g(obj, obj2);
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a(obj, obj2));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Distinct.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f60285a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> h<T> a(@NotNull h<? extends T> hVar) {
        return hVar instanceof h0 ? hVar : d(hVar, f60282a, f60283b);
    }

    @NotNull
    public static final <T> h<T> b(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super T, Boolean> pVar) {
        d2.l<Object, Object> lVar = f60282a;
        if (pVar != null) {
            return d(hVar, lVar, (d2.p) t0.q(pVar, 2));
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Any?, kotlin.Any?) -> kotlin.Boolean");
    }

    @NotNull
    public static final <T, K> h<T> c(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, ? extends K> lVar) {
        return d(hVar, lVar, f60283b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> h<T> d(h<? extends T> hVar, d2.l<? super T, ? extends Object> lVar, d2.p<Object, Object, Boolean> pVar) {
        if (hVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) hVar;
            if (distinctFlowImpl.f59635b == lVar && distinctFlowImpl.f59636c == pVar) {
                return hVar;
            }
        }
        return new DistinctFlowImpl(hVar, lVar, pVar);
    }

    private static final d2.p<Object, Object, Boolean> e() {
        return f60283b;
    }

    private static /* synthetic */ void f() {
    }

    private static final d2.l<Object, Object> g() {
        return f60282a;
    }

    private static /* synthetic */ void h() {
    }
}
