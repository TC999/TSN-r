package com.bytedance.msdk.core.w;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private final String f28278c;
    private final String sr;
    private String[] ux;

    /* renamed from: w  reason: collision with root package name */
    private final String f28280w;
    private final Map<String, Float> xv = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, ux> f28279f = new ConcurrentHashMap();

    public sr(String str, String str2, @NonNull JSONObject jSONObject) {
        this.f28278c = str;
        this.f28280w = str2;
        this.sr = jSONObject.optString("symbol");
        JSONArray optJSONArray = jSONObject.optJSONArray("score_fit_type");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.ux = new String[optJSONArray.length()];
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                String optString = optJSONArray.optString(i4);
                if (!TextUtils.isEmpty(optString)) {
                    this.ux[i4] = optString;
                    JSONObject optJSONObject = jSONObject.optJSONObject(optString);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("range");
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("value");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && optJSONArray3 != null && optJSONArray3.length() > 0) {
                            this.f28279f.put(optString, new ux(optString, optJSONArray2, optJSONArray3));
                        }
                    }
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("rule_exc_mode");
        if (optJSONObject2 == null || optJSONObject2.length() <= 0) {
            return;
        }
        Iterator<String> keys = optJSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.xv.put(next, Float.valueOf((float) optJSONObject2.optDouble(next, 0.0d)));
        }
    }

    public String c() {
        return this.f28278c;
    }

    public String sr() {
        return this.sr;
    }

    public Map<String, ux> ux() {
        return this.f28279f;
    }

    public Map<String, Float> w() {
        return this.xv;
    }

    public String[] xv() {
        return this.ux;
    }
}
