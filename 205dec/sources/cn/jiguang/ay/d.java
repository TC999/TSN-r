package cn.jiguang.ay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f2487c;

    /* renamed from: a  reason: collision with root package name */
    private Context f2488a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f2489b;

    private boolean a(JSONObject jSONObject) {
        String k4 = cn.jiguang.ah.c.k(this.f2488a);
        if (TextUtils.isEmpty(k4)) {
            cn.jiguang.w.a.b("JDeviceIds", "ids cache is empty");
        } else {
            try {
                return !k4.equals(cn.jiguang.ah.d.b(jSONObject.toString()));
            } catch (Exception e4) {
                cn.jiguang.w.a.f("JDeviceIds", "[checkIdsChanged] toHash error: " + e4.getMessage());
            }
        }
        return true;
    }

    public static d d() {
        if (f2487c == null) {
            synchronized (d.class) {
                if (f2487c == null) {
                    f2487c = new d();
                }
            }
        }
        return f2487c;
    }

    private void e() {
        try {
            Object obj = this.f2489b.get("data");
            if (obj != null) {
                String b4 = cn.jiguang.ah.d.b(cn.jiguang.ah.d.f(obj.toString()));
                cn.jiguang.ah.c.v(this.f2488a, b4);
                cn.jiguang.w.a.b("JDeviceIds", "device ids refresh cache success, hash-ids: " + b4);
            }
        } catch (Exception e4) {
            cn.jiguang.w.a.f("JDeviceIds", "ids encrypted failed, err: " + e4.getMessage());
        }
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2488a = context;
        return "JDeviceIds";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        String str2;
        if (cn.jiguang.ar.a.a().g(1900)) {
            return;
        }
        try {
            JSONObject a4 = cn.jiguang.bd.a.a(context);
            if (a4 == null) {
                cn.jiguang.w.a.f("JDeviceIds", "ids collect failed");
            } else if (!a(a4)) {
                cn.jiguang.w.a.b("JDeviceIds", "ids not changed, need not report");
            } else {
                try {
                    str2 = cn.jiguang.ah.d.e(a4.toString());
                } catch (Exception e4) {
                    cn.jiguang.w.a.f("JDeviceIds", "ids encrypted failed, err: " + e4.getMessage());
                    str2 = "";
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (this.f2489b == null) {
                    this.f2489b = new JSONObject();
                }
                this.f2489b.put("data", str2);
                cn.jiguang.w.a.b("JDeviceIds", "collect success:" + this.f2489b + ", origin ids: " + a4.toString());
                super.b(context, str);
            }
        } catch (JSONException e5) {
            cn.jiguang.w.a.f("JDeviceIds", "packageJson exception: " + e5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1900)) {
            return;
        }
        JSONObject jSONObject = this.f2489b;
        if (jSONObject == null) {
            cn.jiguang.w.a.f("JDeviceIds", "there are no data to report");
            return;
        }
        cn.jiguang.ah.d.a(context, jSONObject, "sdk_joa");
        cn.jiguang.ah.d.a(context, (Object) this.f2489b);
        super.c(context, str);
        e();
        cn.jiguang.w.a.b("JDeviceIds", str + "report success, reportData: " + this.f2489b);
        this.f2489b = null;
    }
}
