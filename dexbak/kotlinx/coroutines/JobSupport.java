package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\fj\u0002`\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "f0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "job", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/e2;Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.c2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class JobSupport extends AbstractC14779f2<Job> {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f41726f = AtomicIntegerFieldUpdater.newUpdater(JobSupport.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: e */
    private final InterfaceC15280l<Throwable, Unit> f41727e;

    /* JADX WARN: Multi-variable type inference failed */
    public JobSupport(@NotNull Job job, @NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        super(job);
        this.f41727e = interfaceC15280l;
        this._invoked = 0;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        if (f41726f.compareAndSet(this, 0, 1)) {
            this.f41727e.invoke(th);
        }
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3495f0(th);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "InvokeOnCancelling[" + DebugStrings.m3554a(this) + '@' + DebugStrings.m3553b(this) + ']';
    }
}
