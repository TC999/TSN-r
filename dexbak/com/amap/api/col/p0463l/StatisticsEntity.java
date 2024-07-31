package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;

/* renamed from: com.amap.api.col.3l.f7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class StatisticsEntity {

    /* renamed from: a */
    private Context f4162a;

    /* renamed from: b */
    private String f4163b;

    /* renamed from: c */
    private String f4164c;

    /* renamed from: d */
    private String f4165d;

    /* renamed from: e */
    private String f4166e;

    public StatisticsEntity(Context context, String str, String str2, String str3) throws AMapCoreException {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f4162a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f4164c = str;
            this.f4165d = str2;
            this.f4163b = str3;
            return;
        }
        throw new AMapCoreException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: c */
    private static byte[] m55023c(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: d */
    private byte[] m55022d(String str) {
        byte[] m54189o;
        if (!TextUtils.isEmpty(str) && (m54189o = C1925p4.m54189o(this.f4166e)) != null) {
            return C1925p4.m54190n(m54189o.length);
        }
        return new byte[]{0, 0};
    }

    /* renamed from: a */
    public final void m55025a(String str) throws AMapCoreException {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f4166e = str;
            return;
        }
        throw new AMapCoreException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: b */
    public final byte[] m55024b() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            C1925p4.m54193k(byteArrayOutputStream, this.f4164c);
            C1925p4.m54193k(byteArrayOutputStream, this.f4165d);
            C1925p4.m54193k(byteArrayOutputStream, this.f4163b);
            C1925p4.m54193k(byteArrayOutputStream, String.valueOf(DeviceInfo.m54809M(this.f4162a)));
            try {
                i = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(m55023c(i));
            byteArrayOutputStream.write(m55022d(this.f4166e));
            byteArrayOutputStream.write(C1925p4.m54189o(this.f4166e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                SDKLogHandler.m53863p(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return bArr;
            } catch (Throwable th4) {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th4;
            }
        }
        return bArr;
    }
}
