package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.p472db.p473a.ReplaceTempDaoMiddle;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.system.NoProGuard;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CampaignEx extends DomainCampaignEx implements NoProGuard, Serializable {
    public static final int CAMPAIN_NV_T2_VALUE_3 = 3;
    public static final int CAMPAIN_NV_T2_VALUE_4 = 4;
    public static final String CLICKMODE_ON = "5";
    public static final int CLICK_TIMEOUT_INTERVAL_DEFAULT_VALUE = 2;
    public static final int C_UA_DEFAULT_VALUE = 1;
    private static final int DEFAULT_READY_RATE = 100;
    public static final String ENDCARD_URL = "endcard_url";
    public static final int FLAG_DEFAULT_SPARE_OFFER = -1;
    public static final int FLAG_IS_SPARE_OFFER = 1;
    public static final int FLAG_NOT_SPARE_OFFER = 0;
    public static final int IMP_UA_DEFAULT_VALUE = 1;
    public static final String JSON_AD_IMP_KEY = "sec";
    public static final String JSON_AD_IMP_VALUE = "url";
    public static final String JSON_KEY_ADVIMP = "adv_imp";
    public static final String JSON_KEY_AD_AKS = "aks";
    public static final String JSON_KEY_AD_AL = "al";
    public static final String JSON_KEY_AD_HTML = "ad_html";
    public static final String JSON_KEY_AD_K = "k";
    public static final String JSON_KEY_AD_MP = "mp";
    public static final String JSON_KEY_AD_Q = "q";
    public static final String JSON_KEY_AD_R = "r";
    public static final String JSON_KEY_AD_SOURCE_ID = "ad_source_id";
    public static final String JSON_KEY_AD_TMP_IDS = "tmp_ids";
    public static final String JSON_KEY_AD_TRACKING_DROPOUT_TRACK = "dropout_track";
    public static final String JSON_KEY_AD_TRACKING_IMPRESSION_T2 = "impression_t2";
    public static final String JSON_KEY_AD_TRACKING_PLYCMPT_TRACK = "plycmpt_track";
    public static final String JSON_KEY_AD_URL_LIST = "ad_url_list";
    public static final String JSON_KEY_AD_ZIP = "ad_tpl_url";
    public static final String JSON_KEY_APP_SIZE = "app_size";
    public static final String JSON_KEY_BANNER_HTML = "banner_html";
    public static final String JSON_KEY_BANNER_URL = "banner_url";
    public static final String JSON_KEY_BTY = "ctype";
    public static final String JSON_KEY_CAMPAIGN_UNITID = "unitId";
    public static final String JSON_KEY_CLICK_INTERVAL = "c_ct";
    public static final String JSON_KEY_CLICK_MODE = "click_mode";
    public static final String JSON_KEY_CLICK_TIMEOUT_INTERVAL = "c_toi";
    public static final String JSON_KEY_CLICK_URL = "click_url";
    public static final String JSON_KEY_CREATIVE_ID = "creative_id";
    public static final String JSON_KEY_CTA_TEXT = "ctatext";
    public static final String JSON_KEY_C_UA = "c_ua";
    public static final String JSON_KEY_DEEP_LINK_URL = "deep_link";
    public static final String JSON_KEY_DESC = "desc";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_ENDCARD_CLICK = "endcard_click_result";
    public static final String JSON_KEY_EXT_DATA = "ext_data";
    public static final String JSON_KEY_FAC = "fac";
    public static final String JSON_KEY_FCA = "fca";
    public static final String JSON_KEY_FCB = "fcb";
    public static final String JSON_KEY_FLB = "flb";
    public static final String JSON_KEY_FLB_SKIP_TIME = "flb_skiptime";
    public static final String JSON_KEY_GIF_URL = "gif_url";
    public static final String JSON_KEY_GUIDELINES = "guidelines";
    public static final String JSON_KEY_HASMBTPLMARK = "hasMBTplMark";
    public static final String JSON_KEY_HB = "hb";
    public static final String JSON_KEY_ICON_URL = "icon_url";
    public static final String JSON_KEY_ID = "id";
    public static final String JSON_KEY_IMAGE_SIZE = "image_size";
    public static final String JSON_KEY_IMAGE_URL = "image_url";
    public static final String JSON_KEY_IMPRESSION_URL = "impression_url";
    public static final String JSON_KEY_IMP_UA = "imp_ua";
    public static final String JSON_KEY_JM_PD = "jm_pd";
    public static final String JSON_KEY_LANDING_TYPE = "landing_type";
    public static final String JSON_KEY_LINK_TYPE = "link_type";
    public static final String JSON_KEY_MAITVE = "maitve";
    public static final String JSON_KEY_MAITVESRC = "maitve_src";
    public static final String JSON_KEY_MRAID = "mraid";
    public static final String JSON_KEY_MRAIDFORH5 = "mraid_src";
    public static final String JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T = "adspace_t";
    public static final String JSON_KEY_NEW_INTERSTITIAL_CBD = "cbd";
    public static final String JSON_KEY_NEW_INTERSTITIAL_VST = "vst";
    public static final String JSON_KEY_NOTICE_URL = "notice_url";
    public static final String JSON_KEY_NUMBER_RATING = "number_rating";
    public static final String JSON_KEY_NV_T2 = "nv_t2";
    public static final String JSON_KEY_OFFER_TYPE = "offer_type";
    public static final String JSON_KEY_PACKAGE_NAME = "package_name";
    public static final String JSON_KEY_PLCT = "plct";
    public static final String JSON_KEY_PLCTB = "plctb";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_READY_RATE = "ready_rate";
    public static final String JSON_KEY_RETARGET_OFFER = "retarget_offer";
    public static final String JSON_KEY_RETARGET_TYPE = "rtins_type";
    public static final String JSON_KEY_REWARD_AMOUNT = "reward_amount";
    public static final String JSON_KEY_REWARD_NAME = "reward_name";
    public static final String JSON_KEY_REWARD_PLUS = "rw_pl";
    public static final String JSON_KEY_REWARD_TEMPLATE = "rv";
    public static final String JSON_KEY_REWARD_VIDEO_MD5 = "md5_file";
    public static final String JSON_KEY_RS_IGNORE_CHECK_RULE = "rs_ignc_r";
    public static final String JSON_KEY_STAR = "rating";
    public static final String JSON_KEY_ST_IEX = "iex";
    public static final String JSON_KEY_ST_TS = "ts";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TIMESTAMP = "timestamp";
    public static final String JSON_KEY_TITLE = "title";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_TP_OFFER = "tp_offer";
    public static final String JSON_KEY_T_IMP = "t_imp";
    public static final String JSON_KEY_USER_ACTIVATION = "user_activation";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String JSON_KEY_VIDEO_CHECK_TYPE = "vck_t";
    public static final String JSON_KEY_VIDEO_COMPLETE_TIME = "view_com_time";
    public static final String JSON_KEY_VIDEO_CTN_TYPE = "vctn_t";
    public static final String JSON_KEY_VIDEO_LENGTHL = "video_length";
    public static final String JSON_KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String JSON_KEY_VIDEO_SIZE = "video_size";
    public static final String JSON_KEY_VIDEO_URL = "video_url";
    public static final String JSON_KEY_WATCH_MILE = "watch_mile";
    public static final String JSON_KEY_WITHOUT_INSTALL_CHECK = "wtick";
    public static final String JSON_NATIVE_VIDEO_AD_TRACKING = "ad_tracking";
    public static final String JSON_NATIVE_VIDEO_CLICK = "click";
    public static final String JSON_NATIVE_VIDEO_CLOSE = "close";
    public static final String JSON_NATIVE_VIDEO_COMPLETE = "complete";
    public static final String JSON_NATIVE_VIDEO_ENDCARD = "endcard";
    public static final String JSON_NATIVE_VIDEO_ENDCARD_SHOW = "endcard_show";
    public static final String JSON_NATIVE_VIDEO_ERROR = "error";
    public static final String JSON_NATIVE_VIDEO_FIRST_QUARTILE = "first_quartile";
    public static final String JSON_NATIVE_VIDEO_MIDPOINT = "midpoint";
    public static final String JSON_NATIVE_VIDEO_MUTE = "mute";
    public static final String JSON_NATIVE_VIDEO_PAUSE = "pause";
    public static final String JSON_NATIVE_VIDEO_PLAY_PERCENTAGE = "play_percentage";
    public static final String JSON_NATIVE_VIDEO_RESUME = "resume";
    public static final String JSON_NATIVE_VIDEO_START = "start";
    public static final String JSON_NATIVE_VIDEO_THIRD_QUARTILE = "third_quartile";
    public static final String JSON_NATIVE_VIDEO_UNMUTE = "unmute";
    public static final String JSON_NATIVE_VIDEO_VIDEO_CLICK = "video_click";
    public static final String JSON_NATIVE_VIDOE_IMPRESSION = "impression";
    public static final String KEY_ADCHOICE = "adchoice";
    public static final String KEY_AD_TYPE = "ad_type";
    public static final String KEY_IA_CACHE = "ia_cache";
    public static final String KEY_IA_EXT1 = "ia_ext1";
    public static final String KEY_IA_EXT2 = "ia_ext2";
    public static final String KEY_IA_ICON = "ia_icon";
    public static final String KEY_IA_ORI = "ia_ori";
    public static final String KEY_IA_RST = "ia_rst";
    public static final String KEY_IA_URL = "ia_url";
    public static final String KEY_IS_CMPT_ENTRY = "cmpt=1";
    public static final String KEY_IS_DOWNLOAD = "is_download_zip";
    public static final String KEY_OC_TIME = "oc_time";
    public static final String KEY_OC_TYPE = "oc_type";
    public static final String KEY_OMID = "omid";
    public static final String KEY_T_LIST = "t_list";
    public static final int LANDING_TYPE_VALUE_OPEN_BROWSER = 1;
    public static final int LANDING_TYPE_VALUE_OPEN_GP_BY_PACKAGE = 3;
    public static final int LANDING_TYPE_VALUE_OPEN_WEBVIEW = 2;
    public static final int LINK_TYPE_1 = 1;
    public static final int LINK_TYPE_2 = 2;
    public static final int LINK_TYPE_3 = 3;
    public static final int LINK_TYPE_4 = 4;
    public static final int LINK_TYPE_8 = 8;
    public static final int LINK_TYPE_9 = 9;
    public static final int LINK_TYPE_MINI_PROGRAM = 12;
    public static final int NEW_INTERSTITIAL_DEFAULT_AD_SPACE_T = 1;
    public static final int NEW_INTERSTITIAL_DEFAULT_CBD = -2;
    public static final int NEW_INTERSTITIAL_DEFAULT_VST = -2;
    public static final String PLAYABLE_ADS_WITHOUT_VIDEO = "playable_ads_without_video";
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_DEFAULT = 1;
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_ENDCARD = 2;
    public static final int RETAR_GETING_IS = 1;
    public static final int RETAR_GETING_NOT = 2;
    public static final int RTINS_TYPE_DONE = 1;
    public static final int RTINS_TYPE_NOT_DONE = 2;
    public static final String TAG = CampaignEx.class.getSimpleName();
    public static final String VIDEO_END_TYPE = "video_end_type";
    public static final int VIDEO_END_TYPE_BROWSER = 5;
    public static final int VIDEO_END_TYPE_DEFAULT = 2;
    public static final int VIDEO_END_TYPE_FINISH = 1;
    public static final int VIDEO_END_TYPE_NATIVE = 100;
    public static final int VIDEO_END_TYPE_REULSE = 2;
    public static final int VIDEO_END_TYPE_VAST = 3;
    public static final int VIDEO_END_TYPE_WEBVIEW = 4;
    private static final long serialVersionUID = 1;
    private String CMPTEntryUrl;
    private int adSpaceT;
    private int adType;
    private String ad_url_list;
    private C11315a adchoice;
    private String advImp;
    private HashMap<String, String> aks;

    /* renamed from: al */
    private String f30376al;
    private int bty;
    private long cVersionCode;
    private int cacheLevel;
    private String campaignUnitId;
    private int cbt;
    private int clickInterval;
    private String click_mode;
    private String endScreenUrl;
    private int endcard_click_result;
    private String endcard_url;
    private String ext_data;
    private int fca;
    private int fcb;
    private int flb;
    private int flbSkipTime;
    private String gifUrl;
    private String guidelines;
    private boolean hasMBTplMark;
    private String htmlUrl;
    private String ia_ext1;
    private String ia_ext2;
    private int iex;
    private String interactiveCache;
    private int isAddSuccesful;
    private boolean isBidCampaign;
    private boolean isCallbacked;
    private int isClick;
    private int isDeleted;
    private int isDownLoadZip;
    private boolean isMraid;
    private boolean isReport;
    private boolean isReportClick;
    private int jmPd;
    private CommonJumpLoader.JumpLoaderResult jumpResult;

    /* renamed from: k */
    private String f30377k;
    private String keyIaIcon;
    private int keyIaOri;
    private int keyIaRst;
    private String keyIaUrl;
    private String label;
    private String landingType;
    private int linkType;
    private int maitve;
    private String maitve_src;
    private C11316b mediaViewHolder;
    private String mof_template_url;
    private int mof_tplid;

    /* renamed from: mp */
    private String f30378mp;
    private String mraid;
    private NativeVideoTracking nativeVideoTracking;
    private String nativeVideoTrackingString;
    private int oc_time;
    private int offerType;
    private String pkgSource;
    private String placementId;
    private List<String> pv_urls;

    /* renamed from: q */
    private String f30379q;

    /* renamed from: r */
    private String f30380r;
    private String req_ext_data;
    private String requestId;
    private String requestIdNotice;
    private int retarget_offer;
    private int rewardAmount;
    private int rewardPlayStatus;
    public RewardPlus rewardPlus;
    private C11317c rewardTemplateMode;
    private String reward_name;
    private ArrayList<Integer> rsIgnoreCheckRule;
    private int rtinsType;
    private int t_imp;
    private String t_list;
    private int template;

    /* renamed from: ts */
    private long f30381ts;
    private String videoResolution;
    private int videoSize;
    private int watchMile;
    private int readyState = 1;
    private String adZip = "";
    private String adHtml = "";
    private boolean isReady = false;
    private int tpOffer = 0;
    private int fac = 0;
    private int cbd = -2;
    private int vst = -2;
    private long plct = 0;
    private long plctb = 0;
    private String bannerUrl = "";
    private String bannerHtml = "";
    private long creativeId = 0;
    private int vcn = 0;
    private int tokenRule = 0;
    private String encryptPrice = "";
    private boolean isDynamicView = false;
    private int dynamicTempCode = 0;
    private boolean campaignIsFiltered = false;
    private int videoCompleteTime = 0;
    private int spareOfferFlag = -1;
    private int oc_type = 0;
    private int impUA = 1;
    private int cUA = 1;
    private int nvT2 = 6;
    private int tab = -1;
    private String impressionURL = "";
    private String noticeUrl = "";
    private String clickURL = "";
    private int wtick = 0;
    private String deepLinkUrl = "";
    private boolean userActivation = false;
    private String onlyImpressionURL = "";
    private String imageSize = "";
    private boolean isCallBackImpression = false;
    private String videoUrlEncode = "";
    private String bidToken = "";
    private int video_end_type = 2;
    public String videoMD5Value = "";
    private int ready_rate = -1;
    private int nscpt = 1;
    private int loadTimeoutState = 0;
    private int clickTimeOutInterval = 2;
    private int playable_ads_without_video = 1;
    private boolean hasReportAdTrackPause = false;
    private String omid = null;
    private int videoCheckType = 2;
    private int videoCtnType = 1;
    private int isTimeoutCheckVideoStatus = -1;
    private boolean canStart2C1Anim = false;
    private boolean canStartMoreOfferAnim = false;
    private int videoPlayProgress = 0;

    /* renamed from: com.mbridge.msdk.foundation.entity.CampaignEx$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11315a implements Serializable {

        /* renamed from: a */
        private String f30382a = "";

        /* renamed from: b */
        private String f30383b = "";

        /* renamed from: c */
        private String f30384c = "";

        /* renamed from: d */
        private String f30385d = "";

        /* renamed from: e */
        private String f30386e = "";

        /* renamed from: f */
        private String f30387f = "";

        /* renamed from: g */
        private String f30388g = "";

        /* renamed from: h */
        private String f30389h = "";

        /* renamed from: i */
        private int f30390i = 0;

        /* renamed from: j */
        private int f30391j = 0;

        /* renamed from: k */
        private String f30392k = "";

        /* renamed from: a */
        public final int m22651a() {
            return this.f30390i;
        }

        /* renamed from: b */
        public final int m22648b() {
            return this.f30391j;
        }

        /* renamed from: c */
        public final String m22646c() {
            return this.f30392k;
        }

        /* renamed from: d */
        public final String m22644d() {
            return this.f30383b;
        }

        /* renamed from: e */
        public final String m22643e() {
            return this.f30384c;
        }

        /* renamed from: f */
        public final String m22642f() {
            return this.f30385d;
        }

        /* renamed from: a */
        public static C11315a m22650a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return m22649a(new JSONObject(str));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        /* renamed from: b */
        private static int m22647b(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 1) {
                    return Integer.parseInt(split[1]);
                }
            } catch (NumberFormatException | Exception unused) {
            }
            return 0;
        }

        /* renamed from: c */
        private static int m22645c(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 0) {
                    return Integer.parseInt(split[0]);
                }
            } catch (NumberFormatException | Exception unused) {
            }
            return 0;
        }

        /* renamed from: a */
        private static C11315a m22649a(JSONObject jSONObject) {
            C11315a c11315a;
            C11315a c11315a2 = null;
            if (jSONObject != null) {
                try {
                    c11315a = new C11315a();
                } catch (Exception e) {
                    e = e;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    c11315a.f30384c = jSONObject.optString("adchoice_icon");
                    c11315a.f30383b = jSONObject.optString("adchoice_link");
                    String optString = jSONObject.optString("adchoice_size");
                    c11315a.f30385d = optString;
                    c11315a.f30382a = jSONObject.optString("ad_logo_link");
                    c11315a.f30389h = jSONObject.optString("adv_logo");
                    c11315a.f30388g = jSONObject.optString("adv_name");
                    c11315a.f30387f = jSONObject.optString("platform_logo");
                    c11315a.f30386e = jSONObject.optString("platform_name");
                    c11315a.f30391j = m22647b(optString);
                    c11315a.f30390i = m22645c(optString);
                    c11315a.f30392k = jSONObject.toString();
                    return c11315a;
                } catch (Exception e2) {
                    e = e2;
                    c11315a2 = c11315a;
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return c11315a2;
                    }
                    return c11315a2;
                } catch (Throwable th2) {
                    th = th2;
                    c11315a2 = c11315a;
                    if (MBridgeConstans.DEBUG) {
                        th.printStackTrace();
                        return c11315a2;
                    }
                    return c11315a2;
                }
            }
            return null;
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.entity.CampaignEx$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11316b implements Serializable {

        /* renamed from: a */
        public boolean f30393a = false;

        /* renamed from: b */
        public boolean f30394b = false;

        /* renamed from: c */
        public boolean f30395c = false;

        /* renamed from: d */
        public boolean f30396d = false;

        /* renamed from: e */
        public boolean f30397e = false;

        /* renamed from: f */
        public boolean f30398f = false;

        /* renamed from: g */
        public boolean f30399g = false;

        /* renamed from: h */
        public boolean f30400h = false;

        /* renamed from: i */
        public boolean f30401i = false;

        /* renamed from: j */
        public boolean f30402j = false;

        /* renamed from: k */
        public boolean f30403k = false;

        /* renamed from: l */
        public Map<Integer, String> f30404l;
    }

    /* renamed from: com.mbridge.msdk.foundation.entity.CampaignEx$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11317c implements Serializable {

        /* renamed from: a */
        private String f30405a;

        /* renamed from: b */
        private int f30406b;

        /* renamed from: c */
        private int f30407c;

        /* renamed from: d */
        private String f30408d;

        /* renamed from: e */
        private String f30409e;

        /* renamed from: f */
        private List<C11318a> f30410f;

        /* renamed from: com.mbridge.msdk.foundation.entity.CampaignEx$c$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static final class C11318a implements Serializable {

            /* renamed from: a */
            public String f30411a;

            /* renamed from: b */
            public List<String> f30412b = new ArrayList();
        }

        private C11317c(String str) {
            this.f30405a = str;
        }

        /* renamed from: b */
        public final int m22637b() {
            return this.f30406b;
        }

        /* renamed from: c */
        public final int m22636c() {
            return this.f30407c;
        }

        /* renamed from: d */
        public final String m22635d() {
            return this.f30408d;
        }

        /* renamed from: e */
        public final String m22634e() {
            return this.f30409e;
        }

        /* renamed from: f */
        public final List<C11318a> m22633f() {
            return this.f30410f;
        }

        /* renamed from: a */
        public final String m22641a() {
            return this.f30405a;
        }

        /* renamed from: a */
        public static C11317c m22639a(String str) {
            try {
                if (StringUtils.m21956b(str)) {
                    return m22638a(new JSONObject(str));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* renamed from: a */
        public static C11317c m22638a(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    if (StringUtils.m21956b(jSONObject.toString())) {
                        C11317c c11317c = new C11317c(jSONObject.toString());
                        c11317c.f30406b = jSONObject.optInt("video_template", 1);
                        c11317c.f30409e = jSONObject.optString("template_url");
                        c11317c.f30407c = jSONObject.optInt("orientation");
                        c11317c.f30408d = jSONObject.optString("paused_url");
                        JSONObject optJSONObject = jSONObject.optJSONObject(SocializeProtocolConstants.IMAGE);
                        if (optJSONObject != null) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys != null && keys.hasNext()) {
                                String next = keys.next();
                                List<String> m21996b = SameTool.m21996b(optJSONObject.optJSONArray(next));
                                if (m21996b != null && m21996b.size() > 0) {
                                    C11318a c11318a = new C11318a();
                                    c11318a.f30411a = next;
                                    c11318a.f30412b.addAll(m21996b);
                                    arrayList.add(c11318a);
                                }
                            }
                            c11317c.f30410f = arrayList;
                        }
                        return c11317c;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
    }

    public static NativeVideoTracking TrackingStr2Object(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                NativeVideoTracking nativeVideoTracking = new NativeVideoTracking();
                nativeVideoTracking.m22482r(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDOE_IMPRESSION)));
                nativeVideoTracking.m22504g(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_START)));
                nativeVideoTracking.m22502h(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                nativeVideoTracking.m22500i(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MIDPOINT)));
                nativeVideoTracking.m22498j(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                nativeVideoTracking.m22496k(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_COMPLETE)));
                nativeVideoTracking.m22517a(parsePlayCentage(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)));
                nativeVideoTracking.m22494l(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MUTE)));
                nativeVideoTracking.m22492m(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_UNMUTE)));
                nativeVideoTracking.m22490n(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLICK)));
                nativeVideoTracking.m22488o(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PAUSE)));
                nativeVideoTracking.m22486p(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_RESUME)));
                nativeVideoTracking.m22484q(processNativeVideoTrackingArray(jSONObject.optJSONArray("error")));
                nativeVideoTracking.m22481s(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD)));
                nativeVideoTracking.m22479u(processNativeVideoTrackingArray(jSONObject.optJSONArray("close")));
                nativeVideoTracking.m22480t(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD_SHOW)));
                nativeVideoTracking.m22478v(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_VIDEO_CLICK)));
                nativeVideoTracking.m22506f(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_IMPRESSION_T2)));
                nativeVideoTracking.m22516a(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_DROPOUT_TRACK)));
                nativeVideoTracking.m22514b(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK)));
                return DomainCampaignEx.trackingStr2Object(jSONObject, nativeVideoTracking);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx, boolean z, boolean z2) throws JSONException {
        JSONObject campaignToJsonObject = campaignToJsonObject(campaignEx);
        campaignToJsonObject.put("isReady", z);
        campaignToJsonObject.put("expired", z2);
        return campaignToJsonObject;
    }

    private static JSONObject dealV5Temp(JSONObject jSONObject) {
        JSONArray optJSONArray;
        try {
            if (!jSONObject.has(JSON_KEY_AD_TMP_IDS) || (optJSONArray = jSONObject.optJSONArray(JSON_KEY_AD_TMP_IDS)) == null || optJSONArray.length() <= 0) {
                return jSONObject;
            }
            jSONObject.remove(JSON_KEY_AD_TMP_IDS);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject m22812a = ReplaceTempDaoMiddle.m22814a().m22812a(optJSONArray.getString(i));
                if (m22812a != null) {
                    Iterator<String> keys = m22812a.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, m22812a.opt(next));
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private Map<Integer, String> generateAdImpression(String str) {
        HashMap hashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                HashMap hashMap2 = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        int optInt = optJSONObject.optInt(JSON_AD_IMP_KEY);
                        hashMap2.put(Integer.valueOf(optInt), optJSONObject.optString("url"));
                    } catch (Exception e) {
                        e = e;
                        hashMap = hashMap2;
                        e.printStackTrace();
                        return hashMap;
                    }
                }
                return hashMap2;
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static boolean isBreakCampainOrSetItByEndCard(CampaignEx campaignEx, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (MBSDKContext.m22865f().m22857n() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        campaignEx.setendcard_url(str);
        return false;
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z, CampaignUnit campaignUnit) {
        return parseCampaign(jSONObject, str, str2, str3, z, campaignUnit, "");
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject) {
        ArrayList arrayList;
        CampaignEx campaignEx = null;
        if (jSONObject != null) {
            try {
                CampaignEx campaignEx2 = new CampaignEx();
                try {
                    campaignEx2.setId(jSONObject.optString("id"));
                    campaignEx2.setAppName(jSONObject.optString("title"));
                    campaignEx2.setAppDesc(jSONObject.optString("desc"));
                    campaignEx2.setPackageName(jSONObject.optString("package_name"));
                    campaignEx2.setRtinsType(jSONObject.optInt(JSON_KEY_RETARGET_TYPE));
                    campaignEx2.setIconUrl(jSONObject.optString(JSON_KEY_ICON_URL));
                    campaignEx2.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
                    campaignEx2.setSize(jSONObject.optString(JSON_KEY_APP_SIZE));
                    campaignEx2.setImageSize(jSONObject.optString(JSON_KEY_IMAGE_SIZE));
                    campaignEx2.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
                    campaignEx2.setClickURL(jSONObject.optString(JSON_KEY_CLICK_URL));
                    campaignEx2.setRewardPlus(RewardPlus.parseByString(jSONObject.optString(JSON_KEY_REWARD_PLUS)));
                    campaignEx2.setWtick(jSONObject.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                    campaignEx2.setDeepLinkUrl(jSONObject.optString(JSON_KEY_DEEP_LINK_URL));
                    campaignEx2.setUserActivation(jSONObject.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                    campaignEx2.setNoticeUrl(jSONObject.optString(JSON_KEY_NOTICE_URL));
                    campaignEx2.setTemplate(jSONObject.optInt("template"));
                    campaignEx2.setType(jSONObject.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                    campaignEx2.setFca(jSONObject.optInt(JSON_KEY_FCA));
                    campaignEx2.setFcb(jSONObject.optInt(JSON_KEY_FCB));
                    campaignEx2.setEndcard_click_result(jSONObject.optInt(JSON_KEY_ENDCARD_CLICK));
                    if (!TextUtils.isEmpty(jSONObject.optString(JSON_KEY_STAR))) {
                        campaignEx2.setRating(Double.parseDouble(jSONObject.optString(JSON_KEY_STAR, "0")));
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString(JSON_KEY_NUMBER_RATING))) {
                        campaignEx2.setNumberRating(jSONObject.optInt(JSON_KEY_NUMBER_RATING, 333333));
                    }
                    campaignEx2.setClick_mode(jSONObject.optString(JSON_KEY_CLICK_MODE));
                    campaignEx2.setLandingType(jSONObject.optString(JSON_KEY_LANDING_TYPE));
                    campaignEx2.setLinkType(jSONObject.optInt(JSON_KEY_LINK_TYPE, 4));
                    campaignEx2.setClickInterval(jSONObject.optInt(JSON_KEY_CLICK_INTERVAL));
                    campaignEx2.setAdCall(jSONObject.optString(JSON_KEY_CTA_TEXT));
                    campaignEx2.setAd_url_list(jSONObject.optString(JSON_KEY_AD_URL_LIST));
                    campaignEx2.setRetarget_offer(jSONObject.optInt(JSON_KEY_RETARGET_OFFER, 2));
                    campaignEx2.setVideoUrlEncode(jSONObject.optString(JSON_KEY_VIDEO_URL));
                    campaignEx2.setVideoLength(jSONObject.optInt(JSON_KEY_VIDEO_LENGTHL));
                    campaignEx2.setVideoSize(jSONObject.optInt(JSON_KEY_VIDEO_SIZE));
                    campaignEx2.setVideoResolution(jSONObject.optString(JSON_KEY_VIDEO_RESOLUTION));
                    campaignEx2.setWatchMile(jSONObject.optInt(JSON_KEY_WATCH_MILE));
                    campaignEx2.setTimestamp(System.currentTimeMillis());
                    campaignEx2.setBty(jSONObject.optInt(JSON_KEY_BTY));
                    campaignEx2.setAdvImp(jSONObject.optString(JSON_KEY_ADVIMP));
                    campaignEx2.setTImp(jSONObject.optInt(JSON_KEY_T_IMP));
                    campaignEx2.setHtmlUrl(jSONObject.optString("html_url"));
                    campaignEx2.setEndScreenUrl(jSONObject.optString("end_screen_url"));
                    campaignEx2.setGuidelines(jSONObject.optString(JSON_KEY_GUIDELINES));
                    campaignEx2.setOfferType(jSONObject.optInt(JSON_KEY_OFFER_TYPE));
                    campaignEx2.setRewardName(jSONObject.optString("reward_name"));
                    campaignEx2.setRewardAmount(jSONObject.optInt("reward_amount"));
                    try {
                        if (jSONObject.has(JSON_NATIVE_VIDEO_AD_TRACKING)) {
                            String optString = jSONObject.optString(JSON_NATIVE_VIDEO_AD_TRACKING);
                            if (!TextUtils.isEmpty(optString)) {
                                campaignEx2.setNativeVideoTrackingString(optString);
                                campaignEx2.setNativeVideoTracking(TrackingStr2Object(optString));
                            }
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        campaignEx2.setReady_rate(jSONObject.optInt(JSON_KEY_READY_RATE, -1));
                        JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_EXT_DATA);
                        if (optJSONObject != null) {
                            campaignEx2.setExt_data(optJSONObject.toString());
                        }
                        campaignEx2.setMof_tplid(jSONObject.optInt(CampaignUnit.JSON_KEY_MOF_TPLID));
                        campaignEx2.setMof_template_url(jSONObject.optString(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL));
                        campaignEx2.setNscpt(jSONObject.optInt(CampaignUnit.JSON_KEY_NSCPT));
                        new JSONArray();
                        JSONArray optJSONArray = jSONObject.optJSONArray("pv_urls");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(optJSONArray.length());
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.optString(i));
                            }
                        }
                        campaignEx2.setPv_urls(arrayList);
                        JSONObject optJSONObject2 = jSONObject.optJSONObject(CampaignUnit.JSON_KEY_REQ_EXT_DATA);
                        if (optJSONObject2 != null) {
                            campaignEx2.setReq_ext_data(optJSONObject2.toString());
                        }
                    } catch (Exception unused2) {
                    }
                    campaignEx2.setVideo_end_type(jSONObject.optInt(VIDEO_END_TYPE, 2));
                    if (isBreakCampainOrSetItByEndCard(campaignEx2, jSONObject.optString(ENDCARD_URL))) {
                        return null;
                    }
                    campaignEx2.setPlayable_ads_without_video(jSONObject.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                    if (jSONObject.has(JSON_KEY_REWARD_VIDEO_MD5)) {
                        campaignEx2.setVideoMD5Value(jSONObject.optString(JSON_KEY_REWARD_VIDEO_MD5));
                    }
                    if (jSONObject.has(JSON_KEY_NV_T2)) {
                        campaignEx2.setNvT2(jSONObject.optInt(JSON_KEY_NV_T2));
                    }
                    if (jSONObject.has(JSON_KEY_GIF_URL)) {
                        campaignEx2.setGifUrl(jSONObject.optString(JSON_KEY_GIF_URL));
                    }
                    campaignEx2.setRewardTemplateMode(C11317c.m22638a(jSONObject.optJSONObject(JSON_KEY_REWARD_TEMPLATE)));
                    campaignEx2.setClickTimeOutInterval(jSONObject.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                    campaignEx2.setImpUA(jSONObject.optInt(JSON_KEY_IMP_UA, 1));
                    campaignEx2.setcUA(jSONObject.optInt(JSON_KEY_C_UA, 1));
                    campaignEx2.setJmPd(jSONObject.optInt(JSON_KEY_JM_PD));
                    campaignEx2.setKeyIaIcon(jSONObject.optString("ia_icon"));
                    campaignEx2.setKeyIaRst(jSONObject.optInt("ia_rst"));
                    campaignEx2.setKeyIaUrl(jSONObject.optString("ia_url"));
                    campaignEx2.setKeyIaOri(jSONObject.optInt("ia_ori"));
                    campaignEx2.setAdType(jSONObject.optInt("ad_type"));
                    campaignEx2.setTpOffer(jSONObject.optInt(JSON_KEY_TP_OFFER));
                    campaignEx2.setFac(jSONObject.optInt(JSON_KEY_FAC));
                    campaignEx2.setIa_ext1(jSONObject.optString(KEY_IA_EXT1));
                    campaignEx2.setIa_ext2(jSONObject.optString(KEY_IA_EXT2));
                    campaignEx2.setIsDownLoadZip(jSONObject.optInt(KEY_IS_DOWNLOAD));
                    campaignEx2.setInteractiveCache(jSONObject.optString(KEY_IA_CACHE));
                    campaignEx2.setOc_time(jSONObject.optInt(KEY_OC_TIME));
                    campaignEx2.setOc_type(jSONObject.optInt(KEY_OC_TYPE));
                    campaignEx2.setT_list(jSONObject.optString(KEY_T_LIST));
                    campaignEx2.setAdchoice(C11315a.m22650a(jSONObject.optString(KEY_ADCHOICE, "")));
                    campaignEx2.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
                    campaignEx2.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(KEY_OMID);
                    if (optJSONArray2 == null) {
                        if (!TextUtils.isEmpty(jSONObject.optString(KEY_OMID))) {
                            campaignEx2.setOmid(jSONObject.optString(KEY_OMID));
                        } else {
                            campaignEx2.setOmid(null);
                        }
                    } else {
                        campaignEx2.setOmid(optJSONArray2.toString());
                    }
                    campaignEx2.setCreativeId(jSONObject.optInt(JSON_KEY_CREATIVE_ID));
                    String optString2 = jSONObject.optString("cam_tpl_url");
                    Uri parse = Uri.parse(optString2);
                    if (!TextUtils.isEmpty(parse.getPath()) && (parse.getPath().endsWith(".zip") || parse.getPath().endsWith(".ZIP"))) {
                        campaignEx2.setAdZip(optString2);
                    } else {
                        campaignEx2.setBannerUrl(optString2);
                    }
                    campaignEx2.setBannerHtml(jSONObject.optString("cam_html"));
                    campaignEx2.setAdHtml(jSONObject.optString("cam_html"));
                    campaignEx2.setCampaignUnitId(jSONObject.optString(JSON_KEY_CAMPAIGN_UNITID));
                    String optString3 = jSONObject.optString(JSON_KEY_MRAID);
                    if (TextUtils.isEmpty(optString3)) {
                        optString3 = jSONObject.optString(JSON_KEY_MRAIDFORH5);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        campaignEx2.setIsMraid(true);
                        campaignEx2.setMraid(optString3);
                    } else if (!TextUtils.isEmpty(campaignEx2.getAdHtml()) && !campaignEx2.getAdHtml().contains("<MBTPLMARK>")) {
                        campaignEx2.setIsMraid(true);
                    } else {
                        campaignEx2.setIsMraid(false);
                    }
                    try {
                        String optString4 = jSONObject.optString("only_impression_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            campaignEx2.setOnlyImpressionURL(optString4);
                            Uri parse2 = Uri.parse(optString4);
                            if (parse2 != null) {
                                campaignEx2.setRequestId(parse2.getQueryParameter("k"));
                            }
                        }
                        String optString5 = jSONObject.optString(JSON_KEY_NOTICE_URL);
                        if (!TextUtils.isEmpty(optString5)) {
                            campaignEx2.setNoticeUrl(optString5);
                            Uri parse3 = Uri.parse(optString5);
                            if (parse3 != null) {
                                campaignEx2.setRequestIdNotice(parse3.getQueryParameter("k"));
                            }
                        }
                    } catch (Exception unused3) {
                    }
                    campaignEx2.setIsBidCampaign(jSONObject.optBoolean(JSON_KEY_HB, false));
                    campaignEx2.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
                    campaignEx2.setMaitve(jSONObject.optInt(JSON_KEY_MAITVE));
                    campaignEx2.setMaitve_src(jSONObject.optString(JSON_KEY_MAITVESRC));
                    campaignEx2.setFlb(jSONObject.optInt(JSON_KEY_FLB));
                    campaignEx2.setFlbSkipTime(jSONObject.optInt(JSON_KEY_FLB_SKIP_TIME));
                    campaignEx2.setCbd(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                    campaignEx2.setVst(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                    campaignEx2.setAdSpaceT(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                    CampaignEx parseCampaignWithBackData = DomainCampaignEx.parseCampaignWithBackData(jSONObject, campaignEx2);
                    parseCampaignWithBackData.setVcn(jSONObject.optInt("vcn"));
                    parseCampaignWithBackData.setTokenRule(jSONObject.optInt("token_r"));
                    parseCampaignWithBackData.setEncryptPrice(jSONObject.optString("encrypt_p"));
                    parseCampaignWithBackData.setVideoCompleteTime(jSONObject.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                    parseCampaignWithBackData.setVideoCheckType(jSONObject.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                    parseCampaignWithBackData.setVideoCtnType(jSONObject.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                    JSONArray optJSONArray3 = jSONObject.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                            arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i2)));
                        }
                        if (arrayList2.size() > 0) {
                            parseCampaignWithBackData.setRsIgnoreCheckRule(arrayList2);
                        }
                    }
                    return parseCampaignWithBackData;
                } catch (Exception e) {
                    e = e;
                    campaignEx = campaignEx2;
                    e.printStackTrace();
                    return campaignEx;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return campaignEx;
    }

    public static JSONArray parseCamplistToJson(List<CampaignEx> list) {
        JSONArray jSONArray = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        for (CampaignEx campaignEx : list) {
                            jSONArray2.put(campaignToJsonObject(campaignEx));
                        }
                        return jSONArray2;
                    } catch (Exception e) {
                        e = e;
                        jSONArray = jSONArray2;
                        e.printStackTrace();
                        return jSONArray;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return jSONArray;
    }

    private static List<Map<Integer, String>> parsePlayCentage(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap hashMap = new HashMap();
                        int i2 = jSONObject.getInt("rate");
                        hashMap.put(Integer.valueOf(i2), jSONObject.getString("url"));
                        arrayList.add(hashMap);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public static CampaignEx parseSettingCampaign(JSONObject jSONObject) {
        if (jSONObject != null) {
            CampaignEx campaignEx = new CampaignEx();
            campaignEx.setId(jSONObject.optString("campaignid"));
            campaignEx.setPackageName(jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME));
            campaignEx.setAppName(jSONObject.optString("title"));
            campaignEx.setAdCall(jSONObject.optString("cta"));
            campaignEx.setAppDesc(jSONObject.optString("desc"));
            campaignEx.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
            campaignEx.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
            campaignEx.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
            campaignEx.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
            campaignEx.setAdHtml(jSONObject.optString(JSON_KEY_AD_HTML));
            campaignEx.setAdZip(jSONObject.optString(JSON_KEY_AD_ZIP));
            campaignEx.setBannerUrl(jSONObject.optString(JSON_KEY_BANNER_URL));
            campaignEx.setBannerHtml(jSONObject.optString(JSON_KEY_BANNER_HTML));
            campaignEx.setCreativeId(jSONObject.optInt(JSON_KEY_CREATIVE_ID));
            campaignEx.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
            return campaignEx;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] processNativeVideoTrackingArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdSpaceT() {
        return this.adSpaceT;
    }

    public int getAdType() {
        return this.adType;
    }

    public List<String> getAdUrlList() {
        Exception e;
        ArrayList arrayList;
        String ad_url_list = getAd_url_list();
        try {
        } catch (Exception e2) {
            e = e2;
            arrayList = null;
        }
        if (TextUtils.isEmpty(ad_url_list)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(ad_url_list);
        arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.optString(i));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public String getAd_url_list() {
        return this.ad_url_list;
    }

    public C11315a getAdchoice() {
        return this.adchoice;
    }

    public String getAdvImp() {
        return this.advImp;
    }

    public Map<Integer, String> getAdvImpList() {
        return generateAdImpression(this.advImp);
    }

    public HashMap<String, String> getAks() {
        return this.aks;
    }

    public String getAl() {
        return this.f30376al;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public int getBty() {
        return this.bty;
    }

    public String getCMPTEntryUrl() {
        return this.CMPTEntryUrl;
    }

    public int getCacheLevel() {
        return this.cacheLevel;
    }

    public String getCampaignUnitId() {
        return this.campaignUnitId;
    }

    public boolean getCanStart2C1Anim() {
        return this.canStart2C1Anim;
    }

    public boolean getCanStartMoreOfferAnim() {
        return this.canStartMoreOfferAnim;
    }

    public int getCbd() {
        return this.cbd;
    }

    public int getCbt() {
        return this.cbt;
    }

    public int getClickInterval() {
        return this.clickInterval;
    }

    public int getClickTimeOutInterval() {
        return this.clickTimeOutInterval;
    }

    public String getClickURL() {
        return this.clickURL;
    }

    public String getClick_mode() {
        return this.click_mode;
    }

    public long getCreativeId() {
        return this.creativeId;
    }

    public String getDeepLinkURL() {
        return this.deepLinkUrl;
    }

    public int getDynamicTempCode() {
        return this.dynamicTempCode;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public String getEndScreenUrl() {
        return this.endScreenUrl;
    }

    public int getEndcard_click_result() {
        return this.endcard_click_result;
    }

    public String getExt_data() {
        return this.ext_data;
    }

    public int getFac() {
        return this.fac;
    }

    public int getFca() {
        return this.fca;
    }

    public int getFcb() {
        return this.fcb;
    }

    public int getFlb() {
        return this.flb;
    }

    public int getFlbSkipTime() {
        return this.flbSkipTime;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public String getGuidelines() {
        return this.guidelines;
    }

    public String getHost() {
        if (!TextUtils.isEmpty(getNoticeUrl())) {
            try {
                URL url = new URL(getNoticeUrl());
                return url.getProtocol() + "://" + url.getHost();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_ext1() {
        return this.ia_ext1;
    }

    public String getIa_ext2() {
        return this.ia_ext2;
    }

    public int getIex() {
        return this.iex;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public int getImpUA() {
        return this.impUA;
    }

    public String getImpressionURL() {
        return this.impressionURL;
    }

    public String getInteractiveCache() {
        return this.interactiveCache;
    }

    public int getIsAddSuccesful() {
        return this.isAddSuccesful;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDownLoadZip() {
        return this.isDownLoadZip;
    }

    public int getIsTimeoutCheckVideoStatus() {
        return this.isTimeoutCheckVideoStatus;
    }

    public int getJmPd() {
        return this.jmPd;
    }

    @Override // com.mbridge.msdk.foundation.entity.DomainCampaignEx
    public CommonJumpLoader.JumpLoaderResult getJumpResult() {
        return this.jumpResult;
    }

    public String getK() {
        return this.f30377k;
    }

    public String getKeyIaIcon() {
        return this.keyIaIcon;
    }

    public int getKeyIaOri() {
        return this.keyIaOri;
    }

    public int getKeyIaRst() {
        return this.keyIaRst;
    }

    public String getKeyIaUrl() {
        return this.keyIaUrl;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLandingType() {
        return this.landingType;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public int getLoadTimeoutState() {
        return this.loadTimeoutState;
    }

    public int getMaitve() {
        return this.maitve;
    }

    public String getMaitve_src() {
        return this.maitve_src;
    }

    public C11316b getMediaViewHolder() {
        return this.mediaViewHolder;
    }

    public String getMof_template_url() {
        return this.mof_template_url;
    }

    public int getMof_tplid() {
        return this.mof_tplid;
    }

    public String getMp() {
        return this.f30378mp;
    }

    public String getMraid() {
        return this.mraid;
    }

    public NativeVideoTracking getNativeVideoTracking() {
        return this.nativeVideoTracking;
    }

    public String getNativeVideoTrackingString() {
        return this.nativeVideoTrackingString;
    }

    public String getNoticeUrl() {
        return this.noticeUrl;
    }

    public int getNscpt() {
        return this.nscpt;
    }

    public int getNvT2() {
        return this.nvT2;
    }

    public int getOc_time() {
        return this.oc_time;
    }

    public int getOc_type() {
        return this.oc_type;
    }

    public int getOfferType() {
        return this.offerType;
    }

    public String getOmid() {
        return this.omid;
    }

    public String getOnlyImpressionURL() {
        return this.onlyImpressionURL;
    }

    public String getPkgSource() {
        return this.pkgSource;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public int getPlayable_ads_without_video() {
        return this.playable_ads_without_video;
    }

    public long getPlct() {
        return this.plct;
    }

    public long getPlctb() {
        return this.plctb;
    }

    public List<String> getPv_urls() {
        return this.pv_urls;
    }

    public String getQ() {
        return this.f30379q;
    }

    public String getR() {
        return this.f30380r;
    }

    public int getReadyState() {
        return this.readyState;
    }

    public int getReady_rate() {
        return this.ready_rate;
    }

    public String getReq_ext_data() {
        return this.req_ext_data;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionURL)) {
                return null;
            }
            Uri parse = Uri.parse(this.onlyImpressionURL);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("k");
                this.requestId = queryParameter;
                setRequestId(queryParameter);
            }
            return this.requestId;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getRequestIdNotice() {
        try {
            if (!TextUtils.isEmpty(this.requestIdNotice)) {
                return this.requestIdNotice;
            }
            if (TextUtils.isEmpty(this.noticeUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.noticeUrl);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("k");
                this.requestIdNotice = queryParameter;
                setRequestIdNotice(queryParameter);
            }
            return this.requestIdNotice;
        } catch (Exception unused) {
            return "";
        }
    }

    public int getRetarget_offer() {
        return this.retarget_offer;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.reward_name;
    }

    public int getRewardPlayStatus() {
        return this.rewardPlayStatus;
    }

    public RewardPlus getRewardPlus() {
        return this.rewardPlus;
    }

    public C11317c getRewardTemplateMode() {
        return this.rewardTemplateMode;
    }

    public ArrayList<Integer> getRsIgnoreCheckRule() {
        return this.rsIgnoreCheckRule;
    }

    public String getRsIgnoreCheckRuleString() {
        if (getRsIgnoreCheckRule() == null || getRsIgnoreCheckRule().size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Integer> it = getRsIgnoreCheckRule().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            return !TextUtils.isEmpty(sb) ? sb.toString() : "";
        } catch (Throwable th) {
            SameLogTool.m21733d(TAG, th.getMessage());
            return "";
        }
    }

    public int getRtinsType() {
        return this.rtinsType;
    }

    public int getSpareOfferFlag() {
        return this.spareOfferFlag;
    }

    public int getTImp() {
        return this.t_imp;
    }

    public String getT_list() {
        return this.t_list;
    }

    public int getTab() {
        return this.tab;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i = this.tokenRule;
        if (i == 1) {
            return i;
        }
        return 0;
    }

    public int getTpOffer() {
        return this.tpOffer;
    }

    public long getTs() {
        return this.f30381ts;
    }

    public boolean getUserActivation() {
        return this.userActivation;
    }

    public int getVcn() {
        int i = this.vcn;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public int getVideoCheckType() {
        return this.videoCheckType;
    }

    public int getVideoCompleteTime() {
        return this.videoCompleteTime;
    }

    public int getVideoCtnType() {
        return this.videoCtnType;
    }

    public String getVideoMD5Value() {
        return this.videoMD5Value;
    }

    public int getVideoPlayProgress() {
        return this.videoPlayProgress;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public int getVideoSize() {
        return this.videoSize;
    }

    public String getVideoUrlEncode() {
        return this.videoUrlEncode;
    }

    public int getVideo_end_type() {
        return this.video_end_type;
    }

    public int getVst() {
        return this.vst;
    }

    public int getWatchMile() {
        return this.watchMile;
    }

    public int getWtick() {
        return this.wtick;
    }

    public int getcUA() {
        return this.cUA;
    }

    public long getcVersionCode() {
        return this.cVersionCode;
    }

    public String getendcard_url() {
        return this.endcard_url;
    }

    public boolean isActiveOm() {
        return (TextUtils.isEmpty(this.omid) || TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) ? false : true;
    }

    public boolean isBidCampaign() {
        return this.isBidCampaign;
    }

    public boolean isCallBackImpression() {
        return this.isCallBackImpression;
    }

    public boolean isCallbacked() {
        return this.isCallbacked;
    }

    public boolean isCampaignIsFiltered() {
        return this.campaignIsFiltered;
    }

    public boolean isDynamicView() {
        return this.isDynamicView;
    }

    public boolean isEffectiveOffer(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        return getPlct() > 0 ? getTimestamp() + (getPlct() * 1000) >= currentTimeMillis : getTimestamp() + j >= currentTimeMillis;
    }

    public boolean isHasMBTplMark() {
        return this.hasMBTplMark;
    }

    public boolean isHasReportAdTrackPause() {
        return this.hasReportAdTrackPause;
    }

    public boolean isMraid() {
        return this.isMraid;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public boolean isReportClick() {
        return this.isReportClick;
    }

    public boolean isSpareOffer(long j, long j2) {
        if (isEffectiveOffer(j)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return getPlctb() > 0 ? getTimestamp() + (getPlctb() * 1000) >= currentTimeMillis : getTimestamp() + j2 >= currentTimeMillis;
    }

    public boolean needShowIDialog() {
        return super.needShowIDialog(this);
    }

    @Override // com.mbridge.msdk.out.Campaign
    public void setAdCall(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.linkType != 2 ? "Learn more" : "Install";
        }
        super.setAdCall(str);
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdSpaceT(int i) {
        this.adSpaceT = i;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdZip(String str) {
        this.adZip = str;
        boolean m21977h = SameTool.m21977h(str);
        int m21969l = SameTool.m21969l(str);
        if (m21977h) {
            setDynamicView(true);
            setDynamicTempCode(m21969l);
        }
    }

    public void setAd_url_list(String str) {
        this.ad_url_list = str;
    }

    public void setAdchoice(C11315a c11315a) {
        this.adchoice = c11315a;
    }

    public void setAdvImp(String str) {
        this.advImp = str;
    }

    public void setAks(HashMap<String, String> hashMap) {
        this.aks = hashMap;
    }

    public void setAl(String str) {
        this.f30376al = str;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setBty(int i) {
        this.bty = i;
    }

    public void setCMPTEntryUrl(String str) {
        this.CMPTEntryUrl = str;
    }

    public void setCacheLevel(int i) {
        this.cacheLevel = i;
    }

    public void setCallBackImpression(boolean z) {
        this.isCallBackImpression = z;
    }

    public void setCallbacked(boolean z) {
        this.isCallbacked = z;
    }

    public void setCampaignIsFiltered(boolean z) {
        this.campaignIsFiltered = z;
    }

    public void setCampaignUnitId(String str) {
        this.campaignUnitId = str;
    }

    public void setCanStart2C1Anim(boolean z) {
        this.canStart2C1Anim = z;
    }

    public void setCanStartMoreOfferAnim(boolean z) {
        this.canStartMoreOfferAnim = z;
    }

    public void setCbd(int i) {
        this.cbd = i;
    }

    public void setCbt(int i) {
        this.cbt = i;
    }

    public void setClickInterval(int i) {
        this.clickInterval = i;
    }

    public void setClickTimeOutInterval(int i) {
        this.clickTimeOutInterval = i;
    }

    public void setClickURL(String str) {
        this.clickURL = str;
    }

    public void setClick_mode(String str) {
        this.click_mode = str;
    }

    public void setCreativeId(long j) {
        this.creativeId = j;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setDynamicTempCode(int i) {
        this.dynamicTempCode = SameTool.m21994c(i);
    }

    public void setDynamicView(boolean z) {
        this.isDynamicView = z;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEndScreenUrl(String str) {
        this.endScreenUrl = str;
    }

    public void setEndcard_click_result(int i) {
        this.endcard_click_result = i;
    }

    public void setExt_data(String str) {
        this.ext_data = str;
    }

    public void setFac(int i) {
        this.fac = i;
    }

    public void setFca(int i) {
        this.fca = i;
    }

    public void setFcb(int i) {
        this.fcb = i;
    }

    public void setFlb(int i) {
        this.flb = i;
    }

    public void setFlbSkipTime(int i) {
        this.flbSkipTime = i;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public void setGuidelines(String str) {
        this.guidelines = str;
    }

    public void setHasMBTplMark(boolean z) {
        this.hasMBTplMark = z;
    }

    public void setHasReportAdTrackPause(boolean z) {
        this.hasReportAdTrackPause = z;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_ext1(String str) {
        this.ia_ext1 = str;
    }

    public void setIa_ext2(String str) {
        this.ia_ext2 = str;
    }

    public void setIex(int i) {
        this.iex = i;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public void setImpUA(int i) {
        this.impUA = i;
    }

    public void setImpressionURL(String str) {
        this.impressionURL = str;
    }

    public void setInteractiveCache(String str) {
        this.interactiveCache = str;
    }

    public void setIsAddSuccesful(int i) {
        this.isAddSuccesful = i;
    }

    public void setIsBidCampaign(boolean z) {
        this.isBidCampaign = z;
    }

    public void setIsClick(int i) {
        this.isClick = i;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDownLoadZip(int i) {
        this.isDownLoadZip = i;
    }

    public void setIsMraid(boolean z) {
        this.isMraid = z;
    }

    public void setIsTimeoutCheckVideoStatus(int i) {
        this.isTimeoutCheckVideoStatus = i;
    }

    public void setJmPd(int i) {
        this.jmPd = i;
    }

    @Override // com.mbridge.msdk.foundation.entity.DomainCampaignEx
    public void setJumpResult(CommonJumpLoader.JumpLoaderResult jumpLoaderResult) {
        this.jumpResult = jumpLoaderResult;
    }

    public void setK(String str) {
        this.f30377k = str;
    }

    public void setKeyIaIcon(String str) {
        this.keyIaIcon = str;
    }

    public void setKeyIaOri(int i) {
        this.keyIaOri = i;
    }

    public void setKeyIaRst(int i) {
        this.keyIaRst = i;
    }

    public void setKeyIaUrl(String str) {
        this.keyIaUrl = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLandingType(String str) {
        this.landingType = str;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public void setLoadTimeoutState(int i) {
        this.loadTimeoutState = i;
    }

    public void setMaitve(int i) {
        this.maitve = i;
    }

    public void setMaitve_src(String str) {
        this.maitve_src = str;
    }

    public void setMediaViewHolder(C11316b c11316b) {
        this.mediaViewHolder = c11316b;
    }

    public void setMof_template_url(String str) {
        this.mof_template_url = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCMPTEntryUrl(str);
        boolean m21977h = SameTool.m21977h(str);
        int m21969l = SameTool.m21969l(str);
        if (m21977h) {
            setDynamicView(true);
            setDynamicTempCode(m21969l);
        }
        setCanStart2C1Anim(SameTool.m21971k(str));
    }

    public void setMof_tplid(int i) {
        this.mof_tplid = i;
    }

    public void setMp(String str) {
        this.f30378mp = str;
    }

    public void setMraid(String str) {
        this.mraid = str;
    }

    public void setNativeVideoTracking(NativeVideoTracking nativeVideoTracking) {
        this.nativeVideoTracking = nativeVideoTracking;
    }

    public void setNativeVideoTrackingString(String str) {
        this.nativeVideoTrackingString = str;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }

    public void setNscpt(int i) {
        this.nscpt = i;
    }

    public void setNvT2(int i) {
        this.nvT2 = i;
    }

    public void setOc_time(int i) {
        this.oc_time = i;
    }

    public void setOc_type(int i) {
        this.oc_type = i;
    }

    public void setOfferType(int i) {
        this.offerType = i;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public void setOnlyImpressionURL(String str) {
        this.onlyImpressionURL = str;
    }

    public void setPkgSource(String str) {
        this.pkgSource = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setPlayable_ads_without_video(int i) {
        this.playable_ads_without_video = i;
    }

    public void setPlct(long j) {
        this.plct = j;
    }

    public void setPlctb(long j) {
        this.plctb = j;
    }

    public void setPv_urls(List<String> list) {
        this.pv_urls = list;
    }

    public void setQ(String str) {
        this.f30379q = str;
    }

    public void setR(String str) {
        this.f30380r = str;
    }

    public void setReady(boolean z) {
        this.isReady = z;
    }

    public void setReadyState(int i) {
        this.readyState = i;
    }

    public void setReady_rate(int i) {
        this.ready_rate = i;
    }

    public void setReport(boolean z) {
        this.isReport = z;
    }

    public void setReportClick(boolean z) {
        this.isReportClick = z;
    }

    public void setReq_ext_data(String str) {
        this.req_ext_data = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setRequestIdNotice(String str) {
        this.requestIdNotice = str;
    }

    public void setRetarget_offer(int i) {
        this.retarget_offer = i;
    }

    public void setRewardAmount(int i) {
        this.rewardAmount = i;
    }

    public void setRewardName(String str) {
        this.reward_name = str;
    }

    public void setRewardPlayStatus(int i) {
        this.rewardPlayStatus = i;
    }

    public void setRewardPlus(RewardPlus rewardPlus) {
        this.rewardPlus = rewardPlus;
    }

    public void setRewardTemplateMode(C11317c c11317c) {
        this.rewardTemplateMode = c11317c;
        if (c11317c == null || TextUtils.isEmpty(c11317c.m22634e())) {
            return;
        }
        if (TextUtils.isEmpty(this.mof_template_url) && c11317c.m22634e().contains(KEY_IS_CMPT_ENTRY)) {
            setCMPTEntryUrl(c11317c.m22634e());
        }
        boolean m21977h = SameTool.m21977h(c11317c.m22634e());
        int m21969l = SameTool.m21969l(c11317c.m22634e());
        if (m21977h) {
            setDynamicView(true);
            setDynamicTempCode(m21969l);
        }
    }

    public void setRsIgnoreCheckRule(ArrayList<Integer> arrayList) {
        this.rsIgnoreCheckRule = arrayList;
    }

    public void setRsIgnoreCheckRuleByString(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(",");
        if (split.length > 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String str2 : split) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            }
            setRsIgnoreCheckRule(arrayList);
        }
    }

    public void setRtinsType(int i) {
        this.rtinsType = i;
    }

    public void setSpareOfferFlag(int i) {
        this.spareOfferFlag = i;
    }

    public void setTImp(int i) {
        this.t_imp = i;
    }

    public void setT_list(String str) {
        this.t_list = str;
    }

    public void setTab(int i) {
        this.tab = i;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public void setTokenRule(int i) {
        this.tokenRule = i;
    }

    public void setTpOffer(int i) {
        this.tpOffer = i;
    }

    public void setTs(long j) {
        this.f30381ts = j;
    }

    public void setUserActivation(boolean z) {
        this.userActivation = z;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    public void setVideoCheckType(int i) {
        if (i <= 2 && i >= 1) {
            this.videoCheckType = i;
        } else {
            this.videoCheckType = 2;
        }
    }

    public void setVideoCompleteTime(int i) {
        this.videoCompleteTime = i;
    }

    public void setVideoCtnType(int i) {
        if (i <= 2 && i >= 1) {
            this.videoCtnType = i;
        } else {
            this.videoCtnType = 1;
        }
    }

    public void setVideoMD5Value(String str) {
        this.videoMD5Value = str;
    }

    public void setVideoPlayProgress(int i) {
        this.videoPlayProgress = i;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public void setVideoSize(int i) {
        this.videoSize = i;
    }

    public void setVideoUrlEncode(String str) {
        this.videoUrlEncode = str;
    }

    public void setVideo_end_type(int i) {
        this.video_end_type = i;
    }

    public void setVst(int i) {
        this.vst = i;
    }

    public void setWatchMile(int i) {
        this.watchMile = i;
    }

    public void setWtick(int i) {
        this.wtick = i;
    }

    public void setcUA(int i) {
        this.cUA = i;
    }

    public void setcVersionCode(long j) {
        this.cVersionCode = j;
    }

    public void setendcard_url(String str) {
        C11317c c11317c;
        this.endcard_url = str;
        if (TextUtils.isEmpty(this.mof_template_url) && (((c11317c = this.rewardTemplateMode) == null || TextUtils.isEmpty(c11317c.f30409e)) && !TextUtils.isEmpty(str) && str.contains(KEY_IS_CMPT_ENTRY))) {
            setCMPTEntryUrl(str);
        }
        setCanStartMoreOfferAnim(SameTool.m21971k(str));
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z, CampaignUnit campaignUnit, String str4) {
        CampaignEx campaignEx;
        ArrayList arrayList;
        JSONObject dealV5Temp = dealV5Temp(jSONObject);
        if (dealV5Temp == null) {
            return null;
        }
        try {
            CampaignEx campaignEx2 = new CampaignEx();
            try {
                String optString = dealV5Temp.optString(JSON_KEY_AD_AKS);
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap<String, String> hashMap = new HashMap<>();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                    }
                    campaignEx2.setAks(hashMap);
                }
                if (!TextUtils.isEmpty(str4)) {
                    campaignEx2.setBidToken(str4);
                    campaignEx2.setIsBidCampaign(true);
                }
                try {
                    campaignEx2.setReady_rate(dealV5Temp.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject optJSONObject = dealV5Temp.optJSONObject(JSON_KEY_EXT_DATA);
                    if (optJSONObject != null) {
                        campaignEx2.setExt_data(optJSONObject.toString());
                    }
                    campaignEx2.setMof_tplid(dealV5Temp.optInt(CampaignUnit.JSON_KEY_MOF_TPLID));
                    campaignEx2.setMof_template_url(dealV5Temp.optString(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx2.setNscpt(dealV5Temp.optInt(CampaignUnit.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray optJSONArray = dealV5Temp.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                    campaignEx2.setPv_urls(arrayList);
                    JSONObject optJSONObject2 = dealV5Temp.optJSONObject(CampaignUnit.JSON_KEY_REQ_EXT_DATA);
                    if (optJSONObject2 != null) {
                        campaignEx2.setReq_ext_data(optJSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                campaignEx2.setId(dealV5Temp.optString("id"));
                campaignEx2.setAppName(dealV5Temp.optString("title"));
                campaignEx2.setCampaignUnitId(dealV5Temp.optString(JSON_KEY_CAMPAIGN_UNITID, ""));
                campaignEx2.setAppDesc(dealV5Temp.optString("desc"));
                campaignEx2.setPackageName(dealV5Temp.optString("package_name"));
                campaignEx2.setRtinsType(dealV5Temp.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx2.setIconUrl(dealV5Temp.optString(JSON_KEY_ICON_URL));
                campaignEx2.setImageUrl(dealV5Temp.optString(JSON_KEY_IMAGE_URL));
                campaignEx2.setSize(dealV5Temp.optString(JSON_KEY_APP_SIZE));
                campaignEx2.setImageSize(dealV5Temp.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx2.setImpressionURL(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, dealV5Temp.optString(JSON_KEY_IMPRESSION_URL)));
                campaignEx2.setClickURL(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, dealV5Temp.optString(JSON_KEY_CLICK_URL)));
                campaignEx2.setRewardPlus(RewardPlus.parseByString(dealV5Temp.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx2.setWtick(dealV5Temp.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx2.setDeepLinkUrl(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, dealV5Temp.optString(JSON_KEY_DEEP_LINK_URL)));
                campaignEx2.setUserActivation(dealV5Temp.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx2.setNoticeUrl(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, dealV5Temp.optString(JSON_KEY_NOTICE_URL)));
                campaignEx2.setTemplate(dealV5Temp.optInt("template"));
                campaignEx2.setType(dealV5Temp.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx2.setFca(dealV5Temp.optInt(JSON_KEY_FCA));
                campaignEx2.setFcb(dealV5Temp.optInt(JSON_KEY_FCB));
                campaignEx2.setEndcard_click_result(dealV5Temp.optInt(JSON_KEY_ENDCARD_CLICK));
                if (!TextUtils.isEmpty(dealV5Temp.optString(JSON_KEY_STAR))) {
                    campaignEx2.setRating(Double.parseDouble(dealV5Temp.optString(JSON_KEY_STAR, "0")));
                }
                if (!TextUtils.isEmpty(dealV5Temp.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx2.setNumberRating(dealV5Temp.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx2.setClick_mode(dealV5Temp.optString(JSON_KEY_CLICK_MODE));
                campaignEx2.setLandingType(dealV5Temp.optString(JSON_KEY_LANDING_TYPE));
                campaignEx2.setLinkType(dealV5Temp.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx2.setClickInterval(dealV5Temp.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx2.setAdCall(dealV5Temp.optString(JSON_KEY_CTA_TEXT));
                campaignEx2.setAd_url_list(dealV5Temp.optString(JSON_KEY_AD_URL_LIST));
                campaignEx2.setRetarget_offer(dealV5Temp.optInt(JSON_KEY_RETARGET_OFFER, 2));
                String optString2 = dealV5Temp.optString(JSON_KEY_VIDEO_URL);
                if (!TextUtils.isEmpty(optString2)) {
                    if (z) {
                        campaignEx2.setVideoUrlEncode(optString2);
                    } else {
                        campaignEx2.setVideoUrlEncode(SameBase64Tool.m21812b(optString2));
                    }
                }
                campaignEx2.setVideoCompleteTime(dealV5Temp.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                campaignEx2.setVideoLength(dealV5Temp.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx2.setVideoSize(dealV5Temp.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx2.setVideoResolution(dealV5Temp.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx2.setWatchMile(dealV5Temp.optInt(JSON_KEY_WATCH_MILE));
                campaignEx2.setTimestamp(System.currentTimeMillis());
                campaignEx2.setOnlyImpressionURL(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, str));
                campaignEx2.setBty(dealV5Temp.optInt(JSON_KEY_BTY));
                campaignEx2.setAdvImp(dealV5Temp.optString(JSON_KEY_ADVIMP));
                campaignEx2.setTImp(dealV5Temp.optInt(JSON_KEY_T_IMP));
                campaignEx2.setHtmlUrl(str2);
                campaignEx2.setEndScreenUrl(str3);
                campaignEx2.setGuidelines(dealV5Temp.optString(JSON_KEY_GUIDELINES));
                campaignEx2.setOfferType(dealV5Temp.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx2.setRewardName(dealV5Temp.optString("reward_name"));
                campaignEx2.setRewardAmount(dealV5Temp.optInt("reward_amount"));
                try {
                    String replaceValueByKey = DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, dealV5Temp.optString(JSON_NATIVE_VIDEO_AD_TRACKING));
                    if (!TextUtils.isEmpty(replaceValueByKey)) {
                        campaignEx2.setNativeVideoTrackingString(replaceValueByKey);
                        campaignEx2.setNativeVideoTracking(TrackingStr2Object(replaceValueByKey));
                    }
                } catch (Exception unused2) {
                }
                campaignEx2.setVideo_end_type(dealV5Temp.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx2, dealV5Temp.optString(ENDCARD_URL))) {
                    return null;
                }
                campaignEx2.setPlayable_ads_without_video(dealV5Temp.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                if (dealV5Temp.has(JSON_KEY_REWARD_VIDEO_MD5)) {
                    campaignEx2.setVideoMD5Value(dealV5Temp.optString(JSON_KEY_REWARD_VIDEO_MD5));
                }
                if (dealV5Temp.has(JSON_KEY_NV_T2)) {
                    campaignEx2.setNvT2(dealV5Temp.optInt(JSON_KEY_NV_T2));
                }
                if (dealV5Temp.has(JSON_KEY_GIF_URL)) {
                    campaignEx2.setGifUrl(dealV5Temp.optString(JSON_KEY_GIF_URL));
                }
                campaignEx2.setRewardTemplateMode(C11317c.m22638a(dealV5Temp.optJSONObject(JSON_KEY_REWARD_TEMPLATE)));
                campaignEx2.setClickTimeOutInterval(dealV5Temp.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx2.setImpUA(dealV5Temp.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx2.setcUA(dealV5Temp.optInt(JSON_KEY_C_UA, 1));
                campaignEx2.setJmPd(dealV5Temp.optInt(JSON_KEY_JM_PD));
                campaignEx2.setKeyIaIcon(dealV5Temp.optString("ia_icon"));
                campaignEx2.setKeyIaRst(dealV5Temp.optInt("ia_rst"));
                campaignEx2.setKeyIaUrl(dealV5Temp.optString("ia_url"));
                campaignEx2.setKeyIaOri(dealV5Temp.optInt("ia_ori"));
                campaignEx2.setAdType(campaignUnit.getAdType());
                campaignEx2.setTpOffer(dealV5Temp.optInt(JSON_KEY_TP_OFFER));
                campaignEx2.setFac(dealV5Temp.optInt(JSON_KEY_FAC));
                campaignEx2.setIa_ext1(dealV5Temp.optString(KEY_IA_EXT1));
                campaignEx2.setIa_ext2(dealV5Temp.optString(KEY_IA_EXT2));
                campaignEx2.setIsDownLoadZip(dealV5Temp.optInt(KEY_IS_DOWNLOAD));
                campaignEx2.setInteractiveCache(dealV5Temp.optString(KEY_IA_CACHE));
                campaignEx2.setOc_time(dealV5Temp.optInt(KEY_OC_TIME));
                campaignEx2.setOc_type(dealV5Temp.optInt(KEY_OC_TYPE));
                campaignEx2.setT_list(dealV5Temp.optString(KEY_T_LIST));
                campaignEx2.setAdchoice(C11315a.m22650a(dealV5Temp.optString(KEY_ADCHOICE, "")));
                campaignEx2.setPlct(dealV5Temp.optLong(JSON_KEY_PLCT));
                campaignEx2.setPlctb(dealV5Temp.optLong(JSON_KEY_PLCTB));
                campaignEx2.setCreativeId(dealV5Temp.optLong(JSON_KEY_CREATIVE_ID));
                String optString3 = dealV5Temp.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString3);
                if (!TextUtils.isEmpty(parse.getPath()) && (parse.getPath().endsWith(".zip") || parse.getPath().endsWith(".ZIP"))) {
                    campaignEx2.setAdZip(optString3);
                } else {
                    campaignEx2.setBannerUrl(optString3);
                }
                campaignEx2.setBannerHtml(dealV5Temp.optString("cam_html"));
                campaignEx2.setAdHtml(dealV5Temp.optString("cam_html"));
                String optString4 = dealV5Temp.optString(JSON_KEY_MRAID);
                if (!TextUtils.isEmpty(optString4)) {
                    campaignEx2.setIsMraid(true);
                    campaignEx2.setMraid(optString4);
                } else if (!TextUtils.isEmpty(campaignEx2.getAdHtml()) && !campaignEx2.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx2.setIsMraid(true);
                } else {
                    campaignEx2.setIsMraid(false);
                }
                JSONArray optJSONArray2 = dealV5Temp.optJSONArray(KEY_OMID);
                if (optJSONArray2 == null) {
                    if (!TextUtils.isEmpty(dealV5Temp.optString(KEY_OMID))) {
                        campaignEx2.setOmid(dealV5Temp.optString(KEY_OMID));
                    } else {
                        campaignEx2.setOmid(null);
                    }
                } else {
                    campaignEx2.setOmid(optJSONArray2.toString());
                }
                campaignEx2.setPlacementId(dealV5Temp.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx2.setMaitve(dealV5Temp.optInt(JSON_KEY_MAITVE));
                campaignEx2.setMaitve_src(dealV5Temp.optString(JSON_KEY_MAITVESRC));
                campaignEx2.setFlb(dealV5Temp.optInt(JSON_KEY_FLB));
                campaignEx2.setCbd(dealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx2.setVst(dealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx2.setAdSpaceT(dealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                campaignEx2.setFlbSkipTime(dealV5Temp.optInt(JSON_KEY_FLB_SKIP_TIME));
                CampaignEx parseCampaign = DomainCampaignEx.parseCampaign(dealV5Temp, campaignEx2);
                try {
                    try {
                        parseCampaign.setImpressionURL(SameTool.m22019a(MBSDKContext.m22865f().m22861j(), parseCampaign.getPackageName(), parseCampaign.getImpressionURL()));
                    } catch (Exception e) {
                        SameLogTool.m21733d("campaign", e.getMessage());
                    }
                    parseCampaign.setVideoCheckType(dealV5Temp.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                    parseCampaign.setVideoCtnType(dealV5Temp.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                    JSONArray optJSONArray3 = dealV5Temp.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                            arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i2)));
                        }
                        if (arrayList2.size() > 0) {
                            parseCampaign.setRsIgnoreCheckRule(arrayList2);
                        }
                    }
                    return parseCampaign;
                } catch (Exception e2) {
                    e = e2;
                    campaignEx = parseCampaign;
                    e.printStackTrace();
                    return campaignEx;
                }
            } catch (Exception e3) {
                e = e3;
                campaignEx = campaignEx2;
            }
        } catch (Exception e4) {
            e = e4;
            campaignEx = null;
        }
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", campaignEx.getId());
        jSONObject.put(JSON_KEY_FLB, campaignEx.getFlb());
        jSONObject.put(JSON_KEY_FLB_SKIP_TIME, campaignEx.getFlbSkipTime());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_VST, campaignEx.getVst());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_CBD, campaignEx.getCbd());
        if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
            jSONObject.put(JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
        }
        if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
            try {
                jSONObject.put(JSON_KEY_EXT_DATA, new JSONObject(campaignEx.getExt_data()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getReq_ext_data())) {
            try {
                jSONObject.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, new JSONObject(campaignEx.getReq_ext_data()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : campaignEx.getPv_urls()) {
                    jSONArray.put(str);
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
            jSONObject.put(CampaignUnit.JSON_KEY_MOF_TPLID, campaignEx.getMof_tplid());
            jSONObject.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            jSONObject.put(CampaignUnit.JSON_KEY_NSCPT, campaignEx.getNscpt());
        }
        jSONObject.put(JSON_KEY_READY_RATE, campaignEx.getReady_rate());
        jSONObject.put("title", campaignEx.getAppName());
        jSONObject.put("desc", campaignEx.getAppDesc());
        jSONObject.put("package_name", campaignEx.getPackageName());
        jSONObject.put(JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
        jSONObject.put(JSON_KEY_ICON_URL, campaignEx.getIconUrl());
        jSONObject.put(JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
        jSONObject.put(JSON_KEY_APP_SIZE, campaignEx.getSize());
        jSONObject.put(JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
        jSONObject.put(JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
        jSONObject.put(JSON_KEY_CLICK_URL, campaignEx.getClickURL());
        if (campaignEx.getRewardPlus() != null) {
            jSONObject.put(JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject());
        }
        jSONObject.put(JSON_KEY_WITHOUT_INSTALL_CHECK, campaignEx.getWtick());
        jSONObject.put(JSON_KEY_DEEP_LINK_URL, campaignEx.getDeepLinkURL());
        jSONObject.put(JSON_KEY_USER_ACTIVATION, campaignEx.getUserActivation());
        jSONObject.put(JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
        jSONObject.put("template", campaignEx.getTemplate());
        jSONObject.put(JSON_KEY_AD_SOURCE_ID, campaignEx.getType());
        jSONObject.put(JSON_KEY_FCA, campaignEx.getFca());
        jSONObject.put(JSON_KEY_FCB, campaignEx.getFcb());
        jSONObject.put(JSON_KEY_STAR, campaignEx.getRating() + "");
        jSONObject.put(JSON_KEY_NUMBER_RATING, campaignEx.getNumberRating());
        jSONObject.put(JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
        jSONObject.put(JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
        jSONObject.put(JSON_KEY_LINK_TYPE, campaignEx.getLinkType());
        jSONObject.put(JSON_KEY_CLICK_INTERVAL, campaignEx.getClickInterval());
        jSONObject.put(JSON_KEY_CTA_TEXT, campaignEx.getAdCall());
        jSONObject.put(JSON_KEY_ENDCARD_CLICK, campaignEx.getEndcard_click_result());
        jSONObject.put(JSON_KEY_RETARGET_OFFER, campaignEx.getRetarget_offer());
        jSONObject.put(JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
        jSONObject.put(JSON_KEY_VIDEO_LENGTHL, campaignEx.getVideoLength());
        jSONObject.put(JSON_KEY_VIDEO_SIZE, campaignEx.getVideoSize());
        jSONObject.put(JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
        jSONObject.put(JSON_KEY_WATCH_MILE, campaignEx.getWatchMile());
        jSONObject.put(JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
        jSONObject.put("only_impression_url", campaignEx.getOnlyImpressionURL());
        jSONObject.put(JSON_KEY_BTY, campaignEx.getBty());
        jSONObject.put(JSON_KEY_T_IMP, campaignEx.getTImp());
        jSONObject.put(JSON_KEY_ADVIMP, campaignEx.getAdvImp());
        jSONObject.put("html_url", campaignEx.getHtmlUrl());
        jSONObject.put("end_screen_url", campaignEx.getEndScreenUrl());
        jSONObject.put(JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
        jSONObject.put(JSON_KEY_OFFER_TYPE, campaignEx.getOfferType());
        jSONObject.put("reward_amount", campaignEx.getRewardAmount());
        jSONObject.put("reward_name", campaignEx.getRewardName());
        jSONObject.put(JSON_KEY_GIF_URL, campaignEx.getGifUrl());
        if (StringUtils.m21956b(campaignEx.getNativeVideoTrackingString())) {
            jSONObject.put(JSON_NATIVE_VIDEO_AD_TRACKING, new JSONObject(campaignEx.getNativeVideoTrackingString()));
        }
        jSONObject.put(VIDEO_END_TYPE, campaignEx.getVideo_end_type());
        jSONObject.put(ENDCARD_URL, campaignEx.getendcard_url());
        jSONObject.put(PLAYABLE_ADS_WITHOUT_VIDEO, campaignEx.getPlayable_ads_without_video());
        if (campaignEx.getRewardTemplateMode() != null && StringUtils.m21956b(campaignEx.getRewardTemplateMode().m22641a())) {
            jSONObject.put(JSON_KEY_REWARD_TEMPLATE, new JSONObject(campaignEx.getRewardTemplateMode().m22641a()));
        }
        jSONObject.put(JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
        jSONObject.put(JSON_KEY_CLICK_TIMEOUT_INTERVAL, campaignEx.getClickTimeOutInterval());
        jSONObject.put(JSON_KEY_C_UA, campaignEx.getcUA());
        jSONObject.put(JSON_KEY_IMP_UA, campaignEx.getImpUA());
        jSONObject.put(JSON_KEY_JM_PD, campaignEx.getJmPd());
        jSONObject.put("ia_icon", campaignEx.getKeyIaIcon());
        jSONObject.put("ia_rst", campaignEx.getKeyIaRst());
        jSONObject.put("ia_url", campaignEx.getKeyIaUrl());
        jSONObject.put("ia_ori", campaignEx.getKeyIaOri());
        jSONObject.put("ad_type", campaignEx.getAdType());
        jSONObject.put(KEY_IA_EXT1, campaignEx.getIa_ext1());
        jSONObject.put(KEY_IA_EXT2, campaignEx.getIa_ext2());
        jSONObject.put(KEY_IS_DOWNLOAD, campaignEx.getIsDownLoadZip());
        jSONObject.put(KEY_IA_CACHE, campaignEx.getInteractiveCache());
        jSONObject.put(KEY_OC_TYPE, campaignEx.getOc_type());
        jSONObject.put(KEY_OC_TIME, campaignEx.getOc_time());
        jSONObject.put(KEY_T_LIST, campaignEx.getT_list());
        C11315a adchoice = campaignEx.getAdchoice();
        if (adchoice != null) {
            jSONObject.put(KEY_ADCHOICE, new JSONObject(adchoice.m22646c()));
        }
        jSONObject.put(JSON_KEY_PLCT, campaignEx.getPlct());
        jSONObject.put(JSON_KEY_PLCTB, campaignEx.getPlctb());
        jSONObject.put(KEY_OMID, campaignEx.getOmid());
        jSONObject.put(JSON_KEY_CREATIVE_ID, campaignEx.getCreativeId());
        jSONObject.put("cam_html", campaignEx.getBannerHtml());
        jSONObject.put("cam_tpl_url", campaignEx.getBannerUrl() != null ? campaignEx.getBannerUrl() : campaignEx.getAdZip());
        jSONObject.put(JSON_KEY_MRAID, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_MRAIDFORH5, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_TIMESTAMP, campaignEx.getTimestamp());
        jSONObject.put(JSON_KEY_HB, campaignEx.isBidCampaign);
        jSONObject.put(MBridgeConstans.PLACEMENT_ID, campaignEx.getPlacementId());
        jSONObject.put(JSON_KEY_MAITVE, campaignEx.getMaitve());
        jSONObject.put(JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
        jSONObject.put("vcn", campaignEx.getVcn());
        jSONObject.put("token_r", campaignEx.getTokenRule());
        jSONObject.put("encrypt_p", campaignEx.getEncryptPrice());
        jSONObject.put(JSON_KEY_VIDEO_COMPLETE_TIME, campaignEx.getVideoCompleteTime());
        jSONObject.put(JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRule());
        jSONObject.put(JSON_KEY_VIDEO_CHECK_TYPE, campaignEx.getVideoCheckType());
        jSONObject.put(JSON_KEY_VIDEO_CTN_TYPE, campaignEx.getVideoCtnType());
        jSONObject.put(JSON_KEY_TP_OFFER, campaignEx.getTpOffer());
        jSONObject.put(JSON_KEY_FAC, campaignEx.getFac());
        try {
            jSONObject.put("misk_spt", SameTool.m21986e());
            jSONObject.put("misk_spt_det", SameTool.m21983f());
        } catch (JSONException unused) {
        }
        return DomainCampaignEx.campaignToJsonObject(jSONObject, campaignEx);
    }
}
