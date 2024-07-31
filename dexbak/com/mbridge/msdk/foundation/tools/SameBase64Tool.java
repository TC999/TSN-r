package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* renamed from: com.mbridge.msdk.foundation.tools.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SameBase64Tool {

    /* renamed from: a */
    private static final String f31124a = "s";

    /* renamed from: b */
    private static Map<Character, Character> f31125b;

    /* renamed from: c */
    private static Map<Character, Character> f31126c;

    /* renamed from: d */
    private static char[] f31127d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: e */
    private static byte[] f31128e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, HttpConstants.EQUALS, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, BinaryMemcacheOpcodes.SETQ, BinaryMemcacheOpcodes.ADDQ, BinaryMemcacheOpcodes.REPLACEQ, BinaryMemcacheOpcodes.DELETEQ, BinaryMemcacheOpcodes.INCREMENTQ, BinaryMemcacheOpcodes.DECREMENTQ, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.APPENDQ, -1, -1, -1, -1, -1, -1, BinaryMemcacheOpcodes.PREPENDQ, 27, BinaryMemcacheOpcodes.TOUCH, BinaryMemcacheOpcodes.GAT, BinaryMemcacheOpcodes.GATQ, 31, 32, BinaryMemcacheOpcodes.SASL_AUTH, 34, BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        HashMap hashMap = new HashMap();
        f31126c = hashMap;
        hashMap.put('v', 'A');
        f31126c.put('S', 'B');
        f31126c.put('o', 'C');
        f31126c.put('a', 'D');
        f31126c.put('j', 'E');
        f31126c.put('c', 'F');
        f31126c.put('7', 'G');
        f31126c.put('d', 'H');
        f31126c.put('R', 'I');
        f31126c.put('z', 'J');
        f31126c.put('p', 'K');
        f31126c.put('W', 'L');
        f31126c.put('i', 'M');
        f31126c.put('f', 'N');
        f31126c.put('G', 'O');
        f31126c.put('y', 'P');
        f31126c.put('N', 'Q');
        f31126c.put('x', 'R');
        f31126c.put('Z', 'S');
        f31126c.put('n', 'T');
        f31126c.put('V', 'U');
        f31126c.put('5', 'V');
        f31126c.put('k', 'W');
        f31126c.put('+', 'X');
        f31126c.put('D', 'Y');
        f31126c.put('H', 'Z');
        f31126c.put('L', 'a');
        f31126c.put('Y', 'b');
        f31126c.put('h', 'c');
        f31126c.put('J', 'd');
        f31126c.put('4', 'e');
        f31126c.put('6', 'f');
        f31126c.put('l', 'g');
        f31126c.put('t', 'h');
        f31126c.put('0', 'i');
        f31126c.put('U', 'j');
        f31126c.put('3', 'k');
        f31126c.put('Q', 'l');
        f31126c.put('r', 'm');
        f31126c.put('g', 'n');
        f31126c.put('E', 'o');
        f31126c.put('u', 'p');
        f31126c.put('q', 'q');
        f31126c.put('8', 'r');
        f31126c.put('s', 's');
        f31126c.put('w', 't');
        f31126c.put('/', 'u');
        f31126c.put('X', 'v');
        f31126c.put('M', 'w');
        f31126c.put('e', 'x');
        f31126c.put('B', 'y');
        f31126c.put('A', 'z');
        f31126c.put('T', '0');
        f31126c.put('2', '1');
        f31126c.put('F', '2');
        f31126c.put('b', '3');
        f31126c.put('9', '4');
        f31126c.put('P', '5');
        f31126c.put('1', '6');
        f31126c.put('O', '7');
        f31126c.put('I', '8');
        f31126c.put('K', '9');
        f31126c.put('m', '+');
        f31126c.put('C', '/');
        HashMap hashMap2 = new HashMap();
        f31125b = hashMap2;
        hashMap2.put('A', 'v');
        f31125b.put('B', 'S');
        f31125b.put('C', 'o');
        f31125b.put('D', 'a');
        f31125b.put('E', 'j');
        f31125b.put('F', 'c');
        f31125b.put('G', '7');
        f31125b.put('H', 'd');
        f31125b.put('I', 'R');
        f31125b.put('J', 'z');
        f31125b.put('K', 'p');
        f31125b.put('L', 'W');
        f31125b.put('M', 'i');
        f31125b.put('N', 'f');
        f31125b.put('O', 'G');
        f31125b.put('P', 'y');
        f31125b.put('Q', 'N');
        f31125b.put('R', 'x');
        f31125b.put('S', 'Z');
        f31125b.put('T', 'n');
        f31125b.put('U', 'V');
        f31125b.put('V', '5');
        f31125b.put('W', 'k');
        f31125b.put('X', '+');
        f31125b.put('Y', 'D');
        f31125b.put('Z', 'H');
        f31125b.put('a', 'L');
        f31125b.put('b', 'Y');
        f31125b.put('c', 'h');
        f31125b.put('d', 'J');
        f31125b.put('e', '4');
        f31125b.put('f', '6');
        f31125b.put('g', 'l');
        f31125b.put('h', 't');
        f31125b.put('i', '0');
        f31125b.put('j', 'U');
        f31125b.put('k', '3');
        f31125b.put('l', 'Q');
        f31125b.put('m', 'r');
        f31125b.put('n', 'g');
        f31125b.put('o', 'E');
        f31125b.put('p', 'u');
        f31125b.put('q', 'q');
        f31125b.put('r', '8');
        f31125b.put('s', 's');
        f31125b.put('t', 'w');
        f31125b.put('u', '/');
        f31125b.put('v', 'X');
        f31125b.put('w', 'M');
        f31125b.put('x', 'e');
        f31125b.put('y', 'B');
        f31125b.put('z', 'A');
        f31125b.put('0', 'T');
        f31125b.put('1', '2');
        f31125b.put('2', 'F');
        f31125b.put('3', 'b');
        f31125b.put('4', '9');
        f31125b.put('5', 'P');
        f31125b.put('6', '1');
        f31125b.put('7', 'O');
        f31125b.put('8', 'I');
        f31125b.put('9', 'K');
        f31125b.put('+', 'm');
        f31125b.put('/', 'C');
    }

    private SameBase64Tool() {
    }

    /* renamed from: a */
    public static String m21813a(String str) {
        return TextUtils.isEmpty(str) ? "" : SameMVEncoder.m21729b(str);
    }

    /* renamed from: b */
    public static String m21812b(String str) {
        return SameMVEncoder.m21732a(str);
    }
}
