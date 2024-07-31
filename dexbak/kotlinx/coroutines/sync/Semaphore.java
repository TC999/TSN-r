package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.C15084n0;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u001a8\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\"\u001a\u0010\u0012\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0017\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0016\u0010\u0011\"\u001a\u0010\u001a\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u0012\u0004\b\u0019\u0010\u0011\"\u001a\u0010\u001d\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u0012\u0004\b\u001c\u0010\u0011\"\u001a\u0010 \u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u0012\u0004\b\u001f\u0010\u0011\"\u001a\u0010#\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\f\n\u0004\b!\u0010\u000f\u0012\u0004\b\"\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m12616d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/e;", "a", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", CcgConstant.f38549t, CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/sync/e;Ll1/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "id", "Lkotlinx/coroutines/sync/g;", "prev", "j", "I", "getMAX_SPIN_CYCLES$annotations", "()V", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/j0;", "b", "Lkotlinx/coroutines/internal/j0;", "getPERMIT$annotations", "PERMIT", "c", "getTAKEN$annotations", "TAKEN", "d", "getBROKEN$annotations", "BROKEN", "e", "getCANCELLED$annotations", "CANCELLED", "f", "getSEGMENT_SIZE$annotations", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.SemaphoreKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Semaphore {

    /* renamed from: a */
    private static final int f43353a;

    /* renamed from: b */
    private static final Symbol f43354b;

    /* renamed from: c */
    private static final Symbol f43355c;

    /* renamed from: d */
    private static final Symbol f43356d;

    /* renamed from: e */
    private static final Symbol f43357e;

    /* renamed from: f */
    private static final int f43358f;

    static {
        int m4258d;
        int m4258d2;
        m4258d = C15084n0.m4258d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f43353a = m4258d;
        f43354b = new Symbol("PERMIT");
        f43355c = new Symbol("TAKEN");
        f43356d = new Symbol("BROKEN");
        f43357e = new Symbol("CANCELLED");
        m4258d2 = C15084n0.m4258d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f43358f = m4258d2;
    }

    @NotNull
    /* renamed from: a */
    public static final InterfaceC15221e m3655a(int i, int i2) {
        return new C15222f(i, i2);
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC15221e m3654b(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m3655a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final C15224g m3646j(long j, C15224g c15224g) {
        return new C15224g(j, c15224g, 0);
    }

    /* renamed from: k */
    private static /* synthetic */ void m3645k() {
    }

    /* renamed from: l */
    private static /* synthetic */ void m3644l() {
    }

    /* renamed from: m */
    private static /* synthetic */ void m3643m() {
    }

    /* renamed from: n */
    private static /* synthetic */ void m3642n() {
    }

    /* renamed from: o */
    private static /* synthetic */ void m3641o() {
    }

    /* renamed from: p */
    private static /* synthetic */ void m3640p() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m3639q(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.InterfaceC15221e r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15269a<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r6) {
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
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            l1.a r5 = (p617l1.InterfaceC15269a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.e r4 = (kotlinx.coroutines.sync.InterfaceC15221e) r4
            kotlin.C14294d0.m8596n(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.C14294d0.m8596n(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.mo3611c(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.InlineMarker.m8228d(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.m8229c(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.m8228d(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.m8229c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.Semaphore.m3639q(kotlinx.coroutines.sync.e, l1.a, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: r */
    private static final Object m3638r(@NotNull InterfaceC15221e interfaceC15221e, @NotNull InterfaceC15269a interfaceC15269a, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(0);
        interfaceC15221e.mo3611c(interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            interfaceC15221e.release();
            InlineMarker.m8229c(1);
        }
    }
}
