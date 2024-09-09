package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SameBase64Tool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39897a = "s";

    /* renamed from: b  reason: collision with root package name */
    private static Map<Character, Character> f39898b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f39899c;

    /* renamed from: d  reason: collision with root package name */
    private static char[] f39900d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: e  reason: collision with root package name */
    private static byte[] f39901e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        HashMap hashMap = new HashMap();
        f39899c = hashMap;
        hashMap.put('v', 'A');
        f39899c.put('S', 'B');
        f39899c.put('o', 'C');
        f39899c.put('a', 'D');
        f39899c.put('j', 'E');
        f39899c.put('c', 'F');
        f39899c.put('7', 'G');
        f39899c.put('d', 'H');
        f39899c.put('R', 'I');
        f39899c.put('z', 'J');
        f39899c.put('p', 'K');
        f39899c.put('W', 'L');
        f39899c.put('i', 'M');
        f39899c.put('f', 'N');
        f39899c.put('G', 'O');
        f39899c.put('y', 'P');
        f39899c.put('N', 'Q');
        f39899c.put('x', 'R');
        f39899c.put('Z', 'S');
        f39899c.put('n', 'T');
        f39899c.put('V', 'U');
        f39899c.put('5', 'V');
        f39899c.put('k', 'W');
        f39899c.put('+', 'X');
        f39899c.put('D', 'Y');
        f39899c.put('H', 'Z');
        f39899c.put('L', 'a');
        f39899c.put('Y', 'b');
        f39899c.put('h', 'c');
        f39899c.put('J', 'd');
        f39899c.put('4', 'e');
        f39899c.put('6', 'f');
        f39899c.put('l', 'g');
        f39899c.put('t', 'h');
        f39899c.put('0', 'i');
        f39899c.put('U', 'j');
        f39899c.put('3', 'k');
        f39899c.put('Q', 'l');
        f39899c.put('r', 'm');
        f39899c.put('g', 'n');
        f39899c.put('E', 'o');
        f39899c.put('u', 'p');
        f39899c.put('q', 'q');
        f39899c.put('8', 'r');
        f39899c.put('s', 's');
        f39899c.put('w', 't');
        f39899c.put('/', 'u');
        f39899c.put('X', 'v');
        f39899c.put('M', 'w');
        f39899c.put('e', 'x');
        f39899c.put('B', 'y');
        f39899c.put('A', 'z');
        f39899c.put('T', '0');
        f39899c.put('2', '1');
        f39899c.put('F', '2');
        f39899c.put('b', '3');
        f39899c.put('9', '4');
        f39899c.put('P', '5');
        f39899c.put('1', '6');
        f39899c.put('O', '7');
        f39899c.put('I', '8');
        f39899c.put('K', '9');
        f39899c.put('m', '+');
        f39899c.put('C', '/');
        HashMap hashMap2 = new HashMap();
        f39898b = hashMap2;
        hashMap2.put('A', 'v');
        f39898b.put('B', 'S');
        f39898b.put('C', 'o');
        f39898b.put('D', 'a');
        f39898b.put('E', 'j');
        f39898b.put('F', 'c');
        f39898b.put('G', '7');
        f39898b.put('H', 'd');
        f39898b.put('I', 'R');
        f39898b.put('J', 'z');
        f39898b.put('K', 'p');
        f39898b.put('L', 'W');
        f39898b.put('M', 'i');
        f39898b.put('N', 'f');
        f39898b.put('O', 'G');
        f39898b.put('P', 'y');
        f39898b.put('Q', 'N');
        f39898b.put('R', 'x');
        f39898b.put('S', 'Z');
        f39898b.put('T', 'n');
        f39898b.put('U', 'V');
        f39898b.put('V', '5');
        f39898b.put('W', 'k');
        f39898b.put('X', '+');
        f39898b.put('Y', 'D');
        f39898b.put('Z', 'H');
        f39898b.put('a', 'L');
        f39898b.put('b', 'Y');
        f39898b.put('c', 'h');
        f39898b.put('d', 'J');
        f39898b.put('e', '4');
        f39898b.put('f', '6');
        f39898b.put('g', 'l');
        f39898b.put('h', 't');
        f39898b.put('i', '0');
        f39898b.put('j', 'U');
        f39898b.put('k', '3');
        f39898b.put('l', 'Q');
        f39898b.put('m', 'r');
        f39898b.put('n', 'g');
        f39898b.put('o', 'E');
        f39898b.put('p', 'u');
        f39898b.put('q', 'q');
        f39898b.put('r', '8');
        f39898b.put('s', 's');
        f39898b.put('t', 'w');
        f39898b.put('u', '/');
        f39898b.put('v', 'X');
        f39898b.put('w', 'M');
        f39898b.put('x', 'e');
        f39898b.put('y', 'B');
        f39898b.put('z', 'A');
        f39898b.put('0', 'T');
        f39898b.put('1', '2');
        f39898b.put('2', 'F');
        f39898b.put('3', 'b');
        f39898b.put('4', '9');
        f39898b.put('5', 'P');
        f39898b.put('6', '1');
        f39898b.put('7', 'O');
        f39898b.put('8', 'I');
        f39898b.put('9', 'K');
        f39898b.put('+', 'm');
        f39898b.put('/', 'C');
    }

    private s() {
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : y.b(str);
    }

    public static String b(String str) {
        return y.a(str);
    }
}
