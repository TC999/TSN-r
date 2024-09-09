package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsEntity.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g3 {

    /* renamed from: a  reason: collision with root package name */
    private Context f9864a;

    /* renamed from: b  reason: collision with root package name */
    private String f9865b;

    /* renamed from: c  reason: collision with root package name */
    private String f9866c;

    /* renamed from: d  reason: collision with root package name */
    private String f9867d;

    /* renamed from: e  reason: collision with root package name */
    private String f9868e;

    public g3(Context context, String str, String str2, String str3) throws bv {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f9864a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9866c = str;
            this.f9867d = str2;
            this.f9865b = str3;
            return;
        }
        throw new bv("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    private static byte[] c(int i4) {
        return new byte[]{(byte) ((i4 >> 24) & 255), (byte) ((i4 >> 16) & 255), (byte) ((i4 >> 8) & 255), (byte) (i4 & 255)};
    }

    private byte[] d(String str) {
        byte[] o4;
        if (!TextUtils.isEmpty(str) && (o4 = j1.o(this.f9868e)) != null) {
            return j1.n(o4.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(String str) throws bv {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f9868e = str;
            return;
        }
        throw new bv("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    public final byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i4 = 0;
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
            j1.k(byteArrayOutputStream, this.f9866c);
            j1.k(byteArrayOutputStream, this.f9867d);
            j1.k(byteArrayOutputStream, this.f9865b);
            j1.k(byteArrayOutputStream, String.valueOf(c1.D(this.f9864a)));
            try {
                i4 = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(c(i4));
            byteArrayOutputStream.write(d(this.f9868e));
            byteArrayOutputStream.write(j1.o(this.f9868e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                g2.o(th, "se", "tds");
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
