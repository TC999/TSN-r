package cn.jiguang.bm;

import android.content.Context;
import android.os.Bundle;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2755a = cn.jiguang.bp.d.b(new byte[]{83, 78, 55, 98, Byte.MAX_VALUE, 118, 69, 65, 119, 111, 56, 123, 95, 80, 124, 122, 119, 101, 85, 14, 123, 38, 119});

    /* renamed from: g  reason: collision with root package name */
    private static g f2756g;

    /* renamed from: b  reason: collision with root package name */
    private final String f2757b = "JOperateLocalHelper";

    /* renamed from: c  reason: collision with root package name */
    private boolean f2758c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f2759d;

    /* renamed from: e  reason: collision with root package name */
    private Method f2760e;

    /* renamed from: f  reason: collision with root package name */
    private Context f2761f;

    private g(Context context) {
        this.f2758c = false;
        if (this.f2759d != null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(f2755a);
            this.f2759d = cls;
            this.f2760e = cls.getDeclaredMethod("a", Context.class, Integer.TYPE, Bundle.class);
            this.f2761f = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f2758c = true;
        } catch (Throwable unused) {
            cn.jiguang.bp.h.a("JOperateLocalHelper", "init hasClass: " + this.f2758c);
        }
    }

    public static g a(Context context) {
        if (f2756g == null) {
            synchronized (g.class) {
                if (f2756g == null) {
                    f2756g = new g(context);
                }
            }
        }
        return f2756g;
    }

    public String a() {
        try {
            if (this.f2758c) {
                return String.valueOf(this.f2760e.invoke(null, this.f2761f, 3, null));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
