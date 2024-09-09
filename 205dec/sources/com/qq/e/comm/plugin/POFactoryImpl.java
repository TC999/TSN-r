package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;
import java.util.Map;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class POFactoryImpl extends a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile POFactory f41693a;

    private POFactoryImpl(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    public static synchronized POFactory getInstance(Context context, JSONObject jSONObject) {
        return (POFactory) pro.getobjresult(109, 1, context, jSONObject);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ SVSD getAPKDownloadServiceDelegate(Service service) {
        return (SVSD) pro.getobjresult(110, 0, this, service);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ ACTD getActivityDelegate(String str, Activity activity) {
        return (ACTD) pro.getobjresult(111, 0, this, str, activity);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ String getBuyerId() {
        return (String) pro.getobjresult(112, 0, this);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ String getBuyerId(Map map) {
        return (String) pro.getobjresult(113, 0, this, map);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener) {
        return (DFA) pro.getobjresult(114, 0, this, iGDTApkListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        return (HADI) pro.getobjresult(115, 0, this, hybridADSetting, hybridADListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (NUADI) pro.getobjresult(116, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        return (NEADI) pro.getobjresult(117, 0, this, context, aDSize, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3) {
        return (NSPVI) pro.getobjresult(118, 0, this, context, str, str2, str3);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (RVADI) pro.getobjresult(119, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ String getSDKInfo(String str) {
        return (String) pro.getobjresult(120, 0, this, str);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UBVI) pro.getobjresult(121, 0, this, unifiedBannerView, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UIADI) pro.getobjresult(122, 0, this, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        return pro.getIresult(123, 0, this, gDTAppDialogClickListener);
    }

    @Override // com.qq.e.comm.plugin.a, com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public /* bridge */ /* synthetic */ void start(JSONObject jSONObject) {
        pro.getVresult(124, 0, this, jSONObject);
    }
}
