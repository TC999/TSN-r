package com.mbridge.msdk.mbjscommon.d;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbjscommon.windvane.h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShakeCacheManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static int f40285b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f40286c = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f40287a;

    /* renamed from: d  reason: collision with root package name */
    private String f40288d;

    /* renamed from: e  reason: collision with root package name */
    private String f40289e;

    /* renamed from: f  reason: collision with root package name */
    private WindVaneWebView f40290f;

    /* compiled from: ShakeCacheManager.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class C0750a {

        /* renamed from: a  reason: collision with root package name */
        static a f40291a = new a();
    }

    public static a a() {
        return C0750a.f40291a;
    }

    private a() {
        this.f40287a = "ShakeCacheManager";
    }

    public final void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cache", this.f40289e);
            a(obj, jSONObject);
        } catch (JSONException e4) {
            a(obj, e4.getMessage(), new JSONObject());
        }
    }

    public final void a(Object obj, WindVaneWebView windVaneWebView, String str, String str2, int i4) {
        if ((!TextUtils.isEmpty(this.f40289e) && this.f40289e.equals(str)) || (TextUtils.isEmpty(this.f40289e) && TextUtils.isEmpty(str))) {
            this.f40289e = str2;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.f40288d = new JSONObject(str2).optString("sid");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            this.f40290f = windVaneWebView;
            a(obj, new JSONObject());
            return;
        }
        String str3 = this.f40289e;
        if (windVaneWebView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentCache", str3);
                a(obj, "cache had changed", jSONObject);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(Object obj, WindVaneWebView windVaneWebView, String str) {
        if (!TextUtils.isEmpty(this.f40289e) && this.f40289e.equals(str)) {
            this.f40289e = "";
            this.f40290f = null;
            if (windVaneWebView != null) {
                h.a().a(obj, "releaseShake", "");
            }
            a(obj, new JSONObject());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("currentCache", this.f40289e);
            a(obj, "cache is exception", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f40285b);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e4) {
            a(obj, e4.getMessage(), new JSONObject());
            x.a(this.f40287a, e4.getMessage());
        }
    }

    private void a(Object obj, String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f40286c);
            jSONObject2.put("message", str);
            jSONObject2.put("data", jSONObject);
            h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e4) {
            x.a(this.f40287a, e4.getMessage());
        }
    }
}
