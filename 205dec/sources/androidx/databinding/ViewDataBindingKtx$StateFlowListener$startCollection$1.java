package androidx.databinding;

import androidx.databinding.ViewDataBindingKtx;
import d2.p;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewDataBindingKtx.kt */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements p<q0, c<? super f1>, Object> {
    final /* synthetic */ h<Object> $flow;
    int label;
    final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewDataBindingKtx$StateFlowListener$startCollection$1(h<? extends Object> hVar, ViewDataBindingKtx.StateFlowListener stateFlowListener, c<? super ViewDataBindingKtx$StateFlowListener$startCollection$1> cVar) {
        super(2, cVar);
        this.$flow = hVar;
        this.this$0 = stateFlowListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final c<f1> create(@Nullable Object obj, @NotNull c<?> cVar) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$flow, this.this$0, cVar);
    }

    @Override // d2.p
    @Nullable
    public final Object invoke(@NotNull q0 q0Var, @Nullable c<? super f1> cVar) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h4;
        h4 = b.h();
        int i4 = this.label;
        if (i4 == 0) {
            d0.n(obj);
            h<Object> hVar = this.$flow;
            final ViewDataBindingKtx.StateFlowListener stateFlowListener = this.this$0;
            i<? super Object> iVar = new i<Object>() { // from class: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.i
                @Nullable
                public Object emit(Object obj2, @NotNull c cVar) {
                    WeakListener weakListener;
                    WeakListener weakListener2;
                    WeakListener weakListener3;
                    f1 f1Var;
                    Object h5;
                    weakListener = ViewDataBindingKtx.StateFlowListener.this.listener;
                    ViewDataBinding binder = weakListener.getBinder();
                    if (binder == null) {
                        f1Var = null;
                    } else {
                        weakListener2 = ViewDataBindingKtx.StateFlowListener.this.listener;
                        int i5 = weakListener2.mLocalFieldId;
                        weakListener3 = ViewDataBindingKtx.StateFlowListener.this.listener;
                        binder.handleFieldChange(i5, weakListener3.getTarget(), 0);
                        f1Var = f1.f55527a;
                    }
                    h5 = b.h();
                    return f1Var == h5 ? f1Var : f1.f55527a;
                }
            };
            this.label = 1;
            if (hVar.e(iVar, this) == h4) {
                return h4;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            d0.n(obj);
        }
        return f1.f55527a;
    }
}
