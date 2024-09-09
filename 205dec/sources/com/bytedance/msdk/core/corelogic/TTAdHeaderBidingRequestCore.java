package com.bytedance.msdk.core.corelogic;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
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
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class TTAdHeaderBidingRequestCore extends com.bytedance.msdk.core.corelogic.d implements TTAbsAdLoaderAdapter.AdapterLoaderListener {
    protected ITTAdatperCallback A;
    protected TTBaseAd B;
    protected TTNetworkRequestInfo G;
    private boolean K;

    /* renamed from: v  reason: collision with root package name */
    private long f27855v;

    /* renamed from: w  reason: collision with root package name */
    private long f27856w;

    /* renamed from: x  reason: collision with root package name */
    private long f27857x;

    /* renamed from: y  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c f27858y;

    /* renamed from: z  reason: collision with root package name */
    protected Context f27859z;
    private final Map<String, TTAbsAdLoaderAdapter> C = new HashMap();
    private int D = -1000;
    private final AtomicBoolean E = new AtomicBoolean(false);
    protected AtomicBoolean F = new AtomicBoolean(false);
    private ConcurrentHashMap<String, AdLoadInfo> H = new ConcurrentHashMap<>();
    private long I = 0;
    private long J = 0;

    /* renamed from: L  reason: collision with root package name */
    private final Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> f27854L = new HashMap();
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> M = new b(this);
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> N = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.v();
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements Comparator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> {
        b(TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar2) {
            int l4;
            int l5;
            if (hVar.l() == hVar2.l()) {
                l4 = hVar.s();
                l5 = hVar2.s();
            } else {
                l4 = hVar.l();
                l5 = hVar2.l();
            }
            return l4 - l5;
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements Comparator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> {
        c(TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar2) {
            return (hVar.f() > hVar2.f() ? 1 : (hVar.f() == hVar2.f() ? 0 : -1)) >= 0 ? -1 : 1;
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d extends Handler {
        d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TTAdHeaderBidingRequestCore.this.a(message);
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Integer> list;
            Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> map;
            TTAdHeaderBidingRequestCore.this.I = SystemClock.elapsedRealtime();
            if (!bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b.g()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "MSDK\u672a\u8fdb\u884c\u521d\u59cb\u5316\uff01\uff01\uff01");
                TTAdHeaderBidingRequestCore.this.f(1);
                TTAdHeaderBidingRequestCore.this.a(new AdBreakError(1, AdError.getMessage(1)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                return;
            }
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore = TTAdHeaderBidingRequestCore.this;
            if (tTAdHeaderBidingRequestCore.f27859z == null) {
                Logger.e("TTMediationSDK", "Context\u4e3anull\uff01\uff01\uff01");
                TTAdHeaderBidingRequestCore.this.f((int) AdError.ERROR_CODE_CONTEXT_ERROR);
                TTAdHeaderBidingRequestCore.this.a(new AdBreakError(AdError.ERROR_CODE_CONTEXT_ERROR, AdError.getMessage(AdError.ERROR_CODE_CONTEXT_ERROR)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                return;
            }
            tTAdHeaderBidingRequestCore.L();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore2 = TTAdHeaderBidingRequestCore.this;
            if (tTAdHeaderBidingRequestCore2.f27885h == null) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "AdSlot can't be null\uff01\uff01");
                TTAdHeaderBidingRequestCore.this.f((int) AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR);
                TTAdHeaderBidingRequestCore.this.a(new AdBreakError(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                return;
            }
            if (tTAdHeaderBidingRequestCore2.f27881d == null && tTAdHeaderBidingRequestCore2.f27858y != null) {
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore3 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore3.f27881d = tTAdHeaderBidingRequestCore3.f27858y.b(TTAdHeaderBidingRequestCore.this.f27883f);
                TTAdHeaderBidingRequestCore.this.y();
            }
            if (com.bytedance.msdk.core.corelogic.a.c().b()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "\u8bf7\u6c42\u8fc7\u4e8e\u9891\u7e41\uff0c\u89e6\u53d1\u4e86\u7194\u65ad\u673a\u5236");
                TTAdHeaderBidingRequestCore.this.f((int) AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER);
                TTAdHeaderBidingRequestCore.this.a(new AdBreakError(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER, AdError.getMessage(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                return;
            }
            String testSlotId = TTAdHeaderBidingRequestCore.this.f27885h.getTestSlotId();
            if (!TextUtils.isEmpty(testSlotId) && TTAdHeaderBidingRequestCore.this.a() == 2) {
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore4 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore4.f27881d = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_goto109.a.a(tTAdHeaderBidingRequestCore4.f27881d, testSlotId);
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = TTAdHeaderBidingRequestCore.this.f27881d;
                int p3 = cVar != null ? cVar.p() : 0;
                TTAdHeaderBidingRequestCore.this.y();
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "\u6d4b\u8bd5\u5de5\u5177\u52a0\u8f7d\u5e7f\u544a........totalWaterFallCount: " + p3 + "  ,rit_id:" + TTAdHeaderBidingRequestCore.this.f27883f + " ,slot_id:" + testSlotId);
            }
            TTAdHeaderBidingRequestCore.this.z();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore5 = TTAdHeaderBidingRequestCore.this;
            if (tTAdHeaderBidingRequestCore5.f27881d == null) {
                tTAdHeaderBidingRequestCore5.f((int) AdError.ERROR_CODE_CONFIG_ERROR);
                if (TTAdHeaderBidingRequestCore.this.f27885h.getAdType() == 3 && !bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().p() && TTAdHeaderBidingRequestCore.this.G != null) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "settings config.......AdUnitId = " + TTAdHeaderBidingRequestCore.this.f27883f + "  \u5f00\u5c4f\u5e7f\u544a\u8d70\u4e86\u5f00\u53d1\u8005\u81ea\u5b9a\u4e49\u515c\u5e95\u65b9\u6848   adnName:" + com.bytedance.msdk.base.a.d(TTAdHeaderBidingRequestCore.this.G.getAdNetworkFlatFromId()));
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(TTAdHeaderBidingRequestCore.this.f27885h, -4);
                    TTAdHeaderBidingRequestCore.this.E();
                    return;
                }
                if (TTAdHeaderBidingRequestCore.this.f27858y != null && TTAdHeaderBidingRequestCore.this.f27858y.d() != null && TTAdHeaderBidingRequestCore.this.f27858y.d().size() != 0) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "settings config.......\u6ce8\u610f\uff0cAdUnitId = " + TTAdHeaderBidingRequestCore.this.f27885h.getAdUnitId() + " \u7684\u914d\u7f6e\u4fe1\u606f\u4e3a null \uff01\uff01");
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(TTAdHeaderBidingRequestCore.this.f27885h, 2);
                } else {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "settings config.......\u6ca1\u6709settings config\u914d\u7f6e\u4fe1\u606f,AdUnitId = " + TTAdHeaderBidingRequestCore.this.f27885h.getAdUnitId());
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(TTAdHeaderBidingRequestCore.this.f27885h, 1);
                }
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore6 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore6.a(tTAdHeaderBidingRequestCore6.f27883f, tTAdHeaderBidingRequestCore6.E);
                return;
            }
            tTAdHeaderBidingRequestCore5.f27896s = tTAdHeaderBidingRequestCore5.f27885h.getAdCount();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore7 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore7.f27882e = tTAdHeaderBidingRequestCore7.f27881d.r();
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore8 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore8.f27890m = new ArrayList(tTAdHeaderBidingRequestCore8.f27881d.f());
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().e(TTAdHeaderBidingRequestCore.this.f27883f) && (list = TTAdHeaderBidingRequestCore.this.f27890m) != null && list.size() != 0 && (map = TTAdHeaderBidingRequestCore.this.f27882e) != null && map.size() != 0) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b();
                if (!b4.b(TTAdHeaderBidingRequestCore.this.f27883f + "")) {
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i b5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b();
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g h4 = b5.h(TTAdHeaderBidingRequestCore.this.f27883f + "");
                    Pair<String, String> f4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b().f(TTAdHeaderBidingRequestCore.this.f27883f);
                    if (h4 == null || f4 == null) {
                        return;
                    }
                    AdFreqError adFreqError = new AdFreqError(AdError.ERROR_CODE_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_EXCEED_FREQCTL), (String) f4.second, (String) f4.first);
                    TTAdHeaderBidingRequestCore.this.f(adFreqError.code);
                    TTAdHeaderBidingRequestCore.this.a(adFreqError, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i b6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b();
                if (!b6.c(TTAdHeaderBidingRequestCore.this.f27883f + "") && !TTAdHeaderBidingRequestCore.this.i()) {
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i b7 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b();
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h i4 = b7.i(TTAdHeaderBidingRequestCore.this.f27883f + "");
                    if (i4 != null) {
                        String message = AdError.getMessage(AdError.ERROR_CODE_EXCEED_PACING);
                        AdPacingError adPacingError = new AdPacingError(AdError.ERROR_CODE_EXCEED_PACING, message, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b().g(TTAdHeaderBidingRequestCore.this.f27883f) + "", i4.f());
                        TTAdHeaderBidingRequestCore.this.f(adPacingError.code);
                        TTAdHeaderBidingRequestCore.this.a(adPacingError, (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                        return;
                    }
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i b8 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b();
                if (!b8.b(TTAdHeaderBidingRequestCore.this.f27883f + "")) {
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i b9 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b();
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g h5 = b9.h(TTAdHeaderBidingRequestCore.this.f27883f + "");
                    Pair<String, String> f5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b().f(TTAdHeaderBidingRequestCore.this.f27883f);
                    if (h5 == null || f5 == null) {
                        return;
                    }
                    TTAdHeaderBidingRequestCore.this.a(new AdFreqError(AdError.ERROR_CODE_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_EXCEED_FREQCTL), (String) f5.second, (String) f5.first), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                    return;
                }
                com.bytedance.msdk.core.corelogic.c.a(TTAdHeaderBidingRequestCore.this.f27890m);
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a();
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore9 = TTAdHeaderBidingRequestCore.this;
                if (a4.c(tTAdHeaderBidingRequestCore9.f27883f, tTAdHeaderBidingRequestCore9.a()) != 0) {
                    boolean z3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().g(TTAdHeaderBidingRequestCore.this.f27883f) == null;
                    if (!TTAdHeaderBidingRequestCore.this.i() && !z3 && TTAdHeaderBidingRequestCore.this.D()) {
                        TTAdHeaderBidingRequestCore.this.B();
                        return;
                    }
                    if (!TTAdHeaderBidingRequestCore.this.i() && !z3) {
                        TTAdHeaderBidingRequestCore.this.f27885h.setPrimeRitReqType(3);
                    }
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a();
                    TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore10 = TTAdHeaderBidingRequestCore.this;
                    a5.b(tTAdHeaderBidingRequestCore10.f27883f, tTAdHeaderBidingRequestCore10.f27885h);
                }
                TTAdHeaderBidingRequestCore.this.G();
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore11 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore11.f27895r.f(tTAdHeaderBidingRequestCore11.f27890m);
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore12 = TTAdHeaderBidingRequestCore.this;
                tTAdHeaderBidingRequestCore12.f27895r.r(tTAdHeaderBidingRequestCore12.f27881d.p());
                TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore13 = TTAdHeaderBidingRequestCore.this;
                Handler handler = tTAdHeaderBidingRequestCore13.f27884g;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(2, tTAdHeaderBidingRequestCore13.f27857x);
                }
                TTAdHeaderBidingRequestCore.this.a(0, false);
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).d().c();
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "settings config.......\u6ce8\u610f\uff0cAdUnitId = " + TTAdHeaderBidingRequestCore.this.f27885h.getAdUnitId() + "  \u6ca1\u6709\u5bf9\u5e94\u7684waterfall\u914d\u7f6e\u4fe1\u606f");
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(TTAdHeaderBidingRequestCore.this.f27885h, 3);
            TTAdHeaderBidingRequestCore.this.f((int) AdError.ERROR_CODE_LOAD_PANGOLIN);
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore14 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore14.a(tTAdHeaderBidingRequestCore14.f27883f, tTAdHeaderBidingRequestCore14.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27863a;

        f(String str) {
            this.f27863a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.c(this.f27863a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements ThirdSdkInit.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27865a;

        g(String str) {
            this.f27865a = str;
        }

        @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
        public void fail(int i4, String str) {
            TTAdHeaderBidingRequestCore.this.a(PangleAdapterUtils.buildAdError(AdError.ERROR_CODE_THIRD_SDK_NOT_INIT, AdError.messageFormat(AdError.AD_THIRD_SDK_INIT_FAIL_MSG, "pangle", new String[0])), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
            Logger.e("TTMediationSDK", "\u515c\u5e95\u7b56\u7565\uff1b\uff1b\uff1b\uff1b\uff1b\uff1bpangle init fail \uff0ccode=" + i4 + "\uff0cmsg = " + str);
        }

        @Override // com.bytedance.msdk.adapter.ThirdSdkInit.InitCallback
        public void success() {
            TTAdHeaderBidingRequestCore.this.c(this.f27865a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Handler handler = TTAdHeaderBidingRequestCore.this.f27884g;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                List<TTBaseAd> list = TTAdHeaderBidingRequestCore.this.f27893p;
                if (list != null) {
                    list.clear();
                }
                List<TTBaseAd> list2 = TTAdHeaderBidingRequestCore.this.f27891n;
                if (list2 != null) {
                    list2.clear();
                }
                List<TTBaseAd> list3 = TTAdHeaderBidingRequestCore.this.f27892o;
                if (list3 != null) {
                    list3.clear();
                }
                TTBaseAd tTBaseAd = TTAdHeaderBidingRequestCore.this.B;
                if (tTBaseAd != null) {
                    tTBaseAd.onDestroy();
                }
                if (TTAdHeaderBidingRequestCore.this.C != null) {
                    for (Map.Entry entry : TTAdHeaderBidingRequestCore.this.C.entrySet()) {
                        if (entry != null) {
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = (TTAbsAdLoaderAdapter) entry.getValue();
                            tTAbsAdLoaderAdapter.setAdapterListener(null);
                            tTAbsAdLoaderAdapter.destroy();
                        }
                    }
                    TTAdHeaderBidingRequestCore.this.C.clear();
                }
                TTAdHeaderBidingRequestCore.this.f27894q.clear();
                TTAdHeaderBidingRequestCore.this.f27895r.y();
            } catch (Throwable unused) {
            }
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore.A = null;
            tTAdHeaderBidingRequestCore.f27858y = null;
            TTAdHeaderBidingRequestCore tTAdHeaderBidingRequestCore2 = TTAdHeaderBidingRequestCore.this;
            tTAdHeaderBidingRequestCore2.f27882e = null;
            tTAdHeaderBidingRequestCore2.f27859z = null;
            tTAdHeaderBidingRequestCore2.G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdError f27869a;

        j(AdError adError) {
            this.f27869a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.a(this.f27869a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTAdHeaderBidingRequestCore.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class l implements Runnable {

        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdHeaderBidingRequestCore.this.v();
            }
        }

        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TTAdHeaderBidingRequestCore.this.f27878a.get() || TTAdHeaderBidingRequestCore.this.f27880c.get()) {
                return;
            }
            TTAdHeaderBidingRequestCore.this.f27880c.set(true);
            AdSlot adSlot = TTAdHeaderBidingRequestCore.this.f27885h;
            if ((adSlot != null && adSlot.getAdType() == 7) || TTAdHeaderBidingRequestCore.this.f27885h.getAdType() == 8) {
                Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(TTAdHeaderBidingRequestCore.this.f27883f) + "m-sdk----\u8bbe\u7f6e cacheTimeout \u5df2\u5230\u65f6\u95f4\u3010" + bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().c(TTAdHeaderBidingRequestCore.this.f27885h.getAdUnitId()) + "\u3011\uff0c\u7ed9\u5916\u90e8invokeAdVideoCache ...");
            }
            if (TTAdHeaderBidingRequestCore.this.i()) {
                return;
            }
            TTAdHeaderBidingRequestCore.this.I();
            ThreadHelper.runOnUiThread(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TTAdHeaderBidingRequestCore(Context context, String str) {
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> r3;
        this.f27859z = context;
        this.f27883f = str;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c f4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f();
        this.f27858y = f4;
        if (f4 != null) {
            b(f4.k());
            b(this.f27858y.l());
            this.f27881d = this.f27858y.b(this.f27883f);
            y();
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        if (cVar != null && (r3 = cVar.r()) != null) {
            for (Map.Entry<Integer, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> entry : r3.entrySet()) {
                List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> value = entry.getValue();
                if (value != null && value.size() > 0 && value.get(0).e() == 100) {
                    this.f27854L.put(entry.getKey(), entry.getValue());
                }
            }
        }
        this.f27884g = new d(ThreadHelper.getMSDKThreadLooper());
    }

    private int A() {
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> list;
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> map = this.f27882e;
        if (map == null || map.isEmpty() || this.f27890m == null) {
            return -1;
        }
        int c4 = c(this.D);
        int i4 = 0;
        for (int i5 = 0; i5 < c4 && i5 < this.f27890m.size(); i5++) {
            Integer num = this.f27890m.get(i5);
            if (this.f27882e.containsKey(num) && (list = this.f27882e.get(num)) != null) {
                i4 += list.size();
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        AdSlot c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().c(this.f27883f);
        if (c4 != null) {
            this.f27885h.setLinkedId(c4.getLinkedId());
            this.f27885h.setPrimeRitReqType(c4.getPrimeRitReqType());
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().b(this.f27883f, this.f27885h);
        G();
        F();
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c d4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().d(this.f27883f);
        if (d4 != null) {
            this.f27898u = d4.f27898u;
            this.H = d4.p();
        }
        f();
    }

    private boolean C() {
        List<TTBaseAd> list = this.f27893p;
        if (list != null) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list2 = this.f27892o;
        if (list2 != null) {
            for (TTBaseAd tTBaseAd2 : list2) {
                if (tTBaseAd2.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list3 = this.f27891n;
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
    public boolean D() {
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> h4;
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "mLoadSortList: " + this.f27890m);
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().a(this.f27883f, this.f27885h) && (h4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().h(this.f27883f)) != null && h4.size() > 0) {
            for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f fVar : h4) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(fVar.f418a);
                a(arrayList);
            }
            if (this.f27893p.size() > 0 || this.f27892o.size() > 0 || this.f27891n.size() > 0) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "--==-- not hit cache!!! -----");
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.E():void");
    }

    private void F() {
        if (this.f27897t.get() || this.K) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.J = elapsedRealtime;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27885h, this.f27881d, elapsedRealtime - this.I, c());
        this.f27897t.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27885h, cVar != null ? cVar.t() : null, c(), 0);
    }

    private void H() {
        TTAbsAdLoaderAdapter value;
        for (Map.Entry<String, TTAbsAdLoaderAdapter> entry : this.C.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.setTotalTimedOut(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        AdSlot adSlot = this.f27885h;
        if ((adSlot == null || adSlot.getAdType() != 7) && this.f27885h.getAdType() != 8) {
            return;
        }
        AdSlot adSlot2 = this.f27885h;
        TTBaseAd tTBaseAd = this.B;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.J;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adSlot2, tTBaseAd, elapsedRealtime, cVar != null ? cVar.t() : null);
    }

    private void J() {
        if (this.f27884g != null) {
            if (!C()) {
                this.f27884g.postDelayed(new l(), bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().c(this.f27885h.getAdUnitId()));
            } else if (!this.f27878a.get() || this.f27880c.get()) {
            } else {
                this.f27880c.set(true);
                AdSlot adSlot = this.f27885h;
                if ((adSlot != null && adSlot.getAdType() == 7) || this.f27885h.getAdType() == 8) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u4eceonAdLoaded\u7ed9\u5916\u90e8invokeAdVideoCache ...");
                }
                if (i()) {
                    return;
                }
                I();
                ThreadHelper.runOnUiThread(new k());
            }
        }
    }

    private void K() {
        Handler handler = this.f27884g;
        if (handler != null) {
            handler.removeMessages(1);
            this.f27884g.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.B = null;
        this.E.set(false);
        this.F.set(false);
        this.f27897t.set(false);
        this.f27892o.clear();
        this.f27891n.clear();
        this.f27893p.clear();
        this.f27878a.set(false);
        this.f27879b.set(false);
        this.f27880c.set(false);
        Handler handler = this.f27884g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.bytedance.msdk.core.corelogic.g gVar = this.f27895r;
        if (gVar != null) {
            gVar.y();
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar2 = this.f27898u;
        if (gVar2 != null) {
            gVar2.f531a = null;
        }
    }

    private void a(String str, String str2, String str3, int i4, String str4) {
        AdLoadInfo adLoadInfo = this.H.get(str);
        if (adLoadInfo == null) {
            adLoadInfo = new AdLoadInfo();
        }
        adLoadInfo.setMediationRit(str).setAdnName(str2).setErrCode(i4).setErrMsg(str4).setAdType(str3);
        this.H.put(str, adLoadInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AtomicBoolean atomicBoolean) {
        if (i()) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d();
        dVar.c(-1);
        dVar.d(-1);
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().d(str)) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "settings config.......AdUnitId = " + str + "  \u6682\u65e0config\u914d\u7f6e\u4fe1\u606f");
            a(new AdError(AdError.ERROR_CODE_NO_CONFIG, AdError.getMessage(AdError.ERROR_CODE_NO_CONFIG)), dVar);
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).d().c();
            return;
        }
        a(new AdError(AdError.ERROR_CODE_ADSLOT_ID_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ID_ERROR)), dVar);
        while (true) {
            for (char c4 = 14; c4 != '\f'; c4 = '\r') {
                if (c4 == '\r') {
                    return;
                }
            }
        }
    }

    private boolean a(String str, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, int i4) {
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f27885h);
        if (a4 == null || a4.size() <= 0) {
            return false;
        }
        TTBaseAd tTBaseAd = a4.get(0).f418a;
        AdSlot adSlot = this.f27885h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.b(hVar, this.f27885h, 3, mediationRitReqType);
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(hVar, this.f27885h, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(str), i4, 3, mediationRitReqType, (AdError) null);
        ArrayList arrayList = new ArrayList();
        for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f fVar : a4) {
            fVar.f418a.setMediationRitReqType(3);
            fVar.f418a.setMediationRitReqTypeSrc(mediationRitReqType);
            arrayList.add(fVar.f418a);
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(a4.get(0).f418a, 0, "adn cache\u547d\u4e2d", 0L, this.f27885h, i4, arrayList.size(), false);
        onAdLoaded(arrayList, a4.get(0).f419b);
        return true;
    }

    private void b(AdError adError) {
        this.K = true;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27885h, adError, cVar != null ? cVar.t() : null, c());
    }

    private void b(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
        if (list.get(0).isServerBiddingAd() || !bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(adNetworkSlotId, a())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TTBaseAd tTBaseAd : list) {
            if (tTBaseAd != null) {
                arrayList.add(new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f(tTBaseAd, dVar, 0L, SystemClock.elapsedRealtime(), this.f27885h));
            }
        }
        if (arrayList.size() > 0) {
            TTBaseAd tTBaseAd2 = ((bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f) arrayList.get(0)).f418a;
            Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5e7f\u544a\u7f13\u5b58\u6210\u529f -------" + tTBaseAd2.getAdNetWorkName() + ", adType: " + com.bytedance.msdk.base.a.b(tTBaseAd2.getAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad\u4e2a\u6570: " + arrayList.size());
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(adNetworkSlotId, arrayList);
        }
    }

    private int c(int i4) {
        List<Integer> list = this.f27890m;
        if (list == null) {
            return -1;
        }
        return list.indexOf(Integer.valueOf(i4)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Handler handler;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h c4 = com.bytedance.msdk.core.corelogic.f.c(this.G.getAdNetworkSlotId(), str, -4, -4);
        if (c4 != null) {
            if (this.f27855v != 0 && (handler = this.f27884g) != null) {
                handler.removeMessages(3);
                this.f27884g.sendEmptyMessageDelayed(3, this.f27855v);
            }
            a(c4, -1);
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).d().c();
    }

    private void c(List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar = list.get(i4);
            if (hVar.e() == 1) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar2 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h();
                hVar2.a(hVar.c());
                hVar2.b(hVar.e());
                hVar2.b(hVar.d());
                hVar2.a(hVar.b());
                hVar2.e(hVar.m());
                hVar2.f(hVar.l());
                hVar2.i(hVar.s());
                hVar2.h(hVar.o());
                hVar2.c("" + hVar.f());
                hVar2.d(hVar.h());
                hVar2.g(hVar.t());
                hVar2.f(hVar.q());
                hVar2.a(hVar.r());
                list.set(i4, hVar2);
            }
        }
    }

    private List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> d(List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> list) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f a4;
        ArrayList arrayList = new ArrayList();
        Iterator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> it = list.iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h next = it.next();
            if (next.e() == 100) {
                arrayList.add(next);
                it.remove();
            }
            if (next.e() == 1 && (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().a(this.f27883f, next.c())) != null) {
                next.c("" + a4.f418a.getCpm());
            }
        }
        Collections.sort(arrayList, this.M);
        Collections.sort(list, this.N);
        arrayList.addAll(list);
        return arrayList;
    }

    private boolean d(int i4) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar;
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> list = this.f27882e.get(Integer.valueOf(i4));
        if (list != null) {
            Iterator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> it = list.iterator();
            while (it.hasNext()) {
                hVar = it.next();
                if (hVar != null && hVar.u() && TextUtils.equals(hVar.d(), "pangle")) {
                    break;
                }
            }
        }
        hVar = null;
        return hVar != null && hVar.n() == 3;
    }

    private List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> e(List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> it = list.iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h next = it.next();
            if (next.u()) {
                it.remove();
                arrayList.add(next);
            }
        }
        Collections.sort(list, this.M);
        list.addAll(arrayList);
        if ((list.size() <= 0 || list.get(0).e() != 100) && this.f27854L.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<Integer, List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> entry : this.f27854L.entrySet()) {
                arrayList2.addAll(entry.getValue());
            }
            Collections.sort(arrayList2, this.M);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(int r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.e(int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i4) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27885h, cVar != null ? cVar.t() : null, c(), i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, boolean z3) {
        if (this.f27878a.get() || this.f27879b.get()) {
            return;
        }
        if (i4 >= this.f27890m.size() || this.f27895r.o(this.f27890m.get(i4).intValue())) {
            if (this.f27895r.u()) {
                if (this.f27893p.size() > 0 || this.f27891n.size() > 0 || this.f27892o.size() > 0) {
                    f();
                } else {
                    a(new AdError(20005, AdError.getMessage(20005)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                }
            }
            if (z3 || i4 >= this.f27890m.size()) {
                return;
            }
        }
        int intValue = this.f27890m.get(i4).intValue();
        if (!this.f27895r.o(intValue)) {
            if (intValue == 0 && j() && !this.f27895r.s()) {
                this.f27895r.n(true);
                if (d(intValue)) {
                    a(AdErrorUtil.obtainAdError(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH, AdError.getMessage(AdError.ERROR_CODE_RENDER_TYPE_MISMATCH)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                    return;
                }
                a(this.f27885h, this.f27882e.get(Integer.valueOf(intValue)));
                a(i4 + 1, false);
                return;
            }
            this.D = intValue;
            this.f27895r.q(intValue);
            this.f27895r.d(intValue, true);
            if (e(intValue)) {
                return;
            }
        }
        a(i4 + 1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Message message) {
        StringBuilder sb;
        String str;
        char c4;
        char c5;
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        StringBuilder sb2;
        String str2;
        List<TTBaseAd> list3;
        List<TTBaseAd> list4;
        int i4 = message.what;
        if (i4 == 1) {
            int i5 = message.arg1;
            if (i5 == 10003) {
                if (this.f27893p.size() != 0) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709P\u5c42\u7c7b\u578b\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42....mTTPAdPoolList.size()=" + this.f27893p.size());
                    f();
                    return;
                }
                Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5f53\u524d\u5c42\u8d85\u65f6....P\u5c42\u5e7f\u544a\u6c60\u6ca1\u5e7f\u544a\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTPAdPoolList.size()=" + this.f27893p.size());
                a(c(this.D), false);
                c4 = 'W';
                c5 = ' ';
                if (c5 != 31) {
                }
                do {
                } while (c4 == '\r');
                return;
            } else if (a(i5)) {
                if (j() && !m()) {
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f27883f));
                    str = "\u5f53\u524d\u5c42\u8d85\u65f6....server Bidding \u8fd8\u6ca1\u6709\u63a5\u53e3\u8fd4\u56de\uff0c\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTCommonAdPoolList.size()=";
                } else if (this.f27891n.size() != 0) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42....mTTCommonAdPoolList.size()=" + this.f27891n.size());
                    f();
                } else {
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f27883f));
                    str = "\u5f53\u524d\u5c42\u8d85\u65f6....\u666e\u901a\u5e7f\u544a\u6c60\u6ca1\u5e7f\u544a\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTCommonAdPoolList.size()=";
                }
                sb.append(str);
                sb.append(this.f27891n.size());
                Logger.w("TTMediationSDK", sb.toString());
                a(c(this.D), false);
                return;
            } else {
                return;
            }
        }
        if (i4 == 2) {
            this.f27895r.k(true);
            H();
            if (this.f27878a.get() || this.f27879b.get()) {
                return;
            }
            List<TTBaseAd> list5 = this.f27893p;
            if ((list5 == null || list5.size() <= 0) && (((list = this.f27891n) == null || list.size() <= 0) && ((list2 = this.f27892o) == null || list2.size() <= 0))) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u603b\u52a0\u8f7d\u65f6\u95f4\u8d85\u65f6.......\u6ca1\u6709\u5e7f\u544a\u56de\u8c03\u5931\u8d25");
                a(new AdError(10003, AdError.getMessage(10003)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                c4 = 15;
                c5 = '!';
                if (c5 != 31 || c5 == '!') {
                    do {
                    } while (c4 == '\r');
                    return;
                }
                return;
            }
            sb2 = new StringBuilder();
            sb2.append(TTLogUtil.getTagSecondLevel(this.f27883f));
            str2 = "\u603b\u52a0\u8f7d\u65f6\u95f4\u8d85\u65f6.......\u6709\u5e7f\u544a\u56de\u8c03\u6210\u529f";
        } else if (i4 != 3) {
            return;
        } else {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4.....");
            if (this.f27878a.get() || this.f27879b.get()) {
                return;
            }
            if (this.f27895r.s() && j() && !m()) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4.....  \u5f53\u524d\u6b63\u5904\u4e8eserver Bidding \u7684\u7f51\u7edc\u8bf7\u6c42\u4e2d.......");
                return;
            }
            List<TTBaseAd> list6 = this.f27893p;
            if ((list6 == null || list6.size() <= 0) && (((list3 = this.f27891n) == null || list3.size() <= 0) && ((list4 = this.f27892o) == null || list4.size() <= 0))) {
                return;
            }
            sb2 = new StringBuilder();
            sb2.append(TTLogUtil.getTagSecondLevel(this.f27883f));
            str2 = "\u8d85\u8fc7\u5f53\u524d\u5c42\u6700\u77ed\u52a0\u8f7d\u65f6\u95f4....\u6709\u5e7f\u544a\u56de\u8c03\u6210\u529f\u51fa\u53bb....";
        }
        sb2.append(str2);
        Logger.d("TTMediationSDK", sb2.toString());
        f();
    }

    protected void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar, int i4, int i5) {
        if (hVar != null) {
            this.f27895r.e(hVar.c());
            hVar.f(c());
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(hVar, this.f27885h, i4, i5);
        }
    }

    protected abstract void a(AdError adError);

    @Override // com.bytedance.msdk.core.corelogic.d
    protected void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        K();
        if (this.f27879b.get() || this.f27878a.get()) {
            return;
        }
        this.f27879b.set(true);
        if (b() != 1 || (adError instanceof AdFreqError) || (adError instanceof AdPacingError) || (adError instanceof AdBreakError)) {
            b(adError);
        }
        if (i()) {
            if ((adError instanceof AdFreqError) || (adError instanceof AdPacingError) || (adError instanceof AdBreakError)) {
                AdSlot adSlot = this.f27885h;
                TTBaseAd tTBaseAd = this.B;
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.I;
                int A = A();
                int c4 = c(this.D);
                int i4 = adError.code;
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adSlot, tTBaseAd, elapsedRealtime, A, c4, i4, cVar != null ? cVar.t() : null);
                return;
            }
            return;
        }
        AdSlot adSlot2 = this.f27885h;
        TTBaseAd tTBaseAd2 = this.B;
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.I;
        int A2 = A();
        int c5 = c(this.D);
        int i5 = adError.code;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar2 = this.f27881d;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adSlot2, tTBaseAd2, elapsedRealtime2, A2, c5, i5, cVar2 != null ? cVar2.t() : null);
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeAdLoadFailCallbackOnMainUI...... error Code = " + adError.code + " error Message = " + adError.message);
        ThreadHelper.runOnUiThread(new j(adError));
    }

    protected void a(List<TTBaseAd> list) {
        TTBaseAd tTBaseAd;
        if (list == null || list.size() <= 0 || (tTBaseAd = list.get(0)) == null) {
            return;
        }
        if (tTBaseAd.isPAd()) {
            this.f27893p.addAll(list);
            com.bytedance.msdk.core.corelogic.f.i(this.f27893p, null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd2 : list) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86P\u5c42\u5e7f\u544a_\u5f53\u524dP\u5c42\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.f27893p.size() + ",slotId\uff1a" + tTBaseAd2.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd2.getAdNetworkPlatformId()) + ",loadSort=" + tTBaseAd2.getLoadSort() + ",showSort=" + tTBaseAd2.getShowSort() + ",CPM=" + tTBaseAd2.getCpm());
                }
            }
        } else if (tTBaseAd.isBidingAd()) {
            a(list, tTBaseAd);
        } else {
            this.f27891n.addAll(list);
            com.bytedance.msdk.core.corelogic.f.i(this.f27891n, null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd3 : this.f27891n) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86\u666e\u901a\u5c42\u5e7f\u544a_\u5f53\u524d\u666e\u901a\u5e7f\u544a\u7f13\u5b58\u6c60\u6570\u91cf\uff1a" + this.f27891n.size() + ",slotId\uff1a" + tTBaseAd3.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd3.getAdNetworkPlatformId()) + ",loadSort=" + tTBaseAd3.getLoadSort() + ",showSort=" + tTBaseAd3.getShowSort() + ",CPM=" + tTBaseAd3.getCpm());
                }
            }
        }
    }

    protected void a(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
    }

    @Override // com.bytedance.msdk.core.corelogic.d
    protected void a(boolean z3) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h hVar;
        Handler handler;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar;
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> s3;
        ThirdSdkInit.initTTPangleSDK(this.f27859z);
        if (z3 && (cVar = this.f27881d) != null && (s3 = cVar.s()) != null) {
            Iterator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> it = s3.iterator();
            while (it.hasNext()) {
                hVar = it.next();
                if ("pangle".equals(hVar.d())) {
                    break;
                }
            }
        }
        hVar = null;
        if (hVar == null) {
            hVar = com.bytedance.msdk.core.corelogic.f.b(this.f27885h, -1, -1);
        }
        if (hVar != null) {
            if (this.f27855v != 0 && (handler = this.f27884g) != null) {
                handler.removeMessages(3);
                this.f27884g.sendEmptyMessageDelayed(3, this.f27855v);
            }
            a(hVar, -1);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h r17, int r18) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h, int):boolean");
    }

    public HashMap<String, TTBaseAd> b(List<TTBaseAd> list) {
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
    public void b(TTBaseAd tTBaseAd) {
        AdSlot adSlot = this.f27885h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        tTBaseAd.setMediationRitReqType(3);
        tTBaseAd.setMediationRitReqTypeSrc(mediationRitReqType);
    }

    @Override // com.bytedance.msdk.core.corelogic.d
    protected void f() {
        K();
        if (this.f27878a.get() || this.f27879b.get()) {
            return;
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeAdLoadCallbackOnMainUI........P.size:" + this.f27893p.size() + "   bidding.size:" + this.f27892o.size() + "   normal.size:" + this.f27891n.size());
        this.f27878a.set(true);
        n();
        if (i()) {
            return;
        }
        AdSlot adSlot = this.f27885h;
        TTBaseAd tTBaseAd = this.B;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.I;
        int A = A();
        int c4 = c(this.D);
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adSlot, tTBaseAd, elapsedRealtime, A, c4, 0, cVar != null ? cVar.t() : null);
        ThreadHelper.runOnUiThread(new i());
        J();
    }

    @Keep
    public List<AdLoadInfo> getAdLoadInfoList() {
        AdLoadInfo value;
        ArrayList arrayList = new ArrayList(this.H.size());
        for (Map.Entry<String, AdLoadInfo> entry : this.H.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals(AdLoadInfo.AD_LOADED, value.getErrMsg()) && !TextUtils.equals(AdLoadInfo.AD_LOADING, value.getErrMsg())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public void o() {
        ThreadHelper.runOnMSDKThread(new h());
    }

    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        AdSlot adSlot;
        if (this.f27884g == null || dVar == null) {
            return;
        }
        if (adError != null) {
            a(dVar.d(), dVar.c(), com.bytedance.msdk.base.a.b(dVar.b()), adError.thirdSdkErrorCode, adError.thirdSdkErrorMessage);
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25...........adnName:" + dVar.c() + " ,slotId:" + dVar.d() + ",slotType:" + dVar.a() + ",loadSort:" + dVar.e() + ",showSort:" + dVar.f() + " \uff0cadError:" + adError.toString());
        }
        com.bytedance.msdk.core.corelogic.f.h(adError, dVar);
        if (dVar.a() == 0 && a(dVar.d())) {
            return;
        }
        if (dVar.g()) {
            this.f27895r.a();
        }
        this.f27895r.e(dVar.d());
        this.f27895r.b(dVar.e());
        if (this.f27878a.get() || this.f27879b.get()) {
            return;
        }
        List<TTBaseAd> list3 = this.f27893p;
        if ((list3 == null || list3.size() <= 0) && (((list = this.f27891n) == null || list.size() <= 0) && ((list2 = this.f27892o) == null || list2.size() <= 0))) {
            if (!this.f27895r.w() && this.f27895r.u() && (adSlot = this.f27885h) != null && !TextUtils.isEmpty(adSlot.getTestSlotId()) && a() == 2) {
                a(adError, dVar);
                return;
            }
        } else if (!this.f27895r.w() && this.f27895r.u()) {
            f();
            return;
        }
        if (this.f27895r.i(dVar.e()) == 0) {
            int c4 = c(dVar.e());
            Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "onAdFailed--\u300b \u52a0\u8f7d\u4e0b\u4e00\u5c42-nextIdx=" + c4);
            a(c4, true);
        }
        if (this.f27895r.w() || this.f27895r.u()) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u6240\u6709\u5e7f\u544a\u90fd\u52a0\u8f7d\u5931\u8d25....");
            a(new AdError(20005, AdError.getMessage(20005)), dVar);
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tTBaseAd);
        onAdLoaded(arrayList, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
        if (b() == 1) goto L20;
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
    public void onAdLoaded(java.util.List<com.bytedance.msdk.base.TTBaseAd> r9, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d r10) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore.onAdLoaded(java.util.List, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d):void");
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdVideoCache() {
        if (this.f27884g == null || this.f27879b.get() || this.f27880c.get() || !this.f27878a.get()) {
            return;
        }
        this.f27880c.set(true);
        w();
    }

    public ConcurrentHashMap<String, AdLoadInfo> p() {
        return this.H;
    }

    public int q() {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -2;
    }

    public String r() {
        TTBaseAd tTBaseAd = this.B;
        return tTBaseAd != null ? tTBaseAd.getAdNetworkSlotId() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    public String s() {
        TTBaseAd tTBaseAd = this.B;
        return tTBaseAd != null ? tTBaseAd.getNetWorkPlatFormCpm() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
    }

    public List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> t() {
        ArrayList arrayList = new ArrayList();
        List<Integer> list = this.f27890m;
        if (list != null && list.size() > 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue = list.get(i4).intValue();
                if (this.f27882e.get(Integer.valueOf(intValue)) != null) {
                    arrayList.addAll(this.f27882e.get(Integer.valueOf(intValue)));
                }
            }
        }
        Iterator<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (h()) {
            c(arrayList);
            return d(arrayList);
        } else if (j()) {
            return e(arrayList);
        } else {
            Collections.sort(arrayList, this.M);
            return arrayList;
        }
    }

    protected abstract void u();

    protected abstract void v();

    protected void w() {
        AdSlot adSlot = this.f27885h;
        if ((adSlot != null && adSlot.getAdType() == 7) || this.f27885h.getAdType() == 8) {
            Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u7f13\u5b58\u6210\u529f\uff01\u7ed9\u5916\u90e8\u56de\u8c03\uff1ainvokeAdVideoCacheOnMainUI........");
        }
        if (i()) {
            return;
        }
        I();
        ThreadHelper.runOnUiThread(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        ThreadHelper.runOnMSDKThread(new e());
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                default:
                                    c5 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                    case '^':
                        if (c5 <= 4) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }
    }

    protected void y() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        if (cVar != null) {
            this.f27886i = cVar.d();
            this.f27887j = this.f27881d.b();
            this.f27855v = this.f27881d.g();
            this.f27856w = this.f27881d.e();
            this.f27857x = this.f27881d.o();
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "mRitConfig=" + this.f27881d.toString());
        }
    }

    protected void z() {
        this.f27885h.setIfTest(a());
        this.f27885h.setTransparentParams(d());
        this.f27885h.setAdUnitId(this.f27883f);
        this.f27885h.setAdloadSeq(com.bytedance.msdk.core.corelogic.f.a());
        this.f27885h.setLinkedId(com.bytedance.msdk.core.corelogic.f.q());
        this.f27885h.getReuestParam().getExtraObject().put("tt_request_ad_type", Integer.valueOf(this.f27885h.getAdStyleType()));
        this.f27885h.setReqType(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().c(this.f27883f, a()));
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar = this.f27881d;
        if (cVar != null) {
            this.f27885h.setWaterfallId(cVar.v());
            this.f27885h.setVersion(this.f27881d.q());
            this.f27885h.setSegmentId(this.f27881d.m());
            this.f27885h.setSegmentVersion(this.f27881d.n());
            this.f27885h.setmWaterfallExtra(this.f27881d.u());
        }
    }
}
