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

/* renamed from: com.qq.e.comm.pi.POFactory */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface POFactory extends InnerPOFactory {
    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ SVSD getAPKDownloadServiceDelegate(Service service);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ ACTD getActivityDelegate(String str, Activity activity);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ String getBuyerId(Map<String, Object> map);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ String getSDKInfo(String str);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);

    @Override // com.p518qq.p519e.comm.p520pi.InnerPOFactory
    /* synthetic */ void start(JSONObject jSONObject);
}
