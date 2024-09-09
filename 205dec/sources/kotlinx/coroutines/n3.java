package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Interruptible.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/n3;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "", "state", "", "b", "(I)Ljava/lang/Void;", "d", "()V", "a", "c", "(Ljava/lang/Throwable;)V", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "Ljava/lang/Thread;", "targetThread", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/i1;", "cancelHandle", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/e2;", "job", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class n3 implements d2.l<Throwable, kotlin.f1> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60518d = AtomicIntegerFieldUpdater.newUpdater(n3.class, "_state");
    private volatile int _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Thread f60519a = Thread.currentThread();

    /* renamed from: b  reason: collision with root package name */
    private i1 f60520b;

    /* renamed from: c  reason: collision with root package name */
    private final e2 f60521c;

    public n3(@NotNull e2 e2Var) {
        this.f60521c = e2Var;
    }

    private final Void b(int i4) {
        throw new IllegalStateException(("Illegal state " + i4).toString());
    }

    public final void a() {
        while (true) {
            int i4 = this._state;
            if (i4 != 0) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i4);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f60518d.compareAndSet(this, i4, 1)) {
                i1 i1Var = this.f60520b;
                if (i1Var != null) {
                    i1Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(@Nullable Throwable th) {
        int i4;
        do {
            i4 = this._state;
            if (i4 != 0) {
                if (i4 == 1 || i4 == 2 || i4 == 3) {
                    return;
                }
                b(i4);
                throw new KotlinNothingValueException();
            }
        } while (!f60518d.compareAndSet(this, i4, 2));
        this.f60519a.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i4;
        this.f60520b = this.f60521c.z(true, true, this);
        do {
            i4 = this._state;
            if (i4 != 0) {
                if (i4 == 2 || i4 == 3) {
                    return;
                }
                b(i4);
                throw new KotlinNothingValueException();
            }
        } while (!f60518d.compareAndSet(this, i4, 0));
    }

    @Override // d2.l
    public /* bridge */ /* synthetic */ kotlin.f1 invoke(Throwable th) {
        c(th);
        return kotlin.f1.f55527a;
    }
}
