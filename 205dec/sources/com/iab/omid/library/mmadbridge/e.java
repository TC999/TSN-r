package com.iab.omid.library.mmadbridge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f37742a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f37743b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f37744c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f37745d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f37746e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f37747f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f37748g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        return e(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    private static boolean b(int i4, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i4 >= iArr2[0] && i4 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean c(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i4 = 0;
        while (matcher.find(i4)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!b(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i4 = end;
        }
        return false;
    }

    private static int[][] d(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int indexOf = str.indexOf("<!--", i4);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i4 = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i4 = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(int.class, 0, 2));
    }

    static String e(String str, String str2) {
        com.iab.omid.library.mmadbridge.d.e.f(str, "HTML is null or empty");
        int[][] d4 = d(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (!f(str, sb, f37743b, str2, d4) && !c(str, sb, f37742a, str2, d4) && !f(str, sb, f37745d, str2, d4) && !c(str, sb, f37744c, str2, d4) && !f(str, sb, f37747f, str2, d4) && !c(str, sb, f37746e, str2, d4) && !c(str, sb, f37748g, str2, d4)) {
            return str2 + str;
        }
        return sb.toString();
    }

    private static boolean f(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i4 = 0;
        while (matcher.find(i4)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!b(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i4 = end;
        }
        return false;
    }
}
