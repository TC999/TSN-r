package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private String f34892c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private String f34893f;
    private String gd;

    /* renamed from: p  reason: collision with root package name */
    private JSONArray f34894p;

    /* renamed from: r  reason: collision with root package name */
    private String f34895r;
    private List<c> sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34896w;
    private String xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private final String f34897c;

        /* renamed from: w  reason: collision with root package name */
        private final String f34898w;

        public c(JSONObject jSONObject) {
            this.f34897c = jSONObject.optString("permission_name");
            this.f34898w = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.f34898w);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put("permission_name", this.f34897c);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            return jSONObject;
        }
    }

    public xv(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("package");
            this.f34892c = optJSONObject.optString("app_name");
            this.f34896w = optJSONObject.optString("version_name");
            this.xv = optJSONObject.optString("developer_name");
            this.sr = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray(TTDelegateActivity.INTENT_PERMISSIONS);
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.sr.add(new c(optJSONArray.optJSONObject(i4)));
                }
            }
            this.ux = optJSONObject.optString("policy_url");
            String optString = optJSONObject.optString("package");
            this.f34893f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f34893f = optJSONObject.optString("package_name");
            }
            this.f34895r = optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL);
            this.gd = optJSONObject.optString("desc_url");
        } catch (Throwable unused) {
        }
    }

    public String c() {
        return this.f34892c;
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", this.f34892c);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("app_version", this.f34896w);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("developer_name", this.xv);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("package_name", this.f34893f);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        for (c cVar : this.sr) {
            jSONArray.put(cVar.c());
        }
        try {
            jSONObject.put(TTDelegateActivity.INTENT_PERMISSIONS, jSONArray);
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("privacy_policy_url", this.ux);
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("score", this.ev);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("creative_tags", this.f34894p);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("desc_url", this.gd);
        } catch (JSONException e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put(CampaignEx.JSON_KEY_ICON_URL, this.f34895r);
        } catch (JSONException e13) {
            e13.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sr() {
        return this.gd;
    }

    public boolean ux() {
        List<c> list;
        return (TextUtils.isEmpty(this.f34892c) || TextUtils.isEmpty(this.f34896w) || TextUtils.isEmpty(w()) || (list = this.sr) == null || list.size() == 0 || TextUtils.isEmpty(this.ux) || TextUtils.isEmpty(this.gd)) ? false : true;
    }

    public String w() {
        return this.xv;
    }

    public String xv() {
        return this.f34895r;
    }

    public void c(float f4) {
        this.ev = f4;
    }

    public void c(JSONArray jSONArray) {
        this.f34894p = jSONArray;
    }
}
