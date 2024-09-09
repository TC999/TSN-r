package ms.bz.bd.c.Pgl;

import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class pbli extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "88e415", new byte[]{42, 53, 27, 14, 29, 49, 117, 24, 58, 96, 59, 53, 31, 68, 64, 55, 60, 26, 122, 117, 60, 53, 2, 65, 64, 0, 31, 55, 49, 112, 62, 53, 4, 75, 58, 35, 60, 58, 59, 106, 61, 63, 14, 84, 62, 48, 52, 15, 61, 96, 44, 40, 55, 68, 15, 50, 47, 28, 38}));
            Method declaredMethod = cls.getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "dc824b", new byte[]{120, 96, 89, 77, 42, 102, 73, 71, 126, 87, 102, 100, 89}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object newInstance = cls.newInstance();
            if (newInstance != null ? ((Boolean) declaredMethod.invoke(newInstance, new Object[0])).booleanValue() : false) {
                return (String) pblk.a(16777217, 0, 0L, "401654", new byte[]{43, 55, 85, 119, 25, 38, 37});
            }
            return null;
        } catch (Throwable unused) {
            String str2 = (String) pblk.a(16777217, 0, 0L, "d2d8d5", new byte[]{114, 49, 17});
            return null;
        }
    }
}
