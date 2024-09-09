package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mStrictProjectionMap;
    private Map<String, String> mProjectionMap = null;
    private String mTables = "";
    private StringBuilder mWhereClause = null;
    private boolean mDistinct = false;
    private SQLiteDatabase.CursorFactory mFactory = null;

    private static void appendClause(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    private static void appendClauseEscapeClause(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        DatabaseUtils.appendEscapedSQLString(sb, str2);
    }

    public static void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                if (i4 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append(' ');
    }

    public static String buildQueryString(boolean z3, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        if (!TextUtils.isEmpty(str6) && !sLimitPattern.matcher(str6).matches()) {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + str6);
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("SELECT ");
        if (z3) {
            sb.append("DISTINCT ");
        }
        if (strArr != null && strArr.length != 0) {
            appendColumns(sb, strArr);
        } else {
            sb.append("* ");
        }
        sb.append("FROM ");
        sb.append(str);
        appendClause(sb, " WHERE ", str2);
        appendClause(sb, " GROUP BY ", str3);
        appendClause(sb, " HAVING ", str4);
        appendClause(sb, " ORDER BY ", str5);
        appendClause(sb, " LIMIT ", str6);
        return sb.toString();
    }

    private String[] computeProjection(String[] strArr) {
        int i4 = 0;
        if (strArr != null && strArr.length > 0) {
            if (this.mProjectionMap != null) {
                String[] strArr2 = new String[strArr.length];
                int length = strArr.length;
                while (i4 < length) {
                    String str = strArr[i4];
                    String str2 = this.mProjectionMap.get(str);
                    if (str2 != null) {
                        strArr2[i4] = str2;
                    } else if (!this.mStrictProjectionMap && (str.contains(" AS ") || str.contains(" as "))) {
                        strArr2[i4] = str;
                    } else {
                        throw new IllegalArgumentException("Invalid column " + strArr[i4]);
                    }
                    i4++;
                }
                return strArr2;
            }
            return strArr;
        }
        Map<String, String> map = this.mProjectionMap;
        if (map != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            String[] strArr3 = new String[entrySet.size()];
            for (Map.Entry<String, String> entry : entrySet) {
                if (!entry.getKey().equals("_count")) {
                    strArr3[i4] = entry.getValue();
                    i4++;
                }
            }
            return strArr3;
        }
        return null;
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        String[] computeProjection = computeProjection(strArr);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = this.mWhereClause;
        boolean z3 = sb2 != null && sb2.length() > 0;
        if (z3) {
            sb.append(this.mWhereClause.toString());
            sb.append(')');
        }
        if (str != null && str.length() > 0) {
            if (z3) {
                sb.append(" AND ");
            }
            sb.append('(');
            sb.append(str);
            sb.append(')');
        }
        return buildQueryString(this.mDistinct, this.mTables, computeProjection, sb.toString(), str2, str3, str4, str5);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder sb = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 > 0) {
                sb.append(str3);
            }
            sb.append(strArr[i4]);
        }
        appendClause(sb, " ORDER BY ", str);
        appendClause(sb, " LIMIT ", str2);
        return sb.toString();
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i4, String str2, String str3, String[] strArr2, String str4, String str5) {
        int length = strArr.length;
        String[] strArr3 = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String str6 = strArr[i5];
            if (str6.equals(str)) {
                strArr3[i5] = "'" + str2 + "' AS " + str;
            } else if (i5 > i4 && !set.contains(str6)) {
                strArr3[i5] = "NULL AS " + str6;
            } else {
                strArr3[i5] = str6;
            }
        }
        return buildQuery(strArr3, str3, strArr2, str4, str5, null, null);
    }

    public String getTables() {
        return this.mTables;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null);
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setDistinct(boolean z3) {
        this.mDistinct = z3;
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setStrictProjectionMap(boolean z3) {
        this.mStrictProjectionMap = z3;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (this.mTables == null) {
            return null;
        }
        String buildQuery = buildQuery(strArr, str, strArr2, str2, str3, str4, str5);
        if (Log.isLoggable("SQLiteQueryBuilder", 3)) {
            Log.d("SQLiteQueryBuilder", "Performing query: " + buildQuery);
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables));
    }
}
