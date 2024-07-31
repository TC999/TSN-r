package com.mbridge.msdk.mbjscommon.bridge;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BannerJSPlugin extends AbsMbridgeDownload {

    /* renamed from: a */
    private final String f31434a = "BannerJSBridge";

    /* renamed from: b */
    private IBannerJSBridge f31435b;

    public void cai(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "cai");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21503p(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "cai", th);
        }
    }

    public void click(Object obj, String str) {
        try {
            String addDownloaderListener = addDownloaderListener(obj, str);
            SameLogTool.m21733d("BannerJSBridge", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21517b(obj, addDownloaderListener);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "getFileInfo");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21509j(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "getNetstat");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21504o(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "getNetstat", th);
        }
    }

    public void gial(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "gial");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21502q(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "gial", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "handlerH5Exception");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21506m(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "increaseOfferFrequence");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21507l(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "init");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21518a(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "init", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.WindVanePlugin
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof IBannerJSBridge) {
                this.f31435b = (IBannerJSBridge) context;
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IBannerJSBridge)) {
                this.f31435b = (IBannerJSBridge) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "install");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21512g(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "install", th);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "onJSBridgeConnect");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21513f(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "openURL");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21505n(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "readyStatus");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21516c(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "reportUrls");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21508k(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "resetCountdown");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21511h(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "sendImpressions");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21510i(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        install(obj, str);
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "toggleCloseBtn");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21515d(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            SameLogTool.m21733d("BannerJSBridge", "triggerCloseBtn");
            IBannerJSBridge iBannerJSBridge = this.f31435b;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.mo21514e(obj, str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("BannerJSBridge", "triggerCloseBtn", th);
        }
    }
}
