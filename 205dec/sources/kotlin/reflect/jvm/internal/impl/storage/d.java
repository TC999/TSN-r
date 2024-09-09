package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: locks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d implements k {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lock f58213b;

    public d() {
        this(null, 1, null);
    }

    public d(@NotNull Lock lock) {
        f0.p(lock, "lock");
        this.f58213b = lock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Lock a() {
        return this.f58213b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.k
    public void lock() {
        this.f58213b.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.k
    public void unlock() {
        this.f58213b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i4, u uVar) {
        this((i4 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
