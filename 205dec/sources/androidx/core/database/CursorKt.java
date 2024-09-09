package androidx.core.database;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Cursor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u0015"}, d2 = {"getBlobOrNull", "", "Landroid/database/Cursor;", "index", "", "getDoubleOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Double;", "getFloatOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Float;", "getIntOrNull", "(Landroid/database/Cursor;I)Ljava/lang/Integer;", "getLongOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Long;", "getShortOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Short;", "getStringOrNull", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CursorKt {
    @Nullable
    public static final byte[] getBlobOrNull(@NotNull Cursor getBlobOrNull, int i4) {
        f0.q(getBlobOrNull, "$this$getBlobOrNull");
        if (getBlobOrNull.isNull(i4)) {
            return null;
        }
        return getBlobOrNull.getBlob(i4);
    }

    @Nullable
    public static final Double getDoubleOrNull(@NotNull Cursor getDoubleOrNull, int i4) {
        f0.q(getDoubleOrNull, "$this$getDoubleOrNull");
        if (getDoubleOrNull.isNull(i4)) {
            return null;
        }
        return Double.valueOf(getDoubleOrNull.getDouble(i4));
    }

    @Nullable
    public static final Float getFloatOrNull(@NotNull Cursor getFloatOrNull, int i4) {
        f0.q(getFloatOrNull, "$this$getFloatOrNull");
        if (getFloatOrNull.isNull(i4)) {
            return null;
        }
        return Float.valueOf(getFloatOrNull.getFloat(i4));
    }

    @Nullable
    public static final Integer getIntOrNull(@NotNull Cursor getIntOrNull, int i4) {
        f0.q(getIntOrNull, "$this$getIntOrNull");
        if (getIntOrNull.isNull(i4)) {
            return null;
        }
        return Integer.valueOf(getIntOrNull.getInt(i4));
    }

    @Nullable
    public static final Long getLongOrNull(@NotNull Cursor getLongOrNull, int i4) {
        f0.q(getLongOrNull, "$this$getLongOrNull");
        if (getLongOrNull.isNull(i4)) {
            return null;
        }
        return Long.valueOf(getLongOrNull.getLong(i4));
    }

    @Nullable
    public static final Short getShortOrNull(@NotNull Cursor getShortOrNull, int i4) {
        f0.q(getShortOrNull, "$this$getShortOrNull");
        if (getShortOrNull.isNull(i4)) {
            return null;
        }
        return Short.valueOf(getShortOrNull.getShort(i4));
    }

    @Nullable
    public static final String getStringOrNull(@NotNull Cursor getStringOrNull, int i4) {
        f0.q(getStringOrNull, "$this$getStringOrNull");
        if (getStringOrNull.isNull(i4)) {
            return null;
        }
        return getStringOrNull.getString(i4);
    }
}
