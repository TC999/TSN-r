package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0000\u00a8\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final d2.q<kotlinx.coroutines.flow.i<Object>, Object, kotlin.coroutines.c<? super f1>, Object> f60170a = (d2.q) t0.q(new a(), 3);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0017\u0010\u0006\u001a\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005H\u0086@\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/i;", "", "p1", "Lkotlin/ParameterName;", "name", "value", "p2", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/flow/i;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements d2.q<kotlinx.coroutines.flow.i<? super Object>, Object, kotlin.coroutines.c<? super f1>, Object>, kotlin.coroutines.jvm.internal.i {
        a() {
            super(3, kotlinx.coroutines.flow.i.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // d2.q
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull kotlinx.coroutines.flow.i<Object> iVar, @Nullable Object obj, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            c0.e(0);
            Object emit = iVar.emit(obj, cVar);
            c0.e(2);
            c0.e(1);
            return emit;
        }
    }

    public static final /* synthetic */ d2.q a() {
        return f60170a;
    }

    private static /* synthetic */ void b() {
    }
}
