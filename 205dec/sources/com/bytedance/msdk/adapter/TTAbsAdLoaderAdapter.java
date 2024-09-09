package com.bytedance.msdk.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.z;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.base.a;
import com.bytedance.msdk.core.corelogic.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class TTAbsAdLoaderAdapter {
    protected static final int MAX_INTERVAL_TIME = 120;
    protected static final int MIN_INTERVAL_TIME = 30;

    /* renamed from: a  reason: collision with root package name */
    private AdapterLoaderListener f26884a;

    /* renamed from: b  reason: collision with root package name */
    private h f26885b;

    /* renamed from: c  reason: collision with root package name */
    private String f26886c;

    /* renamed from: d  reason: collision with root package name */
    private int f26887d;

    /* renamed from: e  reason: collision with root package name */
    private int f26888e;

    /* renamed from: f  reason: collision with root package name */
    private double f26889f;

    /* renamed from: g  reason: collision with root package name */
    private String f26890g;

    /* renamed from: h  reason: collision with root package name */
    private String f26891h;

    /* renamed from: i  reason: collision with root package name */
    private long f26892i;

    /* renamed from: j  reason: collision with root package name */
    private long f26893j;

    /* renamed from: k  reason: collision with root package name */
    private int f26894k;

    /* renamed from: l  reason: collision with root package name */
    private int f26895l;

    /* renamed from: m  reason: collision with root package name */
    private int f26896m;
    protected AdSlot mAdSlot;
    protected g mTTExtraModel;
    protected String mWaterfallAbTestParam;

    /* renamed from: n  reason: collision with root package name */
    private f f26897n;

    /* renamed from: o  reason: collision with root package name */
    private int f26898o;

    /* renamed from: p  reason: collision with root package name */
    private int f26899p;

    /* renamed from: q  reason: collision with root package name */
    private String f26900q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f26901r;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface AdapterLoaderListener {
        void onAdFailed(AdError adError, d dVar);

        void onAdLoaded(TTBaseAd tTBaseAd, d dVar);

        void onAdLoaded(List<TTBaseAd> list, d dVar);

        void onAdVideoCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class CallBackRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f26905a;

        /* renamed from: b  reason: collision with root package name */
        private TTBaseAd f26906b;

        /* renamed from: c  reason: collision with root package name */
        private List<TTBaseAd> f26907c;

        /* renamed from: d  reason: collision with root package name */
        private AdError f26908d;

        CallBackRunnable(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError) {
            this.f26905a = str;
            this.f26906b = tTBaseAd;
            this.f26907c = list;
            this.f26908d = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            if (TTAbsAdLoaderAdapter.this.f26884a != null) {
                d dVar = new d();
                dVar.a(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType()).b(TTAbsAdLoaderAdapter.this.f26899p).c(TTAbsAdLoaderAdapter.this.f26887d).d(TTAbsAdLoaderAdapter.this.f26888e).a(TTAbsAdLoaderAdapter.this.getAdNetWorkName()).b(TTAbsAdLoaderAdapter.this.f26900q);
                if (!"adload_ads".equals(this.f26905a) && !"adload_ad".equals(this.f26905a)) {
                    if ("failed".equals(this.f26905a)) {
                        if (TTAbsAdLoaderAdapter.this.f26899p != 2) {
                            AdError adError = this.f26908d;
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = TTAbsAdLoaderAdapter.this;
                            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adError, tTAbsAdLoaderAdapter.mAdSlot, tTAbsAdLoaderAdapter.f26885b, TTAbsAdLoaderAdapter.this.f26894k, TTAbsAdLoaderAdapter.this.f26895l, TTAbsAdLoaderAdapter.this.f26896m, TTAbsAdLoaderAdapter.this.getSdkVersion(), TTAbsAdLoaderAdapter.this.f26893j, TTAbsAdLoaderAdapter.this.f26901r);
                        }
                        b bVar = new b(this.f26908d);
                        bVar.a(TTAbsAdLoaderAdapter.this.mWaterfallAbTestParam);
                        if (this.f26908d != null) {
                            if (com.bytedance.msdk.base.b.f27664c) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f26886c, TTLogUtil.TAG_EVENT_FILL_FAIL));
                                sb.append("AdNetWorkName[");
                                sb.append(TTAbsAdLoaderAdapter.this.getAdNetWorkName());
                                sb.append("] AdUnitId[");
                                sb.append(TTAbsAdLoaderAdapter.this.f26900q);
                                sb.append("] AdType[");
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter2 = TTAbsAdLoaderAdapter.this;
                                sb.append(tTAbsAdLoaderAdapter2.e(tTAbsAdLoaderAdapter2.mAdSlot, tTAbsAdLoaderAdapter2.getAdNetWorkName(), a.c(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                                sb.append("] \u8bf7\u6c42\u5931\u8d25 (loadSort=");
                                sb.append(TTAbsAdLoaderAdapter.this.f26887d);
                                sb.append(",showSort=");
                                sb.append(TTAbsAdLoaderAdapter.this.f26888e);
                                sb.append("),error=");
                                sb.append(this.f26908d.thirdSdkErrorCode);
                                sb.append(",msg=");
                                sb.append(this.f26908d.thirdSdkErrorMessage);
                                Logger.e("TTMediationSDK", sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f26886c, TTLogUtil.TAG_EVENT_FILL_FAIL));
                                sb2.append("AdNetWorkName[");
                                sb2.append(TTAbsAdLoaderAdapter.this.getAdNetWorkName());
                                sb2.append("] AdType[");
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter3 = TTAbsAdLoaderAdapter.this;
                                sb2.append(tTAbsAdLoaderAdapter3.e(tTAbsAdLoaderAdapter3.mAdSlot, tTAbsAdLoaderAdapter3.getAdNetWorkName(), a.c(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                                sb2.append("] \u8bf7\u6c42\u5931\u8d25 error=");
                                sb2.append(this.f26908d.thirdSdkErrorCode);
                                sb2.append(",msg=");
                                sb2.append(this.f26908d.thirdSdkErrorMessage);
                                Logger.e("TTMediationSDK", sb2.toString());
                            }
                            if (TTAbsAdLoaderAdapter.this.f26885b != null) {
                                String str = this.f26908d.thirdSdkErrorCode + "";
                                String f4 = TTAbsAdLoaderAdapter.this.f(this.f26908d.thirdSdkErrorMessage);
                                Logger.e("TTMediationSDK", "errorCode = " + str + " errorCodeList = " + f4);
                                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c.a();
                                String d4 = TTAbsAdLoaderAdapter.this.f26885b.d();
                                String c4 = TTAbsAdLoaderAdapter.this.f26885b.c();
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter4 = TTAbsAdLoaderAdapter.this;
                                a4.a(d4, c4, tTAbsAdLoaderAdapter4.g(tTAbsAdLoaderAdapter4.f26885b.d(), str, f4));
                            }
                        }
                        if (TTAbsAdLoaderAdapter.this.f26884a != null) {
                            TTAbsAdLoaderAdapter.this.f26884a.onAdFailed(bVar, dVar);
                            return;
                        }
                        return;
                    } else if ("ad_video_cache".equals(this.f26905a)) {
                        TTBaseAd tTBaseAd = this.f26906b;
                        if (tTBaseAd != null && (tTBaseAd.getAdType() == 8 || this.f26906b.getAdType() == 7)) {
                            AdError adError2 = this.f26908d;
                            if (adError2 != null && adError2.code == 30010 && TTAbsAdLoaderAdapter.this.m()) {
                                ThreadHelper.postDelayOnMSDKThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.CallBackRunnable.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        CallBackRunnable.this.f26906b.setCacheSuccess(true);
                                        CallBackRunnable callBackRunnable = CallBackRunnable.this;
                                        TTAbsAdLoaderAdapter.this.k(callBackRunnable.f26906b);
                                        if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                                            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(CallBackRunnable.this.f26906b, TTAbsAdLoaderAdapter.this.mAdSlot);
                                        }
                                        if (TTAbsAdLoaderAdapter.this.f26884a != null) {
                                            TTAbsAdLoaderAdapter.this.f26884a.onAdVideoCache();
                                        }
                                    }
                                }, 1000L);
                                return;
                            }
                            this.f26906b.setCacheSuccess(true);
                            TTAbsAdLoaderAdapter.this.k(this.f26906b);
                            if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f26906b, TTAbsAdLoaderAdapter.this.mAdSlot);
                            }
                            if (TTAbsAdLoaderAdapter.this.f26884a != null) {
                                TTAbsAdLoaderAdapter.this.f26884a.onAdVideoCache();
                                return;
                            }
                            return;
                        }
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f26886c, TTLogUtil.TAG_EVENT_FILL) + "onAdVideoCache-----ttAd=" + this.f26906b);
                        return;
                    } else {
                        return;
                    }
                }
                TTBaseAd tTBaseAd2 = null;
                if ("adload_ads".equals(this.f26905a)) {
                    List<TTBaseAd> list = this.f26907c;
                    int size = list != null ? list.size() : 0;
                    List<TTBaseAd> list2 = this.f26907c;
                    i4 = (list2 == null || list2.size() <= 0) ? 20001 : 20001;
                    for (TTBaseAd tTBaseAd3 : this.f26907c) {
                        if (tTBaseAd3 != null) {
                            TTAbsAdLoaderAdapter.this.p(tTBaseAd3);
                            if (tTBaseAd2 == null) {
                                tTBaseAd2 = tTBaseAd3;
                            }
                        }
                    }
                    TTAbsAdLoaderAdapter.this.h(i4, tTBaseAd2, size);
                    if (TTAbsAdLoaderAdapter.this.f26884a != null) {
                        TTAbsAdLoaderAdapter.this.f26884a.onAdLoaded(this.f26907c, dVar);
                    }
                    if (!TTAbsAdLoaderAdapter.this.isServerBidding() || u.b(this.f26907c)) {
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.b(this.f26907c.get(0), TTAbsAdLoaderAdapter.this.mAdSlot);
                    return;
                }
                TTBaseAd tTBaseAd4 = this.f26906b;
                i4 = tTBaseAd4 == null ? 20001 : 20000;
                TTAbsAdLoaderAdapter.this.p(tTBaseAd4);
                TTAbsAdLoaderAdapter.this.h(i4, this.f26906b, 1);
                if (TTAbsAdLoaderAdapter.this.f26884a != null) {
                    TTAbsAdLoaderAdapter.this.f26884a.onAdLoaded(this.f26906b, dVar);
                }
                if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.b(this.f26906b, TTAbsAdLoaderAdapter.this.mAdSlot);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(AdSlot adSlot, String str, String str2) {
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
    public String f(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i4 = 0;
        while (true) {
            if (i4 >= charArray.length) {
                break;
            }
            char c4 = charArray[i4];
            if (c4 >= '0' && c4 <= '9') {
                sb.append(c4);
                if (i4 == charArray.length - 1) {
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
            i4++;
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
    public String g(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && str.equals("gdt")) {
            return str2 + "_" + str3;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i4, TTBaseAd tTBaseAd, int i5) {
        String str = i4 == 20000 ? AdError.AD_LOAD_SUCCESS_MSG : AdError.AD_NO_FILL;
        if (this.f26899p != 2 && tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(tTBaseAd, i4, str, this.f26893j, this.mAdSlot, this.f26894k, i5, this.f26901r);
        }
        if (com.bytedance.msdk.base.b.f27664c) {
            Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f26886c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdUnitId[" + this.f26900q + "] AdType[" + e(this.mAdSlot, getAdNetWorkName(), a.c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType())) + "] \u8bf7\u6c42\u6210\u529f (loadSort=" + this.f26887d + ",showSort=" + this.f26888e + ")");
            return;
        }
        Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f26886c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdType[" + e(this.mAdSlot, getAdNetWorkName(), a.c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType())) + "] \u8bf7\u6c42\u6210\u529f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TTBaseAd tTBaseAd) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.mAdSlot, tTBaseAd);
        if (com.bytedance.msdk.base.b.f27664c) {
            Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f26886c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdUnitId[" + this.f26900q + "] AdType[" + a.c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType()) + "] \u89c6\u9891\u7f13\u5b58\u6210\u529f (loadSort=" + this.f26887d + ",showSort=" + this.f26888e + ")");
            return;
        }
        Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f26886c, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAdNetWorkName() + "] AdType[" + a.c(this.mAdSlot.getAdType(), this.mAdSlot.getAdStyleType()) + "] \u89c6\u9891\u7f13\u5b58\u6210\u529f ");
    }

    private void l(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError) {
        ThreadHelper.runOnMSDKThread(new CallBackRunnable(str, tTBaseAd, list, adError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().A() && (n.e(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()) || n.f(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(TTBaseAd tTBaseAd) {
        h hVar;
        if (tTBaseAd == null) {
            return;
        }
        if (tTBaseAd.getCpm() == 0.0d) {
            double d4 = this.f26889f;
            if (d4 != 0.0d) {
                tTBaseAd.setCpm(d4);
            }
        }
        if (isServerBidding() && (hVar = this.f26885b) != null) {
            tTBaseAd.setServerBiddingCpm(hVar.p());
        }
        tTBaseAd.setAdNetworkSlotType(this.f26899p);
        tTBaseAd.setLoadSort(this.f26887d);
        tTBaseAd.setShowSort(this.f26888e);
        tTBaseAd.setSdkVersion(getSdkVersion());
        tTBaseAd.setAdNetWorkName(getAdNetWorkName());
        tTBaseAd.setExchangeRate(this.f26891h);
        tTBaseAd.setAdNetworkSlotId(this.f26900q);
        tTBaseAd.setRit(this.f26886c);
        tTBaseAd.putEventParam("waterfall_abtest", this.mWaterfallAbTestParam);
        tTBaseAd.setSdkNum(a.a(getAdNetWorkName()));
        tTBaseAd.setMediationRitReqTypeFromRealReq(this.f26895l);
        tTBaseAd.setMediationRitReqTypeSrcFromRealReq(this.f26896m);
        tTBaseAd.setLinkIdFromRealReq(this.f26890g);
        tTBaseAd.setMediationRitReqType(this.f26895l);
        tTBaseAd.setMediationRitReqTypeSrc(this.f26896m);
        h hVar2 = this.f26885b;
        tTBaseAd.setOriginType(hVar2 != null ? hVar2.n() : -1);
        f fVar = this.f26897n;
        if (fVar != null) {
            tTBaseAd.putEventParam("win_call_back", fVar.e());
            tTBaseAd.putEventParam("fail_call_back", this.f26897n.b());
        }
        g gVar = this.mTTExtraModel;
        if (gVar != null) {
            tTBaseAd.putEventParam("if_test", Integer.valueOf(gVar.f532b));
            tTBaseAd.putEventParam("server_bidding_extra", this.mTTExtraModel.f531a);
        }
    }

    public abstract void destroy();

    public final int getAdLoadCount() {
        return this.f26898o;
    }

    public abstract String getAdNetWorkName();

    public AdSlot getAdSlot() {
        return this.mAdSlot;
    }

    public final String getAdSlotId() {
        return this.f26900q;
    }

    public String getAdapterRit() {
        return this.f26886c;
    }

    public final String getAdm() {
        f fVar;
        if (isServerBidding() && (fVar = this.f26897n) != null) {
            return fVar.a();
        }
        return null;
    }

    public String getClientReqId() {
        String str = !TextUtils.isEmpty(this.f26890g) ? this.f26890g : null;
        if (TextUtils.isEmpty(this.f26900q)) {
            return str;
        }
        return (str + "_") + this.f26900q;
    }

    public int getIfTest() {
        g gVar = this.mTTExtraModel;
        if (gVar != null) {
            return gVar.f532b;
        }
        return 0;
    }

    public abstract String getSdkVersion();

    public final boolean isBidding() {
        return isServerBidding() || isClientBidding();
    }

    public boolean isClientBidding() {
        return this.f26899p == 1;
    }

    public boolean isServerBidding() {
        return this.f26899p == 2;
    }

    public abstract void loadAd(Context context, Map<String, Object> map);

    public final void loadAdInter(@NonNull final Context context, @NonNull h hVar, @NonNull final Map<String, Object> map, @NonNull AdSlot adSlot, g gVar, int i4) {
        this.f26885b = hVar;
        this.f26886c = adSlot.getAdUnitId();
        this.f26898o = adSlot.getAdCount();
        this.f26890g = adSlot.getLinkedId();
        this.f26887d = hVar.l();
        this.f26888e = hVar.s();
        this.f26900q = hVar.c();
        this.f26897n = hVar.r();
        this.f26891h = hVar.h();
        this.mAdSlot = adSlot;
        this.mTTExtraModel = gVar;
        this.f26899p = hVar.e();
        this.mWaterfallAbTestParam = hVar.t();
        this.f26894k = i4;
        Object obj = map.get("key_mediation_rit_req_type");
        this.f26895l = obj != null ? ((Integer) obj).intValue() : 1;
        Object obj2 = map.get("key_mediation_rit_req_type_src");
        this.f26896m = obj2 != null ? ((Integer) obj2).intValue() : 1;
        if (!bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c.a().a(hVar.d(), hVar.c())) {
            AdBreakError adBreakError = new AdBreakError(AdError.ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL, AdError.getMessage(AdError.ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL));
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(hVar, adSlot, getSdkVersion(), i4, this.f26895l, this.f26896m, adBreakError);
            notifyAdFailed(adBreakError);
            return;
        }
        if (!hVar.u()) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(hVar, adSlot, getSdkVersion(), i4, this.f26895l, this.f26896m, (AdError) null);
        }
        if (!isBidding()) {
            this.f26889f = hVar.f();
        }
        this.f26892i = System.currentTimeMillis();
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(hVar.c(), getSdkVersion());
        if (!TextUtils.equals("mintegral", hVar.d()) && !TextUtils.equals("baidu", hVar.d()) && !TextUtils.equals("admob", hVar.d())) {
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
        this.f26893j = System.currentTimeMillis() - this.f26892i;
        l("failed", null, null, adError);
    }

    public final void notifyAdLoaded(TTBaseAd tTBaseAd) {
        this.f26893j = System.currentTimeMillis() - this.f26892i;
        l("adload_ad", tTBaseAd, null, null);
    }

    public final void notifyAdVideoCache(TTBaseAd tTBaseAd, AdError adError) {
        l("ad_video_cache", tTBaseAd, null, adError);
    }

    public void removeFromParent(View view) {
        z.a(view);
    }

    public final void setAdapterListener(AdapterLoaderListener adapterLoaderListener) {
        this.f26884a = adapterLoaderListener;
    }

    public void setTotalTimedOut(boolean z3) {
        this.f26901r = z3;
    }

    public final void notifyAdLoaded(List<TTBaseAd> list) {
        this.f26893j = System.currentTimeMillis() - this.f26892i;
        l("adload_ads", null, list, null);
    }
}
