package kotlinx.coroutines.sync;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlinx.coroutines.internal.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Mutex.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001aD\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\t\u0010\n\"\u001a\u0010\u000f\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u0012\u0004\b\r\u0010\u000e\"\u001a\u0010\u0012\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u0012\u0004\b\u0011\u0010\u000e\"\u001a\u0010\u0015\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u0012\u0004\b\u0014\u0010\u000e\"\u001a\u0010\u0018\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u0012\u0004\b\u0017\u0010\u000e\"\u001a\u0010\u001b\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\f\u0012\u0004\b\u001a\u0010\u000e\"\u001a\u0010 \u001a\u00020\u001c8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u000e\"\u001a\u0010#\u001a\u00020\u001c8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u001e\u0012\u0004\b\"\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"", "locked", "Lkotlinx/coroutines/sync/c;", "a", "T", "", "owner", "Lkotlin/Function0;", "action", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/sync/c;Ljava/lang/Object;Ld2/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "getLOCK_FAIL$annotations", "()V", "LOCK_FAIL", "b", "getUNLOCK_FAIL$annotations", "UNLOCK_FAIL", "c", "getSELECT_SUCCESS$annotations", "SELECT_SUCCESS", "d", "getLOCKED$annotations", "LOCKED", "e", "getUNLOCKED$annotations", "UNLOCKED", "Lkotlinx/coroutines/sync/b;", "f", "Lkotlinx/coroutines/sync/b;", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", "g", "getEMPTY_UNLOCKED$annotations", "EMPTY_UNLOCKED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class MutexKt {

    /* renamed from: a  reason: collision with root package name */
    private static final j0 f60663a = new j0("LOCK_FAIL");

    /* renamed from: b  reason: collision with root package name */
    private static final j0 f60664b = new j0("UNLOCK_FAIL");

    /* renamed from: c  reason: collision with root package name */
    private static final j0 f60665c = new j0("SELECT_SUCCESS");

    /* renamed from: d  reason: collision with root package name */
    private static final j0 f60666d;

    /* renamed from: e  reason: collision with root package name */
    private static final j0 f60667e;

    /* renamed from: f  reason: collision with root package name */
    private static final b f60668f;

    /* renamed from: g  reason: collision with root package name */
    private static final b f60669g;

    static {
        j0 j0Var = new j0("LOCKED");
        f60666d = j0Var;
        j0 j0Var2 = new j0("UNLOCKED");
        f60667e = j0Var2;
        f60668f = new b(j0Var);
        f60669g = new b(j0Var2);
    }

    @NotNull
    public static final c a(boolean z3) {
        return new d(z3);
    }

    public static /* synthetic */ c b(boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return a(z3);
    }

    private static /* synthetic */ void j() {
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object q(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.c r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull d2.a<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r7) {
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
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            d2.a r6 = (d2.a) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.c r4 = (kotlinx.coroutines.sync.c) r4
            kotlin.d0.n(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.d0.n(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.c(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.c0.d(r3)
            r4.d(r5)
            kotlin.jvm.internal.c0.c(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            r4.d(r5)
            kotlin.jvm.internal.c0.c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.q(kotlinx.coroutines.sync.c, java.lang.Object, d2.a, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    private static final Object r(@NotNull c cVar, @Nullable Object obj, @NotNull d2.a aVar, @NotNull kotlin.coroutines.c cVar2) {
        c0.e(0);
        cVar.c(obj, cVar2);
        c0.e(2);
        c0.e(1);
        try {
            return aVar.invoke();
        } finally {
            c0.d(1);
            cVar.d(obj);
            c0.c(1);
        }
    }

    public static /* synthetic */ Object s(c cVar, Object obj, d2.a aVar, kotlin.coroutines.c cVar2, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = null;
        }
        c0.e(0);
        cVar.c(obj, cVar2);
        c0.e(2);
        c0.e(1);
        try {
            return aVar.invoke();
        } finally {
            c0.d(1);
            cVar.d(obj);
            c0.c(1);
        }
    }
}
