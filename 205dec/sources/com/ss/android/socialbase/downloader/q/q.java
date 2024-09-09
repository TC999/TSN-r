package com.ss.android.socialbase.downloader.q;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class q {
    public static StringBuilder a(StringBuilder sb, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            ok(sb, strArr[i4]).append("=?");
            if (i4 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append('\"');
            sb.append(strArr[i4]);
            sb.append('\"');
            if (i4 < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append('\"' + str + '\"');
        sb.append(" (");
        ok(sb, strArr);
        sb.append(") VALUES (");
        ok(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder ok(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 < i4 - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String str, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            ok(sb, str, strArr[i4]).append("=?");
            if (i4 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String ok(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        ok(sb, strArr);
        sb.append(") VALUES (");
        ok(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String ok(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            ok(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String ok(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        a(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            ok(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
