package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: locks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f58247a = a.f58248a;

    /* compiled from: locks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f58248a = new a();

        private a() {
        }

        @NotNull
        public final d a(@Nullable Runnable runnable, @Nullable d2.l<? super InterruptedException, f1> lVar) {
            if (runnable != null && lVar != null) {
                return new c(runnable, lVar);
            }
            return new d(null, 1, null);
        }
    }

    void lock();

    void unlock();
}
