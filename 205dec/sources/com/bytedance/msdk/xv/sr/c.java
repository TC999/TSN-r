package com.bytedance.msdk.xv.sr;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.yu;
import com.bytedance.msdk.sr.xv;
import com.bytedance.msdk.xv.gd;
import com.bytedance.msdk.xv.r;
import com.bytedance.msdk.xv.sr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    private static volatile c sr;

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f28509c = new AtomicInteger();

    /* renamed from: w  reason: collision with root package name */
    private AtomicInteger f28510w = new AtomicInteger();
    private AtomicInteger xv = new AtomicInteger();

    public static c c() {
        if (sr == null) {
            synchronized (c.class) {
                if (sr == null) {
                    sr = new w();
                }
            }
        }
        return sr;
    }

    private static void w(sr srVar) {
        srVar.c("block_pacing", "-1");
        srVar.c("rit_adn_show_rule_id", "-1");
        srVar.c("block_show_count", "-1");
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, String str, boolean z3, String str2, int i4, Map<String, Object> map) {
        String str3;
        if (i4 > 0) {
            str3 = com.bytedance.msdk.api.c.c(i4);
        } else {
            str3 = "";
            i4 = 0;
        }
        srVar.c("mediation_request").c("waterfall_abtest", str).c("server_bidding_extra", str2).c("mediation_req_type", Integer.valueOf(i4 != 0 ? z3 ? 2 : 3 : !z3 ? 1 : 0)).c("ad_count", Integer.valueOf(wVar != null ? wVar.ls() : 0)).w(i4).p(str3);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (this.f28509c.get() % 10 == 0) {
            this.f28509c.incrementAndGet();
            hashMap.put("gromore_thread_num", Integer.valueOf(f.ev()));
        }
        if (wVar != null && wVar.xv() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", com.bytedance.msdk.core.ux.w.w.c().xv());
                jSONObject.put("interval", com.bytedance.msdk.core.ux.w.w.c().sr());
                jSONObject.put("primerit_list", com.bytedance.msdk.core.ux.w.w.c().w());
                hashMap.put("preload_info", jSONObject);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (wVar != null && wVar.fz() == 3) {
            com.bytedance.msdk.ux.c.c.p().c(hashMap);
        }
        hashMap.put("csj_plugin_version", xv.xv());
        r.c(srVar, wVar, (p) null, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, ux uxVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.k.w wVar2, long j4, String str, boolean z3, int i4, boolean z4, boolean z5) {
        srVar.c("mediation_fill").c(j4).c("waterfall_abtest", wVar2 != null ? wVar2.mt() : null).c("server_bidding_extra", str).c("mediation_req_type", Integer.valueOf(!z3 ? 1 : 0)).c("ad_count", Integer.valueOf(i4)).w(0).p("");
        HashMap hashMap = new HashMap();
        if (wVar != null && wVar.fz() == 3) {
            com.bytedance.msdk.ux.c.c.p().w(hashMap);
        }
        r.c(srVar, wVar, (p) null, uxVar, hashMap);
        hashMap.put("timeout_req", Integer.valueOf(z4 ? 1 : 0));
        hashMap.put("is_callback", Integer.valueOf(z5 ? 1 : 0));
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, ux uxVar, long j4, int i4, int i5, int i6, String str, int i7, int i8, com.bytedance.msdk.core.k.w wVar2, JSONObject jSONObject) {
        JSONObject k4;
        srVar.c("mediation_request_end").c(j4).c("waterfall_abtest", str).c("ad_count", Integer.valueOf(i7)).c("reason", Integer.valueOf(i8)).w(i6);
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, (p) null, uxVar, hashMap);
        hashMap.put("requested_adn_count", Integer.valueOf(i4));
        hashMap.put("requested_level_count", Integer.valueOf(i5));
        if (jSONObject != null) {
            hashMap.put("auto_detail", jSONObject);
        }
        if (this.f28510w.get() % 10 == 0) {
            this.f28510w.incrementAndGet();
            hashMap.put("gromore_thread_num", Integer.valueOf(f.ev()));
        }
        if (wVar2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(wVar2.w())));
                jSONObject2.putOpt("req_interval", Long.valueOf(wVar2.sr()));
                jSONObject2.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(wVar2.xv())));
                hashMap.put("preload_req", jSONObject2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (wVar != null && (k4 = wVar.k()) != null) {
            hashMap.put("behavior", k4);
        }
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, @Nullable com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.c cVar, String str, String str2) {
        JSONObject k4;
        srVar.c("total_load_fail").c("waterfall_abtest", str).c("server_bidding_extra", str2);
        int i4 = cVar.f27444c;
        if (i4 == 10003) {
            srVar.w(10010).p("Ad load timeout!");
            c(srVar);
        } else if (i4 == 810085) {
            srVar.w(i4).p(cVar.f27445w);
            c(srVar);
        } else if (cVar instanceof com.bytedance.msdk.api.w.xv) {
            com.bytedance.msdk.api.w.xv xvVar = (com.bytedance.msdk.api.w.xv) cVar;
            srVar.w(i4).p(cVar.f27445w);
            srVar.c("block_pacing", xvVar.c());
            srVar.c("waterfall_show_rule_id", xvVar.w());
        } else if (cVar instanceof com.bytedance.msdk.api.w.w) {
            com.bytedance.msdk.api.w.w wVar2 = (com.bytedance.msdk.api.w.w) cVar;
            srVar.w(i4).p(cVar.f27445w);
            srVar.c("block_show_count", wVar2.c());
            srVar.c("waterfall_show_rule_id", wVar2.w());
        } else if (cVar instanceof com.bytedance.msdk.api.w.c) {
            srVar.w(i4).p(cVar.f27445w);
            c(srVar);
        } else {
            srVar.w(10086).p("Ad load fail all loadsorts! ");
            c(srVar);
        }
        HashMap hashMap = new HashMap();
        if (this.xv.get() % 10 == 0) {
            this.xv.incrementAndGet();
            hashMap.put("gromore_thread_num", Integer.valueOf(f.ev()));
        }
        if (wVar != null && (k4 = wVar.k()) != null) {
            hashMap.put("behavior", k4);
        }
        srVar.c("ad_count", Integer.valueOf(wVar != null ? wVar.ls() : 0));
        r.c(srVar, wVar, (p) null, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, p pVar, com.bytedance.msdk.api.c.w wVar, String str, boolean z3, int i4, int i5, int i6, int i7, com.bytedance.msdk.api.c cVar, long j4, boolean z4, boolean z5) {
        int c4;
        if ((cVar instanceof com.bytedance.msdk.api.w.xv) || (cVar instanceof com.bytedance.msdk.api.w.w) || (cVar instanceof com.bytedance.msdk.api.w.c)) {
            srVar.w(cVar.f27444c).p(cVar.f27445w);
        }
        srVar.c("media_request").f(str).c("ad_count", Integer.valueOf(wVar != null ? wVar.ls() : 0)).c("adn_count", Integer.valueOf(i5)).c("mediationrit_req_type", Integer.valueOf(i6)).c("mediationrit_req_type_src", Integer.valueOf(i7)).c("mediation_req_type", Integer.valueOf(!z3 ? 1 : 0)).c("media_req_type", Integer.valueOf(i4));
        HashMap hashMap = new HashMap();
        hashMap.put("timeout_req", Integer.valueOf(z4 ? 1 : 0));
        hashMap.put("is_callback", Integer.valueOf(z5 ? 1 : 0));
        if (wVar != null && wVar.pr() != null && pVar != null && "pangle".equals(pVar.t()) && pVar.a() == 5 && (c4 = wVar.pr().c()) == 1) {
            hashMap.put("support_render_control", Integer.valueOf(c4));
        }
        if (j4 != -1) {
            hashMap.put("start_time", Long.valueOf(SystemClock.elapsedRealtime() - j4));
        }
        r.c(srVar, wVar, pVar, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, ux uxVar, int i4, String str, long j4, com.bytedance.msdk.api.c.w wVar, int i5, int i6, int i7, String str2, long j5, long j6) {
        srVar.c("media_fill").c(j4).w(i4).p(str).c("adn_count", Integer.valueOf(i5)).c("adn_preload", Integer.valueOf((uxVar == null || !uxVar.isAdnPreload()) ? 0 : 1)).c("ad_count", Integer.valueOf(i6));
        srVar.c("fill_type", Integer.valueOf(i7));
        if (str2 != null) {
            srVar.c("sub_adn_name", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z3 = j5 >= 0;
        if (uxVar != null && uxVar.isCustomAd()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(i.c()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z3));
            if (z3) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j5));
            }
        }
        if (j6 != -1) {
            hashMap.put("end_time", Long.valueOf(j6));
        }
        if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName()) && uxVar.getAdType() == 5 && uxVar.getSupportRender() == 1) {
            hashMap.put("if_to_express", Integer.valueOf(uxVar.getSupportRender()));
        }
        if (com.bytedance.msdk.core.c.w().x() && uxVar != null && 5 == uxVar.getAdType()) {
            srVar.c("ex_info", gd.c().c(uxVar));
        }
        r.c(srVar, wVar, (p) null, uxVar, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c cVar, com.bytedance.msdk.api.c.w wVar, p pVar, int i4, int i5, int i6, String str, long j4, String str2, String str3, String str4, long j5) {
        if (cVar instanceof com.bytedance.msdk.api.w.xv) {
            com.bytedance.msdk.api.w.xv xvVar = (com.bytedance.msdk.api.w.xv) cVar;
            srVar.w(cVar.f27444c).p(cVar.f27445w);
            srVar.c("block_pacing", xvVar.c());
            srVar.c("adn_rit_show_rule_id", xvVar.w());
        } else if (cVar instanceof com.bytedance.msdk.api.w.w) {
            com.bytedance.msdk.api.w.w wVar2 = (com.bytedance.msdk.api.w.w) cVar;
            srVar.w(cVar.f27444c).p(cVar.f27445w);
            srVar.c("block_show_count", wVar2.c());
            srVar.c("adn_rit_show_rule_id", wVar2.w());
        } else if (cVar instanceof com.bytedance.msdk.api.w.c) {
            srVar.w(cVar.f27444c);
            srVar.p(cVar.f27445w);
            w(srVar);
        } else {
            srVar.w(cVar != null ? cVar.xv : -1).p(cVar != null ? cVar.sr : "unknown error");
            w(srVar);
        }
        srVar.c("media_fill_fail").c(j4).f(str).c("adn_count", Integer.valueOf(i4)).c("adn_preload", 0).c("mediationrit_req_type", Integer.valueOf(i5)).c("mediationrit_req_type_src", Integer.valueOf(i6));
        HashMap hashMap = new HashMap();
        boolean z3 = j5 >= 0;
        if (pVar != null && pVar.yu()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(i.c()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z3));
            if (z3) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j5));
            }
        }
        r.c(srVar, wVar, pVar, (ux) null, hashMap);
        if (!TextUtils.isEmpty(str2)) {
            srVar.gd(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            srVar.c("level_tag", str3);
        }
        if (str4 != null) {
            srVar.c("sub_adn_name", str4);
        }
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, p pVar, com.bytedance.msdk.api.c.w wVar, int i4, int i5) {
        srVar.c("adapter_request_fail").c(0L).f((String) null).w(-99999).p("adapter create fail !").c("mediationrit_req_type", Integer.valueOf(i4)).c("mediationrit_req_type_src", Integer.valueOf(i5));
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, pVar, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, int i4) {
        srVar.c("get_config_error").w(i4);
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, (p) null, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, ux uxVar, com.bytedance.msdk.api.c.w wVar, List<ux> list, List<ux> list2) {
        Iterator<ux> it;
        HashMap hashMap;
        Iterator<ux> it2;
        srVar.c("bidding_win_event");
        HashMap hashMap2 = new HashMap();
        r.c(srVar, wVar, (p) null, uxVar, hashMap2);
        JSONArray jSONArray = new JSONArray();
        if (!yu.c(list)) {
            Iterator<ux> it3 = list.iterator();
            while (it3.hasNext()) {
                ux next = it3.next();
                if (next != null) {
                    it2 = it3;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        hashMap = hashMap2;
                        try {
                            jSONObject.putOpt("mediation_rit", next.getAdNetworkSlotId());
                            jSONObject.putOpt("adn_name", next.getAdNetWorkName());
                            jSONObject.putOpt("load_sort", Integer.valueOf(next.getLoadSort()));
                            jSONObject.putOpt("show_sort", Integer.valueOf(next.getShowSort()));
                            jSONObject.putOpt("exchange_rate", next.getExchangeRate());
                            jSONObject.putOpt("rit_cpm", Double.valueOf(next.getCpm()));
                            jSONObject.putOpt("m_aid", next.getAid());
                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.getAdNetworkSlotType()));
                            jSONObject.putOpt("win_state", 1);
                            jSONObject.putOpt("ad_extra", next.getAdExtra());
                            jSONObject.putOpt("win_callback", next.getWinCallback());
                            jSONObject.putOpt("loss_callback", next.getFailCallback());
                            if (next.isServerBiddingAd()) {
                                jSONObject.putOpt("pricing_type", Integer.valueOf(next.getPricingType()));
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        hashMap = hashMap2;
                    }
                } else {
                    hashMap = hashMap2;
                    it2 = it3;
                }
                it3 = it2;
                hashMap2 = hashMap;
            }
        }
        HashMap hashMap3 = hashMap2;
        if (!yu.c(list2)) {
            Iterator<ux> it4 = list2.iterator();
            while (it4.hasNext()) {
                ux next2 = it4.next();
                if (next2 != null) {
                    it = it4;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            jSONObject2.putOpt("mediation_rit", next2.getAdNetworkSlotId());
                            jSONObject2.putOpt("adn_name", next2.getAdNetWorkName());
                            jSONObject2.putOpt("load_sort", Integer.valueOf(next2.getLoadSort()));
                            jSONObject2.putOpt("show_sort", Integer.valueOf(next2.getShowSort()));
                            jSONObject2.putOpt("exchange_rate", next2.getExchangeRate());
                            jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.getCpm()));
                            jSONObject2.putOpt("m_aid", next2.getAid());
                            jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.getAdNetworkSlotType()));
                            jSONObject2.putOpt("win_state", 0);
                            jSONObject2.putOpt("ad_extra", next2.getAdExtra());
                            jSONObject2.putOpt("win_callback", next2.getWinCallback());
                            jSONObject2.putOpt("loss_callback", next2.getFailCallback());
                            if (next2.isServerBiddingAd()) {
                                jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.getPricingType()));
                            }
                            jSONArray = jSONArray2;
                            jSONArray.put(jSONObject2);
                        } catch (Exception unused3) {
                            jSONArray = jSONArray2;
                        }
                    } catch (Exception unused4) {
                    }
                } else {
                    it = it4;
                }
                it4 = it;
            }
        }
        hashMap3.put("others", jSONArray);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap3);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, String str, JSONObject jSONObject) {
        srVar.c("start_bidding_request").c(2).c("waterfall_abtest", str).c("ad_count", Integer.valueOf(wVar != null ? wVar.ls() : 0));
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            hashMap.put("token_time", jSONObject);
        }
        r.c(srVar, wVar, (p) null, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.sr.w wVar2, String str, int i4) {
        if (wVar2 == null) {
            return;
        }
        sr result = srVar.c("return_bidding_result").c(wVar2.f28182r).setResult(wVar2.f28179f);
        com.bytedance.msdk.api.c cVar = wVar2.ev;
        sr w3 = result.w(cVar == null ? 0 : cVar.f27444c);
        com.bytedance.msdk.api.c cVar2 = wVar2.ev;
        w3.p(cVar2 == null ? "" : cVar2.f27445w).c(2).c("fill_type", Integer.valueOf(i4)).c("waterfall_abtest", str).c("server_bidding_extra", wVar2.sr).c("ad_count", Integer.valueOf(wVar2.gd));
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.p.sr.c(wVar2.f28181p, wVar2.f28178c, hashMap);
        JSONObject jSONObject = wVar2.f28180k;
        if (jSONObject != null) {
            hashMap.put("token_time", jSONObject);
        }
        r.c(srVar, wVar, (p) null, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, p pVar, com.bytedance.msdk.api.c.w wVar, String str) {
        srVar.c("get_bidding_adm_to_adn").f(str);
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, pVar, (ux) null, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, ux uxVar, com.bytedance.msdk.api.c.w wVar, p pVar, long j4) {
        srVar.c("bidding_adm_load").c(j4);
        HashMap hashMap = new HashMap();
        if (com.bytedance.msdk.core.c.w().x() && uxVar != null && 5 == uxVar.getAdType()) {
            srVar.c("ex_info", gd.c().c(uxVar));
        }
        r.c(srVar, wVar, pVar, uxVar, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, ux uxVar, com.bytedance.msdk.api.c.w wVar, p pVar) {
        srVar.c("bidding_adm_cache");
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, pVar, uxVar, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, ux uxVar, p pVar) {
        srVar.c("media_cache_success");
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, pVar, uxVar, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    public void c(sr srVar, com.bytedance.msdk.api.c.w wVar, ux uxVar, long j4, String str) {
        srVar.c("mediation_video_cached").c(j4).c("waterfall_abtest", str);
        HashMap hashMap = new HashMap();
        r.c(srVar, wVar, (p) null, uxVar, hashMap);
        com.bytedance.msdk.xv.xv.c(com.bytedance.msdk.core.c.getContext(), srVar, hashMap);
    }

    private static void c(sr srVar) {
        srVar.c("block_pacing", "-1");
        srVar.c("waterfall_show_rule_id", "-1");
        srVar.c("block_show_count", "-1");
    }
}
