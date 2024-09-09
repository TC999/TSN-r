package com.qq.e.comm.plugin.e0.e;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private int f42934a;

    /* renamed from: b  reason: collision with root package name */
    private String f42935b;

    /* renamed from: c  reason: collision with root package name */
    private int f42936c;

    /* renamed from: d  reason: collision with root package name */
    private int f42937d;

    /* renamed from: e  reason: collision with root package name */
    private String f42938e;

    /* renamed from: f  reason: collision with root package name */
    private String f42939f;

    /* renamed from: g  reason: collision with root package name */
    private JSONArray f42940g;

    public e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f42934a = jSONObject.optInt("ret", -1);
        jSONObject.optString("msg");
        this.f42935b = jSONObject.optString("payload");
        this.f42936c = jSONObject.optInt("ecpm");
        jSONObject.optString("placement_id");
        this.f42937d = jSONObject.optInt("adnet_id");
        this.f42938e = jSONObject.optString("nurl");
        this.f42939f = jSONObject.optString("lurl");
        jSONObject.optString(ConstantAd.KEY_CACHE_AD);
        this.f42940g = jSONObject.optJSONArray(BaseConstants.MARKET_URI_AUTHORITY_DETAIL);
    }

    public int a() {
        return this.f42937d;
    }

    public JSONArray b() {
        return this.f42940g;
    }

    public int c() {
        return this.f42936c;
    }

    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.f42940g;
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i4 = 0; i4 < this.f42940g.length(); i4++) {
                arrayList.add(this.f42940g.optJSONObject(i4).optString("lurl"));
            }
        }
        return arrayList;
    }

    public String e() {
        return this.f42939f;
    }

    public String f() {
        return this.f42935b;
    }

    public int g() {
        return this.f42934a;
    }

    public String h() {
        return this.f42938e;
    }
}
