package com.iab.omid.library.mmadbridge;

import com.iab.omid.library.mmadbridge.p204d.C7105e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.iab.omid.library.mmadbridge.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class C7107e {

    /* renamed from: a */
    private static final Pattern f24260a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b */
    private static final Pattern f24261b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c */
    private static final Pattern f24262c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d */
    private static final Pattern f24263d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e */
    private static final Pattern f24264e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f */
    private static final Pattern f24265f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g */
    private static final Pattern f24266g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m34656a(String str, String str2) {
        return m34652e(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    /* renamed from: b */
    private static boolean m34655b(int i, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m34654c(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m34655b(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }

    /* renamed from: d */
    private static int[][] m34653d(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str.indexOf("<!--", i);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(int.class, 0, 2));
    }

    /* renamed from: e */
    static String m34652e(String str, String str2) {
        C7105e.m34669f(str, "HTML is null or empty");
        int[][] m34653d = m34653d(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (!m34651f(str, sb, f24261b, str2, m34653d) && !m34654c(str, sb, f24260a, str2, m34653d) && !m34651f(str, sb, f24263d, str2, m34653d) && !m34654c(str, sb, f24262c, str2, m34653d) && !m34651f(str, sb, f24265f, str2, m34653d) && !m34654c(str, sb, f24264e, str2, m34653d) && !m34654c(str, sb, f24266g, str2, m34653d)) {
            return str2 + str;
        }
        return sb.toString();
    }

    /* renamed from: f */
    private static boolean m34651f(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m34655b(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }
}
