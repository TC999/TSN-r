package com.bytedance.msdk.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdCacheManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdnLoadFailShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ServerBiddingWinner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.TTExtraModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.NetworkUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTUIUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.Sdk;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.InterAdError;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTAbsAdLoaderAdapter {
    protected static final int MAX_INTERVAL_TIME = 120;
    protected static final int MIN_INTERVAL_TIME = 30;

    /* renamed from: a */
    private AdapterLoaderListener f21300a;

    /* renamed from: b */
    private WaterFallConfig f21301b;

    /* renamed from: c */
    private String f21302c;

    /* renamed from: d */
    private int f21303d;

    /* renamed from: e */
    private int f21304e;

    /* renamed from: f */
    private double f21305f;

    /* renamed from: g */
    private String f21306g;

    /* renamed from: h */
    private String f21307h;

    /* renamed from: i */
    private long f21308i;

    /* renamed from: j */
    private long f21309j;

    /* renamed from: k */
    private int f21310k;

    /* renamed from: l */
    private int f21311l;

    /* renamed from: m */
    private int f21312m;
    protected AdSlot mAdSlot;
    protected TTExtraModel mTTExtraModel;
    protected String mWaterfallAbTestParam;

    /* renamed from: n */
    private ServerBiddingWinner f21313n;

    /* renamed from: o */
    private int f21314o;

    /* renamed from: p */
    private int f21315p;

    /* renamed from: q */
    private String f21316q;

    /* renamed from: r */
    private boolean f21317r;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface AdapterLoaderListener {
        void onAdFailed(AdError adError, ExtraParam extraParam);

        void onAdLoaded(TTBaseAd tTBaseAd, ExtraParam extraParam);

        void onAdLoaded(List<TTBaseAd> list, ExtraParam extraParam);

        void onAdVideoCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CallBackRunnable implements Runnable {

        /* renamed from: a */
        private String f21321a;

        /* renamed from: b */
        private TTBaseAd f21322b;

        /* renamed from: c */
        private List<TTBaseAd> f21323c;

        /* renamed from: d */
        private AdError f21324d;

        CallBackRunnable(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError) {
            this.f21321a = str;
            this.f21322b = tTBaseAd;
            this.f21323c = list;
            this.f21324d = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            if (TTAbsAdLoaderAdapter.this.f21300a != null) {
                ExtraParam extraParam = new ExtraParam();
                extraParam.m59527a(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType()).m59524b(TTAbsAdLoaderAdapter.this.f21315p).m59521c(TTAbsAdLoaderAdapter.this.f21303d).m59519d(TTAbsAdLoaderAdapter.this.f21304e).m59526a(TTAbsAdLoaderAdapter.this.getAdNetWorkName()).m59523b(TTAbsAdLoaderAdapter.this.f21316q);
                if (!"adload_ads".equals(this.f21321a) && !"adload_ad".equals(this.f21321a)) {
                    if ("failed".equals(this.f21321a)) {
                        if (TTAbsAdLoaderAdapter.this.f21315p != 2) {
                            AdError adError = this.f21324d;
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = TTAbsAdLoaderAdapter.this;
                            AdEventUtil.m59323a(adError, tTAbsAdLoaderAdapter.mAdSlot, tTAbsAdLoaderAdapter.f21301b, TTAbsAdLoaderAdapter.this.f21310k, TTAbsAdLoaderAdapter.this.f21311l, TTAbsAdLoaderAdapter.this.f21312m, TTAbsAdLoaderAdapter.this.getSdkVersion(), TTAbsAdLoaderAdapter.this.f21309j, TTAbsAdLoaderAdapter.this.f21317r);
                        }
                        InterAdError interAdError = new InterAdError(this.f21324d);
                        interAdError.m37365a(TTAbsAdLoaderAdapter.this.mWaterfallAbTestParam);
                        if (this.f21324d != null) {
                            if (Sdk.f21750c) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f21302c, TTLogUtil.TAG_EVENT_FILL_FAIL));
                                sb.append("AdNetWorkName[");
                                sb.append(TTAbsAdLoaderAdapter.this.getAdNetWorkName());
                                sb.append("] AdUnitId[");
                                sb.append(TTAbsAdLoaderAdapter.this.f21316q);
                                sb.append("] AdType[");
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter2 = TTAbsAdLoaderAdapter.this;
                                sb.append(tTAbsAdLoaderAdapter2.m37878e(tTAbsAdLoaderAdapter2.mAdSlot, tTAbsAdLoaderAdapter2.getAdNetWorkName(), C6031a.m37435c(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                                sb.append("] 请求失败 (loadSort=");
                                sb.append(TTAbsAdLoaderAdapter.this.f21303d);
                                sb.append(",showSort=");
                                sb.append(TTAbsAdLoaderAdapter.this.f21304e);
                                sb.append("),error=");
                                sb.append(this.f21324d.thirdSdkErrorCode);
                                sb.append(",msg=");
                                sb.append(this.f21324d.thirdSdkErrorMessage);
                                Logger.m37557e("TTMediationSDK", sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f21302c, TTLogUtil.TAG_EVENT_FILL_FAIL));
                                sb2.append("AdNetWorkName[");
                                sb2.append(TTAbsAdLoaderAdapter.this.getAdNetWorkName());
                                sb2.append("] AdType[");
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter3 = TTAbsAdLoaderAdapter.this;
                                sb2.append(tTAbsAdLoaderAdapter3.m37878e(tTAbsAdLoaderAdapter3.mAdSlot, tTAbsAdLoaderAdapter3.getAdNetWorkName(), C6031a.m37435c(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                                sb2.append("] 请求失败 error=");
                                sb2.append(this.f21324d.thirdSdkErrorCode);
                                sb2.append(",msg=");
                                sb2.append(this.f21324d.thirdSdkErrorMessage);
                                Logger.m37557e("TTMediationSDK", sb2.toString());
                            }
                            if (TTAbsAdLoaderAdapter.this.f21301b != null) {
                                String str = this.f21324d.thirdSdkErrorCode + "";
                                String m37877f = TTAbsAdLoaderAdapter.this.m37877f(this.f21324d.thirdSdkErrorMessage);
                                Logger.m37557e("TTMediationSDK", "errorCode = " + str + " errorCodeList = " + m37877f);
                                AdnLoadFailShowControl m59628a = AdnLoadFailShowControl.m59628a();
                                String m59477d = TTAbsAdLoaderAdapter.this.f21301b.m59477d();
                                String m59480c = TTAbsAdLoaderAdapter.this.f21301b.m59480c();
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter4 = TTAbsAdLoaderAdapter.this;
                                m59628a.m59626a(m59477d, m59480c, tTAbsAdLoaderAdapter4.m37876g(tTAbsAdLoaderAdapter4.f21301b.m59477d(), str, m37877f));
                            }
                        }
                        if (TTAbsAdLoaderAdapter.this.f21300a != null) {
                            TTAbsAdLoaderAdapter.this.f21300a.onAdFailed(interAdError, extraParam);
                            return;
                        }
                        return;
                    } else if ("ad_video_cache".equals(this.f21321a)) {
                        TTBaseAd tTBaseAd = this.f21322b;
                        if (tTBaseAd != null && (tTBaseAd.getAdType() == 8 || this.f21322b.getAdType() == 7)) {
                            AdError adError2 = this.f21324d;
                            if (adError2 != null && adError2.code == 30010 && TTAbsAdLoaderAdapter.this.m37870m()) {
                                ThreadHelper.postDelayOnMSDKThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.CallBackRunnable.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        CallBackRunnable.this.f21322b.setCacheSuccess(true);
                                        CallBackRunnable callBackRunnable = CallBackRunnable.this;
                                        TTAbsAdLoaderAdapter.this.m37872k(callBackRunnable.f21322b);
                                        if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                                            AdEventUtil.m59310a(CallBackRunnable.this.f21322b, TTAbsAdLoaderAdapter.this.mAdSlot);
                                        }
                                        if (TTAbsAdLoaderAdapter.this.f21300a != null) {
                                            TTAbsAdLoaderAdapter.this.f21300a.onAdVideoCache();
                                        }
                                    }
                                }, 1000L);
                                return;
                            }
                            this.f21322b.setCacheSuccess(true);
                            TTAbsAdLoaderAdapter.this.m37872k(this.f21322b);
                            if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                                AdEventUtil.m59310a(this.f21322b, TTAbsAdLoaderAdapter.this.mAdSlot);
                            }
                            if (TTAbsAdLoaderAdapter.this.f21300a != null) {
                                TTAbsAdLoaderAdapter.this.f21300a.onAdVideoCache();
                                return;
                            }
                            return;
                        }
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f21302c, TTLogUtil.TAG_EVENT_FILL) + "onAdVideoCache-----ttAd=" + this.f21322b);
                        return;
                    } else {
                        return;
                    }
                }
                TTBaseAd tTBaseAd2 = null;
                if ("adload_ads".equals(this.f21321a)) {
                    List<TTBaseAd> list = this.f21323c;
                    int size = list != null ? list.size() : 0;
                    List<TTBaseAd> list2 = this.f21323c;
                    i = (list2 == null || list2.size() <= 0) ? 20001 : 20001;
                    for (TTBaseAd tTBaseAd3 : this.f21323c) {
                        if (tTBaseAd3 != null) {
                            TTAbsAdLoaderAdapter.this.m37867p(tTBaseAd3);
                            if (tTBaseAd2 == null) {
                                tTBaseAd2 = tTBaseAd3;
                            }
                        }
                    }
                    TTAbsAdLoaderAdapter.this.m37875h(i, tTBaseAd2, size);
                    if (TTAbsAdLoaderAdapter.this.f21300a != null) {
                        TTAbsAdLoaderAdapter.this.f21300a.onAdLoaded(this.f21323c, extraParam);
                    }
                    if (!TTAbsAdLoaderAdapter.this.isServerBidding() || TTCollectionUtils.m59111b(this.f21323c)) {
                        return;
                    }
                    AdEventUtil.m59303b(this.f21323c.get(0), TTAbsAdLoaderAdapter.this.mAdSlot);
                    return;
                }
                TTBaseAd tTBaseAd4 = this.f21322b;
                i = tTBaseAd4 == null ? 20001 : 20000;
                TTAbsAdLoaderAdapter.this.m37867p(tTBaseAd4);
                TTAbsAdLoaderAdapter.this.m37875h(i, this.f21322b, 1);
                if (TTAbsAdLoaderAdapter.this.f21300a != null) {
                    TTAbsAdLoaderAdapter.this.f21300a.onAdLoaded(this.f21322b, extraParam);
                }
                if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                    AdEventUtil.m59303b(this.f21322b, TTAbsAdLoaderAdapter.this.mAdSlot);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m37878e(AdSlot adSlot, String str, String str2) {
        if (adSlot == null) {
            return "";
        }
        if ("gdt".equals(str) && adSlot.getAdStyleType() == 1 && 5 == adSlot.getAdType()) {
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            int feedExpressType = (tTVideoOption == null || tTVideoOption.getGDTExtraOption() == null) ? 1 : tTVideoOption.getGDTExtraOption().getFeedExpressType();
            if (feedExpressType == 1) {
                return str2 + "(1.0)";
            } else if (feedExpressType == 2) {
                return str2 + "(2.0)";
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m37877f(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                sb.append(c);
                if (i == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
            i++;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : arrayList) {
            sb2.append(str2);
            sb2.append("_");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public String m37876g(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && str.equals("gdt")) {
            return str2 + "_" + str3;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m37875h(int i, TTBaseAd tTBaseAd, int i2) {
        String str = i == 20000 ? AdError.AD_LOAD_SUCCESS_MSG : AdError.AD_NO_FILL;
        if (this.f21315p != 2 && tTBaseAd != null) {
            AdEventUtil.m59311a(tTBaseAd, i, str, this.f21309j, this.mAdSlot, this.f21310k, i2, this.f21317r);
        }
        if (Sdk.f21750c) {
            Logger.m37554i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21302c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdUnitId[" + this.f21316q + "] AdType[" + m37878e(this.mAdSlot, getAdNetWorkName(), C6031a.m37435c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType())) + "] 请求成功 (loadSort=" + this.f21303d + ",showSort=" + this.f21304e + ")");
            return;
        }
        Logger.m37554i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21302c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdType[" + m37878e(this.mAdSlot, getAdNetWorkName(), C6031a.m37435c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType())) + "] 请求成功");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m37872k(TTBaseAd tTBaseAd) {
        AdEventUtil.m59317a(this.mAdSlot, tTBaseAd);
        if (Sdk.f21750c) {
            Logger.m37554i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21302c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdUnitId[" + this.f21316q + "] AdType[" + C6031a.m37435c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType()) + "] 视频缓存成功 (loadSort=" + this.f21303d + ",showSort=" + this.f21304e + ")");
            return;
        }
        Logger.m37554i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21302c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdType[" + C6031a.m37435c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType()) + "] 视频缓存成功 ");
    }

    /* renamed from: l */
    private void m37871l(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError) {
        ThreadHelper.runOnMSDKThread(new CallBackRunnable(str, tTBaseAd, list, adError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public boolean m37870m() {
        return InternalContainer.m59943f().m59770A() && (NetworkUtils.m59166e(InternalContainer.m59945d()) || NetworkUtils.m59165f(InternalContainer.m59945d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m37867p(TTBaseAd tTBaseAd) {
        WaterFallConfig waterFallConfig;
        if (tTBaseAd == null) {
            return;
        }
        if (tTBaseAd.getCpm() == Utils.DOUBLE_EPSILON) {
            double d = this.f21305f;
            if (d != Utils.DOUBLE_EPSILON) {
                tTBaseAd.setCpm(d);
            }
        }
        if (isServerBidding() && (waterFallConfig = this.f21301b) != null) {
            tTBaseAd.setServerBiddingCpm(waterFallConfig.m59455p());
        }
        tTBaseAd.setAdNetworkSlotType(this.f21315p);
        tTBaseAd.setLoadSort(this.f21303d);
        tTBaseAd.setShowSort(this.f21304e);
        tTBaseAd.setSdkVersion(getSdkVersion());
        tTBaseAd.setAdNetWorkName(getAdNetWorkName());
        tTBaseAd.setExchangeRate(this.f21307h);
        tTBaseAd.setAdNetworkSlotId(this.f21316q);
        tTBaseAd.setRit(this.f21302c);
        tTBaseAd.putEventParam("waterfall_abtest", this.mWaterfallAbTestParam);
        tTBaseAd.setSdkNum(C6031a.m37437a(getAdNetWorkName()));
        tTBaseAd.setMediationRitReqTypeFromRealReq(this.f21311l);
        tTBaseAd.setMediationRitReqTypeSrcFromRealReq(this.f21312m);
        tTBaseAd.setLinkIdFromRealReq(this.f21306g);
        tTBaseAd.setMediationRitReqType(this.f21311l);
        tTBaseAd.setMediationRitReqTypeSrc(this.f21312m);
        WaterFallConfig waterFallConfig2 = this.f21301b;
        tTBaseAd.setOriginType(waterFallConfig2 != null ? waterFallConfig2.m59457n() : -1);
        ServerBiddingWinner serverBiddingWinner = this.f21313n;
        if (serverBiddingWinner != null) {
            tTBaseAd.putEventParam("win_call_back", serverBiddingWinner.m59492e());
            tTBaseAd.putEventParam("fail_call_back", this.f21313n.m59498b());
        }
        TTExtraModel tTExtraModel = this.mTTExtraModel;
        if (tTExtraModel != null) {
            tTBaseAd.putEventParam("if_test", Integer.valueOf(tTExtraModel.f539b));
            tTBaseAd.putEventParam("server_bidding_extra", this.mTTExtraModel.f538a);
        }
    }

    public abstract void destroy();

    public final int getAdLoadCount() {
        return this.f21314o;
    }

    public abstract String getAdNetWorkName();

    public AdSlot getAdSlot() {
        return this.mAdSlot;
    }

    public final String getAdSlotId() {
        return this.f21316q;
    }

    public String getAdapterRit() {
        return this.f21302c;
    }

    public final String getAdm() {
        ServerBiddingWinner serverBiddingWinner;
        if (isServerBidding() && (serverBiddingWinner = this.f21313n) != null) {
            return serverBiddingWinner.m59500a();
        }
        return null;
    }

    public String getClientReqId() {
        String str = !TextUtils.isEmpty(this.f21306g) ? this.f21306g : null;
        if (TextUtils.isEmpty(this.f21316q)) {
            return str;
        }
        return (str + "_") + this.f21316q;
    }

    public int getIfTest() {
        TTExtraModel tTExtraModel = this.mTTExtraModel;
        if (tTExtraModel != null) {
            return tTExtraModel.f539b;
        }
        return 0;
    }

    public abstract String getSdkVersion();

    public final boolean isBidding() {
        return isServerBidding() || isClientBidding();
    }

    public boolean isClientBidding() {
        return this.f21315p == 1;
    }

    public boolean isServerBidding() {
        return this.f21315p == 2;
    }

    public abstract void loadAd(Context context, Map<String, Object> map);

    public final void loadAdInter(@NonNull final Context context, @NonNull WaterFallConfig waterFallConfig, @NonNull final Map<String, Object> map, @NonNull AdSlot adSlot, TTExtraModel tTExtraModel, int i) {
        this.f21301b = waterFallConfig;
        this.f21302c = adSlot.getAdUnitId();
        this.f21314o = adSlot.getAdCount();
        this.f21306g = adSlot.getLinkedId();
        this.f21303d = waterFallConfig.m59459l();
        this.f21304e = waterFallConfig.m59452s();
        this.f21316q = waterFallConfig.m59480c();
        this.f21313n = waterFallConfig.m59453r();
        this.f21307h = waterFallConfig.m59465h();
        this.mAdSlot = adSlot;
        this.mTTExtraModel = tTExtraModel;
        this.f21315p = waterFallConfig.m59474e();
        this.mWaterfallAbTestParam = waterFallConfig.m59451t();
        this.f21310k = i;
        Object obj = map.get("key_mediation_rit_req_type");
        this.f21311l = obj != null ? ((Integer) obj).intValue() : 1;
        Object obj2 = map.get("key_mediation_rit_req_type_src");
        this.f21312m = obj2 != null ? ((Integer) obj2).intValue() : 1;
        if (!AdnLoadFailShowControl.m59628a().m59627a(waterFallConfig.m59477d(), waterFallConfig.m59480c())) {
            AdBreakError adBreakError = new AdBreakError(AdError.ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL, AdError.getMessage(AdError.ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL));
            AdEventUtil.m59326a(waterFallConfig, adSlot, getSdkVersion(), i, this.f21311l, this.f21312m, adBreakError);
            notifyAdFailed(adBreakError);
            return;
        }
        if (!waterFallConfig.m59450u()) {
            AdEventUtil.m59326a(waterFallConfig, adSlot, getSdkVersion(), i, this.f21311l, this.f21312m, (AdError) null);
        }
        if (!isBidding()) {
            this.f21305f = waterFallConfig.m59471f();
        }
        this.f21308i = System.currentTimeMillis();
        AdCacheManager.m59712a().m59705a(waterFallConfig.m59480c(), getSdkVersion());
        if (!TextUtils.equals("mintegral", waterFallConfig.m59477d()) && !TextUtils.equals("baidu", waterFallConfig.m59477d()) && !TextUtils.equals("admob", waterFallConfig.m59477d())) {
            loadAd(context, map);
        } else {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    TTAbsAdLoaderAdapter.this.loadAd(context, map);
                }
            });
        }
    }

    public final void notifyAdFailed(AdError adError) {
        this.f21309j = System.currentTimeMillis() - this.f21308i;
        m37871l("failed", null, null, adError);
    }

    public final void notifyAdLoaded(TTBaseAd tTBaseAd) {
        this.f21309j = System.currentTimeMillis() - this.f21308i;
        m37871l("adload_ad", tTBaseAd, null, null);
    }

    public final void notifyAdVideoCache(TTBaseAd tTBaseAd, AdError adError) {
        m37871l("ad_video_cache", tTBaseAd, null, adError);
    }

    public void removeFromParent(View view) {
        TTUIUtils.m59087a(view);
    }

    public final void setAdapterListener(AdapterLoaderListener adapterLoaderListener) {
        this.f21300a = adapterLoaderListener;
    }

    public void setTotalTimedOut(boolean z) {
        this.f21317r = z;
    }

    public final void notifyAdLoaded(List<TTBaseAd> list) {
        this.f21309j = System.currentTimeMillis() - this.f21308i;
        m37871l("adload_ads", null, list, null);
    }
}
