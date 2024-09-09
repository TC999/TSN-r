package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.q.w;
import com.bytedance.sdk.openadsdk.core.u.b;
import com.bytedance.sdk.openadsdk.core.u.bm;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.mt;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.u.oo;
import com.bytedance.sdk.openadsdk.core.u.up;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static Pair<com.bytedance.sdk.openadsdk.core.u.c, ArrayList<Integer>> c(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, long j4) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.u.c cVar = new com.bytedance.sdk.openadsdk.core.u.c();
            cVar.c(jSONObject.optString(ConstantAd.KEY_CACHE_AD));
            cVar.c(jSONObject.optInt("ret"));
            cVar.w(jSONObject.optString("message"));
            String optString = jSONObject.optString("auction_price");
            com.bytedance.sdk.openadsdk.core.eq.gd.w(jSONObject.optString("client_ipv4", ""));
            boolean optBoolean = jSONObject.optBoolean("need_get_materials");
            if (cVar.c() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    com.bytedance.sdk.openadsdk.core.u.me c4 = c(optJSONArray.optJSONObject(i4), wVar, wvVar);
                    int c5 = c(c4, wVar != null ? wVar.q() : 0);
                    boolean s3 = c4.s();
                    String u3 = c4.u();
                    if (c5 != 200 && ((!optBoolean && !s3) || TextUtils.isEmpty(u3))) {
                        arrayList.add(Integer.valueOf(c5));
                    }
                    c4.n(optString);
                    c4.w(j4);
                    c4.sr(optBoolean);
                    cVar.c(c4);
                }
            }
            return new Pair<>(cVar, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.u.s f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.u.s sVar = new com.bytedance.sdk.openadsdk.core.u.s();
        sVar.c(jSONObject.optInt("ah", 1));
        sVar.w(jSONObject.optInt("am", 1));
        return sVar;
    }

    private static Map<String, Object> r(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    public static com.bytedance.sdk.openadsdk.core.u.q sr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.u.q qVar = new com.bytedance.sdk.openadsdk.core.u.q();
        qVar.sr(jSONObject.optString("bg_url"));
        qVar.xv(jSONObject.optString("title"));
        qVar.c(jSONObject.optString("reward_image_url"));
        qVar.w(jSONObject.optString("reward_title"));
        qVar.ux(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return qVar;
    }

    public static com.bytedance.sdk.openadsdk.core.u.ux ux(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.u.ux uxVar = new com.bytedance.sdk.openadsdk.core.u.ux();
        uxVar.sr(jSONObject.optString("developer_name"));
        uxVar.w(jSONObject.optString("app_version"));
        JSONArray optJSONArray = jSONObject.optJSONArray(TTDelegateActivity.INTENT_PERMISSIONS);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            uxVar.w(optJSONArray);
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    uxVar.c(optJSONObject.optString("permission_name"), optJSONObject.optString("permission_desc"));
                }
            }
        }
        uxVar.c(jSONObject.optString("permissions_url"));
        uxVar.c(jSONObject.optInt("score", 0));
        uxVar.c(jSONObject.optJSONArray("creative_tags"));
        uxVar.ux(jSONObject.optString("privacy_policy_url"));
        uxVar.f(jSONObject.optString("desc_url"));
        uxVar.ev(jSONObject.optString("app_name"));
        uxVar.r(jSONObject.optString("package_name"));
        return uxVar;
    }

    public static com.bytedance.sdk.openadsdk.core.u.sr w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.u.sr srVar = new com.bytedance.sdk.openadsdk.core.u.sr();
        srVar.xv(jSONObject.optString("app_name"));
        srVar.sr(jSONObject.optString("package_name"));
        srVar.w(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        srVar.c(jSONObject.optInt("score", 4));
        srVar.w(jSONObject.optInt("comment_num", 0));
        srVar.xv(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        srVar.c(jSONObject.optString("quick_app_url", ""));
        return srVar;
    }

    public static com.bytedance.sdk.openadsdk.core.u.i xv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.u.i iVar = new com.bytedance.sdk.openadsdk.core.u.i();
        iVar.xv(jSONObject.optString("ugen_dialog_md5"));
        iVar.w(jSONObject.optString("ugen_dialog_url"));
        iVar.c(jSONObject.optString("dialog_style"));
        return iVar;
    }

    private static int w(com.bytedance.sdk.openadsdk.core.u.me meVar, int i4) {
        if (i4 != 3 && i4 != 4 && i4 != 0) {
            if (!com.bytedance.sdk.openadsdk.core.u.ba.c(meVar)) {
                return 416;
            }
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.u.ba.r(meVar))) {
                return 417;
            }
        }
        return 200;
    }

    public static com.bytedance.sdk.openadsdk.core.u.me c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return c(jSONObject, null, null);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static com.bytedance.sdk.openadsdk.core.u.me c(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        if (wvVar != null && wVar != null) {
            ls.w().xv(jSONObject.optInt("settings_open", 0));
        }
        final com.bytedance.sdk.openadsdk.core.u.me meVar = new com.bytedance.sdk.openadsdk.core.u.me();
        meVar.z(jSONObject.optString("s_sig_ts"));
        meVar.ux(jSONObject.optLong("ad_rec_stamp", 0L));
        meVar.ck(jSONObject.optInt("interaction_type"));
        meVar.t(jSONObject.optString("target_url"));
        meVar.r(jSONObject.optInt("use_media_video_player", 0));
        meVar.z(jSONObject.optInt("landing_scroll_percentage", -1));
        meVar.ys(jSONObject.optString("gecko_id"));
        meVar.f(jSONObject.optBoolean("is_from_local_cache"));
        meVar.me(jSONObject.optInt("is_from_cache_type", -1));
        if (jSONObject.has("set_click_type")) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("set_click_type");
            meVar.w(optJSONObject2.optDouble("cta", 2.0d));
            meVar.c(optJSONObject2.optDouble("other", 2.0d));
        }
        meVar.f(jSONObject.optInt("feed_video_finish_type"));
        meVar.w(jSONObject.optJSONObject("extension"));
        meVar.u(jSONObject.optString("ad_id"));
        meVar.bk(jSONObject.optString("source"));
        meVar.gb(jSONObject.optString("package_name"));
        meVar.s(jSONObject.optInt("play_bar_show_time", -200));
        JSONObject optJSONObject3 = jSONObject.optJSONObject(RewardPlus.ICON);
        meVar.ux(jSONObject.optBoolean("screenshot", false));
        meVar.ys(jSONObject.optInt("play_bar_style", 0));
        meVar.ls(jSONObject.optString("market_url", ""));
        meVar.bk(jSONObject.optInt("video_adaptation", 0));
        meVar.k(jSONObject.optInt("feed_video_opentype", 0));
        meVar.a(jSONObject.optInt("feed_reward_type", -1));
        meVar.xv(jSONObject.optJSONObject("session_params"));
        meVar.n(jSONObject.optString("auction_price", ""));
        meVar.gw(jSONObject.optInt("no_default_ttdsp_price", 0));
        meVar.ev(jSONObject.optInt("render_control", wvVar != null ? wvVar.f34867r : 1));
        if (optJSONObject3 != null) {
            com.bytedance.sdk.openadsdk.core.u.gb gbVar = new com.bytedance.sdk.openadsdk.core.u.gb();
            gbVar.c(optJSONObject3.optString("url"));
            gbVar.w(optJSONObject3.optInt("height"));
            gbVar.c(optJSONObject3.optInt("width"));
            meVar.c(gbVar);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        if (optJSONArray != null) {
            int i4 = 0;
            while (i4 < optJSONArray.length()) {
                com.bytedance.sdk.openadsdk.core.u.gb gbVar2 = new com.bytedance.sdk.openadsdk.core.u.gb();
                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i4);
                gbVar2.c(optJSONObject4.optString("url"));
                gbVar2.w(optJSONObject4.optInt("height"));
                gbVar2.c(optJSONObject4.optInt("width"));
                gbVar2.c(optJSONObject4.optInt("duration"));
                gbVar2.c(optJSONObject4.optBoolean("image_preview"));
                gbVar2.w(optJSONObject4.optString("image_key"));
                meVar.w(gbVar2);
                i4++;
                optJSONArray = optJSONArray;
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                meVar.db().add(optJSONArray2.optString(i5));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(CampaignEx.JSON_KEY_CLICK_URL);
        if (optJSONArray3 != null) {
            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                meVar.nd().add(optJSONArray3.optString(i6));
            }
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("click_area");
        if (optJSONObject5 != null) {
            com.bytedance.sdk.openadsdk.core.u.r rVar = new com.bytedance.sdk.openadsdk.core.u.r();
            rVar.f34813c = optJSONObject5.optBoolean("click_upper_content_area", true);
            rVar.f34815w = optJSONObject5.optBoolean("click_upper_non_content_area", true);
            rVar.xv = optJSONObject5.optBoolean("click_lower_content_area", true);
            rVar.sr = optJSONObject5.optBoolean("click_lower_non_content_area", true);
            rVar.ux = optJSONObject5.optBoolean("click_button_area", true);
            rVar.f34814f = optJSONObject5.optBoolean("click_video_area", true);
            meVar.c(rVar);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("adslot");
        if (optJSONObject6 != null) {
            meVar.c(com.bytedance.sdk.openadsdk.core.eq.n.c(optJSONObject6.toString()));
        } else {
            meVar.c(wVar);
        }
        meVar.fp(jSONObject.optInt("intercept_flag", 0));
        meVar.ia(jSONObject.optInt("web_inspector", 0));
        meVar.fp(jSONObject.optString("phone_num"));
        meVar.ia(jSONObject.optString("title"));
        meVar.xv(jSONObject.optLong("download_num"));
        meVar.s(jSONObject.optString("description"));
        meVar.fz(jSONObject.optString("button_text"));
        meVar.t(jSONObject.optInt("ad_logo", 1));
        String optString = jSONObject.optString("ext");
        meVar.i(optString);
        try {
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                meVar.q(jSONObject2.optString("req_id"));
                meVar.f(jSONObject2.optString("req_id"));
                meVar.j(jSONObject2.optString("ad_id"));
                com.bytedance.sdk.openadsdk.core.eq.gd.c(jSONObject2.optLong("global_did", -1L));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        meVar.gd(jSONObject.optString(BidResponsed.KEY_PRICE));
        meVar.y(jSONObject.optInt("image_mode"));
        meVar.vc(jSONObject.optInt("orientation", 1));
        meVar.c((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        meVar.w((float) jSONObject.optDouble("aspect_margin", 0.07000000029802322d));
        meVar.xv((float) jSONObject.optDouble("corner_radius", 0.0d));
        JSONObject optJSONObject7 = jSONObject.optJSONObject("app");
        JSONObject optJSONObject8 = jSONObject.optJSONObject("download_sdk_conf");
        meVar.c(w(optJSONObject7));
        meVar.c(f(optJSONObject8));
        JSONObject optJSONObject9 = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL);
        if (optJSONObject9 != null) {
            meVar.c(new com.bytedance.sdk.openadsdk.core.u.ys(optJSONObject9));
        }
        meVar.c(new m(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.wx(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.k(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.fp(jSONObject));
        meVar.c(new oo(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.dislike.xv.w(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.yu(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.ck(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.bw(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.pr(jSONObject));
        meVar.eq(jSONObject.optInt("count_down"));
        meVar.sr(jSONObject.optLong("expiration_time"));
        meVar.wv(jSONObject.optString("_child_metas"));
        meVar.n(jSONObject.optInt("video_encode_type", 0));
        meVar.bm(jSONObject.optInt("player_type", 0));
        if (!eq.w() && meVar.ou() == 1) {
            meVar.n(0);
            meVar.bm(0);
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("download_conf");
        if (optJSONObject10 != null) {
            meVar.c(new com.bytedance.sdk.openadsdk.core.u.ia(optJSONObject10));
        }
        meVar.wv(jSONObject.optInt("if_both_open"));
        meVar.xk(jSONObject.optInt("if_double_deeplink"));
        JSONObject optJSONObject11 = jSONObject.optJSONObject("app_manage");
        if (optJSONObject11 != null) {
            meVar.c(ux(optJSONObject11));
            meVar.a(optJSONObject11.toString());
        }
        JSONObject optJSONObject12 = jSONObject.optJSONObject("easy_dl_dialog");
        if (optJSONObject12 != null) {
            meVar.c(xv(optJSONObject12));
        }
        JSONObject optJSONObject13 = jSONObject.optJSONObject("easy_pl_material");
        if (optJSONObject13 != null) {
            meVar.sr(optJSONObject13);
            meVar.c(sr(optJSONObject13));
        }
        meVar.gb(jSONObject.optString("lp_down_rule", "0").equals("1") ? 1 : 0);
        String optString2 = jSONObject.optString("app_manage_type", "0");
        if (optString2.equals("1")) {
            meVar.ls(1);
        } else if (optString2.equals("2")) {
            meVar.ls(2);
        } else {
            meVar.ls(0);
        }
        meVar.c(r(jSONObject.optJSONObject("media_ext")));
        meVar.yu(jSONObject.optInt("landing_page_type"));
        JSONObject optJSONObject14 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject14 != null) {
            me.c cVar = new me.c();
            cVar.w(optJSONObject14.optString("id"));
            cVar.xv(optJSONObject14.optString("md5"));
            cVar.sr(optJSONObject14.optString("url"));
            cVar.ux(optJSONObject14.optString("data"));
            cVar.f(optJSONObject14.optString("diff_data"));
            cVar.r(optJSONObject14.optString("dynamic_creative"));
            cVar.c(optJSONObject14.optString("version"));
            cVar.ev(optJSONObject14.optString("material_type"));
            cVar.gd(optJSONObject14.optString("ugen_url"));
            cVar.p(optJSONObject14.optString("ugen_md5"));
            cVar.k(optJSONObject14.optString("engine_version"));
            meVar.c(cVar);
        }
        JSONObject optJSONObject15 = jSONObject.optJSONObject("middle_tpl_info");
        if (optJSONObject15 != null) {
            me.c cVar2 = new me.c();
            cVar2.w(optJSONObject15.optString("middle_id"));
            cVar2.xv(optJSONObject15.optString("middle_md5"));
            cVar2.sr(optJSONObject15.optString("middle_url"));
            cVar2.ux(optJSONObject15.optString("middle_data"));
            cVar2.f(optJSONObject15.optString("middle_diff_data"));
            cVar2.r(optJSONObject15.optString("middle_dynamic_creative"));
            cVar2.c(optJSONObject15.optString("middle_version"));
            meVar.w(cVar2);
        }
        meVar.gd(jSONObject.optInt("if_block_lp", 0));
        meVar.fz(jSONObject.optInt("cache_sort", 1));
        meVar.u(jSONObject.optInt("if_sp_cache", 1));
        meVar.i(jSONObject.optInt("splash_timeout_stage", 1));
        meVar.sr(jSONObject.optInt("page_render_type", 0));
        if (meVar.t() == 1 && (optJSONObject = jSONObject.optJSONObject("ugeno")) != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.f.c c4 = c(optJSONObject, meVar);
            meVar.c(c4);
            if (!com.bytedance.sdk.openadsdk.core.ugeno.sr.c().w(c4.c(), c4.w())) {
                com.bytedance.sdk.openadsdk.core.q.w.c(c4, (w.InterfaceC0506w) null);
            }
        }
        meVar.xv(jSONObject.optInt("native_lp_tpl_id"));
        meVar.w(jSONObject.optString("native_lp_data"));
        meVar.xv(jSONObject.optString("native_lp_ugen_url"));
        meVar.sr(jSONObject.optString("native_lp_ugen_md5"));
        meVar.w(jSONObject.optBoolean("native_lp_is_preload"));
        meVar.c(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        if (meVar.p()) {
            JSONObject optJSONObject16 = jSONObject.optJSONObject("native_lp_content");
            if (optJSONObject16 != null) {
                meVar.c(optJSONObject16);
            } else {
                com.bytedance.sdk.openadsdk.core.q.w.c(meVar.f(), new w.c() { // from class: com.bytedance.sdk.openadsdk.core.w.1
                    @Override // com.bytedance.sdk.openadsdk.core.q.w.c
                    public void c(int i7, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.q.w.c
                    public void c(JSONObject jSONObject3) {
                        com.bytedance.sdk.openadsdk.core.u.me.this.c(jSONObject3);
                    }
                });
            }
        }
        meVar.ux(jSONObject.optInt("promotion_type"));
        JSONObject optJSONObject17 = jSONObject.optJSONObject("dylite_info");
        if (optJSONObject17 != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.gd.c cVar3 = new com.bytedance.sdk.openadsdk.core.ugeno.gd.c();
            JSONArray optJSONArray4 = optJSONObject17.optJSONArray("product_infos");
            if (optJSONArray4 != null) {
                cVar3.c(optJSONArray4);
            }
            JSONObject optJSONObject18 = optJSONObject17.optJSONObject(PangleAdapterUtils.MEDIA_EXTRA_COUPON);
            if (optJSONObject18 != null) {
                cVar3.c(optJSONObject18);
            }
            JSONObject optJSONObject19 = optJSONObject17.optJSONObject("render_config");
            if (optJSONObject19 != null) {
                cVar3.w(optJSONObject19);
            }
            JSONObject optJSONObject20 = optJSONObject17.optJSONObject("live_room_data");
            if (optJSONObject20 != null) {
                cVar3.xv(optJSONObject20);
            }
            meVar.c(cVar3);
        }
        JSONObject optJSONObject21 = jSONObject.optJSONObject("render");
        if (optJSONObject21 != null) {
            meVar.wx(optJSONObject21.optInt("render_sequence", 0));
            meVar.bw(optJSONObject21.optInt("backup_render_control", 1));
            meVar.x(optJSONObject21.optInt("render_thread", 0));
            meVar.m(optJSONObject21.optInt("reserve_time", 100));
            meVar.pr(optJSONObject21.optInt("valid_uchain", 0));
        }
        JSONObject optJSONObject22 = jSONObject.optJSONObject("splash_control");
        if (optJSONObject22 != null) {
            meVar.c(c(optJSONObject22, meVar.fh()));
        }
        meVar.ck(jSONObject.optString("ad_info"));
        meVar.gd(jSONObject.optBoolean("close_on_dislike", false));
        meVar.ba(jSONObject.optString("adx_name"));
        meVar.oo(jSONObject.optInt("endcard_close_time", 0));
        meVar.bj(jSONObject.optInt("proportion_watching", 100));
        meVar.xu(jSONObject.optInt("video_skip_result", 3));
        com.bytedance.sdk.openadsdk.core.u.ba baVar = new com.bytedance.sdk.openadsdk.core.u.ba(jSONObject);
        meVar.c(baVar);
        if (baVar.c()) {
            if (eq.w()) {
                meVar.bm(-2);
            } else {
                meVar.bm(0);
            }
        }
        meVar.c(new ng(jSONObject));
        meVar.au(jSONObject.optInt("render_delay_time", 0));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.fz(jSONObject));
        meVar.c(new com.bytedance.sdk.openadsdk.core.u.n(jSONObject));
        c(meVar, jSONObject);
        JSONObject optJSONObject23 = jSONObject.optJSONObject("skip_control");
        if (optJSONObject23 != null) {
            bm bmVar = new bm();
            bmVar.c(optJSONObject23.optInt("position", 2));
            bmVar.w(optJSONObject23.optInt("left_or_right_margin", 16));
            bmVar.xv(optJSONObject23.optInt("top_or_bottom_margin", 30));
            bmVar.sr(optJSONObject23.optInt("skip_style", 1));
            meVar.c(bmVar);
        }
        meVar.up(jSONObject.optInt("shake_value", 13));
        meVar.ok(jSONObject.optInt("deep_shake_value"));
        meVar.mt(jSONObject.optInt("rotation_angle", 50));
        meVar.ba(jSONObject.optInt("dynamic_join_type", 0));
        meVar.q(jSONObject.optInt("calculation_method", 0));
        JSONObject optJSONObject24 = jSONObject.optJSONObject("splash_compliance_bar");
        if (optJSONObject24 != null) {
            up upVar = new up();
            upVar.c(optJSONObject24.optInt("show_type", 0));
            upVar.w(optJSONObject24.optInt("blank", 90));
            upVar.xv(optJSONObject24.optInt("half_blank", 90));
            meVar.c(upVar);
        }
        meVar.b(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
        meVar.ox(jSONObject.optInt("click_send_type", 0));
        meVar.p(jSONObject.optString("adm"));
        meVar.xv(jSONObject.optBoolean("is_cache"));
        meVar.r(jSONObject.optString("log_ext"));
        meVar.ux(jSONObject.optString("cache_ext"));
        String optString3 = jSONObject.optString("req_id");
        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(meVar.ia())) {
            meVar.f(optString3);
        }
        meVar.c(jSONObject.optLong("cache_time"));
        meVar.ev(jSONObject.optString("material_key"));
        meVar.sr(jSONObject.optBoolean("need_get_materials"));
        meVar.w(jSONObject.optLong("s_send_ts"));
        meVar.c(ok.c(jSONObject.optJSONObject("wc_miniapp_info")));
        meVar.eq(jSONObject.optString("live_room_id", ""));
        meVar.wo(jSONObject.optInt("live_interaction_type", 1));
        meVar.k(jSONObject.optString("ec_schema", ""));
        meVar.p(jSONObject.optInt("draw_video_playcount", 2));
        JSONObject optJSONObject25 = jSONObject.optJSONObject("dynamic_join_coupon_style");
        if (optJSONObject25 != null) {
            com.bytedance.sdk.openadsdk.core.u.t tVar = new com.bytedance.sdk.openadsdk.core.u.t();
            tVar.c(optJSONObject25.optInt("style_type"));
            tVar.c(optJSONObject25.optString(CampaignEx.JSON_KEY_IMAGE_URL));
            tVar.w(optJSONObject25.optInt("position"));
            tVar.c(optJSONObject25.optDouble("image_height"));
            tVar.w(optJSONObject25.optString("image_gif_url"));
            tVar.w(optJSONObject25.optDouble("image_scale_rate"));
            tVar.xv(optJSONObject25.optDouble("image_gif_aspect_ratio"));
            meVar.c(tVar);
        }
        meVar.me(jSONObject.optString("ecom_live_params"));
        JSONObject optJSONObject26 = jSONObject.optJSONObject("group_info");
        if (optJSONObject26 != null) {
            com.bytedance.sdk.openadsdk.core.u.xk xkVar = new com.bytedance.sdk.openadsdk.core.u.xk();
            xkVar.c(optJSONObject26.optString("group_id"));
            xkVar.w(optJSONObject26.optString("group_tag"));
            xkVar.xv(optJSONObject26.optString("card_tag"));
            meVar.c(xkVar);
        }
        meVar.c(com.bytedance.sdk.openadsdk.core.u.bk.c(jSONObject.optJSONObject(PangleAdapterUtils.MEDIA_EXTRA_COUPON)));
        meVar.c(com.bytedance.sdk.openadsdk.core.u.y.c(jSONObject.optJSONObject("live_info")));
        JSONObject optJSONObject27 = jSONObject.optJSONObject("video_config");
        if (optJSONObject27 != null) {
            b bVar = new b();
            bVar.c(optJSONObject27.optInt("video_adapter_type", 1));
            bVar.w(optJSONObject27.optInt("video_mute_type", 1));
            meVar.c(bVar);
        }
        JSONObject optJSONObject28 = jSONObject.optJSONObject("click_trigger_config");
        if (optJSONObject28 != null) {
            com.bytedance.sdk.openadsdk.core.u.p pVar = new com.bytedance.sdk.openadsdk.core.u.p();
            pVar.c(optJSONObject28.optInt("click_trigger_type"));
            pVar.c((float) optJSONObject28.optDouble("shake_start_time", 0.0d));
            pVar.w((float) optJSONObject28.optDouble("shake_end_time", 2.147483648E9d));
            meVar.c(pVar);
        }
        meVar.j(jSONObject.optInt("calculation_method_twist"));
        meVar.y(jSONObject.optString("dynamic_configs"));
        meVar.h(jSONObject.optInt("gnd_prefetch_timing"));
        meVar.xk(jSONObject.optString("gnd_prefetch_cache_key"));
        Map<String, Object> tc = meVar.tc();
        if (tc == null) {
            tc = new HashMap<>();
            meVar.c(tc);
        }
        String py = meVar.py();
        if (py != null) {
            tc.put("ad_token", py);
        }
        meVar.oh(jSONObject.optInt("if_lpua_package"));
        meVar.ux(jSONObject.optJSONObject("twist_config"));
        meVar.c(com.bytedance.sdk.openadsdk.core.u.ls.c(jSONObject));
        meVar.c(jSONObject.optInt("no_video_concat"));
        meVar.w(jSONObject.optInt("no_land_btn"));
        return meVar;
    }

    private static com.bytedance.sdk.openadsdk.core.ugeno.f.c c(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.f.c();
        cVar.c(jSONObject.optString("id"));
        cVar.w(jSONObject.optString("md5"));
        cVar.xv(jSONObject.optString("url"));
        cVar.c(jSONObject.optInt("scene"));
        return cVar;
    }

    private static void c(com.bytedance.sdk.openadsdk.core.u.me meVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.u.ys qu;
        if (meVar == null || jSONObject == null) {
            return;
        }
        if ((com.bytedance.sdk.openadsdk.core.u.ba.c(meVar) || com.bytedance.sdk.openadsdk.core.u.bw.c(meVar)) && (qu = meVar.qu()) != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            com.bytedance.sdk.openadsdk.core.u.z zVar = new com.bytedance.sdk.openadsdk.core.u.z();
            if (optJSONObject != null) {
                zVar.c(optJSONObject.optString("reward_live_deep_link_user_id"));
                zVar.ux(optJSONObject.optString("reward_live_deep_link_request_id"));
                zVar.w(optJSONObject.optString("reward_live_deep_link_room_id"));
                zVar.xv(optJSONObject.optString("reawrd_live_short_touch_params"));
                zVar.sr(optJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                zVar.c(optJSONObject.optLong("reward_live_last_time"));
                meVar.c(zVar);
            } else {
                Map<String, String> c4 = com.bytedance.sdk.openadsdk.core.eq.yu.c(qu.c());
                if (c4 == null || c4.size() <= 0) {
                    return;
                }
                zVar.c(c4.get("user_id"));
                zVar.ux(c4.get(ConstantAd.KEY_CACHE_AD));
                zVar.w(c4.get("room_id"));
                zVar.xv(c4.get("live_short_touch_params"));
                zVar.sr(c4.get("extra_pangle_scheme_params"));
                meVar.c(zVar);
            }
            meVar.ev(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    private static mt c(JSONObject jSONObject, int i4) {
        if (jSONObject == null) {
            return null;
        }
        mt mtVar = new mt();
        double d4 = 1.0d;
        double optDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        if (optDouble == 1.0d || optDouble == 2.0d) {
            d4 = optDouble;
        }
        mtVar.c((int) d4);
        mtVar.r(jSONObject.optInt("splash_style_id", 0));
        mtVar.c(jSONObject.optString("splash_clicktext", ""));
        mtVar.w(jSONObject.optInt("area_height", 50));
        mtVar.xv(jSONObject.optInt("area_width", 236));
        if (i4 == 2) {
            mtVar.sr(jSONObject.optInt("area_blank_height", 32));
        } else {
            mtVar.sr(jSONObject.optInt("area_blank_height", 82));
        }
        mtVar.ux(jSONObject.optInt("half_blank_height", 56));
        mtVar.w(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        mtVar.xv(jSONObject.optString("top_splash_clicktext"));
        mtVar.c(jSONObject.optJSONObject("text_config"));
        mtVar.w(jSONObject.optJSONObject("top_text_config"));
        mtVar.ev(jSONObject.optInt("sliding_distance", 5));
        mtVar.c(jSONObject.optJSONObject("slide_area"), i4);
        mtVar.f(jSONObject.optInt("splash_load_time_optimization"));
        return mtVar;
    }

    public static int c(com.bytedance.sdk.openadsdk.core.u.me meVar, int i4) {
        if (TextUtils.isEmpty(meVar.jr()) || meVar.jr().length() <= 1) {
            return 401;
        }
        int c4 = c(meVar.qu());
        if (c4 != 200) {
            return c4;
        }
        int c5 = c(meVar);
        if (c5 != 200) {
            return c5;
        }
        int v3 = meVar.v();
        if (v3 == 2 || v3 == 3) {
            if (TextUtils.isEmpty(meVar.pu())) {
                return 405;
            }
        } else if (v3 != 4) {
            if (v3 == 5 && TextUtils.isEmpty(meVar.ky())) {
                return 408;
            }
        } else {
            c5 = c(meVar.ix());
            if (c5 != 200) {
                return c5;
            }
        }
        int tz = meVar.tz();
        if (tz != 2 && tz != 3 && tz != 4) {
            if (tz == 5 || tz == 15) {
                c5 = ng.ev(meVar);
                if (c5 != 200) {
                    return c5;
                }
            } else if (tz != 16) {
                if (tz == 166 && (c5 = w(meVar, i4)) != 200) {
                    return c5;
                }
            }
            return c5;
        }
        c5 = c(meVar.nc());
        if (c5 != 200) {
        }
        return c5;
    }

    private static int c(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (!(meVar.tz() == 166 && com.bytedance.sdk.openadsdk.core.u.ba.c(meVar)) || eq.w()) {
            return 200;
        }
        com.bytedance.sdk.component.utils.a.xv("\u7a7f\u5c71\u7532sdk\u6ca1\u6709\u96c6\u6210\u70b9\u64ad/\u76f4\u64adaar\uff0c\u4e0d\u652f\u6301\u76f4\u64ad\u7269\u6599");
        return 404;
    }

    private static int c(com.bytedance.sdk.openadsdk.core.u.ys ysVar) {
        if (ysVar == null) {
            return 200;
        }
        return (TextUtils.isEmpty(ysVar.c()) || TextUtils.isEmpty(ysVar.w())) ? TextUtils.isEmpty(ysVar.c()) ? 402 : 418 : (ysVar.xv() == 1 || ysVar.xv() == 2) ? 200 : 403;
    }

    private static int c(com.bytedance.sdk.openadsdk.core.u.sr srVar) {
        if (srVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(srVar.w()) ? 407 : 200;
    }

    private static int c(List<com.bytedance.sdk.openadsdk.core.u.gb> list) {
        if (list == null) {
            return 409;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (com.bytedance.sdk.openadsdk.core.u.gb gbVar : list) {
            if (gbVar == null) {
                return 411;
            }
            if (TextUtils.isEmpty(gbVar.c())) {
                return 412;
            }
        }
        return 200;
    }
}
