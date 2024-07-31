package com.bytedance.msdk.api.splash;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterSplashAdManager;
import com.bytedance.msdk.adapter.ThirdSdkInit;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.TTMediationAdSdk;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.api.TTSettingConfigCallback;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTSplashAd extends TTLoadBase {

    /* renamed from: a */
    private TTInterSplashAdManager f21740a;

    public TTSplashAd(Activity activity, String str) {
        this.f21740a = new TTInterSplashAdManager(activity, str);
    }

    public void destroy() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            tTInterSplashAdManager.mo37382o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            return tTInterSplashAdManager.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            return tTInterSplashAdManager.mo37380q();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        return tTInterSplashAdManager != null ? tTInterSplashAdManager.mo37379r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    public int[] getMinWindowSize() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            tTInterSplashAdManager.m59850A();
            return null;
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        return tTInterSplashAdManager != null ? tTInterSplashAdManager.mo37378s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    public Bitmap getSplashBitMap() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            tTInterSplashAdManager.m59849B();
            return null;
        }
        return null;
    }

    public void loadAd(AdSlot adSlot, TTSplashAdLoadCallback tTSplashAdLoadCallback, int i) {
        loadAd(adSlot, null, tTSplashAdLoadCallback, i);
    }

    public void setMinWindowListener(TTSplashMinWindowListener tTSplashMinWindowListener) {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            tTInterSplashAdManager.m59841a(tTSplashMinWindowListener);
        }
    }

    public void setTTAdSplashListener(TTSplashAdListener tTSplashAdListener) {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            tTInterSplashAdManager.m59842a(tTSplashAdListener);
        }
    }

    public void showAd(final ViewGroup viewGroup) {
        if (this.f21740a != null) {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.api.splash.TTSplashAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TTSplashAd.this.f21740a != null) {
                        TTSplashAd.this.f21740a.m59845a(viewGroup);
                    }
                }
            });
        }
    }

    public boolean showWindowDirect(Rect rect, TTSplashAdListener tTSplashAdListener) {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            return tTInterSplashAdManager.m59846a(rect, tTSplashAdListener);
        }
        return false;
    }

    public void splashMinWindowAnimationFinish() {
        TTInterSplashAdManager tTInterSplashAdManager = this.f21740a;
        if (tTInterSplashAdManager != null) {
            tTInterSplashAdManager.m59848C();
        }
    }

    public void loadAd(final AdSlot adSlot, final TTNetworkRequestInfo tTNetworkRequestInfo, final TTSplashAdLoadCallback tTSplashAdLoadCallback, final int i) {
        if (tTNetworkRequestInfo != null && tTNetworkRequestInfo.getAdNetworkFlatFromId() == 1 && !TextUtils.isEmpty(tTNetworkRequestInfo.getAppId()) && !TextUtils.isEmpty(ThirdSdkInit.getTTPangleAppId()) && !tTNetworkRequestInfo.getAppId().equals(ThirdSdkInit.getTTPangleAppId())) {
            if (tTSplashAdLoadCallback != null) {
                tTSplashAdLoadCallback.onSplashAdLoadFail(new AdError(AdError.ERROR_CODE_PANGLE_APPID_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_PANGLE_APPID_NO_SAME)));
            }
        } else if (this.f21740a != null) {
            if (!InternalContainer.m59943f().m59762a(this.f21740a.m37343e(), 3) && tTSplashAdLoadCallback != null) {
                tTSplashAdLoadCallback.onSplashAdLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (!InternalContainer.m59943f().m59723x()) {
                if (tTSplashAdLoadCallback != null) {
                    tTSplashAdLoadCallback.onSplashAdLoadFail(new AdError(AdError.ERROR_CODE_SPLASH_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_SPLASH_MODULE_UNABLE)));
                }
            } else if (InternalContainer.m59943f().m59731p()) {
                TTMediationAdSdk.registerConfigCallback(new TTSettingConfigCallback() { // from class: com.bytedance.msdk.api.splash.TTSplashAd.1
                    @Override // com.bytedance.msdk.api.TTSettingConfigCallback
                    public void configLoad() {
                        TTSplashAd.this.f21740a.m59843a(adSlot, tTNetworkRequestInfo, tTSplashAdLoadCallback, i);
                    }
                });
            } else {
                this.f21740a.m59843a(adSlot, tTNetworkRequestInfo, tTSplashAdLoadCallback, i);
            }
        }
    }

    @Deprecated
    public TTSplashAd(Activity activity, View view, String str) {
        this.f21740a = new TTInterSplashAdManager(activity, view, str);
    }
}
