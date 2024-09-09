package com.mbridge.msdk.mbjscommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.mraid.a;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MraidJSBridge extends AbsMbridgeDownload {

    /* renamed from: a  reason: collision with root package name */
    private b f40292a;

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            a.C0751a.f40293a.a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a, "close");
        }
        try {
            x.d("MraidJSBridge", "MRAID close");
            b bVar = this.f40292a;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th) {
            x.b("MraidJSBridge", "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            a.C0751a.f40293a.a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            x.d("MraidJSBridge", "MRAID expand " + optString + " " + optString2);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.f40292a == null) {
                return;
            }
            this.f40292a.expand(optString, optString2.toLowerCase().equals("true"));
        } catch (Throwable th) {
            x.b("MraidJSBridge", "MRAID expand", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.j
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.f40292a = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.f40292a = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof b)) {
                return;
            }
            this.f40292a = (b) windVaneWebView.getMraidObject();
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a;
            a.C0751a.f40293a.a(windVaneWebView, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            x.d("MraidJSBridge", "MRAID Open " + optString);
            if (this.f40292a == null || TextUtils.isEmpty(optString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.b.a.f38895c || !com.mbridge.msdk.click.b.a.a(this.f40292a.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f38893a)) {
                this.f40292a.open(optString);
            }
        } catch (Throwable th) {
            x.b("MraidJSBridge", "MRAID Open", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        open(obj, str);
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            a.C0751a.f40293a.a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            x.d("MraidJSBridge", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.f40292a == null) {
                return;
            }
            optString.toLowerCase().equals("true");
            String lowerCase = optString2.toLowerCase();
            int hashCode = lowerCase.hashCode();
            if (hashCode == 729267099) {
                str2 = "portrait";
            } else if (hashCode != 1430647483) {
                return;
            } else {
                str2 = "landscape";
            }
            lowerCase.equals(str2);
        } catch (Throwable th) {
            x.b("MraidJSBridge", "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            a.C0751a.f40293a.a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a, "unload");
        }
        try {
            x.d("MraidJSBridge", "MRAID unload");
            b bVar = this.f40292a;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th) {
            x.b("MraidJSBridge", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            a.C0751a.f40293a.a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            x.d("MraidJSBridge", "MRAID useCustomClose " + optString);
            if (TextUtils.isEmpty(optString) || this.f40292a == null) {
                return;
            }
            this.f40292a.useCustomClose(optString.toLowerCase().equals("true"));
        } catch (Throwable th) {
            x.b("MraidJSBridge", "MRAID useCustomClose", th);
        }
    }
}
