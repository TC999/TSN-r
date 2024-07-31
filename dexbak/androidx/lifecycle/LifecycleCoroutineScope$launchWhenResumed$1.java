package androidx.lifecycle;

import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Lifecycle.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", m8638f = "Lifecycle.kt", m8637i = {0}, m8636l = {99}, m8635m = "invokeSuspend", m8634n = {"$this$launch"}, m8633s = {"L$0"})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class LifecycleCoroutineScope$launchWhenResumed$1 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ InterfaceC15284p $block;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f140p$;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenResumed$1(LifecycleCoroutineScope lifecycleCoroutineScope, InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = interfaceC15284p;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8183q(completion, "completion");
        LifecycleCoroutineScope$launchWhenResumed$1 lifecycleCoroutineScope$launchWhenResumed$1 = new LifecycleCoroutineScope$launchWhenResumed$1(this.this$0, this.$block, completion);
        lifecycleCoroutineScope$launchWhenResumed$1.f140p$ = (CoroutineScope) obj;
        return lifecycleCoroutineScope$launchWhenResumed$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((LifecycleCoroutineScope$launchWhenResumed$1) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            CoroutineScope coroutineScope = this.f140p$;
            Lifecycle lifecycle$lifecycle_runtime_ktx_release = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
            InterfaceC15284p interfaceC15284p = this.$block;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_runtime_ktx_release, interfaceC15284p, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
