package cn.jpush.android.helper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static long f4225a = 1;

    public static long a() {
        long j4 = f4225a + 1;
        f4225a = j4;
        if (j4 >= 2147483647L) {
            f4225a = 1L;
        }
        return f4225a;
    }
}
