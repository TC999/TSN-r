package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class u extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Context c4 = pgla.a().c();
        if (c4 != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) c4.getSystemService((String) pblk.a(16777217, 0, 0L, "a9c261", new byte[]{115, 52, 30, 72, 12, 37, 118, 17, 36, 107, 100, 34}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "996bdd", new byte[]{47, 62, 81, 55, 88, 103, 51, 14, 98, 28, 45, 47, 82, 25, 73, 120, 19, 22, 97, 61}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "4adeba", new byte[]{44, 112, 54, 7, 92, Byte.MAX_VALUE, 59, 65, 55, 57, 32}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
