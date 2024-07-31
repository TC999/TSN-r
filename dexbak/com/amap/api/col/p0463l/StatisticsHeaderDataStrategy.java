package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* renamed from: com.amap.api.col.3l.m7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class StatisticsHeaderDataStrategy extends UpdateDataStrategy {

    /* renamed from: d */
    public static int f4721d = 13;

    /* renamed from: e */
    public static int f4722e = 6;

    /* renamed from: c */
    private Context f4723c;

    public StatisticsHeaderDataStrategy(Context context, UpdateDataStrategy updateDataStrategy) {
        super(updateDataStrategy);
        this.f4723c = context;
    }

    /* renamed from: d */
    private static byte[] m54465d(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            C1925p4.m54193k(byteArrayOutputStream, "1.2." + f4721d + "." + f4722e);
            C1925p4.m54193k(byteArrayOutputStream, "Android");
            C1925p4.m54193k(byteArrayOutputStream, DeviceInfo.m54806P());
            C1925p4.m54193k(byteArrayOutputStream, DeviceInfo.m54813I());
            C1925p4.m54193k(byteArrayOutputStream, DeviceInfo.m54816F(context));
            C1925p4.m54193k(byteArrayOutputStream, Build.MANUFACTURER);
            C1925p4.m54193k(byteArrayOutputStream, Build.MODEL);
            C1925p4.m54193k(byteArrayOutputStream, Build.DEVICE);
            C1925p4.m54193k(byteArrayOutputStream, DeviceInfo.m54801U());
            C1925p4.m54193k(byteArrayOutputStream, C1780e4.m55243g(context));
            C1925p4.m54193k(byteArrayOutputStream, C1780e4.m55242h(context));
            C1925p4.m54193k(byteArrayOutputStream, C1780e4.m55240j(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: b */
    protected final byte[] mo54164b(byte[] bArr) {
        byte[] m54465d = m54465d(this.f4723c);
        byte[] bArr2 = new byte[m54465d.length + bArr.length];
        System.arraycopy(m54465d, 0, bArr2, 0, m54465d.length);
        System.arraycopy(bArr, 0, bArr2, m54465d.length, bArr.length);
        return bArr2;
    }
}
