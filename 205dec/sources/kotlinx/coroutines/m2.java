package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\"\u001a\u0010\b\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001a\u0010\u000b\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u0012\u0004\b\n\u0010\u0007\"\u001a\u0010\u000e\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u0012\u0004\b\r\u0010\u0007\"\u001a\u0010\u0011\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u0012\u0004\b\u0010\u0010\u0007\"\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0014\"\u001a\u0010\u001b\u001a\u00020\u00038\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0005\u0012\u0004\b\u001a\u0010\u0007\"\u001a\u0010 \u001a\u00020\u001c8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0007\"\u001a\u0010#\u001a\u00020\u001c8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u001e\u0012\u0004\b\"\u0010\u0007\u00a8\u0006$"}, d2 = {"", "g", "o", "Lkotlinx/coroutines/internal/j0;", "a", "Lkotlinx/coroutines/internal/j0;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_ALREADY", "b", "getCOMPLETING_WAITING_CHILDREN$annotations", "COMPLETING_WAITING_CHILDREN", "c", "getCOMPLETING_RETRY$annotations", "COMPLETING_RETRY", "d", "getTOO_LATE_TO_CANCEL$annotations", "TOO_LATE_TO_CANCEL", "", "e", "I", "RETRY", "f", "FALSE", "TRUE", "h", "getSEALED$annotations", "SEALED", "Lkotlinx/coroutines/l1;", "i", "Lkotlinx/coroutines/l1;", "getEMPTY_NEW$annotations", "EMPTY_NEW", "j", "getEMPTY_ACTIVE$annotations", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m2 {

    /* renamed from: e  reason: collision with root package name */
    private static final int f60501e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f60502f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final int f60503g = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f60497a = new kotlinx.coroutines.internal.j0("COMPLETING_ALREADY");
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f60498b = new kotlinx.coroutines.internal.j0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f60499c = new kotlinx.coroutines.internal.j0("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f60500d = new kotlinx.coroutines.internal.j0("TOO_LATE_TO_CANCEL");

    /* renamed from: h  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f60504h = new kotlinx.coroutines.internal.j0("SEALED");

    /* renamed from: i  reason: collision with root package name */
    private static final l1 f60505i = new l1(false);

    /* renamed from: j  reason: collision with root package name */
    private static final l1 f60506j = new l1(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof y1 ? new z1((y1) obj) : obj;
    }

    private static /* synthetic */ void h() {
    }

    private static /* synthetic */ void i() {
    }

    public static /* synthetic */ void j() {
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    @Nullable
    public static final Object o(@Nullable Object obj) {
        y1 y1Var;
        z1 z1Var = (z1) (!(obj instanceof z1) ? null : obj);
        return (z1Var == null || (y1Var = z1Var.f60776a) == null) ? obj : y1Var;
    }
}
