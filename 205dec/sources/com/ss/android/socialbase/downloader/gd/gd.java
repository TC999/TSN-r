package com.ss.android.socialbase.downloader.gd;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd {
    public static StringBuilder c(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder w(StringBuilder sb, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            c(sb, strArr[i4]).append("=?");
            if (i4 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String[] strArr) {
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

    public static String w(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append('\"' + str + '\"');
        sb.append(" (");
        c(sb, strArr);
        sb.append(") VALUES (");
        c(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder c(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 < i4 - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String str, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            c(sb, str, strArr[i4]).append("=?");
            if (i4 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String c(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        c(sb, strArr);
        sb.append(") VALUES (");
        c(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String c(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            c(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String c(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        w(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            c(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
