package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    private LoginType f41601a;

    /* renamed from: b  reason: collision with root package name */
    private String f41602b;

    /* renamed from: c  reason: collision with root package name */
    private String f41603c;

    /* renamed from: d  reason: collision with root package name */
    private String f41604d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f41605e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f41606f;

    /* renamed from: g  reason: collision with root package name */
    private final JSONObject f41607g = new JSONObject();

    public Map getDevExtra() {
        return this.f41605e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f41605e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f41605e).toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f41606f;
    }

    public String getLoginAppId() {
        return this.f41602b;
    }

    public String getLoginOpenid() {
        return this.f41603c;
    }

    public LoginType getLoginType() {
        return this.f41601a;
    }

    public JSONObject getParams() {
        return this.f41607g;
    }

    public String getUin() {
        return this.f41604d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f41605e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f41606f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f41602b = str;
    }

    public void setLoginOpenid(String str) {
        this.f41603c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f41601a = loginType;
    }

    public void setUin(String str) {
        this.f41604d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f41601a + ", loginAppId=" + this.f41602b + ", loginOpenid=" + this.f41603c + ", uin=" + this.f41604d + ", passThroughInfo=" + this.f41605e + ", extraInfo=" + this.f41606f + '}';
    }
}
