package com.bytedance.sdk.component.adexpress.dynamic.sr;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.sr.w;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.utils.a;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.adexpress.dynamic.xv.w f29310c;
    private c sr;

    /* renamed from: w  reason: collision with root package name */
    protected w f29311w;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.ev xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        float f29312c;

        /* renamed from: w  reason: collision with root package name */
        float f29313w;
        float xv;
    }

    public ux(double d4, int i4, double d5, String str, bk bkVar) {
        this.f29311w = new w(d4, i4, d5, str, bkVar);
    }

    public void c(c cVar) {
        this.sr = cVar;
    }

    public void c() {
        this.f29311w.c();
    }

    public void c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar, float f4, float f5) {
        if (evVar != null) {
            this.xv = evVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2 = this.xv;
        float ev = evVar2.ev();
        float gd = evVar2.gd();
        float f6 = TextUtils.equals(evVar2.p().sr().ck(), "fixed") ? gd : 65536.0f;
        this.f29311w.c();
        this.f29311w.xv(evVar2, ev, f6);
        w.xv c4 = this.f29311w.c(evVar2);
        com.bytedance.sdk.component.adexpress.dynamic.xv.w wVar = new com.bytedance.sdk.component.adexpress.dynamic.xv.w();
        wVar.f29384c = f4;
        wVar.f29388w = f5;
        if (c4 != null) {
            ev = c4.f29322c;
        }
        wVar.xv = ev;
        if (c4 != null) {
            gd = c4.f29323w;
        }
        wVar.sr = gd;
        wVar.ux = "root";
        wVar.gd = 1280.0f;
        wVar.f29385f = evVar2;
        evVar2.xv(f4);
        wVar.f29385f.sr(wVar.f29388w);
        wVar.f29385f.ux(wVar.xv);
        wVar.f29385f.f(wVar.sr);
        com.bytedance.sdk.component.adexpress.dynamic.xv.w c5 = c(wVar, 0.0f);
        this.f29310c = c5;
        c(c5);
    }

    public void c(com.bytedance.sdk.component.adexpress.dynamic.xv.w wVar) {
        if (wVar == null) {
            return;
        }
        a.w("DynamicCanvas", "native parser: type = " + wVar.f29385f.p().getType() + "; width = " + wVar.xv + "; height = " + wVar.sr + "; x = " + wVar.f29384c + "; y = " + wVar.f29388w);
        List<List<com.bytedance.sdk.component.adexpress.dynamic.xv.w>> list = wVar.f29387r;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.w> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (com.bytedance.sdk.component.adexpress.dynamic.xv.w wVar2 : list2) {
                    c(wVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.xv.w c(com.bytedance.sdk.component.adexpress.dynamic.xv.w r37, float r38) {
        /*
            Method dump skipped, instructions count: 1011
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.sr.ux.c(com.bytedance.sdk.component.adexpress.dynamic.xv.w, float):com.bytedance.sdk.component.adexpress.dynamic.xv.w");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.xv.gd c(com.bytedance.sdk.component.adexpress.dynamic.xv.f fVar, w.xv xvVar, w.xv xvVar2) {
        float bs = fVar.bs();
        float xg = fVar.xg();
        float lf = fVar.lf();
        float mu = fVar.mu();
        boolean ok = fVar.ok();
        boolean h4 = fVar.h();
        boolean oh = fVar.oh();
        boolean fm = fVar.fm();
        if (!ok) {
            if (h4) {
                float f4 = this.sr.f29312c;
                bs = ((f4 != 0.0f ? Math.min(f4, xvVar.f29322c) : xvVar.f29322c) - lf) - xvVar2.f29322c;
            } else {
                bs = 0.0f;
            }
        }
        if (!oh) {
            if (fm) {
                float f5 = this.sr.f29313w;
                if (f5 == 0.0f) {
                    f5 = xvVar.f29323w;
                }
                xg = (f5 - mu) - xvVar2.f29323w;
            } else {
                xg = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.xv.gd(bs, xg);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.xv.gd c(com.bytedance.sdk.component.adexpress.dynamic.xv.w wVar, com.bytedance.sdk.component.adexpress.dynamic.xv.f fVar, float f4, float f5) {
        float f6;
        float f7;
        float f8 = wVar.f29384c;
        float f9 = wVar.f29388w;
        float bs = fVar.bs();
        float xg = fVar.xg();
        float lf = fVar.lf();
        float mu = fVar.mu();
        boolean ok = fVar.ok();
        boolean h4 = fVar.h();
        boolean oh = fVar.oh();
        boolean fm = fVar.fm();
        String ng = fVar.ng();
        float f10 = wVar.xv;
        float f11 = wVar.sr;
        if (TextUtils.equals(ng, "0")) {
            if (ok) {
                f8 = wVar.f29384c + bs;
            } else if (h4) {
                f8 = ((wVar.f29384c + f10) - lf) - f4;
            }
            if (oh) {
                f7 = wVar.f29388w;
                f9 = f7 + xg;
            } else if (fm) {
                f6 = wVar.f29388w;
                f9 = ((f6 + f11) - mu) - f5;
            }
        } else if (TextUtils.equals(ng, "1")) {
            f8 = wVar.f29384c + ((f10 - f4) / 2.0f);
            if (oh) {
                f7 = wVar.f29388w;
                f9 = f7 + xg;
            } else if (fm) {
                f6 = wVar.f29388w;
                f9 = ((f6 + f11) - mu) - f5;
            }
        } else if (TextUtils.equals(ng, "2")) {
            f9 = wVar.f29388w + ((f11 - f5) / 2.0f);
            if (ok) {
                f8 = wVar.f29384c + bs;
            } else if (h4) {
                f8 = ((wVar.f29384c + f10) - lf) - f4;
            }
        } else if (TextUtils.equals(ng, "3")) {
            f8 = wVar.f29384c + ((f10 - f4) / 2.0f);
            f9 = wVar.f29388w + ((f11 - f5) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.xv.gd(f8, f9);
    }
}
