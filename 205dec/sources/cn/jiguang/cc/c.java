package cn.jiguang.cc;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.cn.g;
import java.io.File;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f3261a;

    /* renamed from: b  reason: collision with root package name */
    private int f3262b;

    /* renamed from: c  reason: collision with root package name */
    private String f3263c;

    /* renamed from: d  reason: collision with root package name */
    private String f3264d;

    /* renamed from: e  reason: collision with root package name */
    private String f3265e;

    /* renamed from: f  reason: collision with root package name */
    private long f3266f;

    /* renamed from: g  reason: collision with root package name */
    private String f3267g;

    public c a(int i4) {
        this.f3262b = i4;
        return this;
    }

    public c a(long j4) {
        this.f3266f = j4;
        return this;
    }

    public c a(String str) {
        this.f3261a = str;
        return this;
    }

    public void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", this.f3261a);
            jSONObject.put("imei", this.f3263c);
            jSONObject.put("androidId", this.f3264d);
            jSONObject.put("uuid", this.f3265e);
            jSONObject.put("genIdTimeStamp", this.f3266f);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.c().a((cn.jiguang.g.a<String>) g.a(jSONObject.toString(), cn.jiguang.a.a.f2017i)));
        } catch (Throwable unused) {
        }
    }

    public c b(String str) {
        this.f3263c = str;
        return this;
    }

    public void b(Context context) {
        File a4;
        try {
            String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c());
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.bq.d.c("RegKeyInfo", "no sp cid info");
                return;
            }
            String str2 = cn.jiguang.a.a.f2017i;
            String b4 = g.b(str, str2);
            a(cn.jiguang.cn.c.f3479a);
            JSONObject jSONObject = new JSONObject(b4);
            jSONObject.put("deviceIdFromType", this.f3262b);
            jSONObject.put("newImei", this.f3267g);
            String a5 = g.a(jSONObject.toString(), str2);
            if (!TextUtils.isEmpty(a5) && (a4 = cn.jiguang.f.c.a(context, "r_key_info")) != null) {
                cn.jiguang.f.c.c(a4, a5);
                cn.jiguang.bq.d.c("RegKeyInfo", "save reg key info success");
            }
            cn.jiguang.bq.d.c("RegKeyInfo", "save reg key info: " + jSONObject);
        } catch (Throwable unused) {
        }
    }

    public c c(String str) {
        this.f3264d = str;
        return this;
    }

    public String c(Context context) {
        String d4 = cn.jiguang.f.c.d(cn.jiguang.f.c.a(context, "r_key_info"));
        if (TextUtils.isEmpty(d4)) {
            cn.jiguang.bq.d.c("RegKeyInfo", "no reg info in cache");
            return "";
        }
        String b4 = g.b(d4, cn.jiguang.a.a.f2017i);
        cn.jiguang.bq.d.c("RegKeyInfo", "get reg key info: " + b4);
        return !TextUtils.isEmpty(b4) ? b4 : "";
    }

    public c d(String str) {
        this.f3265e = str;
        return this;
    }

    public c e(String str) {
        this.f3267g = str;
        return this;
    }

    public String toString() {
        return "RegKeyInfo{deviceId='" + this.f3261a + "', deviceIdFromType=" + this.f3262b + ", imei='" + this.f3263c + "', androidId='" + this.f3264d + "', uuid='" + this.f3265e + "', genIdTimeStamp=" + this.f3266f + ", newImei='" + this.f3267g + "'}";
    }
}
