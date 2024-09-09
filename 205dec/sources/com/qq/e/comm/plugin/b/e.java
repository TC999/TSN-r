package com.qq.e.comm.plugin.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.f0;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.k0;
import com.qq.e.comm.plugin.util.m2;
import com.qq.e.comm.plugin.util.r0;
import com.qq.e.comm.plugin.util.r2;
import com.qq.e.comm.plugin.util.s2;
import com.qq.e.comm.plugin.util.t0;
import com.qq.e.comm.plugin.util.v0;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.util.y0;
import com.qq.e.comm.plugin.util.y1;
import com.qq.e.comm.plugin.util.z0;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f41982a = new Random(System.currentTimeMillis());

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Integer> f41983b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f41984c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41985a;

        static {
            int[] iArr = new int[g.values().length];
            f41985a = iArr;
            try {
                iArr[g.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f41984c = copyOnWriteArraySet;
        copyOnWriteArraySet.add("shakable");
    }

    public static Map<String, String> a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.d0.a aVar, d dVar) throws JSONException {
        fVar.a("adposcount", String.valueOf(dVar.a()));
        fVar.a("count", String.valueOf(dVar.c()));
        if (t0.a(dVar.w())) {
            fVar.a("mposid", dVar.w());
            dVar.b(true);
        } else {
            fVar.a("posid", dVar.w());
        }
        fVar.a("mu_p", com.qq.e.comm.plugin.e.a.a().a(dVar.w()));
        if (!TextUtils.isEmpty(dVar.D())) {
            fVar.a("token", dVar.D());
            fVar.a("sbt", "2");
        }
        int x3 = dVar.x();
        if (x3 == g.SPLASH.d()) {
            fVar.a("spsa", "1");
        } else if (x3 == g.NATIVEEXPRESSAD.d()) {
            fVar.a("template_count", String.valueOf(1));
            fVar.a("actual_width", String.valueOf(dVar.u()));
            fVar.a("actual_height", String.valueOf(dVar.t()));
        }
        int y3 = dVar.y();
        int v3 = dVar.v();
        if (y3 > 0 && v3 > 0) {
            fVar.a("posw", String.valueOf(y3));
            fVar.a("posh", String.valueOf(v3));
        }
        if (dVar.d() > 0) {
            fVar.a("datatype", String.valueOf(dVar.d()));
        }
        if (dVar.n() != null && dVar.n().getValue() > 0) {
            fVar.a("login_type", String.valueOf(dVar.n().getValue()));
        }
        if (!TextUtils.isEmpty(dVar.l())) {
            fVar.a("login_appid", dVar.l());
        }
        if (!TextUtils.isEmpty(dVar.m())) {
            fVar.a("login_openid", dVar.m());
        }
        if (!TextUtils.isEmpty(dVar.E())) {
            fVar.a("uin", dVar.E());
        }
        if (aVar.f().a("flow_control", 0) == 1) {
            fVar.a("fc", "1");
        }
        if (aVar.f().a("support_https", 1) == 1) {
            fVar.a("support_https", "1");
        }
        fVar.a("ext", a(aVar, fVar, dVar).toString());
        a(fVar, dVar);
        JSONObject a4 = a(dVar);
        if (a4 != null) {
            fVar.a("outerext", a4.toString());
        }
        fVar.a("r", String.valueOf(Math.random()));
        if (!TextUtils.isEmpty(com.qq.e.comm.plugin.util.c.a(com.qq.e.comm.plugin.d0.a.d().a()))) {
            fVar.a("last_ads", com.qq.e.comm.plugin.util.c.a(aVar.a()));
        }
        JSONObject a5 = a();
        if (a5 == null) {
            return fVar.l();
        }
        String jSONObject = a5.toString();
        String b4 = com.qq.e.comm.plugin.util.d.b(jSONObject);
        fVar.a("encext", b4);
        fVar.a("encver", com.qq.e.comm.plugin.util.d.f46404c);
        d1.a("\u539f\u6587\uff1a" + jSONObject, new Object[0]);
        d1.a("\u5bc6\u6587\uff1a" + b4, new Object[0]);
        return fVar.l();
    }

    private static JSONObject b(com.qq.e.comm.plugin.d0.a aVar, com.qq.e.comm.plugin.i0.n.f fVar, d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(aVar, jSONObject, dVar);
        b(jSONObject, dVar);
        jSONObject.put("conn", aVar.c().n().a());
        String a4 = v0.a();
        if (!TextUtils.isEmpty(a4)) {
            jSONObject.put("cell_native", a4);
        }
        jSONObject.put("carrier", aVar.c().b().a());
        jSONObject.put("support_features", y1.a(dVar));
        int x3 = dVar.x();
        int b4 = b(dVar);
        if (b4 > 0) {
            jSONObject.put("support_tpl2", b4);
        }
        JSONArray C = dVar.C();
        if (b4 > 0 && !k0.a(C)) {
            jSONObject.put("tpl_ids", C);
        }
        if (x3 == g.REWARDVIDEOAD.d()) {
            com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
            jSONObject.put("support_reward_page", f4.a("supportRewardPage", dVar.w(), 0));
            jSONObject.put("support_app_landing_page", f4.a("rewardVideoSupportLandingPage", 0));
            int a5 = com.qq.e.comm.plugin.t.c.a("rewardVideoServerMaxDuration", dVar.w(), 301);
            int a6 = com.qq.e.comm.plugin.t.c.a("sksrvmd", dVar.w(), 0);
            if (a5 > 0) {
                jSONObject.put("max_duration", a5);
            }
            if (a6 > 0 && a6 < a5) {
                jSONObject.put("min_duration", a6);
            }
        } else if (x3 == g.UNIFIED_INTERSTITIAL_FULLSCREEN.d()) {
            jSONObject.put("support_app_landing_page", com.qq.e.comm.plugin.d0.a.d().f().a("interstitialFullScreenSupportLandingPage", 0));
            dVar.l(g.UNIFIED_INTERSTITIAL.d());
            x3 = dVar.x();
            a(dVar, jSONObject);
        } else {
            jSONObject.put("support_app_landing_page", 1);
            a(dVar, jSONObject);
        }
        if (b(x3)) {
            jSONObject.putOpt("fixed_duration", com.qq.e.comm.plugin.d0.a.d().f().c("fixedDurations"));
        }
        jSONObject.put("c_os", "android");
        jSONObject.put("c_osver", Build.VERSION.RELEASE);
        com.qq.e.comm.plugin.d0.e.a b5 = aVar.b();
        jSONObject.put("c_pkgname", b5.b());
        jSONObject.put("hostver", b5.d());
        jSONObject.put("c_device", aVar.c().f42280j);
        jSONObject.put("c_devicetype", f1.b(aVar.a()));
        jSONObject.put("c_mf", Build.MANUFACTURER);
        jSONObject.put("c_ori", y0.a());
        Pair<Integer, Integer> b6 = y.b();
        if (((Integer) b6.first).intValue() > ((Integer) b6.second).intValue()) {
            jSONObject.put("c_w", b6.second);
            jSONObject.put("c_h", b6.first);
        } else {
            jSONObject.put("c_w", b6.first);
            jSONObject.put("c_h", b6.second);
        }
        jSONObject.put("sdkver", e1.c());
        jSONObject.put("jsver", dVar.k());
        jSONObject.put("tmpallpt", true);
        jSONObject.put("postype", x3);
        jSONObject.put("deep_link_version", 1);
        jSONObject.put("c_sdfree", y.a());
        jSONObject.put("c_market", r0.a());
        jSONObject.put("c_hl", Locale.getDefault().getLanguage());
        if (x3 == g.UNIFIED_INTERSTITIAL.d()) {
            jSONObject.put("inline_full_screen", 1);
        } else if (x3 == g.NATIVEEXPRESSAD.d()) {
            jSONObject.put("native_jsver", "1.1.0");
        }
        try {
            String b7 = e1.b();
            if (!TextUtils.isEmpty(b7)) {
                jSONObject.put("sdk_src", b7);
            }
        } catch (Throwable th) {
            d1.a("SDKSrcConfig not exist", th);
        }
        if (dVar.g() != null) {
            JSONObject g4 = dVar.g();
            Iterator<String> keys = g4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, g4.get(next));
            }
        }
        jSONObject.put("scs", a(jSONObject, dVar));
        if (a(com.qq.e.comm.plugin.d0.a.d().f().a("antiSpamTestRate", 1000))) {
            jSONObject.put("ast", a(aVar));
        }
        if (x3 == g.NATIVEEXPRESSAD.d() && m2.a()) {
            jSONObject.put("support_video", true);
        } else if (x3 == g.UNIFIED_INTERSTITIAL.d() && m2.b()) {
            jSONObject.put("support_video", true);
        } else if (x3 == g.SPLASH.d()) {
            if (com.qq.e.comm.plugin.d0.a.d().f().a("skssv", dVar.w(), 0) == 1) {
                jSONObject.put("support_video", true);
            }
        }
        jSONObject.put("from_js", dVar.i());
        jSONObject.put("url", dVar.F());
        jSONObject.putOpt("xflow_pos_id", dVar.H());
        jSONObject.put("sdk_st", dVar.f().a());
        a(aVar.a(), dVar, jSONObject);
        jSONObject.put("sdk_cnl", e1.d());
        if (x3 == g.SPLASH.d()) {
            jSONObject.put("hwmodel", Build.DEVICE);
            jSONObject.put("hwmachine", com.qq.e.comm.plugin.d0.a.d().c().f42280j);
            jSONObject.put("brands", Build.BRAND);
            jSONObject.put("mnc", aVar.c().o());
            jSONObject.put("rtld", dVar.B());
            jSONObject.put("wl", dVar.G());
            jSONObject.put("playround", dVar.s());
            jSONObject.put("warm_boot", false);
        }
        jSONObject.put("prld", dVar.z());
        int A = dVar.A();
        if (A != 0) {
            jSONObject.put(AdLogEventRepo.COL_RETRY_COUNT, A);
        }
        String e4 = e1.e();
        if (!TextUtils.isEmpty(e4)) {
            jSONObject.put("sdk_ex1", e4);
        }
        String f5 = e1.f();
        if (!TextUtils.isEmpty(f5)) {
            jSONObject.put("sdk_ex2", f5);
        }
        jSONObject.put("wx_api_ver", com.qq.e.comm.plugin.s0.b.e());
        jSONObject.put("opensdk_ver", com.qq.e.comm.plugin.s0.b.b());
        String a7 = com.qq.e.comm.plugin.util.n.a();
        if (!TextUtils.isEmpty(a7)) {
            jSONObject.put("qq_ver", a7);
        }
        int i4 = aVar.a().getApplicationInfo().targetSdkVersion;
        jSONObject.put("target_ver", i4);
        if (Build.VERSION.SDK_INT >= 30 && i4 >= 30) {
            jSONObject.put("query_all_packages", z0.c(aVar.a()));
        }
        jSONObject.put("support_c2s", 2);
        jSONObject.put("support_component", String.format("%d,%d,%d", 1, 2, 3));
        Integer channel = GlobalSetting.getChannel();
        if (channel != null) {
            jSONObject.put("m_ch", channel.intValue());
        }
        Integer personalizedState = GlobalSetting.getPersonalizedState();
        if (personalizedState != null && personalizedState.intValue() != 0) {
            jSONObject.put("istopr", personalizedState.intValue());
            v.a(1420000, null, personalizedState);
        }
        jSONObject.put("support_app_store", 1);
        if (com.qq.e.comm.plugin.o0.b.a().a(aVar)) {
            jSONObject.put("s_hd", 1);
        }
        Integer r3 = dVar.r();
        if (r3 != null) {
            jSONObject.put("placementSub_type", r3.intValue());
        }
        jSONObject.put("appid", aVar.b().a());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("is_harmony_os", Boolean.valueOf(f0.c()));
            jSONObject2.putOpt("os_version", f0.a());
            jSONObject2.putOpt("harmony_pure_mode", Integer.valueOf(f0.b()));
            jSONObject.put("harmony_sys_info", jSONObject2);
        } catch (JSONException e5) {
            d1.a(e5.getMessage(), e5);
        }
        Integer a8 = com.qq.e.comm.plugin.e0.d.g.a(dVar.w());
        if (a8 != null) {
            jSONObject.put("egid", a8);
        }
        jSONObject.put("pms_istl_pkg", com.qq.e.comm.plugin.apkmanager.x.e.a());
        if (com.qq.e.comm.plugin.apkmanager.x.d.d()) {
            jSONObject.put("istled_pkg", 1);
        }
        jSONObject.put("ail", com.qq.e.comm.plugin.f.e.d().c());
        JSONObject c4 = com.qq.e.comm.plugin.f.b.d().c();
        if (c4 != null) {
            jSONObject.put("ail2", c4);
        }
        a(jSONObject);
        k0.a(jSONObject, b());
        return jSONObject;
    }

    private static String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME, 1, new Object[0]);
    }

    private static JSONArray d() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("bssidCount", 1);
        JSONArray jSONArray = null;
        if (a4 <= 0) {
            return null;
        }
        List<String> a5 = s2.a(com.qq.e.comm.plugin.d0.a.d().a(), a4);
        if (a5 != null && a5.size() != 0) {
            jSONArray = new JSONArray();
            for (String str : a5) {
                jSONArray.put(str);
            }
        }
        return jSONArray;
    }

    private static void a(com.qq.e.comm.plugin.i0.n.f fVar, d dVar) {
        boolean z3 = com.qq.e.comm.plugin.d0.a.d().f().a("enupdeve", dVar.w(), 1) == 1;
        Map<String, String> e4 = dVar.e();
        if (!z3 || e4 == null || e4.size() <= 0) {
            return;
        }
        try {
            fVar.a("dev_ext", new JSONObject(e4).toString());
        } catch (Exception e5) {
            d1.a("addDevExtInfo error", e5);
        }
    }

    private static JSONObject a() {
        JSONArray d4 = d();
        if (d4 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("blist", d4);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static String a(JSONObject jSONObject, d dVar) {
        String str = jSONObject.optString("sdkver") + jSONObject.optString("c_os") + jSONObject.optString("muidtype") + jSONObject.optString("muid") + jSONObject.optString("c_pkgname") + jSONObject.optInt("postype") + dVar.w();
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes(com.qq.e.comm.plugin.k.a.f44515a));
        return "0001" + Long.toHexString(crc32.getValue());
    }

    private static JSONObject a(com.qq.e.comm.plugin.d0.a aVar, com.qq.e.comm.plugin.i0.n.f fVar, d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("req", b(aVar, fVar, dVar));
        if (!TextUtils.isEmpty(dVar.j())) {
            jSONObject.put("inex", Integer.parseInt(dVar.j()));
        }
        return k0.a(jSONObject, dVar.h());
    }

    private static JSONObject a(d dVar) throws JSONException {
        if (dVar.b() == null || dVar.b().size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", new JSONArray((Collection) dVar.b()));
        return jSONObject;
    }

    private static void a(Context context, d dVar, JSONObject jSONObject) throws JSONException {
        if (dVar.f() == l.f42028e) {
            if (!TextUtils.isEmpty(dVar.p())) {
                jSONObject.put("mgpi", dVar.p());
            }
            jSONObject.put("mc_f", 1);
            int a4 = com.qq.e.comm.plugin.util.u2.e.b().a(dVar.w(), context);
            if (a4 >= 0) {
                jSONObject.put("mc_s", a4);
                return;
            }
            return;
        }
        int c4 = com.qq.e.comm.plugin.util.u2.e.b().c(dVar.w());
        if (c4 >= 0) {
            jSONObject.put("mc_f", c4);
        }
        boolean z3 = com.qq.e.comm.plugin.d0.a.d().f().a("enpamedi", dVar.w(), 1) == 1;
        Map<String, String> e4 = dVar.e();
        if (e4 == null || e4.size() <= 0) {
            return;
        }
        String remove = e4.remove("staIn");
        String remove2 = e4.remove("meSrc");
        String remove3 = e4.remove("thrmei");
        if (z3) {
            if (!TextUtils.isEmpty(remove2)) {
                try {
                    jSONObject.put("mc_f", Integer.valueOf(remove2));
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(remove3)) {
                jSONObject.put("thrmei", remove3);
            }
            int a5 = com.qq.e.comm.plugin.util.u2.e.b().a(remove);
            if (a5 > 0) {
                jSONObject.put("mc_s", a5);
            }
        }
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        com.qq.e.comm.plugin.d0.e.c c4 = com.qq.e.comm.plugin.d0.a.d().c();
        String s3 = c4.s();
        if (!TextUtils.isEmpty(s3)) {
            jSONObject.putOpt("c_webua", s3);
            return;
        }
        int l4 = c4.l();
        if (l4 <= 0) {
            l4 = 1;
        }
        if (r2.c()) {
            jSONObject.putOpt("c_release", c4.p());
            jSONObject.putOpt("c_codename", c4.d());
            jSONObject.putOpt("c_buildid", c4.a());
            jSONObject.putOpt("c_chrover", c4.c());
            jSONObject.putOpt("c_sw_size", String.valueOf(l4));
        }
    }

    private static void a(d dVar, JSONObject jSONObject) throws JSONException {
        int q3 = dVar.q();
        int o4 = dVar.o();
        if (o4 > 0 && o4 < q3) {
            GDTLogger.e("\u53c2\u6570\u8bbe\u7f6e\u9519\u8bef , minVideoDuration\u4e0d\u80fd\u5927\u4e8emaxVideoDuration");
            jSONObject.put("max_duration", com.qq.e.comm.plugin.d0.a.d().f().a("serverRequestMaxVideoDuration", 61));
            return;
        }
        if (q3 > 0) {
            jSONObject.put("min_duration", q3);
        }
        if (o4 > 0) {
            jSONObject.put("max_duration", o4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[Catch: JSONException -> 0x009f, TryCatch #3 {JSONException -> 0x009f, blocks: (B:29:0x0092, B:31:0x0098, B:32:0x009b, B:36:0x00a3, B:38:0x00a9), top: B:57:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.qq.e.comm.plugin.d0.a r10, org.json.JSONObject r11, com.qq.e.comm.plugin.b.d r12) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.b.e.a(com.qq.e.comm.plugin.d0.a, org.json.JSONObject, com.qq.e.comm.plugin.b.d):void");
    }

    private static boolean a(int i4) {
        double nextDouble = f41982a.nextDouble();
        double d4 = i4;
        Double.isNaN(d4);
        return nextDouble < d4 * 0.001d;
    }

    private static JSONObject a(com.qq.e.comm.plugin.d0.a aVar) {
        JSONObject jSONObject = new JSONObject();
        String str = i.f42007a;
        String str2 = i.f42008b;
        String str3 = i.f42009c;
        String str4 = i.f42010d;
        String str5 = i.f42011e;
        try {
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            jSONObject.put("br", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            jSONObject.put("de", str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = null;
            }
            jSONObject.put("fp", str3);
            if (TextUtils.isEmpty(str4)) {
                str4 = null;
            }
            jSONObject.put("hw", str4);
            if (TextUtils.isEmpty(str5)) {
                str5 = null;
            }
            jSONObject.put("pr", str5);
            jSONObject.put("is_d", i.a(aVar.a()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject b() throws JSONException {
        Integer num;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> extraUserData = GlobalSetting.getExtraUserData();
        if (extraUserData != null && !extraUserData.isEmpty()) {
            if (f41983b.isEmpty()) {
                try {
                    String[] split = com.qq.e.comm.plugin.d0.a.d().f().b("oudw", "*#1000").split("#");
                    for (int i4 = 0; i4 < split.length / 2; i4++) {
                        int i5 = i4 * 2;
                        f41983b.put(split[i5], Integer.valueOf(split[i5 + 1]));
                    }
                } catch (Exception unused) {
                    f41983b.put("*", 1000);
                }
            }
            for (Map.Entry<String, String> entry : extraUserData.entrySet()) {
                int length = entry.getValue().length();
                Integer num2 = f41983b.get("*");
                if ((num2 != null && length <= num2.intValue()) || ((num = f41983b.get(entry.getKey())) != null && length <= num.intValue())) {
                    jSONObject.put("outer_" + entry.getKey(), entry.getValue());
                } else if (!f41984c.contains(entry.getKey())) {
                    GDTLogger.e("GlobalSetting.extraUserData \u53c2\u6570\u4e0d\u5408\u6cd5\uff0c\u53c2\u6570\u5df2\u4e22\u5f03\uff0c\u8bf7\u68c0\u67e5\uff01");
                }
            }
        }
        return jSONObject;
    }

    public static f a(g gVar, int i4) {
        if (a.f41985a[gVar.ordinal()] != 1) {
            return null;
        }
        if (i4 >= 320) {
            return f.f41987f;
        }
        return f.f41986e;
    }

    private static int b(d dVar) {
        return dVar.I() ? 2 : -1;
    }

    private static boolean b(int i4) {
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("fixedDurationSupportPosTypes");
        if (TextUtils.isEmpty(c4)) {
            return g.NATIVEEXPRESSAD.d() == i4 || g.UNIFIED_INTERSTITIAL.d() == i4 || g.NATIVEUNIFIEDAD.d() == i4;
        }
        return Arrays.asList(c4.split(",")).contains(Integer.toString(i4));
    }

    private static void b(JSONObject jSONObject, d dVar) throws JSONException {
        int x3 = dVar.x();
        if (x3 == g.SPLASH.d()) {
            jSONObject.put("placement_type", 4);
            jSONObject.put("render_type", 1);
        } else if (x3 == g.NATIVEEXPRESSAD.d()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 3);
        }
        if (x3 == g.REWARDVIDEOAD.d()) {
            jSONObject.put("placement_type", 10);
            jSONObject.put("render_type", 1);
        } else if (x3 == g.NATIVEUNIFIEDAD.d()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 1);
            jSONObject.put("support_container", true);
        } else if (x3 == g.UNIFIED_BANNER.d()) {
            jSONObject.put("placement_type", 1);
            jSONObject.put("render_type", 3);
        } else if (x3 == g.UNIFIED_INTERSTITIAL.d() || x3 == g.UNIFIED_INTERSTITIAL_FULLSCREEN.d()) {
            jSONObject.put("placement_type", 2);
            jSONObject.put("render_type", 3);
        }
    }
}
