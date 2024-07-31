package com.p521ss.android.socialbase.downloader.p556q;

import io.netty.util.internal.StringUtil;

/* renamed from: com.ss.android.socialbase.downloader.q.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12719q {
    /* renamed from: a */
    public static StringBuilder m16507a(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            m16502ok(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    /* renamed from: ok */
    public static StringBuilder m16502ok(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    /* renamed from: ok */
    public static StringBuilder m16501ok(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    /* renamed from: ok */
    public static StringBuilder m16499ok(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
            if (i < length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    /* renamed from: a */
    public static String m16508a(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append('\"' + str + '\"');
        sb.append(" (");
        m16499ok(sb, strArr);
        sb.append(") VALUES (");
        m16503ok(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: ok */
    public static StringBuilder m16503ok(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    /* renamed from: ok */
    public static StringBuilder m16500ok(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            m16501ok(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    /* renamed from: ok */
    public static String m16506ok(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        m16499ok(sb, strArr);
        sb.append(") VALUES (");
        m16503ok(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: ok */
    public static String m16505ok(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            m16500ok(sb, str2, strArr);
        }
        return sb.toString();
    }

    /* renamed from: ok */
    public static String m16504ok(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        m16507a(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            m16500ok(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
