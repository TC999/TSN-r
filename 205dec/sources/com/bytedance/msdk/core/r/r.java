package com.bytedance.msdk.core.r;

import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleDrawLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleFullVideoLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleInterstitialLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleNativeLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleRewardLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleSplashLoader;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.core.c.gd;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.bw;
import com.bytedance.msdk.f.wv;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static Comparator<com.bytedance.msdk.c.ux> f28101c = null;

    /* renamed from: w  reason: collision with root package name */
    private static String f28102w = "KEY_LOAD_SEQ";
    private static String xv = "KEY_LOAD_SEQ_TIME";

    public static Comparator<com.bytedance.msdk.c.ux> c() {
        Comparator<com.bytedance.msdk.c.ux> comparator = f28101c;
        return comparator != null ? comparator : w();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b3, code lost:
        if (r2 == 2) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String f(com.bytedance.msdk.core.k.p r10) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.r.r.f(com.bytedance.msdk.core.k.p):java.lang.String");
    }

    private static com.bytedance.msdk.adapter.c sr(p pVar) {
        if (pVar != null) {
            int ux = pVar.ux();
            switch (pVar.a()) {
                case 1:
                    return new PangleBannerLoader();
                case 2:
                    return new PangleInterstitialLoader();
                case 3:
                    return new PangleSplashLoader();
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    return new PangleNativeLoader();
                case 7:
                    if (ux == 6) {
                        return new PangleRewardLoader();
                    }
                    if (ux == 7) {
                        return new PangleFullVideoLoader();
                    }
                    return new PangleRewardLoader();
                case 8:
                    return new PangleFullVideoLoader();
                case 9:
                    return new PangleDrawLoader();
                case 10:
                    if (ux == 1) {
                        return new PangleInterstitialLoader();
                    }
                    if (ux == 2) {
                        return new PangleFullVideoLoader();
                    }
                    return null;
            }
        }
        return null;
    }

    private static com.bytedance.msdk.adapter.c ux(p pVar) {
        return new gd(f(pVar));
    }

    public static Comparator<com.bytedance.msdk.c.ux> w() {
        Comparator<com.bytedance.msdk.c.ux> comparator = new Comparator<com.bytedance.msdk.c.ux>() { // from class: com.bytedance.msdk.core.r.r.1
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.c.ux uxVar2) {
                if (uxVar.getCpm() > uxVar2.getCpm()) {
                    return -1;
                }
                if (uxVar.getCpm() < uxVar2.getCpm()) {
                    return 1;
                }
                return (uxVar.getCpm() == uxVar2.getCpm() && uxVar.getAdNetworkPlatformId() == 1) ? -1 : 0;
            }
        };
        f28101c = comparator;
        return comparator;
    }

    public static boolean w(String str) {
        return true;
    }

    private static boolean xv(p pVar) {
        if (pVar == null || !TextUtils.equals(pVar.t(), "pangle")) {
            if (pVar != null) {
                Bridge f4 = com.bytedance.msdk.core.bk.c.c().f();
                if (f4 != null) {
                    String f5 = f(pVar);
                    if (TextUtils.isEmpty(f5)) {
                        return false;
                    }
                    b a4 = b.a();
                    a4.i(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, f5);
                    return ((Boolean) f4.call(8229, a4.l(), Boolean.class)).booleanValue();
                }
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "load ad check class loader is null ");
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ux() {
        if (com.bytedance.msdk.core.c.w().wx()) {
            com.bytedance.msdk.api.sr.c(com.bytedance.msdk.core.c.getContext(), "slot setting error");
        }
    }

    public static com.bytedance.msdk.adapter.c w(p pVar) {
        if (pVar != null) {
            return ux(pVar);
        }
        return null;
    }

    public static void c(List<com.bytedance.msdk.c.ux> list, Comparator<com.bytedance.msdk.c.ux> comparator) {
        if (comparator == null) {
            bw.c(list);
        } else {
            bw.c(list, comparator);
        }
    }

    private static boolean w(String str, com.bytedance.msdk.c.ux uxVar) {
        if (uxVar == null) {
            return false;
        }
        com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.core.c.w().c(str, uxVar.getAdType(), 101);
        return com.bytedance.msdk.core.c.w().w(str, uxVar.getAdType()) && c4 != null && c4.wv() != null && c4.wv().size() > 0 && c4.n() != null && c4.n().size() > 0;
    }

    public static String c(String str, String str2, String str3) {
        if (TextUtils.equals("pangle", com.bytedance.msdk.c.c.c(str2)) && com.bytedance.msdk.core.w.k().wx()) {
            String format = String.format(str, "PangleCustom", str3);
            return "com.bytedance.msdk.adapter.panglecustom." + format;
        }
        String format2 = String.format(str, str2, str3);
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.c.c.c(str2) + "." + format2;
    }

    public static String xv() {
        return UUID.randomUUID().toString();
    }

    public static com.bytedance.msdk.adapter.c c(p pVar) {
        if (pVar != null && pVar.t().equals("pangle")) {
            return sr(pVar);
        }
        if (xv(pVar)) {
            return w(pVar);
        }
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "getAndCheckTTAbsAdLoaderAdapter fail");
        return null;
    }

    public static int sr() {
        long w3 = wv.c((String) null, com.bytedance.msdk.core.c.getContext()).w(xv, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean c4 = c(new Date(w3), new Date(currentTimeMillis));
        wv.c((String) null, com.bytedance.msdk.core.c.getContext()).c(xv, currentTimeMillis);
        int w4 = (c4 ? wv.c((String) null, com.bytedance.msdk.core.c.getContext()).w(f28102w, 0) : 0) + 1;
        wv.c((String) null, com.bytedance.msdk.core.c.getContext()).c(f28102w, w4);
        return w4;
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static Map<String, Object> c(p pVar, com.bytedance.msdk.api.c.w wVar, Map<String, Object> map, com.bytedance.msdk.api.sr.p pVar2, int i4, int i5, boolean z3, long j4) {
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.k.c c4 = com.bytedance.msdk.core.c.w().c(pVar.t());
        if (c4 != null) {
            hashMap.put("tt_ad_network_config_appid", c4.c());
            hashMap.put("tt_ad_network_config_appKey", c4.w());
        } else {
            String t3 = pVar.t();
            String c5 = pVar2 != null ? com.bytedance.msdk.c.c.c(pVar2.c()) : null;
            if (pVar2 != null && pVar.j() == -4 && !TextUtils.isEmpty(t3) && t3.equals(c5)) {
                hashMap.put("tt_ad_network_config_appid", pVar2.xv());
                hashMap.put("tt_ad_network_config_appKey", pVar2.sr());
            }
        }
        hashMap.put("tt_ad_origin_type", Integer.valueOf(pVar.gd()));
        hashMap.put("tt_ad_sub_type", Integer.valueOf(pVar.ux()));
        if (wVar != null) {
            if (wVar.yu() != null) {
                hashMap.putAll(wVar.yu());
            }
            int q3 = wVar.q();
            int j5 = wVar.j();
            if (q3 < 0) {
                q3 = 0;
            }
            if (j5 < 0) {
                j5 = 0;
            }
            hashMap.put(TTRequestExtraParams.PARAM_AD_HEIGHT, Integer.valueOf(j5));
            hashMap.put(TTRequestExtraParams.PARAM_AD_WIDTH, Integer.valueOf(q3));
            hashMap.put("ad_type", Integer.valueOf(wVar.fz()));
        }
        hashMap.put("key_mediation_rit_req_type", Integer.valueOf(i4));
        hashMap.put("key_mediation_rit_req_type_src", Integer.valueOf(i5));
        hashMap.put("key_is_from_developer_req", Boolean.valueOf(z3));
        hashMap.put("key_requestwfb_ms", Long.valueOf(j4));
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p c(String str, String str2, int i4, int i5) {
        p pVar = new p();
        pVar.xv(str2);
        pVar.ux(str);
        pVar.gd(0);
        pVar.f("0");
        pVar.w("1");
        pVar.p(i4);
        pVar.k(i5);
        pVar.ev(3);
        pVar.c("%1$s%2$sAdapter");
        return pVar;
    }

    private static boolean c(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        if (!com.bytedance.msdk.core.c.w().wx() || cVar == null || xvVar == null) {
            return;
        }
        if (820001 == cVar.f27444c) {
            com.bytedance.msdk.api.sr.c(com.bytedance.msdk.core.c.getContext(), String.format("error_adn:%1$s no ads\uff0cplease check ad network", xvVar.k()));
        } else {
            com.bytedance.msdk.api.sr.c(com.bytedance.msdk.core.c.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", xvVar.k(), xvVar.bk(), Integer.valueOf(cVar.xv), cVar.sr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, com.bytedance.msdk.core.k.xv xvVar, com.bytedance.msdk.c.ux uxVar) {
        if (com.bytedance.msdk.core.c.w().wx() && xvVar != null && w(str, uxVar)) {
            com.bytedance.msdk.api.sr.c(com.bytedance.msdk.core.c.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", xvVar.k(), xvVar.bk()));
        }
    }

    public static void c(String str, com.bytedance.msdk.c.ux uxVar) {
        if (com.bytedance.msdk.core.c.w().wx() && uxVar != null && w(str, uxVar)) {
            com.bytedance.msdk.api.sr.c(com.bytedance.msdk.core.c.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()), uxVar.getAdNetworkSlotId()));
        }
    }
}
