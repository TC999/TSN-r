package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MvBridge extends AbsMbridgeDownload {
    public void getDeviceInfo(Object obj, String str) {
        WindVaneWebView windVaneWebView = ((CallMethodContext) obj).f31554a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("a", "hello fail");
            MVCallJs.m21396a();
            String jSONObject2 = jSONObject.toString();
            if (obj instanceof CallMethodContext) {
                CallMethodContext callMethodContext = (CallMethodContext) obj;
                if (TextUtils.isEmpty(jSONObject2)) {
                    String.format("javascript:window.MvBridge.onFailure(%s,'');", callMethodContext.f31560g);
                } else {
                    jSONObject2 = WindVaneUtil.m21376c(jSONObject2);
                }
                String format = String.format("javascript:window.MvBridge.onFailure(%s,'%s');", callMethodContext.f31560g, jSONObject2);
                WindVaneWebView windVaneWebView2 = callMethodContext.f31554a;
                if (windVaneWebView2 != null) {
                    try {
                        windVaneWebView2.loadUrl(format);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void getTitle(Object obj, String str) {
        String format;
        CallMethodContext callMethodContext = (CallMethodContext) obj;
        WindVaneWebView windVaneWebView = callMethodContext.f31554a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("a", "hello succ");
            MVCallJs.m21396a().m21395a(obj, jSONObject.toString());
            MVCallJs.m21396a();
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                format = String.format("javascript:window.MvBridge.fireEvent('%s', '');", "receiveMessage");
            } else {
                format = String.format("javascript:window.MvBridge.fireEvent('%s','%s');", "receiveMessage", WindVaneUtil.m21376c(jSONObject2));
            }
            WindVaneWebView windVaneWebView2 = callMethodContext.f31554a;
            if (windVaneWebView2 != null) {
                try {
                    windVaneWebView2.loadUrl(format);
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void openWindow(Object obj, String str) {
        WindVaneWebView windVaneWebView = ((CallMethodContext) obj).f31554a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("a", "hello succ");
            MVCallJs.m21396a().m21395a(obj, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
    }
}
