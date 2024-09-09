package com.bytedance.msdk.core.sr;

import android.text.TextUtils;
import com.bytedance.msdk.core.k.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, C0419c> f28170c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.sr.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0419c {

        /* renamed from: c  reason: collision with root package name */
        String f28171c;
        Map<String, String> sr;

        /* renamed from: w  reason: collision with root package name */
        String f28172w;
        double xv;

        public C0419c(String str, String str2, double d4, Map<String, String> map) {
            this.f28171c = str2;
            this.xv = d4;
            this.sr = map;
            this.f28172w = str;
        }
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, p pVar, Map<String, Object> map) {
        C0419c c0419c;
        if (wVar == null || pVar == null || map == null || !pVar.y() || !"baidu".equals(pVar.t()) || (c0419c = f28170c.get(wVar.u())) == null) {
            return;
        }
        map.put("bidding_win_adn", c0419c.f28171c);
        map.put("bidding_win_price", Double.valueOf(c0419c.xv));
        Boolean valueOf = Boolean.valueOf(com.bytedance.msdk.core.c.w().bm());
        map.put(MediationConstant.BIDDING_IS_OPEN_ECPM, valueOf);
        if (valueOf.booleanValue()) {
            map.put(MediationConstant.BIDDING_REQUEST_ID_MAP, c0419c.sr);
            map.put(MediationConstant.BIDDING_WIN_ADN_ID, c0419c.f28172w);
        }
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.w wVar2, List<com.bytedance.msdk.c.ux> list, List<com.bytedance.msdk.c.ux> list2) {
        HashMap hashMap;
        com.bytedance.msdk.c.ux uxVar;
        if (wVar == null || wVar2 == null || list == null || list.size() == 0 || !wVar.xk() || !c(wVar2)) {
            return;
        }
        Iterator<com.bytedance.msdk.c.ux> it = list.iterator();
        while (true) {
            hashMap = null;
            if (!it.hasNext()) {
                uxVar = null;
                break;
            }
            uxVar = it.next();
            if (uxVar != null && "baidu".equals(uxVar.getAdNetWorkName())) {
                break;
            }
        }
        if (uxVar == null) {
            uxVar = list.get(0);
        }
        if (uxVar != null) {
            if (com.bytedance.msdk.core.c.w().bm() && (list2 != null || list2.size() != 0)) {
                hashMap = new HashMap();
                for (com.bytedance.msdk.c.ux uxVar2 : list2) {
                    hashMap.put(uxVar2.getAdNetworkSlotId(), uxVar2.getReqId());
                }
            }
            f28170c.put(wVar2.xk(), new C0419c(uxVar.getAdNetworkSlotId(), uxVar.getAdNetWorkName(), uxVar.getCpm(), hashMap));
        }
    }

    private static boolean c(com.bytedance.msdk.core.k.w wVar) {
        if (wVar != null) {
            for (p pVar : wVar.up()) {
                if (TextUtils.equals(pVar.t(), "baidu") && pVar.y()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
