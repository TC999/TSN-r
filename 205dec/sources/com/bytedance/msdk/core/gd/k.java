package com.bytedance.msdk.core.gd;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27997c = "TTMediationSDK_" + k.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Pair<String, String>> f27998w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static k f28001c = new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r sr(String str, String str2) {
        return ev.c().w(str, str2);
    }

    public void delete(String str, String str2) {
        ev.c().c(str, str2);
    }

    public boolean xv(String str, String str2) {
        String str3 = f27997c;
        com.bytedance.msdk.adapter.sr.xv.c(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        r sr = sr(str, str2);
        if (sr == null || !sr.ev()) {
            return true;
        }
        for (ux uxVar : sr.k()) {
            Date date = new Date();
            String str4 = f27997c;
            com.bytedance.msdk.adapter.sr.xv.c(str4, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + uxVar.sr());
            if (date.getTime() <= uxVar.sr()) {
                if (uxVar.ux() >= uxVar.c()) {
                    com.bytedance.msdk.adapter.sr.xv.c(str4, "adn checkFreqctl \u5230\u4e86\u4e0a\u7ebf\u4e0d\u53ef\u4ee5\u5c55\u793a ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + uxVar.xv() + " count = " + uxVar.ux());
                    Map<String, Pair<String, String>> map = this.f27998w;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("_");
                    sb.append(str2);
                    String sb2 = sb.toString();
                    String xv = uxVar.xv();
                    map.put(sb2, new Pair<>(xv, uxVar.ux() + ""));
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c(str4, "adn checkFreqctl \u672a\u5230\u4e0a\u7ebf\u53ef\u4ee5\u5c55\u793a ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + uxVar.xv() + " count = " + uxVar.ux());
            } else {
                c(sr, uxVar.xv(), 0);
                c(sr, uxVar.xv(), f.c(uxVar.w()));
                com.bytedance.msdk.adapter.sr.xv.c(str4, "adn checkFreqctl \u6709\u6548\u671f\u5916\u8ba1\u6570\u9700\u8981\u6e050\uff0c\u8fc7\u671f\u65f6\u95f4\u9700\u8981\u66f4\u65b0 = " + uxVar.xv());
            }
        }
        return true;
    }

    private k() {
        this.f27998w = new ConcurrentHashMap();
    }

    public void w(final String str, final String str2) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.gd.k.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = k.f27997c;
                com.bytedance.msdk.adapter.sr.xv.c(str3, "adn addShowFreqctlCount ritId = " + str + " adnSlotId = " + str2);
                r sr = k.this.sr(str, str2);
                if (sr == null || !sr.ev()) {
                    return;
                }
                for (ux uxVar : sr.k()) {
                    if (uxVar.ux() < uxVar.c()) {
                        k.this.c(sr, uxVar.xv(), uxVar.ux() + 1);
                    }
                }
            }
        });
    }

    public static k c() {
        return c.f28001c;
    }

    public void w(r rVar) {
        bk.c().w(rVar);
    }

    public Pair<String, String> c(String str, String str2) {
        Map<String, Pair<String, String>> map = this.f27998w;
        return map.get(str + "_" + str2);
    }

    public boolean c(r rVar) {
        if (rVar == null) {
            return false;
        }
        r sr = sr(rVar.w(), rVar.xv());
        if (sr == null) {
            com.bytedance.msdk.adapter.sr.xv.c(f27997c, "adn freqctl \u89c4\u5219\u4e3a\u7a7a\u76f4\u63a5\u5b58\u50a8");
            return true;
        } else if (TextUtils.isEmpty(rVar.f())) {
            com.bytedance.msdk.adapter.sr.xv.c(f27997c, "adn freqctl version \u4e3a\u7a7a \u6e05\u7a7a\u672c\u5730\u6570\u636e ");
            delete(sr.w(), sr.xv());
            return false;
        } else if (TextUtils.equals(sr.f(), rVar.f())) {
            String str = f27997c;
            com.bytedance.msdk.adapter.sr.xv.c(str, "adn freqctl version \u4e00\u81f4 version = " + sr.f() + " \u65e0\u9700\u5904\u7406");
            return false;
        } else {
            String str2 = f27997c;
            com.bytedance.msdk.adapter.sr.xv.c(str2, "adn freqctl version\u4e0d\u4e00\u81f4\uff0c\u7f13\u5b58\u65b0\u89c4\u5219 old version = " + sr.f() + "  new version " + rVar.f());
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
