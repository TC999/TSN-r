package com.bytedance.sdk.openadsdk.w;

import com.bytedance.sdk.component.utils.a;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.File;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private long f36350c;
    private long sr;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private String f36351w;
    private String xv;

    public c(JSONObject jSONObject) {
        this.f36350c = jSONObject.optLong(BidResponsedEx.KEY_CID);
        this.f36351w = jSONObject.optString("url");
        this.xv = jSONObject.optString("file_hash");
        this.sr = jSONObject.optLong("effective_time");
        this.ux = jSONObject.optLong("expiration_time");
    }

    public String c() {
        return this.f36351w;
    }

    public boolean sr() {
        return System.currentTimeMillis() >= this.ux;
    }

    public JSONObject ux() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BidResponsedEx.KEY_CID, this.f36350c);
            jSONObject.put("url", this.f36351w);
            jSONObject.put("file_hash", this.xv);
            jSONObject.put("effective_time", this.sr);
            jSONObject.put("expiration_time", this.ux);
        } catch (Exception e4) {
            a.sr("BrandVideo", e4.getMessage());
        }
        return jSONObject;
    }

    public String w() {
        return this.xv;
    }

    public long xv() {
        return this.sr;
    }

    public long c(String str) {
        File file = new File(str, this.xv);
        if (file.exists()) {
            return file.lastModified();
        }
        return System.currentTimeMillis();
    }

    public boolean w(String str) {
        File file = new File(str, this.xv);
        if (file.exists()) {
            try {
                return file.delete();
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }
}
