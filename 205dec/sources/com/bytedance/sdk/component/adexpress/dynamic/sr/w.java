package com.bytedance.sdk.component.adexpress.dynamic.sr;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.w.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f29315f;
    private bk gd;

    /* renamed from: r  reason: collision with root package name */
    private double f29316r;
    private double ux;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, xv> f29314c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    public Map<String, xv> f29317w = new HashMap();
    public Map<String, xv> xv = new HashMap();
    private double sr = Math.random();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Cloneable {

        /* renamed from: c  reason: collision with root package name */
        float f29318c;

        /* renamed from: w  reason: collision with root package name */
        boolean f29319w;
        float xv;

        c() {
        }

        public Object clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.sr.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0437w {

        /* renamed from: c  reason: collision with root package name */
        float f29320c;
        double sr;
        float ux;

        /* renamed from: w  reason: collision with root package name */
        int f29321w;
        int xv;

        C0437w() {
        }

        static JSONObject c(C0437w c0437w) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0437w.f29320c);
                jSONObject.put("letterSpacing", c0437w.f29321w);
                jSONObject.put("lineHeight", c0437w.sr);
                jSONObject.put("maxWidth", c0437w.ux);
                jSONObject.put("fontWeight", c0437w.xv);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class xv {

        /* renamed from: c  reason: collision with root package name */
        float f29322c;

        /* renamed from: w  reason: collision with root package name */
        float f29323w;

        public xv() {
        }

        public String toString() {
            return "UnitSize{width=" + this.f29322c + ", height=" + this.f29323w + '}';
        }

        public xv(float f4, float f5) {
            this.f29322c = f4;
            this.f29323w = f5;
        }
    }

    public w(double d4, int i4, double d5, String str, bk bkVar) {
        this.ux = d4;
        this.f29315f = i4;
        this.f29316r = d5;
        this.ev = str;
        this.gd = bkVar;
    }

    private xv f(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar, float f4, float f5) {
        new xv();
        com.bytedance.sdk.component.adexpress.dynamic.xv.f sr = evVar.p().sr();
        evVar.p().w();
        sr.b();
        float s3 = sr.s();
        int bm = sr.bm();
        double bj = sr.bj();
        int wo = sr.wo();
        boolean gw = sr.gw();
        boolean ox = sr.ox();
        int vc = sr.vc();
        C0437w c0437w = new C0437w();
        c0437w.f29320c = s3;
        c0437w.f29321w = bm;
        c0437w.xv = wo;
        c0437w.sr = bj;
        c0437w.ux = f4;
        return c(evVar.p().w(), c0437w, gw, ox, vc, evVar);
    }

    private xv ux(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar, float f4, float f5) {
        String str = evVar.xv() + "_" + f4 + "_" + f5;
        if (this.xv.containsKey(str)) {
            return this.xv.get(str);
        }
        xv f6 = f(evVar, f4, f5);
        this.xv.put(str, f6);
        return f6;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.sr.w.xv c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev r13, float r14, float r15) {
        /*
            r12 = this;
            com.bytedance.sdk.component.adexpress.dynamic.xv.ux r0 = r13.p()
            java.lang.String r0 = r0.w()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.xv.ux r0 = r13.p()
            com.bytedance.sdk.component.adexpress.dynamic.xv.f r0 = r0.sr()
            java.lang.String r0 = r0.te()
            if (r0 != 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv r13 = new com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv
            r13.<init>(r1, r1)
            return r13
        L23:
            com.bytedance.sdk.component.adexpress.dynamic.xv.ux r0 = r13.p()
            java.lang.String r0 = r0.getType()
            java.lang.String r2 = "creative-playable-bait"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L39
            com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv r13 = new com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv
            r13.<init>(r1, r1)
            return r13
        L39:
            float r0 = r13.ev()
            float r1 = r13.gd()
            com.bytedance.sdk.component.adexpress.dynamic.xv.ux r2 = r13.p()
            com.bytedance.sdk.component.adexpress.dynamic.xv.f r2 = r2.sr()
            java.lang.String r3 = r2.z()
            java.lang.String r2 = r2.ck()
            int r4 = r13.bk()
            float r4 = (float) r4
            int r5 = r13.t()
            float r5 = (float) r5
            float r6 = r13.ys()
            float r7 = r13.fp()
            java.lang.String r8 = "fixed"
            boolean r9 = android.text.TextUtils.equals(r3, r8)
            java.lang.String r10 = "flex"
            java.lang.String r11 = "auto"
            if (r9 == 0) goto L86
            float r14 = java.lang.Math.min(r0, r14)
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv r13 = r12.w(r13, r0, r1)
            float r13 = r13.f29323w
        L83:
            float r1 = r13 + r7
            goto Lb7
        L86:
            boolean r9 = android.text.TextUtils.equals(r3, r11)
            if (r9 == 0) goto L9f
            float r14 = r14 - r6
            float r0 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv r13 = r12.w(r13, r14, r0)
            float r14 = r13.f29322c
            float r14 = r14 + r6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r13 = r13.f29323w
            goto L83
        L9f:
            boolean r3 = android.text.TextUtils.equals(r3, r10)
            if (r3 == 0) goto Lb6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv r13 = r12.w(r13, r0, r1)
            float r13 = r13.f29323w
            goto L83
        Lb6:
            r14 = r0
        Lb7:
            java.lang.String r13 = "scale"
            boolean r13 = android.text.TextUtils.equals(r2, r13)
            if (r13 == 0) goto Lda
            float r13 = r14 - r4
            float r13 = r13 / r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r13 = r13 + r5
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto Ld8
            float r13 = r15 - r5
            float r13 = r13 * r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r14 = r13 + r4
            goto Lee
        Ld8:
            r15 = r13
            goto Lee
        Lda:
            boolean r13 = android.text.TextUtils.equals(r2, r8)
            if (r13 == 0) goto Le6
            float r1 = r1 + r5
            float r15 = java.lang.Math.min(r1, r15)
            goto Lee
        Le6:
            boolean r13 = android.text.TextUtils.equals(r2, r10)
            if (r13 == 0) goto Led
            goto Lee
        Led:
            r15 = r1
        Lee:
            com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv r13 = new com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv
            r13.<init>()
            r13.f29322c = r14
            r13.f29323w = r15
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.sr.w.c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev, float, float):com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.sr.w.xv sr(com.bytedance.sdk.component.adexpress.dynamic.xv.ev r21, float r22, float r23) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.sr.w.sr(com.bytedance.sdk.component.adexpress.dynamic.xv.ev, float, float):com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv");
    }

    public xv w(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar, float f4, float f5) {
        xv xvVar = new xv();
        if (evVar.p().sr() == null) {
            return xvVar;
        }
        xv ux = ux(evVar, f4, f5);
        float f6 = ux.f29322c;
        float f7 = ux.f29323w;
        xvVar.f29322c = Math.min(f6, f4);
        xvVar.f29323w = Math.min(f7, f5);
        return xvVar;
    }

    public xv xv(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar, float f4, float f5) {
        if (evVar == null) {
            return null;
        }
        xv c4 = c(evVar);
        if (c4 == null || (c4.f29322c == 0.0f && c4.f29323w == 0.0f)) {
            xv sr = sr(evVar, f4, f5);
            c(evVar, sr);
            return sr;
        }
        return c4;
    }

    private xv xv(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list, float f4, float f5) {
        float f6;
        sr(list);
        xv xvVar = new xv();
        ArrayList<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> arrayList = new ArrayList();
        ArrayList<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.xv.f sr = evVar.p().sr();
            if (sr.xu() == 1 || sr.xu() == 2) {
                arrayList.add(evVar);
            }
            if (sr.xu() != 1 && sr.xu() != 2) {
                arrayList2.add(evVar);
            }
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2 : arrayList) {
            xv(evVar2, f4, f5);
        }
        if (arrayList2.size() <= 0) {
            return xvVar;
        }
        ArrayList arrayList3 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar3 : arrayList2) {
            arrayList3.add(Float.valueOf(xv(evVar3, f4, f5).f29322c));
        }
        ArrayList arrayList4 = new ArrayList();
        int i4 = 0;
        while (true) {
            if (i4 >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar4 = arrayList2.get(i4);
            String z3 = evVar4.p().sr().z();
            float ev = evVar4.ev();
            boolean equals = TextUtils.equals(z3, "flex");
            if (TextUtils.equals(z3, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>> ia = evVar4.ia();
                if (ia != null && ia.size() > 0) {
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list2 : ia) {
                        if (w(list2)) {
                            equals = true;
                            break;
                        }
                    }
                }
                equals = false;
            }
            c cVar = new c();
            if (!equals) {
                ev = ((Float) arrayList3.get(i4)).floatValue();
            }
            cVar.f29318c = ev;
            cVar.f29319w = !equals;
            if (equals) {
                f6 = ((Float) arrayList3.get(i4)).floatValue();
            }
            cVar.xv = f6;
            arrayList4.add(cVar);
            i4++;
        }
        c(arrayList4, f4, arrayList2);
        List<c> c4 = p.c(f4, arrayList4);
        float f7 = 0.0f;
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            f7 += c4.get(i5).f29318c;
            if (((Float) arrayList3.get(i5)).floatValue() != c4.get(i5).f29318c) {
                sr(arrayList2.get(i5));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> it = arrayList2.iterator();
        int i6 = 0;
        boolean z4 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i6++;
            if (!w(it.next())) {
                z4 = false;
                break;
            } else if (i6 == arrayList2.size()) {
                z4 = true;
            }
        }
        f6 = z4 ? f5 : 0.0f;
        ArrayList<xv> arrayList5 = new ArrayList();
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar5 = arrayList2.get(i7);
            xv xv2 = xv(evVar5, c4.get(i7).f29318c, f5);
            if (!w(evVar5)) {
                f6 = Math.max(f6, xv2.f29323w);
            }
            arrayList5.add(xv2);
        }
        ArrayList arrayList6 = new ArrayList();
        for (xv xvVar2 : arrayList5) {
            arrayList6.add(Float.valueOf(xvVar2.f29323w));
        }
        if (!z4) {
            for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar6 = arrayList2.get(i8);
                if (w(evVar6) && ((Float) arrayList6.get(i8)).floatValue() != f6) {
                    sr(evVar6);
                    xv(evVar6, c4.get(i8).f29318c, f6);
                }
            }
        }
        xvVar.f29322c = f7;
        xvVar.f29323w = f6;
        return xvVar;
    }

    private boolean w(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list) {
        boolean z3;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>> ia;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (TextUtils.equals(it.next().p().sr().z(), "flex")) {
                    z3 = true;
                    break;
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (z3) {
            return true;
        }
        while (true) {
            boolean z4 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar : list) {
                if (TextUtils.equals(evVar.p().sr().z(), "auto") && (ia = evVar.ia()) != null) {
                    int i4 = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list2 : ia) {
                        i4++;
                        if (!w(list2)) {
                            break;
                        } else if (i4 == list2.size()) {
                            z4 = true;
                        }
                    }
                    continue;
                }
            }
            return z4;
        }
    }

    private String ux(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        return evVar.xv();
    }

    private xv w(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list, float f4, float f5) {
        xv c4 = c(list);
        if (c4 == null || (c4.f29322c == 0.0f && c4.f29323w == 0.0f)) {
            xv xv2 = xv(list, f4, f5);
            c(list, xv2);
            return xv2;
        }
        return c4;
    }

    private boolean w(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        if (evVar == null) {
            return false;
        }
        if (TextUtils.equals(evVar.p().sr().ck(), "flex")) {
            return true;
        }
        return xv(evVar);
    }

    private xv c(String str, C0437w c0437w, boolean z3, boolean z4, int i4, com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        return k.c(str, evVar.p().getType(), C0437w.c(c0437w).toString(), z3, z4, i4, evVar, this.ux, this.f29315f, this.f29316r, this.ev, this.gd);
    }

    private void c(List<List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>> list, float f4, float f5) {
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z3 = false;
        for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list2 : list) {
            if (c(list2, false)) {
                z3 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list3 : list) {
            c cVar = new c();
            boolean c4 = c(list3, !z3);
            cVar.f29318c = c4 ? 1.0f : w(list3, f4, f5).f29323w;
            cVar.f29319w = !c4;
            arrayList.add(cVar);
        }
        List<c> c5 = p.c(f5, arrayList);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (((c) arrayList.get(i4)).f29318c != c5.get(i4).f29318c) {
                List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list4 = list.get(i4);
                xv(list4);
                w(list4, f4, c5.get(i4).f29318c);
            }
        }
    }

    private void sr(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        this.f29314c.remove(ux(evVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>> ia = evVar.ia();
        if (ia == null || ia.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list : ia) {
            xv(list);
        }
    }

    private String sr(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size(); i4++) {
            String xv2 = list.get(i4).xv();
            if (i4 < list.size() - 1) {
                sb.append(xv2);
                sb.append("-");
            } else {
                sb.append(xv2);
            }
        }
        return sb.toString();
    }

    private boolean c(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list, boolean z3) {
        boolean z4;
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.xv.f sr = evVar.p().sr();
            String ck = sr.ck();
            if (TextUtils.equals(ck, "flex") || (z3 && ((TextUtils.equals(sr.z(), "flex") && TextUtils.equals(sr.ck(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.xv.ux.f29381c.get(evVar.p().getType()).intValue() == 7) || TextUtils.equals(ck, "flex")))) {
                z4 = true;
                break;
            }
        }
        z4 = false;
        if (z4) {
            return true;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2 : list) {
            if (xv(evVar2)) {
                return true;
            }
        }
        return false;
    }

    private boolean xv(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>> ia;
        if (!evVar.s() && TextUtils.equals(evVar.p().sr().ck(), "auto") && (ia = evVar.ia()) != null && ia.size() > 0) {
            if (ia.size() == 1) {
                for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2 : ia.get(0)) {
                    if (!w(evVar2)) {
                        return false;
                    }
                }
                return true;
            }
            for (List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list : ia) {
                if (c(list, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void c(List<c> list, float f4, List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list2) {
        float f5 = 0.0f;
        for (c cVar : list) {
            if (cVar.f29319w) {
                f5 += cVar.f29318c;
            }
        }
        if (f5 > f4) {
            int i4 = 0;
            for (int i5 = 0; i5 < list2.size(); i5++) {
                if (list.get(i5).f29319w && list2.get(i5).q()) {
                    i4++;
                }
            }
            if (i4 > 0) {
                float ceil = (float) (Math.ceil(((f5 - f4) / i4) * 1000.0f) / 1000.0d);
                for (int i6 = 0; i6 < list2.size(); i6++) {
                    c cVar2 = list.get(i6);
                    if (cVar2.f29319w && list2.get(i6).q()) {
                        cVar2.f29318c -= ceil;
                    }
                }
            }
        }
    }

    private void xv(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f29317w.remove(sr(list));
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar : list) {
            sr(evVar);
        }
    }

    public void c() {
        this.xv.clear();
        this.f29314c.clear();
        this.f29317w.clear();
    }

    public xv c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        return this.f29314c.get(ux(evVar));
    }

    public xv c(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list) {
        return this.f29317w.get(sr(list));
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar, xv xvVar) {
        this.f29314c.put(ux(evVar), xvVar);
    }

    private void c(List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> list, xv xvVar) {
        this.f29317w.put(sr(list), xvVar);
    }
}
