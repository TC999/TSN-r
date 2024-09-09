package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.bytedance.msdk.api.NetworkPlatformConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp {
    public static com.bytedance.msdk.api.xv c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, boolean z3) {
        if (uxVar == null) {
            return null;
        }
        com.bytedance.msdk.api.xv xvVar = new com.bytedance.msdk.api.xv();
        xvVar.c(uxVar.getAdNetworkPlatformId());
        xvVar.r(uxVar.getAdNetWorkName());
        xvVar.ev(uxVar.getCustomAdNetWorkName());
        xvVar.gd(uxVar.getAdNetworkSlotId());
        xvVar.k(uxVar.getLevelTag());
        if (z3) {
            if (!c() && (uxVar.isServerBiddingAd() || uxVar.isClientBiddingAd() || uxVar.isMultiBiddingAd())) {
                xvVar.p(NetworkPlatformConst.AD_NETWORK_NO_PERMISSION);
            } else {
                xvVar.p(uxVar.getNetWorkPlatFormCpm());
            }
        } else if (!w() && uxVar.isServerBiddingAd()) {
            xvVar.p(NetworkPlatformConst.AD_NETWORK_NO_PERMISSION);
        } else {
            xvVar.p(uxVar.getMultiCpm());
        }
        xvVar.bk(uxVar.getReqId());
        xvVar.w(uxVar.getAdNetworkSlotType());
        xvVar.a(uxVar.getErrorMsg());
        xvVar.c(c(wVar));
        xvVar.f(wVar != null ? wVar.i() : null);
        xvVar.ux(c(wVar != null ? wVar.up() : null));
        xvVar.w("" + wVar.mt());
        com.bytedance.msdk.api.sr.f ba = com.bytedance.msdk.core.w.k().ba();
        xvVar.xv(ba != null ? ba.xv() : null);
        xvVar.sr(ba != null ? ba.sr() : null);
        Map<String, Object> yu = wVar.yu();
        if (yu != null && !yu.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : yu.entrySet()) {
                Object value = entry.getValue();
                hashMap.put(entry.getKey(), value == null ? null : value.toString());
            }
            xvVar.c(hashMap);
        }
        return xvVar;
    }

    private static boolean w() {
        return com.bytedance.msdk.core.c.w().u();
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("experiment_detail_id");
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static String c(com.bytedance.msdk.api.c.w wVar) {
        if (wVar == null) {
            return null;
        }
        switch (wVar.fz()) {
            case 1:
                return "banner";
            case 2:
                return "interstitial";
            case 3:
                return "splash";
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return "feed";
            case 7:
                return "rewardVideo";
            case 8:
                return "fullVideo";
            case 9:
                return "draw";
            case 10:
                return "interstitialFull";
        }
    }

    private static boolean c() {
        return com.bytedance.msdk.core.c.w().s();
    }

    public static String c(com.bytedance.msdk.c.ux uxVar) {
        Map<String, Object> eventMap;
        if (uxVar != null && (eventMap = uxVar.getEventMap()) != null) {
            Object obj = eventMap.get("waterfall_abtest");
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public static boolean c(List<com.bytedance.msdk.c.ux> list, List<com.bytedance.msdk.c.ux> list2, List<com.bytedance.msdk.c.ux> list3, com.bytedance.msdk.api.c.w wVar, boolean z3, AtomicBoolean atomicBoolean, String str, int i4, List<com.bytedance.msdk.core.k.p> list4, String str2) {
        int w3 = com.bytedance.msdk.core.admanager.sr.w(str);
        com.bytedance.msdk.xv.r.c(list, list2, list3, wVar, str2, w3);
        if (!z3 && w3 == 0) {
            if (list.size() > 0) {
                for (com.bytedance.msdk.c.ux uxVar : list) {
                    if (uxVar != null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(str, uxVar.getAdNetworkSlotId()) + "isReady-\u300b\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar.getAdNetworkPlatformId()) + ",\u662f\u5426\u5df2\u51c6\u5907\u597d\uff1fisReady()\uff1a" + uxVar.isReady(str));
                        if (uxVar.isReady(str) && !uxVar.isHasShown()) {
                            return true;
                        }
                    }
                }
            }
            if (list3 != null && list3.size() > 0) {
                for (com.bytedance.msdk.c.ux uxVar2 : list3) {
                    if (uxVar2 != null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(str, uxVar2.getAdNetworkSlotId()) + "isReady-\u300b\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar2.getAdNetworkPlatformId()) + ",\u662f\u5426\u5df2\u51c6\u5907\u597d\uff1fisReady()\uff1a" + uxVar2.isReady(str));
                        if (uxVar2.isReady(str) && !uxVar2.isHasShown()) {
                            return true;
                        }
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (com.bytedance.msdk.c.ux uxVar3 : list2) {
                    if (uxVar3 != null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.w(str, uxVar3.getAdNetworkSlotId()) + "isReady--->biding-->\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(uxVar3.getAdNetworkPlatformId()) + ",\u662f\u5426\u5df2\u51c6\u5907\u597d\uff1fisReady()\uff1a" + uxVar3.isReady(str));
                        if (uxVar3.isReady(str) && !uxVar3.isHasShown()) {
                            return true;
                        }
                    }
                }
            }
            if (list4 != null && list4.size() > 0) {
                for (com.bytedance.msdk.core.k.p pVar : list4) {
                    String ia = pVar.ia();
                    if (pVar.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(str, ia, i4) && com.bytedance.msdk.core.ux.c.c.c().c(ia, wVar, false) == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
