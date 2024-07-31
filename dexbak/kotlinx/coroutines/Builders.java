package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m12616d2 = {"Lkotlinx/coroutines/f;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "", "state", "Lkotlin/f1;", "Y", "s1", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "d", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/m1;", "e", "Lkotlinx/coroutines/m1;", "eventLoop", "", "E0", "()Z", "isScopedCoroutine", "Lkotlin/coroutines/f;", "parentContext", "<init>", "(Lkotlin/coroutines/f;Ljava/lang/Thread;Lkotlinx/coroutines/m1;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Builders<T> extends AbstractCoroutine<T> {

    /* renamed from: d */
    private final Thread f42283d;

    /* renamed from: e */
    private final AbstractC15133m1 f42284e;

    public Builders(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable AbstractC15133m1 abstractC15133m1) {
        super(coroutineContext, true);
        this.f42283d = thread;
        this.f42284e = abstractC15133m1;
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: E0 */
    protected boolean mo4075E0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: Y */
    public void mo4052Y(@Nullable Object obj) {
        if (!C14342f0.m8193g(Thread.currentThread(), this.f42283d)) {
            LockSupport.unpark(this.f42283d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: s1 */
    public final T m5039s1() {
        InterfaceC15152o3 m3872b = C15156p3.m3872b();
        if (m3872b != null) {
            m3872b.m3925h();
        }
        try {
            AbstractC15133m1 abstractC15133m1 = this.f42284e;
            if (abstractC15133m1 != null) {
                AbstractC15133m1.m3995F(abstractC15133m1, false, 1, null);
            }
            while (!Thread.interrupted()) {
                AbstractC15133m1 abstractC15133m12 = this.f42284e;
                long mo3563J = abstractC15133m12 != null ? abstractC15133m12.mo3563J() : Long.MAX_VALUE;
                if (isCompleted()) {
                    AbstractC15133m1 abstractC15133m13 = this.f42284e;
                    if (abstractC15133m13 != null) {
                        AbstractC15133m1.m3990q(abstractC15133m13, false, 1, null);
                    }
                    T t = (T) C15134m2.m3973o(m4014y0());
                    CompletionState completionState = t instanceof CompletionState ? t : null;
                    if (completionState == null) {
                        return t;
                    }
                    throw completionState.f42189a;
                }
                InterfaceC15152o3 m3872b2 = C15156p3.m3872b();
                if (m3872b2 != null) {
                    m3872b2.m3929d(this, mo3563J);
                } else {
                    LockSupport.parkNanos(this, mo3563J);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            m4046b0(interruptedException);
            throw interruptedException;
        } finally {
            InterfaceC15152o3 m3872b3 = C15156p3.m3872b();
            if (m3872b3 != null) {
                m3872b3.m3928e();
            }
        }
    }
}
