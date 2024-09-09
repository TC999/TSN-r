package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ThreadLocalCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal<>();
    private static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal<>();
    private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<>();

    private static char[] allocate(int i4) {
        if (i4 > 131072) {
            return new char[i4];
        }
        char[] cArr = new char[getAllocateLengthExp(10, 17, i4)];
        charsBufLocal.set(new SoftReference<>(cArr));
        return cArr;
    }

    private static byte[] allocateBytes(int i4) {
        if (i4 > 131072) {
            return new byte[i4];
        }
        byte[] bArr = new byte[getAllocateLengthExp(10, 17, i4)];
        bytesBufLocal.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    private static int getAllocateLengthExp(int i4, int i5, int i6) {
        return (i6 >>> i4) <= 0 ? 1 << i4 : 1 << (32 - Integer.numberOfLeadingZeros(i6 - 1));
    }

    public static byte[] getBytes(int i4) {
        SoftReference<byte[]> softReference = bytesBufLocal.get();
        if (softReference == null) {
            return allocateBytes(i4);
        }
        byte[] bArr = softReference.get();
        if (bArr == null) {
            return allocateBytes(i4);
        }
        return bArr.length < i4 ? allocateBytes(i4) : bArr;
    }

    public static char[] getChars(int i4) {
        SoftReference<char[]> softReference = charsBufLocal.get();
        if (softReference == null) {
            return allocate(i4);
        }
        char[] cArr = softReference.get();
        if (cArr == null) {
            return allocate(i4);
        }
        return cArr.length < i4 ? allocate(i4) : cArr;
    }

    public static CharsetDecoder getUTF8Decoder() {
        ThreadLocal<CharsetDecoder> threadLocal = decoderLocal;
        CharsetDecoder charsetDecoder = threadLocal.get();
        if (charsetDecoder == null) {
            UTF8Decoder uTF8Decoder = new UTF8Decoder();
            threadLocal.set(uTF8Decoder);
            return uTF8Decoder;
        }
        return charsetDecoder;
    }
}
