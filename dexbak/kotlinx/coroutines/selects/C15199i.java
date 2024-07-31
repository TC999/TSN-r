package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

/* compiled from: Select.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lkotlinx/coroutines/selects/i;", "", "", "a", "()J", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.selects.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15199i {

    /* renamed from: a */
    private static final AtomicLongFieldUpdater f43330a = AtomicLongFieldUpdater.newUpdater(C15199i.class, "number");
    private volatile long number = 1;

    /* renamed from: a */
    public final long m3684a() {
        return f43330a.incrementAndGet(this);
    }
}
