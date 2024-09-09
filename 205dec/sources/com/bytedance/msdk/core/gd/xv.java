package com.bytedance.msdk.core.gd;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, w> f28018c;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.gd.c>> f28019w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static xv f28020c = new xv();
    }

    public static xv c() {
        return c.f28020c;
    }

    private xv() {
        this.f28019w = new ConcurrentHashMap();
    }

    public void c(ConcurrentHashMap<String, w> concurrentHashMap) {
        this.f28018c = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "mAdnControlMap = " + concurrentHashMap);
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
    }

    public void c(String str, String str2, String str3) {
        boolean z3;
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, w> map = this.f28018c;
        w wVar = map != null ? map.get(str) : null;
        if (wVar != null) {
            for (String str4 : wVar.w()) {
                if (TextUtils.equals(str4, str3)) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "setAdnError \u547d\u4e2derrorCode = " + str4);
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            long time = new Date().getTime() + wVar.c();
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "setAdnError \u66f4\u65b0\u65f6\u95f4 = " + f.w(time));
            com.bytedance.msdk.core.gd.c cVar = new com.bytedance.msdk.core.gd.c(str, str2, time);
            if (this.f28019w != null) {
                ConcurrentHashMap<String, com.bytedance.msdk.core.gd.c> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, cVar);
                this.f28019w.put(str, concurrentHashMap);
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.f28019w);
            }
        }
    }

    public boolean c(String str, String str2) {
        com.bytedance.msdk.core.gd.c cVar;
        ConcurrentHashMap<String, com.bytedance.msdk.core.gd.c> concurrentHashMap;
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.gd.c>> map = this.f28019w;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            cVar = null;
        } else {
            cVar = concurrentHashMap.get(str2);
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "checkLoad \u53d6\u51fa\u7684showBean = " + cVar);
        }
        if (cVar == null || cVar.c() == 0) {
            return true;
        }
        long time = new Date().getTime();
        if (time <= cVar.c()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "checkLoad \u5f53\u524d\u65f6\u95f4 = " + f.w(time));
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_AdnShowControl", "checkLoad \u89c4\u5219\u6709\u6548\u65f6\u95f4 = " + f.w(cVar.c()));
            return false;
        }
        return true;
    }
}
