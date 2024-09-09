package com.bytedance.msdk.core.gd;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Long> f27983c;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Pair<String, String>> f27984w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static bk f27989c = new bk();
    }

    public boolean ev(String str) {
        r p3 = p(str);
        if (p3 == null || !p3.ev()) {
            return true;
        }
        for (ux uxVar : p3.k()) {
            Date date = new Date();
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + uxVar.sr());
            if (date.getTime() <= uxVar.sr()) {
                if (uxVar.ux() >= uxVar.c()) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "checkFreqctl \u5230\u4e86\u4e0a\u7ebf\u4e0d\u53ef\u4ee5\u5c55\u793a ruleId = " + uxVar.xv() + " count = " + uxVar.ux());
                    Map<String, Pair<String, String>> map = this.f27984w;
                    String xv = uxVar.xv();
                    map.put(str, new Pair<>(xv, uxVar.ux() + ""));
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "checkFreqctl \u672a\u5230\u4e0a\u7ebf\u53ef\u4ee5\u5c55\u793a ruleId = " + uxVar.xv() + " count = " + uxVar.ux());
            } else {
                c(p3, uxVar.xv(), 0);
                c(p3, uxVar.xv(), f.c(uxVar.w()));
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "checkFreqctl \u6709\u6548\u671f\u5916\u8ba1\u6570\u9700\u8981\u6e050\uff0c\u8fc7\u671f\u65f6\u95f4\u9700\u8981\u66f4\u65b0 = " + uxVar.xv());
            }
        }
        return true;
    }

    public Pair<String, String> f(String str) {
        return this.f27984w.get(str);
    }

    public void gd(String str) {
        ev.c().c(str);
    }

    public r p(String str) {
        return ev.c().w(str);
    }

    public void r(final String str) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.gd.bk.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + str);
                r p3 = bk.this.p(str);
                if (p3 == null || !p3.ev()) {
                    return;
                }
                for (ux uxVar : p3.k()) {
                    if (uxVar.ux() < uxVar.c()) {
                        bk.this.c(p3, uxVar.xv(), uxVar.ux() + 1);
                    }
                }
            }
        });
    }

    public void sr(String str) {
        p.c().c(str);
    }

    public gd ux(String str) {
        return p.c().w(str);
    }

    public void w() {
        this.f27984w = new ConcurrentHashMap();
        this.f27983c = new ConcurrentHashMap();
    }

    public boolean xv(String str) {
        gd ux = ux(str);
        if (ux != null && ux.ev() && ux.a()) {
            long time = new Date().getTime();
            long k4 = ux.k();
            long k5 = ux.k() + ux.gd();
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + f.w(time) + " showTime = " + f.w(k4) + " pacingBean.getPacing() = " + ux.gd() + " pacingTime = " + f.w(k5));
            if (time <= k5) {
                this.f27983c.put(str, Long.valueOf(time - k4));
                return false;
            }
        }
        return true;
    }

    private bk() {
        w();
    }

    public static bk c() {
        return c.f27989c;
    }

    public long c(String str) {
        Long l4 = this.f27983c.get(str);
        if (l4 == null) {
            return -2L;
        }
        return l4.longValue();
    }

    public void w(final String str) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.gd.bk.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + str);
                gd ux = bk.this.ux(str);
                if (ux == null || !ux.ev()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + f.w(date.getTime()));
                bk.this.c(str, date.getTime());
            }
        });
    }

    public void w(gd gdVar) {
        p.c().c(gdVar);
    }

    public boolean c(gd gdVar) {
        if (gdVar == null) {
            return false;
        }
        gd ux = ux(gdVar.w());
        if (ux == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "pacing \u89c4\u5219\u4e3a\u7a7a\u76f4\u63a5\u5b58\u50a8");
            return true;
        } else if (TextUtils.isEmpty(gdVar.p())) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "pacing ruleId \u4e3a\u7a7a \u6e05\u7a7a\u672c\u5730\u6570\u636e ");
            sr(gdVar.sr());
            return false;
        } else if (TextUtils.equals(ux.p(), gdVar.p())) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "pacing ruleId \u4e00\u81f4 ruleId = " + ux.p() + " \u65e0\u9700\u5904\u7406");
            return false;
        } else {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "pacing ruleId\u4e0d\u4e00\u81f4\uff0c\u7f13\u5b58\u65b0\u89c4\u5219 old ruleId = " + ux.p() + "  new ruleId = " + gdVar.p());
            StringBuilder sb = new StringBuilder();
            sb.append("pacing \u5220\u9664 ritId = ");
            sb.append(gdVar.sr());
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", sb.toString());
            sr(gdVar.sr());
            return true;
        }
    }

    public void w(r rVar) {
        ev.c().c(rVar);
    }

    public void c(String str, long j4) {
        p.c().c(str, j4);
    }

    public boolean c(r rVar) {
        if (rVar == null) {
            return false;
        }
        r p3 = p(rVar.w());
        if (p3 == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "freqctl \u89c4\u5219\u4e3a\u7a7a\u76f4\u63a5\u5b58\u50a8");
            return true;
        } else if (TextUtils.isEmpty(rVar.ux())) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "freqctl version \u4e3a\u7a7a \u6e05\u7a7a\u672c\u5730\u6570\u636e ");
            gd(p3.w());
            return false;
        } else if (TextUtils.equals(p3.ux(), rVar.ux())) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "freqctl version \u4e00\u81f4 version = " + p3.ux() + "\u65e0\u9700\u5904\u7406");
            return false;
        } else {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalShowControl", "freqctl version\u4e0d\u4e00\u81f4\uff0c\u7f13\u5b58\u65b0\u89c4\u5219 old version = " + p3.ux() + "  new version " + rVar.ux());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(r rVar, String str, int i4) {
        ev.c().c(rVar, str, i4);
    }

    private void c(r rVar, String str, long j4) {
        ev.c().c(rVar, str, j4);
    }
}
