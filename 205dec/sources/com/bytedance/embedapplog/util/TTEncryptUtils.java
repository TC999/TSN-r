package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.be;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTEncryptUtils {
    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e4) {
            be.w(e4);
        }
    }

    public static byte[] a(byte[] bArr, int i4) {
        try {
            return ttEncrypt(bArr, i4);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i4);
}
