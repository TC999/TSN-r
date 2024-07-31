package com.bytedance.msdk.core.corelogic;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.SdkSettingsHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.BiddingModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.BiddingRequestModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.BiddingUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTBiddingFactory;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.TTExtraModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.msdk.core.corelogic.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTADBidingRequestCore {

    /* renamed from: d */
    protected AdsenseRitConfig f21791d;

    /* renamed from: e */
    protected Map<Integer, List<WaterFallConfig>> f21792e;

    /* renamed from: f */
    protected String f21793f;

    /* renamed from: g */
    protected Handler f21794g;

    /* renamed from: h */
    protected AdSlot f21795h;

    /* renamed from: i */
    protected double f21796i;

    /* renamed from: j */
    protected int f21797j;

    /* renamed from: m */
    protected List<Integer> f21800m;

    /* renamed from: s */
    protected int f21806s;

    /* renamed from: a */
    protected final AtomicBoolean f21788a = new AtomicBoolean(false);

    /* renamed from: b */
    protected final AtomicBoolean f21789b = new AtomicBoolean(false);

    /* renamed from: c */
    protected final AtomicBoolean f21790c = new AtomicBoolean(false);

    /* renamed from: k */
    private int f21798k = 0;

    /* renamed from: l */
    private final List<WaterFallConfig> f21799l = new CopyOnWriteArrayList();

    /* renamed from: n */
    protected List<TTBaseAd> f21801n = new CopyOnWriteArrayList();

    /* renamed from: o */
    protected List<TTBaseAd> f21802o = new CopyOnWriteArrayList();

    /* renamed from: p */
    protected List<TTBaseAd> f21803p = new CopyOnWriteArrayList();

    /* renamed from: q */
    protected Map<String, Object> f21804q = new HashMap();

    /* renamed from: r */
    protected TTRequestLoadingStatus f21805r = new TTRequestLoadingStatus();

    /* renamed from: t */
    protected AtomicBoolean f21807t = new AtomicBoolean(false);

    /* renamed from: u */
    protected TTExtraModel f21808u = new TTExtraModel();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTADBidingRequestCore.java */
    /* renamed from: com.bytedance.msdk.core.corelogic.d$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6045a implements ITTBiddingCore.InterfaceC0963b {
        C6045a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore.InterfaceC0963b
        /* renamed from: a */
        public void mo37333a(WaterFallConfig waterFallConfig) {
            TTADBidingRequestCore.this.m37360a(waterFallConfig);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore.InterfaceC0962a
        /* renamed from: a */
        public void mo37332a(BiddingModel biddingModel) {
            TTADBidingRequestCore.this.f21792e = biddingModel.f431a;
        }
    }

    /* compiled from: TTADBidingRequestCore.java */
    /* renamed from: com.bytedance.msdk.core.corelogic.d$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6046b implements ITTBiddingCore.InterfaceC0962a {
        C6046b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore.InterfaceC0962a
        /* renamed from: a */
        public void mo37332a(BiddingModel biddingModel) {
            List<TTBaseAd> list;
            List<TTBaseAd> list2;
            if (biddingModel != null && !TTCollectionUtils.m59112a(biddingModel.f432b)) {
                TTADBidingRequestCore.this.f21798k = 1;
                if (TTADBidingRequestCore.this.f21788a.get() || TTADBidingRequestCore.this.f21789b.get()) {
                    return;
                }
                Handler handler = TTADBidingRequestCore.this.f21794g;
                if (handler != null) {
                    handler.removeMessages(1);
                    TTADBidingRequestCore.this.f21794g.removeMessages(3);
                }
                TTADBidingRequestCore.this.f21799l.clear();
                TTADBidingRequestCore.this.f21799l.addAll(biddingModel.f432b);
                TTADBidingRequestCore tTADBidingRequestCore = TTADBidingRequestCore.this;
                tTADBidingRequestCore.m37346b(tTADBidingRequestCore.f21799l);
                TTADBidingRequestCore.this.m37361a(0, false);
            } else {
                TTADBidingRequestCore.this.f21798k = 2;
                TTADBidingRequestCore.this.f21805r.m37300e(null);
                TTADBidingRequestCore.this.f21805r.m37301d(0, true);
                Map<Integer, List<WaterFallConfig>> map = TTADBidingRequestCore.this.f21792e;
                if (map != null && map.size() > 1) {
                    if (TTADBidingRequestCore.this.f21805r.m37284u()) {
                        List<TTBaseAd> list3 = TTADBidingRequestCore.this.f21803p;
                        if ((list3 != null && list3.size() > 0) || (((list = TTADBidingRequestCore.this.f21801n) != null && list.size() > 0) || ((list2 = TTADBidingRequestCore.this.f21802o) != null && list2.size() > 0))) {
                            TTADBidingRequestCore.this.mo37342f();
                        } else {
                            TTADBidingRequestCore.this.mo37359a(new AdError(20005, AdError.getMessage(20005)), (ExtraParam) null);
                        }
                    }
                } else {
                    TTADBidingRequestCore.this.mo37359a(new AdError(20005, AdError.getMessage(20005)), (ExtraParam) null);
                }
            }
            if (biddingModel != null && biddingModel.f433c) {
                SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59779d().m59781c();
            }
            if (TTADBidingRequestCore.this.f21808u == null || biddingModel == null || TextUtils.isEmpty(biddingModel.f434d)) {
                return;
            }
            TTADBidingRequestCore.this.f21808u.f538a = biddingModel.f434d;
        }
    }

    /* renamed from: a */
    private void m37352a(List<WaterFallConfig> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (TTBaseAd tTBaseAd : this.f21801n) {
            boolean z = true;
            Iterator<WaterFallConfig> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WaterFallConfig next = it.next();
                if (tTBaseAd != null && next != null && tTBaseAd.getAdNetworkSlotId().equals(next.m59480c())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "已经响应的广告: " + tTBaseAd.getAdNetworkSlotId() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                this.f21801n.remove(tTBaseAd);
            }
        }
        Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "已经响应的广告被serverBidding过滤完还剩: " + this.f21801n.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m37346b(List<WaterFallConfig> list) {
        Map<Integer, List<WaterFallConfig>> m59650a;
        if (list == null || list.size() == 0 || (m59650a = BiddingUtil.m59650a(list)) == null || m59650a.size() == 0) {
            return;
        }
        this.f21792e = m59650a;
        ArrayList arrayList = new ArrayList();
        this.f21800m = arrayList;
        arrayList.addAll(this.f21792e.keySet());
        SortAlgorithm.m37364a(this.f21800m);
        this.f21805r.m37295j(this.f21800m);
        this.f21805r.m37292m(list);
        m37352a(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public int m37363a() {
        TTExtraModel tTExtraModel = this.f21808u;
        if (tTExtraModel != null) {
            return tTExtraModel.f539b;
        }
        return 0;
    }

    /* renamed from: a */
    abstract void m37361a(int i, boolean z);

    /* renamed from: a */
    protected void m37360a(WaterFallConfig waterFallConfig) {
        this.f21805r.m37300e(waterFallConfig.m59480c());
        if (this.f21792e.get(Integer.valueOf(waterFallConfig.m59459l())) == null || this.f21792e.get(Integer.valueOf(waterFallConfig.m59459l())).size() != 0) {
            return;
        }
        this.f21805r.m37301d(waterFallConfig.m59459l(), true);
    }

    /* renamed from: a */
    abstract void mo37359a(AdError adError, ExtraParam extraParam);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m37358a(AdSlot adSlot, List<WaterFallConfig> list) {
        ITTBiddingCore m59648b = TTBiddingFactory.m59648b();
        if (m59648b == null) {
            return;
        }
        BiddingRequestModel biddingRequestModel = new BiddingRequestModel();
        biddingRequestModel.f437c = adSlot;
        biddingRequestModel.f438d = list;
        biddingRequestModel.f439e = this.f21791d;
        biddingRequestModel.f440f = adSlot == null ? 1 : adSlot.getPrimeRitReqType();
        m59648b.mo59647a(biddingRequestModel, new C6046b());
        char c = '(';
        while (true) {
            if (c != '(' && c == ')') {
                return;
            }
            c = ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m37351a(List<TTBaseAd> list, TTBaseAd tTBaseAd) {
        TTBaseAd tTBaseAd2;
        this.f21805r.m37304a();
        int i = this.f21806s;
        boolean z = false;
        boolean z2 = true;
        if (i == 1) {
            if (this.f21802o.size() > 0 && (tTBaseAd2 = this.f21802o.get(0)) != null && tTBaseAd2.getCpm() <= tTBaseAd.getCpm()) {
                z = (tTBaseAd2.getCpm() == tTBaseAd.getCpm() && tTBaseAd2.getAdNetworkPlatformId() == 1) ? true : true;
                if (z) {
                    this.f21802o.clear();
                }
                z2 = z;
            }
            if (z2) {
                this.f21802o.addAll(list);
            }
        } else if (i > 1) {
            this.f21802o.addAll(list);
            TTLoaderUtil.m37314i(this.f21802o, TTLoaderUtil.m37307p());
            int size = this.f21802o.size();
            int i2 = this.f21806s;
            if (size > i2) {
                this.f21802o = this.f21802o.subList(0, i2);
            }
        }
        for (TTBaseAd tTBaseAd3 : this.f21802o) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "广告加载成功...........返回了竞价层广告_当前竞价广告池数量：" + this.f21802o.size() + ",slotId：" + tTBaseAd3.getAdNetworkSlotId() + ",广告类型名称:" + C6031a.m37434d(tTBaseAd3.getAdNetworkPlatformId()) + "，cpm=" + tTBaseAd3.getCpm() + ",loadSort=" + tTBaseAd3.getLoadSort() + ",showSort=" + tTBaseAd3.getShowSort());
        }
    }

    /* renamed from: a */
    abstract void mo37350a(boolean z);

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6 A[PHI: r0 r1 r2 
      PHI: (r0v1 boolean) = (r0v0 boolean), (r0v2 boolean), (r0v2 boolean), (r0v2 boolean) binds: [B:40:0x00f2, B:43:0x00f8, B:63:0x00f6, B:61:0x00f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r1v10 char) = (r1v9 char), (r1v11 char), (r1v11 char), (r1v11 char) binds: [B:40:0x00f2, B:43:0x00f8, B:63:0x00f6, B:61:0x00f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v1 char) = (r2v0 char), (r2v2 char), (r2v3 char), (r2v5 char) binds: [B:40:0x00f2, B:43:0x00f8, B:63:0x00f6, B:61:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ee -> B:39:0x00f0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f6 -> B:43:0x00f8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0106 -> B:51:0x010a). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean m37362a(int r10) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTADBidingRequestCore.m37362a(int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[LOOP:0: B:21:0x0050->B:23:0x0050, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:17:0x004a). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m37357a(com.bytedance.msdk.base.TTBaseAd r7) {
        /*
            r6 = this;
            double r0 = r6.f21796i
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L26
            double r0 = r7.getCpm()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L26
            com.bytedance.msdk.core.corelogic.g r0 = r6.f21805r
            r0.m37281x()
            int r7 = r7.getAdNetworkPlatformId()
            if (r7 == r4) goto L20
            r6.mo37350a(r4)
            goto L4e
        L20:
            r6.mo37342f()
            r7 = 92
            goto L4a
        L26:
            double r0 = r7.getCpm()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L2f
            return r4
        L2f:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTBiddingFactory.m59649a()
            if (r0 == 0) goto L52
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b r1 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b
            r1.<init>()
            r1.f435a = r7
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> r7 = r6.f21792e
            r1.f436b = r7
            com.bytedance.msdk.core.corelogic.d$a r7 = new com.bytedance.msdk.core.corelogic.d$a
            r7.<init>()
            r0.mo59647a(r1, r7)
        L48:
            r7 = 91
        L4a:
            switch(r7) {
                case 90: goto L50;
                case 91: goto L52;
                case 92: goto L4e;
                default: goto L4d;
            }
        L4d:
            goto L48
        L4e:
            r7 = 0
            return r7
        L50:
            goto L50
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.TTADBidingRequestCore.m37357a(com.bytedance.msdk.base.TTBaseAd):boolean");
    }

    /* renamed from: a */
    public boolean m37353a(String str) {
        if (!TextUtils.isEmpty(str) && m37338j() && m37336l() && this.f21799l.size() > 0) {
            for (WaterFallConfig waterFallConfig : this.f21799l) {
                if (str.equals(waterFallConfig.m59480c())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public int mo37349b() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m37348b(int i) {
        TTExtraModel tTExtraModel = this.f21808u;
        if (tTExtraModel != null) {
            tTExtraModel.f539b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m37347b(String str) {
        TTExtraModel tTExtraModel = this.f21808u;
        if (tTExtraModel != null) {
            tTExtraModel.f540c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public String m37345c() {
        TTExtraModel tTExtraModel = this.f21808u;
        if (tTExtraModel == null) {
            return null;
        }
        return tTExtraModel.f538a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public String m37344d() {
        TTExtraModel tTExtraModel = this.f21808u;
        if (tTExtraModel != null) {
            return tTExtraModel.f540c;
        }
        return null;
    }

    /* renamed from: e */
    public String m37343e() {
        return this.f21793f;
    }

    /* renamed from: f */
    abstract void mo37342f();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public boolean m37341g() {
        return m37338j() || m37340h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public boolean m37340h() {
        return this.f21797j == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public boolean mo37339i() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public boolean m37338j() {
        return this.f21797j == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public void m37337k() {
        if (this.f21805r.m37283v()) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = 10001;
        Handler handler = this.f21794g;
        if (handler != null) {
            handler.removeMessages(1);
            this.f21794g.sendMessage(message);
        }
    }

    /* renamed from: l */
    protected boolean m37336l() {
        return this.f21798k == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public boolean m37335m() {
        return this.f21798k > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public void m37334n() {
        TTExtraModel tTExtraModel;
        if (!m37338j() || (tTExtraModel = this.f21808u) == null || TextUtils.isEmpty(tTExtraModel.f538a)) {
            return;
        }
        for (TTBaseAd tTBaseAd : this.f21803p) {
            tTBaseAd.putEventParam("server_bidding_extra", this.f21808u.f538a);
        }
        for (TTBaseAd tTBaseAd2 : this.f21802o) {
            tTBaseAd2.putEventParam("server_bidding_extra", this.f21808u.f538a);
        }
        for (TTBaseAd tTBaseAd3 : this.f21801n) {
            tTBaseAd3.putEventParam("server_bidding_extra", this.f21808u.f538a);
        }
    }
}
