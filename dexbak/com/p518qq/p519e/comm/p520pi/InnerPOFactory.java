package com.p518qq.p519e.comm.p520pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.p518qq.p519e.ads.banner2.UnifiedBannerView;
import com.p518qq.p519e.ads.dfa.GDTAppDialogClickListener;
import com.p518qq.p519e.ads.dfa.IGDTApkListener;
import com.p518qq.p519e.ads.hybrid.HybridADListener;
import com.p518qq.p519e.ads.hybrid.HybridADSetting;
import com.p518qq.p519e.ads.nativ.ADSize;
import com.p518qq.p519e.comm.adevent.ADListener;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.pi.InnerPOFactory */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
interface InnerPOFactory {
    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    String getBuyerId();

    String getBuyerId(Map<String, Object> map);

    DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    String getSDKInfo(String str);

    UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener);

    UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);

    void start(JSONObject jSONObject);
}
