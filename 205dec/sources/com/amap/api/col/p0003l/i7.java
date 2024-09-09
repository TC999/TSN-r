package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.n6;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Utils.java */
/* renamed from: com.amap.api.col.3l.i7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i7 {
    public static b7 a(WeakReference<b7> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new b7());
        }
        return weakReference.get();
    }

    public static String b() {
        return q4.b(System.currentTimeMillis());
    }

    public static String c(Context context, p4 p4Var) {
        StringBuilder sb = new StringBuilder();
        try {
            String C = i4.C();
            sb.append("\"sim\":\"");
            sb.append(C);
            sb.append("\",\"sdkversion\":\"");
            sb.append(p4Var.f());
            sb.append("\",\"product\":\"");
            sb.append(p4Var.a());
            sb.append("\",\"ed\":\"");
            sb.append(p4Var.g());
            sb.append("\",\"nt\":\"");
            sb.append(i4.y(context));
            sb.append("\",\"np\":\"");
            sb.append(i4.w(context));
            sb.append("\",\"mnc\":\"");
            sb.append(i4.B());
            sb.append("\",\"ant\":\"");
            sb.append(i4.A(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String d(String str, String str2, int i4, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i4);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String e(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(1);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static void f(Context context, b7 b7Var, String str, int i4, int i5, String str2) {
        b7Var.f7264a = r5.i(context, str);
        b7Var.f7267d = i4;
        b7Var.f7265b = i5;
        b7Var.f7266c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] g(n6 n6Var, String str) {
        n6.e eVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVar = n6Var.a(str);
            if (eVar == null) {
                if (eVar != null) {
                    try {
                        eVar.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream b4 = eVar.b();
                if (b4 == null) {
                    if (b4 != null) {
                        try {
                            b4.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        eVar.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[b4.available()];
                b4.read(bArr);
                try {
                    b4.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    eVar.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    u5.p(th, "sui", "rdS");
                    return bArr;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (eVar != null) {
                        try {
                            eVar.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            eVar = null;
        }
    }
}
