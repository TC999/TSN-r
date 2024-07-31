package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor c) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c.getColumnNames(), c.getCount());
            while (c.moveToNext()) {
                Object[] objArr = new Object[c.getColumnCount()];
                for (int i = 0; i < c.getColumnCount(); i++) {
                    int type = c.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(c.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(c.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = c.getString(i);
                    } else if (type == 4) {
                        objArr[i] = c.getBlob(i);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            c.close();
        }
    }

    private static int findColumnIndexBySuffix(@NonNull Cursor cursor, @NonNull String name) {
        if (Build.VERSION.SDK_INT <= 25 && name.length() != 0) {
            return findColumnIndexBySuffix(cursor.getColumnNames(), name);
        }
        return -1;
    }

    public static int getColumnIndex(@NonNull Cursor c, @NonNull String name) {
        int columnIndex = c.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c.getColumnIndex("`" + name + "`");
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c, name);
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor c, @NonNull String name) {
        String str;
        int columnIndex = getColumnIndex(c, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            str = Arrays.toString(c.getColumnNames());
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            str = "";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }

    @VisibleForTesting(otherwise = 2)
    static int findColumnIndexBySuffix(String[] columnNames, String name) {
        String str = "." + name;
        String str2 = "." + name + "`";
        for (int i = 0; i < columnNames.length; i++) {
            String str3 = columnNames[i];
            if (str3.length() >= name.length() + 2) {
                if (str3.endsWith(str)) {
                    return i;
                }
                if (str3.charAt(0) == '`' && str3.endsWith(str2)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
