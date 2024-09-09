package cn.jiguang.aa;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ah.b;
import cn.jiguang.ah.c;
import cn.jiguang.ah.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private Context f2026a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f2027b;

    /* renamed from: c  reason: collision with root package name */
    private String f2028c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f2029d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f2030e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f2031f = 0;

    private JSONObject a(String str, int i4, int i5) {
        int i6;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(i4);
            jSONArray.put(i5);
            if ("core".equals(str)) {
                jSONArray.put(d.d());
                i6 = this.f2031f;
            } else if (!"push".equals(str)) {
                if ("JAD".equals(str)) {
                    jSONArray.put(d.i());
                    i6 = this.f2031f;
                }
                jSONObject2.put(str, jSONArray);
                jSONObject.put("type", "sdk_type");
                jSONObject.put("itime", d.i(this.f2026a));
                jSONObject.put("sdk", jSONObject2);
                return jSONObject;
            } else {
                jSONArray.put(d.h());
                i6 = this.f2031f;
            }
            jSONArray.put(i6);
            jSONObject2.put(str, jSONArray);
            jSONObject.put("type", "sdk_type");
            jSONObject.put("itime", d.i(this.f2026a));
            jSONObject.put("sdk", jSONObject2);
            return jSONObject;
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("JType", "package json exception: " + e4.getMessage());
            return null;
        }
    }

    private static boolean a(Context context, String str, int i4, int i5, int i6) {
        if (TextUtils.isEmpty(str) || i4 < 0 || i5 < 0) {
            return false;
        }
        int q3 = c.q(context, str);
        cn.jiguang.w.a.b("JType", "[isTypeReportEnable],lastversion:" + q3 + ",curversion:" + i6 + ",type:" + str);
        if (q3 != i6) {
            return true;
        }
        String p3 = c.p(context, str);
        return !p3.equals(i4 + "," + i5);
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2026a = context;
        return "JType";
    }

    @Override // cn.jiguang.ah.b
    protected void a(String str, Bundle bundle) {
        this.f2027b = bundle;
    }

    @Override // cn.jiguang.ah.b
    protected boolean a_() {
        Bundle bundle = this.f2027b;
        if (bundle == null) {
            return false;
        }
        this.f2028c = bundle.getString("name");
        this.f2029d = this.f2027b.getInt("custom", 0);
        this.f2030e = this.f2027b.getInt("dynamic", 0);
        this.f2031f = this.f2027b.getInt("sdk_v", 0);
        cn.jiguang.w.a.b("JType", "parseBundle type:" + this.f2028c + ",custom:" + this.f2029d + ",dynamic:" + this.f2030e + ",sdkVersion:" + this.f2031f);
        boolean a4 = a(this.f2026a, this.f2028c, this.f2029d, this.f2030e, this.f2031f);
        if (a4) {
            c.a(this.f2026a, this.f2028c, this.f2031f);
            c.a(this.f2026a, this.f2028c, this.f2029d + "," + this.f2030e);
        } else {
            cn.jiguang.w.a.b("JType", "type [" + this.f2028c + "] data not change");
        }
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        JSONObject a4 = a(this.f2028c, this.f2029d, this.f2030e);
        if (a4 == null) {
            cn.jiguang.w.a.f("JType", "there are no data to report");
        } else {
            d.a(context, (Object) a4);
        }
    }
}
