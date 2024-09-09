package cn.jiguang.as;

import android.content.Context;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends cn.jiguang.ah.b {

    /* renamed from: a  reason: collision with root package name */
    private static g f2421a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2422b;

    private JSONArray a(List<cn.jiguang.common.m.d> list) {
        JSONObject d4;
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.common.m.d dVar : list) {
            if (dVar.f3500f != 0 && (d4 = dVar.d(128)) != null) {
                jSONArray.put(d4);
            }
        }
        return jSONArray;
    }

    public static g d() {
        if (f2421a == null) {
            synchronized (g.class) {
                if (f2421a == null) {
                    f2421a = new g();
                }
            }
        }
        return f2421a;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2422b = context;
        return "JAppSdk";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1103)) {
            return;
        }
        cn.jiguang.w.a.b("JAppSdk", "doBusiness");
        try {
            List<cn.jiguang.common.m.d> a4 = cn.jiguang.common.n.d.a(context, true, false);
            if (a4 != null && !a4.isEmpty()) {
                JSONArray a5 = a(a4);
                if (a5 != null && a5.length() != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", a5);
                    cn.jiguang.ah.d.a(context, jSONObject, "app_sdk");
                    cn.jiguang.ah.d.a(context, (Object) jSONObject);
                    super.c(context, str);
                    return;
                }
                cn.jiguang.w.a.f("JAppSdk", "there are no third applist ");
                return;
            }
            cn.jiguang.w.a.f("JAppSdk", "there are no data to report");
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JAppSdk", "package json exception:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        return cn.jiguang.ar.a.a().e(1103);
    }
}
