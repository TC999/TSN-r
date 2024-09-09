package com.mbridge.msdk.splash.js;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SplashJs extends AbsMbridgeDownload {

    /* renamed from: a  reason: collision with root package name */
    private static String f40716a = "SplashJs";

    /* renamed from: b  reason: collision with root package name */
    private b f40717b;

    public void cai(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "cai" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.f(obj, str);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a(obj, new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void gial(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "gial" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.g(obj, str);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
            } catch (Throwable th) {
                x.b(f40716a, "handlerH5Exception", th);
            }
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            c.b(obj, new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void init(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "initialize" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.a(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.j
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof b)) {
                return;
            }
            this.f40717b = (b) windVaneWebView.getObject();
        } catch (Throwable th) {
            x.b(f40716a, "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        String addDownloaderListener = addDownloaderListener(obj, str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.d(obj, addDownloaderListener);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            x.d(f40716a, "onJSBridgeConnect");
            b bVar = this.f40717b;
            if (bVar != null) {
                bVar.k(obj, str);
            }
        } catch (Throwable th) {
            x.b(f40716a, "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "openURL" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.e(obj, str);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            x.d(f40716a, "pauseCountDown");
            b bVar = this.f40717b;
            if (bVar != null) {
                bVar.l(obj, str);
            }
        } catch (Throwable th) {
            x.b(f40716a, "pauseCountDown", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, optInt);
            } catch (Throwable th) {
                x.b(f40716a, "readyStatus", th);
            }
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            x.d(f40716a, "reportUrls");
            b bVar = this.f40717b;
            if (bVar != null) {
                bVar.j(obj, str);
            }
        } catch (Throwable th) {
            x.b(f40716a, "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "resetCountdown" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.h(obj, str);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            x.d(f40716a, "resumeCountDown");
            b bVar = this.f40717b;
            if (bVar != null) {
                bVar.m(obj, str);
            }
        } catch (Throwable th) {
            x.b(f40716a, "resumeCountDown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            x.d(f40716a, "sendImpressions");
            b bVar = this.f40717b;
            if (bVar != null) {
                bVar.i(obj, str);
            }
        } catch (Throwable th) {
            x.b(f40716a, "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        install(obj, str);
    }

    public void toggleCloseBtn(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "toggleCloseBtn" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.b(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        String str2 = f40716a;
        x.d(str2, "triggerCloseBtn" + str);
        b bVar = this.f40717b;
        if (bVar != null) {
            bVar.c(obj, str);
        }
    }
}
