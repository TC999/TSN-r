package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61385a;

    /* renamed from: b  reason: collision with root package name */
    private Class f61386b;

    /* renamed from: c  reason: collision with root package name */
    private Object f61387c;

    /* renamed from: d  reason: collision with root package name */
    private Method f61388d;

    public b1(Context context) {
        this.f61385a = context;
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "1ee9f2", new byte[]{35, 104, 27, 3, 88, 43, 54, 86, 59, 96, 36, 41, 31, 73, 23, 44, 63, 84, 56, 39, 9, 99, 38, 95, 86, 51, 59, 64, 49, 123, 9, 106, 6, 65}));
            this.f61386b = cls;
            this.f61387c = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.f61388d = this.f61386b.getMethod((String) pblk.a(16777217, 0, 0L, "f77a35", new byte[]{112, 48, 80, 58, 45, 11, 65}), Context.class);
        } catch (Exception unused2) {
        }
    }

    public String a() {
        Context context = this.f61385a;
        Method method = this.f61388d;
        Object obj = this.f61387c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
