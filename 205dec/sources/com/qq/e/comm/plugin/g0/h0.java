package com.qq.e.comm.plugin.g0;

import android.graphics.Point;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    private String f43583a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f43584b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f43585c;

    public static List<h0> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                Object opt = jSONArray.opt(i4);
                if (opt instanceof JSONObject) {
                    h0 a4 = a((JSONObject) opt);
                    if (a4 != null) {
                        arrayList.add(a4);
                    }
                } else {
                    d1.a("Slot.parseList error !");
                }
            }
        }
        return arrayList;
    }

    public void a(List<Point> list) {
    }

    public List<Integer> b() {
        return this.f43584b;
    }

    public List<String> c() {
        return this.f43585c;
    }

    public void b(List<Integer> list) {
        this.f43584b = list;
    }

    public void c(List<String> list) {
        this.f43585c = list;
    }

    public static h0 a(JSONObject jSONObject) {
        if (jSONObject != null) {
            h0 h0Var = new h0();
            h0Var.a(jSONObject.optString("date"));
            h0Var.b(a0.a(jSONObject.optJSONArray("index")));
            JSONArray optJSONArray = jSONObject.optJSONArray("effectivetime");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        Point point = new Point();
                        point.x = optJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_START);
                        point.y = optJSONObject.optInt("end");
                        arrayList.add(point);
                    }
                }
            }
            h0Var.a(arrayList);
            h0Var.c(a0.b(jSONObject.optJSONArray("server_data")));
            return h0Var;
        }
        return null;
    }

    public String a() {
        return this.f43583a;
    }

    public void a(String str) {
        this.f43583a = str;
    }

    public String a(Integer num) {
        int indexOf;
        List<Integer> b4 = b();
        List<String> c4 = c();
        if (b4 != null && c4 != null && (indexOf = b4.indexOf(num)) >= 0 && indexOf < c4.size()) {
            return c4.get(indexOf);
        }
        if (c4 == null || c4.size() <= 0) {
            return null;
        }
        return c4.get(0);
    }
}
