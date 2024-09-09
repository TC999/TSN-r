package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class y extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Method[] declaredMethods;
        Throwable b4 = m1.a().b();
        if (b4 == null) {
            return null;
        }
        StackTraceElement[] stackTrace = b4.getStackTrace();
        if (stackTrace.length < 4) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 1; i5 < 4; i5++) {
            if (stackTrace[i5] != null && !TextUtils.isEmpty(stackTrace[i5].getClassName())) {
                Class<?> cls = Class.forName(stackTrace[i5].getClassName());
                m1 a4 = m1.a();
                String methodName = stackTrace[i5].getMethodName();
                a4.getClass();
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(methodName)) {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && method.getName().equals(methodName)) {
                            arrayList2.add(method);
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }
}
