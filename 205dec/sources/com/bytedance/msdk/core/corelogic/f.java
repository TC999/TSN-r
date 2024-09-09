package com.bytedance.msdk.core.corelogic;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.m;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.y;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.TToast;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: TTLoaderUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Comparator<TTBaseAd> f27907a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f27908b = "KEY_LOAD_SEQ";

    /* renamed from: c  reason: collision with root package name */
    private static String f27909c = "KEY_LOAD_SEQ_TIME";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTLoaderUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class a implements Comparator<TTBaseAd> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TTBaseAd tTBaseAd, TTBaseAd tTBaseAd2) {
            if (tTBaseAd.getCpm() > tTBaseAd2.getCpm()) {
                return -1;
            }
            if (tTBaseAd.getCpm() < tTBaseAd2.getCpm()) {
                return 1;
            }
            return (tTBaseAd.getCpm() == tTBaseAd2.getCpm() && tTBaseAd.getAdNetworkPlatformId() == 1) ? -1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        long a4 = r.a((String) null, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a(f27909c, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean l4 = l(new Date(a4), new Date(currentTimeMillis));
        r.a((String) null, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).b(f27909c, currentTimeMillis);
        int a5 = (l4 ? r.a((String) null, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a(f27908b, 0) : 0) + 1;
        r.a((String) null, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).b(f27908b, a5);
        return a5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h b(AdSlot adSlot, int i4, int i5) {
        h hVar = new h();
        hVar.b("pangle");
        hVar.a(adSlot.getAdUnitId());
        hVar.b(0);
        hVar.c("0");
        hVar.d("1");
        hVar.f(i4);
        hVar.i(i5);
        hVar.h(adSlot.getAdType());
        hVar.e("%1$s%2$sAdapter");
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h c(String str, String str2, int i4, int i5) {
        h hVar = new h();
        hVar.b(str2);
        hVar.a(str);
        hVar.b(0);
        hVar.c("0");
        hVar.d("1");
        hVar.f(i4);
        hVar.i(i5);
        hVar.h(3);
        hVar.e("%1$s%2$sAdapter");
        return hVar;
    }

    public static TTAbsAdLoaderAdapter d(Map<String, TTAbsAdLoaderAdapter> map, h hVar, String str) {
        String a4 = m.a(str + "_" + hVar.c() + Math.abs(hVar.l()) + Math.abs(hVar.s()));
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = map != null ? map.get(a4) : null;
        if (tTAbsAdLoaderAdapter == null) {
            try {
                tTAbsAdLoaderAdapter = (TTAbsAdLoaderAdapter) Class.forName(str).newInstance();
                if (map != null) {
                    map.put(a4, tTAbsAdLoaderAdapter);
                }
            } catch (Exception e4) {
                Logger.e("TTMediationSDK", "\u521b\u5efa\u5e7f\u544a\u7f51\u7edcadapter\u52a0\u8f7d\u5668\u5931\u8d25\uff1aclass=" + str + ",\u5f02\u5e38\u4fe1\u606f\uff1a" + e4.toString());
                return null;
            }
        }
        return tTAbsAdLoaderAdapter;
    }

    public static String e(String str, String str2, String str3) {
        String format = String.format(str, str2, str3);
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.base.a.e(str2) + "." + format;
    }

    public static Map<String, Object> f(h hVar, AdSlot adSlot, Map<String, Object> map, ITTAdatperCallback iTTAdatperCallback, TTNetworkRequestInfo tTNetworkRequestInfo, int i4, int i5) {
        HashMap hashMap = new HashMap();
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a(hVar.d());
        if (a4 != null) {
            hashMap.put("tt_ad_network_config_appid", a4.a());
            hashMap.put("tt_ad_network_config_appKey", a4.b());
        } else {
            String d4 = hVar.d();
            String d5 = tTNetworkRequestInfo != null ? com.bytedance.msdk.base.a.d(tTNetworkRequestInfo.getAdNetworkFlatFromId()) : null;
            if (tTNetworkRequestInfo != null && hVar.l() == -4 && !TextUtils.isEmpty(d4) && d4.equals(d5)) {
                hashMap.put("tt_ad_network_config_appid", tTNetworkRequestInfo.getAppId());
                hashMap.put("tt_ad_network_config_appKey", tTNetworkRequestInfo.getAppKey());
            }
        }
        hashMap.put("tt_ad_network_callback", iTTAdatperCallback);
        hashMap.put("tt_ad_origin_type", Integer.valueOf(hVar.n()));
        if (adSlot != null) {
            TTRequestExtraParams reuestParam = adSlot.getReuestParam();
            if (reuestParam != null) {
                hashMap.putAll(reuestParam.getExtraObject());
            }
            int imgAcceptedWidth = adSlot.getImgAcceptedWidth();
            int imgAcceptedHeight = adSlot.getImgAcceptedHeight();
            if (imgAcceptedWidth < 0) {
                imgAcceptedWidth = 0;
            }
            if (imgAcceptedHeight < 0) {
                imgAcceptedHeight = 0;
            }
            hashMap.put(TTRequestExtraParams.PARAM_AD_HEIGHT, Integer.valueOf(imgAcceptedHeight));
            hashMap.put(TTRequestExtraParams.PARAM_AD_WIDTH, Integer.valueOf(imgAcceptedWidth));
            hashMap.put("ad_type", Integer.valueOf(adSlot.getAdType()));
        }
        hashMap.put("key_mediation_rit_req_type", Integer.valueOf(i4));
        hashMap.put("key_mediation_rit_req_type_src", Integer.valueOf(i5));
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar, TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().y() && dVar != null && j(tTBaseAd)) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", dVar.c(), dVar.d()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(AdError adError, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        if (!bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().y() || adError == null || dVar == null) {
            return;
        }
        if (20001 == adError.code) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), String.format("error_adn:%1$s no ads\uff0cplease check ad network", dVar.c()));
        } else {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", dVar.c(), dVar.d(), Integer.valueOf(adError.thirdSdkErrorCode), adError.thirdSdkErrorMessage));
        }
    }

    public static void i(List<TTBaseAd> list, Comparator<TTBaseAd> comparator) {
        if (comparator == null) {
            y.a(list);
        } else {
            y.a(list, comparator);
        }
    }

    private static boolean j(TTBaseAd tTBaseAd) {
        if (tTBaseAd == null) {
            return false;
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c b4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().b(tTBaseAd.getRit());
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().e(tTBaseAd.getRit()) && b4 != null && b4.f() != null && b4.f().size() > 0 && b4.r() != null && b4.r().size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(String str) {
        return true;
    }

    private static boolean l(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static Comparator<TTBaseAd> n() {
        a aVar = new a();
        f27907a = aVar;
        return aVar;
    }

    public static void o(TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().y() && tTBaseAd != null && j(tTBaseAd)) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()), tTBaseAd.getAdNetworkSlotId()));
        }
    }

    public static Comparator<TTBaseAd> p() {
        Comparator<TTBaseAd> comparator = f27907a;
        return comparator != null ? comparator : n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q() {
        return UUID.randomUUID().toString();
    }
}
