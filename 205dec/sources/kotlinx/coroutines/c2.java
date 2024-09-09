package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\fj\u0002`\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "h0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "job", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/e2;Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c2 extends f2<e2> {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f59071f = AtomicIntegerFieldUpdater.newUpdater(c2.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: e  reason: collision with root package name */
    private final d2.l<Throwable, kotlin.f1> f59072e;

    /* JADX WARN: Multi-variable type inference failed */
    public c2(@NotNull e2 e2Var, @NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        super(e2Var);
        this.f59072e = lVar;
        this._invoked = 0;
    }

    @Override // kotlinx.coroutines.f0
    public void h0(@Nullable Throwable th) {
        if (f59071f.compareAndSet(this, 0, 1)) {
            this.f59072e.invoke(th);
        }
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        h0(th);
        return kotlin.f1.f55527a;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "InvokeOnCancelling[" + u0.a(this) + '@' + u0.b(this) + ']';
    }
}
