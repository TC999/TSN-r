package cn.jiguang.bv;

import android.text.TextUtils;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    LinkedHashSet<g> f2966a;

    /* renamed from: b  reason: collision with root package name */
    LinkedHashSet<g> f2967b;

    /* renamed from: c  reason: collision with root package name */
    LinkedHashSet<g> f2968c;

    /* renamed from: d  reason: collision with root package name */
    LinkedHashSet<g> f2969d;

    /* renamed from: e  reason: collision with root package name */
    LinkedHashSet<g> f2970e;

    /* renamed from: f  reason: collision with root package name */
    JSONObject f2971f;

    /* renamed from: g  reason: collision with root package name */
    transient g f2972g;

    /* renamed from: h  reason: collision with root package name */
    boolean f2973h;

    /* renamed from: i  reason: collision with root package name */
    int f2974i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f2966a = a(jSONObject, "ips");
            this.f2967b = a(jSONObject, "ssl_ips");
            this.f2968c = a(jSONObject, "http_report");
            this.f2969d = a(jSONObject, "https_report");
            this.f2970e = a(jSONObject, "sis_ips");
            this.f2973h = jSONObject.optBoolean("data_report");
            this.f2971f = jSONObject.optJSONObject("tcp_report");
            this.f2974i = jSONObject.optInt("cert_ver", 0);
            cn.jiguang.bq.d.c("sis", "get sis=" + jSONObject.toString(2));
        } catch (Throwable unused) {
        }
    }

    private LinkedHashSet<g> a(JSONObject jSONObject, String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    g a4 = g.a(optJSONArray.optString(i4, null));
                    if (a4 != null && a4.a()) {
                        linkedHashSet.add(a4);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }

    public boolean a() {
        LinkedHashSet<g> linkedHashSet;
        LinkedHashSet<g> linkedHashSet2 = this.f2966a;
        return (linkedHashSet2 == null || linkedHashSet2.isEmpty()) && ((linkedHashSet = this.f2967b) == null || linkedHashSet.isEmpty());
    }
}
