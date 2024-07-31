package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.asm.Opcodes;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: PausingDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", m8638f = "PausingDispatcher.kt", m8637i = {0, 0, 0, 0}, m8636l = {Opcodes.IF_ICMPGT}, m8635m = "invokeSuspend", m8634n = {"$this$withContext", "job", "dispatcher", "controller"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2<T> extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super T>, Object> {
    final /* synthetic */ InterfaceC15284p $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f143p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = interfaceC15284p;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
        C14342f0.m8183q(completion, "completion");
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, completion);
        pausingDispatcherKt$whenStateAtLeast$2.f143p$ = (CoroutineScope) obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(coroutineScope, (InterfaceC14268c) obj)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        LifecycleController lifecycleController;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            CoroutineScope coroutineScope = this.f143p$;
            Job job = (Job) coroutineScope.getCoroutineContext().get(Job.f42281m0);
            if (job != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, job);
                try {
                    InterfaceC15284p interfaceC15284p = this.$block;
                    this.L$0 = coroutineScope;
                    this.L$1 = job;
                    this.L$2 = pausingDispatcher;
                    this.L$3 = lifecycleController2;
                    this.label = 1;
                    obj = C15057h.m4445i(pausingDispatcher, interfaceC15284p, this);
                    if (obj == m8642h) {
                        return m8642h;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            lifecycleController = (LifecycleController) this.L$3;
            PausingDispatcher pausingDispatcher2 = (PausingDispatcher) this.L$2;
            Job job2 = (Job) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                C14294d0.m8596n(obj);
            } catch (Throwable th2) {
                th = th2;
                lifecycleController.finish();
                throw th;
            }
        }
        lifecycleController.finish();
        return obj;
    }
}
