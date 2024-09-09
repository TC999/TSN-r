package com.qq.e.comm.plugin.i0.l;

import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Character, Byte> f44290a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, Cipher> f44291b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, Cipher> f44292c = new HashMap<>();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a extends HashMap<Character, Byte> {
        a() {
            put('0', (byte) 0);
            put('1', (byte) 1);
            put('2', (byte) 2);
            put('3', (byte) 3);
            put('4', (byte) 4);
            put('5', (byte) 5);
            put('6', (byte) 6);
            put('7', (byte) 7);
            put('8', (byte) 8);
            put('9', (byte) 9);
            put('A', (byte) 10);
            put('B', (byte) 11);
            put('C', (byte) 12);
            put('D', (byte) 13);
            put('E', (byte) 14);
            put('F', (byte) 15);
            put('a', (byte) 10);
            put('b', (byte) 11);
            put('c', (byte) 12);
            put('d', (byte) 13);
            put('e', (byte) 14);
            put('f', (byte) 15);
        }
    }

    static String a(String str, String str2) throws Exception {
        return (String) pro.getobjresult(213, 1, str, str2);
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append("0123456789ABCDEF".charAt((b4 >> 4) & 15));
            sb.append("0123456789ABCDEF".charAt(b4 & 15));
        }
        return sb.toString();
    }

    static String b(String str, String str2) throws Exception {
        return (String) pro.getobjresult(214, 1, str, str2);
    }

    private static byte[] b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                bArr[i4] = (byte) ((f44290a.get(Character.valueOf(str.charAt(i5))).byteValue() << 4) | (f44290a.get(Character.valueOf(str.charAt(i5 + 1))).byteValue() & 15));
                i4++;
                i5 += 2;
            }
            return bArr;
        }
        throw new IllegalArgumentException("invalid hex encoded string");
    }

    private static byte[] a(String str) {
        return str.getBytes(com.qq.e.comm.plugin.k.a.f44515a);
    }
}
