package com.bytedance.msdk.core.corelogic;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TTAdHeaderBidingManagerWrapper.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class e extends TTAdHeaderBidingRequestCore {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTAdHeaderBidingManagerWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TTBaseAd f27901a;

        a(TTBaseAd tTBaseAd) {
            this.f27901a = tTBaseAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd = this.f27901a;
            if (tTBaseAd != null && tTBaseAd.adnHasAdVideoCachedApi() && this.f27901a.isCacheSuccess()) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(e.this.f27883f, this.f27901a.getAdNetworkSlotId()) + "\u5728show\u65f6\u89e6\u53d1\u4e86\u9884\u52a0\u8f7d\u3010" + this.f27901a.getAdNetWorkName() + "\u3011, loadSort: " + this.f27901a.getLoadSort() + ", showSort: " + this.f27901a.getShowSort());
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a();
                e eVar = e.this;
                a4.b(eVar.f27859z, eVar.f27883f, eVar.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTAdHeaderBidingManagerWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TTBaseAd f27903a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f27904b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f27905c;

        b(TTBaseAd tTBaseAd, Activity activity, Map map) {
            this.f27903a = tTBaseAd;
            this.f27904b = activity;
            this.f27905c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z3;
            TTBaseAd tTBaseAd = this.f27903a;
            if (tTBaseAd != null) {
                e.this.B = tTBaseAd;
                boolean z4 = true;
                tTBaseAd.setHasShown(true);
                e eVar = e.this;
                eVar.B.setTTAdatperCallback(eVar.A);
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(e.this.f27883f, "show") + "\u5c55\u793a\u7684\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(e.this.B.getAdNetworkPlatformId()) + ",slotId\uff1a" + e.this.B.getAdNetworkSlotId() + ",slotType:" + e.this.B.getAdNetworkSlotType() + ",isReady()\uff1a" + e.this.B.isReady() + "\uff0c\u662f\u5426\u4e3a\u7f13\u5b58\u5e7f\u544a:" + e.this.B.isCacheSuccess());
                e.this.B.showAd(this.f27904b, this.f27905c);
                if (e.this.j()) {
                    e eVar2 = e.this;
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.c(eVar2.B, eVar2.f27885h);
                }
                i b4 = i.b();
                b4.a(e.this.f27883f + "");
                i b5 = i.b();
                b5.j(e.this.f27883f + "");
                e eVar3 = e.this;
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.e(eVar3.B, eVar3.f27885h);
                e.this.F.set(true);
                if (this.f27903a.getAdType() == 8 || this.f27903a.getAdType() == 7) {
                    if (this.f27903a.adnHasAdVideoCachedApi() && this.f27903a.isCacheSuccess()) {
                        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a();
                        e eVar4 = e.this;
                        if (a4.c(eVar4.f27883f, eVar4.a()) != 0) {
                            z4 = false;
                        }
                    }
                    z3 = this.f27903a.getAdNetworkPlatformId() == 4 ? false : z4;
                } else {
                    z3 = true;
                }
                if (this.f27903a.isServerBiddingAd() || !bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f27903a.getAdNetworkSlotId(), e.this.a())) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a();
                String adNetworkSlotId = e.this.B.getAdNetworkSlotId();
                e eVar5 = e.this;
                a5.a(adNetworkSlotId, eVar5.f27885h, eVar5.f27894q, z3, eVar5.G, eVar5.f27898u, eVar5.f27859z);
            }
        }
    }

    /* compiled from: TTAdHeaderBidingManagerWrapper.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, String str) {
        super(context, str);
    }

    private boolean B() {
        boolean e4 = n.e(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
        boolean f4 = n.f(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
        Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "setting \u4e0b\u53d1\u662f\u5426\u4e3a\u5f31\u7f51\u6267\u884c\uff1a" + bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().A() + "\uff0c\u5f53\u524d\u7f51\u7edc\u73af\u5883\uff1a2G-type=" + e4 + ",3G-type=" + f4);
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().A() && (e4 || f4);
    }

    private List<TTBaseAd> C() {
        List<TTBaseAd> list;
        while (true) {
            char c4 = 'X';
            char c5 = '\uffd6';
            while (true) {
                switch (c4) {
                    case 'W':
                        c4 = 'Y';
                        c5 = 31;
                    case 'X':
                        c4 = 'Y';
                        c5 = 31;
                    case 'Y':
                        while (true) {
                            switch (c5) {
                                case 29:
                                    break;
                                case 30:
                                    break;
                                case 31:
                                    ArrayList arrayList = new ArrayList();
                                    if (!u.a(this.f27892o) || !u.a(this.f27891n)) {
                                        if (!u.a(this.f27892o) && u.a(this.f27891n)) {
                                            list = this.f27892o;
                                        } else if (u.a(this.f27891n) || !u.a(this.f27892o)) {
                                            arrayList.addAll(this.f27891n);
                                            arrayList.addAll(this.f27892o);
                                            if (h()) {
                                                Collections.sort(arrayList, f.p());
                                            }
                                        } else {
                                            list = this.f27891n;
                                        }
                                        arrayList.addAll(list);
                                    }
                                    if (!u.a(this.f27893p)) {
                                        arrayList.addAll(0, this.f27893p);
                                    }
                                    return arrayList;
                                default:
                                    c5 = 29;
                            }
                        }
                        c4 = 'Y';
                        c5 = 31;
                        break;
                    default:
                        c4 = 'W';
                }
            }
        }
    }

    private void a(TTBaseAd tTBaseAd, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        ThreadHelper.runOnUiThread(new b(tTBaseAd, activity, map));
    }

    private boolean a(List<h> list, List<TTBaseAd> list2, boolean z3, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a4;
        TTBaseAd tTBaseAd;
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a5;
        TTBaseAd tTBaseAd2;
        HashMap<String, TTBaseAd> b4 = b(list2);
        for (h hVar : list) {
            if (hVar != null) {
                String c4 = hVar.c();
                TTBaseAd tTBaseAd3 = b4.get(c4);
                if (tTBaseAd3 != null) {
                    if (z3) {
                        if (tTBaseAd3.isCacheSuccess()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd3.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u5df2\u7f13\u5b58\u597d\u7684\u5e7f\u544a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd3.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd3.isReady());
                            if (tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                                a(tTBaseAd3, activity, map);
                                c(tTBaseAd3);
                                return true;
                            }
                        }
                    } else if (tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                        a(tTBaseAd3, activity, map);
                        c(tTBaseAd3);
                        return true;
                    }
                }
                if (hVar.e() != 2 && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(c4, a()) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().b(c4, this.f27885h) == 3 && (a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(c4, this.f27885h)) != null && a5.size() > 0 && (tTBaseAd2 = a5.get(0).f418a) != null) {
                    if (z3) {
                        if (tTBaseAd2.isCacheSuccess()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd2.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u5df2\u7f13\u5b58\u597d\u7684\u5e7f\u544a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd2.isReady());
                            if (tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                                b(tTBaseAd2);
                                a(tTBaseAd2, activity, map);
                                c(tTBaseAd2);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else if (tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                        b(tTBaseAd2);
                        a(tTBaseAd2, activity, map);
                        c(tTBaseAd2);
                        return true;
                    }
                }
            }
        }
        if (z3 && this.B == null) {
            for (h hVar2 : list) {
                if (hVar2 != null) {
                    String c5 = hVar2.c();
                    TTBaseAd tTBaseAd4 = b4.get(c5);
                    if (tTBaseAd4 != null && tTBaseAd4.isReady() && !tTBaseAd4.isHasShown()) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd4.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd4.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd4.isReady());
                        a(tTBaseAd4, activity, map);
                        c(tTBaseAd4);
                        return true;
                    } else if (hVar2.e() != 2 && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(c5, a()) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().b(c5, this.f27885h) == 3 && (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(c5, this.f27885h)) != null && a4.size() > 0 && (tTBaseAd = a4.get(0).f418a) != null && tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd.isReady());
                        b(tTBaseAd);
                        a(tTBaseAd, activity, map);
                        c(tTBaseAd);
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private void c(TTBaseAd tTBaseAd) {
        ThreadHelper.runOnUiThread(new a(tTBaseAd));
    }

    public boolean A() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27893p, this.f27892o, this.f27891n, this.f27885h);
        if (this.f27893p.size() > 0) {
            for (TTBaseAd tTBaseAd : this.f27893p) {
                if (tTBaseAd != null) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd.getAdNetworkSlotId()) + "isReady-\u300b\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()) + ",\u662f\u5426\u5df2\u51c6\u5907\u597d\uff1fisReady()\uff1a" + tTBaseAd.isReady());
                    if (tTBaseAd.isReady()) {
                        return true;
                    }
                }
            }
        }
        TTBaseAd tTBaseAd2 = null;
        TTBaseAd tTBaseAd3 = this.f27892o.size() > 0 ? this.f27892o.get(0) : null;
        List<TTBaseAd> list = this.f27891n;
        if (list != null && list.size() > 0) {
            Iterator<TTBaseAd> it = this.f27891n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TTBaseAd next = it.next();
                if (next != null) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, next.getAdNetworkSlotId()) + "isReady-\u300b\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(next.getAdNetworkPlatformId()) + ",\u662f\u5426\u5df2\u51c6\u5907\u597d\uff1fisReady()\uff1a" + next.isReady());
                    if (next.isReady()) {
                        tTBaseAd2 = next;
                        break;
                    }
                }
            }
        } else if (tTBaseAd3 != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd3.getAdNetworkSlotId()) + "isReady--->biding-->\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd3.getAdNetworkPlatformId()) + ",\u662f\u5426\u5df2\u51c6\u5907\u597d\uff1fisReady()\uff1a" + tTBaseAd3.isReady());
            if (tTBaseAd3.isReady()) {
                tTBaseAd2 = tTBaseAd3;
            }
        }
        return tTBaseAd2 != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, c cVar) {
        List<h> list;
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a4;
        TTBaseAd tTBaseAd;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27885h);
        if (this.F.get() || this.f27879b.get()) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a((List<TTBaseAd>) null, this.f27885h);
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        List<TTBaseAd> C = C();
        try {
            list = t();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        if (list != null && list.size() > 0) {
            HashMap<String, TTBaseAd> b4 = b(C);
            for (h hVar : list) {
                if (hVar != null) {
                    String c4 = hVar.c();
                    TTBaseAd tTBaseAd2 = b4.get(c4);
                    if (tTBaseAd2 != null && tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, "show") + "adSlotId\uff1a" + tTBaseAd2.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd2.isReady());
                        a(tTBaseAd2, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                        return;
                    } else if (hVar.e() != 2 && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(c4, a()) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().b(c4, this.f27885h) == 3 && (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(c4, this.f27885h)) != null && a4.size() > 0 && (tTBaseAd = a4.get(0).f418a) != null && tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, "show") + "adSlotId\uff1a" + tTBaseAd.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd.isReady());
                        b(tTBaseAd);
                        a(tTBaseAd, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                        return;
                    }
                }
            }
        }
        if (C != null && C.size() > 0) {
            for (TTBaseAd tTBaseAd3 : C) {
                if (tTBaseAd3 != null && tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, "show") + "adSlotId\uff1a" + tTBaseAd3.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd3.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd3.isReady());
                    a(tTBaseAd3, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                    return;
                }
            }
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(C, this.f27885h);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, c cVar) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f27885h);
        List<h> list = null;
        if (this.F.get() || this.f27879b.get()) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a((List<TTBaseAd>) null, this.f27885h);
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        boolean B = B();
        List<TTBaseAd> C = C();
        try {
            list = t();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        List<h> list2 = list;
        if (list2 == null || list2.size() <= 0 || !a(list2, C, B, activity, map)) {
            if (C != null && C.size() > 0) {
                for (TTBaseAd tTBaseAd : C) {
                    if (tTBaseAd != null) {
                        if (B) {
                            if (tTBaseAd.isCacheSuccess()) {
                                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u5df2\u7f13\u5b58\u597d\u7684\u5e7f\u544a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd.isReady());
                            } else {
                                continue;
                            }
                        }
                        if (tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                            a(tTBaseAd, activity, map);
                            c(tTBaseAd);
                            return;
                        }
                    }
                }
                if (B && this.B == null) {
                    for (TTBaseAd tTBaseAd2 : C) {
                        if (tTBaseAd2 != null && tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f27883f, tTBaseAd2.getAdNetworkSlotId()) + "\u5f31\u7f51\u60c5\u51b5\u4e0b\u6ca1\u6709\u7f13\u5b58\u597d\u7684\u5e7f\u544a,\u90a3\u4e48\u76f4\u63a5\u6839\u636e\u4f18\u5148\u7ea7\u5c55\u793a\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd2.isReady());
                            a(tTBaseAd2, activity, map);
                            c(tTBaseAd2);
                            return;
                        }
                    }
                }
            }
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(C, this.f27885h);
            if (cVar != null) {
                cVar.a();
            }
        }
    }
}
