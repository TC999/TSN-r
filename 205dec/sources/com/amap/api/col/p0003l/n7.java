package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsHeaderDataStrategy.java */
/* renamed from: com.amap.api.col.3l.n7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n7 extends p7 {

    /* renamed from: d  reason: collision with root package name */
    public static int f8430d = 13;

    /* renamed from: e  reason: collision with root package name */
    public static int f8431e = 6;

    /* renamed from: c  reason: collision with root package name */
    private Context f8432c;

    public n7(Context context, p7 p7Var) {
        super(p7Var);
        this.f8432c = context;
    }

    private static byte[] d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            q4.k(byteArrayOutputStream, "1.2." + f8430d + "." + f8431e);
            q4.k(byteArrayOutputStream, "Android");
            q4.k(byteArrayOutputStream, i4.P());
            q4.k(byteArrayOutputStream, i4.I());
            q4.k(byteArrayOutputStream, i4.F(context));
            q4.k(byteArrayOutputStream, Build.MANUFACTURER);
            q4.k(byteArrayOutputStream, Build.MODEL);
            q4.k(byteArrayOutputStream, Build.DEVICE);
            q4.k(byteArrayOutputStream, i4.U());
            q4.k(byteArrayOutputStream, e4.g(context));
            q4.k(byteArrayOutputStream, e4.h(context));
            q4.k(byteArrayOutputStream, e4.j(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }

    @Override // com.amap.api.col.p0003l.p7
    protected final byte[] b(byte[] bArr) {
        byte[] d4 = d(this.f8432c);
        byte[] bArr2 = new byte[d4.length + bArr.length];
        System.arraycopy(d4, 0, bArr2, 0, d4.length);
        System.arraycopy(bArr, 0, bArr2, d4.length, bArr.length);
        return bArr2;
    }
}
