package cn.jiguang.bv;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f2986a;

    /* renamed from: b  reason: collision with root package name */
    public String f2987b;

    /* renamed from: c  reason: collision with root package name */
    public String f2988c;

    /* renamed from: d  reason: collision with root package name */
    public long f2989d;

    /* renamed from: e  reason: collision with root package name */
    public String f2990e;

    /* renamed from: f  reason: collision with root package name */
    public double f2991f;

    /* renamed from: g  reason: collision with root package name */
    public double f2992g;

    /* renamed from: h  reason: collision with root package name */
    public long f2993h;

    /* renamed from: i  reason: collision with root package name */
    private int f2994i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f2995j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f2996k = 0;

    public n(int i4, String str, String str2, long j4, String str3, double d4, double d5, long j5) {
        this.f2986a = i4;
        this.f2987b = str;
        this.f2988c = str2;
        this.f2989d = j4;
        this.f2990e = str3;
        this.f2991f = d4;
        this.f2992g = d5;
        this.f2993h = j5;
    }

    private static boolean a(double d4, double d5) {
        return d4 > -90.0d && d4 < 90.0d && d5 > -180.0d && d5 < 180.0d;
    }

    public n a(int i4) {
        this.f2996k = i4;
        return this;
    }

    public JSONObject a(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f2986a);
            jSONObject.put("appkey", this.f2987b);
            jSONObject.put("sdkver", this.f2988c);
            jSONObject.put("platform", 0);
            long j4 = this.f2989d;
            if (j4 != 0) {
                jSONObject.put("uid", j4);
            }
            String str = this.f2990e;
            if (str != null) {
                jSONObject.put("opera", str);
            }
            if (a(this.f2991f, this.f2992g)) {
                jSONObject.put("lat", this.f2991f);
                jSONObject.put("lng", this.f2992g);
                jSONObject.put("time", this.f2993h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : set) {
                    jSONArray.put(str2);
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            int i4 = this.f2994i;
            if (i4 != 0) {
                jSONObject.put("ips_flag", i4);
            }
            int i5 = this.f2995j;
            if (i5 != 0) {
                jSONObject.put("report_flag", i5);
            }
            int i6 = this.f2996k;
            if (i6 >= 0) {
                if (i6 == 0) {
                    i6 = 1;
                }
                jSONObject.put("cert_ver", i6);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
