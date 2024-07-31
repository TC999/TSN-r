package androidx.core.database;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00008\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0015"}, m12616d2 = {"getBlobOrNull", "", "Landroid/database/Cursor;", "index", "", "getDoubleOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Double;", "getFloatOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Float;", "getIntOrNull", "(Landroid/database/Cursor;I)Ljava/lang/Integer;", "getLongOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Long;", "getShortOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Short;", "getStringOrNull", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.database.CursorKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Cursor {
    @Nullable
    public static final byte[] getBlobOrNull(@NotNull android.database.Cursor getBlobOrNull, int i) {
        C14342f0.m8183q(getBlobOrNull, "$this$getBlobOrNull");
        if (getBlobOrNull.isNull(i)) {
            return null;
        }
        return getBlobOrNull.getBlob(i);
    }

    @Nullable
    public static final Double getDoubleOrNull(@NotNull android.database.Cursor getDoubleOrNull, int i) {
        C14342f0.m8183q(getDoubleOrNull, "$this$getDoubleOrNull");
        if (getDoubleOrNull.isNull(i)) {
            return null;
        }
        return Double.valueOf(getDoubleOrNull.getDouble(i));
    }

    @Nullable
    public static final Float getFloatOrNull(@NotNull android.database.Cursor getFloatOrNull, int i) {
        C14342f0.m8183q(getFloatOrNull, "$this$getFloatOrNull");
        if (getFloatOrNull.isNull(i)) {
            return null;
        }
        return Float.valueOf(getFloatOrNull.getFloat(i));
    }

    @Nullable
    public static final Integer getIntOrNull(@NotNull android.database.Cursor getIntOrNull, int i) {
        C14342f0.m8183q(getIntOrNull, "$this$getIntOrNull");
        if (getIntOrNull.isNull(i)) {
            return null;
        }
        return Integer.valueOf(getIntOrNull.getInt(i));
    }

    @Nullable
    public static final Long getLongOrNull(@NotNull android.database.Cursor getLongOrNull, int i) {
        C14342f0.m8183q(getLongOrNull, "$this$getLongOrNull");
        if (getLongOrNull.isNull(i)) {
            return null;
        }
        return Long.valueOf(getLongOrNull.getLong(i));
    }

    @Nullable
    public static final Short getShortOrNull(@NotNull android.database.Cursor getShortOrNull, int i) {
        C14342f0.m8183q(getShortOrNull, "$this$getShortOrNull");
        if (getShortOrNull.isNull(i)) {
            return null;
        }
        return Short.valueOf(getShortOrNull.getShort(i));
    }

    @Nullable
    public static final String getStringOrNull(@NotNull android.database.Cursor getStringOrNull, int i) {
        C14342f0.m8183q(getStringOrNull, "$this$getStringOrNull");
        if (getStringOrNull.isNull(i)) {
            return null;
        }
        return getStringOrNull.getString(i);
    }
}
