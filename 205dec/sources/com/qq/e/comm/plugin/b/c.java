package com.qq.e.comm.plugin.b;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f41954a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    private String f41955b;

    public void a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.f41955b)) {
            int indexOf = str.indexOf(63);
            if (indexOf == -1) {
                d1.a("AdFilterReporter fl is not valid:" + str, new Object[0]);
                return;
            }
            this.f41955b = str.substring(0, indexOf);
        }
        String queryParameter = Uri.parse(str).getQueryParameter("viewid");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("view_id", queryParameter);
            jSONObject.put("filter_code", i4);
            this.f41954a.put(jSONObject);
        } catch (JSONException e4) {
            d1.a("AdFilterReporter addData error", e4);
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.f41955b) || this.f41954a.length() <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f41954a);
            String jSONObject2 = jSONObject.toString();
            d1.a("AdFilterReporter url:" + this.f41955b + " data:" + jSONObject2, new Object[0]);
            com.qq.e.comm.plugin.i0.n.c cVar = new com.qq.e.comm.plugin.i0.n.c(this.f41955b, f.a.POST, jSONObject2.getBytes(com.qq.e.comm.plugin.k.a.f44515a));
            cVar.addHeader("Content-Type", "application/json");
            com.qq.e.comm.plugin.i0.d.a().a(cVar);
        } catch (JSONException e4) {
            d1.a("AdFilterReporter report error", e4);
        }
        this.f41954a = new JSONArray();
    }
}
