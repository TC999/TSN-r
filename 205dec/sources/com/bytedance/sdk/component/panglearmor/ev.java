package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ev f30005c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f30006w;
    private static r xv;

    private ev() {
    }

    public static void c(r rVar) {
        xv = rVar;
    }

    public byte[] w(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || !f30006w) {
            return null;
        }
        return SoftDecTool.bc(1011, bArr);
    }

    public static ev c() {
        if (f30005c == null) {
            synchronized (ev.class) {
                if (f30005c == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    System.loadLibrary("panglearmor");
                    f30006w = true;
                    f30005c = new ev();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    r rVar = xv;
                    if (rVar != null) {
                        rVar.c(currentTimeMillis2 - currentTimeMillis, f30006w);
                    }
                }
            }
        }
        return f30005c;
    }

    public static boolean w() {
        return f30006w;
    }

    public byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || !f30006w) {
            return null;
        }
        return SoftDecTool.bc(1010, bArr);
    }

    public String c(String str) {
        if (str == null || str.length() == 0 || !f30006w) {
            return null;
        }
        try {
            byte[] w3 = w(Base64.decode(str, 0));
            if (w3 != null) {
                return new String(w3);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
