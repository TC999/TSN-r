package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001aD\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\"\u001a\u0010\u000f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u0012\u0004\b\r\u0010\u000e\"\u001a\u0010\u0012\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u0012\u0004\b\u0011\u0010\u000e\"\u001a\u0010\u0015\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u0012\u0004\b\u0014\u0010\u000e\"\u001a\u0010\u0018\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0016\u0010\f\u0012\u0004\b\u0017\u0010\u000e\"\u001a\u0010\u001b\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\f\u0012\u0004\b\u001a\u0010\u000e\"\u001a\u0010 \u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u000e\"\u001a\u0010#\u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u0012\u0004\b\"\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m12616d2 = {"", "locked", "Lkotlinx/coroutines/sync/c;", "a", ExifInterface.GPS_DIRECTION_TRUE, "", "owner", "Lkotlin/Function0;", CcgConstant.f38549t, CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/sync/c;Ljava/lang/Object;Ll1/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "getLOCK_FAIL$annotations", "()V", "LOCK_FAIL", "b", "getUNLOCK_FAIL$annotations", "UNLOCK_FAIL", "c", "getSELECT_SUCCESS$annotations", "SELECT_SUCCESS", "d", "getLOCKED$annotations", "LOCKED", "e", "getUNLOCKED$annotations", "UNLOCKED", "Lkotlinx/coroutines/sync/b;", "f", "Lkotlinx/coroutines/sync/b;", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", "g", "getEMPTY_UNLOCKED$annotations", "EMPTY_UNLOCKED", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.MutexKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Mutex {

    /* renamed from: a */
    private static final Symbol f43346a = new Symbol("LOCK_FAIL");

    /* renamed from: b */
    private static final Symbol f43347b = new Symbol("UNLOCK_FAIL");

    /* renamed from: c */
    private static final Symbol f43348c = new Symbol("SELECT_SUCCESS");

    /* renamed from: d */
    private static final Symbol f43349d;

    /* renamed from: e */
    private static final Symbol f43350e;

    /* renamed from: f */
    private static final C15206b f43351f;

    /* renamed from: g */
    private static final C15206b f43352g;

    static {
        Symbol symbol = new Symbol("LOCKED");
        f43349d = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        f43350e = symbol2;
        f43351f = new C15206b(symbol);
        f43352g = new C15206b(symbol2);
    }

    @NotNull
    /* renamed from: a */
    public static final InterfaceC15207c m3674a(boolean z) {
        return new C15209d(z);
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC15207c m3673b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m3674a(z);
    }

    /* renamed from: j */
    private static /* synthetic */ void m3665j() {
    }

    /* renamed from: k */
    private static /* synthetic */ void m3664k() {
    }

    /* renamed from: l */
    private static /* synthetic */ void m3663l() {
    }

    /* renamed from: m */
    private static /* synthetic */ void m3662m() {
    }

    /* renamed from: n */
    private static /* synthetic */ void m3661n() {
    }

    /* renamed from: o */
    private static /* synthetic */ void m3660o() {
    }

    /* renamed from: p */
    private static /* synthetic */ void m3659p() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m3658q(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.InterfaceC15207c r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15269a<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            l1.a r6 = (p617l1.InterfaceC15269a) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.c r4 = (kotlinx.coroutines.sync.InterfaceC15207c) r4
            kotlin.C14294d0.m8596n(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.C14294d0.m8596n(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.mo3632c(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.InlineMarker.m8228d(r3)
            r4.mo3630e(r5)
            kotlin.jvm.internal.InlineMarker.m8229c(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.m8228d(r3)
            r4.mo3630e(r5)
            kotlin.jvm.internal.InlineMarker.m8229c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.Mutex.m3658q(kotlinx.coroutines.sync.c, java.lang.Object, l1.a, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: r */
    private static final Object m3657r(@NotNull InterfaceC15207c interfaceC15207c, @Nullable Object obj, @NotNull InterfaceC15269a interfaceC15269a, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(0);
        interfaceC15207c.mo3632c(obj, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            interfaceC15207c.mo3630e(obj);
            InlineMarker.m8229c(1);
        }
    }

    /* renamed from: s */
    public static /* synthetic */ Object m3656s(InterfaceC15207c interfaceC15207c, Object obj, InterfaceC15269a interfaceC15269a, InterfaceC14268c interfaceC14268c, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        InlineMarker.m8227e(0);
        interfaceC15207c.mo3632c(obj, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            interfaceC15207c.mo3630e(obj);
            InlineMarker.m8229c(1);
        }
    }
}
