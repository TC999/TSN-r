package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsHeaderDataStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n3 extends p3 {

    /* renamed from: d  reason: collision with root package name */
    public static int f10040d = 13;

    /* renamed from: e  reason: collision with root package name */
    public static int f10041e = 6;

    /* renamed from: c  reason: collision with root package name */
    private Context f10042c;

    public n3(Context context, p3 p3Var) {
        super(p3Var);
        this.f10042c = context;
    }

    private static byte[] d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            j1.k(byteArrayOutputStream, "1.2." + f10040d + "." + f10041e);
            j1.k(byteArrayOutputStream, "Android");
            j1.k(byteArrayOutputStream, c1.H());
            j1.k(byteArrayOutputStream, c1.C());
            j1.k(byteArrayOutputStream, c1.y(context));
            j1.k(byteArrayOutputStream, Build.MANUFACTURER);
            j1.k(byteArrayOutputStream, Build.MODEL);
            j1.k(byteArrayOutputStream, Build.DEVICE);
            j1.k(byteArrayOutputStream, c1.M());
            j1.k(byteArrayOutputStream, x0.f(context));
            j1.k(byteArrayOutputStream, x0.g(context));
            j1.k(byteArrayOutputStream, x0.i(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        byte[] d4 = d(this.f10042c);
        byte[] bArr2 = new byte[d4.length + bArr.length];
        System.arraycopy(d4, 0, bArr2, 0, d4.length);
        System.arraycopy(bArr, 0, bArr2, d4.length, bArr.length);
        return bArr2;
    }
}
