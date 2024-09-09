package cn.jiguang.ah;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class b {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends e {

        /* renamed from: b  reason: collision with root package name */
        private Context f2226b;

        /* renamed from: c  reason: collision with root package name */
        private String f2227c;

        /* renamed from: e  reason: collision with root package name */
        private Bundle f2228e;

        a(Context context, String str, Bundle bundle) {
            this.f2226b = context;
            this.f2227c = str;
            this.f2228e = bundle;
            this.f2244d = str + "#BundleAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            try {
                b.this.a(this.f2226b, this.f2227c, this.f2228e);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommon", "BundleAction failed:" + th.getMessage());
            }
        }
    }

    /* renamed from: cn.jiguang.ah.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0050b extends e {

        /* renamed from: b  reason: collision with root package name */
        private Context f2230b;

        /* renamed from: c  reason: collision with root package name */
        private String f2231c;

        C0050b(Context context, String str) {
            this.f2230b = context;
            this.f2231c = str;
            this.f2244d = str + "#CommonAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            try {
                b.this.f(this.f2230b, this.f2231c);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommon", "tag=" + this.f2231c + " dealAction failed:" + th.getMessage());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends e {

        /* renamed from: b  reason: collision with root package name */
        private Context f2233b;

        /* renamed from: c  reason: collision with root package name */
        private String f2234c;

        /* renamed from: e  reason: collision with root package name */
        private JSONObject f2235e;

        c(Context context, String str, JSONObject jSONObject) {
            this.f2233b = context;
            this.f2234c = str;
            this.f2235e = jSONObject;
            this.f2244d = str + "#JsonAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            try {
                b.this.a(this.f2233b, this.f2234c, this.f2235e);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommon", "JsonAction-deal failed:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle) {
        a(str, bundle);
        boolean a_ = a_();
        cn.jiguang.w.a.b("JCommon", str + " isActionBundleEnable:" + a_);
        if (a_) {
            b(context, str);
            c(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, JSONObject jSONObject) {
        a(str, jSONObject);
        if (jSONObject.optInt("cmd") != 45) {
            boolean b4 = b();
            cn.jiguang.w.a.b("JCommon", str + " isActionCommandEnable:" + b4);
            if (b4) {
                b(context, str);
                c(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, String str) {
        boolean a4 = a(context, str);
        cn.jiguang.w.a.b("JCommon", str + " isBusinessEnable:" + a4);
        if (a4) {
            cn.jiguang.ar.a.a().a(str);
            b(context, str);
        }
        boolean d4 = d(context, str);
        cn.jiguang.w.a.b("JCommon", str + " isReportEnable:" + d4);
        if (d4) {
            c(context, str);
        }
    }

    private boolean g(Context context, String str) {
        boolean c4 = c();
        boolean b4 = b();
        boolean b5 = b(context);
        boolean e4 = e(context, str);
        boolean z3 = c4 && b4 && b5 && e4;
        cn.jiguang.w.a.b("JCommon", str + " isActionEnable:" + z3 + ",actionUserEnable:" + c4 + ",actionCommandEnable:" + b4 + ",actionUidEnable:" + b5 + ",actionProtectionEnable:" + e4);
        return z3;
    }

    protected abstract String a(Context context);

    public void a(Context context, Bundle bundle) {
        String a4 = a(context);
        cn.jiguang.w.a.b("JCommon", "executeBundleAction: [" + a4 + "] from bundle");
        boolean c4 = c();
        cn.jiguang.w.a.b("JCommon", a4 + " isActionUserEnable:" + c4);
        if (c4) {
            d.a(new a(context, a4, bundle));
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        String a4 = a(context);
        cn.jiguang.w.a.b("JCommon", "executeJsonAction: [" + a4 + "] from cmd");
        boolean c4 = c();
        cn.jiguang.w.a.b("JCommon", a4 + " isActionUserEnable:" + c4);
        if (c4) {
            d.a(new c(context, a4, jSONObject));
        }
    }

    protected void a(String str, Bundle bundle) {
        if (bundle != null) {
            cn.jiguang.w.a.b("JCommon", str + " parseJson:" + bundle.toString());
        }
    }

    protected void a(String str, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Context context, String str) {
        return cn.jiguang.ah.c.a(context, str);
    }

    protected boolean a_() {
        return true;
    }

    public void b(Context context, int i4) {
        String a4 = a(context);
        cn.jiguang.w.a.b("JCommon", "executeActionSingle: [" + a4 + "] from heartBeat, will delay " + i4 + "ms execute");
        boolean g4 = g(context, a4);
        boolean a5 = a(context, a4);
        boolean d4 = d(context, a4);
        cn.jiguang.w.a.b("JCommon", a4 + " isActionEnable:" + g4 + ", isBusinessEnable:" + a5 + ", reportEnable:" + d4);
        if (g4) {
            if (a5 || d4) {
                if (i4 > 0) {
                    d.a(new C0050b(context, a4), i4);
                } else {
                    d.a(new C0050b(context, a4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, String str) {
        cn.jiguang.ah.c.e(context, str);
    }

    public void b(Context context, JSONObject jSONObject) {
        String a4 = a(context);
        cn.jiguang.w.a.b("JCommon", "executeCommandActionSingle: [" + a4 + "] from cmd");
        boolean c4 = c();
        cn.jiguang.w.a.b("JCommon", a4 + " isActionUserEnable:" + c4);
        if (c4) {
            d.a(new c(context, a4, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    protected boolean b(Context context) {
        return d.c(context) > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, String str) {
        cn.jiguang.ah.c.h(context, str);
    }

    protected boolean c() {
        return true;
    }

    public Object d(Context context) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Context context, String str) {
        return cn.jiguang.ah.c.c(context, str);
    }

    public void e(Context context) {
        try {
            String a4 = a(context);
            cn.jiguang.w.a.b("JCommon", "executeAction: [" + a4 + "] from heartBeat");
            boolean g4 = g(context, a4);
            boolean a5 = a(context, a4);
            boolean d4 = d(context, a4);
            cn.jiguang.w.a.b("JCommon", a4 + " - isActionEnable:" + g4 + ", isBusinessEnable:" + a5 + ", reportEnable:" + d4);
            if (g4) {
                if (a5 || d4) {
                    d.a(new C0050b(context, a4));
                }
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JCommon", "executeAction failed, error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(Context context, String str) {
        if (Math.abs((d.i(context) * 1000) - d.f(context)) < cn.jiguang.ar.a.a().c(str)) {
            cn.jiguang.w.a.b("JCommon", "isProtectionTime is false");
            return false;
        }
        cn.jiguang.w.a.b("JCommon", "isProtectionTime is true");
        return true;
    }

    public void f(Context context) {
        String a4 = a(context);
        cn.jiguang.w.a.b("JCommon", "executeCommandAction: [" + a4 + "] from cmd");
        boolean g4 = g(context, a4);
        cn.jiguang.w.a.b("JCommon", a4 + " - isActionEnable:" + g4);
        if (g4) {
            d.a(new C0050b(context, a4));
        }
    }
}
