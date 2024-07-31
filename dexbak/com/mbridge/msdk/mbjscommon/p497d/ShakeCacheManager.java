package com.mbridge.msdk.mbjscommon.p497d;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ShakeCacheManager {

    /* renamed from: b */
    private static int f31513b = 0;

    /* renamed from: c */
    private static int f31514c = 1;

    /* renamed from: a */
    private String f31515a;

    /* renamed from: d */
    private String f31516d;

    /* renamed from: e */
    private String f31517e;

    /* renamed from: f */
    private WindVaneWebView f31518f;

    /* compiled from: ShakeCacheManager.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.d.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C11498a {

        /* renamed from: a */
        static ShakeCacheManager f31519a = new ShakeCacheManager();
    }

    /* renamed from: a */
    public static ShakeCacheManager m21436a() {
        return C11498a.f31519a;
    }

    private ShakeCacheManager() {
        this.f31515a = "ShakeCacheManager";
    }

    /* renamed from: a */
    public final void m21435a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cache", this.f31517e);
            m21431a(obj, jSONObject);
        } catch (JSONException e) {
            m21432a(obj, e.getMessage(), new JSONObject());
        }
    }

    /* renamed from: a */
    public final void m21433a(Object obj, WindVaneWebView windVaneWebView, String str, String str2, int i) {
        if ((!TextUtils.isEmpty(this.f31517e) && this.f31517e.equals(str)) || (TextUtils.isEmpty(this.f31517e) && TextUtils.isEmpty(str))) {
            this.f31517e = str2;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.f31516d = new JSONObject(str2).optString(SocializeProtocolConstants.PROTOCOL_KEY_SID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f31518f = windVaneWebView;
            m21431a(obj, new JSONObject());
            return;
        }
        String str3 = this.f31517e;
        if (windVaneWebView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentCache", str3);
                m21432a(obj, "cache had changed", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21434a(Object obj, WindVaneWebView windVaneWebView, String str) {
        if (!TextUtils.isEmpty(this.f31517e) && this.f31517e.equals(str)) {
            this.f31517e = "";
            this.f31518f = null;
            if (windVaneWebView != null) {
                WindVaneCallJs.m21387a().m21383a(obj, "releaseShake", "");
            }
            m21431a(obj, new JSONObject());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("currentCache", this.f31517e);
            m21432a(obj, "cache is exception", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m21431a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f31513b);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            m21432a(obj, e.getMessage(), new JSONObject());
            SameLogTool.m21738a(this.f31515a, e.getMessage());
        }
    }

    /* renamed from: a */
    private void m21432a(Object obj, String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f31514c);
            jSONObject2.put("message", str);
            jSONObject2.put("data", jSONObject);
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            SameLogTool.m21738a(this.f31515a, e.getMessage());
        }
    }
}
