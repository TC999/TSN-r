package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MvBridge extends AbsMbridgeDownload {
    public void getDeviceInfo(Object obj, String str) {
        WindVaneWebView windVaneWebView = ((a) obj).f40326a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("a", "hello fail");
            e.a();
            String jSONObject2 = jSONObject.toString();
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (TextUtils.isEmpty(jSONObject2)) {
                    String.format("javascript:window.MvBridge.onFailure(%s,'');", aVar.f40332g);
                } else {
                    jSONObject2 = k.c(jSONObject2);
                }
                String format = String.format("javascript:window.MvBridge.onFailure(%s,'%s');", aVar.f40332g, jSONObject2);
                WindVaneWebView windVaneWebView2 = aVar.f40326a;
                if (windVaneWebView2 != null) {
                    try {
                        windVaneWebView2.loadUrl(format);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void getTitle(Object obj, String str) {
        String format;
        a aVar = (a) obj;
        WindVaneWebView windVaneWebView = aVar.f40326a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("a", "hello succ");
            e.a().a(obj, jSONObject.toString());
            e.a();
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                format = String.format("javascript:window.MvBridge.fireEvent('%s', '');", "receiveMessage");
            } else {
                format = String.format("javascript:window.MvBridge.fireEvent('%s','%s');", "receiveMessage", k.c(jSONObject2));
            }
            WindVaneWebView windVaneWebView2 = aVar.f40326a;
            if (windVaneWebView2 != null) {
                try {
                    windVaneWebView2.loadUrl(format);
                } catch (Exception e4) {
                    e4.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void openWindow(Object obj, String str) {
        WindVaneWebView windVaneWebView = ((a) obj).f40326a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("a", "hello succ");
            e.a().a(obj, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
    }
}
