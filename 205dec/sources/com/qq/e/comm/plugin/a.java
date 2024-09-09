package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
import com.qq.e.comm.plugin.util.c1;
import java.util.Map;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a implements POFactory {
    public static final String DIALOG_ACTIVITY = "dialogActivity";
    public static final String DOWNLOAD_MANAGE = "downloadManage";
    public static final String FULLSCREEN_ACTIVITY = "fullscreenActivity";
    public static final String HYBRID_AD_PAGE = "hybridADPage";
    public static final String INNER_BROWSER = "innerBrowser";
    public static final String MIIT_INFO_DISPLAY = "miitInfoDisplay";
    public static final String REWARD_PAGE = "rewardPage";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, JSONObject jSONObject) {
        c1.a(context, jSONObject);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public SVSD getAPKDownloadServiceDelegate(Service service) {
        return (SVSD) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 0, this, service);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public ACTD getActivityDelegate(String str, Activity activity) {
        return (ACTD) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 0, this, str, activity);
    }

    @Override // com.qq.e.comm.pi.InnerPOFactory
    public String getBuyerId() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 0, this);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public String getBuyerId(Map<String, Object> map) {
        return (String) pro.getobjresult(250, 0, this, map);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener) {
        return (DFA) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 0, this, iGDTApkListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        return (HADI) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 0, this, hybridADSetting, hybridADListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (NUADI) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        return (NEADI) pro.getobjresult(254, 0, this, context, aDSize, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public synchronized NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3) {
        return (NSPVI) pro.getobjresult(255, 0, this, context, str, str2, str3);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener) {
        return (RVADI) pro.getobjresult(256, 0, this, context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public String getSDKInfo(String str) {
        return (String) pro.getobjresult(257, 0, this, str);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UBVI) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 0, this, unifiedBannerView, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        return (UIADI) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 0, this, activity, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 0, this, gDTAppDialogClickListener);
    }

    @Override // com.qq.e.comm.pi.POFactory, com.qq.e.comm.pi.InnerPOFactory
    public void start(JSONObject jSONObject) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, 0, this, jSONObject);
    }
}
