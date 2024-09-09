package com.bytedance.msdk.api.splash;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f;
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

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTSplashAd extends TTLoadBase {

    /* renamed from: a  reason: collision with root package name */
    private f f27483a;

    public TTSplashAd(Activity activity, String str) {
        this.f27483a = new f(activity, str);
    }

    public void destroy() {
        f fVar = this.f27483a;
        if (fVar != null) {
            fVar.o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        f fVar = this.f27483a;
        if (fVar != null) {
            return fVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        f fVar = this.f27483a;
        if (fVar != null) {
            return fVar.q();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        f fVar = this.f27483a;
        return fVar != null ? fVar.r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    public int[] getMinWindowSize() {
        f fVar = this.f27483a;
        if (fVar != null) {
            fVar.A();
            return null;
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        f fVar = this.f27483a;
        return fVar != null ? fVar.s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    public Bitmap getSplashBitMap() {
        f fVar = this.f27483a;
        if (fVar != null) {
            fVar.B();
            return null;
        }
        return null;
    }

    public void loadAd(AdSlot adSlot, TTSplashAdLoadCallback tTSplashAdLoadCallback, int i4) {
        loadAd(adSlot, null, tTSplashAdLoadCallback, i4);
    }

    public void setMinWindowListener(TTSplashMinWindowListener tTSplashMinWindowListener) {
        f fVar = this.f27483a;
        if (fVar != null) {
            fVar.a(tTSplashMinWindowListener);
        }
    }

    public void setTTAdSplashListener(TTSplashAdListener tTSplashAdListener) {
        f fVar = this.f27483a;
        if (fVar != null) {
            fVar.a(tTSplashAdListener);
        }
    }

    public void showAd(final ViewGroup viewGroup) {
        if (this.f27483a != null) {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.api.splash.TTSplashAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TTSplashAd.this.f27483a != null) {
                        TTSplashAd.this.f27483a.a(viewGroup);
                    }
                }
            });
        }
    }

    public boolean showWindowDirect(Rect rect, TTSplashAdListener tTSplashAdListener) {
        f fVar = this.f27483a;
        if (fVar != null) {
            return fVar.a(rect, tTSplashAdListener);
        }
        return false;
    }

    public void splashMinWindowAnimationFinish() {
        f fVar = this.f27483a;
        if (fVar != null) {
            fVar.C();
        }
    }

    public void loadAd(final AdSlot adSlot, final TTNetworkRequestInfo tTNetworkRequestInfo, final TTSplashAdLoadCallback tTSplashAdLoadCallback, final int i4) {
        if (tTNetworkRequestInfo != null && tTNetworkRequestInfo.getAdNetworkFlatFromId() == 1 && !TextUtils.isEmpty(tTNetworkRequestInfo.getAppId()) && !TextUtils.isEmpty(ThirdSdkInit.getTTPangleAppId()) && !tTNetworkRequestInfo.getAppId().equals(ThirdSdkInit.getTTPangleAppId())) {
            if (tTSplashAdLoadCallback != null) {
                tTSplashAdLoadCallback.onSplashAdLoadFail(new AdError(AdError.ERROR_CODE_PANGLE_APPID_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_PANGLE_APPID_NO_SAME)));
            }
        } else if (this.f27483a != null) {
            if (!a.f().a(this.f27483a.e(), 3) && tTSplashAdLoadCallback != null) {
                tTSplashAdLoadCallback.onSplashAdLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (!a.f().x()) {
                if (tTSplashAdLoadCallback != null) {
                    tTSplashAdLoadCallback.onSplashAdLoadFail(new AdError(AdError.ERROR_CODE_SPLASH_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_SPLASH_MODULE_UNABLE)));
                }
            } else if (a.f().p()) {
                TTMediationAdSdk.registerConfigCallback(new TTSettingConfigCallback() { // from class: com.bytedance.msdk.api.splash.TTSplashAd.1
                    @Override // com.bytedance.msdk.api.TTSettingConfigCallback
                    public void configLoad() {
                        TTSplashAd.this.f27483a.a(adSlot, tTNetworkRequestInfo, tTSplashAdLoadCallback, i4);
                    }
                });
            } else {
                this.f27483a.a(adSlot, tTNetworkRequestInfo, tTSplashAdLoadCallback, i4);
            }
        }
    }

    @Deprecated
    public TTSplashAd(Activity activity, View view, String str) {
        this.f27483a = new f(activity, view, str);
    }
}
