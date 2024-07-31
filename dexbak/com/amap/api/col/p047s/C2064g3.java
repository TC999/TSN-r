package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsEntity.java */
/* renamed from: com.amap.api.col.s.g3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2064g3 {

    /* renamed from: a */
    private Context f6136a;

    /* renamed from: b */
    private String f6137b;

    /* renamed from: c */
    private String f6138c;

    /* renamed from: d */
    private String f6139d;

    /* renamed from: e */
    private String f6140e;

    public C2064g3(Context context, String str, String str2, String str3) throws C2022bv {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f6136a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6138c = str;
            this.f6139d = str2;
            this.f6137b = str3;
            return;
        }
        throw new C2022bv("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: c */
    private static byte[] m52969c(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: d */
    private byte[] m52968d(String str) {
        byte[] m52862o;
        if (!TextUtils.isEmpty(str) && (m52862o = C2079j1.m52862o(this.f6140e)) != null) {
            return C2079j1.m52863n(m52862o.length);
        }
        return new byte[]{0, 0};
    }

    /* renamed from: a */
    public final void m52971a(String str) throws C2022bv {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f6140e = str;
            return;
        }
        throw new C2022bv("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: b */
    public final byte[] m52970b() {
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
            C2079j1.m52866k(byteArrayOutputStream, this.f6138c);
            C2079j1.m52866k(byteArrayOutputStream, this.f6139d);
            C2079j1.m52866k(byteArrayOutputStream, this.f6137b);
            C2079j1.m52866k(byteArrayOutputStream, String.valueOf(C2023c1.m53200D(this.f6136a)));
            try {
                i = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(m52969c(i));
            byteArrayOutputStream.write(m52968d(this.f6140e));
            byteArrayOutputStream.write(C2079j1.m52862o(this.f6140e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                C2060g2.m52972o(th, "se", "tds");
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
