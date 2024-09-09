package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: locks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends d {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f58211c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final d2.l<InterruptedException, f1> f58212d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Lock lock, @NotNull Runnable checkCancelled, @NotNull d2.l<? super InterruptedException, f1> interruptedExceptionHandler) {
        super(lock);
        f0.p(lock, "lock");
        f0.p(checkCancelled, "checkCancelled");
        f0.p(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.f58211c = checkCancelled;
        this.f58212d = interruptedExceptionHandler;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.d, kotlin.reflect.jvm.internal.impl.storage.k
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f58211c.run();
            } catch (InterruptedException e4) {
                this.f58212d.invoke(e4);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Runnable checkCancelled, @NotNull d2.l<? super InterruptedException, f1> interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        f0.p(checkCancelled, "checkCancelled");
        f0.p(interruptedExceptionHandler, "interruptedExceptionHandler");
    }
}
