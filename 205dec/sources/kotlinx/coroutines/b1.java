package kotlinx.coroutines;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a2\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/b1;", "T", "Lkotlinx/coroutines/internal/f0;", "", EventMonitor.V1_STAGING_ADLOG, "()Z", "u1", "", "state", "Lkotlin/f1;", "Y", "(Ljava/lang/Object;)V", "k1", "t1", "()Ljava/lang/Object;", "Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b1<T> extends kotlinx.coroutines.internal.f0<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f59056e = AtomicIntegerFieldUpdater.newUpdater(b1.class, "_decision");
    private volatile int _decision;

    public b1(@NotNull kotlin.coroutines.f fVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        super(fVar, cVar);
        this._decision = 0;
    }

    private final boolean u1() {
        do {
            int i4 = this._decision;
            if (i4 != 0) {
                if (i4 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f59056e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean v1() {
        do {
            int i4 = this._decision;
            if (i4 != 0) {
                if (i4 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f59056e.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.f0, kotlinx.coroutines.l2
    public void Y(@Nullable Object obj) {
        k1(obj);
    }

    @Override // kotlinx.coroutines.internal.f0, kotlinx.coroutines.a
    protected void k1(@Nullable Object obj) {
        kotlin.coroutines.c d4;
        if (u1()) {
            return;
        }
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(this.f60357d);
        kotlinx.coroutines.internal.k.g(d4, i0.a(obj, this.f60357d), null, 2, null);
    }

    @Nullable
    public final Object t1() {
        Object h4;
        if (v1()) {
            h4 = kotlin.coroutines.intrinsics.b.h();
            return h4;
        }
        Object o4 = m2.o(y0());
        if (o4 instanceof d0) {
            throw ((d0) o4).f59534a;
        }
        return o4;
    }
}
