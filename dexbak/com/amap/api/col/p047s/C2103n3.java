package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy.java */
/* renamed from: com.amap.api.col.s.n3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2103n3 extends AbstractC2117p3 {

    /* renamed from: d */
    public static int f6312d = 13;

    /* renamed from: e */
    public static int f6313e = 6;

    /* renamed from: c */
    private Context f6314c;

    public C2103n3(Context context, AbstractC2117p3 abstractC2117p3) {
        super(abstractC2117p3);
        this.f6314c = context;
    }

    /* renamed from: d */
    private static byte[] m52732d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            C2079j1.m52866k(byteArrayOutputStream, "1.2." + f6312d + "." + f6313e);
            C2079j1.m52866k(byteArrayOutputStream, "Android");
            C2079j1.m52866k(byteArrayOutputStream, C2023c1.m53196H());
            C2079j1.m52866k(byteArrayOutputStream, C2023c1.m53201C());
            C2079j1.m52866k(byteArrayOutputStream, C2023c1.m53149y(context));
            C2079j1.m52866k(byteArrayOutputStream, Build.MANUFACTURER);
            C2079j1.m52866k(byteArrayOutputStream, Build.MODEL);
            C2079j1.m52866k(byteArrayOutputStream, Build.DEVICE);
            C2079j1.m52866k(byteArrayOutputStream, C2023c1.m53191M());
            C2079j1.m52866k(byteArrayOutputStream, C2199x0.m52330f(context));
            C2079j1.m52866k(byteArrayOutputStream, C2199x0.m52329g(context));
            C2079j1.m52866k(byteArrayOutputStream, C2199x0.m52327i(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: b */
    protected final byte[] mo52644b(byte[] bArr) {
        byte[] m52732d = m52732d(this.f6314c);
        byte[] bArr2 = new byte[m52732d.length + bArr.length];
        System.arraycopy(m52732d, 0, bArr2, 0, m52732d.length);
        System.arraycopy(bArr, 0, bArr2, m52732d.length, bArr.length);
        return bArr2;
    }
}
