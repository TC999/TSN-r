package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15113j2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Lifecycle.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", m8638f = "Lifecycle.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
    int label;

    /* renamed from: p$ */
    private CoroutineScope f142p$;
    final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8183q(completion, "completion");
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, completion);
        lifecycleCoroutineScopeImpl$register$1.f142p$ = (CoroutineScope) obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        C14287b.m8642h();
        if (this.label == 0) {
            C14294d0.m8596n(obj);
            CoroutineScope coroutineScope = this.f142p$;
            if (this.this$0.getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                this.this$0.getLifecycle$lifecycle_runtime_ktx_release().addObserver(this.this$0);
            } else {
                C15113j2.m4112j(coroutineScope.getCoroutineContext(), null, 1, null);
            }
            return Unit.f41048a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}