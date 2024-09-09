package com.bytedance.msdk.api.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements sr, xv {

    /* renamed from: c  reason: collision with root package name */
    private sr f27454c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.core.k.w f27455w;
    private xv xv;

    public w() {
    }

    private void bj() {
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "------------- \u670d\u52a1\u7aef\u914d\u7f6e start ----------------------");
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getWaterfallId = " + bw());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getVersion = " + x());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getBidFloor = " + m());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getParalleType = " + gw());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getReqParallelNum = " + vc());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getWaterfallABTest = " + up());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getSegmentId = " + mt());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getSegmentVersion = " + oo());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getWaterfallExtra = " + au());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getAdCount = " + ls());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "------------- \u670d\u52a1\u7aef\u914d\u7f6e end ----------------------");
    }

    private void c(int i4, ValueSet valueSet, xv xvVar) {
        this.f27454c = new ux(i4, valueSet);
        c cVar = new c();
        this.xv = cVar;
        if (xvVar != null) {
            cVar.ux(xvVar.ev());
        }
    }

    public xv a() {
        return this.xv;
    }

    public String au() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        return wVar != null ? wVar.fz() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String ba() {
        sr srVar = this.f27454c;
        return srVar != null ? srVar.ba() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public float bk() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.bk();
        }
        return 0.0f;
    }

    public long bw() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        if (wVar != null) {
            return wVar.ck();
        }
        return 0L;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String ck() {
        sr srVar = this.f27454c;
        return srVar != null ? srVar.ck() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int eq() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.eq();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public void ev(int i4) {
        sr srVar = this.f27454c;
        if (srVar != null) {
            srVar.ev(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void f(int i4) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.f(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int fp() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.fp();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int fz() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.fz();
        }
        return 0;
    }

    public int gb() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        if (wVar != null) {
            return wVar.bj();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public void gd() {
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "--------------------------- \u8bf7\u6c42\u53c2\u6570 --------------------------");
        if (this.xv != null) {
            com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "---- \u805a\u5408\u5185\u90e8\u751f\u6210\u53c2\u6570 start ------ ");
            this.xv.gd();
            com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "---- \u805a\u5408\u5185\u90e8\u751f\u6210\u53c2\u6570 end ----- ");
        }
        if (this.f27454c != null) {
            com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "---- \u8bf7\u6c42\u53c2\u6570 start ------");
            this.f27454c.gd();
            com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "---- \u8bf7\u6c42\u53c2\u6570 end ------");
        }
        bj();
    }

    public int gw() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        if (wVar != null) {
            return wVar.oo();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String i() {
        sr srVar = this.f27454c;
        return srVar != null ? srVar.i() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean ia() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.ia();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int j() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.j();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public JSONObject k() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.k();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int ls() {
        sr srVar;
        if (5 == fz() || 9 == fz()) {
            com.bytedance.msdk.core.k.w wVar = this.f27455w;
            int ia = wVar != null ? wVar.ia() : 0;
            if (ia == 0 && (srVar = this.f27454c) != null) {
                ia = srVar.ls();
            }
            if (ia <= 0) {
                return 1;
            }
            if (ia >= 3) {
                return 3;
            }
            return ia;
        }
        return 1;
    }

    public double m() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        if (wVar != null) {
            return wVar.s();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean me() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.me();
        }
        return false;
    }

    public int mt() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        if (wVar != null) {
            return wVar.z();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean n() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.n();
        }
        return false;
    }

    public String oo() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        return wVar != null ? wVar.ba() : "";
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int p() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.p();
        }
        return 0;
    }

    public com.bytedance.msdk.core.k.w pr() {
        return this.f27455w;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int q() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.q();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public void r(int i4) {
        sr srVar = this.f27454c;
        if (srVar != null) {
            srVar.r(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.sr
    public com.bytedance.sdk.openadsdk.mediation.c.w.c s() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.s();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int sr() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.sr();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public float t() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.t();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String u() {
        sr srVar = this.f27454c;
        return srVar != null ? srVar.u() : "";
    }

    public String up() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        return wVar != null ? wVar.mt() : "";
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int ux() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.ux();
        }
        return 0;
    }

    public int vc() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        if (wVar != null) {
            return wVar.au();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int w() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.w();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String wv() {
        sr srVar = this.f27454c;
        return srVar != null ? srVar.wv() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public ValueSet wx() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.wx();
        }
        return null;
    }

    public String x() {
        com.bytedance.msdk.core.k.w wVar = this.f27455w;
        return wVar != null ? wVar.me() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean xk() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.xk();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int xv() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.xv();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String y() {
        sr srVar = this.f27454c;
        return srVar != null ? srVar.y() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean ys() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.ys();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public Map<String, Object> yu() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.yu();
        }
        return new HashMap();
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int z() {
        sr srVar = this.f27454c;
        if (srVar != null) {
            return srVar.z();
        }
        return 0;
    }

    public w(int i4, ValueSet valueSet) {
        c(i4, valueSet, null);
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int ev() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.ev();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public String f() {
        xv xvVar = this.xv;
        return xvVar != null ? xvVar.f() : "";
    }

    @Override // com.bytedance.msdk.api.c.xv
    public boolean r() {
        xv xvVar = this.xv;
        if (xvVar != null) {
            return xvVar.r();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void sr(int i4) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.sr(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void ux(int i4) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.ux(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void w(int i4) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.w(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void xv(int i4) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.xv(i4);
        }
    }

    public w(w wVar) {
        if (wVar != null) {
            c(wVar.fz(), wVar.wx(), wVar.a());
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(JSONObject jSONObject) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.c(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void w(String str) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.w(str);
        }
    }

    public void c(com.bytedance.msdk.core.k.w wVar) {
        this.f27455w = wVar;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public String c() {
        xv xvVar = this.xv;
        return xvVar != null ? xvVar.c() : "";
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(String str) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.c(str);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(int i4) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.c(i4);
        }
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(boolean z3) {
        xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.c(z3);
        }
    }
}
