package com.bytedance.sdk.openadsdk.core.dislike.xv;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ys.w.w.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends f {

    /* renamed from: c  reason: collision with root package name */
    private String f33185c;
    private List<f> sr;

    /* renamed from: w  reason: collision with root package name */
    private String f33186w;
    private boolean xv;

    public xv(String str, String str2) {
        super(null);
        this.f33185c = str;
        this.f33186w = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public String c() {
        return this.f33185c;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public boolean f() {
        List<f> list = this.sr;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public JSONObject r() {
        try {
            if (ux()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", c());
                jSONObject.put("name", w());
                jSONObject.put("is_selected", xv());
                if (f()) {
                    JSONArray jSONArray = new JSONArray();
                    for (f fVar : sr()) {
                        if (fVar instanceof xv) {
                            jSONArray.put(((xv) fVar).r());
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public List<f> sr() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public boolean ux() {
        return (TextUtils.isEmpty(this.f33185c) || TextUtils.isEmpty(this.f33186w)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public String w() {
        return this.f33186w;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public boolean xv() {
        return this.xv;
    }

    public void c(String str) {
        this.f33185c = str;
    }

    public void w(String str) {
        this.f33186w = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public void c(boolean z3) {
        this.xv = z3;
    }

    public xv() {
        super(null);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.f
    public void c(f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.sr == null) {
            this.sr = new ArrayList();
        }
        this.sr.add(fVar);
    }

    public static xv c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            xv xvVar = new xv();
            xvVar.c(jSONObject.optString("id"));
            xvVar.w(jSONObject.optString("name"));
            xvVar.c(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    xv c4 = c(optJSONArray.optJSONObject(i4));
                    if (c4 != null && c4.ux()) {
                        xvVar.c(c4);
                    }
                }
            }
            return xvVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
