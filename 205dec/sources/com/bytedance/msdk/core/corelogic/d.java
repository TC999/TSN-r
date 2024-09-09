package com.bytedance.msdk.core.corelogic;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTADBidingRequestCore.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class d {

    /* renamed from: d  reason: collision with root package name */
    protected bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c f27881d;

    /* renamed from: e  reason: collision with root package name */
    protected Map<Integer, List<h>> f27882e;

    /* renamed from: f  reason: collision with root package name */
    protected String f27883f;

    /* renamed from: g  reason: collision with root package name */
    protected Handler f27884g;

    /* renamed from: h  reason: collision with root package name */
    protected AdSlot f27885h;

    /* renamed from: i  reason: collision with root package name */
    protected double f27886i;

    /* renamed from: j  reason: collision with root package name */
    protected int f27887j;

    /* renamed from: m  reason: collision with root package name */
    protected List<Integer> f27890m;

    /* renamed from: s  reason: collision with root package name */
    protected int f27896s;

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicBoolean f27878a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicBoolean f27879b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicBoolean f27880c = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private int f27888k = 0;

    /* renamed from: l  reason: collision with root package name */
    private final List<h> f27889l = new CopyOnWriteArrayList();

    /* renamed from: n  reason: collision with root package name */
    protected List<TTBaseAd> f27891n = new CopyOnWriteArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected List<TTBaseAd> f27892o = new CopyOnWriteArrayList();

    /* renamed from: p  reason: collision with root package name */
    protected List<TTBaseAd> f27893p = new CopyOnWriteArrayList();

    /* renamed from: q  reason: collision with root package name */
    protected Map<String, Object> f27894q = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    protected g f27895r = new g();

    /* renamed from: t  reason: collision with root package name */
    protected AtomicBoolean f27897t = new AtomicBoolean(false);

    /* renamed from: u  reason: collision with root package name */
    protected bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g f27898u = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTADBidingRequestCore.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements d.b {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.b
        public void a(h hVar) {
            d.this.a(hVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.a
        public void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a aVar) {
            d.this.f27882e = aVar.f424a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTADBidingRequestCore.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements d.a {
        b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.a
        public void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a aVar) {
            List<TTBaseAd> list;
            List<TTBaseAd> list2;
            if (aVar != null && !u.a(aVar.f425b)) {
                d.this.f27888k = 1;
                if (d.this.f27878a.get() || d.this.f27879b.get()) {
                    return;
                }
                Handler handler = d.this.f27884g;
                if (handler != null) {
                    handler.removeMessages(1);
                    d.this.f27884g.removeMessages(3);
                }
                d.this.f27889l.clear();
                d.this.f27889l.addAll(aVar.f425b);
                d dVar = d.this;
                dVar.b(dVar.f27889l);
                d.this.a(0, false);
            } else {
                d.this.f27888k = 2;
                d.this.f27895r.e(null);
                d.this.f27895r.d(0, true);
                Map<Integer, List<h>> map = d.this.f27882e;
                if (map != null && map.size() > 1) {
                    if (d.this.f27895r.u()) {
                        List<TTBaseAd> list3 = d.this.f27893p;
                        if ((list3 != null && list3.size() > 0) || (((list = d.this.f27891n) != null && list.size() > 0) || ((list2 = d.this.f27892o) != null && list2.size() > 0))) {
                            d.this.f();
                        } else {
                            d.this.a(new AdError(20005, AdError.getMessage(20005)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                        }
                    }
                } else {
                    d.this.a(new AdError(20005, AdError.getMessage(20005)), (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d) null);
                }
            }
            if (aVar != null && aVar.f426c) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).d().c();
            }
            if (d.this.f27898u == null || aVar == null || TextUtils.isEmpty(aVar.f427d)) {
                return;
            }
            d.this.f27898u.f531a = aVar.f427d;
        }
    }

    private void a(List<h> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (TTBaseAd tTBaseAd : this.f27891n) {
            boolean z3 = true;
            Iterator<h> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (tTBaseAd != null && next != null && tTBaseAd.getAdNetworkSlotId().equals(next.c())) {
                    z3 = false;
                    break;
                }
            }
            if (z3) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5df2\u7ecf\u54cd\u5e94\u7684\u5e7f\u544a: " + tTBaseAd.getAdNetworkSlotId() + "  \u6ca1\u6709\u5728severBidding\u7684waterFall\u5217\u8868\u4e2d\uff0c\u9700\u8981\u88ab\u79fb\u9664\u6389");
                this.f27891n.remove(tTBaseAd);
            }
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5df2\u7ecf\u54cd\u5e94\u7684\u5e7f\u544a\u88abserverBidding\u8fc7\u6ee4\u5b8c\u8fd8\u5269: " + this.f27891n.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<h> list) {
        Map<Integer, List<h>> a4;
        if (list == null || list.size() == 0 || (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c.a(list)) == null || a4.size() == 0) {
            return;
        }
        this.f27882e = a4;
        ArrayList arrayList = new ArrayList();
        this.f27890m = arrayList;
        arrayList.addAll(this.f27882e.keySet());
        c.a(this.f27890m);
        this.f27895r.j(this.f27890m);
        this.f27895r.m(list);
        a(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar = this.f27898u;
        if (gVar != null) {
            return gVar.f532b;
        }
        return 0;
    }

    abstract void a(int i4, boolean z3);

    protected void a(h hVar) {
        this.f27895r.e(hVar.c());
        if (this.f27882e.get(Integer.valueOf(hVar.l())) == null || this.f27882e.get(Integer.valueOf(hVar.l())).size() != 0) {
            return;
        }
        this.f27895r.d(hVar.l(), true);
    }

    abstract void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdSlot adSlot, List<h> list) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.e.b();
        if (b4 == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b bVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b();
        bVar.f430c = adSlot;
        bVar.f431d = list;
        bVar.f432e = this.f27881d;
        bVar.f433f = adSlot == null ? 1 : adSlot.getPrimeRitReqType();
        b4.a(bVar, new b());
        char c4 = '(';
        while (true) {
            if (c4 != '(' && c4 == ')') {
                return;
            }
            c4 = ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<TTBaseAd> list, TTBaseAd tTBaseAd) {
        TTBaseAd tTBaseAd2;
        this.f27895r.a();
        int i4 = this.f27896s;
        boolean z3 = false;
        boolean z4 = true;
        if (i4 == 1) {
            if (this.f27892o.size() > 0 && (tTBaseAd2 = this.f27892o.get(0)) != null && tTBaseAd2.getCpm() <= tTBaseAd.getCpm()) {
                z3 = (tTBaseAd2.getCpm() == tTBaseAd.getCpm() && tTBaseAd2.getAdNetworkPlatformId() == 1) ? true : true;
                if (z3) {
                    this.f27892o.clear();
                }
                z4 = z3;
            }
            if (z4) {
                this.f27892o.addAll(list);
            }
        } else if (i4 > 1) {
            this.f27892o.addAll(list);
            f.i(this.f27892o, f.p());
            int size = this.f27892o.size();
            int i5 = this.f27896s;
            if (size > i5) {
                this.f27892o = this.f27892o.subList(0, i5);
            }
        }
        for (TTBaseAd tTBaseAd3 : this.f27892o) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f27883f) + "\u5e7f\u544a\u52a0\u8f7d\u6210\u529f...........\u8fd4\u56de\u4e86\u7ade\u4ef7\u5c42\u5e7f\u544a_\u5f53\u524d\u7ade\u4ef7\u5e7f\u544a\u6c60\u6570\u91cf\uff1a" + this.f27892o.size() + ",slotId\uff1a" + tTBaseAd3.getAdNetworkSlotId() + ",\u5e7f\u544a\u7c7b\u578b\u540d\u79f0:" + com.bytedance.msdk.base.a.d(tTBaseAd3.getAdNetworkPlatformId()) + "\uff0ccpm=" + tTBaseAd3.getCpm() + ",loadSort=" + tTBaseAd3.getLoadSort() + ",showSort=" + tTBaseAd3.getShowSort());
        }
    }

    abstract void a(boolean z3);

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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(int r10) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.d.a(int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[LOOP:0: B:21:0x0050->B:23:0x0050, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:17:0x004a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.bytedance.msdk.base.TTBaseAd r7) {
        /*
            r6 = this;
            double r0 = r6.f27886i
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L26
            double r0 = r7.getCpm()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L26
            com.bytedance.msdk.core.corelogic.g r0 = r6.f27895r
            r0.x()
            int r7 = r7.getAdNetworkPlatformId()
            if (r7 == r4) goto L20
            r6.a(r4)
            goto L4e
        L20:
            r6.f()
            r7 = 92
            goto L4a
        L26:
            double r0 = r7.getCpm()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L2f
            return r4
        L2f:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.e.a()
            if (r0 == 0) goto L52
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b r1 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b
            r1.<init>()
            r1.f428a = r7
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h>> r7 = r6.f27882e
            r1.f429b = r7
            com.bytedance.msdk.core.corelogic.d$a r7 = new com.bytedance.msdk.core.corelogic.d$a
            r7.<init>()
            r0.a(r1, r7)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.corelogic.d.a(com.bytedance.msdk.base.TTBaseAd):boolean");
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && j() && l() && this.f27889l.size() > 0) {
            for (h hVar : this.f27889l) {
                if (str.equals(hVar.c())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int b() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i4) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar = this.f27898u;
        if (gVar != null) {
            gVar.f532b = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar = this.f27898u;
        if (gVar != null) {
            gVar.f533c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar = this.f27898u;
        if (gVar == null) {
            return null;
        }
        return gVar.f531a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar = this.f27898u;
        if (gVar != null) {
            return gVar.f533c;
        }
        return null;
    }

    public String e() {
        return this.f27883f;
    }

    abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        return j() || h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        return this.f27887j == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j() {
        return this.f27887j == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        if (this.f27895r.v()) {
            return;
        }
        Message message = new Message();
        message.what = 1;
        message.arg1 = 10001;
        Handler handler = this.f27884g;
        if (handler != null) {
            handler.removeMessages(1);
            this.f27884g.sendMessage(message);
        }
    }

    protected boolean l() {
        return this.f27888k == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return this.f27888k > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g gVar;
        if (!j() || (gVar = this.f27898u) == null || TextUtils.isEmpty(gVar.f531a)) {
            return;
        }
        for (TTBaseAd tTBaseAd : this.f27893p) {
            tTBaseAd.putEventParam("server_bidding_extra", this.f27898u.f531a);
        }
        for (TTBaseAd tTBaseAd2 : this.f27892o) {
            tTBaseAd2.putEventParam("server_bidding_extra", this.f27898u.f531a);
        }
        for (TTBaseAd tTBaseAd3 : this.f27891n) {
            tTBaseAd3.putEventParam("server_bidding_extra", this.f27898u.f531a);
        }
    }
}
