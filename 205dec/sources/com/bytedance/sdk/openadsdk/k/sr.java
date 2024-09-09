package com.bytedance.sdk.openadsdk.k;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.w.c.p;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.k.c;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr extends c {
    public sr(w wVar, String str, String str2, String str3, String str4) {
        super(wVar, str, str2, str3, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.k.c
    public void c(final String str, final String str2) {
        a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.k.sr.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BidResponsedEx.KEY_CID, str);
                    jSONObject.put("req_id", str2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("web_upload_start").w(jSONObject.toString());
            }
        }, "web_upload_start");
    }

    @Override // com.bytedance.sdk.openadsdk.k.c
    public void c(final String str, final String str2, final long j4, final String str3, final long j5, final long j6) {
        a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.k.sr.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BidResponsedEx.KEY_CID, str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put("duration", System.currentTimeMillis() - j4);
                    jSONObject.put("weburl", str3);
                    jSONObject.put("size", j5);
                    jSONObject.put("avail_mem", j6);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("web_upload_finish").w(jSONObject.toString());
            }
        }, "web_upload_finish");
    }

    @Override // com.bytedance.sdk.openadsdk.k.c
    protected void c(JSONObject jSONObject, String str, p pVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("name", str2);
            jSONObject2.putOpt("url", str3);
            jSONObject2.putOpt("request_headers", new JSONObject(map));
            String lowerCase = pVar.toString().toLowerCase();
            if (lowerCase.contains("image")) {
                c(jSONObject2, jSONObject, "sub_pic");
            } else {
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        c(jSONObject2, jSONObject, "css");
                    } else if (lowerCase.contains("html")) {
                        c(jSONObject2, jSONObject, "html");
                    }
                }
                c(jSONObject2, jSONObject, "js");
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void c(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray optJSONArray = jSONObject2.optJSONArray(str);
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.f35918f.putOpt(str, jSONArray);
            } else {
                optJSONArray.put(jSONObject);
                this.f35918f.putOpt(str, optJSONArray);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.c
    void c() {
        try {
            this.f35918f.putOpt("html", new JSONArray());
            this.f35918f.putOpt("js", new JSONArray());
            this.f35918f.putOpt("css", new JSONArray());
            this.f35918f.putOpt("sub_pic", new JSONArray());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.c
    boolean c(p pVar) {
        try {
            Set<String> me = ls.w().me();
            String str = pVar.c().trim().toLowerCase() + TTPathConst.sSeparator + pVar.w().trim().toLowerCase();
            com.bytedance.sdk.component.utils.a.w("weblp", "contentType======>" + me + "   " + str);
            return me.contains(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.c
    void c(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, p pVar, c.InterfaceC0529c interfaceC0529c) {
        interfaceC0529c.c(true, null);
    }
}
