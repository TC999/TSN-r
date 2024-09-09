package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Distinct.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002Bg\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012:\u0010\u0014\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/DistinctFlowImpl;", "T", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/flow/h;", "upstream", "Lkotlin/Function1;", "", "keySelector", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "areEquivalent", "<init>", "(Lkotlinx/coroutines/flow/h;Ld2/l;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class DistinctFlowImpl<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f59634a;
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final d2.l<T, Object> f59635b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final d2.p<Object, Object, Boolean> f59636c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@NotNull h<? extends T> hVar, @NotNull d2.l<? super T, ? extends Object> lVar, @NotNull d2.p<Object, Object, Boolean> pVar) {
        this.f59634a = hVar;
        this.f59635b = lVar;
        this.f59636c = pVar;
    }

    @Override // kotlinx.coroutines.flow.h
    @InternalCoroutinesApi
    @Nullable
    public Object e(@NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) kotlinx.coroutines.flow.internal.r.f60167a;
        Object e4 = this.f59634a.e(new DistinctFlowImpl$collect$$inlined$collect$1(this, objectRef, iVar), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }
}
