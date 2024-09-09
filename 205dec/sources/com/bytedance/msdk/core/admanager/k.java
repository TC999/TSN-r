package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.sr.ys;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends sr implements com.bytedance.msdk.adapter.w.ux {
    private com.bytedance.msdk.api.sr.c.gd.sr be;

    /* renamed from: c  reason: collision with root package name */
    private Activity f27722c;
    private com.bytedance.msdk.api.sr.c.gd.ux eu;

    /* renamed from: w  reason: collision with root package name */
    private boolean f27723w;
    private com.bytedance.msdk.api.sr.c.gd.w wx;
    private View xv;
    private com.bytedance.msdk.api.sr.c.gd.xv yu;

    public k(Activity activity, String str) {
        super(activity, str, 3);
        this.f27723w = false;
        this.f27722c = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.p pVar, com.bytedance.msdk.api.sr.c.gd.xv xvVar) {
        c(wVar, pVar, xvVar, p());
    }

    public View a() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.getSplashClickEyeView();
            return null;
        }
        return null;
    }

    public View bk() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            uxVar.getSplashCardView();
            return null;
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.gd.w
    public void d_(com.bytedance.msdk.api.c cVar) {
        String str;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, cVar, 1, 0, str, j4);
        ux(cVar);
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void f() {
        com.bytedance.msdk.api.sr.c.gd.sr srVar = this.be;
        if (srVar != null) {
            srVar.sr();
        }
    }

    public View fp() {
        if (this.f27722c == null) {
            return null;
        }
        if (this.xv == null) {
            FrameLayout frameLayout = new FrameLayout(this.f27722c);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            xv(frameLayout);
            this.xv = frameLayout;
        }
        return this.xv;
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public Activity getActivity() {
        com.bytedance.msdk.api.sr.c.gd.sr srVar = this.be;
        if (srVar != null) {
            return srVar.getActivity();
        }
        return null;
    }

    protected void ia() {
        if (this.bm.canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, this.bm.getAdNetworkSlotId(), u())) {
            com.bytedance.msdk.core.ux.c.c.c().c(this.bm.getAdNetworkSlotId(), this.f28155k, this.f28153i, true, this.xu, this.gb, this.vc.get());
        }
    }

    public int p() {
        return ((Integer) this.f28153i.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue();
    }

    @Override // com.bytedance.msdk.api.sr.c.gd.w
    public void r() {
        com.bytedance.msdk.api.sr.c.gd.w wVar = this.wx;
        if (wVar != null) {
            wVar.r();
        }
        String str = null;
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = -1;
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        }
        com.bytedance.msdk.core.w.c.ux(this.f28155k.u());
        com.bytedance.msdk.c.ux uxVar = this.bm;
        com.bytedance.msdk.xv.r.w(uxVar, this.f28155k, 0, str, j4, uxVar.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
    }

    public int[] t() {
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            return uxVar.getMinWindowSize();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.gd.w
    public void u_() {
        com.bytedance.msdk.api.sr.c.gd.w wVar = this.wx;
        if (wVar != null) {
            wVar.u_();
        }
        bk c4 = bk.c();
        c4.r(this.gd + "");
        if (this.bm != null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.bm.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(this.bm.getAdNetworkPlatformId()));
            com.bytedance.msdk.core.gd.k.c().w(this.gd, this.bm.getAdNetworkSlotId());
        }
        com.bytedance.msdk.c.ux uxVar = this.bm;
        if (uxVar != null) {
            com.bytedance.msdk.core.xv.xv.c(uxVar.getAdnName(), this.gd, this.bm.getAdNetworkSlotId());
        }
        ia();
        String str = null;
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = -1;
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 0, str, j4, false);
        com.bytedance.msdk.core.w.c.r(this.f28155k.u());
        com.bytedance.msdk.core.w.c.xv(this.f28155k.u());
        com.bytedance.msdk.core.p.sr.c(1, this.f28155k.u(), this.bm.getAdType(), this.bm.getCpm());
        com.bytedance.msdk.core.r.r.c(this.gd, this.bm);
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void ux() {
        com.bytedance.msdk.api.sr.c.gd.sr srVar = this.be;
        if (srVar != null) {
            srVar.xv();
        }
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void v_() {
        com.bytedance.msdk.api.sr.c.gd.ux uxVar = this.eu;
        if (uxVar != null) {
            uxVar.w();
        }
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void w_() {
        com.bytedance.msdk.api.sr.c.gd.sr srVar = this.be;
        if (srVar != null) {
            srVar.c();
        }
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void x_() {
        com.bytedance.msdk.api.sr.c.gd.sr srVar = this.be;
        if (srVar != null) {
            srVar.w();
        }
    }

    public void xv(int i4) {
        this.f28153i.put(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT, Integer.valueOf(i4));
    }

    public boolean ys() {
        List<com.bytedance.msdk.core.k.p> list;
        try {
            list = be();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        return fp.c(this.f28162u, this.fz, this.f28160s, this.f28155k, this.au, this.ux, pr(), u(), list, wVar != null ? wVar.mt() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(ViewGroup viewGroup) {
        boolean z3;
        boolean z4;
        List<com.bytedance.msdk.core.ux.w.ev> c4;
        com.bytedance.msdk.c.ux uxVar;
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        List<com.bytedance.msdk.core.k.p> list = null;
        com.bytedance.msdk.xv.r.c(this.f28155k, wVar != null ? wVar.mt() : null);
        if (this.au) {
            com.bytedance.msdk.xv.r.c((List<com.bytedance.msdk.c.ux>) null, this.f28155k, 0);
            ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            return;
        }
        int w3 = sr.w(this.gd);
        if (w3 != 0) {
            com.bytedance.msdk.xv.r.c((List<com.bytedance.msdk.c.ux>) null, this.f28155k, w3);
            ux(new com.bytedance.msdk.api.c(w3, com.bytedance.msdk.api.c.c(w3)));
            return;
        }
        List<com.bytedance.msdk.c.ux> gw = gw();
        if (viewGroup != null) {
            try {
                list = be();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (list != null && list.size() > 0) {
                HashMap<String, com.bytedance.msdk.c.ux> f4 = f(gw);
                for (com.bytedance.msdk.core.k.p pVar : list) {
                    if (pVar != null) {
                        String ia = pVar.ia();
                        com.bytedance.msdk.c.ux uxVar2 = f4.get(ia);
                        if (uxVar2 != null && uxVar2.isReady(this.gd) && !uxVar2.isHasShown()) {
                            c(uxVar2, viewGroup);
                        } else if (pVar.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia, u()) && com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, false) == 3 && (c4 = com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, u())) != null && c4.size() > 0 && (uxVar = c4.get(0).f28224c) != null && uxVar.isReady(this.gd) && !uxVar.isHasShown()) {
                            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, "show") + "adSlotId\uff1a" + uxVar.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()) + ",isReady()\uff1a" + uxVar.isReady(this.gd));
                            sr(uxVar);
                            c(uxVar, viewGroup);
                        }
                        z3 = true;
                        z4 = true;
                        break;
                    }
                }
            }
            z3 = false;
            z4 = false;
            if (!z3 && gw != null && gw.size() > 0) {
                Iterator<com.bytedance.msdk.c.ux> it = gw.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bytedance.msdk.c.ux next = it.next();
                    if (next != null && next.isReady(this.gd) && !next.isHasShown()) {
                        c(next, viewGroup);
                        z4 = true;
                        break;
                    }
                }
            }
            if (z4) {
                this.au = true;
                if (this.bm != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.bm);
                    w(arrayList);
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, false, 0);
                return;
            }
            com.bytedance.msdk.xv.r.c(gw, this.f28155k, 0);
            ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            return;
        }
        com.bytedance.msdk.xv.r.c(gw, this.f28155k, 0);
        ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w() {
        if (this.bm == null) {
            com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
        }
        super.w();
        this.f27722c = null;
        this.wx = null;
        this.yu = null;
    }

    private void ux(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.k.3
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.wx != null) {
                    k.this.wx.d_(cVar);
                }
            }
        });
    }

    public void c(final com.bytedance.msdk.api.c.w wVar, final com.bytedance.msdk.api.sr.p pVar, final com.bytedance.msdk.api.sr.c.gd.xv xvVar) {
        if (pVar != null && pVar.c() == 1 && !TextUtils.isEmpty(pVar.xv()) && !TextUtils.isEmpty(com.bytedance.msdk.sr.w.c.ux()) && !pVar.xv().equals(com.bytedance.msdk.sr.w.c.ux())) {
            if (xvVar != null) {
                xvVar.c(new com.bytedance.msdk.api.c(840028, com.bytedance.msdk.api.c.c(840028)));
            }
        } else if (!com.bytedance.msdk.core.c.w().c(pr(), 3) && xvVar != null) {
            xvVar.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
        } else if (!com.bytedance.msdk.core.c.w().bk()) {
            if (xvVar != null) {
                xvVar.c(new com.bytedance.msdk.api.c(840034, com.bytedance.msdk.api.c.c(840034)));
            }
        } else {
            xv(wVar.fp());
            if (com.bytedance.msdk.core.c.w().j()) {
                com.bytedance.msdk.api.sr.gd.c(new ys() { // from class: com.bytedance.msdk.core.admanager.k.1
                    @Override // com.bytedance.msdk.api.sr.ys
                    public void c() {
                        k.this.w(wVar, pVar, xvVar);
                    }
                });
            } else {
                w(wVar, pVar, xvVar);
            }
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.gd.w
    public void w(int i4) {
        com.bytedance.msdk.api.sr.c.gd.w wVar = this.wx;
        if (wVar != null) {
            wVar.w(i4);
        }
        com.bytedance.msdk.core.ux.w.w.c().c(this.vc.get(), this.gd, u());
    }

    private void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.p pVar, com.bytedance.msdk.api.sr.c.gd.xv xvVar, int i4) {
        if (k()) {
            this.f28155k = wVar;
            this.xu = pVar;
            this.yu = xvVar;
            if (i4 != -1 && i4 != 0) {
                this.f28153i.put(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT, Integer.valueOf(i4));
                this.f28155k.r(i4);
            }
            this.up = this;
            g_();
        }
    }

    public void c(com.bytedance.msdk.api.sr.c.gd.w wVar) {
        this.wx = wVar;
    }

    public void c(com.bytedance.msdk.api.sr.c.gd.ux uxVar) {
        this.eu = uxVar;
    }

    public void c(com.bytedance.msdk.api.sr.c.gd.sr srVar) {
        this.be = srVar;
    }

    public void c(final ViewGroup viewGroup) {
        w((com.bytedance.msdk.c.ux) null);
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.k.2
            @Override // java.lang.Runnable
            public void run() {
                k.this.xv(viewGroup);
            }
        });
    }

    private void c(com.bytedance.msdk.c.ux uxVar, ViewGroup viewGroup) {
        this.bm = uxVar;
        uxVar.setHasShown(true);
        this.bm.setTTAdatperCallback(this.up);
        if (this.bm.canAdReuse() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, this.bm.getAdNetworkSlotId(), u())) {
            com.bytedance.msdk.c.ux uxVar2 = this.bm;
            c(uxVar2, uxVar2.getAdNetworkSlotId());
        }
        com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd, "show") + "\u5c55\u793a\u7684\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(this.bm.getAdNetworkPlatformId()) + ",slotId\uff1a" + this.bm.getAdNetworkSlotId() + ",slotType:" + this.bm.getAdNetworkSlotType());
        bk c4 = bk.c();
        StringBuilder sb = new StringBuilder();
        sb.append(this.gd);
        sb.append("");
        c4.w(sb.toString());
        a.c().w(this.gd, this.bm.getAdNetworkSlotId());
        this.bm.showSplashAd(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.gd.xv xvVar = this.yu;
        if (xvVar != null) {
            xvVar.c(cVar);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.gd.w
    public void c(int i4) {
        com.bytedance.msdk.api.sr.c.gd.w wVar = this.wx;
        if (wVar != null) {
            wVar.c(1);
        }
        com.bytedance.msdk.core.ux.w.w.c().c(this.vc.get(), this.gd, u());
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void c() {
        com.bytedance.msdk.api.sr.c.gd.ux uxVar = this.eu;
        if (uxVar != null) {
            uxVar.c();
        }
    }

    @Override // com.bytedance.msdk.adapter.w.ux
    public void c(boolean z3) {
        com.bytedance.msdk.api.sr.c.gd.sr srVar = this.be;
        if (srVar != null) {
            srVar.c(z3);
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
        com.bytedance.msdk.api.sr.c.gd.xv xvVar = this.yu;
        if (xvVar != null) {
            xvVar.c();
        }
    }
}
