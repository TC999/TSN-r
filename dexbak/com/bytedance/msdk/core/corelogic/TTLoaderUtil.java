package com.bytedance.msdk.core.corelogic;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdNetworkConfValue;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.MD5;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTSortUtil;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.TToast;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.bytedance.msdk.core.corelogic.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTLoaderUtil {

    /* renamed from: a */
    private static Comparator<TTBaseAd> f21817a = null;

    /* renamed from: b */
    private static String f21818b = "KEY_LOAD_SEQ";

    /* renamed from: c */
    private static String f21819c = "KEY_LOAD_SEQ_TIME";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTLoaderUtil.java */
    /* renamed from: com.bytedance.msdk.core.corelogic.f$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6050a implements Comparator<TTBaseAd> {
        C6050a() {
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
    /* renamed from: a */
    public static int m37322a() {
        long m59132a = SPUtils.m59131a((String) null, InternalContainer.m59945d()).m59132a(f21819c, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean m37311l = m37311l(new Date(m59132a), new Date(currentTimeMillis));
        SPUtils.m59131a((String) null, InternalContainer.m59945d()).m59124b(f21819c, currentTimeMillis);
        int m59133a = (m37311l ? SPUtils.m59131a((String) null, InternalContainer.m59945d()).m59133a(f21818b, 0) : 0) + 1;
        SPUtils.m59131a((String) null, InternalContainer.m59945d()).m59125b(f21818b, m59133a);
        return m59133a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static WaterFallConfig m37321b(AdSlot adSlot, int i, int i2) {
        WaterFallConfig waterFallConfig = new WaterFallConfig();
        waterFallConfig.m59481b("pangle");
        waterFallConfig.m59484a(adSlot.getAdUnitId());
        waterFallConfig.m59482b(0);
        waterFallConfig.m59478c("0");
        waterFallConfig.m59475d("1");
        waterFallConfig.m59470f(i);
        waterFallConfig.m59462i(i2);
        waterFallConfig.m59464h(adSlot.getAdType());
        waterFallConfig.m59472e("%1$s%2$sAdapter");
        return waterFallConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static WaterFallConfig m37320c(String str, String str2, int i, int i2) {
        WaterFallConfig waterFallConfig = new WaterFallConfig();
        waterFallConfig.m59481b(str2);
        waterFallConfig.m59484a(str);
        waterFallConfig.m59482b(0);
        waterFallConfig.m59478c("0");
        waterFallConfig.m59475d("1");
        waterFallConfig.m59470f(i);
        waterFallConfig.m59462i(i2);
        waterFallConfig.m59464h(3);
        waterFallConfig.m59472e("%1$s%2$sAdapter");
        return waterFallConfig;
    }

    /* renamed from: d */
    public static TTAbsAdLoaderAdapter m37319d(Map<String, TTAbsAdLoaderAdapter> map, WaterFallConfig waterFallConfig, String str) {
        String m59172a = MD5.m59172a(str + "_" + waterFallConfig.m59480c() + Math.abs(waterFallConfig.m59459l()) + Math.abs(waterFallConfig.m59452s()));
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = map != null ? map.get(m59172a) : null;
        if (tTAbsAdLoaderAdapter == null) {
            try {
                tTAbsAdLoaderAdapter = (TTAbsAdLoaderAdapter) Class.forName(str).newInstance();
                if (map != null) {
                    map.put(m59172a, tTAbsAdLoaderAdapter);
                }
            } catch (Exception e) {
                Logger.m37557e("TTMediationSDK", "创建广告网络adapter加载器失败：class=" + str + ",异常信息：" + e.toString());
                return null;
            }
        }
        return tTAbsAdLoaderAdapter;
    }

    /* renamed from: e */
    public static String m37318e(String str, String str2, String str3) {
        String format = String.format(str, str2, str3);
        return "com.bytedance.msdk.adapter." + C6031a.m37433e(str2) + "." + format;
    }

    /* renamed from: f */
    public static Map<String, Object> m37317f(WaterFallConfig waterFallConfig, AdSlot adSlot, Map<String, Object> map, ITTAdatperCallback iTTAdatperCallback, TTNetworkRequestInfo tTNetworkRequestInfo, int i, int i2) {
        HashMap hashMap = new HashMap();
        AdNetworkConfValue m59763a = InternalContainer.m59943f().m59763a(waterFallConfig.m59477d());
        if (m59763a != null) {
            hashMap.put("tt_ad_network_config_appid", m59763a.m59573a());
            hashMap.put("tt_ad_network_config_appKey", m59763a.m59572b());
        } else {
            String m59477d = waterFallConfig.m59477d();
            String m37434d = tTNetworkRequestInfo != null ? C6031a.m37434d(tTNetworkRequestInfo.getAdNetworkFlatFromId()) : null;
            if (tTNetworkRequestInfo != null && waterFallConfig.m59459l() == -4 && !TextUtils.isEmpty(m59477d) && m59477d.equals(m37434d)) {
                hashMap.put("tt_ad_network_config_appid", tTNetworkRequestInfo.getAppId());
                hashMap.put("tt_ad_network_config_appKey", tTNetworkRequestInfo.getAppKey());
            }
        }
        hashMap.put("tt_ad_network_callback", iTTAdatperCallback);
        hashMap.put("tt_ad_origin_type", Integer.valueOf(waterFallConfig.m59457n()));
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
        hashMap.put("key_mediation_rit_req_type", Integer.valueOf(i));
        hashMap.put("key_mediation_rit_req_type_src", Integer.valueOf(i2));
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static void m37316g(ExtraParam extraParam, TTBaseAd tTBaseAd) {
        if (InternalContainer.m59943f().m59722y() && extraParam != null && m37313j(tTBaseAd)) {
            TToast.show(InternalContainer.m59945d(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", extraParam.m59522c(), extraParam.m59520d()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static void m37315h(AdError adError, ExtraParam extraParam) {
        if (!InternalContainer.m59943f().m59722y() || adError == null || extraParam == null) {
            return;
        }
        if (20001 == adError.code) {
            TToast.show(InternalContainer.m59945d(), String.format("error_adn:%1$s no ads，please check ad network", extraParam.m59522c()));
        } else {
            TToast.show(InternalContainer.m59945d(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", extraParam.m59522c(), extraParam.m59520d(), Integer.valueOf(adError.thirdSdkErrorCode), adError.thirdSdkErrorMessage));
        }
    }

    /* renamed from: i */
    public static void m37314i(List<TTBaseAd> list, Comparator<TTBaseAd> comparator) {
        if (comparator == null) {
            TTSortUtil.m59090a(list);
        } else {
            TTSortUtil.m59089a(list, comparator);
        }
    }

    /* renamed from: j */
    private static boolean m37313j(TTBaseAd tTBaseAd) {
        if (tTBaseAd == null) {
            return false;
        }
        AdsenseRitConfig m59754b = InternalContainer.m59943f().m59754b(tTBaseAd.getRit());
        return InternalContainer.m59943f().m59744e(tTBaseAd.getRit()) && m59754b != null && m59754b.m59548f() != null && m59754b.m59548f().size() > 0 && m59754b.m59533r() != null && m59754b.m59533r().size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static boolean m37312k(String str) {
        return true;
    }

    /* renamed from: l */
    private static boolean m37311l(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static String m37310m(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    /* renamed from: n */
    public static Comparator<TTBaseAd> m37309n() {
        C6050a c6050a = new C6050a();
        f21817a = c6050a;
        return c6050a;
    }

    /* renamed from: o */
    public static void m37308o(TTBaseAd tTBaseAd) {
        if (InternalContainer.m59943f().m59722y() && tTBaseAd != null && m37313j(tTBaseAd)) {
            TToast.show(InternalContainer.m59945d(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()), tTBaseAd.getAdNetworkSlotId()));
        }
    }

    /* renamed from: p */
    public static Comparator<TTBaseAd> m37307p() {
        Comparator<TTBaseAd> comparator = f21817a;
        return comparator != null ? comparator : m37309n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static String m37306q() {
        return UUID.randomUUID().toString();
    }
}
