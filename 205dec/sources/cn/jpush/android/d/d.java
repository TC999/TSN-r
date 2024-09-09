package cn.jpush.android.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.io.LineNumberReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d implements Serializable {
    private static HashMap<String, String> bW = new HashMap<>();
    private static Map<String, String> bX = new HashMap();
    private static HashMap<String, String> bY = new HashMap<>();
    private static final long serialVersionUID = 8407025843324043625L;
    public String A;
    public String B;
    public int C;
    public int D;
    public String E;
    public String F;
    public String I;
    public String J;
    public String K;

    /* renamed from: L  reason: collision with root package name */
    public String f4123L;
    public String M;
    public String N;
    public int O;
    public String P;
    public String Q;
    public int S;
    public String T;
    public String U;
    public int V;
    public String Y;
    public String Z;
    public String aa;
    public int ab;
    public int ad;
    public Integer ai;
    public String aj;
    public long ak;
    public String al;
    public boolean am;
    public boolean an;
    public long ao;
    public String ar;
    public String as;
    public String at;
    public String au;
    public String av;
    public String aw;
    public int ax;
    public int ay;

    /* renamed from: b  reason: collision with root package name */
    public String f4125b;
    public int bC;
    public int bD;
    public int bE;
    public String bI;
    public int bL;
    public int bM;
    public long bN;
    public long bO;
    public long bP;
    public long bQ;
    public String bR;
    public String bS;
    public String bT;
    public JSONObject bU;
    public JSONObject bV;
    public String bg;
    public int bs;
    public int bt;
    public boolean bu;
    public boolean bv;
    public String bw;
    public String bx;
    public String bz;

    /* renamed from: c  reason: collision with root package name */
    public String f4126c;

    /* renamed from: d  reason: collision with root package name */
    public String f4127d;

    /* renamed from: e  reason: collision with root package name */
    public int f4128e;

    /* renamed from: f  reason: collision with root package name */
    public int f4129f;

    /* renamed from: g  reason: collision with root package name */
    public String f4130g;

    /* renamed from: h  reason: collision with root package name */
    public String f4131h;

    /* renamed from: i  reason: collision with root package name */
    public String f4132i;

    /* renamed from: j  reason: collision with root package name */
    public int f4133j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4134k;

    /* renamed from: l  reason: collision with root package name */
    public int f4135l;

    /* renamed from: n  reason: collision with root package name */
    public String f4137n;

    /* renamed from: o  reason: collision with root package name */
    public String f4138o;

    /* renamed from: p  reason: collision with root package name */
    public String f4139p;

    /* renamed from: q  reason: collision with root package name */
    public String f4140q;

    /* renamed from: r  reason: collision with root package name */
    public int f4141r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4142s;

    /* renamed from: t  reason: collision with root package name */
    public int f4143t;

    /* renamed from: u  reason: collision with root package name */
    public String f4144u;

    /* renamed from: v  reason: collision with root package name */
    public JSONArray f4145v;

    /* renamed from: w  reason: collision with root package name */
    public String f4146w;

    /* renamed from: x  reason: collision with root package name */
    public String f4147x;

    /* renamed from: y  reason: collision with root package name */
    public int f4148y;

    /* renamed from: z  reason: collision with root package name */
    public String f4149z;

    /* renamed from: a  reason: collision with root package name */
    public int f4124a = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f4136m = 0;
    public int G = -1;
    public String H = "";
    public int R = 0;
    public boolean W = false;
    public boolean X = false;
    public int ac = 0;
    public ArrayList<String> ae = new ArrayList<>();
    public String af = "";
    public String ag = "";
    public byte ah = 0;
    public double ap = 200.0d;
    public double aq = 200.0d;
    public String az = "";
    public String aA = "";
    public String aB = "";
    public String aC = "";
    public String aD = "";
    public int aE = 1;
    public int aF = 2;
    public int aG = 0;
    public int aH = 0;
    public int aI = 0;
    public int aJ = 0;
    public int aK = 1;
    public int aL = 0;
    public String aM = "";
    public int aN = 0;
    public long aO = 0;
    public int aP = 0;
    public int aQ = 0;
    public int aR = 0;
    public int aS = 1;
    public int aT = 1;
    public String aU = "#FFFFFFFF";
    public String aV = "#FF000000";
    public String aW = "#FF000000";
    public int aX = 14;
    public int aY = 14;
    public int aZ = 9;
    public int ba = 5;
    public float bb = 1.0f;
    public float bc = 1.0f;
    public String bd = "";
    public int be = 2;
    public int bf = 2;
    public String bh = "";
    public String bi = "";
    public float bj = 0.6f;
    public String bk = "";
    public String bl = "";
    public ArrayList<String> bm = new ArrayList<>();
    public int bn = 0;
    public int bo = 180;
    public int bp = 0;
    public int bq = 0;
    public String br = "";
    public String by = "";
    public String bA = "";
    public ArrayList<Float> bB = new ArrayList<>();
    public int bF = 0;
    public int bG = 0;
    public float bH = -1.0f;
    public int bJ = 1;
    public int bK = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Map<String, String> f4150a;

        static {
            HashMap hashMap = new HashMap();
            f4150a = hashMap;
            hashMap.put("google", "fc");
            hashMap.put("huawei", "hw");
            hashMap.put("honor", "hn");
            hashMap.put("meizu", "mz");
            hashMap.put("vivo", "vi");
            hashMap.put("oppo", "op");
            hashMap.put("realme", "op");
            hashMap.put("oneplus", "op");
            hashMap.put("xiaomi", "xm");
            hashMap.put("blackshark", "xm");
        }

        public static int a(JSONObject jSONObject) {
            int b4;
            int optInt = jSONObject.optInt("n_priority", 0);
            int c4 = c(jSONObject);
            return (-1 != c4 && optInt > (b4 = cn.jpush.android.x.a.b(c4))) ? b4 : optInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int c(JSONObject jSONObject) {
            String str;
            JSONObject optJSONObject = jSONObject.optJSONObject("n_importance");
            if (optJSONObject == null || (str = Build.MANUFACTURER) == null) {
                return -1;
            }
            String str2 = f4150a.get(str.toLowerCase());
            if (str2 != null) {
                int optInt = optJSONObject.optInt(str2, -1);
                Logger.d("PushEntity", "im_v:" + optInt);
                return optInt;
            }
            return -1;
        }
    }

    public static d a(Context context, d dVar) {
        try {
            JSONObject optJSONObject = new JSONObject(dVar.f4132i).optJSONObject("inapp");
            if (optJSONObject == null) {
                return null;
            }
            dVar.a(context);
            dVar.aC = dVar.f4144u;
            dVar.aD = dVar.f4147x;
            dVar.aQ = optJSONObject.optInt("inapp_delay_display_time", 10) * 1000;
            dVar.bi = optJSONObject.optString("inapp_h5_tpl_url", "");
            dVar.bt = 1;
            dVar.bu = optJSONObject.optInt("inapp_display_direct", 0) == 1;
            dVar.aG = optJSONObject.optInt("inapp_show_pos", 0);
            dVar.ba = optJSONObject.optInt("inapp_show_threshold_time", 5);
            String str = dVar.f4123L;
            if (!TextUtils.isEmpty(str)) {
                dVar.bm.add(str);
            }
            dVar.bN = System.currentTimeMillis();
            dVar.bO = cn.jpush.android.ad.b.b(optJSONObject.optString("inapp_end_time", ""));
            dVar.ax = optJSONObject.optInt("inapp_max_cache_numb", 10);
            dVar.aP = optJSONObject.optInt("inapp_msg_to_user", 1);
            dVar.bs = 40;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("in_title", dVar.aC);
            jSONObject.put("in_body_content", dVar.aD);
            jSONObject.put("in_pic_path1", str);
            dVar.bk = jSONObject.toString();
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static d a(Context context, String str, String str2) {
        String str3;
        byte b4;
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("_jmsgid_");
            dVar.f4127d = optString;
            if (optString.isEmpty()) {
                dVar.f4127d = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            }
            dVar.f4130g = a(dVar.f4127d, jSONObject);
            dVar.ah = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                dVar.f4147x = optJSONObject.optString("n_content");
                dVar.f4144u = optJSONObject.optString("n_title");
                dVar.F = optJSONObject.optString("n_extras");
                dVar.H = optJSONObject.optString("n_channel_id");
                dVar.I = optJSONObject.optString("n_display_foreground");
                dVar.G = optJSONObject.optInt("n_alert_type");
                dVar.C = a.a(optJSONObject);
                dVar.D = a.c(optJSONObject);
                dVar.I = optJSONObject.optString("n_display_foreground");
                dVar.at = optJSONObject.optString("n_sound");
                dVar.f4143t = optJSONObject.optInt("n_flag", 1);
                dVar.f4145v = optJSONObject.optJSONArray("n_target_event");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                if (optJSONObject2 != null) {
                    dVar.X = true;
                    dVar.a(optJSONObject2);
                    dVar.f4133j = 3;
                } else {
                    dVar.f4133j = 4;
                    dVar.ac = -1;
                }
            } else {
                dVar.f4147x = jSONObject.optString("n_content");
                dVar.f4144u = jSONObject.optString("n_title");
                dVar.f4145v = jSONObject.optJSONArray("n_target_event");
                dVar.F = jSONObject.optString("n_extras");
                dVar.H = jSONObject.optString("n_channel_id");
                dVar.I = jSONObject.optString("n_display_foreground");
                dVar.G = jSONObject.optInt("n_alert_type");
                dVar.C = a.a(jSONObject);
                dVar.D = a.c(jSONObject);
                dVar.I = jSONObject.optString("n_display_foreground");
                dVar.ah = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
                dVar.f4131h = jSONObject.optString("override_msg_id");
                dVar.at = jSONObject.optString("n_sound");
            }
            if (optInt != -1) {
                dVar.f4133j = optInt;
            }
            dVar.f4141r = 0;
            dVar.f4142s = true;
            dVar.f4125b = context.getPackageName();
            return dVar;
        } catch (Throwable th) {
            Logger.e("PushEntity", "parseContent error:" + th);
            if (TextUtils.isEmpty(dVar.f4127d)) {
                str3 = "NO MSGID";
                b4 = 0;
            } else {
                str3 = dVar.f4127d;
                b4 = dVar.ah;
            }
            cn.jpush.android.helper.c.a(str3, str2, b4, 996L, context);
            return null;
        }
    }

    public static d a(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject(dVar.f4132i);
            int i4 = jSONObject.getInt("type");
            if (!a(i4)) {
                Logger.ke("PushEntity", "parseInApp not support type=" + i4);
                return null;
            }
            if (jSONObject.has("target")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                if (optJSONArray.length() > 0) {
                    dVar.bR = optJSONArray.optString(0);
                }
            }
            dVar.bN = System.currentTimeMillis();
            dVar.bP = jSONObject.getInt("delay");
            dVar.bO = Long.parseLong(jSONObject.getString("expired"));
            dVar.bQ = jSONObject.getInt("interval");
            dVar.bt = b(i4);
            dVar.bs = i4;
            dVar.f4140q = jSONObject.optString("extras");
            dVar.f4145v = jSONObject.optJSONArray("target_event");
            if (jSONObject.has("banner")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
                if (10 == i4) {
                    dVar.bU = jSONObject2.getJSONObject("title");
                    dVar.bV = jSONObject2.getJSONObject("content");
                    dVar.aC = dVar.bU.optString("text");
                    dVar.aD = dVar.bV.optString("text");
                }
                if (11 == i4) {
                    String string = jSONObject.getString("image");
                    if (TextUtils.isEmpty(string)) {
                        Logger.ke("PushEntity", "parseInApp image value is null");
                        return null;
                    }
                    dVar.bS = string;
                }
                if (jSONObject2 != null && jSONObject2.has("duration")) {
                    dVar.ba = jSONObject2.getInt("duration") / 1000;
                }
                if (jSONObject2 != null && jSONObject2.has("location")) {
                    dVar.aG = jSONObject2.getInt("location");
                }
            }
            if (jSONObject.has("full")) {
                String string2 = jSONObject.getString("image");
                if (TextUtils.isEmpty(string2)) {
                    Logger.ke("PushEntity", "parseInApp image value is null");
                    return null;
                }
                dVar.bS = string2;
                JSONObject jSONObject3 = jSONObject.getJSONObject("full");
                if (jSONObject3 != null && jSONObject3.has("duration")) {
                    dVar.ba = jSONObject3.getInt("duration") / 1000;
                }
            }
            if (jSONObject.has("interstitial")) {
                if (21 == i4) {
                    String string3 = jSONObject.getString("image");
                    if (TextUtils.isEmpty(string3)) {
                        Logger.ke("PushEntity", "parseInApp image value is null");
                        return null;
                    }
                    dVar.bS = string3;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("interstitial");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("title");
                if (optJSONObject2 != null) {
                    dVar.aC = optJSONObject2.optString("text");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("content");
                if (optJSONObject3 != null) {
                    dVar.aD = optJSONObject3.optString("text");
                }
            }
            return dVar;
        } catch (Throwable th) {
            Logger.ke("PushEntity", "parseInApp Throwable=" + th);
            return null;
        }
    }

    public static d a(String str, String str2, String str3, long j4) {
        d dVar = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar2 = new d();
            try {
                String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("ad_id", "");
                }
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("_jmsgid_", "");
                }
                if (TextUtils.isEmpty(optString)) {
                    optString = j4 + "";
                }
                Logger.d("PushEntity", "preParseOriginalMsgMessage msgId = " + optString);
                dVar2.f4127d = optString;
                dVar2.f4125b = str2;
                dVar2.f4126c = str3;
                dVar2.f4130g = a(optString, jSONObject);
                String optString2 = jSONObject.optString("sequence_id", "");
                dVar2.az = optString2;
                b(optString, optString2);
                boolean z3 = true;
                if (jSONObject.optInt("n_only", 0) != 1) {
                    z3 = false;
                }
                int optInt = z3 ? jSONObject.optInt("n_builder_id", 0) : 0;
                dVar2.f4134k = z3;
                dVar2.f4135l = optInt;
                dVar2.f4132i = str;
                dVar2.f4133j = jSONObject.optInt("show_type", 3);
                dVar2.ah = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
                dVar2.f4136m = jSONObject.optInt("notificaion_type", 0);
                dVar2.f4131h = jSONObject.optString("override_msg_id", "");
                dVar2.f4137n = jSONObject.optString("message", "");
                dVar2.f4138o = jSONObject.optString("content_type", "");
                dVar2.f4139p = jSONObject.optString("title", "");
                dVar2.f4140q = jSONObject.optString("extras", "");
                return dVar2;
            } catch (Throwable th) {
                th = th;
                dVar = dVar2;
                Logger.w("PushEntity", "processMessage failed:" + th.getMessage());
                return dVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                String optString = jSONObject.optString("_j_data_", "");
                Logger.d("PushEntity", "parse jdata:" + optString);
                a(str, optString);
                return optString;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void a(String str, String str2) {
        if (bW == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bW.put(str, str2);
    }

    private void a(JSONObject jSONObject) {
        this.X = true;
        this.Y = jSONObject.optString("e_url", "").trim();
        this.Z = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.Y) && !cn.jpush.android.ad.a.c(this.Y)) {
            this.Y = JPushConstants.HTTPS_PRE + this.Y;
            Logger.i("PushEntity", "Add http to non-prefix url: " + this.Y);
        }
        this.ac = jSONObject.optInt("e_rich_type", 0);
        this.ab = jSONObject.optInt("e_jump_mode", 0);
        this.ad = jSONObject.optInt("e_show", 0);
        int i4 = this.ac;
        if (3 == i4 || 2 == i4 || 1 == i4) {
            this.ae = m.a(jSONObject.optJSONArray("e_eres"));
        }
        this.af = jSONObject.optString("from_num", "");
        this.ag = jSONObject.optString("to_num", "");
    }

    private static boolean a(int i4) {
        return 10 == i4 || 11 == i4 || 20 == i4 || 21 == i4 || 31 == i4 || 30 == i4;
    }

    private static int b(int i4) {
        String valueOf = String.valueOf(i4);
        if (valueOf.startsWith("1")) {
            return 2;
        }
        if (valueOf.startsWith("2")) {
            return 3;
        }
        return valueOf.startsWith("3") ? 4 : -1;
    }

    public static d b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.f4124a = jSONObject.optInt("msgType", -1);
            dVar.f4125b = jSONObject.optString("appId");
            dVar.f4126c = jSONObject.optString("senderId");
            String optString = jSONObject.optString("messageId");
            dVar.f4127d = optString;
            dVar.f4130g = a(optString, jSONObject);
            dVar.f4128e = jSONObject.optInt("notificationId");
            dVar.f4129f = jSONObject.optInt("messageType");
            dVar.f4131h = jSONObject.optString("overrideMessageId");
            dVar.f4132i = jSONObject.optString("originalMessage");
            dVar.f4133j = jSONObject.optInt("messageVersion");
            dVar.f4134k = jSONObject.optBoolean("notificationOnly");
            dVar.f4135l = jSONObject.optInt("notificationBuilderId");
            dVar.f4136m = jSONObject.optInt("notificationType");
            dVar.f4137n = jSONObject.optString("message");
            dVar.f4138o = jSONObject.optString("contentType");
            dVar.f4139p = jSONObject.optString("title");
            dVar.f4140q = jSONObject.optString("extras");
            dVar.f4141r = jSONObject.optInt("type");
            dVar.f4142s = jSONObject.optBoolean("isFullScreen");
            dVar.f4143t = jSONObject.optInt("notificationRemoveMode");
            dVar.f4144u = jSONObject.optString("notificationTitle");
            dVar.f4145v = jSONObject.optJSONArray("notificationTargetEvent");
            dVar.f4146w = jSONObject.optString("notificationAppName");
            dVar.f4147x = jSONObject.optString("notificationContent");
            dVar.f4148y = jSONObject.optInt("notificationStyle");
            dVar.f4149z = jSONObject.optString("notificationBigText");
            dVar.A = jSONObject.optString("notificationBigPicPath");
            dVar.B = jSONObject.optString("notificationInbox");
            dVar.C = jSONObject.optInt("notificationPriority");
            dVar.D = jSONObject.optInt("notificationImportance");
            dVar.E = jSONObject.optString("notificationCategory");
            dVar.F = jSONObject.optString("notificationExtra");
            dVar.G = jSONObject.optInt("notificationAlertType");
            dVar.H = jSONObject.optString("notificationChannelId");
            dVar.I = jSONObject.optString("displayForeground");
            dVar.J = jSONObject.optString("source");
            dVar.K = jSONObject.optString("smallIcon");
            dVar.f4123L = jSONObject.optString("largeIcon");
            dVar.M = jSONObject.optString("normalSmallIcon");
            dVar.N = jSONObject.optString("deeplink");
            dVar.O = jSONObject.optInt("failedAction");
            dVar.P = jSONObject.optString("failedLink");
            dVar.Q = jSONObject.optString("targetPkgName");
            dVar.S = jSONObject.optInt("deeplinkBuilderId");
            dVar.X = jSONObject.optBoolean("isRichPush");
            dVar.Y = jSONObject.optString("showUrl");
            dVar.Z = jSONObject.optString("showTitle");
            dVar.aa = jSONObject.optString("_webPagePath");
            dVar.ab = jSONObject.optInt("jumpMode");
            dVar.ac = jSONObject.optInt("richType");
            dVar.ad = jSONObject.optInt("showMode");
            String optString2 = jSONObject.optString("showResourceList");
            if (!TextUtils.isEmpty(optString2)) {
                dVar.ae = new ArrayList<>(Arrays.asList(optString2.split(",")));
            }
            dVar.af = jSONObject.optString("fromNum");
            dVar.ag = jSONObject.optString("toNum");
            dVar.ah = (byte) jSONObject.optInt("platform");
            if (jSONObject.has("badgeAddNum")) {
                dVar.ai = Integer.valueOf(jSONObject.optInt("badgeAddNum"));
            }
            dVar.aj = jSONObject.optString("geofenceid");
            dVar.ak = jSONObject.optLong("radius");
            dVar.al = jSONObject.optString("status");
            dVar.am = jSONObject.optBoolean("repeat");
            dVar.an = jSONObject.optBoolean("hasShow");
            dVar.ao = jSONObject.optLong("expiration");
            dVar.ap = jSONObject.optDouble("longitude");
            dVar.aq = jSONObject.optDouble("latitude");
            dVar.ar = jSONObject.optString("lastGeoStatus");
            dVar.as = jSONObject.optString("developerArg0");
            dVar.at = jSONObject.optString("sound");
            dVar.au = jSONObject.optString("showBeginTime");
            dVar.av = jSONObject.optString("showEndTime");
            dVar.W = jSONObject.optBoolean("isWmDeepLink");
            dVar.T = jSONObject.optString("wxAppId");
            dVar.U = jSONObject.optString("miniOriginid");
            dVar.V = jSONObject.optInt("miniType");
            dVar.aB = jSONObject.optString("inAppMsgContent");
            dVar.aA = jSONObject.optString("inAppIntent");
            dVar.aC = jSONObject.optString("inAppMsgTitle");
            dVar.aD = jSONObject.optString("inAppMsgContentBody");
            dVar.bR = jSONObject.optString("target");
            dVar.bT = jSONObject.optString("clickAction");
            dVar.f4140q = jSONObject.optString("extras");
            dVar.aE = jSONObject.optInt("inAppMsgType");
            dVar.aF = jSONObject.optInt("inAppMsgShowType");
            dVar.aG = jSONObject.optInt("inAppMsgShowPos");
            dVar.aH = jSONObject.optInt("inAppMsgShowAniAction");
            dVar.bp = jSONObject.optInt("inSupportNotifyAni");
            dVar.bq = jSONObject.optInt("inSupportVibration");
            dVar.br = jSONObject.optString("inAppIcon");
            dVar.aI = jSONObject.optInt("inAppMsgDismissAniAction");
            dVar.aJ = jSONObject.optInt("inAppMsgShowBackground");
            dVar.aK = jSONObject.optInt("inAppMsgAllowIntercept");
            dVar.aL = jSONObject.optInt("inAppMsgFilterMsg");
            dVar.aM = jSONObject.optString("inAppMsgPicPath");
            dVar.aN = jSONObject.optInt("inAppMsgCountLmt");
            dVar.aO = jSONObject.optInt("inAppMsgGap");
            dVar.aP = jSONObject.optInt("inAppMsgToUser");
            dVar.aQ = jSONObject.optInt("inAppMsgDelayDisplayTime");
            dVar.aR = jSONObject.optInt("inAppMsgPageDelayDisplayTime");
            dVar.aS = jSONObject.optInt("inAppMsgReportPageName");
            dVar.aT = jSONObject.optInt("inAppUseSysAlert");
            dVar.aU = jSONObject.optString("inAppMsgBackgroundColor");
            dVar.aV = jSONObject.optString("inAppMsgTitleColor");
            dVar.aW = jSONObject.optString("inAppMsgContentColor");
            dVar.aX = jSONObject.optInt("inAppMsgTitleSize");
            dVar.aY = jSONObject.optInt("inAppMsgContentSize");
            dVar.aZ = jSONObject.optInt("inAppMsgCircularSize");
            dVar.ba = jSONObject.optInt("inAppMsgShowTime");
            dVar.bb = (float) jSONObject.optDouble("inAppMsgShowElapseTime");
            dVar.bc = (float) jSONObject.optDouble("inAppMsgDismissElapseTime");
            dVar.bd = jSONObject.optString("inAppWebPageUrl");
            dVar.be = jSONObject.optInt("inAppProtocolVer");
            dVar.bo = jSONObject.optInt("inAppSSPGap");
            dVar.bf = jSONObject.optInt("inAppCheckIntent");
            dVar.bg = jSONObject.optString("inAppTplContent");
            dVar.bh = jSONObject.optString("inAppTplId");
            dVar.bi = jSONObject.optString("inAppTplUrl");
            dVar.bj = (float) jSONObject.optDouble("inAppMarginY");
            dVar.bk = jSONObject.optString("inAppTplData");
            dVar.bl = jSONObject.optString("inAppIntentActions");
            dVar.bs = jSONObject.optInt("inAppType");
            dVar.bO = jSONObject.optLong("expired");
            dVar.ax = jSONObject.optInt("notifyInAppCacheNumb");
            dVar.ay = jSONObject.optInt("notifyInAppMsgType");
            dVar.bt = jSONObject.optInt("inAppPriority");
            dVar.bu = jSONObject.optBoolean("inAppIsDisplayDirect");
            dVar.bw = jSONObject.optString("inAppBlackConf");
            dVar.bx = jSONObject.optString("inAppAnimatorConf");
            dVar.by = jSONObject.optString("inAppAdPosition");
            dVar.bz = jSONObject.optString("inAppFragment");
            dVar.bA = jSONObject.optString("inAppAdPosId");
            dVar.bC = jSONObject.optInt("inAppCoordinateType");
            dVar.bD = jSONObject.optInt("inAppWinWidth");
            dVar.bE = jSONObject.optInt("inAppWinHeight");
            JSONArray optJSONArray = jSONObject.optJSONArray("inAppShowCoordinate");
            dVar.bB = new ArrayList<>();
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    dVar.bB.add(Float.valueOf((float) optJSONArray.getDouble(i4)));
                }
            }
            dVar.bF = jSONObject.optInt("inAppPosMsgCountLmt");
            dVar.bG = jSONObject.optInt("inAppPosMsgGap");
            dVar.bH = (float) jSONObject.optDouble("inAppSizeRatio");
            dVar.az = jSONObject.optString("sequenceId");
            dVar.bv = jSONObject.optBoolean("inAppFixed");
            String optString3 = jSONObject.optString("inAppShowResList");
            if (!TextUtils.isEmpty(optString3)) {
                dVar.bm = new ArrayList<>(Arrays.asList(optString3.split(",")));
            }
            dVar.bI = jSONObject.optString("unionADExtras");
            dVar.bJ = jSONObject.optInt("swipeDismiss");
            dVar.bK = jSONObject.optInt("adSspSvrVer");
            dVar.bL = jSONObject.optInt("inAppMsgStyle");
            dVar.bM = jSONObject.optInt("inAppMsgStyleGap");
            dVar.bR = jSONObject.optString("target");
            dVar.bN = jSONObject.optLong("msgTime");
            dVar.bP = jSONObject.optInt("delay");
            dVar.bQ = jSONObject.optInt("interval");
            return dVar;
        } catch (Throwable th) {
            Logger.w("PushEntity", "parseJSONString e:" + th);
            return null;
        }
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bX.put(str, str2);
    }

    public static String c(String str) {
        HashMap<String, String> hashMap = bW;
        return hashMap != null ? hashMap.get(str) : "";
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str));
                String readLine = lineNumberReader.readLine();
                String readLine2 = lineNumberReader.readLine();
                if (readLine == null) {
                    Logger.e("PushEntity", "NO appId");
                    return null;
                } else if (readLine2 == null) {
                    Logger.e("PushEntity", "NO senderId");
                    return null;
                } else {
                    int length = readLine.length() + readLine2.length() + 2;
                    if (str.length() <= length + 1) {
                        Logger.d("PushEntity", "No msgContent");
                        return null;
                    }
                    String optString = new JSONObject(str.substring(length)).optString("_j_data_", "");
                    Logger.d("PushEntity", "get jdata from push msg:" + optString);
                    return optString;
                }
            } catch (Throwable th) {
                Logger.d("PushEntity", "get jdata from push msg error:" + th.getMessage());
            }
        }
        return null;
    }

    public cn.jpush.android.d.a a() {
        return new cn.jpush.android.d.a(this);
    }

    public void a(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(this.f4132i).optJSONObject("m_content");
            int optInt = optJSONObject.optInt("ad_t", 0);
            this.f4141r = optInt;
            if (optInt != 0) {
                return;
            }
            this.f4142s = optJSONObject.optInt("full_screen", 0) >= 1;
            this.f4143t = optJSONObject.optInt("n_flag", 1);
            this.f4144u = optJSONObject.optString("n_title", "");
            this.f4146w = optJSONObject.optString("n_app_name", "");
            this.f4147x = optJSONObject.optString("n_content", "");
            this.f4148y = optJSONObject.optInt("n_style", 0);
            this.f4149z = optJSONObject.optString("n_big_text", "");
            this.A = optJSONObject.optString("n_big_pic_path", "");
            this.B = optJSONObject.optString("n_inbox", "");
            this.F = optJSONObject.optString("n_extras", "");
            this.C = a.a(optJSONObject);
            this.D = a.c(optJSONObject);
            this.E = optJSONObject.optString("n_category", "");
            this.G = optJSONObject.optInt("n_alert_type", -1);
            this.H = optJSONObject.optString("n_channel_id");
            this.I = optJSONObject.optString("n_display_foreground");
            this.K = optJSONObject.optString("n_small_icon", "");
            this.f4123L = optJSONObject.optString("n_large_icon", "");
            this.J = optJSONObject.optString("n_source", "");
            this.M = optJSONObject.optString("n_small_icon_uri", "");
            this.aA = optJSONObject.optString("n_intent");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            if (optJSONObject2 != null) {
                this.N = optJSONObject2.optString("n_url", "");
                this.O = optJSONObject2.optInt("n_fail_handle_type", 0);
                this.P = optJSONObject2.optString("n_fail_handle_url", "");
                this.Q = optJSONObject2.optString("n_package_name", "");
                this.S = optJSONObject2.optInt("n_builder_id", 0);
                this.T = optJSONObject2.optString("wx_app_id", "");
                this.U = optJSONObject2.optString("mini_originid", "");
                this.V = optJSONObject2.optInt("mini_type", 0);
            }
            if (TextUtils.isEmpty(this.f4144u)) {
                Logger.dd("PushEntity", "Not found notificaiton title for developer mode. Use the application name.");
                this.f4144u = cn.jpush.android.ad.a.b(context);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("ad_content");
            if (!optJSONObject.isNull("ad_content") && optJSONObject3 != null) {
                a(optJSONObject3);
            }
            if (optJSONObject.has("n_badge_add_num")) {
                this.ai = Integer.valueOf(optJSONObject.optInt("n_badge_add_num"));
            } else {
                this.ai = null;
            }
            this.at = optJSONObject.optString("n_sound");
            this.au = optJSONObject.optString("n_show_begin_time");
            this.av = optJSONObject.optString("n_show_end_time");
            this.f4145v = optJSONObject.optJSONArray("n_target_event");
        } catch (Throwable th) {
            Logger.ww("PushEntity", "parse notification failed:" + th.getMessage());
        }
    }

    public void a(String str) {
        this.bT = str;
    }

    public NotificationMessage b() {
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.appkey = this.f4126c;
        notificationMessage.msgId = this.f4127d;
        notificationMessage.notificationAlertType = this.G;
        notificationMessage.notificationBigPicPath = this.A;
        notificationMessage.notificationBigText = this.f4149z;
        notificationMessage.notificationBuilderId = this.f4135l;
        notificationMessage.notificationCategory = this.E;
        notificationMessage.notificationContent = this.f4147x;
        notificationMessage.notificationExtras = this.F;
        notificationMessage.notificationId = this.f4128e;
        notificationMessage.notificationInbox = this.B;
        notificationMessage.notificationLargeIcon = this.f4123L;
        notificationMessage.notificationPriority = this.C;
        notificationMessage.notificationImportance = this.D;
        notificationMessage.notificationSmallIcon = this.K;
        notificationMessage.notificationStyle = this.f4148y;
        notificationMessage.notificationTitle = this.f4144u;
        notificationMessage.notificationTargetEvent = this.f4145v;
        notificationMessage.appId = this.f4125b;
        notificationMessage.notificationType = this.f4136m;
        notificationMessage.developerArg0 = this.as;
        notificationMessage.notificationChannelId = this.H;
        notificationMessage.isRichPush = this.X;
        notificationMessage.richType = this.ac;
        notificationMessage._webPagePath = this.aa;
        notificationMessage.showResourceList = this.ae;
        notificationMessage.platform = this.ah;
        try {
            notificationMessage.deeplink = this.N;
            notificationMessage.failedAction = this.O;
            notificationMessage.failedLink = this.P;
            notificationMessage.targetPkgName = this.Q;
            notificationMessage.displayForeground = this.I;
            notificationMessage.sspWxAppId = this.T;
            notificationMessage.sspWmOriginId = this.U;
            notificationMessage.sspWmType = this.V;
            notificationMessage.isWmDeepLink = this.W;
            notificationMessage.inAppMsgTitle = this.aC;
            notificationMessage.inAppMsgContentBody = this.aD;
            notificationMessage.inAppMsgType = this.aE;
            notificationMessage.inAppMsgShowType = this.aF;
            notificationMessage.inAppMsgShowPos = this.aG;
            notificationMessage.inAppShowTarget = this.bR;
            notificationMessage.inAppExtras = this.f4140q;
            notificationMessage.inAppClickAction = this.bT;
            if (JPushConstants.SDK_VERSION_CODE >= 408) {
                notificationMessage.notificationNormalSmallIcon = this.M;
            }
        } catch (Throwable th) {
            Logger.w("PushEntity", "pushEntry toNotificationMessage error" + th.getMessage());
        }
        return notificationMessage;
    }

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", this.f4124a);
            jSONObject.put("appId", this.f4125b);
            jSONObject.put("senderId", this.f4126c);
            jSONObject.put("messageId", this.f4127d);
            jSONObject.put("_j_data_", this.f4130g);
            jSONObject.put("notificationId", this.f4128e);
            jSONObject.put("messageType", this.f4129f);
            jSONObject.put("overrideMessageId", this.f4131h);
            jSONObject.put("messageVersion", this.f4133j);
            jSONObject.put("notificationOnly", this.f4134k);
            jSONObject.put("notificationBuilderId", this.f4135l);
            jSONObject.put("notificationType", this.f4136m);
            jSONObject.put("message", this.f4137n);
            jSONObject.put("originalMessage", this.f4132i);
            jSONObject.put("contentType", this.f4138o);
            jSONObject.put("title", this.f4139p);
            jSONObject.put("extras", this.f4140q);
            jSONObject.put("type", this.f4141r);
            jSONObject.put("isFullScreen", this.f4142s);
            jSONObject.put("notificationRemoveMode", this.f4143t);
            jSONObject.put("notificationTitle", this.f4144u);
            jSONObject.put("notificationTargetEvent", this.f4145v);
            jSONObject.put("notificationAppName", this.f4146w);
            jSONObject.put("notificationContent", this.f4147x);
            jSONObject.put("notificationStyle", this.f4148y);
            jSONObject.put("notificationBigText", this.f4149z);
            jSONObject.put("notificationBigPicPath", this.A);
            jSONObject.put("notificationInbox", this.B);
            jSONObject.put("notificationPriority", this.C);
            jSONObject.put("notificationImportance", this.D);
            jSONObject.put("notificationCategory", this.E);
            jSONObject.put("notificationExtra", this.F);
            jSONObject.put("notificationAlertType", this.G);
            jSONObject.put("notificationChannelId", this.H);
            jSONObject.put("displayForeground", this.I);
            jSONObject.put("source", this.J);
            jSONObject.put("smallIcon", this.K);
            jSONObject.put("largeIcon", this.f4123L);
            jSONObject.put("normalSmallIcon", this.M);
            jSONObject.put("deeplink", this.N);
            jSONObject.put("failedAction", this.O);
            jSONObject.put("failedLink", this.P);
            jSONObject.put("targetPkgName", this.Q);
            jSONObject.put("deeplinkBuilderId", this.S);
            jSONObject.put("isRichPush", this.X);
            jSONObject.put("showUrl", this.Y);
            jSONObject.put("showTitle", this.Z);
            jSONObject.put("_webPagePath", this.aa);
            jSONObject.put("jumpMode", this.ab);
            jSONObject.put("richType", this.ac);
            jSONObject.put("showMode", this.ad);
            jSONObject.put("showResourceList", m.a(this.ae, ","));
            jSONObject.put("fromNum", this.af);
            jSONObject.put("toNum", this.ag);
            jSONObject.put("platform", (int) this.ah);
            jSONObject.put("badgeAddNum", this.ai);
            jSONObject.put("geofenceid", this.aj);
            jSONObject.put("radius", this.ak);
            jSONObject.put("status", this.al);
            jSONObject.put("repeat", this.am);
            jSONObject.put("hasShow", this.an);
            jSONObject.put("expiration", this.ao);
            jSONObject.put("longitude", this.ap);
            jSONObject.put("latitude", this.aq);
            jSONObject.put("lastGeoStatus", this.ar);
            jSONObject.put("developerArg0", this.as);
            jSONObject.put("sound", this.at);
            jSONObject.put("showBeginTime", this.au);
            jSONObject.put("showEndTime", this.av);
            jSONObject.put("isWmDeepLink", this.W);
            jSONObject.put("wxAppId", this.T);
            jSONObject.put("miniOriginid", this.U);
            jSONObject.put("miniType", this.V);
            jSONObject.put("inAppMsgContent", this.aB);
            jSONObject.put("inAppIntent", this.aA);
            jSONObject.put("inAppMsgTitle", this.aC);
            jSONObject.put("inAppMsgContentBody", this.aD);
            jSONObject.put("target", this.bR);
            jSONObject.put("clickAction", this.bT);
            jSONObject.put("extras", this.f4140q);
            jSONObject.put("inAppMsgType", this.aE);
            jSONObject.put("inAppMsgShowType", this.aF);
            jSONObject.put("inAppMsgShowPos", this.aG);
            jSONObject.put("inAppMsgShowAniAction", this.aH);
            jSONObject.put("inSupportNotifyAni", this.bp);
            jSONObject.put("inSupportVibration", this.bq);
            jSONObject.put("inAppIcon", this.br);
            jSONObject.put("inAppMsgDismissAniAction", this.aI);
            jSONObject.put("inAppMsgShowBackground", this.aJ);
            jSONObject.put("inAppMsgAllowIntercept", this.aK);
            jSONObject.put("inAppMsgFilterMsg", this.aL);
            jSONObject.put("inAppMsgPicPath", this.aM);
            jSONObject.put("inAppMsgCountLmt", this.aN);
            jSONObject.put("inAppMsgGap", this.aO);
            jSONObject.put("inAppMsgToUser", this.aP);
            jSONObject.put("inAppMsgDelayDisplayTime", this.aQ);
            jSONObject.put("inAppMsgPageDelayDisplayTime", this.aR);
            jSONObject.put("inAppMsgReportPageName", this.aS);
            jSONObject.put("inAppUseSysAlert", this.aT);
            jSONObject.put("inAppMsgBackgroundColor", this.aU);
            jSONObject.put("inAppMsgTitleColor", this.aV);
            jSONObject.put("inAppMsgContentColor", this.aW);
            jSONObject.put("inAppMsgTitleSize", this.aX);
            jSONObject.put("inAppMsgContentSize", this.aY);
            jSONObject.put("inAppMsgCircularSize", this.aZ);
            jSONObject.put("inAppMsgShowTime", this.ba);
            jSONObject.put("inAppMsgShowElapseTime", this.bb);
            jSONObject.put("inAppMsgDismissElapseTime", this.bc);
            jSONObject.put("inAppWebPageUrl", this.bd);
            jSONObject.put("inAppProtocolVer", this.be);
            jSONObject.put("inAppSSPGap", this.bo);
            jSONObject.put("inAppCheckIntent", this.bf);
            jSONObject.put("inAppTplContent", this.bg);
            jSONObject.put("inAppTplId", this.bh);
            jSONObject.put("inAppTplUrl", this.bi);
            jSONObject.put("inAppMarginY", this.bj);
            jSONObject.put("inAppTplData", this.bk);
            jSONObject.put("inAppIntentActions", this.bl);
            jSONObject.put("inAppShowResList", m.a(this.bm, ","));
            jSONObject.put("inAppType", this.bs);
            jSONObject.put("expired", this.bO);
            jSONObject.put("notifyInAppCacheNumb", this.ax);
            jSONObject.put("notifyInAppMsgType", this.ay);
            jSONObject.put("inAppPriority", this.bt);
            jSONObject.put("inAppIsDisplayDirect", this.bu);
            jSONObject.put("inAppFixed", this.bv);
            jSONObject.put("inAppBlackConf", this.bw);
            jSONObject.put("inAppAnimatorConf", this.bx);
            jSONObject.put("inAppAdPosition", this.by);
            jSONObject.put("inAppFragment", this.bz);
            jSONObject.put("inAppAdPosId", this.bA);
            jSONObject.put("inAppCoordinateType", this.bC);
            jSONObject.put("inAppWinWidth", this.bD);
            jSONObject.put("inAppWinHeight", this.bE);
            JSONArray jSONArray = new JSONArray();
            Iterator<Float> it = this.bB.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().floatValue());
            }
            jSONObject.put("inAppShowCoordinate", jSONArray);
            jSONObject.put("inAppPosMsgCountLmt", this.bF);
            jSONObject.put("inAppPosMsgGap", this.bG);
            jSONObject.put("inAppSizeRatio", this.bH);
            jSONObject.put("sequenceId", this.az);
            jSONObject.put("unionADExtras", this.bI);
            jSONObject.put("swipeDismiss", this.bJ);
            jSONObject.put("adSspSvrVer", this.bK);
            jSONObject.put("inAppMsgStyle", this.bL);
            jSONObject.put("inAppMsgStyleGap", this.bM);
            jSONObject.put("target", this.bR);
            jSONObject.put("msgTime", this.bN);
            jSONObject.put("delay", this.bP);
            jSONObject.put("interval", this.bQ);
            jSONObject.put("inAppPriority", this.bt);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return "PushEntity{appId='" + this.f4125b + "', senderId='" + this.f4126c + "', messageId='" + this.f4127d + "', jData='" + this.f4130g + "', notificationId=" + this.f4128e + ", messageType=" + this.f4129f + ", overrideMessageId='" + this.f4131h + "', originalMessage='" + this.f4132i + "', messageVersion=" + this.f4133j + ", notificationOnly=" + this.f4134k + ", notificationBuilderId=" + this.f4135l + ", notificationType=" + this.f4136m + ", message='" + this.f4137n + "', contentType='" + this.f4138o + "', title='" + this.f4139p + "', extras='" + this.f4140q + "', type=" + this.f4141r + ", isFullScreen=" + this.f4142s + ", notificationRemoveMode=" + this.f4143t + ", notificationTitle='" + this.f4144u + "', notificationAppName='" + this.f4146w + "', notificationContent='" + this.f4147x + "', notificationStyle=" + this.f4148y + ", notificationBigText='" + this.f4149z + "', notificationBigPicPath='" + this.A + "', notificationInbox='" + this.B + "', notificationPriority=" + this.C + ", notificationImportance=" + this.D + ", notificationCategory='" + this.E + "', notificationExtra='" + this.F + "', notificationAlertType=" + this.G + ", notificationChannelId='" + this.H + "', displayForeground='" + this.I + "', source='" + this.J + "', smallIcon='" + this.K + "', largeIcon='" + this.f4123L + "', normalSmallIcon='" + this.M + "', deeplink='" + this.N + "', failedAction=" + this.O + ", failedLink='" + this.P + "', targetPkgName='" + this.Q + "', deeplinkBuilderId=" + this.S + ", isRichPush=" + this.X + ", showUrl='" + this.Y + "', showTitle='" + this.Z + "', _webPagePath='" + this.aa + "', jumpMode=" + this.ab + ", richType=" + this.ac + ", showMode=" + this.ad + ", showResourceList=" + this.ae + ", fromNum='" + this.af + "', toNum='" + this.ag + "', platform=" + ((int) this.ah) + ", badgeAddNum=" + this.ai + ", geofenceid='" + this.aj + "', radius=" + this.ak + ", status='" + this.al + "', repeat=" + this.am + ", hasShow=" + this.an + ", expiration=" + this.ao + ", longitude=" + this.ap + ", latitude=" + this.aq + ", lastGeoStatus='" + this.ar + "', developerArg0='" + this.as + "', sound='" + this.at + "', showBeginTime='" + this.au + "', showEndTime='" + this.av + "', inAppMsgContent='" + this.aB + "', inAppIntent='" + this.aA + ", inAppWebPageUrl = '" + this.bd + "', inAppProtocolVer = '" + this.be + "', inAppSSPGap = '" + this.bo + "', inAppCheckIntent = '" + this.bf + "', inAppTplContent = '" + this.bg + "', inAppTplId = '" + this.bh + "', inAppTplUrl = '" + this.bi + "', inAppMarginY  = '" + this.bj + "', inAppTplData = '" + this.bk + "', inAppIntentActions = '" + this.bl + "', inAppType= '" + this.bs + "', notifyInAppEndTime= '" + this.aw + "', notifyInAppEndTime= '" + this.ax + "', notifyInAppMsgType= '" + this.ay + "', inAppPriority= '" + this.bt + "', msgTime= '" + this.bN + "', inAppIsDisplayDirect= '" + this.bu + "', inAppFixed= '" + this.bv + "', inAppBlackConf= '" + this.bw + "', inAppAnimatorConf= '" + this.bx + "', inAppAdPosition= '" + this.by + "', inAppAdPosId= '" + this.bA + "', inAppFragment= '" + this.bz + "', inAppShowCoordinate= '" + this.bB + "', inAppCoordinateType= '" + this.bC + "', inAppWinWidth= '" + this.bD + "', inAppWinHeight= '" + this.bE + "', sequenceId= '" + this.az + "', swipeDismiss= '" + this.bJ + "'}";
    }
}
