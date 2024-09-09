package com.mbridge.msdk.mbjscommon.confirmation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.bridge.b;
import com.mbridge.msdk.mbjscommon.confirmation.a;
import com.mbridge.msdk.mbjscommon.confirmation.e;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbjscommon.windvane.h;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ConfirmationJsBridgePlugin extends AbsMbridgeDownload {

    /* renamed from: a  reason: collision with root package name */
    private static String f40218a = "ConfirmationJsBridgePlugin";

    private a a(Object obj) {
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            Object object = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a.getObject();
            if (object instanceof a) {
                return (a) object;
            }
        }
        return null;
    }

    public void click(Object obj, String str) {
        try {
            a(obj, str);
            h.a().a(obj, b.a(0));
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }

    public void confirmCancel(Object obj, String str) {
        try {
            e.a().a(obj, str);
            h.a().a(obj, b.a(0));
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }

    public void confirmClick(Object obj, String str) {
        try {
            a(obj, str);
            h.a().a(obj, b.a(0));
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }

    public void confirmClose(Object obj, String str) {
        try {
            e.a().a(obj, str);
            h.a().a(obj, b.a(0));
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }

    public void init(Object obj, String str) {
        x.d(f40218a, " INIT INVOKE");
        a a4 = a(obj);
        if (a4 != null) {
            CampaignEx b4 = a4.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(b4);
            try {
                JSONObject jSONObject = new JSONObject();
                d dVar = new d(com.mbridge.msdk.foundation.controller.a.f().j());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dev_close_state", 0);
                jSONObject.put("sdkSetting", jSONObject2);
                jSONObject.put("device", dVar.a());
                jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(arrayList));
                com.mbridge.msdk.c.d e4 = com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), a4.d());
                if (e4 == null) {
                    e4 = com.mbridge.msdk.c.d.d(a4.d());
                }
                jSONObject.put("unitSetting", e4.t());
                String c4 = com.mbridge.msdk.c.b.a().c(com.mbridge.msdk.foundation.controller.a.f().k());
                if (!TextUtils.isEmpty(c4)) {
                    jSONObject.put("appSetting", new JSONObject(c4));
                }
                h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                x.b(f40218a, "init", th);
                b.a(obj, "exception: " + th.getLocalizedMessage());
            }
        }
    }

    public void install(Object obj, String str) {
        try {
            a(obj, str);
            h.a().a(obj, b.a(0));
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            String str2 = f40218a;
            x.d(str2, "openURL:" + str);
            if (TextUtils.isEmpty(str)) {
                b.a(obj, "params is null");
                return;
            }
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (!TextUtils.isEmpty(str)) {
                if (j4 == null) {
                    try {
                        if ((obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a) != null) {
                            j4 = windVaneWebView.getContext();
                        }
                    } catch (Exception e4) {
                        x.d(f40218a, e4.getMessage());
                    }
                }
                if (j4 == null) {
                    b.a(obj, "context is null");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("url");
                    int optInt = jSONObject.optInt("type");
                    if (optInt == 1) {
                        c.a(j4, optString);
                    } else if (optInt == 2) {
                        c.b(j4, optString);
                    }
                } catch (JSONException e5) {
                    x.d(f40218a, e5.getMessage());
                } catch (Throwable th) {
                    x.d(f40218a, th.getMessage());
                }
            }
            h.a().a(obj, b.a(0));
        } catch (Exception e6) {
            b.a(obj, "exception: " + e6.getLocalizedMessage());
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int optInt = new JSONObject(str).optInt("isReady", 1);
                h.a().a(obj, b.a(0));
                a a4 = a(obj);
                if ((a4 != null ? a4.b() : null) != null) {
                    e.a().a(obj, optInt);
                } else {
                    e.a().a(obj, 2);
                }
            } catch (Throwable th) {
                x.b(f40218a, "readyStatus", th);
                b.a(obj, "exception: " + th.getLocalizedMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        e.a().b(obj, str);
    }

    public void translatePermission(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("permissionMap");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, q.a(jSONObject2.getJSONArray(next)));
                }
                jSONObject.put("permissionMap", jSONObject2);
                h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            b.a(obj, "exception: params is " + str);
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }

    private void a(Object obj, String str) {
        try {
            addDownloaderListener(obj, str);
            e.a().b(obj, str);
            h.a().a(obj, b.a(0));
        } catch (Exception e4) {
            b.a(obj, "exception: " + e4.getLocalizedMessage());
        }
    }
}
