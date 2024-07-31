package com.mbridge.msdk.splash.p508js;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.js.SplashJs */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SplashJs extends AbsMbridgeDownload {

    /* renamed from: a */
    private static String f31949a = "SplashJs";

    /* renamed from: b */
    private SplashJSBridgeImpl f31950b;

    public void cai(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "cai" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21022f(obj, str);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SplashJsUtils.m21009a(obj, new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void gial(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "gial" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21021g(obj, str);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                WindVaneWebView windVaneWebView = ((CallMethodContext) obj).f31554a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().mo21138a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
            } catch (Throwable th) {
                SameLogTool.m21735b(f31949a, "handlerH5Exception", th);
            }
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            SplashJsUtils.m21007b(obj, new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void init(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "initialize" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21031a(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.WindVanePlugin
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof SplashJSBridgeImpl)) {
                return;
            }
            this.f31950b = (SplashJSBridgeImpl) windVaneWebView.getObject();
        } catch (Throwable th) {
            SameLogTool.m21735b(f31949a, "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        String addDownloaderListener = addDownloaderListener(obj, str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21024d(obj, addDownloaderListener);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            SameLogTool.m21733d(f31949a, "onJSBridgeConnect");
            SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.m21017k(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(f31949a, "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "openURL" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21023e(obj, str);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            SameLogTool.m21733d(f31949a, "pauseCountDown");
            SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.m21016l(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(f31949a, "pauseCountDown", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((CallMethodContext) obj).f31554a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().mo21139a(windVaneWebView, optInt);
            } catch (Throwable th) {
                SameLogTool.m21735b(f31949a, "readyStatus", th);
            }
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            SameLogTool.m21733d(f31949a, "reportUrls");
            SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.m21018j(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(f31949a, "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "resetCountdown" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21020h(obj, str);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            SameLogTool.m21733d(f31949a, "resumeCountDown");
            SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.m21015m(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(f31949a, "resumeCountDown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            SameLogTool.m21733d(f31949a, "sendImpressions");
            SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.m21019i(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(f31949a, "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        install(obj, str);
    }

    public void toggleCloseBtn(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "toggleCloseBtn" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21027b(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        String str2 = f31949a;
        SameLogTool.m21733d(str2, "triggerCloseBtn" + str);
        SplashJSBridgeImpl splashJSBridgeImpl = this.f31950b;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.m21025c(obj, str);
        }
    }
}
