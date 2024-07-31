package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: Interruptible.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001a¨\u0006\u001e"}, m12616d2 = {"Lkotlinx/coroutines/n3;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "", "state", "", "b", "(I)Ljava/lang/Void;", "d", "()V", "a", "c", "(Ljava/lang/Throwable;)V", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "Ljava/lang/Thread;", "targetThread", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/i1;", "cancelHandle", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/e2;", "job", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.n3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15145n3 implements InterfaceC15280l<Throwable, Unit> {

    /* renamed from: d */
    private static final AtomicIntegerFieldUpdater f43201d = AtomicIntegerFieldUpdater.newUpdater(C15145n3.class, "_state");
    private volatile int _state = 0;

    /* renamed from: a */
    private final Thread f43202a = Thread.currentThread();

    /* renamed from: b */
    private InterfaceC15064i1 f43203b;

    /* renamed from: c */
    private final Job f43204c;

    public C15145n3(@NotNull Job job) {
        this.f43204c = job;
    }

    /* renamed from: b */
    private final Void m3948b(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    /* renamed from: a */
    public final void m3949a() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        m3948b(i);
                        throw new ExceptionsH();
                    }
                }
            } else if (f43201d.compareAndSet(this, i, 1)) {
                InterfaceC15064i1 interfaceC15064i1 = this.f43203b;
                if (interfaceC15064i1 != null) {
                    interfaceC15064i1.dispose();
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: c */
    public void m3947c(@Nullable Throwable th) {
        int i;
        do {
            i = this._state;
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                m3948b(i);
                throw new ExceptionsH();
            }
        } while (!f43201d.compareAndSet(this, i, 2));
        this.f43202a.interrupt();
        this._state = 3;
    }

    /* renamed from: d */
    public final void m3946d() {
        int i;
        this.f43203b = this.f43204c.mo3824o(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                m3948b(i);
                throw new ExceptionsH();
            }
        } while (!f43201d.compareAndSet(this, i, 0));
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        m3947c(th);
        return Unit.f41048a;
    }
}
