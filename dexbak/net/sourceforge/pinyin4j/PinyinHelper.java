package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* renamed from: net.sourceforge.pinyin4j.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PinyinHelper {

    /* renamed from: a */
    private static final String[] f44111a = new String[0];

    /* renamed from: b */
    private static final String f44112b = "";

    private PinyinHelper() {
    }

    /* renamed from: a */
    private static String[] m2855a(char c) {
        String[] m2852d = m2852d(c);
        if (m2852d != null) {
            String[] strArr = new String[m2852d.length];
            for (int i = 0; i < m2852d.length; i++) {
                strArr[i] = GwoyeuRomatzyhTranslator.m2858a(m2852d[i]);
            }
            return strArr;
        }
        return f44111a;
    }

    /* renamed from: b */
    private static String[] m2854b(char c, PinyinRomanizationType pinyinRomanizationType) {
        String[] m2852d = m2852d(c);
        if (m2852d != null) {
            String[] strArr = new String[m2852d.length];
            for (int i = 0; i < m2852d.length; i++) {
                strArr[i] = PinyinRomanizationTranslator.m2826a(m2852d[i], PinyinRomanizationType.f44129b, pinyinRomanizationType);
            }
            return strArr;
        }
        return f44111a;
    }

    /* renamed from: c */
    private static String[] m2853c(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String[] m2852d = m2852d(c);
        if (m2852d != null) {
            for (int i = 0; i < m2852d.length; i++) {
                m2852d[i] = PinyinFormatter.m2856b(m2852d[i], hanyuPinyinOutputFormat);
            }
            return m2852d;
        }
        return f44111a;
    }

    /* renamed from: d */
    private static String[] m2852d(char c) {
        return ChineseToPinyinResource.m2868d().m2870b(c);
    }

    /* renamed from: e */
    public static String[] m2851e(char c) {
        return m2855a(c);
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* renamed from: f */
    public static java.lang.String m2850f(java.lang.String r9, net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat r10, java.lang.String r11, boolean r12) throws net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination {
        /*
            net.sourceforge.pinyin4j.a r0 = net.sourceforge.pinyin4j.ChineseToPinyinResource.m2868d()
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
            c2.b r6 = r0.m2867e()
            r7 = r3
            r8 = r7
        L1b:
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            java.lang.String r5 = r5.toUpperCase()
            c2.b r5 = r6.m58051a(r5)
            if (r5 == 0) goto L38
            java.lang.String r6 = r5.m58049c()
            if (r6 == 0) goto L34
            java.lang.String r4 = r5.m58049c()
            r8 = r7
        L34:
            c2.b r5 = r5.m58050b()
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
            java.lang.String[] r4 = r0.m2864h(r4)
            if (r4 == 0) goto L72
            r5 = 0
        L53:
            int r6 = r4.length
            if (r5 >= r6) goto L72
            r6 = r4[r5]
            java.lang.String r6 = net.sourceforge.pinyin4j.PinyinFormatter.m2856b(r6, r10)
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
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.pinyin4j.PinyinHelper.m2850f(java.lang.String, net.sourceforge.pinyin4j.format.b, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: g */
    public static String[] m2849g(char c) {
        return m2852d(c);
    }

    /* renamed from: h */
    public static String[] m2848h(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        return m2853c(c, hanyuPinyinOutputFormat);
    }

    /* renamed from: i */
    public static String[] m2847i(char c) {
        return m2854b(c, PinyinRomanizationType.f44131d);
    }

    /* renamed from: j */
    public static String[] m2846j(char c) {
        return m2854b(c, PinyinRomanizationType.f44133f);
    }

    /* renamed from: k */
    public static String[] m2845k(char c) {
        return m2854b(c, PinyinRomanizationType.f44130c);
    }

    /* renamed from: l */
    public static String[] m2844l(char c) {
        return m2854b(c, PinyinRomanizationType.f44132e);
    }
}
