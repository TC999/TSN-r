package com.umeng.analytics.pro;

import com.amap.api.services.district.DistrictSearchQuery;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import io.netty.handler.codec.rtsp.RtspHeaders;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.umeng.analytics.pro.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UContent {

    /* renamed from: A */
    public static final String f38070A = "ts";

    /* renamed from: B */
    public static final String f38071B = "locations";

    /* renamed from: C */
    public static final String f38072C = "lat";

    /* renamed from: D */
    public static final String f38073D = "lng";

    /* renamed from: E */
    public static final String f38074E = "ts";

    /* renamed from: F */
    public static final String f38075F = "traffic";

    /* renamed from: G */
    public static final String f38076G = "upload_traffic";

    /* renamed from: H */
    public static final String f38077H = "download_traffic";

    /* renamed from: I */
    public static final String f38078I = "activate_msg";

    /* renamed from: J */
    public static final String f38079J = "ts";

    /* renamed from: K */
    public static final String f38080K = "group_info";

    /* renamed from: L */
    public static final String f38081L = "active_user";

    /* renamed from: M */
    public static final String f38082M = "provider";

    /* renamed from: N */
    public static final String f38083N = "puid";

    /* renamed from: O */
    public static final String f38084O = "_$!mobile";

    /* renamed from: P */
    public static final String f38085P = "_$!email";

    /* renamed from: Q */
    public static final String f38086Q = "_#$$$";

    /* renamed from: R */
    public static final String f38087R = "up";

    /* renamed from: S */
    public static final String f38088S = "pk";

    /* renamed from: T */
    public static final String f38089T = "pv";

    /* renamed from: U */
    public static final String f38090U = "error";

    /* renamed from: V */
    public static final String f38091V = "ts";

    /* renamed from: W */
    public static final String f38092W = "error_source";

    /* renamed from: X */
    public static final String f38093X = "context";

    /* renamed from: Y */
    public static final String f38094Y = "ekv";

    /* renamed from: Z */
    public static final String f38095Z = "gkv";

    /* renamed from: a */
    public static final String f38096a = "appkey";

    /* renamed from: aB */
    public static final String f38098aB = "_$pp";

    /* renamed from: aC */
    public static final String f38099aC = "session";

    /* renamed from: aD */
    public static final String f38100aD = "pageview";

    /* renamed from: aE */
    public static final String f38101aE = "versioncode";

    /* renamed from: aF */
    public static final String f38102aF = "versionname";

    /* renamed from: aG */
    public static final String f38103aG = "userlevel";

    /* renamed from: aH */
    public static final String f38104aH = "eof";

    /* renamed from: aI */
    public static final String f38105aI = "exception";

    /* renamed from: aa */
    public static final String f38111aa = "id";

    /* renamed from: ab */
    public static final String f38112ab = "ts";

    /* renamed from: ad */
    public static final String f38114ad = "userlevel";

    /* renamed from: af */
    public static final String f38116af = "dplus";

    /* renamed from: ag */
    public static final String f38117ag = "analytics";

    /* renamed from: ah */
    public static final String f38118ah = "push";

    /* renamed from: ai */
    public static final String f38119ai = "share";

    /* renamed from: aj */
    public static final String f38120aj = "content";

    /* renamed from: ak */
    public static final String f38121ak = "header";

    /* renamed from: al */
    public static final String f38122al = "ds";

    /* renamed from: am */
    public static final String f38123am = "pn";

    /* renamed from: an */
    public static final String f38124an = "pro_ver";

    /* renamed from: ao */
    public static final String f38125ao = "1.0.0";

    /* renamed from: ap */
    public static final String f38126ap = "atm";

    /* renamed from: aq */
    public static final String f38127aq = "st";

    /* renamed from: at */
    public static final String f38130at = "ekv_bl_ver";

    /* renamed from: au */
    public static final String f38131au = "ekv_wl_ver";

    /* renamed from: av */
    public static final String f38132av = "$ekv_bl_ver";

    /* renamed from: aw */
    public static final String f38133aw = "$ekv_wl_ver";

    /* renamed from: ax */
    public static final String f38134ax = "events";

    /* renamed from: b */
    public static final String f38137b = "channel";

    /* renamed from: c */
    public static final String f38138c = "secret";

    /* renamed from: d */
    public static final String f38139d = "app_version";

    /* renamed from: e */
    public static final String f38140e = "version_code";

    /* renamed from: f */
    public static final String f38141f = "wrapper_type";

    /* renamed from: g */
    public static final String f38142g = "wrapper_version";

    /* renamed from: h */
    public static final String f38143h = "sdk_version";

    /* renamed from: i */
    public static final String f38144i = "vertical_type";

    /* renamed from: j */
    public static final String f38145j = "device_id";

    /* renamed from: k */
    public static final String f38146k = "device_model";

    /* renamed from: l */
    public static final String f38147l = "$pr_ve";

    /* renamed from: m */
    public static final String f38148m = "$ud_da";

    /* renamed from: n */
    public static final String f38149n = "sessions";

    /* renamed from: o */
    public static final String f38150o = "id";

    /* renamed from: p */
    public static final String f38151p = "start_time";

    /* renamed from: q */
    public static final String f38152q = "end_time";

    /* renamed from: r */
    public static final String f38153r = "duration";

    /* renamed from: s */
    public static final String f38154s = "duration_old";

    /* renamed from: t */
    public static final String f38155t = "pages";

    /* renamed from: u */
    public static final String f38156u = "autopages";

    /* renamed from: v */
    public static final String f38157v = "page_name";

    /* renamed from: w */
    public static final String f38158w = "duration";

    /* renamed from: x */
    public static final String f38159x = "page_start";

    /* renamed from: y */
    public static final String f38160y = "type";

    /* renamed from: z */
    public static final String f38161z = "$page_num";

    /* renamed from: ar */
    public static final String f38128ar = PathCenter.m14695b().m14694b(PathCenter.f37701t);

    /* renamed from: as */
    public static final String f38129as = PathCenter.m14695b().m14694b(PathCenter.f37702u);

    /* renamed from: aJ */
    public static final String f38106aJ = "_$!deep_link";

    /* renamed from: aK */
    public static final String f38107aK = "_$!link";

    /* renamed from: aL */
    public static final String[] f38108aL = {f38106aJ, f38107aK};

    /* renamed from: ac */
    public static final String f38113ac = "du";

    /* renamed from: ae */
    public static final String f38115ae = "$st_fl";

    /* renamed from: aA */
    public static final String f38097aA = "_$sp";

    /* renamed from: aM */
    public static final String[] f38109aM = {"id", "ts", f38113ac, f38115ae, "ds", "pn", f38097aA};

    /* renamed from: ay */
    public static final String f38135ay = "_$!ts";

    /* renamed from: az */
    public static final String f38136az = "_$!id";

    /* renamed from: aN */
    public static final String[] f38110aN = {f38135ay, f38136az, "_$!du", "_$!c", f38115ae, "_$!sp", "event_name", BidResponsed.KEY_TOKEN, RtspHeaders.Values.TIME, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "country", "region", DistrictSearchQuery.KEYWORDS_CITY, "browser", "os", UMCommonContent.f37749F, "device_version", UMCommonContent.f37805ai, "screen_width", "screen_height", "referrer", "referrer_domain", "initial_referrer", "initial_referrer_domain", "initial_view_time", "search_engine", "keyword", "ali_lib", "utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign", "date", "hour", "minute", "app_version", "sp"};
}
