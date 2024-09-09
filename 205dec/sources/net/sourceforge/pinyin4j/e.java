package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PinyinHelper.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f61525a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    private static final String f61526b = "";

    private e() {
    }

    private static String[] a(char c4) {
        String[] d4 = d(c4);
        if (d4 != null) {
            String[] strArr = new String[d4.length];
            for (int i4 = 0; i4 < d4.length; i4++) {
                strArr[i4] = c.a(d4[i4]);
            }
            return strArr;
        }
        return f61525a;
    }

    private static String[] b(char c4, h hVar) {
        String[] d4 = d(c4);
        if (d4 != null) {
            String[] strArr = new String[d4.length];
            for (int i4 = 0; i4 < d4.length; i4++) {
                strArr[i4] = g.a(d4[i4], h.f61543b, hVar);
            }
            return strArr;
        }
        return f61525a;
    }

    private static String[] c(char c4, net.sourceforge.pinyin4j.format.b bVar) throws BadHanyuPinyinOutputFormatCombination {
        String[] d4 = d(c4);
        if (d4 != null) {
            for (int i4 = 0; i4 < d4.length; i4++) {
                d4[i4] = d.b(d4[i4], bVar);
            }
            return d4;
        }
        return f61525a;
    }

    private static String[] d(char c4) {
        return a.d().b(c4);
    }

    public static String[] e(char c4) {
        return a(c4);
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    public static java.lang.String f(java.lang.String r9, net.sourceforge.pinyin4j.format.b r10, java.lang.String r11, boolean r12) throws net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination {
        /*
            net.sourceforge.pinyin4j.a r0 = net.sourceforge.pinyin4j.a.d()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char[] r9 = r9.toCharArray()
            r2 = 0
            r3 = 0
        Lf:
            int r4 = r9.length
            if (r3 >= r4) goto L75
            r4 = 0
            char r5 = r9[r3]
            h3.b r6 = r0.e()
            r7 = r3
            r8 = r7
        L1b:
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            java.lang.String r5 = r5.toUpperCase()
            h3.b r5 = r6.a(r5)
            if (r5 == 0) goto L38
            java.lang.String r6 = r5.c()
            if (r6 == 0) goto L34
            java.lang.String r4 = r5.c()
            r8 = r7
        L34:
            h3.b r5 = r5.b()
        L38:
            r6 = r5
            int r7 = r7 + 1
            int r5 = r9.length
            if (r7 >= r5) goto L42
            char r5 = r9[r7]
            if (r6 != 0) goto L1b
        L42:
            if (r4 != 0) goto L4c
            if (r12 == 0) goto L72
            char r3 = r9[r3]
            r1.append(r3)
            goto L72
        L4c:
            java.lang.String[] r4 = r0.h(r4)
            if (r4 == 0) goto L72
            r5 = 0
        L53:
            int r6 = r4.length
            if (r5 >= r6) goto L72
            r6 = r4[r5]
            java.lang.String r6 = net.sourceforge.pinyin4j.d.b(r6, r10)
            r1.append(r6)
            int r6 = r9.length
            if (r7 < r6) goto L69
            int r6 = r4.length
            int r6 = r6 + (-1)
            if (r5 >= r6) goto L6c
            if (r3 == r8) goto L6c
        L69:
            r1.append(r11)
        L6c:
            if (r3 != r8) goto L6f
            goto L72
        L6f:
            int r5 = r5 + 1
            goto L53
        L72:
            int r3 = r8 + 1
            goto Lf
        L75:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.pinyin4j.e.f(java.lang.String, net.sourceforge.pinyin4j.format.b, java.lang.String, boolean):java.lang.String");
    }

    public static String[] g(char c4) {
        return d(c4);
    }

    public static String[] h(char c4, net.sourceforge.pinyin4j.format.b bVar) throws BadHanyuPinyinOutputFormatCombination {
        return c(c4, bVar);
    }

    public static String[] i(char c4) {
        return b(c4, h.f61545d);
    }

    public static String[] j(char c4) {
        return b(c4, h.f61547f);
    }

    public static String[] k(char c4) {
        return b(c4, h.f61544c);
    }

    public static String[] l(char c4) {
        return b(c4, h.f61546e);
    }
}
