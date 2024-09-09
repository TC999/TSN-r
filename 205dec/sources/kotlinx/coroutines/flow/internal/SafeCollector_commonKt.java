package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.f;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0080\u0010\u001aP\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\b2/\b\u0005\u0010\u000e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\rH\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/f;", "currentContext", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/e2;", "collectJob", "b", "T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/h;", "c", "(Ld2/p;)Lkotlinx/coroutines/flow/h;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SafeCollector_commonKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "count", "Lkotlin/coroutines/f$b;", "element", "a", "(ILkotlin/coroutines/f$b;)I"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.p<Integer, f.b, Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SafeCollector f60123a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SafeCollector safeCollector) {
            super(2);
            this.f60123a = safeCollector;
        }

        public final int a(int i4, @NotNull f.b bVar) {
            f.c<?> key = bVar.getKey();
            f.b bVar2 = this.f60123a.collectContext.get(key);
            if (key != e2.f59626i0) {
                if (bVar != bVar2) {
                    return Integer.MIN_VALUE;
                }
                return i4 + 1;
            }
            e2 e2Var = (e2) bVar2;
            e2 b4 = SafeCollector_commonKt.b((e2) bVar, e2Var);
            if (b4 == e2Var) {
                return e2Var == null ? i4 : i4 + 1;
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b4 + ", expected child of " + e2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, f.b bVar) {
            return Integer.valueOf(a(num.intValue(), bVar));
        }
    }

    @JvmName(name = "checkContext")
    public static final void a(@NotNull SafeCollector<?> safeCollector, @NotNull kotlin.coroutines.f fVar) {
        if (((Number) fVar.fold(0, new a(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + fVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @Nullable
    public static final e2 b(@Nullable e2 e2Var, @Nullable e2 e2Var2) {
        while (e2Var != null) {
            if (e2Var == e2Var2 || !(e2Var instanceof f0)) {
                return e2Var;
            }
            e2Var = ((f0) e2Var).s1();
        }
        return null;
    }

    @PublishedApi
    @NotNull
    public static final <T> kotlinx.coroutines.flow.h<T> c(@BuilderInference @NotNull d2.p<? super kotlinx.coroutines.flow.i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return new SafeCollector_commonKt$unsafeFlow$1(pVar);
    }
}
