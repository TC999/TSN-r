package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: EventLoop.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\"\u001a\u0010\n\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\r\"\u0014\u0010\u0013\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012\"\u0014\u0010\u0017\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012\"\u001a\u0010\u001a\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u0012\u0004\b\u0019\u0010\t*\u001e\b\u0002\u0010\u001d\u001a\u0004\b\u0000\u0010\u001b\"\b\u0012\u0004\u0012\u00028\u00000\u001c2\b\u0012\u0004\u0012\u00028\u00000\u001c¨\u0006\u001e"}, m12616d2 = {"", "timeMillis", "d", "timeNanos", "c", "Lkotlinx/coroutines/internal/j0;", "a", "Lkotlinx/coroutines/internal/j0;", "getDISPOSED_TASK$annotations", "()V", "DISPOSED_TASK", "", "b", "I", "SCHEDULE_OK", "SCHEDULE_COMPLETED", "SCHEDULE_DISPOSED", "e", "J", "MS_TO_NS", "f", "MAX_MS", "g", "MAX_DELAY_NS", "h", "getCLOSED_EMPTY$annotations", "CLOSED_EMPTY", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/v;", "Queue", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.q1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15158q1 {

    /* renamed from: b */
    private static final int f43220b = 0;

    /* renamed from: c */
    private static final int f43221c = 1;

    /* renamed from: d */
    private static final int f43222d = 2;

    /* renamed from: e */
    private static final long f43223e = 1000000;

    /* renamed from: f */
    private static final long f43224f = 9223372036854L;

    /* renamed from: g */
    private static final long f43225g = 4611686018427387903L;

    /* renamed from: a */
    private static final Symbol f43219a = new Symbol("REMOVED_TASK");

    /* renamed from: h */
    private static final Symbol f43226h = new Symbol("CLOSED_EMPTY");

    /* renamed from: c */
    public static final long m3859c(long j) {
        return j / f43223e;
    }

    /* renamed from: d */
    public static final long m3858d(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= f43224f) {
            return Long.MAX_VALUE;
        }
        return f43223e * j;
    }

    /* renamed from: e */
    private static /* synthetic */ void m3857e() {
    }

    /* renamed from: f */
    private static /* synthetic */ void m3856f() {
    }
}
