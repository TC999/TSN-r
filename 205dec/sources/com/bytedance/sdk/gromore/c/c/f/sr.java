package com.bytedance.sdk.gromore.c.c.f;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.msdk.api.sr.p;
import com.bytedance.msdk.core.admanager.k;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements f {

    /* renamed from: c  reason: collision with root package name */
    private k f31152c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31153w;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.c xv;

    public sr(Activity activity, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar2) {
        this.f31153w = cVar;
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "CSJMSplashLoader \u6784\u9020\u51fd\u6570\u521b\u5efa mAdSlotValueSet = " + this.f31153w + " mAdSlotValueSet.getCodeId() = " + this.f31153w.f());
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar3 = this.f31153w;
        if (cVar3 != null) {
            this.f31152c = new k(activity, cVar3.f());
            this.xv = cVar2;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        c(-1);
    }

    @Override // com.bytedance.sdk.gromore.c.c.f.f
    public void c(int i4) {
        final com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.xv bk;
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "CSJMSplashLoader load timeout = " + i4);
        com.bytedance.msdk.core.bk.c.c().w();
        com.bytedance.msdk.api.c.w wVar = new com.bytedance.msdk.api.c.w(3, this.f31153w.w());
        if (i4 != -1) {
            wVar.r(i4);
        }
        p pVar = null;
        if (this.f31153w.c() != null && (bk = this.f31153w.c().bk()) != null && !TextUtils.isEmpty(bk.c()) && !TextUtils.isEmpty(bk.xv()) && !TextUtils.isEmpty(bk.w())) {
            pVar = new p() { // from class: com.bytedance.sdk.gromore.c.c.f.sr.1
                @Override // com.bytedance.msdk.api.sr.p
                public int c() {
                    String c4 = bk.c();
                    c4.hashCode();
                    char c5 = '\uffff';
                    switch (c4.hashCode()) {
                        case -1128782217:
                            if (c4.equals("klevin")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -995541405:
                            if (c4.equals("pangle")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -902468465:
                            if (c4.equals("sigmob")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case 3432:
                            if (c4.equals("ks")) {
                                c5 = 3;
                                break;
                            }
                            break;
                        case 102199:
                            if (c4.equals("gdt")) {
                                c5 = 4;
                                break;
                            }
                            break;
                        case 93498907:
                            if (c4.equals("baidu")) {
                                c5 = 5;
                                break;
                            }
                            break;
                        case 1126045977:
                            if (c4.equals("mintegral")) {
                                c5 = 6;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            return 9;
                        case 1:
                            return 1;
                        case 2:
                            return 8;
                        case 3:
                            return 7;
                        case 4:
                            return 3;
                        case 5:
                            return 6;
                        case 6:
                            return 4;
                        default:
                            return super.c();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.p
                public String sr() {
                    return bk.sr();
                }

                @Override // com.bytedance.msdk.api.sr.p
                public String w() {
                    return bk.w();
                }

                @Override // com.bytedance.msdk.api.sr.p
                public String xv() {
                    return bk.xv();
                }
            };
        }
        this.f31152c.c(wVar, pVar, new com.bytedance.msdk.api.sr.c.gd.xv() { // from class: com.bytedance.sdk.gromore.c.c.f.sr.2
            @Override // com.bytedance.msdk.api.sr.c.gd.xv
            public void c(com.bytedance.msdk.api.c cVar) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "CSJMSplashLoader onSplashAdLoadFail");
                if (cVar == null || sr.this.xv == null) {
                    return;
                }
                com.bytedance.sdk.gromore.c.c.c cVar2 = new com.bytedance.sdk.gromore.c.c.c(cVar.f27444c, cVar.f27445w);
                sr.this.xv.onSplashLoadFail(cVar2);
                sr.this.xv.onSplashRenderFail(null, cVar2);
            }

            @Override // com.bytedance.msdk.api.sr.c.gd.xv
            public void c() {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "CSJMSplashLoader onSplashAdLoadSuccess");
                if (sr.this.xv != null) {
                    w wVar2 = new w(sr.this.f31152c, sr.this.xv);
                    sr.this.xv.onSplashLoadSuccess(wVar2);
                    sr.this.xv.onSplashRenderSuccess(wVar2);
                }
            }
        });
    }
}
