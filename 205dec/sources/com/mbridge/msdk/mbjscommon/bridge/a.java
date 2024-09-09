package com.mbridge.msdk.mbjscommon.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbjscommon.windvane.h;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonBannerJSBridgeImp.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40208a = "a";

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void a(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "init: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void b(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "click: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void c(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "readyStatus: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void d(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "toggleCloseBtn: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void e(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "triggerCloseBtn: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
                h.a().a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a);
            }
        } catch (Throwable th) {
            x.b(f40208a, "onJSBridgeConnect", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void g(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "install: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void h(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "resetCountdown: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void i(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "sendImpressions: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public void j(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "getFileInfo:" + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void k(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    int optInt2 = jSONObject.optInt("report");
                    if (optInt2 == 0) {
                        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.f().j(), (CampaignEx) null, "", optString, false, optInt != 0);
                    } else {
                        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.f().j(), (CampaignEx) null, "", optString, false, optInt != 0, optInt2);
                    }
                }
                h.a().a(obj, b.a(0));
            } catch (Throwable th) {
                x.b(f40208a, "reportUrls", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void l(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "increaseOfferFrequence:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                b.a(obj, new JSONObject(str));
            } catch (Throwable th) {
                x.b(f40208a, "increaseOfferFrequence", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void m(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "handlerH5Exception: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void n(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = f40208a;
        x.d(str2, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (j4 == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a) != null) {
                    j4 = windVaneWebView.getContext();
                }
            } catch (Exception e4) {
                x.d(f40208a, e4.getMessage());
            }
        }
        if (j4 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.mbridge.msdk.click.c.a(j4, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.b(j4, optString);
            }
        } catch (JSONException e5) {
            x.d(f40208a, e5.getMessage());
        } catch (Throwable th) {
            x.d(f40208a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void o(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = f40208a;
        x.d(str2, "getNetstat:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (j4 == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a) != null) {
                    j4 = windVaneWebView.getContext();
                }
            } catch (Exception e4) {
                x.d(f40208a, e4.getMessage());
            }
        }
        if (j4 == null) {
            h.a().a(obj, b.a(1));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("netstat", t.D(j4));
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            h.a().a(obj, jSONObject2);
        } catch (Throwable th) {
            x.d(f40208a, th.getMessage());
            h.a().a(obj, b.a(1));
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void p(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                try {
                    String optString = new JSONObject(str).optString("packageName");
                    if (TextUtils.isEmpty(optString)) {
                        b.a(obj, "packageName is empty");
                    }
                    int i4 = ac.c(com.mbridge.msdk.foundation.controller.a.f().j(), optString) ? 1 : 2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", b.f40210b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", i4);
                        jSONObject.put("data", jSONObject2);
                        h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e4) {
                        b.a(obj, e4.getMessage());
                        x.a(f40208a, e4.getMessage());
                    }
                } catch (Throwable th) {
                    b.a(obj, "exception: " + th.getLocalizedMessage());
                    x.b(f40208a, "cai", th);
                }
            } catch (JSONException e5) {
                b.a(obj, "exception: " + e5.getLocalizedMessage());
                x.b(f40208a, "cai", e5);
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.c
    public final void q(Object obj, String str) {
        String str2 = f40208a;
        x.a(str2, "gial:" + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", b.f40210b);
            JSONObject jSONObject2 = new JSONObject();
            List<String> list = com.mbridge.msdk.foundation.controller.a.f39079c;
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    jSONArray.put(list.get(i4));
                }
            }
            jSONObject2.put("packageNameList", jSONArray);
            jSONObject.put("data", jSONObject2);
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            b.a(obj, e4.getMessage());
            x.a(f40208a, e4.getMessage());
        } catch (Throwable th) {
            b.a(obj, th.getMessage());
            x.a(f40208a, th.getMessage());
        }
    }
}
