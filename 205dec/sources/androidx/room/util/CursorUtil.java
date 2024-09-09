package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor c4) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c4.getColumnNames(), c4.getCount());
            while (c4.moveToNext()) {
                Object[] objArr = new Object[c4.getColumnCount()];
                for (int i4 = 0; i4 < c4.getColumnCount(); i4++) {
                    int type = c4.getType(i4);
                    if (type == 0) {
                        objArr[i4] = null;
                    } else if (type == 1) {
                        objArr[i4] = Long.valueOf(c4.getLong(i4));
                    } else if (type == 2) {
                        objArr[i4] = Double.valueOf(c4.getDouble(i4));
                    } else if (type == 3) {
                        objArr[i4] = c4.getString(i4);
                    } else if (type == 4) {
                        objArr[i4] = c4.getBlob(i4);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            c4.close();
        }
    }

    private static int findColumnIndexBySuffix(@NonNull Cursor cursor, @NonNull String name) {
        if (Build.VERSION.SDK_INT <= 25 && name.length() != 0) {
            return findColumnIndexBySuffix(cursor.getColumnNames(), name);
        }
        return -1;
    }

    public static int getColumnIndex(@NonNull Cursor c4, @NonNull String name) {
        int columnIndex = c4.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c4.getColumnIndex("`" + name + "`");
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c4, name);
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor c4, @NonNull String name) {
        String str;
        int columnIndex = getColumnIndex(c4, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            str = Arrays.toString(c4.getColumnNames());
        } catch (Exception e4) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e4);
            str = "";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }

    @VisibleForTesting(otherwise = 2)
    static int findColumnIndexBySuffix(String[] columnNames, String name) {
        String str = "." + name;
        String str2 = "." + name + "`";
        for (int i4 = 0; i4 < columnNames.length; i4++) {
            String str3 = columnNames[i4];
            if (str3.length() >= name.length() + 2) {
                if (str3.endsWith(str)) {
                    return i4;
                }
                if (str3.charAt(0) == '`' && str3.endsWith(str2)) {
                    return i4;
                }
            }
        }
        return -1;
    }
}
