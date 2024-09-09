package com.mbridge.msdk.mbjscommon.bridge;

import android.content.Context;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BannerJSPlugin extends AbsMbridgeDownload {

    /* renamed from: a  reason: collision with root package name */
    private final String f40206a = "BannerJSBridge";

    /* renamed from: b  reason: collision with root package name */
    private c f40207b;

    public void cai(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "cai");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.p(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "cai", th);
        }
    }

    public void click(Object obj, String str) {
        try {
            String addDownloaderListener = addDownloaderListener(obj, str);
            x.d("BannerJSBridge", "click");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.b(obj, addDownloaderListener);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "click", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "getFileInfo");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.j(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "getNetstat");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.o(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "getNetstat", th);
        }
    }

    public void gial(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "gial");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.q(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "gial", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "handlerH5Exception");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.m(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "increaseOfferFrequence");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.l(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "init");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.a(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "init", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.j
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof c) {
                this.f40207b = (c) context;
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof c)) {
                this.f40207b = (c) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            x.d("BannerJSBridge", AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY);
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.g(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY, th);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "onJSBridgeConnect");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.f(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "openURL");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.n(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "readyStatus");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.c(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "reportUrls");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.k(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "resetCountdown");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.h(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "sendImpressions");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.i(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        install(obj, str);
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "toggleCloseBtn");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.d(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            x.d("BannerJSBridge", "triggerCloseBtn");
            c cVar = this.f40207b;
            if (cVar != null) {
                cVar.e(obj, str);
            }
        } catch (Throwable th) {
            x.b("BannerJSBridge", "triggerCloseBtn", th);
        }
    }
}
