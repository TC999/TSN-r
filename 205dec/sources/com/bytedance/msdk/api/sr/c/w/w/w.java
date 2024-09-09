package com.bytedance.msdk.api.sr.c.w.w;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.k.gd;
import com.bytedance.msdk.core.k.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w {

    /* renamed from: r  reason: collision with root package name */
    protected Map<String, Object> f27605r;
    protected com.bytedance.msdk.api.sr.c.w.w.c sr;

    /* renamed from: w  reason: collision with root package name */
    protected p f27606w;
    protected com.bytedance.msdk.adapter.c xv;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f27603c = false;
    protected int ux = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f27604f = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    public final boolean a() {
        com.bytedance.msdk.adapter.c cVar = this.xv;
        if (cVar != null) {
            return cVar.hasNotifyFail();
        }
        return false;
    }

    public final MediationConstant.AdIsReadyStatus bk() {
        try {
            return c();
        } catch (Exception e4) {
            e4.printStackTrace();
            return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
        }
    }

    public final void c(Context context, final com.bytedance.msdk.api.c.w wVar, final p pVar, Map<String, Object> map, gd gdVar, int i4, c.InterfaceC0386c interfaceC0386c) {
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", "\u81ea\u5b9a\u4e49ADN \u5f00\u59cb\u52a0\u8f7d\u5e7f\u544a\u5bf9\u8c61 ----------   adSlot = " + pVar.ia());
        this.f27606w = pVar;
        map.put("const_is_custom", Boolean.TRUE);
        com.bytedance.msdk.api.sr.c.w.w wVar2 = new com.bytedance.msdk.api.sr.c.w.w() { // from class: com.bytedance.msdk.api.sr.c.w.w.w.1
            @Override // com.bytedance.msdk.api.sr.c.w.w, com.bytedance.msdk.adapter.c
            public String getAdNetWorkName() {
                p pVar2 = pVar;
                if (pVar2 != null) {
                    return pVar2.t();
                }
                return super.getAdNetWorkName();
            }

            @Override // com.bytedance.msdk.adapter.c
            public void loadAd(Context context2, Map<String, Object> map2) {
                com.bytedance.msdk.api.sr.c.w.xv.xv xvVar = new com.bytedance.msdk.api.sr.c.w.xv.xv(w.this.p(), pVar.ia(), pVar.gd(), pVar.ux(), pVar.xk());
                com.bytedance.msdk.api.sr.c.w.f.c c4 = com.bytedance.msdk.sr.w.c.c(pVar.t());
                ((com.bytedance.msdk.api.sr.c.w.w) this).f27601f = c4 != null ? c4.c() : "";
                w.this.w(context2, wVar, xvVar);
            }
        };
        this.xv = wVar2;
        wVar2.setAdapterListener(interfaceC0386c);
        this.xv.loadAdInter(context, pVar, map, wVar, gdVar, i4);
    }

    public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
    }

    public final Object fp() {
        com.bytedance.msdk.adapter.c cVar = this.xv;
        if (cVar == null) {
            return null;
        }
        return cVar.getExtraDataNoParse();
    }

    public final boolean k() {
        com.bytedance.msdk.adapter.c cVar = this.xv;
        if (cVar != null) {
            return cVar.hasNotifySuccess();
        }
        return false;
    }

    @Nullable
    public final String p() {
        p pVar = this.f27606w;
        return pVar == null ? "" : pVar.t();
    }

    public void sr() {
    }

    public final int t() {
        com.bytedance.msdk.adapter.c cVar = this.xv;
        if (cVar == null) {
            return 0;
        }
        return cVar.getReqBiddingType();
    }

    public void w() {
    }

    public abstract void w(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.w.xv.xv xvVar);

    public final void w(c cVar) {
        if (this.f27603c) {
            int i4 = this.ux;
            if (i4 < 2) {
                this.ux = i4 + 1;
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter show\u65b9\u6cd5\u56de\u8c03\u6b21\u6570\u9700\u8981\u5c0f\u4e8e2\u6b21");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter show\u65b9\u6cd5\u56de\u8c03\u5fc5\u987b\u7531GroMore\u89e6\u53d1show\u65f6\u624d\u4f1a\u751f\u6548");
    }

    public void xv() {
    }

    public final void xv(c cVar) {
        int i4 = this.f27604f;
        if (i4 < 60) {
            this.f27604f = i4 + 1;
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter click\u65b9\u6cd5\u56de\u8c03\u6b21\u6570\u9700\u8981\u5c0f\u4e8e60\u6b21");
    }

    public final String ys() {
        com.bytedance.msdk.adapter.c cVar = this.xv;
        return cVar == null ? "" : cVar.getAdm();
    }

    public MediationConstant.AdIsReadyStatus c() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public final void c(c cVar) {
        if (!k()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u8c03\u7528\u9519\u8bef\u9700\u8981\u5728load\u6210\u529f\u4e4b\u540e\u624d\u53ef\u4ee5\u8c03\u7528");
        } else if (cVar != null) {
            cVar.c();
        }
    }

    public final void c(ux uxVar, String str) {
        com.bytedance.msdk.adapter.c cVar = this.xv;
        if (cVar != null) {
            cVar.nativeDislikeClick(uxVar, str, null);
        }
    }
}
