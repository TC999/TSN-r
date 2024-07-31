package com.bytedance.msdk.core.corelogic;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.SdkSettingsHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.TTSdkSettings;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdCacheManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PreLoadManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PreLoadRequestCore;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_goto109.TTTestToolUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalFreqctlBean;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalPacingBean;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.TTExtraModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.InitHelper;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.ThirdSdkInit;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdErrorUtil;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.api.error.AdFreqError;
import com.bytedance.msdk.api.error.AdPacingError;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTAdHeaderBidingRequestCore extends TTADBidingRequestCore implements TTAbsAdLoaderAdapter.AdapterLoaderListener {

    /* renamed from: A */
    protected ITTAdatperCallback f21751A;

    /* renamed from: B */
    protected TTBaseAd f21752B;

    /* renamed from: G */
    protected TTNetworkRequestInfo f21757G;

    /* renamed from: K */
    private boolean f21761K;

    /* renamed from: v */
    private long f21765v;

    /* renamed from: w */
    private long f21766w;

    /* renamed from: x */
    private long f21767x;

    /* renamed from: y */
    private TTSdkSettings f21768y;

    /* renamed from: z */
    protected Context f21769z;

    /* renamed from: C */
    private final Map<String, TTAbsAdLoaderAdapter> f21753C = new HashMap();

    /* renamed from: D */
    private int f21754D = -1000;

    /* renamed from: E */
    private final AtomicBoolean f21755E = new AtomicBoolean(false);

    /* renamed from: F */
    protected AtomicBoolean f21756F = new AtomicBoolean(false);

    /* renamed from: H */
    private ConcurrentHashMap<String, AdLoadInfo> f21758H = new ConcurrentHashMap<>();

    /* renamed from: I */
    private long f21759I = 0;

    /* renamed from: J */
    private long f21760J = 0;

    /* renamed from: L */
    private final Map<Integer, List<WaterFallConfig>> f21762L = new HashMap();

    /* renamed from: M */
    private final Comparator<WaterFallConfig> f21763M = new C6033b(this);

    /* renamed from: N */
    private final Comparator<WaterFallConfig> f21764N = new C6034c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6032a implements Runnable {
        RunnableC6032a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.mo37375v();
        }
    }

    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6033b implements Comparator<WaterFallConfig> {
        C6033b(TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(WaterFallConfig waterFallConfig, WaterFallConfig waterFallConfig2) {
            int m59459l;
            int m59459l2;
            if (waterFallConfig.m59459l() == waterFallConfig2.m59459l()) {
                m59459l = waterFallConfig.m59452s();
                m59459l2 = waterFallConfig2.m59452s();
            } else {
                m59459l = waterFallConfig.m59459l();
                m59459l2 = waterFallConfig2.m59459l();
            }
            return m59459l - m59459l2;
        }
    }

    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6034c implements Comparator<WaterFallConfig> {
        C6034c(TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(WaterFallConfig waterFallConfig, WaterFallConfig waterFallConfig2) {
            return (waterFallConfig.m59471f() > waterFallConfig2.m59471f() ? 1 : (waterFallConfig.m59471f() == waterFallConfig2.m59471f() ? 0 : -1)) >= 0 ? -1 : 1;
        }
    }

    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC6035d extends Handler {
        HandlerC6035d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TTAdHeaderBidingRequestCore.this.mo37418a(message);
        }
    }

    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6036e implements Runnable {
        RunnableC6036e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Integer> list;
            Map<Integer, List<WaterFallConfig>> map;
            TTAdHeaderBidingRequestCore.this.f21759I = SystemClock.elapsedRealtime();
            if (!InitHelper.m59269g()) {
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "MSDK未进行初始化！！！");
                TTAdHeaderBidingRequestCore.this.m37388f(1);
                TTAdHeaderBidingRequestCore.this.mo37359a(new AdBreakError(1, AdError.getMessage(1)), (ExtraParam) null);
                return;
            }
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore = TTAdHeaderBidingRequestCore.this;
            if (tTAdHeaderBidingRequestCore.f21769z == null) {
                Logger.m37557e("TTMediationSDK", "Context为null！！！");
                TTAdHeaderBidingRequestCore.this.m37388f((int) AdError.ERROR_CODE_CONTEXT_ERROR);
                TTAdHeaderBidingRequestCore.this.mo37359a(new AdBreakError(AdError.ERROR_CODE_CONTEXT_ERROR, AdError.getMessage(AdError.ERROR_CODE_CONTEXT_ERROR)), (ExtraParam) null);
                return;
            }
            tTAdHeaderBidingRequestCore.m37420L();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore2 = TTAdHeaderBidingRequestCore.this;
            if (tTAdHeaderBidingRequestCore2.f21795h == null) {
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "AdSlot can't be null！！");
                TTAdHeaderBidingRequestCore.this.m37388f((int) AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR);
                TTAdHeaderBidingRequestCore.this.mo37359a(new AdBreakError(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR)), (ExtraParam) null);
                return;
            }
            if (tTAdHeaderBidingRequestCore2.f21791d == null && tTAdHeaderBidingRequestCore2.f21768y != null) {
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore3 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore3.f21791d = tTAdHeaderBidingRequestCore3.f21768y.m59754b(TTAdHeaderBidingRequestCore.this.f21793f);
                TTAdHeaderBidingRequestCore.this.m37372y();
            }
            if (CircuitBreakerController.m37366c().m37367b()) {
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "请求过于频繁，触发了熔断机制");
                TTAdHeaderBidingRequestCore.this.m37388f((int) AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER);
                TTAdHeaderBidingRequestCore.this.mo37359a(new AdBreakError(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER, AdError.getMessage(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER)), (ExtraParam) null);
                return;
            }
            String testSlotId = TTAdHeaderBidingRequestCore.this.f21795h.getTestSlotId();
            if (!TextUtils.isEmpty(testSlotId) && TTAdHeaderBidingRequestCore.this.m37363a() == 2) {
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore4 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore4.f21791d = TTTestToolUtil.m59651a(tTAdHeaderBidingRequestCore4.f21791d, testSlotId);
                AdsenseRitConfig adsenseRitConfig = TTAdHeaderBidingRequestCore.this.f21791d;
                int m59535p = adsenseRitConfig != null ? adsenseRitConfig.m59535p() : 0;
                TTAdHeaderBidingRequestCore.this.m37372y();
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "测试工具加载广告........totalWaterFallCount: " + m59535p + "  ,rit_id:" + TTAdHeaderBidingRequestCore.this.f21793f + " ,slot_id:" + testSlotId);
            }
            TTAdHeaderBidingRequestCore.this.m37371z();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore5 = TTAdHeaderBidingRequestCore.this;
            if (tTAdHeaderBidingRequestCore5.f21791d == null) {
                tTAdHeaderBidingRequestCore5.m37388f((int) AdError.ERROR_CODE_CONFIG_ERROR);
                if (TTAdHeaderBidingRequestCore.this.f21795h.getAdType() == 3 && !InternalContainer.m59943f().m59731p() && TTAdHeaderBidingRequestCore.this.f21757G != null) {
                    Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "settings config.......AdUnitId = " + TTAdHeaderBidingRequestCore.this.f21793f + "  开屏广告走了开发者自定义兜底方案   adnName:" + C6031a.m37434d(TTAdHeaderBidingRequestCore.this.f21757G.getAdNetworkFlatFromId()));
                    AdEventUtil.m59321a(TTAdHeaderBidingRequestCore.this.f21795h, -4);
                    TTAdHeaderBidingRequestCore.this.m37427E();
                    return;
                }
                if (TTAdHeaderBidingRequestCore.this.f21768y != null && TTAdHeaderBidingRequestCore.this.f21768y.m59748d() != null && TTAdHeaderBidingRequestCore.this.f21768y.m59748d().size() != 0) {
                    Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "settings config.......注意，AdUnitId = " + TTAdHeaderBidingRequestCore.this.f21795h.getAdUnitId() + " 的配置信息为 null ！！");
                    AdEventUtil.m59321a(TTAdHeaderBidingRequestCore.this.f21795h, 2);
                } else {
                    Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "settings config.......没有settings config配置信息,AdUnitId = " + TTAdHeaderBidingRequestCore.this.f21795h.getAdUnitId());
                    AdEventUtil.m59321a(TTAdHeaderBidingRequestCore.this.f21795h, 1);
                }
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore6 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore6.m37406a(tTAdHeaderBidingRequestCore6.f21793f, tTAdHeaderBidingRequestCore6.f21755E);
                return;
            }
            tTAdHeaderBidingRequestCore5.f21806s = tTAdHeaderBidingRequestCore5.f21795h.getAdCount();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore7 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore7.f21792e = tTAdHeaderBidingRequestCore7.f21791d.m59533r();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore8 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore8.f21800m = new ArrayList(tTAdHeaderBidingRequestCore8.f21791d.m59548f());
            if (InternalContainer.m59943f().m59744e(TTAdHeaderBidingRequestCore.this.f21793f) && (list = TTAdHeaderBidingRequestCore.this.f21800m) != null && list.size() != 0 && (map = TTAdHeaderBidingRequestCore.this.f21792e) != null && map.size() != 0) {
                IntervalShowControl m59587b = IntervalShowControl.m59587b();
                if (!m59587b.m59584b(TTAdHeaderBidingRequestCore.this.f21793f + "")) {
                    IntervalShowControl m59587b2 = IntervalShowControl.m59587b();
                    IntervalFreqctlBean m59577h = m59587b2.m59577h(TTAdHeaderBidingRequestCore.this.f21793f + "");
                    Pair<String, String> m59579f = IntervalShowControl.m59587b().m59579f(TTAdHeaderBidingRequestCore.this.f21793f);
                    if (m59577h == null || m59579f == null) {
                        return;
                    }
                    AdFreqError adFreqError = new AdFreqError(AdError.ERROR_CODE_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_EXCEED_FREQCTL), (String) m59579f.second, (String) m59579f.first);
                    TTAdHeaderBidingRequestCore.this.m37388f(adFreqError.code);
                    TTAdHeaderBidingRequestCore.this.mo37359a(adFreqError, (ExtraParam) null);
                    return;
                }
                IntervalShowControl m59587b3 = IntervalShowControl.m59587b();
                if (!m59587b3.m59582c(TTAdHeaderBidingRequestCore.this.f21793f + "") && !TTAdHeaderBidingRequestCore.this.mo37339i()) {
                    IntervalShowControl m59587b4 = IntervalShowControl.m59587b();
                    IntervalPacingBean m59576i = m59587b4.m59576i(TTAdHeaderBidingRequestCore.this.f21793f + "");
                    if (m59576i != null) {
                        String message = AdError.getMessage(AdError.ERROR_CODE_EXCEED_PACING);
                        AdPacingError adPacingError = new AdPacingError(AdError.ERROR_CODE_EXCEED_PACING, message, IntervalShowControl.m59587b().m59578g(TTAdHeaderBidingRequestCore.this.f21793f) + "", m59576i.m59597f());
                        TTAdHeaderBidingRequestCore.this.m37388f(adPacingError.code);
                        TTAdHeaderBidingRequestCore.this.mo37359a(adPacingError, (ExtraParam) null);
                        return;
                    }
                    return;
                }
                IntervalShowControl m59587b5 = IntervalShowControl.m59587b();
                if (!m59587b5.m59584b(TTAdHeaderBidingRequestCore.this.f21793f + "")) {
                    IntervalShowControl m59587b6 = IntervalShowControl.m59587b();
                    IntervalFreqctlBean m59577h2 = m59587b6.m59577h(TTAdHeaderBidingRequestCore.this.f21793f + "");
                    Pair<String, String> m59579f2 = IntervalShowControl.m59587b().m59579f(TTAdHeaderBidingRequestCore.this.f21793f);
                    if (m59577h2 == null || m59579f2 == null) {
                        return;
                    }
                    TTAdHeaderBidingRequestCore.this.mo37359a(new AdFreqError(AdError.ERROR_CODE_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_EXCEED_FREQCTL), (String) m59579f2.second, (String) m59579f2.first), (ExtraParam) null);
                    return;
                }
                SortAlgorithm.m37364a(TTAdHeaderBidingRequestCore.this.f21800m);
                PreLoadManager m59686a = PreLoadManager.m59686a();
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore9 = TTAdHeaderBidingRequestCore.this;
                if (m59686a.m59672c(tTAdHeaderBidingRequestCore9.f21793f, tTAdHeaderBidingRequestCore9.m37363a()) != 0) {
                    boolean z = PreLoadManager.m59686a().m59664g(TTAdHeaderBidingRequestCore.this.f21793f) == null;
                    if (!TTAdHeaderBidingRequestCore.this.mo37339i() && !z && TTAdHeaderBidingRequestCore.this.m37428D()) {
                        TTAdHeaderBidingRequestCore.this.m37430B();
                        return;
                    }
                    if (!TTAdHeaderBidingRequestCore.this.mo37339i() && !z) {
                        TTAdHeaderBidingRequestCore.this.f21795h.setPrimeRitReqType(3);
                    }
                    PreLoadManager m59686a2 = PreLoadManager.m59686a();
                    TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore10 = TTAdHeaderBidingRequestCore.this;
                    m59686a2.m59674b(tTAdHeaderBidingRequestCore10.f21793f, tTAdHeaderBidingRequestCore10.f21795h);
                }
                TTAdHeaderBidingRequestCore.this.m37425G();
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore11 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore11.f21805r.m37299f(tTAdHeaderBidingRequestCore11.f21800m);
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore12 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore12.f21805r.m37287r(tTAdHeaderBidingRequestCore12.f21791d.m59535p());
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore13 = TTAdHeaderBidingRequestCore.this;
                Handler handler = tTAdHeaderBidingRequestCore13.f21794g;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(2, tTAdHeaderBidingRequestCore13.f21767x);
                }
                TTAdHeaderBidingRequestCore.this.mo37419a(0, false);
                SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59779d().m59781c();
                return;
            }
            Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "settings config.......注意，AdUnitId = " + TTAdHeaderBidingRequestCore.this.f21795h.getAdUnitId() + "  没有对应的waterfall配置信息");
            AdEventUtil.m59321a(TTAdHeaderBidingRequestCore.this.f21795h, 3);
            TTAdHeaderBidingRequestCore.this.m37388f((int) AdError.ERROR_CODE_LOAD_PANGOLIN);
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore14 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore14.m37406a(tTAdHeaderBidingRequestCore14.f21793f, tTAdHeaderBidingRequestCore14.f21755E);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6037f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21773a;

        RunnableC6037f(String str) {
            this.f21773a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.m37396c(this.f21773a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6038g implements ThirdSdkInit.InitCallback {

        /* renamed from: a */
        final /* synthetic */ String f21775a;

        C6038g(String str) {
            this.f21775a = str;
        }

        @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
        public void fail(int i, String str) {
            TTAdHeaderBidingRequestCore.this.mo37359a(PangleAdapterUtils.buildAdError(AdError.ERROR_CODE_THIRD_SDK_NOT_INIT, AdError.messageFormat(AdError.AD_THIRD_SDK_INIT_FAIL_MSG, "pangle", new String[0])), (ExtraParam) null);
            Logger.m37557e("TTMediationSDK", "兜底策略；；；；；；pangle init fail ，code=" + i + "，msg = " + str);
        }

        @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
        public void success() {
            TTAdHeaderBidingRequestCore.this.m37396c(this.f21775a);
        }
    }

    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6039h implements Runnable {
        RunnableC6039h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Handler handler = TTAdHeaderBidingRequestCore.this.f21794g;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                List<TTBaseAd> list = TTAdHeaderBidingRequestCore.this.f21803p;
                if (list != null) {
                    list.clear();
                }
                List<TTBaseAd> list2 = TTAdHeaderBidingRequestCore.this.f21801n;
                if (list2 != null) {
                    list2.clear();
                }
                List<TTBaseAd> list3 = TTAdHeaderBidingRequestCore.this.f21802o;
                if (list3 != null) {
                    list3.clear();
                }
                TTBaseAd tTBaseAd = TTAdHeaderBidingRequestCore.this.f21752B;
                if (tTBaseAd != null) {
                    tTBaseAd.onDestroy();
                }
                if (TTAdHeaderBidingRequestCore.this.f21753C != null) {
                    for (Map.Entry entry : TTAdHeaderBidingRequestCore.this.f21753C.entrySet()) {
                        if (entry != null) {
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = (TTAbsAdLoaderAdapter) entry.getValue();
                            tTAbsAdLoaderAdapter.setAdapterListener(null);
                            tTAbsAdLoaderAdapter.destroy();
                        }
                    }
                    TTAdHeaderBidingRequestCore.this.f21753C.clear();
                }
                TTAdHeaderBidingRequestCore.this.f21804q.clear();
                TTAdHeaderBidingRequestCore.this.f21805r.m37280y();
            } catch (Throwable unused) {
            }
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore.f21751A = null;
            tTAdHeaderBidingRequestCore.f21768y = null;
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore2 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore2.f21792e = null;
            tTAdHeaderBidingRequestCore2.f21769z = null;
            tTAdHeaderBidingRequestCore2.f21757G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6040i implements Runnable {
        RunnableC6040i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.mo37376u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6041j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdError f21779a;

        RunnableC6041j(AdError adError) {
            this.f21779a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.mo37415a(this.f21779a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6042k implements Runnable {
        RunnableC6042k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.mo37375v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6043l implements Runnable {

        /* renamed from: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore$l$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class RunnableC6044a implements Runnable {
            RunnableC6044a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdHeaderBidingRequestCore.this.mo37375v();
            }
        }

        RunnableC6043l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TTAdHeaderBidingRequestCore.this.f21788a.get() || TTAdHeaderBidingRequestCore.this.f21790c.get()) {
                return;
            }
            TTAdHeaderBidingRequestCore.this.f21790c.set(true);
            AdSlot adSlot = TTAdHeaderBidingRequestCore.this.f21795h;
            if ((adSlot != null && adSlot.getAdType() == 7) || TTAdHeaderBidingRequestCore.this.f21795h.getAdType() == 8) {
                Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f21793f) + "m-sdk----设置 cacheTimeout 已到时间【" + InternalContainer.m59943f().m59750c(TTAdHeaderBidingRequestCore.this.f21795h.getAdUnitId()) + "】，给外部invokeAdVideoCache ...");
            }
            if (TTAdHeaderBidingRequestCore.this.mo37339i()) {
                return;
            }
            TTAdHeaderBidingRequestCore.this.m37423I();
            ThreadHelper.runOnUiThread(new RunnableC6044a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TTAdHeaderBidingRequestCore(Context context, String str) {
        Map<Integer, List<WaterFallConfig>> m59533r;
        this.f21769z = context;
        this.f21793f = str;
        TTSdkSettings m59943f = InternalContainer.m59943f();
        this.f21768y = m59943f;
        if (m59943f != null) {
            m37348b(m59943f.m59736k());
            m37347b(this.f21768y.m59735l());
            this.f21791d = this.f21768y.m59754b(this.f21793f);
            m37372y();
        }
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        if (adsenseRitConfig != null && (m59533r = adsenseRitConfig.m59533r()) != null) {
            for (Map.Entry<Integer, List<WaterFallConfig>> entry : m59533r.entrySet()) {
                List<WaterFallConfig> value = entry.getValue();
                if (value != null && value.size() > 0 && value.get(0).m59474e() == 100) {
                    this.f21762L.put(entry.getKey(), entry.getValue());
                }
            }
        }
        this.f21794g = new HandlerC6035d(ThreadHelper.getMSDKThreadLooper());
    }

    /* renamed from: A */
    private int m37431A() {
        List<WaterFallConfig> list;
        Map<Integer, List<WaterFallConfig>> map = this.f21792e;
        if (map == null || map.isEmpty() || this.f21800m == null) {
            return -1;
        }
        int m37398c = m37398c(this.f21754D);
        int i = 0;
        for (int i2 = 0; i2 < m37398c && i2 < this.f21800m.size(); i2++) {
            Integer num = this.f21800m.get(i2);
            if (this.f21792e.containsKey(num) && (list = this.f21792e.get(num)) != null) {
                i += list.size();
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m37430B() {
        AdSlot m59673c = PreLoadManager.m59686a().m59673c(this.f21793f);
        if (m59673c != null) {
            this.f21795h.setLinkedId(m59673c.getLinkedId());
            this.f21795h.setPrimeRitReqType(m59673c.getPrimeRitReqType());
        }
        PreLoadManager.m59686a().m59674b(this.f21793f, this.f21795h);
        m37425G();
        m37426F();
        PreLoadRequestCore m59670d = PreLoadManager.m59686a().m59670d(this.f21793f);
        if (m59670d != null) {
            this.f21808u = m59670d.f21808u;
            this.f21758H = m59670d.m37381p();
        }
        mo37342f();
    }

    /* renamed from: C */
    private boolean m37429C() {
        List<TTBaseAd> list = this.f21803p;
        if (list != null) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list2 = this.f21802o;
        if (list2 != null) {
            for (TTBaseAd tTBaseAd2 : list2) {
                if (tTBaseAd2.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list3 = this.f21801n;
        if (list3 != null) {
            for (TTBaseAd tTBaseAd3 : list3) {
                if (tTBaseAd3.isCacheSuccess()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public boolean m37428D() {
        List<TTBaseAdCache> m59663h;
        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "mLoadSortList: " + this.f21800m);
        if (PreLoadManager.m59686a().m59680a(this.f21793f, this.f21795h) && (m59663h = PreLoadManager.m59686a().m59663h(this.f21793f)) != null && m59663h.size() > 0) {
            for (TTBaseAdCache tTBaseAdCache : m59663h) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(tTBaseAdCache.f425a);
                m37405a(arrayList);
            }
            if (this.f21803p.size() > 0 || this.f21802o.size() > 0 || this.f21801n.size() > 0) {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "--==-- not hit cache!!! -----");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f9, code lost:
        switch(r2) {
            case 31: goto L16;
            case 32: goto L41;
            case 33: goto L15;
            default: goto L15;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00fe -> B:46:0x00fc). Please submit an issue!!! */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m37427E() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.m37427E():void");
    }

    /* renamed from: F */
    private void m37426F() {
        if (this.f21807t.get() || this.f21761K) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f21760J = elapsedRealtime;
        AdEventUtil.m59319a(this.f21795h, this.f21791d, elapsedRealtime - this.f21759I, m37345c());
        this.f21807t.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m37425G() {
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        AdEventUtil.m59312a(this.f21795h, adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null, m37345c(), 0);
    }

    /* renamed from: H */
    private void m37424H() {
        TTAbsAdLoaderAdapter value;
        for (Map.Entry<String, TTAbsAdLoaderAdapter> entry : this.f21753C.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.setTotalTimedOut(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m37423I() {
        AdSlot adSlot = this.f21795h;
        if ((adSlot == null || adSlot.getAdType() != 7) && this.f21795h.getAdType() != 8) {
            return;
        }
        AdSlot adSlot2 = this.f21795h;
        TTBaseAd tTBaseAd = this.f21752B;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f21760J;
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        AdEventUtil.m59315a(adSlot2, tTBaseAd, elapsedRealtime, adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null);
    }

    /* renamed from: J */
    private void m37422J() {
        if (this.f21794g != null) {
            if (!m37429C()) {
                this.f21794g.postDelayed(new RunnableC6043l(), InternalContainer.m59943f().m59750c(this.f21795h.getAdUnitId()));
            } else if (!this.f21788a.get() || this.f21790c.get()) {
            } else {
                this.f21790c.set(true);
                AdSlot adSlot = this.f21795h;
                if ((adSlot != null && adSlot.getAdType() == 7) || this.f21795h.getAdType() == 8) {
                    Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "从onAdLoaded给外部invokeAdVideoCache ...");
                }
                if (mo37339i()) {
                    return;
                }
                m37423I();
                ThreadHelper.runOnUiThread(new RunnableC6042k());
            }
        }
    }

    /* renamed from: K */
    private void m37421K() {
        Handler handler = this.f21794g;
        if (handler != null) {
            handler.removeMessages(1);
            this.f21794g.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m37420L() {
        this.f21752B = null;
        this.f21755E.set(false);
        this.f21756F.set(false);
        this.f21807t.set(false);
        this.f21802o.clear();
        this.f21801n.clear();
        this.f21803p.clear();
        this.f21788a.set(false);
        this.f21789b.set(false);
        this.f21790c.set(false);
        Handler handler = this.f21794g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        TTRequestLoadingStatus tTRequestLoadingStatus = this.f21805r;
        if (tTRequestLoadingStatus != null) {
            tTRequestLoadingStatus.m37280y();
        }
        TTExtraModel tTExtraModel = this.f21808u;
        if (tTExtraModel != null) {
            tTExtraModel.f538a = null;
        }
    }

    /* renamed from: a */
    private void m37407a(String str, String str2, String str3, int i, String str4) {
        AdLoadInfo adLoadInfo = this.f21758H.get(str);
        if (adLoadInfo == null) {
            adLoadInfo = new AdLoadInfo();
        }
        adLoadInfo.setMediationRit(str).setAdnName(str2).setErrCode(i).setErrMsg(str4).setAdType(str3);
        this.f21758H.put(str, adLoadInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37406a(String str, AtomicBoolean atomicBoolean) {
        if (mo37339i()) {
            return;
        }
        ExtraParam extraParam = new ExtraParam();
        extraParam.m59521c(-1);
        extraParam.m59519d(-1);
        if (InternalContainer.m59943f().m59747d(str)) {
            Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "settings config.......AdUnitId = " + str + "  暂无config配置信息");
            mo37359a(new AdError(AdError.ERROR_CODE_NO_CONFIG, AdError.getMessage(AdError.ERROR_CODE_NO_CONFIG)), extraParam);
            SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59779d().m59781c();
            return;
        }
        mo37359a(new AdError(AdError.ERROR_CODE_ADSLOT_ID_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ID_ERROR)), extraParam);
        while (true) {
            for (char c = 14; c != '\f'; c = StringUtil.CARRIAGE_RETURN) {
                if (c == '\r') {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m37408a(String str, WaterFallConfig waterFallConfig, int i) {
        List<TTBaseAdCache> m59708a = AdCacheManager.m59712a().m59708a(str, this.f21795h);
        if (m59708a == null || m59708a.size() <= 0) {
            return false;
        }
        TTBaseAd tTBaseAd = m59708a.get(0).f425a;
        AdSlot adSlot = this.f21795h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        AdEventUtil.m59305b(waterFallConfig, this.f21795h, 3, mediationRitReqType);
        AdEventUtil.m59326a(waterFallConfig, this.f21795h, AdCacheManager.m59712a().m59700c(str), i, 3, mediationRitReqType, (AdError) null);
        ArrayList arrayList = new ArrayList();
        for (TTBaseAdCache tTBaseAdCache : m59708a) {
            tTBaseAdCache.f425a.setMediationRitReqType(3);
            tTBaseAdCache.f425a.setMediationRitReqTypeSrc(mediationRitReqType);
            arrayList.add(tTBaseAdCache.f425a);
        }
        AdEventUtil.m59311a(m59708a.get(0).f425a, 0, "adn cache命中", 0L, this.f21795h, i, arrayList.size(), false);
        onAdLoaded(arrayList, m59708a.get(0).f426b);
        return true;
    }

    /* renamed from: b */
    private void m37403b(AdError adError) {
        this.f21761K = true;
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        AdEventUtil.m59318a(this.f21795h, adError, adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null, m37345c());
    }

    /* renamed from: b */
    private void m37399b(List<TTBaseAd> list, ExtraParam extraParam) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
        if (list.get(0).isServerBiddingAd() || !AdCacheManager.m59712a().m59699c(adNetworkSlotId, m37363a())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TTBaseAd tTBaseAd : list) {
            if (tTBaseAd != null) {
                arrayList.add(new TTBaseAdCache(tTBaseAd, extraParam, 0L, SystemClock.elapsedRealtime(), this.f21795h));
            }
        }
        if (arrayList.size() > 0) {
            TTBaseAd tTBaseAd2 = ((TTBaseAdCache) arrayList.get(0)).f425a;
            Logger.m37562d("TTMediationSDK", "--==-- 广告复用:广告缓存成功 -------" + tTBaseAd2.getAdNetWorkName() + ", adType: " + C6031a.m37436b(tTBaseAd2.getAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
            AdCacheManager.m59712a().m59704a(adNetworkSlotId, arrayList);
        }
    }

    /* renamed from: c */
    private int m37398c(int i) {
        List<Integer> list = this.f21800m;
        if (list == null) {
            return -1;
        }
        return list.indexOf(Integer.valueOf(i)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m37396c(String str) {
        Handler handler;
        WaterFallConfig m37320c = TTLoaderUtil.m37320c(this.f21757G.getAdNetworkSlotId(), str, -4, -4);
        if (m37320c != null) {
            if (this.f21765v != 0 && (handler = this.f21794g) != null) {
                handler.removeMessages(3);
                this.f21794g.sendEmptyMessageDelayed(3, this.f21765v);
            }
            m37417a(m37320c, -1);
        }
        SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59779d().m59781c();
    }

    /* renamed from: c */
    private void m37395c(List<WaterFallConfig> list) {
        for (int i = 0; i < list.size(); i++) {
            WaterFallConfig waterFallConfig = list.get(i);
            if (waterFallConfig.m59474e() == 1) {
                WaterFallConfig waterFallConfig2 = new WaterFallConfig();
                waterFallConfig2.m59484a(waterFallConfig.m59480c());
                waterFallConfig2.m59482b(waterFallConfig.m59474e());
                waterFallConfig2.m59481b(waterFallConfig.m59477d());
                waterFallConfig2.m59487a(waterFallConfig.m59483b());
                waterFallConfig2.m59472e(waterFallConfig.m59458m());
                waterFallConfig2.m59470f(waterFallConfig.m59459l());
                waterFallConfig2.m59462i(waterFallConfig.m59452s());
                waterFallConfig2.m59464h(waterFallConfig.m59456o());
                waterFallConfig2.m59478c("" + waterFallConfig.m59471f());
                waterFallConfig2.m59475d(waterFallConfig.m59465h());
                waterFallConfig2.m59466g(waterFallConfig.m59451t());
                waterFallConfig2.m59469f(waterFallConfig.m59454q());
                waterFallConfig2.m59486a(waterFallConfig.m59453r());
                list.set(i, waterFallConfig2);
            }
        }
    }

    /* renamed from: d */
    private List<WaterFallConfig> m37392d(List<WaterFallConfig> list) {
        TTBaseAdCache m59679a;
        ArrayList arrayList = new ArrayList();
        Iterator<WaterFallConfig> it = list.iterator();
        while (it.hasNext()) {
            WaterFallConfig next = it.next();
            if (next.m59474e() == 100) {
                arrayList.add(next);
                it.remove();
            }
            if (next.m59474e() == 1 && (m59679a = PreLoadManager.m59686a().m59679a(this.f21793f, next.m59480c())) != null) {
                next.m59478c("" + m59679a.f425a.getCpm());
            }
        }
        Collections.sort(arrayList, this.f21763M);
        Collections.sort(list, this.f21764N);
        arrayList.addAll(list);
        return arrayList;
    }

    /* renamed from: d */
    private boolean m37394d(int i) {
        WaterFallConfig waterFallConfig;
        List<WaterFallConfig> list = this.f21792e.get(Integer.valueOf(i));
        if (list != null) {
            Iterator<WaterFallConfig> it = list.iterator();
            while (it.hasNext()) {
                waterFallConfig = it.next();
                if (waterFallConfig != null && waterFallConfig.m59450u() && TextUtils.equals(waterFallConfig.m59477d(), "pangle")) {
                    break;
                }
            }
        }
        waterFallConfig = null;
        return waterFallConfig != null && waterFallConfig.m59457n() == 3;
    }

    /* renamed from: e */
    private List<WaterFallConfig> m37389e(List<WaterFallConfig> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<WaterFallConfig> it = list.iterator();
        while (it.hasNext()) {
            WaterFallConfig next = it.next();
            if (next.m59450u()) {
                it.remove();
                arrayList.add(next);
            }
        }
        Collections.sort(list, this.f21763M);
        list.addAll(arrayList);
        if ((list.size() <= 0 || list.get(0).m59474e() != 100) && this.f21762L.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<Integer, List<WaterFallConfig>> entry : this.f21762L.entrySet()) {
                arrayList2.addAll(entry.getValue());
            }
            Collections.sort(arrayList2, this.f21763M);
            arrayList2.addAll(list);
            return arrayList2;
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f0 A[PHI: r1 r9 
      PHI: (r1v19 char) = (r1v18 char), (r1v22 char) binds: [B:9:0x001d, B:46:0x00eb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v18 char) = (r9v17 char), (r9v24 char) binds: [B:9:0x001d, B:46:0x00eb] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e6 -> B:46:0x00eb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00f0 -> B:46:0x00eb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00f4 -> B:46:0x00eb). Please submit an issue!!! */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m37391e(int r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.m37391e(int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m37388f(int i) {
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        AdEventUtil.m59312a(this.f21795h, adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null, m37345c(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37419a(int i, boolean z) {
        if (this.f21788a.get() || this.f21789b.get()) {
            return;
        }
        if (i >= this.f21800m.size() || this.f21805r.m37290o(this.f21800m.get(i).intValue())) {
            if (this.f21805r.m37284u()) {
                if (this.f21803p.size() > 0 || this.f21801n.size() > 0 || this.f21802o.size() > 0) {
                    mo37342f();
                } else {
                    mo37359a(new AdError(20005, AdError.getMessage(20005)), (ExtraParam) null);
                }
            }
            if (z || i >= this.f21800m.size()) {
                return;
            }
        }
        int intValue = this.f21800m.get(i).intValue();
        if (!this.f21805r.m37290o(intValue)) {
            if (intValue == 0 && m37338j() && !this.f21805r.m37286s()) {
                this.f21805r.m37291n(true);
                if (m37394d(intValue)) {
                    mo37359a(AdErrorUtil.obtainAdError(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH, AdError.getMessage(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH)), (ExtraParam) null);
                    return;
                }
                m37358a(this.f21795h, this.f21792e.get(Integer.valueOf(intValue)));
                mo37419a(i + 1, false);
                return;
            }
            this.f21754D = intValue;
            this.f21805r.m37288q(intValue);
            this.f21805r.m37301d(intValue, true);
            if (m37391e(intValue)) {
                return;
            }
        }
        mo37419a(i + 1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37418a(Message message) {
        StringBuilder sb;
        String str;
        char c;
        char c2;
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        StringBuilder sb2;
        String str2;
        List<TTBaseAd> list3;
        List<TTBaseAd> list4;
        int i = message.what;
        if (i == 1) {
            int i2 = message.arg1;
            if (i2 == 10003) {
                if (this.f21803p.size() != 0) {
                    Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "当前层超时....广告池已有P层类型广告不执行下层....mTTPAdPoolList.size()=" + this.f21803p.size());
                    mo37342f();
                    return;
                }
                Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "当前层超时....P层广告池没广告尝试执行下层(不一定执行)....mTTPAdPoolList.size()=" + this.f21803p.size());
                mo37419a(m37398c(this.f21754D), false);
                c = 'W';
                c2 = HttpConstants.SP_CHAR;
                if (c2 != 31) {
                }
                do {
                } while (c == '\r');
                return;
            } else if (m37362a(i2)) {
                if (m37338j() && !m37335m()) {
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f21793f));
                    str = "当前层超时....server Bidding 还没有接口返回，尝试执行下层(不一定执行)....mTTCommonAdPoolList.size()=";
                } else if (this.f21801n.size() != 0) {
                    Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "当前层超时....广告池已有广告不执行下层....mTTCommonAdPoolList.size()=" + this.f21801n.size());
                    mo37342f();
                } else {
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f21793f));
                    str = "当前层超时....普通广告池没广告尝试执行下层(不一定执行)....mTTCommonAdPoolList.size()=";
                }
                sb.append(str);
                sb.append(this.f21801n.size());
                Logger.m37547w("TTMediationSDK", sb.toString());
                mo37419a(m37398c(this.f21754D), false);
                return;
            } else {
                return;
            }
        }
        if (i == 2) {
            this.f21805r.m37294k(true);
            m37424H();
            if (this.f21788a.get() || this.f21789b.get()) {
                return;
            }
            List<TTBaseAd> list5 = this.f21803p;
            if ((list5 == null || list5.size() <= 0) && (((list = this.f21801n) == null || list.size() <= 0) && ((list2 = this.f21802o) == null || list2.size() <= 0))) {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "总加载时间超时.......没有广告回调失败");
                mo37359a(new AdError(10003, AdError.getMessage(10003)), (ExtraParam) null);
                c = 15;
                c2 = '!';
                if (c2 != 31 || c2 == '!') {
                    do {
                    } while (c == '\r');
                    return;
                }
                return;
            }
            sb2 = new StringBuilder();
            sb2.append(TTLogUtil.getTagSecondLevel(this.f21793f));
            str2 = "总加载时间超时.......有广告回调成功";
        } else if (i != 3) {
            return;
        } else {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "超过当前层最短加载时间.....");
            if (this.f21788a.get() || this.f21789b.get()) {
                return;
            }
            if (this.f21805r.m37286s() && m37338j() && !m37335m()) {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "超过当前层最短加载时间.....  当前正处于server Bidding 的网络请求中.......");
                return;
            }
            List<TTBaseAd> list6 = this.f21803p;
            if ((list6 == null || list6.size() <= 0) && (((list3 = this.f21801n) == null || list3.size() <= 0) && ((list4 = this.f21802o) == null || list4.size() <= 0))) {
                return;
            }
            sb2 = new StringBuilder();
            sb2.append(TTLogUtil.getTagSecondLevel(this.f21793f));
            str2 = "超过当前层最短加载时间....有广告回调成功出去....";
        }
        sb2.append(str2);
        Logger.m37562d("TTMediationSDK", sb2.toString());
        mo37342f();
    }

    /* renamed from: a */
    protected void m37416a(WaterFallConfig waterFallConfig, int i, int i2) {
        if (waterFallConfig != null) {
            this.f21805r.m37300e(waterFallConfig.m59480c());
            waterFallConfig.m59469f(m37345c());
            AdEventUtil.m59328a(waterFallConfig, this.f21795h, i, i2);
        }
    }

    /* renamed from: a */
    protected abstract void mo37415a(AdError adError);

    @Override // com.bytedance.msdk.core.corelogic.TTADBidingRequestCore
    /* renamed from: a */
    protected void mo37359a(AdError adError, ExtraParam extraParam) {
        m37421K();
        if (this.f21789b.get() || this.f21788a.get()) {
            return;
        }
        this.f21789b.set(true);
        if (mo37349b() != 1 || (adError instanceof AdFreqError) || (adError instanceof AdPacingError) || (adError instanceof AdBreakError)) {
            m37403b(adError);
        }
        if (mo37339i()) {
            if ((adError instanceof AdFreqError) || (adError instanceof AdPacingError) || (adError instanceof AdBreakError)) {
                AdSlot adSlot = this.f21795h;
                TTBaseAd tTBaseAd = this.f21752B;
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f21759I;
                int m37431A = m37431A();
                int m37398c = m37398c(this.f21754D);
                int i = adError.code;
                AdsenseRitConfig adsenseRitConfig = this.f21791d;
                AdEventUtil.m59316a(adSlot, tTBaseAd, elapsedRealtime, m37431A, m37398c, i, adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null);
                return;
            }
            return;
        }
        AdSlot adSlot2 = this.f21795h;
        TTBaseAd tTBaseAd2 = this.f21752B;
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.f21759I;
        int m37431A2 = m37431A();
        int m37398c2 = m37398c(this.f21754D);
        int i2 = adError.code;
        AdsenseRitConfig adsenseRitConfig2 = this.f21791d;
        AdEventUtil.m59316a(adSlot2, tTBaseAd2, elapsedRealtime2, m37431A2, m37398c2, i2, adsenseRitConfig2 != null ? adsenseRitConfig2.m59531t() : null);
        Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + adError.code + " error Message = " + adError.message);
        ThreadHelper.runOnUiThread(new RunnableC6041j(adError));
    }

    /* renamed from: a */
    protected void m37405a(List<TTBaseAd> list) {
        TTBaseAd tTBaseAd;
        if (list == null || list.size() <= 0 || (tTBaseAd = list.get(0)) == null) {
            return;
        }
        if (tTBaseAd.isPAd()) {
            this.f21803p.addAll(list);
            TTLoaderUtil.m37314i(this.f21803p, null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd2 : list) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告加载成功...........返回了P层广告_当前P层广告缓存池数量：" + this.f21803p.size() + ",slotId：" + tTBaseAd2.getAdNetworkSlotId() + ",广告类型：" + C6031a.m37434d(tTBaseAd2.getAdNetworkPlatformId()) + ",loadSort=" + tTBaseAd2.getLoadSort() + ",showSort=" + tTBaseAd2.getShowSort() + ",CPM=" + tTBaseAd2.getCpm());
                }
            }
        } else if (tTBaseAd.isBidingAd()) {
            m37351a(list, tTBaseAd);
        } else {
            this.f21801n.addAll(list);
            TTLoaderUtil.m37314i(this.f21801n, null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd3 : this.f21801n) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告加载成功...........返回了普通层广告_当前普通广告缓存池数量：" + this.f21801n.size() + ",slotId：" + tTBaseAd3.getAdNetworkSlotId() + ",广告类型：" + C6031a.m37434d(tTBaseAd3.getAdNetworkPlatformId()) + ",loadSort=" + tTBaseAd3.getLoadSort() + ",showSort=" + tTBaseAd3.getShowSort() + ",CPM=" + tTBaseAd3.getCpm());
                }
            }
        }
    }

    /* renamed from: a */
    protected void mo37404a(List<TTBaseAd> list, ExtraParam extraParam) {
    }

    @Override // com.bytedance.msdk.core.corelogic.TTADBidingRequestCore
    /* renamed from: a */
    protected void mo37350a(boolean z) {
        WaterFallConfig waterFallConfig;
        Handler handler;
        AdsenseRitConfig adsenseRitConfig;
        List<WaterFallConfig> m59532s;
        ThirdSdkInit.initTTPangleSDK(this.f21769z);
        if (z && (adsenseRitConfig = this.f21791d) != null && (m59532s = adsenseRitConfig.m59532s()) != null) {
            Iterator<WaterFallConfig> it = m59532s.iterator();
            while (it.hasNext()) {
                waterFallConfig = it.next();
                if ("pangle".equals(waterFallConfig.m59477d())) {
                    break;
                }
            }
        }
        waterFallConfig = null;
        if (waterFallConfig == null) {
            waterFallConfig = TTLoaderUtil.m37321b(this.f21795h, -1, -1);
        }
        if (waterFallConfig != null) {
            if (this.f21765v != 0 && (handler = this.f21794g) != null) {
                handler.removeMessages(3);
                this.f21794g.sendEmptyMessageDelayed(3, this.f21765v);
            }
            m37417a(waterFallConfig, -1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0189, code lost:
        if (r0 != 'b') goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0191  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0189 -> B:59:0x018e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x018c -> B:58:0x018d). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean m37417a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig r17, int r18) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.m37417a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h, int):boolean");
    }

    /* renamed from: b */
    public HashMap<String, TTBaseAd> m37400b(List<TTBaseAd> list) {
        HashMap<String, TTBaseAd> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    hashMap.put(tTBaseAd.getAdNetworkSlotId(), tTBaseAd);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m37402b(TTBaseAd tTBaseAd) {
        AdSlot adSlot = this.f21795h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        tTBaseAd.setMediationRitReqType(3);
        tTBaseAd.setMediationRitReqTypeSrc(mediationRitReqType);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTADBidingRequestCore
    /* renamed from: f */
    protected void mo37342f() {
        m37421K();
        if (this.f21788a.get() || this.f21789b.get()) {
            return;
        }
        Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告加载成功！给外部回调：invokeAdLoadCallbackOnMainUI........P.size:" + this.f21803p.size() + "   bidding.size:" + this.f21802o.size() + "   normal.size:" + this.f21801n.size());
        this.f21788a.set(true);
        m37334n();
        if (mo37339i()) {
            return;
        }
        AdSlot adSlot = this.f21795h;
        TTBaseAd tTBaseAd = this.f21752B;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f21759I;
        int m37431A = m37431A();
        int m37398c = m37398c(this.f21754D);
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        AdEventUtil.m59316a(adSlot, tTBaseAd, elapsedRealtime, m37431A, m37398c, 0, adsenseRitConfig != null ? adsenseRitConfig.m59531t() : null);
        ThreadHelper.runOnUiThread(new RunnableC6040i());
        m37422J();
    }

    @Keep
    public List<AdLoadInfo> getAdLoadInfoList() {
        AdLoadInfo value;
        ArrayList arrayList = new ArrayList(this.f21758H.size());
        for (Map.Entry<String, AdLoadInfo> entry : this.f21758H.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals(AdLoadInfo.AD_LOADED, value.getErrMsg()) && !TextUtils.equals(AdLoadInfo.AD_LOADING, value.getErrMsg())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    public void mo37382o() {
        ThreadHelper.runOnMSDKThread(new RunnableC6039h());
    }

    public void onAdFailed(AdError adError, ExtraParam extraParam) {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        AdSlot adSlot;
        if (this.f21794g == null || extraParam == null) {
            return;
        }
        if (adError != null) {
            m37407a(extraParam.m59520d(), extraParam.m59522c(), C6031a.m37436b(extraParam.m59525b()), adError.thirdSdkErrorCode, adError.thirdSdkErrorMessage);
            Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告加载失败...........adnName:" + extraParam.m59522c() + " ,slotId:" + extraParam.m59520d() + ",slotType:" + extraParam.m59528a() + ",loadSort:" + extraParam.m59518e() + ",showSort:" + extraParam.m59517f() + " ，adError:" + adError.toString());
        }
        TTLoaderUtil.m37315h(adError, extraParam);
        if (extraParam.m59528a() == 0 && m37353a(extraParam.m59520d())) {
            return;
        }
        if (extraParam.m59516g()) {
            this.f21805r.m37304a();
        }
        this.f21805r.m37300e(extraParam.m59520d());
        this.f21805r.m37303b(extraParam.m59518e());
        if (this.f21788a.get() || this.f21789b.get()) {
            return;
        }
        List<TTBaseAd> list3 = this.f21803p;
        if ((list3 == null || list3.size() <= 0) && (((list = this.f21801n) == null || list.size() <= 0) && ((list2 = this.f21802o) == null || list2.size() <= 0))) {
            if (!this.f21805r.m37282w() && this.f21805r.m37284u() && (adSlot = this.f21795h) != null && !TextUtils.isEmpty(adSlot.getTestSlotId()) && m37363a() == 2) {
                mo37359a(adError, extraParam);
                return;
            }
        } else if (!this.f21805r.m37282w() && this.f21805r.m37284u()) {
            mo37342f();
            return;
        }
        if (this.f21805r.m37296i(extraParam.m59518e()) == 0) {
            int m37398c = m37398c(extraParam.m59518e());
            Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "onAdFailed--》 加载下一层-nextIdx=" + m37398c);
            mo37419a(m37398c, true);
        }
        if (this.f21805r.m37282w() || this.f21805r.m37284u()) {
            Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "所有广告都加载失败....");
            mo37359a(new AdError(20005, AdError.getMessage(20005)), extraParam);
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(TTBaseAd tTBaseAd, ExtraParam extraParam) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tTBaseAd);
        onAdLoaded(arrayList, extraParam);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
        if (mo37349b() == 1) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018a A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x018a -> B:82:0x018e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0197 -> B:84:0x0192). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAdLoaded(java.util.List<com.bytedance.msdk.base.TTBaseAd> r9, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam r10) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.onAdLoaded(java.util.List, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d):void");
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdVideoCache() {
        if (this.f21794g == null || this.f21789b.get() || this.f21790c.get() || !this.f21788a.get()) {
            return;
        }
        this.f21790c.set(true);
        m37374w();
    }

    /* renamed from: p */
    public ConcurrentHashMap<String, AdLoadInfo> m37381p() {
        return this.f21758H;
    }

    /* renamed from: q */
    public int mo37380q() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -2;
    }

    /* renamed from: r */
    public String mo37379r() {
        TTBaseAd tTBaseAd = this.f21752B;
        return tTBaseAd != null ? tTBaseAd.getAdNetworkSlotId() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    /* renamed from: s */
    public String mo37378s() {
        TTBaseAd tTBaseAd = this.f21752B;
        return tTBaseAd != null ? tTBaseAd.getNetWorkPlatFormCpm() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    /* renamed from: t */
    public List<WaterFallConfig> m37377t() {
        ArrayList arrayList = new ArrayList();
        List<Integer> list = this.f21800m;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int intValue = list.get(i).intValue();
                if (this.f21792e.get(Integer.valueOf(intValue)) != null) {
                    arrayList.addAll(this.f21792e.get(Integer.valueOf(intValue)));
                }
            }
        }
        Iterator<WaterFallConfig> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (m37340h()) {
            m37395c(arrayList);
            return m37392d(arrayList);
        } else if (m37338j()) {
            return m37389e(arrayList);
        } else {
            Collections.sort(arrayList, this.f21763M);
            return arrayList;
        }
    }

    /* renamed from: u */
    protected abstract void mo37376u();

    /* renamed from: v */
    protected abstract void mo37375v();

    /* renamed from: w */
    protected void m37374w() {
        AdSlot adSlot = this.f21795h;
        if ((adSlot != null && adSlot.getAdType() == 7) || this.f21795h.getAdType() == 8) {
            Logger.m37547w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
        }
        if (mo37339i()) {
            return;
        }
        m37423I();
        ThreadHelper.runOnUiThread(new RunnableC6032a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public void m37373x() {
        ThreadHelper.runOnMSDKThread(new RunnableC6036e());
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                default:
                                    c2 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c = '^';
                        c2 = 'K';
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }
    }

    /* renamed from: y */
    protected void m37372y() {
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        if (adsenseRitConfig != null) {
            this.f21796i = adsenseRitConfig.m59556d();
            this.f21797j = this.f21791d.m59564b();
            this.f21765v = this.f21791d.m59545g();
            this.f21766w = this.f21791d.m59552e();
            this.f21767x = this.f21791d.m59536o();
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "mRitConfig=" + this.f21791d.toString());
        }
    }

    /* renamed from: z */
    protected void m37371z() {
        this.f21795h.setIfTest(m37363a());
        this.f21795h.setTransparentParams(m37344d());
        this.f21795h.setAdUnitId(this.f21793f);
        this.f21795h.setAdloadSeq(TTLoaderUtil.m37322a());
        this.f21795h.setLinkedId(TTLoaderUtil.m37306q());
        this.f21795h.getReuestParam().getExtraObject().put("tt_request_ad_type", Integer.valueOf(this.f21795h.getAdStyleType()));
        this.f21795h.setReqType(PreLoadManager.m59686a().m59672c(this.f21793f, m37363a()));
        AdsenseRitConfig adsenseRitConfig = this.f21791d;
        if (adsenseRitConfig != null) {
            this.f21795h.setWaterfallId(adsenseRitConfig.m59529v());
            this.f21795h.setVersion(this.f21791d.m59534q());
            this.f21795h.setSegmentId(this.f21791d.m59538m());
            this.f21795h.setSegmentVersion(this.f21791d.m59537n());
            this.f21795h.setmWaterfallExtra(this.f21791d.m59530u());
        }
    }
}
