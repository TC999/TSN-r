package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringNumberConversions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemProps.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\tH\u0000¨\u0006\u000b"}, m12616d2 = {"", "propertyName", "", "defaultValue", "c", "", "minValue", "maxValue", "a", "", "b", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* renamed from: kotlinx.coroutines.internal.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15084n0 {
    /* renamed from: a */
    public static final int m4261a(@NotNull String str, int i, int i2, int i3) {
        return (int) C15082l0.m4279c(str, i, i2, i3);
    }

    /* renamed from: b */
    public static final long m4260b(@NotNull String str, long j, long j2, long j3) {
        Long m6628Z0;
        String m4278d = C15082l0.m4278d(str);
        if (m4278d != null) {
            m6628Z0 = StringNumberConversions.m6628Z0(m4278d);
            if (m6628Z0 == null) {
                throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + m4278d + '\'').toString());
            }
            long longValue = m6628Z0.longValue();
            if (j2 > longValue || j3 < longValue) {
                throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
            }
            return longValue;
        }
        return j;
    }

    /* renamed from: c */
    public static final boolean m4259c(@NotNull String str, boolean z) {
        String m4278d = C15082l0.m4278d(str);
        return m4278d != null ? Boolean.parseBoolean(m4278d) : z;
    }

    /* renamed from: d */
    public static /* synthetic */ int m4258d(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return C15082l0.m4280b(str, i, i2, i3);
    }

    /* renamed from: e */
    public static /* synthetic */ long m4257e(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return C15082l0.m4279c(str, j, j4, j3);
    }
}
