package kotlinx.coroutines.sync;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Semaphore.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u001a8\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\"\u001a\u0010\u0012\u001a\u00020\u00008\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0017\u001a\u00020\u00138\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0016\u0010\u0011\"\u001a\u0010\u001a\u001a\u00020\u00138\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u0012\u0004\b\u0019\u0010\u0011\"\u001a\u0010\u001d\u001a\u00020\u00138\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u0012\u0004\b\u001c\u0010\u0011\"\u001a\u0010 \u001a\u00020\u00138\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u0012\u0004\b\u001f\u0010\u0011\"\u001a\u0010#\u001a\u00020\u00008\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u000f\u0012\u0004\b\"\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/e;", "a", "T", "Lkotlin/Function0;", "action", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/sync/e;Ld2/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "id", "Lkotlinx/coroutines/sync/g;", "prev", "j", "I", "getMAX_SPIN_CYCLES$annotations", "()V", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/j0;", "b", "Lkotlinx/coroutines/internal/j0;", "getPERMIT$annotations", "PERMIT", "c", "getTAKEN$annotations", "TAKEN", "d", "getBROKEN$annotations", "BROKEN", "e", "getCANCELLED$annotations", "CANCELLED", "f", "getSEGMENT_SIZE$annotations", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SemaphoreKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f60670a;

    /* renamed from: b  reason: collision with root package name */
    private static final j0 f60671b;

    /* renamed from: c  reason: collision with root package name */
    private static final j0 f60672c;

    /* renamed from: d  reason: collision with root package name */
    private static final j0 f60673d;

    /* renamed from: e  reason: collision with root package name */
    private static final j0 f60674e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f60675f;

    static {
        int d4;
        int d5;
        d4 = n0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f60670a = d4;
        f60671b = new j0("PERMIT");
        f60672c = new j0("TAKEN");
        f60673d = new j0("BROKEN");
        f60674e = new j0("CANCELLED");
        d5 = n0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f60675f = d5;
    }

    @NotNull
    public static final e a(int i4, int i5) {
        return new f(i4, i5);
    }

    public static /* synthetic */ e b(int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return a(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g j(long j4, g gVar) {
        return new g(j4, gVar, 0);
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    private static /* synthetic */ void o() {
    }

    private static /* synthetic */ void p() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object q(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.e r4, @org.jetbrains.annotations.NotNull d2.a<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            d2.a r5 = (d2.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.e r4 = (kotlinx.coroutines.sync.e) r4
            kotlin.d0.n(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.d0.n(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.c(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.c0.d(r3)
            r4.release()
            kotlin.jvm.internal.c0.c(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            r4.release()
            kotlin.jvm.internal.c0.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.q(kotlinx.coroutines.sync.e, d2.a, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    private static final Object r(@NotNull e eVar, @NotNull d2.a aVar, @NotNull kotlin.coroutines.c cVar) {
        c0.e(0);
        eVar.c(cVar);
        c0.e(2);
        c0.e(1);
        try {
            return aVar.invoke();
        } finally {
            c0.d(1);
            eVar.release();
            c0.c(1);
        }
    }
}
