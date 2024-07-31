package com.p518qq.p519e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.constants.LoadAdParams */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LoadAdParams {

    /* renamed from: a */
    private LoginType f32886a;

    /* renamed from: b */
    private String f32887b;

    /* renamed from: c */
    private String f32888c;

    /* renamed from: d */
    private String f32889d;

    /* renamed from: e */
    private Map<String, String> f32890e;

    /* renamed from: f */
    private JSONObject f32891f;

    /* renamed from: g */
    private final JSONObject f32892g = new JSONObject();

    public Map getDevExtra() {
        return this.f32890e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f32890e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f32890e).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f32891f;
    }

    public String getLoginAppId() {
        return this.f32887b;
    }

    public String getLoginOpenid() {
        return this.f32888c;
    }

    public LoginType getLoginType() {
        return this.f32886a;
    }

    public JSONObject getParams() {
        return this.f32892g;
    }

    public String getUin() {
        return this.f32889d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f32890e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f32891f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f32887b = str;
    }

    public void setLoginOpenid(String str) {
        this.f32888c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f32886a = loginType;
    }

    public void setUin(String str) {
        this.f32889d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f32886a + ", loginAppId=" + this.f32887b + ", loginOpenid=" + this.f32888c + ", uin=" + this.f32889d + ", passThroughInfo=" + this.f32890e + ", extraInfo=" + this.f32891f + '}';
    }
}
