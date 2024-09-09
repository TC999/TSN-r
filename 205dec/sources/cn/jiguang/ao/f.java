package cn.jiguang.ao;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static long f2336a = 1;

    public static long a() {
        long j4 = f2336a + 1;
        f2336a = j4;
        if (j4 >= 2147483647L) {
            f2336a = 1L;
        }
        return f2336a;
    }

    public static byte[] a(long j4, String str) {
        cn.jiguang.bc.a aVar = new cn.jiguang.bc.a(20480);
        aVar.a(0);
        aVar.a(j4);
        if (str != null && !TextUtils.isEmpty(str)) {
            aVar.a(cn.jiguang.ah.d.d(str));
        }
        return aVar.a();
    }
}
