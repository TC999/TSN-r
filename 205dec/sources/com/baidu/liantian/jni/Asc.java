package com.baidu.liantian.jni;

import com.baidu.liantian.b.e;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Asc {
    static {
        try {
            System.loadLibrary("liantian");
        } catch (Throwable unused) {
            e.a();
        }
    }

    public static native String fai(String str, String str2, String str3);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native int df(String str, String str2, byte[] bArr);

    public native byte[] dr(byte[] bArr, byte[] bArr2);
}
