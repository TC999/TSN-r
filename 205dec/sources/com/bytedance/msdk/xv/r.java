package com.bytedance.msdk.xv;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.wv;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static int f28494c;

    /* renamed from: w  reason: collision with root package name */
    private static int f28495w;
    private static int xv;

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, int i4, String str, long j4, int i5, int i6, String str2) {
        com.bytedance.msdk.core.fp.xv w3;
        com.bytedance.msdk.core.k.w c4;
        sr w4 = sr.w();
        w4.c("media_reward_verify").c("adn_preload", Integer.valueOf((uxVar == null || !uxVar.isAdnPreload()) ? 0 : 1)).c("reason", Integer.valueOf(i5)).c("play_again", Integer.valueOf(i4));
        if (i6 != 0 && i6 != 20000) {
            w4.w(i6).p(str2);
        }
        HashMap hashMap = new HashMap();
        boolean z3 = j4 >= 0;
        if (uxVar != null && uxVar.isCustomAd()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(i.c()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z3));
            if (z3) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j4));
            }
        }
        if (wVar != null && (w3 = com.bytedance.msdk.core.c.w()) != null && (c4 = w3.c(wVar.u(), wVar.fz(), 101)) != null) {
            hashMap.put("reward_callback_type", Integer.valueOf(c4.gw()));
            hashMap.put("reward_start_time", Integer.valueOf(c4.m()));
        }
        if (str != null) {
            w4.c("sub_adn_name", str);
        }
        c(w4, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w4, hashMap);
    }

    public static void w(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, int i4, String str, long j4, boolean z3) {
        w(uxVar, wVar, i4, str, j4, null, z3);
    }

    public static void w(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, int i4, String str, long j4, String str2, boolean z3) {
        sr w3 = sr.w();
        w3.c("media_click_listen").c("adn_preload", Integer.valueOf((uxVar == null || !uxVar.isAdnPreload()) ? 0 : 1)).c("play_again", Integer.valueOf(i4)).c("is_repeat", Integer.valueOf(z3 ? 1 : 0));
        if (str != null) {
            w3.c("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            w3.c("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z4 = j4 >= 0;
        if (uxVar != null && uxVar.isCustomAd()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(i.c()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z4));
            if (z4) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j4));
            }
        }
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void w(com.bytedance.msdk.api.c.w wVar, int i4) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, i4);
    }

    public static void w() {
        sr w3 = sr.w();
        w3.c("start_up");
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, (Map<String, Object>) null);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, int i4, String str, long j4, boolean z3) {
        c(uxVar, wVar, i4, str, j4, (String) null, z3);
    }

    public static void c() {
        sr w3 = sr.w();
        w3.c("mediation_sdk_init");
        HashMap hashMap = new HashMap();
        hashMap.put("call_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.f.f31256c));
        hashMap.put("call_init_csj_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.f.f31257w));
        hashMap.put("call_init_csj_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.f.xv));
        hashMap.put("call_init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.f.f31257w - com.bytedance.sdk.gromore.init.f.f31256c));
        hashMap.put("init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.f.xv - com.bytedance.sdk.gromore.init.f.f31257w));
        hashMap.put("call_init_gromore_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.f.sr));
        hashMap.put("call_init_gromore_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.f.ux));
        hashMap.put("call_init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.f.sr - com.bytedance.sdk.gromore.init.f.f31256c));
        hashMap.put("init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.f.ux - com.bytedance.sdk.gromore.init.f.sr));
        hashMap.put("init_total_duration", Long.valueOf(com.bytedance.sdk.gromore.init.f.ux - com.bytedance.sdk.gromore.init.f.f31256c));
        c(w3, (com.bytedance.msdk.api.c.w) null, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void w(long j4) {
        sr w3 = sr.w();
        w3.c("sdk_backstage").c(j4);
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.ux.c.c.p().xv(hashMap);
        hashMap.put(EventMonitor.V3_STAGING_ADLOG, wv.r(EventMonitor.V3_STAGING_ADLOG));
        hashMap.put(EventMonitor.V1_STAGING_ADLOG, wv.r(EventMonitor.V1_STAGING_ADLOG));
        hashMap.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.c.w().eq() ? 1 : 0));
        hashMap.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.w.k().c() ? 1 : 0));
        JSONArray sr = wv.sr();
        if (sr != null) {
            Log.d("TMe", "--==-- v3bug size: " + sr.length());
            hashMap.put("sp_v3_bug", sr);
        }
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void w(com.bytedance.msdk.api.c.w wVar, String str) {
        sr w3 = sr.w();
        w3.c("mt_ra_cc").c("waterfall_abtest", str);
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, int i4, String str, long j4, String str2, boolean z3) {
        sr w3 = sr.w();
        w3.c("media_show_listen").c("adn_preload", Integer.valueOf((uxVar == null || !uxVar.isAdnPreload()) ? 0 : 1)).c("play_again", Integer.valueOf(i4)).c("is_repeat", Integer.valueOf(z3 ? 1 : 0));
        if (str != null) {
            w3.c("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            w3.c("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.c.w().eq() ? 1 : 0));
        hashMap.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.w.k().c() ? 1 : 0));
        com.bytedance.msdk.core.w.xv.c(uxVar, wVar, hashMap);
        boolean z4 = j4 >= 0;
        if (uxVar != null && uxVar.isCustomAd()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(i.c()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z4));
            if (z4) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j4));
            }
        }
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, String str) {
        sr w3 = sr.w();
        w3.c("media_show_dislike").p(str);
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, boolean z3, int i4) {
        sr w3 = sr.w();
        w3.c("media_show").c("adn_preload", Integer.valueOf((uxVar == null || !uxVar.isAdnPreload()) ? 0 : 1)).c("play_again", Integer.valueOf(i4)).c("is_repeat", Integer.valueOf(z3 ? 1 : 0));
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(List<com.bytedance.msdk.c.ux> list, List<com.bytedance.msdk.c.ux> list2, List<com.bytedance.msdk.c.ux> list3, com.bytedance.msdk.api.c.w wVar, String str, int i4) {
        boolean z3;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i5 = 0;
        com.bytedance.msdk.c.ux uxVar = arrayList.size() > 0 ? (com.bytedance.msdk.c.ux) arrayList.get(0) : null;
        sr w3 = sr.w();
        w3.c("media_show_is_ready").c("waterfall_abtest", str);
        if (i4 == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                loop0: while (true) {
                    z3 = false;
                    while (it.hasNext()) {
                        com.bytedance.msdk.c.ux uxVar2 = (com.bytedance.msdk.c.ux) it.next();
                        if (uxVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", uxVar2.getAdNetWorkName());
                            jSONObject.put("type", com.bytedance.msdk.c.c.c(uxVar2.getAdType(), uxVar2.getSubAdType()));
                            jSONObject.put("adnSlotId", uxVar2.getAdNetworkSlotId());
                            jSONObject.put("loadSort", uxVar2.getLoadSort());
                            jSONObject.put("showSort", uxVar2.getShowSort());
                            if (wVar != null) {
                                jSONObject.put("isReady", uxVar2.isReady(wVar.u()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", uxVar2.isHasShown() ? 1 : 0);
                            if (uxVar2.adnHasAdVideoCachedApi()) {
                                jSONObject.put("is_video_cache_success", uxVar2.isCacheSuccess() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", uxVar2.getMediationRitReqType(wVar != null ? wVar.c() : null));
                            jSONObject.put("mediationrit_req_type_src", uxVar2.getMediationRitReqTypeSrc(wVar != null ? wVar.c() : null));
                            jSONArray.put(jSONObject);
                            if (!z3 && wVar != null) {
                                if (wVar.fz() == 5) {
                                    z3 = uxVar2.isReady(wVar.u());
                                } else if (uxVar2.isReady(wVar.u()) && !uxVar2.isHasShown()) {
                                    z3 = true;
                                }
                            }
                        }
                    }
                    break loop0;
                }
                if (!z3) {
                    i5 = -1;
                }
                w3.w(i5);
                w3.p(jSONArray.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        } else {
            w3.w(2);
            w3.p(com.bytedance.msdk.api.c.c(i4));
        }
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.api.c.w wVar, int i4) {
        com.bytedance.msdk.c.ux uxVar = (list == null || list.size() <= 0) ? null : list.get(0);
        sr w3 = sr.w();
        w3.c("media_show_fail");
        if (i4 == 0) {
            w3.w(AdError.ERROR_CODE_SHOW_FAIL_NO_AD);
            if (uxVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.msdk.c.ux uxVar2 : list) {
                        if (uxVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", uxVar2.getAdNetWorkName());
                            jSONObject.put("type", com.bytedance.msdk.c.c.c(uxVar2.getAdType(), uxVar2.getSubAdType()));
                            jSONObject.put("adnSlotId", uxVar2.getAdNetworkSlotId());
                            jSONObject.put("loadSort", uxVar2.getLoadSort());
                            jSONObject.put("showSort", uxVar2.getShowSort());
                            int i5 = 1;
                            if (wVar != null) {
                                jSONObject.put("isReady", uxVar2.isReady(wVar.u()) ? 1 : 0);
                            }
                            if (!uxVar2.isHasShown()) {
                                i5 = 0;
                            }
                            jSONObject.put("hasShown", i5);
                            jSONArray.put(jSONObject);
                        }
                    }
                    w3.p(jSONArray.toString());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        } else {
            w3.w(i4);
            w3.p(com.bytedance.msdk.api.c.c(i4));
        }
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        w3.c("is_video_cache_success", 0);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, int i4) {
        sr w3 = sr.w();
        w3.c("media_carousel_fail").w(i4).p(com.bytedance.msdk.api.c.c(i4));
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        w3.c("is_video_cache_success", 0);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.api.c.w wVar, String str, boolean z3, int i4, int i5, int i6, int i7, com.bytedance.msdk.api.c cVar, long j4, boolean z4, boolean z5) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), pVar, wVar, str, z3, i4, i5, i6, i7, cVar, j4, z4, z5);
    }

    public static void c(com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, int i4, String str) {
        sr w3 = sr.w();
        sr c4 = w3.c("bidding_info_invalid").w(i4).p(str).c("ad_count", Integer.valueOf(wVar != null ? wVar.ls() : 0));
        com.bytedance.msdk.core.fp.w.c(com.bytedance.msdk.core.c.w());
        c4.c("grouping_params", com.bytedance.msdk.core.fp.w.w()).c("log_source", 2);
        HashMap hashMap = new HashMap();
        c(w3, wVar, pVar, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, int i4, String str, long j4, com.bytedance.msdk.api.c.w wVar, int i5, int i6, int i7, String str2, long j5, long j6) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), uxVar, i4, str, j4, wVar, i5, i6, i7, str2, j5, j6);
    }

    public static void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.p pVar, int i4, int i5, int i6, String str, long j4, String str2, String str3, String str4, long j5) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), cVar, wVar, pVar, i4, i5, i6, str, j4, str2, str3, str4, j5);
    }

    public static void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.p pVar, int i4, int i5, int i6, String str, long j4) {
        sr w3 = sr.w();
        w3.c("bidding_adm_load_fail").c(j4).f(str).w(cVar != null ? cVar.xv : -1).p(cVar != null ? cVar.sr : "unknown error").c("adn_count", Integer.valueOf(i4)).c("adn_preload", 0).c("mediationrit_req_type", Integer.valueOf(i5)).c("mediationrit_req_type_src", Integer.valueOf(i6));
        if (cVar instanceof com.bytedance.msdk.api.w.c) {
            w3.f28506t = cVar.f27444c;
            w3.f28501k = cVar.f27445w;
        }
        HashMap hashMap = new HashMap();
        c(w3, wVar, pVar, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(@Nullable com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.c cVar, String str, String str2) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, cVar, str, str2);
    }

    public static void c(com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.api.c.w wVar, int i4, int i5) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), pVar, wVar, i4, i5);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, String str, boolean z3, String str2, int i4, Map<String, Object> map) {
        if (wVar != null) {
            com.bytedance.sdk.gromore.w.c.c().c(wVar.c(), c.xv);
        }
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, str, z3, str2, i4, map);
    }

    public static void c(Map<String, Object> map, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, long j4, int i4, int i5, int i6, String str, int i7, int i8, com.bytedance.msdk.core.k.w wVar2) {
        JSONObject jSONObject;
        int i9;
        sr xv2 = sr.xv();
        if (map != null) {
            int intValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double doubleValue = map.get("ecpm") instanceof Double ? ((Double) map.get("ecpm")).doubleValue() : 0.0d;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("price_from", map.get("price_from"));
                jSONObject2.put("grout_type", intValue);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("target_ecpm_origin", doubleValue);
                jSONObject3.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject2.put(BidResponsed.KEY_PRICE, jSONObject3);
                if (map.get("price_source") != null) {
                    jSONObject2.put("price_source", map.get("price_source"));
                }
                int intValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean booleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (intValue != 3 && intValue != 4) {
                    i9 = 0;
                } else if (!booleanValue) {
                    i9 = 1;
                } else if (doubleValue == 0.0d) {
                    i9 = 2;
                } else if (intValue2 == 0) {
                    i9 = 5;
                } else {
                    i9 = (intValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject2.put("pos_state", i9);
                jSONObject2.put("rule_id", map.get("rule_id"));
                jSONObject2.put("rule_inuse", intValue2);
            } catch (JSONException unused) {
            }
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        com.bytedance.msdk.xv.sr.c.c().c(xv2, wVar, uxVar, j4, i4, i5, i6, str, i7, i8, wVar2, jSONObject);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, long j4, String str) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, uxVar, j4, str);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.core.k.p pVar) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, uxVar, pVar);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.w wVar2, long j4, String str, boolean z3, int i4, boolean z4, boolean z5) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), uxVar, wVar, wVar2, j4, str, z3, i4, z4, z5);
    }

    public static void c(boolean z3) {
        sr w3 = sr.w();
        w3.c("get_config_start").c("reason", Integer.valueOf(z3 ? com.bytedance.msdk.ux.f.c().ux("is_config_from_assert") ? 2 : 1 : 0));
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, (Map<String, Object>) null);
    }

    public static void c(long j4) {
        sr w3 = sr.w();
        w3.c("sdk_init").xv(j4);
        String str = null;
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            Class.forName("com.bytedance.android.NativeAdManager");
            str = "unity";
        } catch (Throwable unused) {
        }
        if (str != null) {
            w3.c("develop_type", str);
        }
        HashMap hashMap = new HashMap();
        int f4 = com.bytedance.msdk.ux.xv.c.c().f();
        if (f4 > 0) {
            com.bytedance.msdk.ux.xv.c.c().r();
            hashMap.put("discard_num", Integer.valueOf(f4));
        }
        hashMap.put("csj_plugin_version", com.bytedance.msdk.sr.xv.xv());
        JSONObject ux = wv.ux();
        if (ux != null) {
            hashMap.put("init_time", ux);
        }
        wv.c(hashMap);
        wv.w(hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sr w3 = sr.w();
        w3.c("callstack_dynamic");
        w3.c("callstack_message", str);
        w3.c("callstack_report_time", 1);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, (Map<String, Object>) null);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sr w3 = sr.w();
        w3.c("callstack_static").c("callstack_message", str).c("callstack_report_time", Integer.valueOf(i4));
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(long j4, int i4, int i5, long j5, JSONObject jSONObject, Map<String, Object> map) {
        sr w3 = sr.w();
        w3.c("sdk_init_end");
        w3.c(j4);
        w3.xv(j5);
        w3.c("adn_count", Integer.valueOf(i4));
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("is_from_local_config", Integer.valueOf(i5));
        hashMap.put("adapter_version_list", com.bytedance.msdk.f.r.c());
        if (jSONObject != null) {
            hashMap.put("local_init_time", jSONObject);
        }
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(int i4, int i5, long j4, boolean z3, boolean z4, JSONObject jSONObject, long j5, JSONObject jSONObject2) {
        sr w3 = sr.w();
        boolean ux = com.bytedance.msdk.ux.f.c().ux("is_config_from_assert");
        if (i4 != 1) {
            i4 = (z3 || (i4 == 0 && ux)) ? 2 : 0;
        }
        w3.setResult(i4).c(j4).c("get_config_final").f(i5).w(i5).c("transparent_params", com.bytedance.msdk.core.c.w().ux());
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.p.sr.c(z4, w3, jSONObject, hashMap);
        if (jSONObject2 != null) {
            hashMap.put("cfg_handle_time", jSONObject2);
        }
        hashMap.put("config_size", Long.valueOf(j5));
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, String str, JSONObject jSONObject) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, str, jSONObject);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.sr.w wVar2, String str, int i4) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), wVar, wVar2, str, i4);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, List<com.bytedance.msdk.c.ux> list, List<com.bytedance.msdk.c.ux> list2) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), uxVar, wVar, list, list2);
    }

    public static void c(com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.api.c.w wVar, String str) {
        sr.w();
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), pVar, wVar, str);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.p pVar, long j4) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), uxVar, wVar, pVar, j4);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.p pVar) {
        com.bytedance.msdk.xv.sr.c.c().c(sr.xv(), uxVar, wVar, pVar);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, String str, String str2) {
        sr w3 = sr.w();
        w3.c("cache_cannot_use").c("cache_invalid_info", str).c("waterfall_abtest", str2);
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, String str) {
        sr w3 = sr.w();
        w3.c("rit_cache_cannot_use").c("cache_invalid_info", str);
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        w3.c("mediationrit_req_type", 2);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, String str) {
        sr w3 = sr.w();
        w3.c("media_will_show").c("waterfall_abtest", str);
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.c cVar, int i4, int i5, String str, long j4) {
        c(uxVar, wVar, cVar, i4, i5, str, j4, (String) null);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.c cVar, int i4, int i5, String str, long j4, String str2) {
        sr w3 = sr.w();
        w3.setResult(i4).w(cVar != null ? cVar.xv : 0).p(cVar != null ? cVar.sr : null).c("media_show_fail_listen").c("play_again", Integer.valueOf(i5));
        if (str != null) {
            w3.c("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            w3.c("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z3 = j4 >= 0;
        if (uxVar != null && uxVar.isCustomAd()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(i.c()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z3));
            if (z3) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j4));
            }
        }
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, int i4, int i5, int i6, String str) {
        sr w3 = sr.w();
        w3.setResult(i5).c("media_show_after").c("play_again", Integer.valueOf(i6)).c("reason", Integer.valueOf(i4));
        if (!TextUtils.isEmpty(str)) {
            w3.c("callstack_message", str);
        }
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(String str, com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.api.c cVar) {
        sr w3 = sr.w();
        sr p3 = w3.w(cVar != null ? cVar.f27444c : 0).p(cVar != null ? cVar.f27445w : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        p3.ux(str).c("custom_adn_init_fail");
        HashMap hashMap = new HashMap();
        c(w3, wVar, pVar, uxVar, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, String str, int i4, int i5) {
        sr w3 = sr.w();
        w3.c("mt_ra_s").w(i4).c("waterfall_abtest", str);
        HashMap hashMap = new HashMap();
        hashMap.put("pre_req", Integer.valueOf(i5));
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    public static void c(com.bytedance.msdk.api.c.w wVar, String str, int i4) {
        sr w3 = sr.w();
        w3.c("mt_ra_c").w(i4).c("waterfall_abtest", str);
        HashMap hashMap = new HashMap();
        c(w3, wVar, (com.bytedance.msdk.core.k.p) null, (com.bytedance.msdk.c.ux) null, hashMap);
        xv.c(com.bytedance.msdk.core.c.getContext(), w3, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x037a  */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.util.Map<java.lang.String, java.lang.Object>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(com.bytedance.msdk.xv.sr r11, com.bytedance.msdk.api.c.w r12, com.bytedance.msdk.core.k.p r13, com.bytedance.msdk.c.ux r14, java.util.Map<java.lang.String, java.lang.Object> r15) {
        /*
            Method dump skipped, instructions count: 997
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.xv.r.c(com.bytedance.msdk.xv.sr, com.bytedance.msdk.api.c.w, com.bytedance.msdk.core.k.p, com.bytedance.msdk.c.ux, java.util.Map):void");
    }
}
