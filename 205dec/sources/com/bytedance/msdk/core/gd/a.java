package com.bytedance.msdk.core.gd;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27978c = "TTMediationSDK_" + a.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Long> f27979w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static a f27982c = new a();
    }

    public void delete(String str, String str2) {
        p.c().c(str, str2);
    }

    public gd sr(String str, String str2) {
        return p.c().w(str, str2);
    }

    public boolean xv(String str, String str2) {
        String str3 = f27978c;
        com.bytedance.msdk.adapter.sr.xv.c(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        gd sr = sr(str, str2);
        if (sr != null && sr.ev() && sr.a()) {
            long time = new Date().getTime();
            long k4 = sr.k();
            long k5 = sr.k() + sr.gd();
            com.bytedance.msdk.adapter.sr.xv.c(str3, "adn checkPacing currentTime = " + f.w(time) + " showTime = " + f.w(k4) + " pacingBean.getPacing() = " + sr.gd() + " pacingTime = " + f.w(k5));
            if (time <= k5) {
                Map<String, Long> map = this.f27979w;
                map.put(str + "_" + str2, Long.valueOf(time - k4));
                return false;
            }
        }
        return true;
    }

    private a() {
        this.f27979w = new ConcurrentHashMap();
    }

    public static a c() {
        return c.f27982c;
    }

    public void w(final String str, final String str2) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.gd.a.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = a.f27978c;
                com.bytedance.msdk.adapter.sr.xv.c(str3, "adn updateShowPacingTime ritId = " + str + " adnSlotId = " + str2);
                gd sr = a.this.sr(str, str2);
                if (sr == null || !sr.ev()) {
                    return;
                }
                Date date = new Date();
                String str4 = a.f27978c;
                com.bytedance.msdk.adapter.sr.xv.c(str4, "adn updateShowPacingTime save time = " + f.w(date.getTime()));
                a.this.c(str, str2, date.getTime());
            }
        });
    }

    public long c(String str, String str2) {
        Map<String, Long> map = this.f27979w;
        Long l4 = map.get(str + "_" + str2);
        if (l4 == null) {
            return -2L;
        }
        return l4.longValue();
    }

    public void w(gd gdVar) {
        p.c().c(gdVar);
    }

    public boolean c(gd gdVar) {
        if (gdVar == null) {
            return false;
        }
        gd sr = sr(gdVar.w(), gdVar.xv());
        if (sr == null) {
            com.bytedance.msdk.adapter.sr.xv.c(f27978c, "adn pacing \u89c4\u5219\u4e3a\u7a7a\u76f4\u63a5\u5b58\u50a8");
            return true;
        } else if (TextUtils.isEmpty(gdVar.p())) {
            com.bytedance.msdk.adapter.sr.xv.c(f27978c, "adn pacing ruleId \u4e3a\u7a7a \u6e05\u7a7a\u672c\u5730\u6570\u636e ");
            delete(gdVar.w(), gdVar.xv());
            return false;
        } else if (TextUtils.equals(sr.p(), gdVar.p())) {
            String str = f27978c;
            com.bytedance.msdk.adapter.sr.xv.c(str, "adn pacing ruleId \u4e00\u81f4 ruleId = " + sr.p() + " \u65e0\u9700\u5904\u7406");
            return false;
        } else {
            String str2 = f27978c;
            com.bytedance.msdk.adapter.sr.xv.c(str2, "adn pacing ruleId\u4e0d\u4e00\u81f4\uff0c\u7f13\u5b58\u65b0\u89c4\u5219 old ruleId = " + sr.p() + "  new ruleId = " + gdVar.p());
            delete(gdVar.w(), gdVar.xv());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, long j4) {
        p.c().c(str, str2, j4);
    }
}
