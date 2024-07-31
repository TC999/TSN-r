package androidx.databinding;

import androidx.databinding.ViewDataBindingKtx;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: ViewDataBindingKtx.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
@DebugMetadata(m8639c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", m8638f = "ViewDataBindingKtx.kt", m8637i = {}, m8636l = {116}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ InterfaceC14958h<Object> $flow;
    int label;
    final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewDataBindingKtx$StateFlowListener$startCollection$1(InterfaceC14958h<? extends Object> interfaceC14958h, ViewDataBindingKtx.StateFlowListener stateFlowListener, InterfaceC14268c<? super ViewDataBindingKtx$StateFlowListener$startCollection$1> interfaceC14268c) {
        super(2, interfaceC14268c);
        this.$flow = interfaceC14958h;
        this.this$0 = stateFlowListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$flow, this.this$0, interfaceC14268c);
    }

    @Override // p617l1.InterfaceC15284p
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            InterfaceC14958h<Object> interfaceC14958h = this.$flow;
            final ViewDataBindingKtx.StateFlowListener stateFlowListener = this.this$0;
            FlowCollector<? super Object> flowCollector = new FlowCollector<Object>() { // from class: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj2, @NotNull InterfaceC14268c interfaceC14268c) {
                    WeakListener weakListener;
                    WeakListener weakListener2;
                    WeakListener weakListener3;
                    Unit unit;
                    Object m8642h2;
                    weakListener = ViewDataBindingKtx.StateFlowListener.this.listener;
                    ViewDataBinding binder = weakListener.getBinder();
                    if (binder == null) {
                        unit = null;
                    } else {
                        weakListener2 = ViewDataBindingKtx.StateFlowListener.this.listener;
                        int i2 = weakListener2.mLocalFieldId;
                        weakListener3 = ViewDataBindingKtx.StateFlowListener.this.listener;
                        binder.handleFieldChange(i2, weakListener3.getTarget(), 0);
                        unit = Unit.f41048a;
                    }
                    m8642h2 = C14287b.m8642h();
                    return unit == m8642h2 ? unit : Unit.f41048a;
                }
            };
            this.label = 1;
            if (interfaceC14958h.mo4470e(flowCollector, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
