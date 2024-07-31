package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.DiskLruCache;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3l.h7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Utils {
    /* renamed from: a */
    public static LogConfig m54750a(WeakReference<LogConfig> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new LogConfig());
        }
        return weakReference.get();
    }

    /* renamed from: b */
    public static String m54749b() {
        return C1925p4.m54202b(System.currentTimeMillis());
    }

    /* renamed from: c */
    public static String m54748c(Context context, SDKInfo sDKInfo) {
        StringBuilder sb = new StringBuilder();
        try {
            String m54819C = DeviceInfo.m54819C();
            sb.append("\"sim\":\"");
            sb.append(m54819C);
            sb.append("\",\"sdkversion\":\"");
            sb.append(sDKInfo.m54395f());
            sb.append("\",\"product\":\"");
            sb.append(sDKInfo.m54400a());
            sb.append("\",\"ed\":\"");
            sb.append(sDKInfo.m54394g());
            sb.append("\",\"nt\":\"");
            sb.append(DeviceInfo.m54759y(context));
            sb.append("\",\"np\":\"");
            sb.append(DeviceInfo.m54761w(context));
            sb.append("\",\"mnc\":\"");
            sb.append(DeviceInfo.m54820B());
            sb.append("\",\"ant\":\"");
            sb.append(DeviceInfo.m54821A(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static String m54747d(String str, String str2, int i, String str3, String str4) {
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
    public static String m54746e(String str, String str2, String str3, String str4) {
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

    /* renamed from: f */
    public static void m54745f(Context context, LogConfig logConfig, String str, int i, int i2, String str2) {
        logConfig.f3554a = Log.m54106i(context, str);
        logConfig.f3557d = i;
        logConfig.f3555b = i2;
        logConfig.f3556c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static byte[] m54744g(DiskLruCache diskLruCache, String str) {
        DiskLruCache.C1858e c1858e;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            c1858e = diskLruCache.m54504a(str);
            if (c1858e == null) {
                if (c1858e != null) {
                    try {
                        c1858e.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream m54479a = c1858e.m54479a();
                if (m54479a == null) {
                    if (m54479a != null) {
                        try {
                            m54479a.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        c1858e.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[m54479a.available()];
                m54479a.read(bArr);
                try {
                    m54479a.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    c1858e.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    SDKLogHandler.m53863p(th, "sui", "rdS");
                    return bArr;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (c1858e != null) {
                        try {
                            c1858e.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            c1858e = null;
        }
    }
}
