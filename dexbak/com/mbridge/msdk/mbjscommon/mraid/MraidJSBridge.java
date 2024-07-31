package com.mbridge.msdk.mbjscommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.p461b.DspFilterUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.mraid.CallMraidJS;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MraidJSBridge extends AbsMbridgeDownload {

    /* renamed from: a */
    private IMraidJSBridge f31520a;

    public void close(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMraidJS.C11499a.f31521a.m21425a(((CallMethodContext) obj).f31554a, "close");
        }
        try {
            SameLogTool.m21733d("MraidJSBridge", "MRAID close");
            IMraidJSBridge iMraidJSBridge = this.f31520a;
            if (iMraidJSBridge != null) {
                iMraidJSBridge.close();
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("MraidJSBridge", "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMraidJS.C11499a.f31521a.m21425a(((CallMethodContext) obj).f31554a, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            SameLogTool.m21733d("MraidJSBridge", "MRAID expand " + optString + " " + optString2);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.f31520a == null) {
                return;
            }
            this.f31520a.expand(optString, optString2.toLowerCase().equals("true"));
        } catch (Throwable th) {
            SameLogTool.m21735b("MraidJSBridge", "MRAID expand", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.WindVanePlugin
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof IMraidJSBridge) {
                this.f31520a = (IMraidJSBridge) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IMraidJSBridge)) {
                this.f31520a = (IMraidJSBridge) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof IMraidJSBridge)) {
                return;
            }
            this.f31520a = (IMraidJSBridge) windVaneWebView.getMraidObject();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof CallMethodContext) {
            windVaneWebView = ((CallMethodContext) obj).f31554a;
            CallMraidJS.C11499a.f31521a.m21425a(windVaneWebView, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            SameLogTool.m21733d("MraidJSBridge", "MRAID Open " + optString);
            if (this.f31520a == null || TextUtils.isEmpty(optString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= DspFilterUtils.f30068c || !DspFilterUtils.m23081a(this.f31520a.getMraidCampaign(), windVaneWebView.getUrl(), DspFilterUtils.f30066a)) {
                this.f31520a.open(optString);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("MraidJSBridge", "MRAID Open", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        open(obj, str);
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof CallMethodContext) {
            CallMraidJS.C11499a.f31521a.m21425a(((CallMethodContext) obj).f31554a, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            SameLogTool.m21733d("MraidJSBridge", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.f31520a == null) {
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
            SameLogTool.m21735b("MraidJSBridge", "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMraidJS.C11499a.f31521a.m21425a(((CallMethodContext) obj).f31554a, "unload");
        }
        try {
            SameLogTool.m21733d("MraidJSBridge", "MRAID unload");
            IMraidJSBridge iMraidJSBridge = this.f31520a;
            if (iMraidJSBridge != null) {
                iMraidJSBridge.unload();
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("MraidJSBridge", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMraidJS.C11499a.f31521a.m21425a(((CallMethodContext) obj).f31554a, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            SameLogTool.m21733d("MraidJSBridge", "MRAID useCustomClose " + optString);
            if (TextUtils.isEmpty(optString) || this.f31520a == null) {
                return;
            }
            this.f31520a.useCustomClose(optString.toLowerCase().equals("true"));
        } catch (Throwable th) {
            SameLogTool.m21735b("MraidJSBridge", "MRAID useCustomClose", th);
        }
    }
}
