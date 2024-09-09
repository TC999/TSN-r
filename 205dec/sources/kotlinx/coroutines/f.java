package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\r\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/f;", "T", "Lkotlinx/coroutines/a;", "", "state", "Lkotlin/f1;", "Y", "s1", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "d", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/m1;", "e", "Lkotlinx/coroutines/m1;", "eventLoop", "", "E0", "()Z", "isScopedCoroutine", "Lkotlin/coroutines/f;", "parentContext", "<init>", "(Lkotlin/coroutines/f;Ljava/lang/Thread;Lkotlinx/coroutines/m1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f<T> extends a<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Thread f59628d;

    /* renamed from: e  reason: collision with root package name */
    private final m1 f59629e;

    public f(@NotNull kotlin.coroutines.f fVar, @NotNull Thread thread, @Nullable m1 m1Var) {
        super(fVar, true);
        this.f59628d = thread;
        this.f59629e = m1Var;
    }

    @Override // kotlinx.coroutines.l2
    protected boolean E0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l2
    public void Y(@Nullable Object obj) {
        if (!kotlin.jvm.internal.f0.g(Thread.currentThread(), this.f59628d)) {
            LockSupport.unpark(this.f59628d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T s1() {
        o3 b4 = p3.b();
        if (b4 != null) {
            b4.h();
        }
        try {
            m1 m1Var = this.f59629e;
            if (m1Var != null) {
                m1.D(m1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                m1 m1Var2 = this.f59629e;
                long H = m1Var2 != null ? m1Var2.H() : Long.MAX_VALUE;
                if (isCompleted()) {
                    m1 m1Var3 = this.f59629e;
                    if (m1Var3 != null) {
                        m1.q(m1Var3, false, 1, null);
                    }
                    T t3 = (T) m2.o(y0());
                    d0 d0Var = t3 instanceof d0 ? t3 : null;
                    if (d0Var == null) {
                        return t3;
                    }
                    throw d0Var.f59534a;
                }
                o3 b5 = p3.b();
                if (b5 != null) {
                    b5.d(this, H);
                } else {
                    LockSupport.parkNanos(this, H);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            b0(interruptedException);
            throw interruptedException;
        } finally {
            o3 b6 = p3.b();
            if (b6 != null) {
                b6.e();
            }
        }
    }
}
