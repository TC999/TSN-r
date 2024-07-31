package com.amap.api.col.p0463l;

import java.util.Locale;
import java.util.Random;

/* renamed from: com.amap.api.col.3l.s2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RandomUtil {

    /* renamed from: a */
    private static String f5217a = "0123456789";

    /* renamed from: a */
    public static String m54009a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        Locale locale = Locale.US;
        String format = String.format(locale, "%05d", Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        String m54006c = new C1936a(f5217a, nextInt3).m54006c(nextInt2, format);
        return m54006c + String.format(locale, "%01d", Integer.valueOf(nextInt2)) + String.format(locale, "%02d", Integer.valueOf(nextInt3));
    }

    /* compiled from: RandomUtil.java */
    /* renamed from: com.amap.api.col.3l.s2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C1936a {

        /* renamed from: a */
        private String f5218a;

        /* renamed from: b */
        private int f5219b;

        /* renamed from: c */
        private int f5220c;

        public C1936a(String str, int i) {
            this.f5219b = 1103515245;
            this.f5220c = 12345;
            this.f5218a = m54005d(str, i, str.length());
        }

        /* renamed from: a */
        private char m54008a(int i) {
            this.f5218a.length();
            return this.f5218a.charAt(i);
        }

        /* renamed from: b */
        private int m54007b(char c) {
            this.f5218a.length();
            return this.f5218a.indexOf(c);
        }

        /* renamed from: d */
        private String m54005d(String str, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i3 = 0; i3 < i2; i3++) {
                int m54004e = m54004e(i);
                int i4 = m54004e % length;
                i = m54004e(m54004e);
                int i5 = i % length;
                char charAt = stringBuffer.charAt(i4);
                stringBuffer.setCharAt(i4, stringBuffer.charAt(i5));
                stringBuffer.setCharAt(i5, charAt);
            }
            return stringBuffer.toString();
        }

        /* renamed from: e */
        private int m54004e(int i) {
            return (int) (((i * this.f5219b) + this.f5220c) & 2147483647L);
        }

        /* renamed from: f */
        private String m54003f(int i, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.f5218a.length();
            int length2 = str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                int m54007b = m54007b(str.charAt(i2));
                if (m54007b < 0) {
                    break;
                }
                sb.append(m54008a(((m54007b + i) + i2) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        /* renamed from: c */
        public final String m54006c(int i, String str) {
            return m54003f(i, str);
        }

        public C1936a() {
            this((byte) 0);
        }

        private C1936a(byte b) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }
    }
}
