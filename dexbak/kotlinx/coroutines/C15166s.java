package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* compiled from: CompletionState.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/s;", "Lkotlinx/coroutines/d0;", "", "c", "()Z", "Lkotlin/coroutines/c;", "continuation", "", "cause", "handled", "<init>", "(Lkotlin/coroutines/c;Ljava/lang/Throwable;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15166s extends CompletionState {

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f43234c = AtomicIntegerFieldUpdater.newUpdater(C15166s.class, "_resumed");
    private volatile int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C15166s(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<?> r3, @org.jetbrains.annotations.Nullable java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 == 0) goto L3
            goto L1e
        L3:
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L1e:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C15166s.<init>(kotlin.coroutines.c, java.lang.Throwable, boolean):void");
    }

    /* renamed from: c */
    public final boolean m3811c() {
        return f43234c.compareAndSet(this, 0, 1);
    }
}
