package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.r2;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Utils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i3 {
    public static c3 a(WeakReference<c3> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new c3());
        }
        return weakReference.get();
    }

    public static String b() {
        return j1.b(System.currentTimeMillis());
    }

    public static String c(Context context, i1 i1Var) {
        StringBuilder sb = new StringBuilder();
        try {
            String v3 = c1.v();
            sb.append("\"sim\":\"");
            sb.append(v3);
            sb.append("\",\"sdkversion\":\"");
            sb.append(i1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(i1Var.d());
            sb.append("\",\"ed\":\"");
            sb.append(i1Var.g());
            sb.append("\",\"nt\":\"");
            sb.append(c1.r(context));
            sb.append("\",\"np\":\"");
            sb.append(c1.p(context));
            sb.append("\",\"mnc\":\"");
            sb.append(c1.u());
            sb.append("\",\"ant\":\"");
            sb.append(c1.t(context));
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

    public static void e(Context context, c3 c3Var, String str, int i4, int i5, String str2) {
        c3Var.f9699a = e2.i(context, str);
        c3Var.f9702d = i4;
        c3Var.f9700b = i5;
        c3Var.f9701c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] f(r2 r2Var, String str) {
        r2.e eVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVar = r2Var.a(str);
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
                    g2.o(th, "sui", "rdS");
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
