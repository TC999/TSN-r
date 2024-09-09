package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = {"count(*)"};
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Collator mColl = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private final String mTableName;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        private void buildSQL() throws SQLException {
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(this.mTableName);
            sb.append(" (");
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("VALUES (");
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                cursor = sQLiteDatabase.rawQuery("PRAGMA table_info(" + this.mTableName + ")", (String[]) null);
                this.mColumns = new HashMap<>(cursor.getCount());
                int i4 = 1;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i4));
                    sb.append("'");
                    sb.append(string);
                    sb.append("'");
                    if (string2 == null) {
                        sb2.append("?");
                    } else {
                        sb2.append("COALESCE(?, ");
                        sb2.append(string2);
                        sb2.append(")");
                    }
                    sb.append(i4 == cursor.getCount() ? ") " : ", ");
                    sb2.append(i4 == cursor.getCount() ? ");" : ", ");
                    i4++;
                }
                cursor.close();
                sb.append((CharSequence) sb2);
                this.mInsertSQL = sb.toString();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private SQLiteStatement getStatement(boolean z3) throws SQLException {
            if (z3) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
                }
                return this.mReplaceStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            return this.mInsertStatement;
        }

        private synchronized long insertInternal(ContentValues contentValues, boolean z3) {
            SQLiteStatement statement;
            try {
                statement = getStatement(z3);
                statement.clearBindings();
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    DatabaseUtils.bindObjectToProgram(statement, getColumnIndex(entry.getKey()), entry.getValue());
                }
            } catch (SQLException e4) {
                Log.e("DatabaseUtils", "Error inserting " + contentValues + " into table  " + this.mTableName, e4);
                return -1L;
            }
            return statement.executeInsert();
        }

        public void bind(int i4, double d4) {
            this.mPreparedStatement.bindDouble(i4, d4);
        }

        public void bindNull(int i4) {
            this.mPreparedStatement.bindNull(i4);
        }

        public void close() {
            SQLiteStatement sQLiteStatement = this.mInsertStatement;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
                this.mInsertStatement = null;
            }
            SQLiteStatement sQLiteStatement2 = this.mReplaceStatement;
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }

        public long execute() {
            SQLiteStatement sQLiteStatement = this.mPreparedStatement;
            if (sQLiteStatement != null) {
                try {
                    return sQLiteStatement.executeInsert();
                } catch (SQLException e4) {
                    Log.e("DatabaseUtils", "Error executing InsertHelper with table " + this.mTableName, e4);
                    return -1L;
                } finally {
                    this.mPreparedStatement = null;
                }
            }
            throw new IllegalStateException("you must prepare this inserter before calling execute");
        }

        public int getColumnIndex(String str) {
            getStatement(false);
            Integer num = this.mColumns.get(str);
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("column '" + str + "' is invalid");
        }

        public long insert(ContentValues contentValues) {
            return insertInternal(contentValues, false);
        }

        public void prepareForInsert() {
            SQLiteStatement statement = getStatement(false);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement statement = getStatement(true);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public long replace(ContentValues contentValues) {
            return insertInternal(contentValues, true);
        }

        public void bind(int i4, float f4) {
            this.mPreparedStatement.bindDouble(i4, f4);
        }

        public void bind(int i4, long j4) {
            this.mPreparedStatement.bindLong(i4, j4);
        }

        public void bind(int i4, int i5) {
            this.mPreparedStatement.bindLong(i4, i5);
        }

        public void bind(int i4, boolean z3) {
            this.mPreparedStatement.bindLong(i4, z3 ? 1L : 0L);
        }

        public void bind(int i4, byte[] bArr) {
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i4);
            } else {
                this.mPreparedStatement.bindBlob(i4, bArr);
            }
        }

        public void bind(int i4, String str) {
            if (str == null) {
                this.mPreparedStatement.bindNull(i4);
            } else {
                this.mPreparedStatement.bindString(i4, str);
            }
        }
    }

    public static void appendEscapedSQLString(StringBuilder sb, String str) {
        sb.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                if (charAt == '\'') {
                    sb.append('\'');
                }
                sb.append(charAt);
            }
        } else {
            sb.append(str);
        }
        sb.append('\'');
    }

    public static final void appendValueToSql(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("NULL");
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        } else {
            appendEscapedSQLString(sb, obj.toString());
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i4, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i4);
        } else if (!(obj instanceof Double) && !(obj instanceof Float)) {
            if (obj instanceof Number) {
                sQLiteProgram.bindLong(i4, ((Number) obj).longValue());
            } else if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    sQLiteProgram.bindLong(i4, 1L);
                } else {
                    sQLiteProgram.bindLong(i4, 0L);
                }
            } else if (obj instanceof byte[]) {
                sQLiteProgram.bindBlob(i4, (byte[]) obj);
            } else {
                sQLiteProgram.bindString(i4, obj.toString());
            }
        } else {
            sQLiteProgram.bindDouble(i4, ((Number) obj).doubleValue());
        }
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return "(" + str + ") AND (" + str2 + ")";
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        } else {
            contentValues.put(str2, (Double) null);
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndexOrThrow)));
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorFillWindow(Cursor cursor, int i4, android.database.CursorWindow cursorWindow) {
        boolean putNull;
        if (i4 < 0 || i4 >= cursor.getCount()) {
            return;
        }
        int position = cursor.getPosition();
        int columnCount = cursor.getColumnCount();
        cursorWindow.clear();
        cursorWindow.setStartPosition(i4);
        cursorWindow.setNumColumns(columnCount);
        if (cursor.moveToPosition(i4)) {
            while (cursorWindow.allocRow()) {
                int i5 = 0;
                while (true) {
                    if (i5 >= columnCount) {
                        break;
                    }
                    int type = cursor.getType(i5);
                    if (type == 0) {
                        putNull = cursorWindow.putNull(i4, i5);
                    } else if (type == 1) {
                        putNull = cursorWindow.putLong(cursor.getLong(i5), i4, i5);
                    } else if (type == 2) {
                        putNull = cursorWindow.putDouble(cursor.getDouble(i5), i4, i5);
                    } else if (type != 4) {
                        String string = cursor.getString(i5);
                        if (string != null) {
                            putNull = cursorWindow.putString(string, i4, i5);
                        } else {
                            putNull = cursorWindow.putNull(i4, i5);
                        }
                    } else {
                        byte[] blob = cursor.getBlob(i5);
                        if (blob != null) {
                            putNull = cursorWindow.putBlob(blob, i4, i5);
                        } else {
                            putNull = cursorWindow.putNull(i4, i5);
                        }
                    }
                    if (!putNull) {
                        cursorWindow.freeLastRow();
                        break;
                    }
                    i5++;
                }
                i4++;
                if (!cursor.moveToNext()) {
                    break;
                }
            }
        }
        cursor.moveToPosition(position);
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndexOrThrow)));
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndexOrThrow)));
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Long.valueOf(cursor.getLong(columnIndexOrThrow)));
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (abstractWindowedCursor != null && abstractWindowedCursor.isBlob(i4)) {
                contentValues.put(columnNames[i4], cursor.getBlob(i4));
            } else {
                contentValues.put(columnNames[i4], cursor.getString(i4));
            }
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Short.valueOf(cursor.getShort(columnIndexOrThrow)));
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, cursor.getString(columnIndexOrThrow));
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i4) {
        insertHelper.bind(i4, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i4 + 1;
            cArr2[i4] = cArr[(bArr[i5] & 240) >>> 4];
            i4 = i6 + 1;
            cArr2[i6] = cArr[bArr[i5] & 15];
        }
        return cArr2;
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            Collator collator = Collator.getInstance();
            mColl = collator;
            collator.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes, HEX_DIGITS_LOWER), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    private static int getKeyLen(byte[] bArr) {
        if (bArr[bArr.length - 1] != 0) {
            return bArr.length;
        }
        return bArr.length - 1;
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer)) ? 1 : 3;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return longForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(str, countProjection, null, null, null, null, null);
        try {
            query.moveToFirst();
            return query.getLong(0);
        } finally {
            query.close();
        }
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        readExceptionFromParcel(parcel, parcel.readString(), readInt);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) throws FileNotFoundException {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        String readString = parcel.readString();
        if (readInt != 1) {
            readExceptionFromParcel(parcel, readString, readInt);
            return;
        }
        throw new FileNotFoundException(readString);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) throws OperationApplicationException {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        String readString = parcel.readString();
        if (readInt != 10) {
            readExceptionFromParcel(parcel, readString, readInt);
            return;
        }
        throw new OperationApplicationException(readString);
    }

    public static String sqlEscapeString(String str) {
        StringBuilder sb = new StringBuilder();
        appendEscapedSQLString(sb, str);
        return sb.toString();
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return stringForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exc) {
        boolean z3;
        int i4 = 1;
        if (exc instanceof FileNotFoundException) {
            z3 = false;
        } else if (exc instanceof IllegalArgumentException) {
            z3 = true;
            i4 = 2;
        } else if (exc instanceof UnsupportedOperationException) {
            z3 = true;
            i4 = 3;
        } else if (exc instanceof SQLiteAbortException) {
            z3 = true;
            i4 = 4;
        } else if (exc instanceof SQLiteConstraintException) {
            z3 = true;
            i4 = 5;
        } else if (exc instanceof SQLiteDatabaseCorruptException) {
            z3 = true;
            i4 = 6;
        } else if (exc instanceof SQLiteFullException) {
            z3 = true;
            i4 = 7;
        } else if (exc instanceof SQLiteDiskIOException) {
            z3 = true;
            i4 = 8;
        } else if (exc instanceof SQLiteException) {
            z3 = true;
            i4 = 9;
        } else if (!(exc instanceof OperationApplicationException)) {
            parcel.writeException(exc);
            Log.e("DatabaseUtils", "Writing exception to parcel", exc);
            return;
        } else {
            z3 = true;
            i4 = 10;
        }
        parcel.writeInt(i4);
        parcel.writeString(exc.getMessage());
        if (z3) {
            Log.e("DatabaseUtils", "Writing exception to parcel", exc);
        }
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        } else {
            contentValues.put(str2, (Integer) null);
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        } else {
            contentValues.put(str2, (Long) null);
        }
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        printStream.println("" + cursor.getPosition() + " {");
        int length = columnNames.length;
        for (int i4 = 0; i4 < length; i4++) {
            try {
                str = cursor.getString(i4);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            printStream.println("   " + columnNames[i4] + '=' + str);
        }
        printStream.println("}");
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        printStream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i4) {
        switch (i4) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            default:
                parcel.readException(i4, str);
                return;
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                bindObjectToProgram(sQLiteStatement, i5, strArr[i4]);
                i4 = i5;
            }
        }
        return sQLiteStatement.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                bindObjectToProgram(sQLiteStatement, i5, strArr[i4]);
                i4 = i5;
            }
        }
        return sQLiteStatement.simpleQueryForString();
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        sb.append("" + cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i4 = 0; i4 < length; i4++) {
            try {
                str = cursor.getString(i4);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            sb.append("   " + columnNames[i4] + '=' + str + "\n");
        }
        sb.append("}\n");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        sb.append(">>>>> Dumping cursor " + cursor + "\n");
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(position);
        }
        sb.append("<<<<<\n");
    }
}
