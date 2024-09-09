package com.qq.e.comm.plugin.g0;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar, JSONObject jSONObject) {
        eVar.f43510b = jSONObject.optString("cl");
        eVar.f43513c = jSONObject.optString("txt");
        eVar.f43516d = jSONObject.optString("title");
        eVar.f43519e = jSONObject.optString("desc");
        eVar.f43522f = jSONObject.optString("img");
        eVar.f43525g = jSONObject.optString("img2");
        eVar.f43527h = jSONObject.optInt("pic_width");
        eVar.f43529i = jSONObject.optInt("pic_height");
        eVar.f43531j = jSONObject.optString("apurl");
        eVar.f43533k = jSONObject.optString("v_apurl");
        eVar.f43535l = jSONObject.optString("rl");
        eVar.f43537m = jSONObject.optString("customizedpingurl");
        eVar.f43539n = jSONObject.optInt("producttype");
        eVar.f43541o = jSONObject.optInt("dest_type");
        eVar.f43545q = jSONObject.optString("landing_page_report_url");
        eVar.f43547r = jSONObject.optString("traceid");
        eVar.f43549s = jSONObject.optString("token");
        eVar.f43551t = jSONObject.optString("netlog_traceid");
        eVar.f43555v = jSONObject.optInt("app_landing_page") == 1;
        eVar.f43557w = jSONObject.optInt("alpdl") == 1;
        eVar.f43559x = jSONObject.optString("template_id");
        eVar.f43561y = jSONObject.optInt("template_width");
        eVar.f43563z = jSONObject.optInt("template_height");
        eVar.B = jSONObject.optString("video_tracking_url");
        eVar.F = jSONObject.optInt("ecpm", -1);
        eVar.G = jSONObject.optString("ecpm_level");
        eVar.I = jSONObject.optInt("buyingtype", 1);
        JSONObject optJSONObject = jSONObject.optJSONObject("ssp_ext");
        if (optJSONObject != null) {
            eVar.J = new i0(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("component");
        if (optJSONObject2 != null) {
            eVar.N = new h(optJSONObject2);
        }
        eVar.O = jSONObject.optInt("sub_type");
        eVar.P = jSONObject.optString("video");
        eVar.Q = jSONObject.optBoolean("is_vhd");
        eVar.R = jSONObject.optInt("video_width");
        eVar.S = jSONObject.optInt("video_height");
        eVar.T = jSONObject.optInt("video_duration");
        eVar.U = e0.a(jSONObject.optJSONArray("report_url"));
        eVar.V = e0.a(jSONObject.optJSONArray("report_url_sdk"));
        eVar.W = a0.b(jSONObject.optJSONArray("click_mo_url"));
        eVar.X = a0.b(jSONObject.optJSONArray("click_mo_url_sdk"));
        eVar.Z = jSONObject.optString("video_widget_url");
        eVar.f43508a0 = jSONObject.optString("button_txt");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("app_state_txt");
        if (optJSONObject3 != null) {
            eVar.f43511b0 = new c(optJSONObject3);
        }
        eVar.f43514c0 = jSONObject.optString("compliance_button_txt");
        eVar.f43517d0 = jSONObject.optInt("mini_program_type");
        eVar.f43520e0 = jSONObject.optString("customized_invoke_url");
        eVar.f43526g0 = jSONObject.optInt("app_store") == 1;
        eVar.f43528h0 = jSONObject.optString("productid");
        eVar.f43530i0 = new b0(jSONObject.optJSONObject("posCfg"));
        eVar.f43534k0 = a0.b(jSONObject.optJSONArray("screenshot_url_list"));
        eVar.f43536l0 = jSONObject.optString("app_info_url");
        eVar.f43538m0 = jSONObject.optInt("bxg_restrict") == 1;
        eVar.f43540n0 = jSONObject.optBoolean("is_fullscreen");
        eVar.f43542o0 = jSONObject.optString("local_trace_id");
        eVar.f43546q0 = jSONObject.optInt("ad_expire");
        eVar.f43548r0 = jSONObject.optString("ip_ping_url");
        eVar.f43550s0 = jSONObject.optString("requrl");
        eVar.f43552t0 = jSONObject.optString("wechat_canvas_ext_info");
        eVar.f43554u0 = jSONObject.optString("wxappid");
        eVar.f43556v0 = jSONObject.optInt("is_reward_ad") == 1;
        eVar.f43558w0 = jSONObject.optString("ssv_report_url");
        eVar.f43560x0 = jSONObject.optString("nurl");
        eVar.f43562y0 = jSONObject.optString("lurl");
        eVar.f43564z0 = jSONObject.optInt("interactive_type");
        eVar.A0 = jSONObject.optLong("support_mf");
        eVar.B0 = jSONObject.optInt("is_new_template") == 1;
        JSONObject optJSONObject4 = jSONObject.optJSONObject("tpl_info_native");
        if (optJSONObject4 != null) {
            eVar.C0 = new y(optJSONObject4);
        }
        eVar.D0 = jSONObject.optInt("cpsf");
        eVar.E0 = jSONObject.optDouble(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);
        eVar.F0 = jSONObject.optString("complaint_url");
        eVar.G0 = jSONObject.optString("quick_app_link");
        eVar.H0 = jSONObject.optInt("custom_click_logic");
        eVar.I0 = jSONObject.optInt("isml") == 1;
        eVar.J0 = jSONObject.optString("ext3");
        eVar.K0 = jSONObject.optInt("ad_index");
        eVar.L0 = jSONObject.optInt("prld");
        eVar.M0 = jSONObject.optJSONObject("reward_content");
        eVar.X0 = jSONObject.optLong("adCachedTime");
    }
}
