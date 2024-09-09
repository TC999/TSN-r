package com.bytedance.adsdk.ugeno.w;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f26380a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f26381b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f26382c;

    public JSONObject a() {
        return this.f26381b;
    }

    public void b(Context context) {
        this.f26380a = context;
    }

    public void c(Map<String, Object> map) {
        this.f26382c = map;
    }

    public void d(JSONObject jSONObject) {
        this.f26381b = jSONObject;
    }

    public Map<String, Object> e() {
        return this.f26382c;
    }

    public Context getContext() {
        return this.f26380a;
    }
}
