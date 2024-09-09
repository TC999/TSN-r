package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Synchronized.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0007"}, d2 = {"R", "", "lock", "Lkotlin/Function0;", "block", "l", "(Ljava/lang/Object;Ld2/a;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/StandardKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class h0 extends g0 {
    @InlineOnly
    private static final <R> R l(Object lock, d2.a<? extends R> block) {
        R invoke;
        kotlin.jvm.internal.f0.p(lock, "lock");
        kotlin.jvm.internal.f0.p(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th;
            }
        }
        kotlin.jvm.internal.c0.c(1);
        return invoke;
    }
}
