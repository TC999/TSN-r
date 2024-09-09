package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private String f34665c;

    /* renamed from: w  reason: collision with root package name */
    private List<String> f34666w;

    public f(Map<String, Object> map) {
        this.f34665c = "";
        this.f34666w = new ArrayList();
        try {
            this.f34665c = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.f34666w = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                this.f34666w.add(jSONArray.optString(i4));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public String c() {
        return this.f34665c;
    }

    public List<String> w() {
        return this.f34666w;
    }
}
