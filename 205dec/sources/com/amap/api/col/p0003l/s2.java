package com.amap.api.col.p0003l;

import java.util.Locale;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RandomUtil.java */
/* renamed from: com.amap.api.col.3l.s2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s2 {

    /* renamed from: a  reason: collision with root package name */
    private static String f8929a = "0123456789";

    public static String a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        Locale locale = Locale.US;
        String format = String.format(locale, "%05d", Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        String c4 = new a(f8929a, nextInt3).c(nextInt2, format);
        return c4 + String.format(locale, "%01d", Integer.valueOf(nextInt2)) + String.format(locale, "%02d", Integer.valueOf(nextInt3));
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RandomUtil.java */
    /* renamed from: com.amap.api.col.3l.s2$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8930a;

        /* renamed from: b  reason: collision with root package name */
        private int f8931b;

        /* renamed from: c  reason: collision with root package name */
        private int f8932c;

        public a(String str, int i4) {
            this.f8931b = 1103515245;
            this.f8932c = 12345;
            this.f8930a = d(str, i4, str.length());
        }

        private char a(int i4) {
            this.f8930a.length();
            return this.f8930a.charAt(i4);
        }

        private int b(char c4) {
            this.f8930a.length();
            return this.f8930a.indexOf(c4);
        }

        private String d(String str, int i4, int i5) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i6 = 0; i6 < i5; i6++) {
                int e4 = e(i4);
                int i7 = e4 % length;
                i4 = e(e4);
                int i8 = i4 % length;
                char charAt = stringBuffer.charAt(i7);
                stringBuffer.setCharAt(i7, stringBuffer.charAt(i8));
                stringBuffer.setCharAt(i8, charAt);
            }
            return stringBuffer.toString();
        }

        private int e(int i4) {
            return (int) (((i4 * this.f8931b) + this.f8932c) & 2147483647L);
        }

        private String f(int i4, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.f8930a.length();
            int length2 = str.length();
            for (int i5 = 0; i5 < length2; i5++) {
                int b4 = b(str.charAt(i5));
                if (b4 < 0) {
                    break;
                }
                sb.append(a(((b4 + i4) + i5) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public final String c(int i4, String str) {
            return f(i4, str);
        }

        public a() {
            this((byte) 0);
        }

        private a(byte b4) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }
    }
}
