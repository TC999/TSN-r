package com.bytedance.msdk.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.c.sr;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.k.ev;
import com.bytedance.msdk.core.k.gd;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.k.xv;
import com.bytedance.msdk.f.ck;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.wx;
import com.bytedance.msdk.f.yu;
import com.bytedance.msdk.xv.r;
import com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.wv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {
    private int ba;
    private InterfaceC0386c bk;

    /* renamed from: c  reason: collision with root package name */
    protected String f26913c;
    private int ck;
    private int eq;
    private int fp;
    private String fz;
    private ev gb;

    /* renamed from: i  reason: collision with root package name */
    private long f26915i;
    private double ia;

    /* renamed from: j  reason: collision with root package name */
    private int f26916j;
    private int ls;

    /* renamed from: n  reason: collision with root package name */
    private int f26918n;

    /* renamed from: q  reason: collision with root package name */
    private int f26920q;

    /* renamed from: s  reason: collision with root package name */
    private String f26922s;
    protected gd sr;

    /* renamed from: t  reason: collision with root package name */
    private String f26923t;

    /* renamed from: u  reason: collision with root package name */
    private long f26924u;
    protected int ux;

    /* renamed from: w  reason: collision with root package name */
    protected p f26925w;
    protected com.bytedance.msdk.api.c.w xv;

    /* renamed from: y  reason: collision with root package name */
    private boolean f26926y;
    private int ys;

    /* renamed from: z  reason: collision with root package name */
    private String f26927z;

    /* renamed from: f  reason: collision with root package name */
    private final int f26914f = 10;

    /* renamed from: r  reason: collision with root package name */
    private final String f26921r = "adload_ads";
    private final String ev = "adload_ad";
    private final String gd = "failed";

    /* renamed from: p  reason: collision with root package name */
    private final String f26919p = "ad_video_cache";

    /* renamed from: k  reason: collision with root package name */
    private boolean f26917k = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f26912a = false;
    private volatile long me = -1;

    /* renamed from: com.bytedance.msdk.adapter.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0386c {
        void c(com.bytedance.msdk.api.c cVar, xv xvVar);

        void c(ux uxVar, xv xvVar);

        void c(List<ux> list, xv xvVar);

        void m_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w implements Runnable {
        private boolean ev;

        /* renamed from: f  reason: collision with root package name */
        private String f26934f;

        /* renamed from: r  reason: collision with root package name */
        private long f26935r;
        private List<ux> sr;
        private com.bytedance.msdk.api.c ux;

        /* renamed from: w  reason: collision with root package name */
        private String f26936w;
        private ux xv;

        w(String str, ux uxVar, List<ux> list, com.bytedance.msdk.api.c cVar, String str2, long j4, boolean z3) {
            this.f26936w = str;
            this.xv = uxVar;
            this.sr = list;
            this.ux = cVar;
            this.f26934f = str2;
            this.f26935r = j4;
            this.ev = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            String str3;
            String str4;
            if (c.this.bk != null) {
                xv xvVar = new xv();
                xvVar.w(c.this.xv.fz()).c(c.this.ux).xv(c.this.ck).sr(c.this.ys).ux(c.this.fp).w(c.this.getAdNetWorkName()).c(c.this.getCustomAdNetWorkName()).xv(c.this.f26927z);
                if (!"adload_ads".equals(this.f26936w) && !"adload_ad".equals(this.f26936w)) {
                    if ("failed".equals(this.f26936w)) {
                        ux uxVar = this.xv;
                        if (uxVar != null) {
                            String valueOf = String.valueOf(uxVar.getCpm());
                            str2 = this.xv.getLevelTag();
                            str = valueOf;
                        } else {
                            str = null;
                            str2 = null;
                        }
                        if (c.this.ck != 2 && this.ev) {
                            com.bytedance.msdk.api.c cVar = this.ux;
                            c cVar2 = c.this;
                            str3 = "TTMediationSDK";
                            r.c(cVar, cVar2.xv, cVar2.f26925w, cVar2.f26920q, c.this.f26916j, c.this.ls, c.this.getSdkVersion(), c.this.f26915i, str, str2, this.f26934f, this.f26935r);
                        } else {
                            str3 = "TTMediationSDK";
                            com.bytedance.msdk.api.c cVar3 = this.ux;
                            c cVar4 = c.this;
                            r.c(cVar3, cVar4.xv, cVar4.f26925w, cVar4.f26920q, c.this.f26916j, c.this.ls, c.this.getSdkVersion(), c.this.f26915i);
                        }
                        if (this.ux != null) {
                            if (sr.f27666w) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(com.bytedance.msdk.adapter.sr.ux.c(c.this.f26923t, TTLogUtil.TAG_EVENT_FILL_FAIL));
                                sb.append("AdNetWorkName[");
                                sb.append(c.this.getAllAdNetWorkName());
                                sb.append("] AdUnitId[");
                                sb.append(c.this.f26927z);
                                sb.append("] AdType[");
                                c cVar5 = c.this;
                                com.bytedance.msdk.api.c.w wVar = cVar5.xv;
                                String adNetWorkName = cVar5.getAdNetWorkName();
                                int fz = c.this.xv.fz();
                                c cVar6 = c.this;
                                sb.append(cVar5.c(wVar, adNetWorkName, com.bytedance.msdk.c.c.c(fz, cVar6.ux, cVar6.f26925w)));
                                sb.append("] \u8bf7\u6c42\u5931\u8d25 (loadSort=");
                                sb.append(c.this.ys);
                                sb.append(",showSort=");
                                sb.append(c.this.fp);
                                sb.append("),error=");
                                sb.append(this.ux.xv);
                                sb.append(",msg=");
                                sb.append(this.ux.sr);
                                str4 = str3;
                                com.bytedance.msdk.adapter.sr.xv.sr(str4, sb.toString());
                            } else {
                                str4 = str3;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(com.bytedance.msdk.adapter.sr.ux.c(c.this.f26923t, TTLogUtil.TAG_EVENT_FILL_FAIL));
                                sb2.append("AdNetWorkName[");
                                sb2.append(c.this.getAllAdNetWorkName());
                                sb2.append("] AdType[");
                                c cVar7 = c.this;
                                com.bytedance.msdk.api.c.w wVar2 = cVar7.xv;
                                String adNetWorkName2 = cVar7.getAdNetWorkName();
                                int fz2 = c.this.xv.fz();
                                c cVar8 = c.this;
                                sb2.append(cVar7.c(wVar2, adNetWorkName2, com.bytedance.msdk.c.c.c(fz2, cVar8.ux, cVar8.f26925w)));
                                sb2.append("] \u8bf7\u6c42\u5931\u8d25 error=");
                                sb2.append(this.ux.xv);
                                sb2.append(",msg=");
                                sb2.append(this.ux.sr);
                                com.bytedance.msdk.adapter.sr.xv.sr(str4, sb2.toString());
                            }
                            if (c.this.f26925w != null) {
                                String str5 = this.ux.xv + "";
                                String c4 = c.this.c(this.ux.sr);
                                com.bytedance.msdk.adapter.sr.xv.sr(str4, "errorCode = " + str5 + " errorCodeList = " + c4);
                                com.bytedance.msdk.core.gd.xv c5 = com.bytedance.msdk.core.gd.xv.c();
                                String t3 = c.this.f26925w.t();
                                String ia = c.this.f26925w.ia();
                                c cVar9 = c.this;
                                c5.c(t3, ia, cVar9.c(cVar9.f26925w.t(), str5, c4));
                            }
                        }
                        if (c.this.bk != null) {
                            c.this.bk.c(this.ux, xvVar);
                            return;
                        }
                        return;
                    } else if ("ad_video_cache".equals(this.f26936w)) {
                        if (this.xv != null && (c.this.ba == 10 || c.this.ba == 8 || c.this.ba == 7)) {
                            c.this.w(this.xv);
                            com.bytedance.msdk.api.c cVar10 = this.ux;
                            if (cVar10 != null && cVar10.f27444c == 30010 && c.this.c()) {
                                f.c(new Runnable() { // from class: com.bytedance.msdk.adapter.c.w.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        w.this.xv.setCacheSuccess(true);
                                        w wVar3 = w.this;
                                        c.this.c(wVar3.xv);
                                        if (c.this.isServerBidding()) {
                                            ux uxVar2 = w.this.xv;
                                            c cVar11 = c.this;
                                            r.c(uxVar2, cVar11.xv, cVar11.f26925w);
                                        }
                                        if (c.this.bk != null) {
                                            c.this.bk.m_();
                                        }
                                    }
                                }, 1000L);
                                return;
                            }
                            this.xv.setCacheSuccess(true);
                            c.this.c(this.xv);
                            if (c.this.isServerBidding()) {
                                ux uxVar2 = this.xv;
                                c cVar11 = c.this;
                                r.c(uxVar2, cVar11.xv, cVar11.f26925w);
                            }
                            if (c.this.bk != null) {
                                c.this.bk.m_();
                                return;
                            }
                            return;
                        }
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(c.this.f26923t, TTLogUtil.TAG_EVENT_FILL) + "onAdVideoCache-----ttAd=" + this.xv);
                        return;
                    } else {
                        return;
                    }
                }
                if ("adload_ads".equals(this.f26936w)) {
                    List<ux> list = this.sr;
                    int size = list != null ? list.size() : 0;
                    List<ux> list2 = this.sr;
                    int i4 = (list2 == null || list2.size() <= 0) ? 820001 : 20000;
                    ux uxVar3 = null;
                    for (ux uxVar4 : this.sr) {
                        if (uxVar4 != null) {
                            c.this.w(uxVar4);
                            if (uxVar3 == null) {
                                uxVar3 = uxVar4;
                            }
                        }
                    }
                    if (!c.this.isClientBidding() && !c.this.isMultiBidding() && !c.this.isServerBidding()) {
                        c.this.c(i4, uxVar3, size, this.f26934f, this.f26935r);
                    } else {
                        for (ux uxVar5 : this.sr) {
                            if (uxVar5 != null) {
                                c.this.c(i4, uxVar5, 1, this.f26934f, this.f26935r);
                            }
                        }
                    }
                    if (c.this.isServerBidding() && !yu.w(this.sr)) {
                        c cVar12 = c.this;
                        r.c(this.sr.get(0), cVar12.xv, cVar12.f26925w, cVar12.f26915i);
                    }
                    if (c.this.bk != null) {
                        c.this.bk.c(this.sr, xvVar);
                        com.bytedance.msdk.core.xv.xv.xv(c.this.getAdnName(), c.this.getAdapterRit(), c.this.getAdSlotId());
                        return;
                    }
                    return;
                }
                ux uxVar6 = this.xv;
                int i5 = uxVar6 != null ? 20000 : 820001;
                c.this.w(uxVar6);
                c.this.c(i5, this.xv, 1, this.f26934f, this.f26935r);
                if (c.this.isServerBidding()) {
                    ux uxVar7 = this.xv;
                    c cVar13 = c.this;
                    r.c(uxVar7, cVar13.xv, cVar13.f26925w, cVar13.f26915i);
                }
                if (c.this.bk != null) {
                    c.this.bk.c(this.xv, xvVar);
                    com.bytedance.msdk.core.xv.xv.xv(c.this.getAdnName(), c.this.getAdapterRit(), c.this.getAdSlotId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(com.bytedance.msdk.api.c.w wVar, String str, String str2) {
        return wVar == null ? "" : str2;
    }

    public abstract void destroy();

    public com.bytedance.msdk.api.c.w getAdLinkInfo() {
        return this.xv;
    }

    public final int getAdLoadCount() {
        return this.f26918n;
    }

    public abstract String getAdNetWorkName();

    public final String getAdSlotId() {
        return this.f26927z;
    }

    public String getAdapterRit() {
        return this.f26923t;
    }

    public final String getAdm() {
        ev evVar;
        return (isServerBidding() && (evVar = this.gb) != null) ? evVar.p() : "";
    }

    public String getAdnName() {
        p pVar = this.f26925w;
        return pVar != null ? pVar.fp() : "";
    }

    public String getAllAdNetWorkName() {
        if (this.f26925w != null) {
            if (com.bytedance.msdk.core.c.w().xv(this.f26925w.t())) {
                return this.f26925w.ys() + "_" + this.f26925w.t();
            }
            return getAdNetWorkName();
        }
        return getAdNetWorkName();
    }

    public int getBehaviorTTL() {
        com.bytedance.msdk.api.c.w wVar = this.xv;
        if (wVar != null) {
            return wVar.gb();
        }
        return 0;
    }

    public String getBiddingToken(Context context, String str, com.bytedance.msdk.api.c.w wVar) {
        return null;
    }

    public String getClientReqId() {
        String str = !TextUtils.isEmpty(this.f26922s) ? this.f26922s : null;
        if (TextUtils.isEmpty(this.f26927z)) {
            return str;
        }
        return (str + "_") + this.f26927z;
    }

    public String getCustomAdNetWorkName() {
        if (this.f26925w == null || !com.bytedance.msdk.core.c.w().xv(this.f26925w.t())) {
            return null;
        }
        return this.f26925w.ys();
    }

    public final Object getExtraDataNoParse() {
        ev evVar;
        if (isServerBidding() && (evVar = this.gb) != null) {
            return evVar.w();
        }
        return null;
    }

    public int getIfTest() {
        gd gdVar = this.sr;
        if (gdVar != null) {
            return gdVar.f28035w;
        }
        return 0;
    }

    public wv getPluginCSJLoader(Context context) {
        Loader csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader instanceof wv) {
            return (wv) csjLoader;
        }
        if (csjLoader == null) {
            notifyAdFailed(new com.bytedance.msdk.api.c("ClassCastException\uff1aload ad fail loader is null"));
        } else {
            notifyAdFailed(new com.bytedance.msdk.api.c("ClassCastException\uff1aload ad fail loader is not TTAdNativeImpl"));
        }
        return null;
    }

    public int getReqBiddingType() {
        return this.ck;
    }

    public abstract String getSdkVersion();

    public p getWaterFallConfig() {
        return this.f26925w;
    }

    public int getmSubAdType() {
        return this.ux;
    }

    public boolean hasNotifyFail() {
        return this.f26912a;
    }

    public boolean hasNotifySuccess() {
        return this.f26917k;
    }

    public boolean isClientBidding() {
        return this.ck == 1;
    }

    public boolean isMultiBidding() {
        return this.ck == 3;
    }

    public boolean isServerBidding() {
        return this.ck == 2;
    }

    public abstract void loadAd(Context context, Map<String, Object> map);

    public final void loadAdInter(@NonNull final Context context, @NonNull p pVar, @NonNull final Map<String, Object> map, @NonNull com.bytedance.msdk.api.c.w wVar, gd gdVar, int i4) {
        this.f26917k = false;
        this.f26912a = false;
        this.f26925w = pVar;
        this.f26923t = wVar.u();
        this.f26918n = wVar.ls();
        this.f26922s = wVar.c();
        this.ba = wVar.fz();
        this.ux = pVar.ux();
        this.ys = pVar.j();
        this.fp = pVar.ls();
        this.f26927z = pVar.ia();
        this.gb = pVar.ck();
        this.fz = pVar.bk();
        this.xv = wVar;
        this.sr = gdVar;
        this.ck = pVar.s();
        this.f26913c = pVar.gb();
        this.f26920q = i4;
        Object obj = map.get("key_mediation_rit_req_type");
        this.f26916j = obj != null ? ((Integer) obj).intValue() : 1;
        Object obj2 = map.get("key_mediation_rit_req_type_src");
        this.ls = obj2 != null ? ((Integer) obj2).intValue() : 1;
        Object obj3 = map.get("key_is_from_developer_req");
        this.f26926y = obj3 != null && ((Boolean) obj3).booleanValue();
        Object obj4 = map.get("key_requestwfb_ms");
        long longValue = obj4 instanceof Long ? ((Long) obj4).longValue() : -1L;
        Object obj5 = map.get("const_is_custom");
        boolean z3 = obj5 != null && ((Boolean) obj5).booleanValue();
        if (!pVar.ba()) {
            this.eq = this.f26916j == 4 ? 3 : 0;
            String sdkVersion = getSdkVersion();
            boolean z4 = this.f26926y;
            int i5 = this.eq;
            int i6 = this.f26916j;
            int i7 = this.ls;
            gd gdVar2 = this.sr;
            r.c(pVar, wVar, sdkVersion, z4, i5, i4, i6, i7, (com.bytedance.msdk.api.c) null, longValue, gdVar2 != null ? gdVar2.ux : false, false);
        }
        if (!isServerBidding() && !isClientBidding() && !isMultiBidding()) {
            this.ia = pVar.q();
        } else {
            this.ia = 0.0d;
        }
        this.f26924u = System.currentTimeMillis();
        if (!z3) {
            com.bytedance.msdk.core.ux.c.c.c().sr(pVar.ia(), getSdkVersion());
        }
        if (!TextUtils.equals("mintegral", pVar.t()) && !TextUtils.equals("baidu", pVar.t()) && !TextUtils.equals("admob", pVar.t())) {
            c(context, map, "\u5b50\u7ebf\u7a0bADN\u8bf7\u6c42\u5e7f\u544a\u5d29\u6e83");
        } else {
            f.xv(new Runnable() { // from class: com.bytedance.msdk.adapter.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(context, map, "\u4e3b\u7ebf\u7a0bADN\u8bf7\u6c42\u5e7f\u544a\u5d29\u6e83");
                }
            });
        }
        com.bytedance.msdk.core.xv.xv.w(getAdnName(), getAdapterRit(), getAdSlotId());
    }

    public final void nativeDislikeClick(ux uxVar, String str, Map<String, Object> map) {
        if (uxVar == null || uxVar.getAdType() != 5) {
            return;
        }
        r.c(uxVar, this.xv, str);
    }

    public final void notifyAdFailed(com.bytedance.msdk.api.c cVar) {
        c((ux) null, cVar, true);
    }

    public final void notifyAdLoaded(com.bytedance.msdk.api.sr.c.w.w.c cVar) {
        notifyAdLoaded(cVar.p());
    }

    public final void notifyAdLoadedCustom(List<? extends com.bytedance.msdk.api.sr.c.w.w.c> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (com.bytedance.msdk.api.sr.c.w.w.c cVar : list) {
                arrayList.add(cVar.p());
            }
            notifyAdLoaded(arrayList);
        }
    }

    public final void notifyAdVideoCache(com.bytedance.msdk.api.sr.c.w.w.c cVar, com.bytedance.msdk.api.c cVar2) {
        notifyAdVideoCache(cVar.p(), cVar2);
    }

    public void removeFromParent(View view) {
        com.bytedance.msdk.api.ux.c(view);
    }

    public final void setAdapterListener(InterfaceC0386c interfaceC0386c) {
        this.bk = interfaceC0386c;
    }

    public final void notifyAdLoaded(ux uxVar) {
        int i4;
        if (this.me == -1) {
            this.me = SystemClock.elapsedRealtime();
        }
        if (uxVar != null) {
            uxVar.setAdNetworkSlotType(this.ck);
            uxVar.setExchangeRate(this.fz);
            uxVar.setFillTime(SystemClock.elapsedRealtime());
            wx.c(uxVar, this.f26925w, this.xv, true);
            com.bytedance.msdk.api.c.w wVar = this.xv;
            if (wVar != null && ((i4 = this.ck) == 1 || i4 == 3)) {
                double m4 = wVar.m();
                if (m4 > 0.0d && m4 > uxVar.getCpm()) {
                    c(uxVar, new com.bytedance.msdk.api.c(50100, com.bytedance.msdk.api.c.c(50100)), true);
                    return;
                }
            }
        }
        if (this.f26917k) {
            return;
        }
        this.f26917k = true;
        this.f26915i = System.currentTimeMillis() - this.f26924u;
        c("adload_ad", uxVar, (List<ux>) null, (com.bytedance.msdk.api.c) null, true);
        p pVar = this.f26925w;
        if (pVar != null && pVar.a() == 10 && this.ux == 1) {
            notifyAdVideoCache(uxVar, (com.bytedance.msdk.api.c) null);
        }
    }

    public final void notifyAdVideoCache(ux uxVar, com.bytedance.msdk.api.c cVar) {
        if (this.f26912a) {
            return;
        }
        c("ad_video_cache", uxVar, (List<ux>) null, cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ux uxVar) {
        p pVar;
        if (uxVar == null) {
            return;
        }
        int i4 = this.ck;
        if (i4 == 0 || i4 == 100) {
            double d4 = this.ia;
            if (d4 != 0.0d) {
                uxVar.setCpm(d4);
            }
        }
        if (isServerBidding() && (pVar = this.f26925w) != null) {
            uxVar.setServerBiddingShowCpm(pVar.u());
            uxVar.setServerBiddingLoadCpm(this.f26925w.i());
            if (this.f26925w.ck() != null) {
                uxVar.setAid(this.f26925w.ck().xv());
                uxVar.setAdExtra(this.f26925w.ck().sr());
                uxVar.setWinCallback(this.f26925w.ck().ev());
                uxVar.setFailCallback(this.f26925w.ck().gd());
                uxVar.setPricingType(this.f26925w.ck().c());
            }
        }
        uxVar.setAdNetworkSlotType(this.ck);
        uxVar.setLoadSort(this.ys);
        uxVar.setShowSort(this.fp);
        uxVar.setSdkVersion(getSdkVersion());
        p pVar2 = this.f26925w;
        uxVar.setAdNetWorkName(pVar2 != null ? pVar2.t() : getAdNetWorkName());
        p pVar3 = this.f26925w;
        uxVar.setCustomAdNetWorkName(pVar3 != null ? pVar3.ys() : null);
        uxVar.setExchangeRate(this.fz);
        uxVar.setAdNetworkSlotId(this.f26927z);
        uxVar.setRit(this.f26923t);
        uxVar.putEventParam("waterfall_abtest", this.f26913c);
        uxVar.setSdkNum(com.bytedance.msdk.c.c.w(getAdNetWorkName()));
        uxVar.setMediationRitReqTypeFromRealReq(this.f26916j);
        uxVar.setMediationRitReqTypeSrcFromRealReq(this.ls);
        uxVar.setLinkIdFromRealReq(this.f26922s);
        uxVar.setMediationRitReqType(this.f26916j);
        uxVar.setMediationRitReqTypeSrc(this.ls);
        p pVar4 = this.f26925w;
        uxVar.setOriginType(pVar4 != null ? pVar4.gd() : -1);
        uxVar.setSubAdType(this.ux);
        uxVar.setAdType(this.ba);
        p pVar5 = this.f26925w;
        uxVar.setIfReuseAds(pVar5 != null ? pVar5.ev() : 0);
        wx.c(uxVar, this.f26925w, this.xv, false);
        gd gdVar = this.sr;
        if (gdVar != null) {
            int i5 = gdVar.f28035w;
            uxVar.putEventParam("if_test", Integer.valueOf(i5 == 1 ? i5 : 0));
            uxVar.putEventParam("server_bidding_extra", this.sr.f28033c);
            com.bytedance.msdk.api.c.w wVar = this.xv;
            int mediationRitReqType = uxVar.getMediationRitReqType(wVar != null ? wVar.c() : null);
            if (mediationRitReqType == 1 || mediationRitReqType == 2) {
                uxVar.setTimeoutFill(this.sr.ux);
            }
        }
        ev evVar = this.gb;
        if (evVar == null || evVar.w() == null) {
            return;
        }
        uxVar.putExtraMsg("extra_data_and_no_parse", this.gb.w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Map<String, Object> map, String str) {
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.f26923t, "request") + "AdNetWorkName[" + getAllAdNetWorkName() + "] AdUnitId[" + this.f26927z + "] + AdType[" + com.bytedance.msdk.c.c.c(this.xv.fz(), this.ux, this.f26925w) + "] \u5f00\u59cbadn\u8bf7\u6c42");
        if (com.bytedance.msdk.core.w.k().n()) {
            if (map == null) {
                map = new HashMap<>();
            }
            loadAd(context, map);
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                notifyAdFailed(new com.bytedance.msdk.api.c(str));
                th.printStackTrace();
                return;
            }
        }
        loadAd(context, map);
    }

    private final void c(ux uxVar, com.bytedance.msdk.api.c cVar, boolean z3) {
        this.f26912a = true;
        if (this.f26917k) {
            return;
        }
        this.f26917k = true;
        this.f26915i = System.currentTimeMillis() - this.f26924u;
        c("failed", uxVar, (List<ux>) null, cVar, z3);
    }

    public final void notifyAdLoaded(List<ux> list) {
        int i4;
        int i5;
        long j4;
        String str;
        if (this.me == -1) {
            this.me = SystemClock.elapsedRealtime();
        }
        if (list != null) {
            for (ux uxVar : list) {
                if (uxVar != null) {
                    uxVar.setFillTime(SystemClock.elapsedRealtime());
                }
            }
        }
        List<ux> arrayList = new ArrayList<>();
        if (!yu.c(list)) {
            arrayList.addAll(list);
        }
        if (!yu.w(list) && ((i4 = this.ck) == 1 || i4 == 3)) {
            for (ux uxVar2 : list) {
                uxVar2.setAdNetworkSlotType(this.ck);
                uxVar2.setExchangeRate(this.fz);
                wx.c(uxVar2, this.f26925w, this.xv, true);
                com.bytedance.msdk.api.c.w wVar = this.xv;
                if (wVar != null && ((i5 = this.ck) == 1 || i5 == 3)) {
                    double m4 = wVar.m();
                    if (m4 > 0.0d && m4 > uxVar2.getCpm()) {
                        arrayList.remove(uxVar2);
                        String valueOf = String.valueOf(uxVar2.getCpm());
                        String levelTag = uxVar2.getLevelTag();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (i.c(this.f26925w)) {
                            str = i.w(Thread.currentThread().getStackTrace());
                            j4 = System.currentTimeMillis() - currentTimeMillis;
                        } else {
                            j4 = -1;
                            str = null;
                        }
                        r.c(new com.bytedance.msdk.api.c(50100, com.bytedance.msdk.api.c.c(50100)), this.xv, this.f26925w, this.f26920q, this.f26916j, this.ls, getSdkVersion(), this.f26915i, valueOf, levelTag, str, j4);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                c((ux) null, new com.bytedance.msdk.api.c(50100, com.bytedance.msdk.api.c.c(50100)), false);
                return;
            }
        }
        if (this.f26917k) {
            return;
        }
        this.f26917k = true;
        this.f26915i = System.currentTimeMillis() - this.f26924u;
        c("adload_ads", (ux) null, arrayList, (com.bytedance.msdk.api.c) null, true);
    }

    private void c(String str, ux uxVar, List<ux> list, com.bytedance.msdk.api.c cVar, boolean z3) {
        String str2;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.f26925w)) {
            str2 = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str2 = null;
            j4 = -1;
        }
        f.c(new w(str, uxVar, list, cVar, str2, j4, z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && str.equals("gdt")) {
            return str2 + "_" + str3;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
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
    public void c(int i4, ux uxVar, int i5, String str, long j4) {
        String str2 = i4 == 20000 ? AdError.AD_LOAD_SUCCESS_MSG : "\u8bf7\u6c42\u6210\u529f\uff0c\u4f46\u65e0\u5e7f\u544a\u53ef\u7528";
        gd gdVar = this.sr;
        int i6 = (gdVar == null || !gdVar.f28034f) ? 0 : 1;
        if (this.ck != 2 && uxVar != null) {
            r.c(uxVar, i4, str2, this.f26915i, this.xv, this.f26920q, i5, i6, str, j4, this.me != -1 ? SystemClock.elapsedRealtime() - this.me : -1L);
        }
        if (sr.f27666w) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.f26923t, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAllAdNetWorkName() + "] AdUnitId[" + this.f26927z + "] AdType[" + c(this.xv, getAdNetWorkName(), com.bytedance.msdk.c.c.c(this.xv.fz(), this.ux, this.f26925w)) + "] \u8bf7\u6c42\u6210\u529f (loadSort=" + this.ys + ",showSort=" + this.fp + ")");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.f26923t, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAllAdNetWorkName() + "] AdType[" + c(this.xv, getAdNetWorkName(), com.bytedance.msdk.c.c.c(this.xv.fz(), this.ux, this.f26925w)) + "] \u8bf7\u6c42\u6210\u529f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ux uxVar) {
        if (this.ck != 2 && uxVar != null) {
            r.c(this.xv, uxVar, this.f26925w);
        }
        if (sr.f27666w) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.f26923t, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAllAdNetWorkName() + "] AdUnitId[" + this.f26927z + "] AdType[" + com.bytedance.msdk.c.c.c(this.xv.fz(), this.ux, this.f26925w) + "] \u89c6\u9891\u7f13\u5b58\u6210\u529f (loadSort=" + this.ys + ",showSort=" + this.fp + ")");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.f26923t, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + getAllAdNetWorkName() + "] AdType[" + com.bytedance.msdk.c.c.c(this.xv.fz(), this.ux, this.f26925w) + "] \u89c6\u9891\u7f13\u5b58\u6210\u529f ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return com.bytedance.msdk.core.c.w().ev() && (ck.ux(com.bytedance.msdk.core.c.getContext()) || ck.sr(com.bytedance.msdk.core.c.getContext()));
    }
}
