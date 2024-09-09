package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SystemProps.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\tH\u0000\u00a8\u0006\u000b"}, d2 = {"", "propertyName", "", "defaultValue", "c", "", "minValue", "maxValue", "a", "", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class n0 {
    public static final int a(@NotNull String str, int i4, int i5, int i6) {
        return (int) l0.c(str, i4, i5, i6);
    }

    public static final long b(@NotNull String str, long j4, long j5, long j6) {
        Long Z0;
        String d4 = l0.d(str);
        if (d4 != null) {
            Z0 = kotlin.text.v.Z0(d4);
            if (Z0 == null) {
                throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d4 + '\'').toString());
            }
            long longValue = Z0.longValue();
            if (j5 > longValue || j6 < longValue) {
                throw new IllegalStateException(("System property '" + str + "' should be in range " + j5 + ".." + j6 + ", but is '" + longValue + '\'').toString());
            }
            return longValue;
        }
        return j4;
    }

    public static final boolean c(@NotNull String str, boolean z3) {
        String d4 = l0.d(str);
        return d4 != null ? Boolean.parseBoolean(d4) : z3;
    }

    public static /* synthetic */ int d(String str, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            i5 = 1;
        }
        if ((i7 & 8) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        return l0.b(str, i4, i5, i6);
    }

    public static /* synthetic */ long e(String str, long j4, long j5, long j6, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            j5 = 1;
        }
        long j7 = j5;
        if ((i4 & 8) != 0) {
            j6 = Long.MAX_VALUE;
        }
        return l0.c(str, j4, j7, j6);
    }
}
