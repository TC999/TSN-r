package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.col.p047s.C2129r2;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Utils.java */
/* renamed from: com.amap.api.col.s.i3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2076i3 {
    /* renamed from: a */
    public static C2032c3 m52901a(WeakReference<C2032c3> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new C2032c3());
        }
        return weakReference.get();
    }

    /* renamed from: b */
    public static String m52900b() {
        return C2079j1.m52875b(System.currentTimeMillis());
    }

    /* renamed from: c */
    public static String m52899c(Context context, C2073i1 c2073i1) {
        StringBuilder sb = new StringBuilder();
        try {
            String m53152v = C2023c1.m53152v();
            sb.append("\"sim\":\"");
            sb.append(m53152v);
            sb.append("\",\"sdkversion\":\"");
            sb.append(c2073i1.m52916f());
            sb.append("\",\"product\":\"");
            sb.append(c2073i1.m52918d());
            sb.append("\",\"ed\":\"");
            sb.append(c2073i1.m52915g());
            sb.append("\",\"nt\":\"");
            sb.append(C2023c1.m53156r(context));
            sb.append("\",\"np\":\"");
            sb.append(C2023c1.m53158p(context));
            sb.append("\",\"mnc\":\"");
            sb.append(C2023c1.m53153u());
            sb.append("\",\"ant\":\"");
            sb.append(C2023c1.m53154t(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static String m52898d(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    /* renamed from: e */
    public static void m52897e(Context context, C2032c3 c2032c3, String str, int i, int i2, String str2) {
        c2032c3.f5971a = C2051e2.m53017i(context, str);
        c2032c3.f5974d = i;
        c2032c3.f5972b = i2;
        c2032c3.f5973c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static byte[] m52896f(C2129r2 c2129r2, String str) {
        C2129r2.C2135e c2135e;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            c2135e = c2129r2.m52616a(str);
            if (c2135e == null) {
                if (c2135e != null) {
                    try {
                        c2135e.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream m52591a = c2135e.m52591a();
                if (m52591a == null) {
                    if (m52591a != null) {
                        try {
                            m52591a.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        c2135e.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[m52591a.available()];
                m52591a.read(bArr);
                try {
                    m52591a.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    c2135e.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    C2060g2.m52972o(th, "sui", "rdS");
                    return bArr;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (c2135e != null) {
                        try {
                            c2135e.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            c2135e = null;
        }
    }
}
