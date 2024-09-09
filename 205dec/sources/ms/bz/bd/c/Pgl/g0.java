package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        double d4;
        Context c4 = pgla.a().c();
        try {
            Class<?> cls = Class.forName(new String(pbly.d((String) pblk.a(16777217, 0, 0L, "12c726", new byte[]{118, 99, 70, 69, 91, 37, 96, 22, 100, 54, 118, 53, 70, 23, 90, 115, 100, 21, 100, 62, 118, 100, 66, 70, 91, 120, 100, 22, 101, 51, 118, 101, 71, 17, 91, 36, 100, 66, 100, 100, 114, 53, 70, 69, 90, 114, 96, 22, 103, 55, 118, 54, 71, 20, 91, 116, 101, 65, 103, 55, 119, 98, 70, 69, 91, 119, 100, 74, 100, 100, 118, 101}))));
            Object newInstance = cls.getConstructor(Context.class).newInstance(c4);
            Method declaredMethod = cls.getDeclaredMethod(new String(pbly.d((String) pblk.a(16777217, 0, 0L, "b8de95", new byte[]{37, 109, 65, 68, 81, 118, 53, 72, 98, 99, 37, 111, 64, 67, 80, 115, 55, 78, 99, 96, 38, 106, 65, 23, 81, 117, 55, 76, 98, 103}))), String.class);
            declaredMethod.setAccessible(true);
            Object[] objArr = new Object[1];
            objArr[0] = new String(pbly.d((String) pblk.a(16777217, 0, 0L, "96e42f", new byte[]{126, 102, 64, 17, 90, 37, 109, 67, 98, 49, Byte.MAX_VALUE, 102, 65, 25, 95, 116, 108, 68, 98, 53, Byte.MAX_VALUE, 100, 64, 17, 91, 34, 108, 78, 99, 48, Byte.MAX_VALUE, 109})));
            d4 = ((Double) declaredMethod.invoke(newInstance, objArr)).doubleValue();
        } catch (Throwable unused) {
            d4 = 0.0d;
        }
        return Integer.toString((int) d4);
    }
}
